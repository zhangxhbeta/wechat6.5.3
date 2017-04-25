package com.tencent.mm.plugin.offline;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public abstract class a<T> {
    protected List<WeakReference<T>> hJH = new ArrayList();

    public final void aS(T t) {
        if (this.hJH != null) {
            this.hJH = new ArrayList();
        }
        if (t != null) {
            this.hJH.add(new WeakReference(t));
        }
    }

    public final void aT(T t) {
        if (this.hJH != null && t != null) {
            for (int i = 0; i < this.hJH.size(); i++) {
                WeakReference weakReference = (WeakReference) this.hJH.get(i);
                if (weakReference != null) {
                    Object obj = weakReference.get();
                    if (obj != null && obj.equals(t)) {
                        this.hJH.remove(obj);
                    }
                }
            }
        }
    }
}
