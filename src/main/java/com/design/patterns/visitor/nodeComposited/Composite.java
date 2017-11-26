package com.design.patterns.visitor.nodeComposited;

import com.design.patterns.visitor.Equipment;
import com.design.patterns.visitor.Visitor;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PicaHelth on 2017/11/12.
 * 复合节点
 */
public class Composite extends Equipment{
    private List<Equipment> parts;

    public Composite() {
        parts  = new ArrayList<>(10);
    }

    @Override
    public void accept(Visitor visitor) {
        for (Equipment v:parts) {
            v.accept(visitor);
        }
    }

    @Override
    public double price() {
        double total=0;
        for (Equipment e: parts) {
            total += e.price();

        }
        return total;
    }

    public void add(Equipment equipment) {
        parts.add(equipment);
    }
}
