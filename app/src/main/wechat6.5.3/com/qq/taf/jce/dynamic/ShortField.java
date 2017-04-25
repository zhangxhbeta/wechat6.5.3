package com.qq.taf.jce.dynamic;

public final class ShortField extends NumberField {
    private short data;

    ShortField(short s, int i) {
        super(i);
        this.data = s;
    }

    public final Number getNumber() {
        return Short.valueOf(this.data);
    }

    public final short get() {
        return this.data;
    }

    public final void set(short s) {
        this.data = s;
    }
}
