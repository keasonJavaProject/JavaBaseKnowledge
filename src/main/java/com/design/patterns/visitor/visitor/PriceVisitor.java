package com.design.patterns.visitor.visitor;

import com.design.patterns.visitor.Visitor;
import com.design.patterns.visitor.node.Case;
import com.design.patterns.visitor.node.Cpu;
import com.design.patterns.visitor.node.HardDisk;
import com.design.patterns.visitor.node.MainBoard;
import com.design.patterns.visitor.nodeComposited.IntegratedBoard;
import com.design.patterns.visitor.nodeComposited.Pc;

/**
 * Created by PicaHelth on 2017/11/12.
 */
public class PriceVisitor extends Visitor {
    private float total;

    public PriceVisitor() {
        total = 0;
    }

    public float value() {
        return total;
    }

    @Override
    public void visitHardDisk(HardDisk e) {
        total += e.price();
    }

    @Override
    public void visitMainBoard(MainBoard e) {
        total += e.price();

    }

    @Override
    public void visitCpu(Cpu e) {
        total += e.price();

    }

    @Override
    public void visitPc(Pc e) {
        total += e.price();

    }

    @Override
    public void visitCase(Case e) {
        total += e.price();

    }

    @Override
    public void visitIntegrateBoard(IntegratedBoard e) {
        total += e.price();

    }


}
