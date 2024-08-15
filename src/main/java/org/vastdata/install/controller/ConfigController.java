package org.vastdata.install.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.vastdata.install.domain.DatabaseCfg;

import java.io.IOException;
import java.net.URL;

/**
 * description: org.vastdata.install.controller
 * company: 北京海量数据有限公司
 * create by: zhaosong 2024/8/15
 * version: 1.0
 */
public class ConfigController {

    private Stage primaryStage;

    @FXML
    private Button button3;

    @FXML
    private Label l1;

    @FXML
    private Label l2;

    @FXML
    private TextField t1; // 端口号

    @FXML
    private TextField t2; // 用户名


    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    private DatabaseCfg databaseCfg;

    @FXML
    public void initialize() {
        databaseCfg = new DatabaseCfg();
        databaseCfg.setListenPort(Integer.parseInt(t1.getText()));
        databaseCfg.setUsername(t2.getText());
        // 监听当值发生变化时，更新结果
        t1.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                databaseCfg.setListenPort(Integer.parseInt(newValue));
            }
        });

        t2.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                System.out.println(oldValue + newValue);
                databaseCfg.setUsername(newValue);
            }
        });
    }

    @FXML
    private void goToNextStep() throws IOException {
        FXMLLoader fx = new FXMLLoader();
        URL resource = fx.getClassLoader().getResource("install/install_vb.fxml");
        fx.setLocation(resource);
        AnchorPane virtual = fx.load();

        InstallVBController vbCtl = (InstallVBController) fx.getController();
        vbCtl.setPrimaryStage(primaryStage);
        vbCtl.setDatabaseCfg(databaseCfg);

        Scene scene = new Scene(virtual);
        // 切换页面
        primaryStage.setScene(scene);
    }
}
