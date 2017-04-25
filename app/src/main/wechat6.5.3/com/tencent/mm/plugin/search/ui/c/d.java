package com.tencent.mm.plugin.search.ui.c;

import android.content.Context;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsearch.p;
import com.tencent.mm.modelsearch.p.b;
import com.tencent.mm.modelsearch.p.h;
import com.tencent.mm.modelsearch.p.l;
import com.tencent.mm.plugin.search.ui.a.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.f.c;
import com.tencent.mm.ui.f.f;
import com.tencent.mm.ui.f.f.a;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public final class d extends c {
    private Comparator<h> eAz = new b();
    private boolean iJm = false;

    public d(Context context, f.b bVar, int i) {
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
        return p.a(this.bkC, this.iJm ? new int[]{131072, 131073, 131074} : new int[]{131072}, 0, this.eAz, this, acVar);
    }

    protected final void a(List<h> list, HashSet<String> hashSet) {
        if (com.tencent.mm.ui.f.b.cH(list)) {
            a aVar = new a();
            aVar.cWS = -4;
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
            j jVar = new j(i);
            jVar.eAt = hVar;
            jVar.ezU = aVar.ezU;
            jVar.dp(hVar.type, hVar.cWt);
            aVar2 = jVar;
        }
        if (aVar2 != null) {
            aVar2.oPu = i2 + 1;
        }
        return aVar2;
    }

    public final int getType() {
        return 4112;
    }
}
