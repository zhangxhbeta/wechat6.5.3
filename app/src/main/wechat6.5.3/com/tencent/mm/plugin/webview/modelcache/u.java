package com.tencent.mm.plugin.webview.modelcache;

import android.util.SparseArray;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;

public final class u {
    public final m lfY;
    public final SparseArray<o> lfZ;
    public final SparseArray<Boolean> lga;

    private static final class a {
        private static final u lgb = new u();
    }

    private u() {
        this.lfY = new m();
        this.lfZ = new SparseArray();
        this.lga = new SparseArray();
    }

    public static boolean a(String str, d dVar, int i) {
        m mVar = a.lgb.lfY;
        if (be.kS(str)) {
            return false;
        }
        WebResourceResponse b = mVar.b(str, str, dVar, i);
        if (b == null || b.getData() == null) {
            return false;
        }
        be.f(b.getData());
        return true;
    }

    public final void O(int i, boolean z) {
        this.lga.put(i, Boolean.valueOf(!z));
    }
}
