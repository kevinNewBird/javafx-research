package org.vastdata.demo4.f1;

import javafx.util.Builder;
import org.vastdata.demo4.Person;

/**
 * description：TODO
 *
 * @author zhaosong
 * @version 1.0
 * @company 北京海量数据有限公司
 * @date 2024/8/14 21:34
 */
public class PersonBuilder implements Builder<Person> {

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public Person build() {
        return new Person(this.name);
    }
}
