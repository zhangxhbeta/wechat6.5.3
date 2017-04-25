package com.qq.taf.jce.dynamic;

public class LongField extends NumberField {
    private long data;

    LongField(long j, int i) {
        super(i);
        this.data = j;
    }

    public Number getNumber() {
        return Long.valueOf(this.data);
    }

    public long get() {
        return this.data;
    }

    public void set(long j) {
        this.data = j;
    }
}
