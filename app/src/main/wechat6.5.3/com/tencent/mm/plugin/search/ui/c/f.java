package com.tencent.mm.plugin.search.ui.c;

import android.content.Context;
import com.tencent.mm.modelsearch.p;
import com.tencent.mm.modelsearch.p.d;
import com.tencent.mm.modelsearch.p.h;
import com.tencent.mm.modelsearch.p.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.f.c;
import com.tencent.mm.ui.f.f.a;
import com.tencent.mm.ui.f.f.b;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public final class f extends c {
    private Comparator<h> iJp = new d();

    public f(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    protected final l a(ac acVar, HashSet<String> hashSet) {
        return p.c(this.bkC, this.iJp, this, acVar, hashSet);
    }

    protected final void a(List<h> list, HashSet<String> hashSet) {
        if (com.tencent.mm.ui.f.b.cH(list)) {
            a aVar = new a();
            aVar.cWS = -6;
            aVar.ezU = this.ezU;
            aVar.iHv = list;
            this.oPj.add(aVar);
        }
    }

    protected final com.tencent.mm.ui.f.a.a a(int i, a aVar) {
        int i2 = (i - aVar.oPn) - 1;
        com.tencent.mm.ui.f.a.a aVar2 = null;
        if (i2 < aVar.iHv.size() && i2 >= 0) {
            aVar2 = a(i, (h) aVar.iHv.get(i2), aVar.ezU);
        }
        if (aVar2 != null) {
            aVar2.oPu = i2 + 1;
        }
        return aVar2;
    }

    public final int getType() {
        return 64;
    }

    public final com.tencent.mm.ui.f.a.a a(int i, h hVar, List<String> list) {
        com.tencent.mm.plugin.search.ui.a.c cVar = new com.tencent.mm.plugin.search.ui.a.c(i);
        cVar.eAt = hVar;
        cVar.ezU = list;
        return cVar;
    }
}
