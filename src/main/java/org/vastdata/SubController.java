package org.vastdata;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * description: org.vastdata
 * company: 北京海量数据有限公司
 * create by: zhaosong 2024/8/14
 * version: 1.0
 */
public class SubController {

    @FXML
    private Button nextButton;


    @FXML
    private void handleNextAction() {
        System.out.println("sub");
    }
}
