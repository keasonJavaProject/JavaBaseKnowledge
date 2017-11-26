package com.design.patterns.visitor.nodeComposited;

import com.design.patterns.visitor.Visitor;
import com.design.patterns.visitor.node.Cpu;
import com.design.patterns.visitor.node.MainBoard;

/**
 * Created by PicaHelth on 2017/11/12.
 */
public class IntegratedBoard extends Composite {
    public IntegratedBoard() {
        super.add(new MainBoard());
        super.add(new Cpu());
    }

    public void accept(Visitor visitor) {
        System.out.println("IntegratedBoard has been visited.");
        super.accept(visitor);

    }
}
