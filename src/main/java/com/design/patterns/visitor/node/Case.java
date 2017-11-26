package com.design.patterns.visitor.node;

import com.design.patterns.visitor.Equipment;
import com.design.patterns.visitor.Visitor;

/**
 * Created by PicaHelth on 2017/11/12.
 */
public class Case extends Equipment {

    @Override
    public void accept(Visitor visitor) {
        System.out.println("Case has been visited.");
        visitor.visitCase(this);
    }

    @Override
    public double price() {
        return 800.00;
    }
}
