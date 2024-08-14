package org.vastdata.demo4.f2;

import javafx.fxml.JavaFXBuilderFactory;
import javafx.util.Builder;
import javafx.util.BuilderFactory;
import org.vastdata.demo4.Person;
import org.vastdata.demo4.f1.PersonBuilder;

/**
 * description：上一种方式的变种
 *
 * @author zhaosong
 * @version 1.0
 * @company 北京海量数据有限公司
 * @date 2024/8/14 21:36
 */
public class PersonMapBuilderFactory implements BuilderFactory {

    private final JavaFXBuilderFactory jff = new JavaFXBuilderFactory();

    @Override
    public Builder<?> getBuilder(Class<?> type) {
        if (type == Person.class) {
            return new PersonMapBuilder();
        } else {
            return jff.getBuilder(type);
        }
    }
}
