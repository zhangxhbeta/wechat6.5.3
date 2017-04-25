package com.tencent.mm.ui.f;

import android.content.Context;
import com.tencent.mm.modelsearch.p;
import com.tencent.mm.modelsearch.p.h;
import com.tencent.mm.modelsearch.p.k;
import com.tencent.mm.modelsearch.p.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.f.f.a;
import com.tencent.mm.ui.f.f.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public abstract class c extends b implements k {
    public String bkC;
    public HashSet<String> cUR = new HashSet();
    public List<String> ezU = new LinkedList();
    private l lcS;
    public List<a> oPj = Collections.synchronizedList(new LinkedList());

    public abstract l a(ac acVar, HashSet<String> hashSet);

    public abstract com.tencent.mm.ui.f.a.a a(int i, a aVar);

    public abstract void a(List<h> list, HashSet<String> hashSet);

    public c(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    public final void a(String str, ac acVar, HashSet<String> hashSet) {
        bIJ();
        ua();
        this.bkC = str;
        this.lcS = a(acVar, (HashSet) hashSet);
    }

    public final void bIJ() {
        if (this.lcS != null) {
            p.a(this.lcS);
            this.lcS = null;
        }
    }

    public final int xY(int i) {
        int size = this.oPj.size();
        int i2 = 0;
        int i3 = i;
        while (i2 < size) {
            int i4;
            a aVar = (a) this.oPj.get(i2);
            aVar.oPn = i3;
            if (aVar.oPo) {
                i3++;
            }
            i3 += aVar.iHv.size() + aVar.oPr;
            aVar.oPp = i3;
            if (aVar.oPq) {
                i4 = i3 + 1;
            } else {
                i4 = i3;
            }
            i2++;
            i3 = i4;
        }
        return i3;
    }

    public final com.tencent.mm.ui.f.a.a pe(int i) {
        int size = this.oPj.size();
        for (int i2 = 0; i2 < size; i2++) {
            com.tencent.mm.ui.f.a.a bVar;
            a aVar = (a) this.oPj.get(i2);
            if (aVar.oPn == i && aVar.oPo) {
                bVar = new com.tencent.mm.ui.f.a.b(i);
            } else if (aVar.oPp == i && aVar.oPq) {
                bVar = new com.tencent.mm.ui.f.a.c(i);
                bVar.oPu = aVar.oPp - aVar.oPn;
            } else {
                v.d("MicroMsg.FTS.BaseNativeFTSUIUnit", "create Native Item: %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(aVar.iHv.size())});
                bVar = a(i, aVar);
            }
            if (bVar != null) {
                if (!aVar.oPq && bVar.position == aVar.oPp) {
                    bVar.oPt = true;
                }
                bVar.iHJ = boZ();
                bVar.bkC = this.bkC;
                bVar.iHC = aVar.cWS;
                return bVar;
            }
        }
        return null;
    }

    public final void ua() {
        this.bkC = null;
        this.cUR.clear();
        this.oPj.clear();
    }

    public final void a(l lVar, List<h> list, HashSet<String> hashSet, String[] strArr, String str) {
        int i = 0;
        v.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "search type %d | result %d", new Object[]{Integer.valueOf(getType()), Integer.valueOf(list.size())});
        if (this.bkC == null || !this.bkC.equals(str)) {
            v.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "Native Search: Not Same query origin:%s current:%s", new Object[]{str, this.bkC});
            return;
        }
        List arrayList = new ArrayList();
        if (strArr != null && strArr.length > 0) {
            while (i < strArr.length) {
                arrayList.add(strArr[i]);
                i++;
            }
        }
        this.ezU = arrayList;
        a((List) list, (HashSet) hashSet);
        this.cUR = hashSet;
        this.oPi.a(this, str);
    }

    public final void jI(String str) {
        v.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "onSearchError: type=%d | errorCode=%d | originQuery=%s", new Object[]{Integer.valueOf(getType()), Integer.valueOf(-1), str});
        if (str.equals(this.bkC)) {
            this.oPi.a(this, str);
        } else {
            v.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "Native Search: Not Same Query");
        }
    }

    public final LinkedList<Integer> bIK() {
        LinkedList<Integer> linkedList = new LinkedList();
        int size = this.oPj.size();
        for (int i = 0; i < size; i++) {
            a aVar = (a) this.oPj.get(i);
            if (aVar.oPn != Integer.MAX_VALUE) {
                linkedList.add(Integer.valueOf(aVar.oPn));
            }
        }
        return linkedList;
    }

    public com.tencent.mm.ui.f.a.a a(int i, h hVar, List<String> list) {
        return null;
    }
}
