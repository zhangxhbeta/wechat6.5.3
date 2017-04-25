package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.axr;
import com.tencent.mm.protocal.c.beg;
import com.tencent.mm.protocal.c.bfv;
import com.tencent.mm.protocal.c.bfw;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class j extends n<bfv, bfw> {
    public j(long j, long j2, int i, String str, String str2, int i2, int i3, int[] iArr) {
        a aVar = new a();
        aVar.czn = new bfv();
        aVar.czo = new bfw();
        aVar.uri = "/cgi-bin/micromsg-bin/voipspeedresult";
        aVar.czm = 901;
        aVar.czp = 901;
        aVar.czq = 1000000901;
        this.cif = aVar.Bv();
        bfv com_tencent_mm_protocal_c_bfv = (bfv) this.cif.czk.czs;
        com_tencent_mm_protocal_c_bfv.nbz = j;
        com_tencent_mm_protocal_c_bfv.mqT = j2;
        com_tencent_mm_protocal_c_bfv.mnk = i;
        com_tencent_mm_protocal_c_bfv.nbA = new arf().JF(str);
        com_tencent_mm_protocal_c_bfv.nbB = new arf().JF(str2);
        com_tencent_mm_protocal_c_bfv.mhY = 0.0d;
        com_tencent_mm_protocal_c_bfv.mhZ = 0.0d;
        com_tencent_mm_protocal_c_bfv.mqS = i2;
        com_tencent_mm_protocal_c_bfv.nbC = i3;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            axr com_tencent_mm_protocal_c_axr = new axr();
            int i6 = i4 + 1;
            com_tencent_mm_protocal_c_axr.mUJ = iArr[i4];
            i4 = i6 + 1;
            com_tencent_mm_protocal_c_axr.mUK = iArr[i6];
            i6 = i4 + 1;
            com_tencent_mm_protocal_c_axr.mUL = iArr[i4];
            com_tencent_mm_protocal_c_axr.mUM = new beg();
            int i7 = i6 + 1;
            com_tencent_mm_protocal_c_axr.mUM.mWf = iArr[i6];
            i4 = i7 + 1;
            com_tencent_mm_protocal_c_axr.mUM.mNM = iArr[i7];
            i6 = i4 + 1;
            com_tencent_mm_protocal_c_axr.mUN = iArr[i4];
            i4 = i6 + 1;
            com_tencent_mm_protocal_c_axr.mUO = iArr[i6];
            i6 = i4 + 1;
            com_tencent_mm_protocal_c_axr.mUP = iArr[i4];
            i4 = i6 + 1;
            com_tencent_mm_protocal_c_axr.mUQ = iArr[i6];
            for (i6 = 0; i6 < com_tencent_mm_protocal_c_axr.mUQ; i6++) {
                if (i4 < iArr.length) {
                    i7 = i4 + 1;
                    com_tencent_mm_protocal_c_axr.mUR.add(Integer.valueOf(iArr[i4]));
                    i4 = i7;
                }
            }
            if (i4 < iArr.length) {
                i6 = i4 + 1;
                com_tencent_mm_protocal_c_axr.mUS = iArr[i4];
                i4 = i6;
            }
            for (i6 = 0; i6 < com_tencent_mm_protocal_c_axr.mUS; i6++) {
                if (i4 < iArr.length) {
                    i7 = i4 + 1;
                    com_tencent_mm_protocal_c_axr.mUT.add(Integer.valueOf(iArr[i4]));
                    i4 = i7;
                }
            }
            if (i4 < iArr.length) {
                i6 = i4 + 1;
                com_tencent_mm_protocal_c_axr.mUU = iArr[i4];
                i4 = i6;
            }
            for (i6 = 0; i6 < com_tencent_mm_protocal_c_axr.mUU; i6++) {
                if (i4 < iArr.length) {
                    i7 = i4 + 1;
                    com_tencent_mm_protocal_c_axr.mUV.add(Integer.valueOf(iArr[i4]));
                    i4 = i7;
                }
            }
            com_tencent_mm_protocal_c_bfv.myS.add(com_tencent_mm_protocal_c_axr);
        }
    }

    public final int getType() {
        return 901;
    }

    public final e bcT() {
        return new e(this) {
            final /* synthetic */ j kvx;

            {
                this.kvx = r1;
            }

            public final void a(int i, int i2, String str, k kVar) {
                com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.NetSceneVoipSpeedResult", "VoipContext onVoipSpeedResultResp errType=" + i + " errCode=" + i2 + " errMsg=" + str);
                this.kvx.ksv.bbz();
            }
        };
    }
}
