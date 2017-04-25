package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.protocal.c.bfk;
import com.tencent.mm.protocal.c.bfl;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class f extends n<bfk, bfl> {
    String TAG = "MicroMsg.NetSceneVoipHeartBeat";

    public f(int i, long j, int i2) {
        a aVar = new a();
        aVar.czn = new bfk();
        aVar.czo = new bfl();
        aVar.uri = "/cgi-bin/micromsg-bin/voipheartbeat";
        aVar.czm = 178;
        aVar.czp = 81;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        bfk com_tencent_mm_protocal_c_bfk = (bfk) this.cif.czk.czs;
        com_tencent_mm_protocal_c_bfk.mqS = i;
        com_tencent_mm_protocal_c_bfk.mqT = j;
        com_tencent_mm_protocal_c_bfk.mZV = System.currentTimeMillis();
        com_tencent_mm_protocal_c_bfk.naT = i2;
    }

    public final int getType() {
        return 178;
    }

    public final e bcT() {
        return new e(this) {
            final /* synthetic */ f kvt;

            {
                this.kvt = r1;
            }

            public final void a(int i, int i2, String str, k kVar) {
                if (i != 0) {
                    com.tencent.mm.plugin.voip.b.a.cR(this.kvt.TAG, "Voip heartbeat Failed, type:" + kVar.getType() + " errType:" + i + " errCode:" + i2);
                    this.kvt.ksv.ksc.kxf.ksP = 111;
                    this.kvt.ksv.ksc.kxf.ksQ = i2;
                    this.kvt.ksv.ksc.kxf.kth = 2;
                    this.kvt.ksv.m(1, -9004, "");
                }
            }
        };
    }
}
