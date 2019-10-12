package com.test.jaxb;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestMain {
    public static void main(String[] args) throws JAXBException {
        Order order =  new Order();
        order.setOrderId(1001L);
        order.setOrderTime(new Date());
        order.setTitle("测试订单");
        order.setAttr("name");

        Address address = new Address();
        address.setAddressId(1002L);
        address.setAddressName("address1002L");
        order.setAddress(address);

        List<Item> itemList = new ArrayList<Item>();
        Item item= new Item();
        item.setItemId(3001L);
        item.setItemName("item3001L");
        item.setPrice(3001L);
        itemList.add(item);

        item= new Item();
        item.setItemId(3002L);
        item.setItemName("item3002L");
        item.setPrice(3002L);
        itemList.add(item);

        order.setItems(itemList);

        String xmlStr  = JAXBUtils.marshal(order);
        System.out.println(xmlStr);


        /**
         * 反序列化，通过对象字段名 或者 别名（@XmlElement(name = "addressIdAlias")），去匹配String xml 中的属性名
         * 匹配不上就，当前值就为 null
         */
        Order orderUn  = JAXBUtils.unmarshal(xmlStr, Order.class);



    }
}
