package org.vastdata.demo3;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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
    private Label fxmllabel; // 属性名必须和配置文件里的相同

    @FXML
    private void initialize() {
        System.out.println("initialize....");
        // 赋值在前，方法调用在后
        System.out.println(fxmllabel.getText());
    }


    @FXML
    private void handle() {
        System.out.println("handle");
    }

    public Button getFxmlbutton() {
        return fxmlbutton;
    }

    public Label getFxmllabel() {
        return fxmllabel;
    }
}
