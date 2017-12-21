package com.design.patterns.strategy;

public class Context {
     private Strategy strategy;  
     //构造函数，要你使用哪个妙计  
     public Context(Strategy strategy){  
          this.strategy = strategy;  
     }

     public void operate(){  
          this.strategy.operate();  
     }  
}  