package com.qq.taf.jce.dynamic;

public final class ZeroField extends NumberField {
    ZeroField(int i) {
        super(i);
    }

    public final Number getNumber() {
        return Integer.valueOf(0);
    }

    public final byte byteValue() {
        return (byte) 0;
    }

    public final double doubleValue() {
        return 0.0d;
    }

    public final float floatValue() {
        return 0.0f;
    }

    public final int intValue() {
        return 0;
    }

    public final long longValue() {
        return 0;
    }

    public final short shortValue() {
        return (short) 0;
    }
}
