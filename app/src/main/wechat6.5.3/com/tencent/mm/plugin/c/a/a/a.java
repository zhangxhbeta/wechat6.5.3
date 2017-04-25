package com.tencent.mm.plugin.c.a.a;

public final class a {
    int[] eom = null;

    public a(int[] iArr) {
        if (iArr.length == 0) {
            throw new NullPointerException("null == aDataGroup || 0 == aDataGroup.length");
        }
        this.eom = iArr;
    }
}
