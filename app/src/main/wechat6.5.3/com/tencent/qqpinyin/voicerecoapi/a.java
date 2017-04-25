package com.tencent.qqpinyin.voicerecoapi;

public final class a {
    public static int ptv = 2000;
    public TRSpeexNative ptA = new TRSpeexNative();
    private byte[] ptw = null;
    public byte[] ptx = null;
    private int pty = 0;
    public int ptz = 0;

    public final int bMs() {
        if (this.pty != 0) {
            return -103;
        }
        int nativeTRSpeexInit = this.ptA.nativeTRSpeexInit();
        if (nativeTRSpeexInit == -1) {
            return nativeTRSpeexInit;
        }
        this.pty = nativeTRSpeexInit;
        this.ptw = new byte[(ptv * 10)];
        return 0;
    }

    public final byte[] E(byte[] bArr, int i) {
        if (this.pty == 0) {
            throw new b(-102);
        } else if (bArr == null || bArr.length == 0) {
            throw new b(-104);
        } else {
            int nativeTRSpeexEncode = this.ptA.nativeTRSpeexEncode(this.pty, bArr, 0, i, this.ptw);
            if (nativeTRSpeexEncode < 0) {
                throw new b(nativeTRSpeexEncode);
            } else if (nativeTRSpeexEncode == 0) {
                return null;
            } else {
                byte[] bArr2 = new byte[nativeTRSpeexEncode];
                System.arraycopy(this.ptw, 0, bArr2, 0, nativeTRSpeexEncode);
                return bArr2;
            }
        }
    }

    public final int bMt() {
        if (this.pty == 0) {
            return -102;
        }
        this.ptw = null;
        int nativeTRSpeexRelease = this.ptA.nativeTRSpeexRelease(this.pty);
        this.pty = 0;
        return nativeTRSpeexRelease;
    }
}
