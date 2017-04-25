package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.network.aa;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aqx;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.auk;
import com.tencent.mm.protocal.c.aul;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;

public final class g extends e {
    private final b cif;
    private e cii;

    public g(byte[] bArr, int i, long j, int i2, boolean z, int i3) {
        float f;
        float f2;
        int i4 = 1;
        int i5 = 0;
        super(j);
        a aVar = new a();
        aVar.czn = new auk();
        aVar.czo = new aul();
        aVar.uri = "/cgi-bin/micromsg-bin/shaketv";
        aVar.czm = 408;
        aVar.czp = i5;
        aVar.czq = i5;
        this.cif = aVar.Bv();
        auk com_tencent_mm_protocal_c_auk = (auk) this.cif.czk.czs;
        com_tencent_mm_protocal_c_auk.mfg = new are().ba(bArr);
        com_tencent_mm_protocal_c_auk.mRO = i2;
        com_tencent_mm_protocal_c_auk.mfh = z ? 1 : i5;
        com_tencent_mm_protocal_c_auk.mRP = (float) i;
        if (!aa.bk(com.tencent.mm.sdk.platformtools.aa.getContext())) {
            i4 = 2;
        }
        com_tencent_mm_protocal_c_auk.mnk = i4;
        com_tencent_mm_protocal_c_auk.mcM = i3;
        try {
            ak.yW();
            float f3 = be.getFloat((String) c.vf().get(t.a.npv, null), 0.0f);
            try {
                ak.yW();
                f = be.getFloat((String) c.vf().get(t.a.npw, null), 0.0f);
                try {
                    ak.yW();
                    i5 = be.KL((String) c.vf().get(t.a.nrG, null));
                    f2 = f;
                    f = f3;
                } catch (Exception e) {
                    f2 = f;
                    f = f3;
                }
            } catch (Exception e2) {
                f2 = 0.0f;
                f = f3;
            }
        } catch (Exception e3) {
            f2 = 0.0f;
            f = 0.0f;
        }
        com_tencent_mm_protocal_c_auk.mjN = f;
        com_tencent_mm_protocal_c_auk.mRQ = f2;
        n.a(2009, com_tencent_mm_protocal_c_auk.mRQ, com_tencent_mm_protocal_c_auk.mjN, i5);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        auk com_tencent_mm_protocal_c_auk = (auk) this.cif.czk.czs;
        v.d("MicroMsg.NetSceneShakeTV", "MusicFingerPrintRecorder doscene dataid:%d data:%d endflag:%d voice:%f nettype:%d ver:%d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_auk.mRO), Integer.valueOf(com_tencent_mm_protocal_c_auk.mfg.mQu), Integer.valueOf(com_tencent_mm_protocal_c_auk.mfh), Float.valueOf(com_tencent_mm_protocal_c_auk.mRP), Integer.valueOf(com_tencent_mm_protocal_c_auk.mnk), Integer.valueOf(com_tencent_mm_protocal_c_auk.mcM)});
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        auk com_tencent_mm_protocal_c_auk = (auk) this.cif.czk.czs;
        v.d("MicroMsg.NetSceneShakeTV", "MusicFingerPrintRecorder onGYNetEnd [%d,%d] dataid:%d endflag:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(com_tencent_mm_protocal_c_auk.mRO), Integer.valueOf(((aul) this.cif.czl.czs).mfh)});
        if (i2 == 0 && i3 == 0 && r1.mfh == 1) {
            this.iQe = true;
        }
        this.cii.a(i2, i3, str, this);
    }

    public final aqx aOr() {
        return (aul) this.cif.czl.czs;
    }

    public final int getType() {
        return 408;
    }
}
