package org.vastdata.demo3;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * description: org.vastdata.demo2
 * company: 北京海量数据有限公司
 * create by: zhaosong 2024/8/14
 * version: 1.0
 */
public class AnchorPaneMainController2 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // 1.使用fxml实现
        fxmlImpl(stage);
    }


    private void fxmlImpl(Stage stage) throws IOException {
        FXMLLoader fx = new FXMLLoader();
//        AnchorPane root = (AnchorPane) fx.load(AnchorPaneMainController.class.getClassLoader()
//                .getResourceAsStream("demo2/anchorpane.fxml"));
        fx.setLocation(fx.getClassLoader().getResource("demo3/anchorpane2.fxml"));// 这里先加载，意味者fxml中配置文件定义的控制器已经被加载
        AnchorPane root = fx.<AnchorPane>load();

        // 通过id搜索按钮等(如果这里和MyController同时定义了，那么此处的生效，即被覆盖)
//        Button b1 = (Button) root.lookup("#fxmlbutton");
//        System.out.println(b1.getText());
//        b1.setOnAction(event -> {
//            System.out.println("click2....");
//        });

        // 获取fxml中定义的控制器(同样的道理：如果这里和MyController同时定义了，那么此处的生效，即被覆盖)
        MyController mc = fx.getController();
        mc.getFxmlbutton().setOnAction(event -> {
            System.out.println(mc.getFxmllabel().getText());
        });

        // 列表数据添加到布局视图中，将覆盖配置文件中的数据
//        ListView listview = mc.getListview();
//        ObservableList<Object> observableList = FXCollections.observableArrayList();
//        observableList.add("121");
//        listview.setItems(observableList);



        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setHeight(1000);
        stage.setWidth(1000);
        stage.show();

        // 切换页面,也就是改变root(或者通过MyController去实现)
        mc.getOtherbutton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    FXMLLoader fx2 = new FXMLLoader();
//        AnchorPane root = (AnchorPane) fx.load(AnchorPaneMainController.class.getClassLoader()
//                .getResourceAsStream("demo2/anchorpane.fxml"));
                    fx2.setLocation(fx2.getClassLoader().getResource("demo3/other.fxml"));// 这里先加载，意味者fxml中配置文件定义的控制器已经被加载
                    AnchorPane other = fx2.<AnchorPane>load();
                    scene.setRoot(other);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
