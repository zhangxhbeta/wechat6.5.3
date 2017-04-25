package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.tz;
import com.tencent.mm.protocal.c.ua;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class u extends k implements j {
    private final b cif;
    private e cii;

    public u() {
        a aVar = new a();
        aVar.czn = new tz();
        aVar.czo = new ua();
        aVar.uri = "/cgi-bin/micromsg-bin/getcardcount";
        aVar.czm = 663;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
    }

    public final int getType() {
        return 663;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneGetCardCount", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            ua uaVar = (ua) this.cif.czl.czs;
            v.i("MicroMsg.NetSceneGetCardCount", "has_card_item:" + uaVar.mwY + " has_share_card:" + uaVar.mwZ);
            if (uaVar.mwY > 0) {
                com.tencent.mm.plugin.card.b.j.acG();
                ak.yW();
                if (TextUtils.isEmpty((String) c.vf().get(t.a.npC, null))) {
                    af.aaj();
                    com.tencent.mm.plugin.card.a.b.iS(1);
                }
            }
            if (uaVar.mwZ > 0) {
                com.tencent.mm.plugin.card.b.j.acI();
                ak.yW();
                Long l = (Long) c.vf().get(t.a.npM, Long.valueOf(0));
                if (l != null && l.longValue() == 0) {
                    af.aar().aay();
                }
            }
        }
        ak.yW();
        c.vf().set(282882, Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
        this.cii.a(i2, i3, str, this);
    }
}
