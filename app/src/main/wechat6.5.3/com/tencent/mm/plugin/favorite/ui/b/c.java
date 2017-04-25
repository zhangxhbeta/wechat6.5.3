package com.tencent.mm.plugin.favorite.ui.b;

import android.content.Context;
import com.tencent.mm.modelsearch.p;
import com.tencent.mm.modelsearch.p.h;
import com.tencent.mm.modelsearch.p.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.f.f.a;
import com.tencent.mm.ui.f.f.b;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public final class c extends com.tencent.mm.ui.f.c {
    private Comparator<h> fSk = new com.tencent.mm.modelsearch.p.c();

    public c(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    protected final l a(ac acVar, HashSet<String> hashSet) {
        return p.b(this.bkC, this.fSk, this, acVar, hashSet);
    }

    protected final void a(List<h> list, HashSet<String> hashSet) {
        if (com.tencent.mm.ui.f.b.cH(list)) {
            a aVar = new a();
            aVar.cWS = -1;
            aVar.ezU = this.ezU;
            aVar.iHv = list;
            this.oPj.add(aVar);
        }
    }

    protected final com.tencent.mm.ui.f.a.a a(int i, a aVar) {
        int i2 = (i - aVar.oPn) - 1;
        com.tencent.mm.ui.f.a.a aVar2 = null;
        if (i2 < aVar.iHv.size() && i2 >= 0) {
            h hVar = (h) aVar.iHv.get(i2);
            a aVar3 = new a(i);
            aVar3.eAt = hVar;
            aVar3.ezU = aVar.ezU;
            aVar2 = aVar3;
        }
        if (aVar2 != null) {
            aVar2.oPu = i2 + 1;
        }
        return aVar2;
    }

    public final int getType() {
        return 4176;
    }
}
