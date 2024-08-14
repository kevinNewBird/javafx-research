package org.vastdata.demo4.f2;

import javafx.util.Builder;
import org.vastdata.demo4.Person;

import java.util.HashMap;

/**
 * description：和上一种方式是一样的
 *
 * @author zhaosong
 * @version 1.0
 * @company 北京海量数据有限公司
 * @date 2024/8/14 21:34
 */
public class PersonMapBuilder extends HashMap<String,Object> implements Builder<Person> {

    private String name;

    @Override
    public Object put(String key, Object value) {
        if ("name".equals(key)) {
            this.name = String.valueOf(value);
        }
        return null;
    }

    @Override
    public Person build() {
        return new Person(this.name);
    }
}
