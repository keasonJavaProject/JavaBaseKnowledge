package com.design.patterns.adapter.classAdapter;

class Adapter extends Adaptee implements Target{
    public void request() {
		super.specificRequest();
	}
}