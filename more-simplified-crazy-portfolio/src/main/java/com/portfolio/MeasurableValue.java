package com.portfolio;

public class MeasurableValue extends Value {

    protected MeasurableValue(int value) {
        super(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
