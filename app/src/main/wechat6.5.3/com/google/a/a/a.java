package com.google.a.a;

import com.tencent.mmdb.FileUtils;

public final class a {
    private int aGo;
    private int aGp;
    private int aGq;
    private int aGr;
    private int aGs;
    private int aGt = Integer.MAX_VALUE;
    private int aGu;
    private int aGv = 64;
    private int aGw = 67108864;
    private final byte[] buffer;

    public final int mG() {
        if ((this.aGr == this.aGp ? 1 : 0) != 0) {
            this.aGs = 0;
            return 0;
        }
        this.aGs = mH();
        if (this.aGs != 0) {
            return this.aGs;
        }
        throw d.mP();
    }

    public final void cn(int i) {
        if (this.aGs != i) {
            throw d.mQ();
        }
    }

    public final boolean co(int i) {
        switch (g.cz(i)) {
            case 0:
                mH();
                return true;
            case 1:
                mL();
                mL();
                mL();
                mL();
                mL();
                mL();
                mL();
                mL();
                return true;
            case 2:
                ct(mH());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                mL();
                mL();
                mL();
                mL();
                return true;
            default:
                throw d.mR();
        }
        int mG;
        do {
            mG = mG();
            if (mG != 0) {
            }
            cn(g.ao(g.cA(i), 4));
            return true;
        } while (co(mG));
        cn(g.ao(g.cA(i), 4));
        return true;
    }

    public final String readString() {
        int mH = mH();
        if (mH > this.aGp - this.aGr || mH <= 0) {
            return new String(cs(mH), "UTF-8");
        }
        String str = new String(this.buffer, this.aGr, mH, "UTF-8");
        this.aGr = mH + this.aGr;
        return str;
    }

    public final void a(e eVar) {
        int mH = mH();
        if (this.aGu >= this.aGv) {
            throw d.mS();
        }
        mH = cp(mH);
        this.aGu++;
        eVar.a(this);
        cn(0);
        this.aGu--;
        cq(mH);
    }

    public final byte[] readBytes() {
        int mH = mH();
        if (mH > this.aGp - this.aGr || mH <= 0) {
            return cs(mH);
        }
        Object obj = new byte[mH];
        System.arraycopy(this.buffer, this.aGr, obj, 0, mH);
        this.aGr = mH + this.aGr;
        return obj;
    }

    public final int mH() {
        byte mL = mL();
        if (mL >= (byte) 0) {
            return mL;
        }
        int i = mL & 127;
        byte mL2 = mL();
        if (mL2 >= (byte) 0) {
            return i | (mL2 << 7);
        }
        i |= (mL2 & 127) << 7;
        mL2 = mL();
        if (mL2 >= (byte) 0) {
            return i | (mL2 << 14);
        }
        i |= (mL2 & 127) << 14;
        mL2 = mL();
        if (mL2 >= (byte) 0) {
            return i | (mL2 << 21);
        }
        i |= (mL2 & 127) << 21;
        mL2 = mL();
        i |= mL2 << 28;
        if (mL2 >= (byte) 0) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (mL() >= (byte) 0) {
                return i;
            }
        }
        throw d.mO();
    }

    public final long mI() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte mL = mL();
            j |= ((long) (mL & 127)) << i;
            if ((mL & FileUtils.S_IWUSR) == 0) {
                return j;
            }
        }
        throw d.mO();
    }

    a(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.aGo = 0;
        this.aGp = i2 + 0;
        this.aGr = 0;
    }

    public final int cp(int i) {
        if (i < 0) {
            throw d.mN();
        }
        int i2 = this.aGr + i;
        int i3 = this.aGt;
        if (i2 > i3) {
            throw d.mM();
        }
        this.aGt = i2;
        mJ();
        return i3;
    }

    private void mJ() {
        this.aGp += this.aGq;
        int i = this.aGp;
        if (i > this.aGt) {
            this.aGq = i - this.aGt;
            this.aGp -= this.aGq;
            return;
        }
        this.aGq = 0;
    }

    public final void cq(int i) {
        this.aGt = i;
        mJ();
    }

    public final int mK() {
        if (this.aGt == Integer.MAX_VALUE) {
            return -1;
        }
        return this.aGt - this.aGr;
    }

    public final int getPosition() {
        return this.aGr - this.aGo;
    }

    public final void cr(int i) {
        if (i > this.aGr - this.aGo) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.aGr - this.aGo));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.aGr = this.aGo + i;
        }
    }

    private byte mL() {
        if (this.aGr == this.aGp) {
            throw d.mM();
        }
        byte[] bArr = this.buffer;
        int i = this.aGr;
        this.aGr = i + 1;
        return bArr[i];
    }

    private byte[] cs(int i) {
        if (i < 0) {
            throw d.mN();
        } else if (this.aGr + i > this.aGt) {
            ct(this.aGt - this.aGr);
            throw d.mM();
        } else if (i <= this.aGp - this.aGr) {
            Object obj = new byte[i];
            System.arraycopy(this.buffer, this.aGr, obj, 0, i);
            this.aGr += i;
            return obj;
        } else {
            throw d.mM();
        }
    }

    private void ct(int i) {
        if (i < 0) {
            throw d.mN();
        } else if (this.aGr + i > this.aGt) {
            ct(this.aGt - this.aGr);
            throw d.mM();
        } else if (i <= this.aGp - this.aGr) {
            this.aGr += i;
        } else {
            throw d.mM();
        }
    }
}
