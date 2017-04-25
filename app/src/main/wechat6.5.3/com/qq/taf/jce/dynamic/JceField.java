package com.qq.taf.jce.dynamic;

import com.qq.taf.jce.JceDecodeException;

public class JceField {
    private static ZeroField[] zs = new ZeroField[256];
    private int tag;

    JceField(int i) {
        this.tag = i;
    }

    public int getTag() {
        return this.tag;
    }

    public static JceField create(byte b, int i) {
        return new ByteField(b, i);
    }

    public static JceField create(short s, int i) {
        return new ShortField(s, i);
    }

    public static JceField create(int i, int i2) {
        return new IntField(i, i2);
    }

    public static JceField create(long j, int i) {
        return new LongField(j, i);
    }

    public static JceField create(float f, int i) {
        return new FloatField(f, i);
    }

    public static JceField create(double d, int i) {
        return new DoubleField(d, i);
    }

    public static JceField create(String str, int i) {
        return new StringField(str, i);
    }

    public static JceField create(byte[] bArr, int i) {
        return new ByteArrayField(bArr, i);
    }

    public static JceField createList(JceField[] jceFieldArr, int i) {
        return new ListField(jceFieldArr, i);
    }

    public static JceField createMap(JceField[] jceFieldArr, JceField[] jceFieldArr2, int i) {
        return new MapField(jceFieldArr, jceFieldArr2, i);
    }

    public static JceField createStruct(JceField[] jceFieldArr, int i) {
        return new StructField(jceFieldArr, i);
    }

    static {
        for (int i = 0; i < zs.length; i++) {
            zs[i] = new ZeroField(i);
        }
    }

    public static JceField createZero(int i) {
        if (i >= 0 && i < 255) {
            return zs[i];
        }
        throw new JceDecodeException("invalid tag: " + i);
    }
}
