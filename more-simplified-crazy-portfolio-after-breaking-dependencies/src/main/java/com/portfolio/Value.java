package com.portfolio;

public abstract class Value {

    protected final int value;

    protected Value(int value) {
        this.value = value;
    }

    public int get(){
        return value;
    }
}
