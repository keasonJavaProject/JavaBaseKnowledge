package com.reflect;

import com.reflect.beanProperty.DataModel;
import junit.framework.TestCase;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by keason on 2018/3/11.
 */
public class ReflectUtilTest extends TestCase {
    public void testCompareTwoClass() throws Exception {
        DataModel student = new DataModel();
        student.setName("name");
        student.setId(1);
        student.setDate(new Date());

        DataModel student2 = new DataModel();
        student2.setName("name");
        student2.setId(2);
        student2.setDate(new Date("2017/02/04"));

        List<Map<String ,Object>> maps = ReflectUtil.compareTwoClass(student, student2);
    }

}