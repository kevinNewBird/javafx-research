package org.vastdata.demo4.f1;

import javafx.fxml.JavaFXBuilderFactory;
import javafx.util.Builder;
import javafx.util.BuilderFactory;
import org.vastdata.demo4.Person;

/**
 * description：TODO
 *
 * @author zhaosong
 * @version 1.0
 * @company 北京海量数据有限公司
 * @date 2024/8/14 21:36
 */
public class PersonBuilderFactory implements BuilderFactory {

    private final JavaFXBuilderFactory jff = new JavaFXBuilderFactory();

    @Override
    public Builder<?> getBuilder(Class<?> type) {
        if (type == Person.class) {
            return new PersonBuilder();
        } else {
            return jff.getBuilder(type);
        }
    }
}
