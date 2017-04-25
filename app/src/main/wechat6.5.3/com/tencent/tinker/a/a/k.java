package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.t.a.a;

public final class k extends a<k> {
    public byte[] data;

    public final /* synthetic */ int compareTo(Object obj) {
        return b((k) obj);
    }

    public k(int i, byte[] bArr) {
        super(i);
        this.data = bArr;
    }

    public final int b(k kVar) {
        return c.m(this.data, kVar.data);
    }
}
