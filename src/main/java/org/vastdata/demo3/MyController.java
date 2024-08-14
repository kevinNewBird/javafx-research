package org.vastdata.demo3;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * description: fxml的控制器，对应anchorpane2.fxml
 * company: 北京海量数据有限公司
 * create by: zhaosong 2024/8/14
 * version: 1.0
 */
public class MyController {

    @FXML
    private Button fxmlbutton;// 属性名必须和配置文件里的相同

    @FXML
    private Button otherbutton;

    @FXML
    private Button otherbutton2;

    @FXML
    private Label fxmllabel; // 属性名必须和配置文件里的相同

    @FXML
    private ListView<String> listview;

    @FXML
    private void initialize() {
        System.out.println("initialize....");
        // 赋值在前，方法调用在后
        System.out.println(fxmllabel.getText());

        ObservableList<String> observableList = FXCollections.observableArrayList();
        observableList.add("121");
        observableList.add("221");
        listview.setItems(observableList);
        // 实现下拉列表
        listview.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                // 第一次点击oldValue为null
                // 以后的每一次点击为上一次的值
                System.out.println(oldValue + "==" + newValue);
            }
        });
    }


    @FXML
    private void handle() {
        System.out.println("handle");
    }

    @FXML
    private void other2_action() throws IOException {
        FXMLLoader fx2 = new FXMLLoader();
//        AnchorPane root = (AnchorPane) fx.load(AnchorPaneMainController.class.getClassLoader()
//                .getResourceAsStream("demo2/anchorpane.fxml"));
        fx2.setLocation(fx2.getClassLoader().getResource("demo3/other.fxml"));// 这里先加载，意味者fxml中配置文件定义的控制器已经被加载
        AnchorPane other = fx2.<AnchorPane>load();

        // 新开窗口展示（类似弹窗）
        Scene scene = new Scene(other);
        Stage stage = new Stage();
        stage.setWidth(400);
        stage.setHeight(400);
        stage.setScene(scene);
        stage.show();
    }

    public Button getFxmlbutton() {
        return fxmlbutton;
    }

    public Label getFxmllabel() {
        return fxmllabel;
    }

    public ListView<String> getListview() {
        return listview;
    }

    public Button getOtherbutton() {
        return otherbutton;
    }
}
