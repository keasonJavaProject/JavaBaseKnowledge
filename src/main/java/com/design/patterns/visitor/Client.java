package com.design.patterns.visitor;

import com.design.patterns.visitor.nodeComposited.Pc;
import com.design.patterns.visitor.visitor.InventoryVisitor;
import com.design.patterns.visitor.visitor.PriceVisitor;

/**
 * Created by PicaHelth on 2017/11/12.
 */
public class Client {
    private static PriceVisitor priceVisitor;
    private static InventoryVisitor inventoryVisitor;
    private static Equipment equipment;

    public static void main(String[] args) {
        equipment = new Pc();
        priceVisitor = new PriceVisitor();
        equipment.accept(priceVisitor);
        System.out.println("price:" + priceVisitor.value());
        System.out.println();

        inventoryVisitor = new InventoryVisitor();
        equipment.accept(inventoryVisitor);
        System.out.println("number of parts:"+inventoryVisitor.size());
    }
}
