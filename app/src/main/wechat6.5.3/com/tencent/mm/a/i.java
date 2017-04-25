package com.tencent.mm.a;

import com.tencent.mmdb.FileUtils;

final class i {
    public byte[] aPQ;
    public int aPR;

    public i() {
        this.aPR = 0;
        this.aPQ = new byte[FileUtils.S_IRUSR];
    }

    public i(byte b) {
        this.aPR = 0;
        this.aPQ = new byte[]{b};
    }

    public i(byte[] bArr) {
        this.aPR = 0;
        this.aPQ = bArr;
    }
}
