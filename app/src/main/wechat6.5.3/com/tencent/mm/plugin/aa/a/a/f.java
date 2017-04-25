package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.compatible.util.p;
import com.tencent.mm.network.j;
import com.tencent.mm.protocal.c.h;
import com.tencent.mm.protocal.c.i;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;
import java.util.List;

public final class f extends k implements j {
    public String biB;
    private e cii;
    private b dsK;
    private h dsP;
    public i dsQ;

    public f(String str, long j, List<com.tencent.mm.protocal.c.j> list, int i, String str2) {
        a aVar = new a();
        aVar.czn = new h();
        aVar.czo = new i();
        aVar.czm = 1655;
        aVar.uri = "/cgi-bin/mmpay-bin/newaalaunchbyperson";
        aVar.czp = 0;
        aVar.czq = 0;
        this.dsK = aVar.Bv();
        this.dsP = (h) this.dsK.czk.czs;
        try {
            this.dsP.title = p.encode(str, "UTF-8");
            this.dsP.lYE = j;
            this.dsP.lYB = new LinkedList();
            this.dsP.lYB.addAll(list);
            this.dsP.scene = i;
            this.dsP.lYx = str2;
            this.dsP.lYC = com.tencent.mm.plugin.wallet_core.model.f.bfP();
            v.d("MicroMsg.NetSceneAALaunchByPerson", "location %s", new Object[]{this.dsP.lYC});
        } catch (Exception e) {
            v.e("MicroMsg.NetSceneAALaunchByPerson", "build NetSceneAALaunchByPerson request error: %s", new Object[]{e.getMessage()});
        }
        this.biB = str2;
        v.i("MicroMsg.NetSceneAALaunchByPerson", "NetSceneAALaunchByPerson, title: %s, total_pay_amount: %s, payer_list: %s, scene: %s, groupid: %s", new Object[]{this.dsP.title, Long.valueOf(this.dsP.lYE), this.dsP.lYB, Integer.valueOf(this.dsP.scene), this.dsP.lYx});
    }

    public final int getType() {
        return 1655;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.d("MicroMsg.NetSceneAALaunchByPerson", "doScene");
        this.cii = eVar2;
        return a(eVar, this.dsK, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneAALaunchByPerson", "onGYNetEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.dsQ = (i) ((b) pVar).czl.czs;
        String str2 = "MicroMsg.NetSceneAALaunchByPerson";
        String str3 = "retcode: %s, retmsg: %s, bill_no: %s, msgxml==null: %s";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(this.dsQ.hKq);
        objArr[1] = this.dsQ.hKr;
        objArr[2] = this.dsQ.lYw;
        objArr[3] = Boolean.valueOf(this.dsQ.lYy == null);
        v.i(str2, str3, objArr);
        v.d("MicroMsg.NetSceneAALaunchByPerson", "msgxml: %s", new Object[]{this.dsQ.lYy});
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }
}
