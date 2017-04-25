package com.tencent.mm.plugin.search.ui.c;

import android.content.Context;
import com.tencent.mm.modelsearch.p;
import com.tencent.mm.modelsearch.p.b;
import com.tencent.mm.modelsearch.p.h;
import com.tencent.mm.modelsearch.p.l;
import com.tencent.mm.plugin.search.a.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.f.f;
import com.tencent.mm.ui.f.f.a;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public final class c extends com.tencent.mm.ui.f.c {
    private Comparator<h> eAz = new b();

    public c(Context context, f.b bVar, int i) {
        super(context, bVar, i);
    }

    protected final l a(ac acVar, HashSet<String> hashSet) {
        if (i.aMj().searchMode != 1) {
            return p.a(this.bkC, 3, hashSet, this, acVar);
        }
        return p.a(this.bkC, new int[]{131075}, 3, this.eAz, this, acVar, hashSet);
    }

    protected final void a(List<h> list, HashSet<String> hashSet) {
        if (com.tencent.mm.ui.f.b.cH(list)) {
            a aVar = new a();
            aVar.iHv = list;
            aVar.cWS = -3;
            aVar.ezU = this.ezU;
            if (aVar.iHv.size() > 3) {
                aVar.oPq = true;
                aVar.iHv = aVar.iHv.subList(0, 3);
            }
            this.oPj.add(aVar);
        }
    }

    protected final com.tencent.mm.ui.f.a.a a(int i, a aVar) {
        com.tencent.mm.ui.f.a.a aVar2;
        int i2 = (i - aVar.oPn) - 1;
        if (i2 < aVar.iHv.size() && i2 >= 0) {
            h hVar = (h) aVar.iHv.get(i2);
            if (hVar.type == 131075) {
                com.tencent.mm.ui.f.a.a a = a(i, hVar, aVar.ezU);
                a.dp(hVar.type, hVar.cWt);
                aVar2 = a;
                if (aVar2 != null) {
                    aVar2.oPu = i2 + 1;
                }
                return aVar2;
            }
        }
        aVar2 = null;
        if (aVar2 != null) {
            aVar2.oPu = i2 + 1;
        }
        return aVar2;
    }

    public final int getType() {
        return 48;
    }

    public final com.tencent.mm.ui.f.a.a a(int i, h hVar, List<String> list) {
        com.tencent.mm.plugin.search.ui.a.i iVar = new com.tencent.mm.plugin.search.ui.a.i(i);
        iVar.eAt = hVar;
        iVar.ezU = list;
        return iVar;
    }
}
