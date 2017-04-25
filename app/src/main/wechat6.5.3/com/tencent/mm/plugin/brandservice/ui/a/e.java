package com.tencent.mm.plugin.brandservice.ui.a;

import android.content.Context;
import com.tencent.mm.modelsearch.p;
import com.tencent.mm.modelsearch.p.b;
import com.tencent.mm.modelsearch.p.h;
import com.tencent.mm.modelsearch.p.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.f.c;
import com.tencent.mm.ui.f.f;
import com.tencent.mm.ui.f.f.a;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public final class e extends c {
    private Comparator<h> eAz = new b();

    public e(Context context, f.b bVar, int i) {
        super(context, bVar, i);
    }

    protected final l a(ac acVar, HashSet<String> hashSet) {
        return p.a(this.bkC, new int[]{131076}, 4, this.eAz, this, acVar, hashSet);
    }

    protected final void a(List<h> list, HashSet<String> hashSet) {
        if (cH(list)) {
            a aVar = new a();
            aVar.cWS = -7;
            aVar.ezU = this.ezU;
            aVar.iHv = list;
            if (aVar.iHv.size() > 3) {
                aVar.oPq = true;
                aVar.iHv = aVar.iHv.subList(0, 3);
            }
            this.oPj.add(aVar);
        }
    }

    protected final com.tencent.mm.ui.f.a.a a(int i, a aVar) {
        int i2 = (i - aVar.oPn) - 1;
        com.tencent.mm.ui.f.a.a aVar2 = null;
        if (i2 < aVar.iHv.size() && i2 >= 0) {
            h hVar = (h) aVar.iHv.get(i2);
            com.tencent.mm.ui.f.a.a a = a(i, hVar, aVar.ezU);
            a.dp(hVar.type, hVar.cWt);
            aVar2 = a;
        }
        if (aVar2 != null) {
            aVar2.oPu = i2 + 1;
        }
        return aVar2;
    }

    public final int getType() {
        return 96;
    }

    public final com.tencent.mm.ui.f.a.a a(int i, h hVar, List<String> list) {
        a aVar = new a(i);
        aVar.eAt = hVar;
        aVar.ezU = list;
        return aVar;
    }
}
