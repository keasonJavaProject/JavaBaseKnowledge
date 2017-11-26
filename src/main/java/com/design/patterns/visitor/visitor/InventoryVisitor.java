package com.design.patterns.visitor.visitor;

import com.design.patterns.visitor.Visitor;
import com.design.patterns.visitor.node.Case;
import com.design.patterns.visitor.node.Cpu;
import com.design.patterns.visitor.node.HardDisk;
import com.design.patterns.visitor.node.MainBoard;
import com.design.patterns.visitor.nodeComposited.IntegratedBoard;
import com.design.patterns.visitor.nodeComposited.Pc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PicaHelth on 2017/11/12.
 */
public class InventoryVisitor extends Visitor {
    private List list;

    public InventoryVisitor() {
        list = new ArrayList();
    }

    public int size() {
        return list.size();
    }


    @Override
    public void visitHardDisk(HardDisk e) {
        list.add(e);
    }

    @Override
    public void visitMainBoard(MainBoard e) {
        list.add(e);
    }

    @Override
    public void visitCpu(Cpu e) {
        list.add(e);

    }

    @Override
    public void visitPc(Pc e) {
        list.add(e);

    }

    @Override
    public void visitCase(Case e) {
        list.add(e);

    }

    @Override
    public void visitIntegrateBoard(IntegratedBoard e) {
        list.add(e);

    }


}
