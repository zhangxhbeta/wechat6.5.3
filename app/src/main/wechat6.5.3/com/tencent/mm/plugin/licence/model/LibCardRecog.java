package com.tencent.mm.plugin.licence.model;

import com.tencent.mm.compatible.util.k;

public final class LibCardRecog {
    public static native int recognizeCardInit(int i, int i2, int i3);

    public static native int recognizeCardProcess(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, CardInfo cardInfo, boolean[] zArr);

    public static native int recognizeCardRelease();

    static {
        k.b("stlport_shared", LibCardRecog.class.getClassLoader());
        k.b("IDCardRecog", LibCardRecog.class.getClassLoader());
    }
}
