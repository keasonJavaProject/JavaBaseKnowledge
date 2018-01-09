package com.gy.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {

    //不起别名，就是叫addressId ,起别名则为addressIdAlias
    @XmlElement(name = "addressIdAlias")
    private Long addressId;

    @XmlElement
    private String addressName;

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public Long getAddressId() {

        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }
}
