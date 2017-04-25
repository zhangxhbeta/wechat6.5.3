package com.tencent.mm.plugin.sns.e;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.protocal.c.awv;
import com.tencent.mm.protocal.c.axa;
import com.tencent.mm.protocal.c.axb;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class u extends k implements j {
    private int bdf;
    private b cif;
    public e cii;
    private long jkF = 0;

    public u(long j, String str) {
        v.d("MicroMsg.NetSceneSnsTagOption", "opcode 3" + " snsTagId " + j + " tagName " + str);
        this.jkF = j;
        this.bdf = 3;
        a aVar = new a();
        aVar.czn = new axa();
        aVar.czo = new axb();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnstagoption";
        aVar.czm = 290;
        aVar.czp = 114;
        aVar.czq = 1000000114;
        this.cif = aVar.Bv();
        axa com_tencent_mm_protocal_c_axa = (axa) this.cif.czk.czs;
        com_tencent_mm_protocal_c_axa.lZm = 3;
        com_tencent_mm_protocal_c_axa.mUj = j;
        com_tencent_mm_protocal_c_axa.gmM = str;
    }

    public final int getType() {
        return 290;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneSnsTagOption", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            awv com_tencent_mm_protocal_c_awv = ((axb) ((b) pVar).czl.czs).mUl;
            v.d("MicroMsg.NetSceneSnsTagOption", com_tencent_mm_protocal_c_awv.toString());
            switch (this.bdf) {
                case 1:
                case 2:
                    q df = ad.aSI().df(com_tencent_mm_protocal_c_awv.mUj);
                    df.field_tagId = com_tencent_mm_protocal_c_awv.mUj;
                    df.field_tagName = be.ah(com_tencent_mm_protocal_c_awv.gmM, "");
                    df.field_count = com_tencent_mm_protocal_c_awv.eet;
                    df.bt(com_tencent_mm_protocal_c_awv.eeu);
                    ad.aSI().a(df);
                    break;
                case 3:
                    v.d("MicroMsg.NetSceneSnsTagOption", "MM_SNS_TAG_DEL " + ad.aSI().di(this.jkF));
                    break;
            }
            this.cii.a(i2, i3, str, this);
            return;
        }
        this.cii.a(i2, i3, str, this);
    }
}
