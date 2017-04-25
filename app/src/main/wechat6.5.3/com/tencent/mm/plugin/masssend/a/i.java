package com.tencent.mm.plugin.masssend.a;

import com.tencent.mm.e.a.pv;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.ali;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.v;
import java.util.List;

public final class i extends c<pv> {
    public i() {
        this.nhz = pv.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        List list = ((pv) bVar).bre.brf;
        if (list == null || list.size() <= 0) {
            v.e("MicroMsg.UpdateMassSendPlaceTopListener", "empty mass send top config package");
        } else {
            byte[] a = m.a(((ali) list.get(0)).mcO);
            if (!(a == null || a.length == 0)) {
                String str = new String(a);
                v.i("MicroMsg.UpdateMassSendPlaceTopListener", "MassSendTopConfXml:" + str);
                h.azg().wl(str);
            }
        }
        return false;
    }
}
