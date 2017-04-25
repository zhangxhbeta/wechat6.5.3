package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.network.aa;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aqx;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.aug;
import com.tencent.mm.protocal.c.auh;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;

public final class f extends e {
    private final b cif;
    private e cii;

    public f(byte[] bArr, int i, long j, int i2, boolean z, int i3) {
        float f;
        int KL;
        float f2;
        int i4 = 1;
        float f3 = 0.0f;
        super(j);
        a aVar = new a();
        aVar.czn = new aug();
        aVar.czo = new auh();
        aVar.uri = "/cgi-bin/micromsg-bin/shakemusic";
        aVar.czm = 367;
        aVar.czp = 177;
        aVar.czq = 1000000177;
        this.cif = aVar.Bv();
        aug com_tencent_mm_protocal_c_aug = (aug) this.cif.czk.czs;
        com_tencent_mm_protocal_c_aug.mfg = new are().ba(bArr);
        com_tencent_mm_protocal_c_aug.mRO = i2;
        com_tencent_mm_protocal_c_aug.mfh = z ? 1 : 0;
        com_tencent_mm_protocal_c_aug.mRP = (float) i;
        com_tencent_mm_protocal_c_aug.mnk = aa.bk(com.tencent.mm.sdk.platformtools.aa.getContext()) ? 1 : 2;
        com_tencent_mm_protocal_c_aug.mcM = i3;
        try {
            ak.yW();
            f = be.getFloat((String) c.vf().get(t.a.npv, null), 0.0f);
            try {
                ak.yW();
                f3 = be.getFloat((String) c.vf().get(t.a.npw, null), 0.0f);
                ak.yW();
                KL = be.KL((String) c.vf().get(t.a.nrG, null));
            } catch (Exception e) {
                f2 = f3;
                f3 = f;
                f = f3;
                f3 = f2;
                KL = 0;
                com_tencent_mm_protocal_c_aug.mjN = f;
                com_tencent_mm_protocal_c_aug.mRQ = f3;
                com_tencent_mm_protocal_c_aug.mAk = com.tencent.mm.ai.c.HI() ? 0 : 1;
                if (!com.tencent.mm.ai.c.HH()) {
                    i4 = 0;
                }
                com_tencent_mm_protocal_c_aug.mAl = i4;
                n.a(2014, com_tencent_mm_protocal_c_aug.mRQ, com_tencent_mm_protocal_c_aug.mjN, KL);
            }
        } catch (Exception e2) {
            f2 = 0.0f;
            f = f3;
            f3 = f2;
            KL = 0;
            com_tencent_mm_protocal_c_aug.mjN = f;
            com_tencent_mm_protocal_c_aug.mRQ = f3;
            if (com.tencent.mm.ai.c.HI()) {
            }
            com_tencent_mm_protocal_c_aug.mAk = com.tencent.mm.ai.c.HI() ? 0 : 1;
            if (com.tencent.mm.ai.c.HH()) {
                i4 = 0;
            }
            com_tencent_mm_protocal_c_aug.mAl = i4;
            n.a(2014, com_tencent_mm_protocal_c_aug.mRQ, com_tencent_mm_protocal_c_aug.mjN, KL);
        }
        com_tencent_mm_protocal_c_aug.mjN = f;
        com_tencent_mm_protocal_c_aug.mRQ = f3;
        if (com.tencent.mm.ai.c.HI()) {
        }
        com_tencent_mm_protocal_c_aug.mAk = com.tencent.mm.ai.c.HI() ? 0 : 1;
        if (com.tencent.mm.ai.c.HH()) {
            i4 = 0;
        }
        com_tencent_mm_protocal_c_aug.mAl = i4;
        n.a(2014, com_tencent_mm_protocal_c_aug.mRQ, com_tencent_mm_protocal_c_aug.mjN, KL);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        aug com_tencent_mm_protocal_c_aug = (aug) this.cif.czk.czs;
        v.d("MicroMsg.NetSceneShakeMusic", "MusicFingerPrintRecorder doscene dataid:%d data:%d endflag:%d voice:%f nettype:%d ver:%d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_aug.mRO), Integer.valueOf(com_tencent_mm_protocal_c_aug.mfg.mQu), Integer.valueOf(com_tencent_mm_protocal_c_aug.mfh), Float.valueOf(com_tencent_mm_protocal_c_aug.mRP), Integer.valueOf(com_tencent_mm_protocal_c_aug.mnk), Integer.valueOf(com_tencent_mm_protocal_c_aug.mcM)});
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        aug com_tencent_mm_protocal_c_aug = (aug) this.cif.czk.czs;
        v.d("MicroMsg.NetSceneShakeMusic", "MusicFingerPrintRecorder onGYNetEnd [%d,%d] dataid:%d endflag:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(com_tencent_mm_protocal_c_aug.mRO), Integer.valueOf(((auh) this.cif.czl.czs).mfh)});
        if (i2 == 0 && i3 == 0 && r1.mfh == 1) {
            this.iQe = true;
        }
        this.cii.a(i2, i3, str, this);
    }

    public final aqx aOr() {
        return (auh) this.cif.czl.czs;
    }

    public final int getType() {
        return 367;
    }
}
