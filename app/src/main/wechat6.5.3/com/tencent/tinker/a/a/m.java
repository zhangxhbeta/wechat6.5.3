package com.tencent.tinker.a.a;

import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.qqvideo.proxy.common.VcSystemInfo;
import com.tencent.tinker.a.a.b.a;

public final class m {
    protected final a pBg;
    public int pBh;
    private int pBi;
    private int type;

    public m(a aVar, int i) {
        this.type = -1;
        this.pBg = aVar;
        this.type = i;
    }

    public m(k kVar, int i) {
        this(new a(kVar) {
            final /* synthetic */ k pBf;
            private int position = 0;

            {
                this.pBf = r2;
            }

            public final byte readByte() {
                byte[] bArr = this.pBf.data;
                int i = this.position;
                this.position = i + 1;
                return bArr[i];
            }
        }, i);
    }

    public final int bOB() {
        if (this.type == -1) {
            int readByte = this.pBg.readByte() & 255;
            this.type = readByte & 31;
            this.pBi = (readByte & 224) >> 5;
        }
        return this.type;
    }

    public final int bOC() {
        yR(28);
        this.type = -1;
        return o.b(this.pBg);
    }

    public final int bOD() {
        yR(29);
        this.type = -1;
        this.pBh = o.b(this.pBg);
        return o.b(this.pBg);
    }

    public final int bOE() {
        return o.b(this.pBg);
    }

    public final byte readByte() {
        yR(0);
        this.type = -1;
        return (byte) l.a(this.pBg, this.pBi);
    }

    public final short readShort() {
        yR(2);
        this.type = -1;
        return (short) l.a(this.pBg, this.pBi);
    }

    public final char readChar() {
        yR(3);
        this.type = -1;
        return (char) l.a(this.pBg, this.pBi, false);
    }

    public final int readInt() {
        yR(4);
        this.type = -1;
        return l.a(this.pBg, this.pBi);
    }

    public final long readLong() {
        yR(6);
        this.type = -1;
        a aVar = this.pBg;
        int i = this.pBi;
        long j = 0;
        for (int i2 = i; i2 >= 0; i2--) {
            j = (j >>> 8) | ((((long) aVar.readByte()) & 255) << 56);
        }
        return j >> ((7 - i) * 8);
    }

    public final float readFloat() {
        yR(16);
        this.type = -1;
        return Float.intBitsToFloat(l.a(this.pBg, this.pBi, true));
    }

    public final double readDouble() {
        yR(17);
        this.type = -1;
        a aVar = this.pBg;
        long j = 0;
        for (int i = this.pBi; i >= 0; i--) {
            j = (j >>> 8) | ((((long) aVar.readByte()) & 255) << 56);
        }
        return Double.longBitsToDouble(j);
    }

    public final int bOF() {
        yR(23);
        this.type = -1;
        return l.a(this.pBg, this.pBi, false);
    }

    public final int bOG() {
        yR(24);
        this.type = -1;
        return l.a(this.pBg, this.pBi, false);
    }

    public final int bOH() {
        yR(25);
        this.type = -1;
        return l.a(this.pBg, this.pBi, false);
    }

    public final int bOI() {
        yR(27);
        this.type = -1;
        return l.a(this.pBg, this.pBi, false);
    }

    public final int bOJ() {
        yR(26);
        this.type = -1;
        return l.a(this.pBg, this.pBi, false);
    }

    public final void bOK() {
        yR(30);
        this.type = -1;
    }

    public final boolean readBoolean() {
        yR(31);
        this.type = -1;
        return this.pBi != 0;
    }

    public final void skipValue() {
        int i = 0;
        int bOC;
        switch (bOB()) {
            case 0:
                readByte();
                return;
            case 2:
                readShort();
                return;
            case 3:
                readChar();
                return;
            case 4:
                readInt();
                return;
            case 6:
                readLong();
                return;
            case 16:
                readFloat();
                return;
            case 17:
                readDouble();
                return;
            case 23:
                bOF();
                return;
            case 24:
                bOG();
                return;
            case 25:
                bOH();
                return;
            case VcSystemInfo.PLAYER_LEVEL_26 /*26*/:
                bOJ();
                return;
            case bv.CTRL_INDEX /*27*/:
                bOI();
                return;
            case p.CTRL_INDEX /*28*/:
                bOC = bOC();
                while (i < bOC) {
                    skipValue();
                    i++;
                }
                return;
            case JsApiChooseImage.CTRL_INDEX /*29*/:
                bOC = bOD();
                while (i < bOC) {
                    o.b(this.pBg);
                    skipValue();
                    i++;
                }
                return;
            case 30:
                bOK();
                return;
            case JsApiStartRecordVoice.CTRL_INDEX /*31*/:
                readBoolean();
                return;
            default:
                throw new j("Unexpected type: " + Integer.toHexString(this.type));
        }
    }

    private void yR(int i) {
        if (bOB() != i) {
            throw new IllegalStateException(String.format("Expected %x but was %x", new Object[]{Integer.valueOf(i), Integer.valueOf(bOB())}));
        }
    }
}
