package com.design.patterns.visitor;

import com.design.patterns.visitor.node.Case;
import com.design.patterns.visitor.node.Cpu;
import com.design.patterns.visitor.node.HardDisk;
import com.design.patterns.visitor.node.MainBoard;
import com.design.patterns.visitor.nodeComposited.IntegratedBoard;
import com.design.patterns.visitor.nodeComposited.Pc;

/**
 * Created by PicaHelth on 2017/11/12.
 */
public abstract class Visitor {
    public abstract void visitHardDisk(HardDisk e);
    public abstract void visitMainBoard(MainBoard e);
    public abstract void visitCpu(Cpu e);
    public abstract void visitPc(Pc e);
    public abstract void visitCase(Case e);
    public abstract void visitIntegrateBoard(IntegratedBoard e);
}
