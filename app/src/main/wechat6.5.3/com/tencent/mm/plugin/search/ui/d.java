package com.tencent.mm.plugin.search.ui;

import com.tencent.mm.modelsearch.p;
import com.tencent.mm.modelsearch.p.f;
import com.tencent.mm.modelsearch.p.h;
import com.tencent.mm.modelsearch.p.k;
import com.tencent.mm.modelsearch.p.l;
import com.tencent.mm.plugin.search.ui.a.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.f.a.a;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public final class d extends b implements k {
    private String bdo;
    private ac eFT = new ac();
    private List<String> ezU;
    private Comparator<h> iHu = new f();
    private List<h> iHv;

    public d(c cVar, String str) {
        super(cVar);
        this.bdo = str;
    }

    protected final a pe(int i) {
        e eVar = new e(i);
        eVar.eAt = (h) this.iHv.get(i);
        eVar.ezU = this.ezU;
        eVar.iHC = -12;
        eVar.bkC = this.bkC;
        eVar.oJg = i;
        if (eVar.position == getCount() - 1) {
            eVar.oPt = true;
        }
        return eVar;
    }

    protected final void aMm() {
        p.a(this.bkC, this.bdo, this.iHu, this, this.eFT);
        v.i("MicroMSsg.FTS.FTSChattingTalkerAdapter", "do search %s", new Object[]{this.bkC});
    }

    public final void a(l lVar, List<h> list, HashSet<String> hashSet, String[] strArr, String str) {
        this.iHv = list;
        this.ezU = be.g(strArr);
        pf(list.size());
        notifyDataSetChanged();
        D(getCount(), true);
    }

    public final void jI(String str) {
        pf(0);
        notifyDataSetChanged();
        D(getCount(), true);
    }

    protected final boolean a(a aVar) {
        return false;
    }
}
