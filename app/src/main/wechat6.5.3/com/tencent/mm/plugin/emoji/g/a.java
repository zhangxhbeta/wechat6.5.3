package com.tencent.mm.plugin.emoji.g;

import com.tencent.mm.plugin.emoji.g.b.b;
import com.tencent.mm.plugin.emoji.g.b.c;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public final class a<T extends e> {
    public c feA;

    public enum a {
        Default,
        Syncing,
        PauseSync,
        PauseSyncOffline,
        PauseSyncSDCardFull,
        FinishSync
    }

    public a() {
        com.tencent.mm.plugin.emoji.g.b.a aVar = new com.tencent.mm.plugin.emoji.g.b.a();
        aVar.feK = new b(aVar.feI, aVar.feI, TimeUnit.MILLISECONDS, new com.tencent.mm.ae.a.e.a(), new c(aVar.cOW, "bkg_loader_"));
        a(new b(aVar));
    }

    private synchronized void a(b bVar) {
        if (this.feA == null) {
            this.feA = new c(bVar);
        } else {
            v.i("MicroMsg.BKGLoader.BKGLoader", "[cpan] BKGLoader had init.");
        }
    }

    public final void w(ArrayList<e> arrayList) {
        c cVar = this.feA;
        cVar.feN = false;
        if (cVar.feW == null) {
            cVar.feW = new Vector();
        }
        if (arrayList.size() > 0) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                e eVar = (e) arrayList.get(i);
                if (eVar == null || cVar.feW.contains(eVar)) {
                    v.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is has exist.:%s", new Object[]{eVar.getKey()});
                } else {
                    cVar.feW.add(eVar);
                }
            }
        }
    }

    public final void x(ArrayList<e> arrayList) {
        c cVar = this.feA;
        if (cVar.feY == null) {
            cVar.feY = new Vector();
        }
        if (arrayList.size() > 0) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                e eVar = (e) arrayList.get(i);
                String str;
                String str2;
                Object[] objArr;
                if (cVar.feU != null && cVar.feU.equals(eVar)) {
                    str = "MicroMsg.BKGLoader.BKGLoaderManager";
                    str2 = "[cpan] currentTask equals task is has exist:%s";
                    objArr = new Object[1];
                    objArr[0] = eVar == null ? "task is null" : eVar.getKey();
                    v.i(str, str2, objArr);
                } else if (eVar == null || cVar.feY.contains(eVar)) {
                    str = "MicroMsg.BKGLoader.BKGLoaderManager";
                    str2 = "[cpan] task is has exist:%s";
                    objArr = new Object[1];
                    objArr[0] = eVar == null ? "task is null" : eVar.getKey();
                    v.i(str, str2, objArr);
                } else {
                    cVar.feY.add(eVar);
                }
            }
        }
    }

    public final a afT() {
        c cVar = this.feA;
        if (cVar.feO && cVar.feT) {
            return a.PauseSyncSDCardFull;
        }
        if (c.aeT() && !cVar.feO && g.afx().fch.bxQ() > 0) {
            return a.PauseSync;
        }
        if (!ak.isConnected(aa.getContext()) && !cVar.feO && g.afx().fch.bxQ() > 0) {
            return a.PauseSyncOffline;
        }
        if (ak.isConnected(aa.getContext())) {
            if (cVar.feO && cVar.dMT) {
                return a.Syncing;
            }
            if (cVar.feR) {
                return a.FinishSync;
            }
        }
        return a.Default;
    }

    public final void cu(boolean z) {
        this.feA.dMT = z;
    }
}
