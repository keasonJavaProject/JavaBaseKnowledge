package com.design.patterns.visitor.node;

import com.design.patterns.visitor.Equipment;
import com.design.patterns.visitor.Visitor;

/**
 * Created by PicaHelth on 2017/11/12.
 */
public class MainBoard extends Equipment {

    @Override
    public void accept(Visitor visitor) {
        System.out.println("MainBoard has been visited.");
        visitor.visitMainBoard(this);
    }

    @Override
    public double price() {
        return 100.00;
    }
}
