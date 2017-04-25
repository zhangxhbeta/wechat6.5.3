package com.google.android.gms.c;

import com.tencent.mmdb.FileUtils;
import com.tencent.smtt.sdk.WebView;

public final class aw {
    int aAA;
    int aAB;
    private int aAC;
    int aAD;
    private int aAE;
    private int aAF = Integer.MAX_VALUE;
    private int aAG;
    private int aAH = 64;
    private int aAI = 67108864;
    final byte[] buffer;

    aw(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.aAA = 0;
        this.aAB = i2 + 0;
        this.aAD = 0;
    }

    private void bZ(int i) {
        if (i < 0) {
            throw bd.lv();
        } else if (this.aAD + i > this.aAF) {
            bZ(this.aAF - this.aAD);
            throw bd.lu();
        } else if (i <= this.aAB - this.aAD) {
            this.aAD += i;
        } else {
            throw bd.lu();
        }
    }

    private void lm() {
        this.aAB += this.aAC;
        int i = this.aAB;
        if (i > this.aAF) {
            this.aAC = i - this.aAF;
            this.aAB -= this.aAC;
            return;
        }
        this.aAC = 0;
    }

    private byte lo() {
        if (this.aAD == this.aAB) {
            throw bd.lu();
        }
        byte[] bArr = this.buffer;
        int i = this.aAD;
        this.aAD = i + 1;
        return bArr[i];
    }

    public final void a(be beVar) {
        int lj = lj();
        if (this.aAG >= this.aAH) {
            throw bd.lA();
        }
        lj = bV(lj);
        this.aAG++;
        beVar.a(this);
        bT(0);
        this.aAG--;
        bW(lj);
    }

    public final void bT(int i) {
        if (this.aAE != i) {
            throw bd.ly();
        }
    }

    public final boolean bU(int i) {
        switch (bh.ci(i)) {
            case 0:
                lj();
                return true;
            case 1:
                ll();
                return true;
            case 2:
                bZ(lj());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                lk();
                return true;
            default:
                throw bd.lz();
        }
        int lg;
        do {
            lg = lg();
            if (lg != 0) {
            }
            bT(bh.ah(bh.cj(i), 4));
            return true;
        } while (bU(lg));
        bT(bh.ah(bh.cj(i), 4));
        return true;
    }

    public final int bV(int i) {
        if (i < 0) {
            throw bd.lv();
        }
        int i2 = this.aAD + i;
        int i3 = this.aAF;
        if (i2 > i3) {
            throw bd.lu();
        }
        this.aAF = i2;
        lm();
        return i3;
    }

    public final void bW(int i) {
        this.aAF = i;
        lm();
    }

    public final void bX(int i) {
        if (i > this.aAD - this.aAA) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.aAD - this.aAA));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.aAD = this.aAA + i;
        }
    }

    public final byte[] bY(int i) {
        if (i < 0) {
            throw bd.lv();
        } else if (this.aAD + i > this.aAF) {
            bZ(this.aAF - this.aAD);
            throw bd.lu();
        } else if (i <= this.aAB - this.aAD) {
            Object obj = new byte[i];
            System.arraycopy(this.buffer, this.aAD, obj, 0, i);
            this.aAD += i;
            return obj;
        } else {
            throw bd.lu();
        }
    }

    public final int getPosition() {
        return this.aAD - this.aAA;
    }

    public final int lg() {
        if ((this.aAD == this.aAB ? 1 : 0) != 0) {
            this.aAE = 0;
            return 0;
        }
        this.aAE = lj();
        if (this.aAE != 0) {
            return this.aAE;
        }
        throw bd.lx();
    }

    public final long lh() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte lo = lo();
            j |= ((long) (lo & 127)) << i;
            if ((lo & FileUtils.S_IWUSR) == 0) {
                return j;
            }
        }
        throw bd.lw();
    }

    public final boolean li() {
        return lj() != 0;
    }

    public final int lj() {
        byte lo = lo();
        if (lo >= (byte) 0) {
            return lo;
        }
        int i = lo & 127;
        byte lo2 = lo();
        if (lo2 >= (byte) 0) {
            return i | (lo2 << 7);
        }
        i |= (lo2 & 127) << 7;
        lo2 = lo();
        if (lo2 >= (byte) 0) {
            return i | (lo2 << 14);
        }
        i |= (lo2 & 127) << 14;
        lo2 = lo();
        if (lo2 >= (byte) 0) {
            return i | (lo2 << 21);
        }
        i |= (lo2 & 127) << 21;
        lo2 = lo();
        i |= lo2 << 28;
        if (lo2 >= (byte) 0) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (lo() >= (byte) 0) {
                return i;
            }
        }
        throw bd.lw();
    }

    public final int lk() {
        return (((lo() & WebView.NORMAL_MODE_ALPHA) | ((lo() & WebView.NORMAL_MODE_ALPHA) << 8)) | ((lo() & WebView.NORMAL_MODE_ALPHA) << 16)) | ((lo() & WebView.NORMAL_MODE_ALPHA) << 24);
    }

    public final long ll() {
        byte lo = lo();
        byte lo2 = lo();
        return ((((((((((long) lo2) & 255) << 8) | (((long) lo) & 255)) | ((((long) lo()) & 255) << 16)) | ((((long) lo()) & 255) << 24)) | ((((long) lo()) & 255) << 32)) | ((((long) lo()) & 255) << 40)) | ((((long) lo()) & 255) << 48)) | ((((long) lo()) & 255) << 56);
    }

    public final int ln() {
        if (this.aAF == Integer.MAX_VALUE) {
            return -1;
        }
        return this.aAF - this.aAD;
    }

    public final String readString() {
        int lj = lj();
        if (lj > this.aAB - this.aAD || lj <= 0) {
            return new String(bY(lj), "UTF-8");
        }
        String str = new String(this.buffer, this.aAD, lj, "UTF-8");
        this.aAD = lj + this.aAD;
        return str;
    }
}
