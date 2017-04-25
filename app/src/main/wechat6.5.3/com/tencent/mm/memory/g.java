package com.tencent.mm.memory;

import java.util.Arrays;

public final class g extends a<byte[]> {
    public static final g cnv = new g();

    public final /* synthetic */ void ar(Object obj) {
        x((byte[]) obj);
    }

    protected final /* bridge */ /* synthetic */ long as(Object obj) {
        return (long) ((byte[]) obj).length;
    }

    protected final /* synthetic */ Comparable at(Object obj) {
        byte[] bArr = (byte[]) obj;
        return (bArr == null || bArr.length <= 0) ? Integer.valueOf(0) : Integer.valueOf(bArr.length);
    }

    protected final /* bridge */ /* synthetic */ Comparable b(Comparable comparable) {
        return (Integer) comparable;
    }

    protected final /* synthetic */ d c(Comparable comparable) {
        return new f(((Integer) comparable).intValue());
    }

    protected final /* synthetic */ Object d(Comparable comparable) {
        return new byte[((Integer) comparable).intValue()];
    }

    private g() {
    }

    public final synchronized void x(byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
        super.ar(bArr);
    }

    protected final long wa() {
        return 5242880;
    }

    protected final long wb() {
        return 1048576;
    }
}
