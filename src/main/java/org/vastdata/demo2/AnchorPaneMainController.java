package org.vastdata.demo2;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * description: org.vastdata.demo2
 * company: 北京海量数据有限公司
 * create by: zhaosong 2024/8/14
 * version: 1.0
 */
public class AnchorPaneMainController extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // 1.纯java代码实现
        javaImpl(stage);

        // 2.使用fxml实现
//        fxmlImpl(stage);
    }

    private void javaImpl(Stage stage) {
        AnchorPane an = new AnchorPane();
        Button button = new Button();
        button.setPrefHeight(100);
        button.setPrefWidth(100);

        button.setId("b1");
        button.setText("Button");

        Button button2 = new Button();
        button2.setPrefHeight(100);
        button2.setPrefWidth(100);

        button2.setId("b2");
        button2.setText("Button2");
        an.getChildren().add(button);
        an.getChildren().add(button2);

        AnchorPane.setTopAnchor(button, 100.0);
        AnchorPane.setLeftAnchor(button, 100.0);
        AnchorPane.setTopAnchor(button2, 100.0);
        AnchorPane.setLeftAnchor(button2, 300.0);

        // 通过lookup搜索（指定id字段）
        Button b1 = (Button) an.lookup("#b1");
        System.out.println(b1.getText());

        // 位置布局
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(new Label("top"));
//        borderPane.setCenter(new Label("center"));
        borderPane.setBottom(new Label("bottom"));
        borderPane.setLeft(new Label("left"));
        borderPane.setRight(new Label("right"));
        // 创建可见视图数据列表
        ObservableList<String> observableList = FXCollections.observableArrayList();
        observableList.add("ssss");
        ListView<String> listView = new ListView<>();
        listView.setItems(observableList);
        borderPane.setCenter(listView);

        Scene scene = new Scene(an);
        stage.setScene(scene);
        stage.setHeight(1000);
        stage.setWidth(1000);
        stage.show();

        // 切换页面
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                AnchorPane an = new AnchorPane();
                Button button = new Button();
                button.setPrefHeight(100);
                button.setPrefWidth(100);
                button.setText("OTHER");
                an.getChildren().add(button);
                scene.setRoot(an);
            }
        });
    }


    private void fxmlImpl(Stage stage) throws IOException {
        FXMLLoader fx = new FXMLLoader();
//        AnchorPane root = (AnchorPane) fx.load(AnchorPaneMainController.class.getClassLoader()
//                .getResourceAsStream("demo2/anchorpane.fxml"));
        fx.setLocation(fx.getClassLoader().getResource("demo2/anchorpane.fxml"));
        AnchorPane root = fx.<AnchorPane>load();

        // 通过id搜索按钮等
        Button b1 = (Button) root.lookup("#fxmlbutton");
        System.out.println(b1.getText());
        b1.setOnAction(event -> {
            System.out.println("click....");
        });


        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setHeight(1000);
        stage.setWidth(1000);
        stage.show();
    }
}
