package com.tencent.mm.modelsfs;

import com.tencent.mm.plugin.imgenc.MMIMAGEENCJNI;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class a {
    private static boolean cXI = false;
    private long cXJ = 0;
    private String cXK;
    private long cXL = 0;
    private long mNativePtr = 0;

    public a(long j) {
        this.cXK = String.valueOf(j);
        init();
    }

    public a(String str) {
        this.cXK = str;
        init();
    }

    private void init() {
        v.i("MicroMsg.EncEngine", "init  key  enckey " + this.cXK + "  hashcode " + hashCode());
        this.mNativePtr = MMIMAGEENCJNI.open(this.cXK);
        try {
            v.i("MicroMsg.EncEngine", "mNativePtr " + this.mNativePtr + " " + hashCode());
        } catch (Exception e) {
            v.e("MicroMsg.EncEngine", "exception " + e.getMessage());
        }
    }

    public final void reset() {
        v.i("MicroMsg.EncEngine", "reset " + be.bur());
        free();
        if (this.cXL == 0) {
            init();
            this.cXJ = 0;
            return;
        }
        init();
        MMIMAGEENCJNI.seek(this.mNativePtr, this.cXL, 1);
        this.cXJ = this.cXL;
    }

    public final long IK() {
        this.cXL = this.cXJ;
        return this.cXL;
    }

    public final int j(byte[] bArr, int i) {
        if (this.mNativePtr == 0) {
            v.i("MicroMsg.EncEngine", "transFor " + be.bur().toString());
        }
        if (cXI) {
            v.i("MicroMsg.EncEngine", "trans for  " + hashCode() + " " + bArr.length);
        }
        if (cXI && this.cXJ < 64) {
            v.d("MicroMsg.EncEngine", "dump before _offset " + this.cXJ + "  length:" + i + " " + be.bk(bArr) + " hashcode " + hashCode());
        }
        MMIMAGEENCJNI.transFor(this.mNativePtr, bArr, this.cXJ, (long) i);
        if (cXI && this.cXJ < 64) {
            v.d("MicroMsg.EncEngine", "dump after _offset " + this.cXJ + "  length:" + i + " " + be.bk(bArr) + " hashcode " + hashCode());
        }
        this.cXJ += (long) i;
        return i;
    }

    public final void seek(long j) {
        this.cXJ = j;
        MMIMAGEENCJNI.seek(this.mNativePtr, j, 1);
    }

    public final void free() {
        v.i("MicroMsg.EncEngine", "free mNativePtr: " + this.mNativePtr + " hashcode " + hashCode());
        MMIMAGEENCJNI.free(this.mNativePtr);
        this.mNativePtr = 0;
    }
}
