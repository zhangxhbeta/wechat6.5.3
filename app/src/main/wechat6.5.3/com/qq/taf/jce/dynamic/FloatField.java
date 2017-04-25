package com.qq.taf.jce.dynamic;

public class FloatField extends NumberField {
    private float data;

    FloatField(float f, int i) {
        super(i);
        this.data = f;
    }

    public Number getNumber() {
        return Float.valueOf(this.data);
    }

    public void set(float f) {
        this.data = f;
    }

    public float get() {
        return this.data;
    }
}
