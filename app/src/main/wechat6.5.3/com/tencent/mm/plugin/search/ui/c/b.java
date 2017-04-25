package com.tencent.mm.plugin.search.ui.c;

import android.content.Context;
import com.tencent.mm.modelsearch.p;
import com.tencent.mm.modelsearch.p.h;
import com.tencent.mm.modelsearch.p.l;
import com.tencent.mm.plugin.search.ui.a.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.f.c;
import com.tencent.mm.ui.f.f.a;
import java.util.HashSet;
import java.util.List;

public final class b extends c {
    public b(Context context, com.tencent.mm.ui.f.f.b bVar, int i) {
        super(context, bVar, i);
    }

    protected final l a(ac acVar, HashSet<String> hashSet) {
        return p.a(this.bkC, -1, hashSet, this, acVar);
    }

    protected final void a(List<h> list, HashSet<String> hashSet) {
        if (com.tencent.mm.ui.f.b.cH(list)) {
            a aVar = new a();
            aVar.cWS = -3;
            aVar.iHv = list;
            aVar.ezU = this.ezU;
            aVar.oPq = false;
            this.oPj.add(aVar);
        }
    }

    protected final com.tencent.mm.ui.f.a.a a(int i, a aVar) {
        int i2 = (i - aVar.oPn) - 1;
        com.tencent.mm.ui.f.a.a aVar2 = null;
        if (i2 < aVar.iHv.size() && i2 >= 0) {
            h hVar = (h) aVar.iHv.get(i2);
            i iVar = new i(i);
            iVar.eAt = hVar;
            iVar.ezU = aVar.ezU;
            iVar.dp(hVar.type, hVar.cWt);
            aVar2 = iVar;
        }
        if (aVar2 != null) {
            aVar2.oPu = i2 + 1;
        }
        return aVar2;
    }

    public final int getType() {
        return 4128;
    }
}
