package org.vastdata.demo4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import org.vastdata.demo4.f1.PersonBuilderFactory;
import org.vastdata.demo4.f2.PersonMapBuilderFactory;

import java.io.IOException;

/**
 * description：加载带有参数的构造器的实例类
 *
 * @author zhaosong
 * @version 1.0
 * @company 北京海量数据有限公司
 * @date 2024/8/14 21:28
 */
public class PersonController extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // 方式1
//        f1();

        // 方式2
        f2();


        stage.setHeight(1000);
        stage.setWidth(1000);
        stage.show();
    }

    private void f1() throws IOException {
        FXMLLoader fx = new FXMLLoader();
        fx.setBuilderFactory(new PersonBuilderFactory());
        fx.setLocation(fx.getClassLoader().getResource("demo4/data.fxml"));// 这里先加载，意味者fxml中配置文件定义的控制器已经被加载
        Person person = fx.<Person>load();  //默认只识别无参构造，如需处理需实现Builder接口
        System.out.println(person.getName());
    }

    private void f2() throws IOException {
        FXMLLoader fx = new FXMLLoader();
        fx.setBuilderFactory(new PersonMapBuilderFactory());
        fx.setLocation(fx.getClassLoader().getResource("demo4/data.fxml"));// 这里先加载，意味者fxml中配置文件定义的控制器已经被加载
        Person person = fx.<Person>load();  //默认只识别无参构造，如需处理需实现Builder接口
        System.out.println(person.getName());
    }
}
