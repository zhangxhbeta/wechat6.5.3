package com.tencent.tinker.a.b.b;

import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.qqvideo.proxy.common.VcSystemInfo;
import com.tencent.tinker.a.a.j;
import com.tencent.tinker.a.a.l;
import com.tencent.tinker.a.a.m;
import com.tencent.tinker.a.a.o;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.BitSet;

public final class b {
    public final BitSet pCA = new BitSet();
    public final BitSet pCB = new BitSet();
    public final BitSet pCC = new BitSet();
    public final BitSet pCD = new BitSet();
    public final BitSet pCE = new BitSet();
    public final BitSet pCF = new BitSet();
    public final BitSet pCG = new BitSet();
    public final BitSet pCH = new BitSet();
    public final BitSet pCI = new BitSet();
    public final com.tencent.tinker.a.c.a pCh = new com.tencent.tinker.a.c.a();
    public final com.tencent.tinker.a.c.a pCi = new com.tencent.tinker.a.c.a();
    public final com.tencent.tinker.a.c.a pCj = new com.tencent.tinker.a.c.a();
    public final com.tencent.tinker.a.c.a pCk = new com.tencent.tinker.a.c.a();
    public final com.tencent.tinker.a.c.a pCl = new com.tencent.tinker.a.c.a();
    public final com.tencent.tinker.a.c.a pCm = new com.tencent.tinker.a.c.a();
    public final com.tencent.tinker.a.c.a pCn = new com.tencent.tinker.a.c.a();
    public final com.tencent.tinker.a.c.a pCo = new com.tencent.tinker.a.c.a();
    public final com.tencent.tinker.a.c.a pCp = new com.tencent.tinker.a.c.a();
    public final com.tencent.tinker.a.c.a pCq = new com.tencent.tinker.a.c.a();
    public final com.tencent.tinker.a.c.a pCr = new com.tencent.tinker.a.c.a();
    public final com.tencent.tinker.a.c.a pCs = new com.tencent.tinker.a.c.a();
    public final com.tencent.tinker.a.c.a pCt = new com.tencent.tinker.a.c.a();
    public final com.tencent.tinker.a.c.a pCu = new com.tencent.tinker.a.c.a();
    public final BitSet pCv = new BitSet();
    public final BitSet pCw = new BitSet();
    public final BitSet pCx = new BitSet();
    public final BitSet pCy = new BitSet();
    public final BitSet pCz = new BitSet();

    private final class a {
        final /* synthetic */ b pCK;
        private final com.tencent.tinker.a.a.b.b pCM;

        public a(b bVar, com.tencent.tinker.a.a.b.b bVar2) {
            this.pCK = bVar;
            this.pCM = bVar2;
        }

        private void a(m mVar) {
            int i = 0;
            switch (mVar.bOB()) {
                case 0:
                    l.a(this.pCM, 0, (long) mVar.readByte());
                    return;
                case 2:
                    l.a(this.pCM, 2, (long) mVar.readShort());
                    return;
                case 3:
                    l.b(this.pCM, 3, (long) mVar.readChar());
                    return;
                case 4:
                    l.a(this.pCM, 4, (long) mVar.readInt());
                    return;
                case 6:
                    l.a(this.pCM, 6, mVar.readLong());
                    return;
                case 16:
                    l.c(this.pCM, 16, ((long) Float.floatToIntBits(mVar.readFloat())) << 32);
                    return;
                case 17:
                    l.c(this.pCM, 17, Double.doubleToLongBits(mVar.readDouble()));
                    return;
                case 23:
                    l.b(this.pCM, 23, (long) this.pCK.zo(mVar.bOF()));
                    return;
                case 24:
                    l.b(this.pCM, 24, (long) this.pCK.zp(mVar.bOG()));
                    return;
                case 25:
                    l.b(this.pCM, 25, (long) this.pCK.zq(mVar.bOH()));
                    return;
                case VcSystemInfo.PLAYER_LEVEL_26 /*26*/:
                    l.b(this.pCM, 26, (long) this.pCK.zr(mVar.bOJ()));
                    return;
                case bv.CTRL_INDEX /*27*/:
                    l.b(this.pCM, 27, (long) this.pCK.zq(mVar.bOI()));
                    return;
                case p.CTRL_INDEX /*28*/:
                    dQ(28, 0);
                    c(mVar);
                    return;
                case JsApiChooseImage.CTRL_INDEX /*29*/:
                    dQ(29, 0);
                    b(mVar);
                    return;
                case 30:
                    mVar.bOK();
                    dQ(30, 0);
                    return;
                case JsApiStartRecordVoice.CTRL_INDEX /*31*/:
                    if (mVar.readBoolean()) {
                        i = 1;
                    }
                    dQ(31, i);
                    return;
                default:
                    throw new j("Unexpected type: " + Integer.toHexString(mVar.bOB()));
            }
        }

        public final void b(m mVar) {
            int bOD = mVar.bOD();
            o.a(this.pCM, this.pCK.zp(mVar.pBh));
            o.a(this.pCM, bOD);
            for (int i = 0; i < bOD; i++) {
                o.a(this.pCM, this.pCK.zo(mVar.bOE()));
                a(mVar);
            }
        }

        public final void c(m mVar) {
            int bOC = mVar.bOC();
            o.a(this.pCM, bOC);
            for (int i = 0; i < bOC; i++) {
                a(mVar);
            }
        }

        private void dQ(int i, int i2) {
            this.pCM.writeByte((i2 << 5) | i);
        }
    }

    class AnonymousClass1 implements com.tencent.tinker.a.a.b.a {
        final /* synthetic */ ByteArrayInputStream pCJ;
        final /* synthetic */ b pCK;

        public AnonymousClass1(b bVar, ByteArrayInputStream byteArrayInputStream) {
            this.pCK = bVar;
            this.pCJ = byteArrayInputStream;
        }

        public final byte readByte() {
            return (byte) (this.pCJ.read() & 255);
        }
    }

    class AnonymousClass2 implements com.tencent.tinker.a.a.b.b {
        final /* synthetic */ ByteArrayOutputStream pBV;
        final /* synthetic */ b pCK;

        public AnonymousClass2(b bVar, ByteArrayOutputStream byteArrayOutputStream) {
            this.pCK = bVar;
            this.pBV = byteArrayOutputStream;
        }

        public final void writeByte(int i) {
            this.pBV.write(i);
        }
    }

    class AnonymousClass3 implements com.tencent.tinker.a.a.b.b {
        final /* synthetic */ b pCK;
        final /* synthetic */ ByteArrayOutputStream pCL;

        public AnonymousClass3(b bVar, ByteArrayOutputStream byteArrayOutputStream) {
            this.pCK = bVar;
            this.pCL = byteArrayOutputStream;
        }

        public final void writeByte(int i) {
            this.pCL.write(i);
        }
    }

    class AnonymousClass4 implements com.tencent.tinker.a.a.b.b {
        final /* synthetic */ b pCK;
        final /* synthetic */ ByteArrayOutputStream pCL;

        public AnonymousClass4(b bVar, ByteArrayOutputStream byteArrayOutputStream) {
            this.pCK = bVar;
            this.pCL = byteArrayOutputStream;
        }

        public final void writeByte(int i) {
            this.pCL.write(i);
        }
    }

    public final int zo(int i) {
        int indexOfKey = this.pCh.indexOfKey(i);
        if (indexOfKey >= 0) {
            return this.pCh.pCP[indexOfKey];
        }
        if (i < 0 || !this.pCv.get(i)) {
            return i;
        }
        return -1;
    }

    public final int zp(int i) {
        int indexOfKey = this.pCi.indexOfKey(i);
        if (indexOfKey >= 0) {
            return this.pCi.pCP[indexOfKey];
        }
        if (i < 0 || !this.pCw.get(i)) {
            return i;
        }
        return -1;
    }

    public final int zq(int i) {
        int indexOfKey = this.pCk.indexOfKey(i);
        if (indexOfKey >= 0) {
            return this.pCk.pCP[indexOfKey];
        }
        if (i < 0 || !this.pCy.get(i)) {
            return i;
        }
        return -1;
    }

    public final int zr(int i) {
        int indexOfKey = this.pCl.indexOfKey(i);
        if (indexOfKey >= 0) {
            return this.pCl.pCP[indexOfKey];
        }
        if (i < 0 || !this.pCz.get(i)) {
            return i;
        }
        return -1;
    }

    public final int zs(int i) {
        int indexOfKey = this.pCm.indexOfKey(i);
        if (indexOfKey >= 0) {
            return this.pCm.pCP[indexOfKey];
        }
        if (i < 0 || !this.pCA.get(i)) {
            return i;
        }
        return -1;
    }

    public final int zt(int i) {
        int indexOfKey = this.pCo.indexOfKey(i);
        if (indexOfKey >= 0) {
            return this.pCo.pCP[indexOfKey];
        }
        if (i < 0 || !this.pCC.get(i)) {
            return i;
        }
        return -1;
    }

    public final com.tencent.tinker.a.a.e.a[] c(com.tencent.tinker.a.a.e.a[] aVarArr) {
        com.tencent.tinker.a.a.e.a[] aVarArr2 = new com.tencent.tinker.a.a.e.a[aVarArr.length];
        for (int i = 0; i < aVarArr.length; i++) {
            com.tencent.tinker.a.a.e.a aVar = aVarArr[i];
            aVarArr2[i] = new com.tencent.tinker.a.a.e.a(zq(aVar.pAs), aVar.pAt);
        }
        return aVarArr2;
    }

    public final com.tencent.tinker.a.a.e.b[] c(com.tencent.tinker.a.a.e.b[] bVarArr) {
        com.tencent.tinker.a.a.e.b[] bVarArr2 = new com.tencent.tinker.a.a.e.b[bVarArr.length];
        for (int i = 0; i < bVarArr.length; i++) {
            com.tencent.tinker.a.a.e.b bVar = bVarArr[i];
            int zr = zr(bVar.pAu);
            int i2 = bVar.pAv;
            int indexOfKey = this.pCu.indexOfKey(i2);
            if (indexOfKey >= 0) {
                i2 = this.pCu.pCP[indexOfKey];
            } else if (i2 >= 0 && this.pCI.get(i2)) {
                i2 = -1;
            }
            bVarArr2[i] = new com.tencent.tinker.a.a.e.b(zr, bVar.pAt, i2);
        }
        return bVarArr2;
    }
}
