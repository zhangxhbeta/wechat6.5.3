package com.google.a.a;

import java.io.IOException;

public abstract class e {
    public volatile int aGz = -1;

    public abstract e a(a aVar);

    public final int mT() {
        int mU = mU();
        this.aGz = mU;
        return mU;
    }

    public int mU() {
        return 0;
    }

    public void a(b bVar) {
    }

    public static final byte[] b(e eVar) {
        byte[] bArr = new byte[eVar.mT()];
        try {
            b bVar = new b(bArr, 0, bArr.length);
            eVar.a(bVar);
            if (bVar.aGx - bVar.position == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (Throwable e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public static <T extends e> T a(T t, byte[] bArr, int i) {
        try {
            a aVar = new a(bArr, 0, i);
            t.a(aVar);
            aVar.cn(0);
            return t;
        } catch (d e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public String toString() {
        return f.c(this);
    }
}
