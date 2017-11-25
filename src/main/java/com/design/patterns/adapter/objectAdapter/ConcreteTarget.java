package com.design.patterns.adapter.objectAdapter;

class ConcreteTarget implements Target{
    public void request() {
		System.out.println("普通类 具有 普通功能...");
	}
}