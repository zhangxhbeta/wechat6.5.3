package com.tencent.mm.a;

import com.tencent.mm.sdk.platformtools.x;

public class f<K, O> extends x<K, O> {
    private b<K, O> aPP = null;

    public interface a<K, O> {
    }

    public interface b<K, O> {
        void l(K k, O o);
    }

    public f(int i) {
        super(i);
    }

    public final void k(K k, O o) {
        if (o != null) {
            put(k, o);
        }
    }

    public void clear() {
        super.trimToSize(-1);
    }

    public f(int i, b<K, O> bVar) {
        super(i);
        this.aPP = bVar;
    }

    public final void trimToSize(int i) {
        super.trimToSize(i);
    }

    protected final O create(K k) {
        return super.create(k);
    }

    public void entryRemoved(boolean z, K k, O o, O o2) {
        super.entryRemoved(z, k, o, o2);
        if (this.aPP != null && o2 == null) {
            this.aPP.l(k, o);
        }
    }

    public int sizeOf(K k, O o) {
        return super.sizeOf(k, o);
    }

    public void a(a<K, O> aVar) {
        clear();
    }
}
