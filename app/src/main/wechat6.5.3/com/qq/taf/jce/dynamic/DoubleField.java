package com.qq.taf.jce.dynamic;

public class DoubleField extends NumberField {
    private double data;

    DoubleField(double d, int i) {
        super(i);
        this.data = d;
    }

    public Number getNumber() {
        return Double.valueOf(this.data);
    }

    public double get() {
        return this.data;
    }

    public void set(double d) {
        this.data = d;
    }
}
