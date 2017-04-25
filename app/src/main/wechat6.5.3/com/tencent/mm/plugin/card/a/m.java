package com.tencent.mm.plugin.card.a;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mm.e.a.nb;
import com.tencent.mm.model.ak;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.card.b.e;
import com.tencent.mm.plugin.card.model.d;
import com.tencent.mm.plugin.card.model.i;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.q.a.a;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.v;

public final class m extends c<nb> {
    public m() {
        this.nhz = nb.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        nb nbVar = (nb) bVar;
        if (nbVar instanceof nb) {
            Object obj = nbVar.bop.bgD;
            long j = nbVar.bop.aYG;
            String str = nbVar.bop.bgE;
            d qo = e.qo(obj);
            if (qo == null) {
                v.e("ShareCardEventListener", "item == null");
            } else if (TextUtils.isEmpty(obj)) {
                v.e("ShareCardEventListener", "cardAppMsg is empty");
            } else {
                ak.yW();
                a dV = a.dV(com.tencent.mm.model.c.wJ().ek(j).field_content);
                if (dV != null) {
                    dV.cpm = e.a(qo);
                    dV.bgD = obj;
                    dV.cpn = qo.eCD;
                    dV.cpo = qo.bon;
                    dV.cpp = qo.eBL;
                    Bitmap a = j.a(new i(dV.thumburl));
                    l.a(dV, dV.appId, qo.eCD, str, null, a != null ? com.tencent.mm.sdk.platformtools.d.E(a) : null);
                    return true;
                }
            }
        }
        return false;
    }
}
