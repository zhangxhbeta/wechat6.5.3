package com.tencent.mm.protocal;

import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.akb;
import com.tencent.mm.protocal.c.akc;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.nr;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;

public final class z {

    public static class a extends c implements com.tencent.mm.protocal.l.a {
        public byte[] lWF;
        public akb lXu = new akb();

        public final byte[] zf() {
            int i = -1;
            this.lWS = ad.brG();
            this.lXu.mgD = new are().ba(be.buh());
            this.lXu.mPU = l.a(this);
            this.lXu.mKJ = f.nhU;
            nr nrVar = new nr();
            nrVar.mpx = 713;
            PByteArray pByteArray = new PByteArray();
            PByteArray pByteArray2 = new PByteArray();
            int generateECKey = MMProtocalJni.generateECKey(nrVar.mpx, pByteArray, pByteArray2);
            byte[] bArr = pByteArray.value;
            byte[] bArr2 = pByteArray2.value;
            this.lWF = bArr2 != null ? bArr2 : new byte[0];
            String str = "MicroMsg.MMReg2.Req";
            String str2 = "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s";
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(nrVar.mpx);
            objArr[1] = Integer.valueOf(generateECKey);
            objArr[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            if (bArr2 != null) {
                i = bArr2.length;
            }
            objArr[3] = Integer.valueOf(i);
            objArr[4] = be.bk(bArr);
            objArr[5] = be.bk(bArr2);
            v.d(str, str2, objArr);
            nrVar.mes = new are().ba(bArr);
            this.lXu.mew = nrVar;
            return this.lXu.toByteArray();
        }

        public final int zg() {
            return 126;
        }

        public final int getCmdId() {
            return 0;
        }
    }

    public static class b extends d implements com.tencent.mm.protocal.l.b {
        public byte[] dlf;
        public byte[] lWH;
        public int lWI = 0;
        public akc lXv = new akc();

        public final int y(byte[] bArr) {
            this.lWI = 0;
            this.lXv = (akc) new akc().az(bArr);
            l.a(this, this.lXv.mQl);
            this.lWI = 0;
            return this.lXv.mQl.mcj;
        }

        public final int getCmdId() {
            return 0;
        }

        public final void aV(byte[] bArr) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            this.dlf = bArr;
        }
    }
}
