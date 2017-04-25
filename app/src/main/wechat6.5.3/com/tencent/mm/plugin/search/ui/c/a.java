package com.tencent.mm.plugin.search.ui.c;

import android.content.Context;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.modelsearch.FTSUtils;
import com.tencent.mm.modelsearch.d;
import com.tencent.mm.modelsearch.p;
import com.tencent.mm.modelsearch.p.b;
import com.tencent.mm.modelsearch.p.h;
import com.tencent.mm.modelsearch.p.l;
import com.tencent.mm.plugin.search.ui.a.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.f.c;
import com.tencent.mm.ui.f.f;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class a extends c {
    private Comparator<h> eAz = new b();
    private boolean iJm;
    private boolean iJn;
    private boolean iJo;

    public a(Context context, f.b bVar, int i) {
        super(context, bVar, i);
        ak.yW();
        String str = (String) com.tencent.mm.model.c.vf().get(6, null);
        boolean z = str != null && str.length() > 0;
        this.iJm = z;
        ak.yW();
        if (be.f((Integer) com.tencent.mm.model.c.vf().get(9, null)) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z && (k.xQ() & 4096) == 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            this.iJn = true;
        }
        this.iJo = false;
        v.d("MicroMsg.FTS.FTSAddFriendUIUnit", "[FTSAddFriendUIUnit doSearchMobile : %s, doSearchQQ : %s, doSearchGoogle : %s]", new Object[]{Boolean.valueOf(this.iJm), Boolean.valueOf(this.iJn), Boolean.valueOf(this.iJo)});
    }

    protected final l a(ac acVar, HashSet<String> hashSet) {
        String str = this.bkC;
        ArrayList arrayList = new ArrayList();
        if (this.iJm) {
            arrayList.add(Integer.valueOf(131073));
            arrayList.add(Integer.valueOf(131074));
        }
        if (this.iJn) {
            arrayList.add(Integer.valueOf(131077));
            arrayList.add(Integer.valueOf(131078));
        }
        if (this.iJo) {
            arrayList.add(Integer.valueOf(131079));
            arrayList.add(Integer.valueOf(131080));
        }
        int[] iArr = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            iArr[i] = ((Integer) arrayList.get(i)).intValue();
        }
        return p.a(str, iArr, aMN(), this.eAz, this, acVar);
    }

    private int[] aMN() {
        ArrayList arrayList = new ArrayList();
        if (this.iJm) {
            arrayList.add(Integer.valueOf(16));
        }
        if (this.iJn) {
            arrayList.add(Integer.valueOf(25));
        }
        if (this.iJo) {
            arrayList.add(Integer.valueOf(26));
            arrayList.add(Integer.valueOf(27));
            arrayList.add(Integer.valueOf(28));
        }
        int[] iArr = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            iArr[i] = ((Integer) arrayList.get(i)).intValue();
        }
        return iArr;
    }

    protected final void a(List<h> list, HashSet<String> hashSet) {
        this.oPj.clear();
        com.tencent.mm.ui.f.f.a aVar = new com.tencent.mm.ui.f.f.a();
        aVar.cWS = -4;
        aVar.oPo = false;
        aVar.ezU = this.ezU;
        aVar.oPr = 1;
        aVar.iHv = new LinkedList();
        this.oPj.add(aVar);
        if (com.tencent.mm.ui.f.b.cH(list)) {
            com.tencent.mm.ui.f.f.a aVar2;
            List a = FTSUtils.a(list, d.cVs, 131073, 131074);
            if (com.tencent.mm.ui.f.b.cH(a)) {
                aVar2 = new com.tencent.mm.ui.f.f.a();
                aVar2.cWS = -11;
                aVar2.iHv = a;
                aVar2.ezU = this.ezU;
                this.oPj.add(aVar2);
            }
            a = FTSUtils.a(list, d.cVs, 131077, 131078);
            if (com.tencent.mm.ui.f.b.cH(a)) {
                aVar2 = new com.tencent.mm.ui.f.f.a();
                aVar2.cWS = -10;
                aVar2.iHv = a;
                aVar2.ezU = this.ezU;
                this.oPj.add(aVar2);
            }
            a = FTSUtils.a(list, d.cVs, 131079, 131080);
            if (com.tencent.mm.ui.f.b.cH(a)) {
                aVar2 = new com.tencent.mm.ui.f.f.a();
                aVar2.cWS = -9;
                aVar2.iHv = a;
                aVar2.ezU = this.ezU;
                this.oPj.add(aVar2);
            }
        }
    }

    protected final com.tencent.mm.ui.f.a.a a(int i, com.tencent.mm.ui.f.f.a aVar) {
        int i2 = (i - aVar.oPn) - 1;
        com.tencent.mm.ui.f.a.a aVar2 = null;
        if (i2 < aVar.iHv.size() && i2 >= 0) {
            h hVar = (h) aVar.iHv.get(i2);
            if (hVar.type == 131077 || hVar.type == 131078) {
                aVar2 = new g(i);
                aVar2.eAt = hVar;
                aVar2.ezU = aVar.ezU;
                aVar2.iJa = true;
            } else if (hVar.type == 131079 || hVar.type == 131080) {
                aVar2 = new com.tencent.mm.plugin.search.ui.a.d(i);
                aVar2.eAt = hVar;
                aVar2.ezU = aVar.ezU;
            } else {
                com.tencent.mm.ui.f.a.a aVar3;
                if (hVar.type == 131073 || hVar.type == 131074) {
                    com.tencent.mm.plugin.search.ui.a.f fVar = new com.tencent.mm.plugin.search.ui.a.f(i);
                    fVar.eAt = hVar;
                    fVar.ezU = aVar.ezU;
                    fVar.iJa = true;
                    aVar3 = fVar;
                } else {
                    aVar3 = null;
                }
                aVar2 = aVar3;
            }
        } else if (!aVar.oPo && i == 0) {
            aVar2 = new com.tencent.mm.plugin.search.ui.a.a(i);
            aVar2.ezU = this.ezU;
        }
        if (aVar2 != null) {
            aVar2.oPu = i2 + 1;
        }
        return aVar2;
    }

    public final int getType() {
        return 8192;
    }
}
