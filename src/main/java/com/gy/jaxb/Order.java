package com.gy.jaxb;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "Order")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
       "orderId","orderTime","items","address", "title","attr"
})
public class Order {
    @XmlElement
    private Long orderId;

    @XmlAttribute(name = "nameAttr")
    private String attr;


    @XmlElement
    private String title;

    @XmlElement
    private Date orderTime;

    @XmlElement
    private List<Item> items;


    @XmlElement(name = "addressRef")
    private Address address;

    public Order() {
    }


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }
}
