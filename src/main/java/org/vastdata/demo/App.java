package org.vastdata.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Hello world!
 */
public class App extends Application {

    private Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        try {
            Parent root = FXMLLoader.load(App.class.getClassLoader().getResource("main.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void demo(Stage primaryStage) {
        this.stage = primaryStage;
        Button button = new Button("Next Step");
        button.setOnAction(event -> {
            showNextPage();
        });


        // 1.部署virtualbox,加载镜像,配置网络，启动镜像

        // 2.分发数据库安装包并解压（可直接内置）

        // 3.执行vastbase-installer并启动数据库

        StackPane root = new StackPane(button);
        Scene scene = new Scene(root, 400, 400);
        stage.setScene(scene);
        stage.show();
    }

    private void showNextPage() {
        Button back = new Button("Back");
        back.setOnAction(event -> {
            stage.setScene(stage.getScene());
        });
        StackPane root = new StackPane(back);
        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
    }
}
