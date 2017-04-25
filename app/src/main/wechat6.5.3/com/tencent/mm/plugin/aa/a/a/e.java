package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.f;
import com.tencent.mm.protocal.c.g;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.k;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

public final class e extends k implements j {
    public String biB;
    private com.tencent.mm.v.e cii;
    private b dsK;
    private f dsN;
    public g dsO;

    public e(long j, String str, List<String> list, int i, String str2) {
        a aVar = new a();
        aVar.czn = new f();
        aVar.czo = new g();
        aVar.czm = 1624;
        aVar.uri = "/cgi-bin/mmpay-bin/newaalaunchbymoney";
        aVar.czp = 0;
        aVar.czq = 0;
        this.biB = str2;
        this.dsK = aVar.Bv();
        this.dsN = (f) this.dsK.czk.czs;
        if (list != null) {
            try {
                if (list.size() > 0) {
                    this.dsN.lYz = list.size();
                    this.dsN.lYA = j;
                    this.dsN.title = URLEncoder.encode(str, "UTF-8");
                    this.dsN.lYB = new LinkedList();
                    this.dsN.lYB.addAll(list);
                    this.dsN.scene = i;
                    this.dsN.lYx = str2;
                    this.dsN.lYC = com.tencent.mm.plugin.wallet_core.model.f.bfP();
                    v.d("MicroMsg.NetSceneAALaunchByMoney", "location %s", new Object[]{this.dsN.lYC});
                }
            } catch (Exception e) {
                v.e("MicroMsg.NetSceneAALaunchByMoney", "build NetSceneAALaunchByMoney request error: %s", new Object[]{e.getMessage()});
            }
        }
        v.i("MicroMsg.NetSceneAALaunchByMoney", "NetSceneAALaunchByMoney, total_num: %s, per_amount: %s, title: %s, payer_list: %s, scene: %s, groupid: %s", new Object[]{Integer.valueOf(this.dsN.lYz), Long.valueOf(this.dsN.lYA), this.dsN.title, this.dsN.lYB, Integer.valueOf(this.dsN.scene), this.dsN.lYx});
    }

    public e(long j, String str, int i, int i2, String str2) {
        a aVar = new a();
        aVar.czn = new f();
        aVar.czo = new g();
        aVar.czm = 1624;
        aVar.uri = "/cgi-bin/mmpay-bin/newaalaunchbymoney";
        aVar.czp = 0;
        aVar.czq = 0;
        this.dsK = aVar.Bv();
        this.dsN = (f) this.dsK.czk.czs;
        this.biB = str2;
        try {
            this.dsN.lYz = i;
            this.dsN.lYA = j;
            this.dsN.title = URLEncoder.encode(str, "UTF-8");
            this.dsN.lYB = new LinkedList();
            this.dsN.scene = i2;
            this.dsN.lYx = str2;
            this.dsN.lYC = com.tencent.mm.plugin.wallet_core.model.f.bfP();
            v.d("MicroMsg.NetSceneAALaunchByMoney", "location %s", new Object[]{this.dsN.lYC});
        } catch (Exception e) {
            v.e("MicroMsg.NetSceneAALaunchByMoney", "build NetSceneAALaunchByMoney request error: %s", new Object[]{e.getMessage()});
        }
        v.i("MicroMsg.NetSceneAALaunchByMoney", "NetSceneAALaunchByMoney, total_num: %s, per_amount: %s, title: %s, payer_list: %s, scene: %s, groupid: %s", new Object[]{Integer.valueOf(this.dsN.lYz), Long.valueOf(this.dsN.lYA), this.dsN.title, this.dsN.lYB, Integer.valueOf(this.dsN.scene), this.dsN.lYx});
    }

    public final int getType() {
        return 1624;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.v.e eVar2) {
        v.i("MicroMsg.NetSceneAALaunchByMoney", "doScene");
        this.cii = eVar2;
        return a(eVar, this.dsK, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneAALaunchByMoney", "onGYNetEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.dsO = (g) ((b) pVar).czl.czs;
        String str2 = "MicroMsg.NetSceneAALaunchByMoney";
        String str3 = "retcode: %s, retmsg: %s, msgxml==null: %s, billNo: %s";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(this.dsO.hKq);
        objArr[1] = this.dsO.hKr;
        objArr[2] = Boolean.valueOf(this.dsO.lYy == null);
        objArr[3] = this.dsO.lYw;
        v.i(str2, str3, objArr);
        v.d("MicroMsg.NetSceneAALaunchByMoney", "msgxml: %s", new Object[]{this.dsO.lYy});
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }
}
