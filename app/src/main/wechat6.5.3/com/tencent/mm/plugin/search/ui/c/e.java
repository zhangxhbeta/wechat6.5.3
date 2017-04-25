package com.tencent.mm.plugin.search.ui.c;

import android.content.Context;
import com.tencent.mm.modelsearch.p;
import com.tencent.mm.modelsearch.p.b;
import com.tencent.mm.modelsearch.p.h;
import com.tencent.mm.modelsearch.p.l;
import com.tencent.mm.plugin.search.a.i;
import com.tencent.mm.plugin.search.ui.a.j;
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
        if (i.aMj().searchMode == 1) {
            return p.a(this.bkC, aMO(), 3, this.eAz, this, acVar, hashSet);
        }
        return p.a(this.bkC, aMO(), 3, hashSet, this.eAz, this, acVar);
    }

    protected final void a(List<h> list, HashSet<String> hashSet) {
        a aVar = new a();
        aVar.cWS = -4;
        aVar.iHv = list;
        aVar.oPo = com.tencent.mm.ui.f.b.cH(list);
        aVar.ezU = this.ezU;
        if (aVar.iHv.size() > 3) {
            aVar.oPq = true;
            aVar.iHv = aVar.iHv.subList(0, 3);
        }
        if (com.tencent.mm.ui.f.b.cH(list)) {
            this.oPj.add(aVar);
        }
    }

    private static int[] aMO() {
        return new int[]{131072};
    }

    protected final com.tencent.mm.ui.f.a.a a(int i, a aVar) {
        com.tencent.mm.ui.f.a.a aVar2;
        int i2 = 0;
        if (aVar.oPo) {
            int i3 = (i - aVar.oPn) - 1;
            if (i3 >= aVar.iHv.size() || i3 < 0) {
                i2 = i3;
                aVar2 = null;
            } else {
                h hVar = (h) aVar.iHv.get(i3);
                com.tencent.mm.ui.f.a.a a = a(i, hVar, aVar.ezU);
                a.dp(hVar.type, hVar.cWt);
                i2 = i3;
                aVar2 = a;
            }
        } else {
            aVar2 = null;
        }
        if (aVar2 != null) {
            aVar2.oPu = i2 + 1;
        }
        return aVar2;
    }

    public final int getType() {
        return 32;
    }

    public final com.tencent.mm.ui.f.a.a a(int i, h hVar, List<String> list) {
        if (hVar.type == 131072) {
            j jVar = new j(i);
            jVar.eAt = hVar;
            jVar.ezU = list;
            return jVar;
        } else if (hVar.type != 131073 && hVar.type != 131074) {
            return null;
        } else {
            com.tencent.mm.ui.f.a.a fVar = new com.tencent.mm.plugin.search.ui.a.f(i);
            fVar.eAt = hVar;
            fVar.ezU = list;
            return fVar;
        }
    }
}
