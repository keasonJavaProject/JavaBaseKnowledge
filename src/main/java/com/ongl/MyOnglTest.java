package com.ongl;


import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

import java.util.HashMap;

/**
 * Created by keason on 2018/1/13.
 *  http://commons.apache.org/proper/commons-ognl/language-guide.html
 */
public class MyOnglTest {
    public static void main(String[] args) throws OgnlException {
        // 新建一个部门对象并设置部门名称
        SlDept dept = new SlDept();
        dept.setName("销售部");

        // 新建一个员工对象并设置员工姓名
        SlEmployee emp = new SlEmployee();
        emp.setName("张三");
        emp.setSlDept(dept);
        emp.setId(123);

        // 构建一个OgnlContext对象
        OgnlContext context  = new OgnlContext();

        // 将上述部门和员工对象放入Ognl上下文环境中
        context.put("dept", dept);
        context.put("emp", emp);



        // 构建Ognl表达式的树状表示,用来获取
        Object expression = Ognl.parseExpression("#dept.name");
        // 解析树状表达式，返回结果
        Object name = Ognl.getValue(expression, context, context.getRoot());
        System.out.println(name);


        System.out.println("默认在根下找 不用带#, 此时如果根元素没设置，Ognl.getValue(expression, context, context.getRoot());会报异常");
        context.setRoot(emp);
        expression = Ognl.parseExpression("name");
        name = Ognl.getValue(expression, context, context.getRoot());
        System.out.println(name);
        System.out.println();

        System.out.println("直接从根节点取值，不用带#");
        context.setRoot(dept);
        expression = Ognl.parseExpression("name");
        name = Ognl.getValue(expression, context, context.getRoot());
        System.out.println(name);
        System.out.println();

        System.out.println("调用静态方法:@java.lang.Integer@valueOf('111')");
        expression = Ognl.parseExpression("@java.lang.Integer@valueOf('111')");
        name = Ognl.getValue(expression, context, context.getRoot());
        System.out.println(name);
        System.out.println();


        System.out.println("两个函数，指向同一个字段");
        expression = Ognl.parseExpression("#emp.getPackName()");
        name = Ognl.getValue(expression, context, context.getRoot());
        System.out.println("#emp.getPackName()："+name);
        expression = Ognl.parseExpression("#emp.getName()");
        name = Ognl.getValue(expression, context, context.getRoot());
        System.out.println("#emp.getName()"+name);
        System.out.println();


        System.out.println("挨个计算，值为最后一个");
        expression = Ognl.parseExpression("1,2,3");
        Object value = Ognl.getValue(expression,context,context.getRoot());
        System.out.println("#emp.name =='张三':"+value);
        System.out.println();


        System.out.println("赋值之后，重新取出来");
        expression = Ognl.parseExpression("#emp.name='张三L'");
        value = Ognl.getValue(expression,context,context.getRoot());
        expression = Ognl.parseExpression("#emp.name");
        System.out.println("#emp.name =='张三':"+value);
        System.out.println();


        System.out.println("string instanceof java.lang.String");
        expression = Ognl.parseExpression("'111' instanceof java.lang.String");
        value = Ognl.getValue(expression,context,context.getRoot());
        System.out.println("'1.01' instanceof java.lang.String: "+value);

        expression = Ognl.parseExpression("1.01 instanceof java.lang.String");
        value = Ognl.getValue(expression,context,context.getRoot());
        System.out.println("1.01 instanceof java.lang.String: "+value);
        System.out.println();








    }
}
