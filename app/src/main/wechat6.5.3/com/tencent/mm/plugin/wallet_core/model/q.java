package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.e.a.qk;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mm.v.n;
import java.util.Date;

public final class q extends c<qk> implements e {
    private qk kQq;
    private String kQr;

    public q() {
        this.kQr = null;
        this.nhz = qk.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        long longValue;
        this.kQq = (qk) bVar;
        this.kQr = this.kQq.brG.brI;
        ak.yW();
        Object obj = com.tencent.mm.model.c.vf().get(a.nrP, Long.valueOf(0));
        long longValue2 = obj != null ? ((Long) obj).longValue() : 0;
        long time = new Date().getTime();
        ak.yW();
        obj = com.tencent.mm.model.c.vf().get(a.nrQ, Long.valueOf(600000));
        if (obj != null) {
            longValue = ((Long) obj).longValue();
            if (longValue <= 0) {
                longValue = 600000;
            }
        } else {
            longValue = 600000;
        }
        if (time - longValue2 > longValue || be.kS(this.kQr)) {
            v.i("MicroMsg.WalletGetBulletinEventListener", "data is out of date,do NetSceneGetBannerInfo for update");
            com.tencent.mm.plugin.wallet_core.b.c cVar = new com.tencent.mm.plugin.wallet_core.b.c();
            n vy = ak.vy();
            vy.a(385, this);
            vy.a(cVar, 0);
        } else if (be.kS(this.kQr)) {
            v.e("MicroMsg.WalletGetBulletinEventListener", "mScene is null");
            this.kQq.bpT.run();
            this.kQq = null;
        } else {
            v.i("MicroMsg.WalletGetBulletinEventListener", "get bulletin data from db");
            bgj();
        }
        return true;
    }

    private void bgj() {
        d bge = k.bge();
        n nVar = new n();
        nVar.field_bulletin_scene = this.kQr;
        if (bge.b(nVar, new String[0])) {
            this.kQq.brH.brJ = nVar.field_bulletin_scene;
            this.kQq.brH.content = nVar.field_bulletin_content;
            this.kQq.brH.url = nVar.field_bulletin_url;
        } else {
            v.i("MicroMsg.WalletGetBulletinEventListener", "not bulletin data ");
        }
        this.kQq.bpT.run();
        this.kQq = null;
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.WalletGetBulletinEventListener", "NetSceneGetBannerInfo resp,errType = " + i + ";errCode=" + i2);
        ak.vy().b(385, this);
        ak.yW();
        com.tencent.mm.model.c.vf().a(a.nrP, Long.valueOf(new Date().getTime()));
        bgj();
    }
}
