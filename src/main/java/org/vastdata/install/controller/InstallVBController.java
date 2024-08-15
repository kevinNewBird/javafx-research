package org.vastdata.install.controller;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.vastdata.install.domain.DatabaseCfg;

import java.text.MessageFormat;
import java.util.concurrent.TimeUnit;

/**
 * description: org.vastdata.install.controller
 * company: 北京海量数据有限公司
 * create by: zhaosong 2024/8/15
 * version: 1.0
 */
public class InstallVBController {

    private Stage primaryStage;

    @FXML
    private Label label4;

    private DatabaseCfg databaseCfg;


    @FXML
    private void initialize() throws InterruptedException {
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try {
                    label4.setText("Installing....");
                    System.out.println(MessageFormat.format("数据库端口号：{0}, 实例用户名：{1}"
                            , databaseCfg.getListenPort(), databaseCfg.getUsername()));
                    // 分发安装包（可直接内置在镜像里）
                    // 执行安装
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };
        task.setOnSucceeded(workerStateEvent -> {
            label4.setText("Success!");
        });

        new Thread(task).start();
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Label getLabel3() {
        return label4;
    }

    public void setDatabaseCfg(DatabaseCfg databaseCfg) {
        this.databaseCfg = databaseCfg;
    }
}
