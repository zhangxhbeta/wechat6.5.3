package com.tencent.mm.plugin.exdevice.f.b;

import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;
import junit.framework.Assert;

public final class a {
    SparseArray<WeakReference<e>> fwH;

    public final void a(e eVar) {
        Assert.assertTrue(eVar != null);
        if (this.fwH == null) {
            this.fwH = new SparseArray();
        }
        this.fwH.put(eVar.hashCode(), new WeakReference(eVar));
    }

    public final void b(e eVar) {
        Assert.assertTrue(eVar != null);
        if (this.fwH == null) {
            v.d("MicroMsg.ExdeviceRankCallbackManager", "hy: callback pool is null. abort ");
        } else {
            this.fwH.remove(eVar.hashCode());
        }
    }

    public final void a(String str, d dVar) {
        Assert.assertTrue(true);
        if (this.fwH == null) {
            v.d("MicroMsg.ExdeviceRankCallbackManager", "hy: callback pool is null. abort");
            return;
        }
        for (int i = 0; i < this.fwH.size(); i++) {
            e eVar = (e) ((WeakReference) this.fwH.get(this.fwH.keyAt(i))).get();
            if (eVar != null) {
                eVar.b(str, dVar);
            }
        }
        v.d("MicroMsg.ExdeviceRankCallbackManager", "hy: publish end");
    }
}
