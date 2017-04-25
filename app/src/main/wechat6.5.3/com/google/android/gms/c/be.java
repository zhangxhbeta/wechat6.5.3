package com.google.android.gms.c;

import java.io.IOException;

public abstract class be {
    protected volatile int aAV = -1;

    public static final <T extends be> T a(T t, byte[] bArr, int i) {
        try {
            aw awVar = new aw(bArr, 0, i);
            t.a(awVar);
            awVar.bT(0);
            return t;
        } catch (bd e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public static final byte[] c(be beVar) {
        byte[] bArr = new byte[beVar.lC()];
        try {
            ax b = ax.b(bArr, 0, bArr.length);
            beVar.a(b);
            if (b.aAJ.remaining() == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (Throwable e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public abstract be a(aw awVar);

    public void a(ax axVar) {
    }

    public /* synthetic */ Object clone() {
        return lr();
    }

    protected int kF() {
        return 0;
    }

    public final int lB() {
        if (this.aAV < 0) {
            lC();
        }
        return this.aAV;
    }

    public final int lC() {
        int kF = kF();
        this.aAV = kF;
        return kF;
    }

    public be lr() {
        return (be) super.clone();
    }

    public String toString() {
        return bf.d(this);
    }
}
