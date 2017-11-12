package com.design.patterns.visitor.nodeComposited;

import com.design.patterns.visitor.Equipment;
import com.design.patterns.visitor.Visitor;
import com.design.patterns.visitor.node.Case;
import com.design.patterns.visitor.node.HardDisk;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PicaHelth on 2017/11/12.
 * 复合节点
 */
public class Pc extends IntegratedBoard {
    public Pc() {
        super.add(new IntegratedBoard());
        super.add(new HardDisk());
        super.add(new Case());
    }

    public void accept(Visitor visitor) {
        System.out.println("Pc has been visited.");
        super.accept(visitor);
    }


}

