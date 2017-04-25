package com.tencent.mm.plugin.card.a;

import com.tencent.mm.e.a.gy;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.card.model.aa;
import com.tencent.mm.plugin.card.model.d;
import com.tencent.mm.q.a.a;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.storage.at;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class l extends c<gy> implements e {
    private long aYG;

    public l() {
        this.aYG = 0;
        this.nhz = gy.class.getName().hashCode();
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof aa) {
            String str2 = ((aa) kVar).bom;
            ak.yW();
            at ek = com.tencent.mm.model.c.wJ().ek(this.aYG);
            if (i == 0 && i2 == 0) {
                ek.dh(2);
            } else {
                ek.dh(5);
            }
            a dV = a.dV(ek.field_content);
            d qo = com.tencent.mm.plugin.card.b.e.qo(ek.field_content);
            qo.bom = str2;
            dV.cpm = com.tencent.mm.plugin.card.b.e.a(qo);
            dV.bgD = a.b(dV);
            ek.setContent(a.b(dV));
            ak.yW();
            com.tencent.mm.model.c.wJ().a(this.aYG, ek);
            ak.vy().b(652, this);
        }
    }

    private boolean a(gy gyVar) {
        if (!(gyVar instanceof gy)) {
            return false;
        }
        String str = gyVar.bgC.bgD;
        this.aYG = gyVar.bgC.aYG;
        String str2 = gyVar.bgC.bgE;
        d qo = com.tencent.mm.plugin.card.b.e.qo(str);
        ak.yW();
        at ek = com.tencent.mm.model.c.wJ().ek(this.aYG);
        ek.dh(1);
        ak.yW();
        com.tencent.mm.model.c.wJ().a(this.aYG, ek);
        if (qo == null) {
            qo = com.tencent.mm.plugin.card.b.e.qo(ek.field_content);
        }
        if (qo == null) {
            return true;
        }
        ak.vy().a(652, this);
        ak.vy().a(new aa(qo.bol, str2, 17), 0);
        return true;
    }
}
