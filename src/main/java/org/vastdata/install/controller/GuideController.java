package org.vastdata.install.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;


/**
 * description: org.vastdata.install
 * company: 北京海量数据有限公司
 * create by: zhaosong 2024/8/15
 * version: 1.0
 */
public class GuideController {

    private Stage primaryStage;

    @FXML
    private Button button1;

    @FXML
    private Label label1;


    @FXML
    private void goToNextStep() throws IOException {
        FXMLLoader fx = new FXMLLoader();
        URL resource = fx.getClassLoader().getResource("install/install_virtual.fxml");
        fx.setLocation(resource);
        AnchorPane virtual = fx.load();

        InstallVirtualController virtualCtl = (InstallVirtualController) fx.getController();
        virtualCtl.setPrimaryStage(primaryStage);

        Scene scene = new Scene(virtual);
        // 切换页面
        primaryStage.setScene(scene);
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Button getButton1() {
        return button1;
    }

    public Label getLabel1() {
        return label1;
    }


}
