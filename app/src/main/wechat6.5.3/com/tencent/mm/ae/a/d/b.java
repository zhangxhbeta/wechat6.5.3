package com.tencent.mm.ae.a.d;

import android.graphics.Bitmap;

public final class b {
    public Bitmap bitmap;
    public String bsL;
    public int cPY;
    public byte[] data;
    public int status;

    public b() {
        this.status = -1;
    }

    public b(Bitmap bitmap) {
        this.status = 0;
        this.cPY = 0;
        this.bitmap = bitmap;
    }

    public b(byte[] bArr, String str) {
        this.data = bArr;
        this.bsL = str;
    }

    public b(byte[] bArr, String str, byte b) {
        this.data = bArr;
        this.cPY = 2;
        this.bsL = str;
    }
}
