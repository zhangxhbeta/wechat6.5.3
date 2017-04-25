package com.tencent.mm.plugin.search.ui;

import com.tencent.mm.modelsearch.p;
import com.tencent.mm.modelsearch.p.f;
import com.tencent.mm.modelsearch.p.h;
import com.tencent.mm.modelsearch.p.k;
import com.tencent.mm.modelsearch.p.l;
import com.tencent.mm.plugin.search.ui.a.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.f.a.a;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public final class g extends b implements k {
    private String bdo;
    private ac eFT = new ac();
    private List<String> ezU;
    private Comparator<h> iHu = new f();
    private List<h> iHv;

    public g(c cVar, String str) {
        super(cVar);
        this.bdo = str;
    }

    protected final a pe(int i) {
        a hVar;
        if (i == 0) {
            hVar = new com.tencent.mm.plugin.search.ui.a.h(i);
            hVar.count = getCount() - 1;
            hVar.imS = false;
        } else {
            e eVar = new e(i);
            eVar.eAt = (h) this.iHv.get(i - 1);
            eVar.ezU = this.ezU;
            hVar = eVar;
        }
        hVar.iHC = -12;
        hVar.bkC = this.bkC;
        hVar.oJg = i;
        if (hVar.position == getCount() - 1) {
            hVar.oPt = true;
        }
        return hVar;
    }

    protected final void aMm() {
        p.a(this.bkC, this.bdo, this.iHu, this, this.eFT);
    }

    protected final boolean a(a aVar) {
        return false;
    }

    public final void a(l lVar, List<h> list, HashSet<String> hashSet, String[] strArr, String str) {
        this.iHv = list;
        this.ezU = be.g(strArr);
        pf(list.size() + 1);
        notifyDataSetChanged();
    }

    public final void jI(String str) {
        pf(1);
        notifyDataSetChanged();
    }
}
