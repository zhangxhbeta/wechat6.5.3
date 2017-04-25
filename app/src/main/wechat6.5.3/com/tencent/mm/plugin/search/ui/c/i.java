package com.tencent.mm.plugin.search.ui.c;

import android.content.Context;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsearch.p;
import com.tencent.mm.modelsearch.p.h;
import com.tencent.mm.modelsearch.p.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.f.c;
import com.tencent.mm.ui.f.e;
import com.tencent.mm.ui.f.f.a;
import com.tencent.mm.ui.f.f.b;
import java.util.HashSet;
import java.util.List;

public final class i extends c {
    private boolean iJm = false;

    public i(Context context, b bVar, int i) {
        boolean z;
        super(context, bVar, i);
        ak.yW();
        String str = (String) com.tencent.mm.model.c.vf().get(6, null);
        if (str == null || str.length() <= 0) {
            z = false;
        } else {
            z = true;
        }
        this.iJm = z;
        this.iJm &= be.He();
    }

    protected final l a(ac acVar, HashSet<String> hashSet) {
        return p.a(this.bkC, this.iJm ? new int[]{131072, 131075, 131073, 131074, 262144, 131076} : new int[]{131072, 131075, 262144, 131076}, this, acVar, 0, hashSet);
    }

    protected final void a(List<h> list, HashSet<String> hashSet) {
        for (h hVar : list) {
            hashSet.add(hVar.cWv);
        }
        if (com.tencent.mm.ui.f.b.cH(list)) {
            a aVar = new a();
            aVar.cWS = -8;
            if (com.tencent.mm.ui.f.b.cH(list) && list.size() > 3) {
                list = list.subList(0, 3);
            }
            aVar.iHv = list;
            aVar.oPq = false;
            aVar.ezU = this.ezU;
            this.oPj.add(aVar);
        }
    }

    protected final com.tencent.mm.ui.f.a.a a(int i, a aVar) {
        com.tencent.mm.ui.f.a.a a;
        int i2 = (i - aVar.oPn) - 1;
        if (i2 < aVar.iHv.size() && i2 >= 0) {
            h hVar = (h) aVar.iHv.get(i2);
            c cVar = hVar.type == 131075 ? (c) e.a(48, this.context, this.oPi, boZ()) : (hVar.type == 131072 || hVar.type == 131073 || hVar.type == 131074) ? (c) e.a(32, this.context, this.oPi, boZ()) : hVar.type == 262144 ? (c) e.a(64, this.context, this.oPi, boZ()) : hVar.type == 131076 ? (c) e.a(96, this.context, this.oPi, boZ()) : null;
            if (cVar != null) {
                a = cVar.a(i, hVar, aVar.ezU);
                if (a != null) {
                    a.oPu = i2 + 1;
                }
                return a;
            }
        }
        a = null;
        if (a != null) {
            a.oPu = i2 + 1;
        }
        return a;
    }

    public final int getType() {
        return 16;
    }
}
