package com.tencent.mm.plugin.sns.e;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.awv;
import com.tencent.mm.protocal.c.awy;
import com.tencent.mm.protocal.c.awz;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;
import java.util.List;

public final class t extends k implements j {
    private int bdf;
    private b cif;
    public e cii;
    private long jkE;
    private int scene = 0;

    public t(int i, long j, String str, int i2, List<String> list, int i3) {
        v.d("MicroMsg.NetSceneSnsTagMemberOption", "opCode " + i + " tagName " + str + " memberList " + list.size() + " scene " + i3);
        this.bdf = i;
        this.jkE = j;
        this.scene = i3;
        a aVar = new a();
        aVar.czn = new awy();
        aVar.czo = new awz();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnstagmemberoption";
        aVar.czm = 291;
        aVar.czp = 115;
        aVar.czq = 1000000115;
        this.cif = aVar.Bv();
        awy com_tencent_mm_protocal_c_awy = (awy) this.cif.czk.czs;
        com_tencent_mm_protocal_c_awy.lZm = i;
        com_tencent_mm_protocal_c_awy.mUj = j;
        com_tencent_mm_protocal_c_awy.gmM = str;
        com_tencent_mm_protocal_c_awy.eet = i2;
        com_tencent_mm_protocal_c_awy.maG = this.scene;
        LinkedList linkedList = new LinkedList();
        for (String JF : list) {
            linkedList.add(new arf().JF(JF));
        }
        com_tencent_mm_protocal_c_awy.eeu = linkedList;
        v.d("MicroMsg.NetSceneSnsTagMemberOption", "rr.req.rImpl " + com_tencent_mm_protocal_c_awy.toString());
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 291;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneSnsTagMemberOption", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            awv com_tencent_mm_protocal_c_awv = ((awz) ((b) pVar).czl.czs).mUl;
            v.d("MicroMsg.NetSceneSnsTagMemberOption", "Resp.rImpl " + com_tencent_mm_protocal_c_awv.toString());
            q df = ad.aSI().df(com_tencent_mm_protocal_c_awv.mUj);
            df.field_tagId = com_tencent_mm_protocal_c_awv.mUj;
            df.field_tagName = be.ah(com_tencent_mm_protocal_c_awv.gmM, "");
            switch (this.bdf) {
                case 1:
                case 2:
                case 3:
                    df.field_count = com_tencent_mm_protocal_c_awv.eet;
                    df.bt(com_tencent_mm_protocal_c_awv.eeu);
                    break;
            }
            ad.aSI().a(df);
            this.cii.a(i2, i3, str, this);
            return;
        }
        this.cii.a(i2, i3, str, this);
    }
}
