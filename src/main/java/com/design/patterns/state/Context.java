package com.design.patterns.state;

public class Context {

    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String stateMessage() {
        return state.getState();
    }
}