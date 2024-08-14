package org.vastdata.demo5;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * description：输入框等简单控件
 *
 * @author zhaosong
 * @version 1.0
 * @company 北京海量数据有限公司
 * @date 2024/8/14 22:44
 */
public class BaseController extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("javafx");
        stage.setWidth(800);
        stage.setHeight(800);
        stage.show();

        // 1.输入框
        testTextField(root);

        // 2.密码框
        testPasswordField(root);

        // 3.标签
        testLabel(root);
    }


    private void testTextField(Group root){
        // 1.输入框
        TextField text = new TextField();
//        text.setText("这是文本");

        text.setLayoutX(100);
        text.setLayoutY(100);
        text.setPrefWidth(100);
        text.setPrefHeight(100);

        text.setFont(Font.font(14));

        Tooltip tip = new Tooltip("这是提示");
        tip.setFont(Font.font(40));
        text.setTooltip(tip);
        text.setPromptText("请输入7个字以下"); // 文本框内提示
        text.setFocusTraversable(false);

        // 文本框的所有内容的监听
        text.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                if (newValue.length() > 7) {
                    text.setText(oldValue);
                }
            }
        });

        // 输入框中选择的内容监听
        text.selectedTextProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                System.out.println(newValue);
            }
        });
        root.getChildren().add(text);

        text.setOnAction(event -> {
            // 回车后赋值
            System.out.println(text.getText());
        });
    }

    private void testPasswordField(Group root){
        // 2.密码框
        PasswordField pText = new PasswordField();

        pText.setLayoutX(300);
        pText.setLayoutY(100);
//        pText.setVisible(true); // 是否显示密码框

        root.getChildren().add(pText);
    }

    private void testLabel(Group root){
        Label label = new Label("我是标签");
        label.setLayoutX(50);
        label.setLayoutY(100);
        label.setFont(Font.font(14));

        label.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("sssssss");
            }
        });

        label.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // 判断是鼠标左键还是右键
                System.out.println(mouseEvent.getButton().name().equals(MouseButton.PRIMARY.name()));
                System.out.println(mouseEvent.getClickCount());
            }
        });

        root.getChildren().add(label);
    }

}
