package com.qq.taf.jce.dynamic;

public final class ByteField extends NumberField {
    private byte data;

    ByteField(byte b, int i) {
        super(i);
        this.data = b;
    }

    public final Number getNumber() {
        return Byte.valueOf(this.data);
    }

    public final byte get() {
        return this.data;
    }

    public final void set(byte b) {
        this.data = b;
    }
}
