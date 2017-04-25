package com.tencent.mm.ad;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.adj;
import com.tencent.mm.protocal.c.adk;
import com.tencent.mm.protocal.c.adl;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.LinkedList;

public final class b extends k implements j {
    private LinkedList<adj> cKF;
    public String cKG;
    private final com.tencent.mm.v.b cif;
    private e cii;

    public b(ArrayList<String> arrayList) {
        a aVar = new a();
        aVar.czn = new adk();
        aVar.czo = new adl();
        aVar.uri = "/cgi-bin/micromsg-bin/invitegooglecontact";
        this.cif = aVar.Bv();
        this.cKF = new LinkedList();
        if (arrayList.size() > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                adj com_tencent_mm_protocal_c_adj = new adj();
                com_tencent_mm_protocal_c_adj.mgj = (String) arrayList.get(i);
                this.cKF.add(com_tencent_mm_protocal_c_adj);
            }
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "doScene");
        this.cii = eVar2;
        adk com_tencent_mm_protocal_c_adk = (adk) this.cif.czk.czs;
        com_tencent_mm_protocal_c_adk.eet = this.cKF.size();
        com_tencent_mm_protocal_c_adk.eeu = this.cKF;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "NetId:%d, ErrType:%d, ErrCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.cii.a(i2, i3, str, this);
        } else {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final adl Gi() {
        return (adl) this.cif.czl.czs;
    }

    public final int getType() {
        return 489;
    }
}
