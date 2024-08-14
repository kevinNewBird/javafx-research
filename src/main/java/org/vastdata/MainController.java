package org.vastdata;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * description: org.vastdata
 * company: 北京海量数据有限公司
 * create by: zhaosong 2024/8/14
 * version: 1.0
 */
public class MainController implements Initializable {

    @FXML
    private Button nextButton;


    @FXML
    private void handleNextAction(ActionEvent event) throws IOException {
        System.out.println("1111");
        Parent subPage = FXMLLoader.load(MainController.class.getClassLoader().getResource("sub.fxml"));
        Scene subScene = new Scene(subPage);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(subScene);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
