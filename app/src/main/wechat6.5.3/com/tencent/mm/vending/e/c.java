package com.tencent.mm.vending.e;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class c<_Target extends a> implements a, b<_Target> {
    private List<WeakReference<_Target>> phe = new ArrayList();
    private boolean phf = true;

    public final synchronized void a(_Target _Target) {
        if (this.phf) {
            this.phe.add(new WeakReference(_Target));
        } else {
            Assert.assertNotNull(_Target);
            _Target.dead();
        }
    }

    public final synchronized void dead() {
        if (this.phf) {
            for (WeakReference weakReference : this.phe) {
                a aVar = (a) weakReference.get();
                if (aVar != null) {
                    aVar.dead();
                }
            }
            this.phe.clear();
            this.phf = false;
        }
    }
}
