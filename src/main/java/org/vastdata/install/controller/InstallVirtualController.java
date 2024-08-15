package org.vastdata.install.controller;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * description: org.vastdata.install.controller
 * company: 北京海量数据有限公司
 * create by: zhaosong 2024/8/15
 * version: 1.0
 */
public class InstallVirtualController {

    private Stage primaryStage;

    @FXML
    private Button button2;

    @FXML
    private Label label2;


    @FXML
    private void initialize() {
        // 执行任务中，禁用下一步按钮
        button2.setDisable(true);

        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try {
                    label2.setText("Installing....");
                    // 部署虚拟机
                    // 加载镜像
                    // 配置网络
                    TimeUnit.SECONDS.sleep(3);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };
        task.setOnSucceeded(workerStateEvent -> {
            label2.setText("Success!");
            button2.setDisable(false);
        });
        task.setOnFailed(workerStateEvent -> {
            label2.setText("Failed!");
            button2.setDisable(false);
        });
        new Thread(task).start();
    }


    @FXML
    private void goToNextStep() throws IOException, InterruptedException {
        FXMLLoader fx = new FXMLLoader();
        URL resource = fx.getClassLoader().getResource("install/config_db.fxml");
        fx.setLocation(resource);
        AnchorPane virtual = fx.load();

        ConfigController vbCtl = (ConfigController) fx.getController();
        vbCtl.setPrimaryStage(primaryStage);

        Scene scene = new Scene(virtual);
        // 切换页面
        primaryStage.setScene(scene);

    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
