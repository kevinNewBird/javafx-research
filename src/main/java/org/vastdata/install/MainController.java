package org.vastdata.install;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.vastdata.install.controller.GuideController;

import java.net.URL;

/**
 * description: org.vastdata.install
 * company: 北京海量数据有限公司
 * create by: zhaosong 2024/8/15
 * version: 1.0
 */
public class MainController extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fx = new FXMLLoader();
        URL resource = fx.getClassLoader().getResource("install/guide.fxml");
        fx.setLocation(resource);
        AnchorPane root = fx.load();

        GuideController guideCtl = (GuideController) fx.getController();
        guideCtl.setPrimaryStage(stage);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setHeight(800);
        stage.setWidth(800);
        stage.setTitle("Vastbase Installation Guide Tool");
        stage.show();
    }
}
