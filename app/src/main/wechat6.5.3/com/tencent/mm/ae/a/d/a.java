package com.tencent.mm.ae.a.d;

import com.tencent.mm.a.f;
import java.util.Map;

public final class a<K, V> {
    private f<K, V> cPX;

    public a(int i) {
        this.cPX = new f(i);
    }

    public final void clear() {
        if (this.cPX == null) {
            throw new NullPointerException("mData == null");
        }
        this.cPX.trimToSize(-1);
    }

    public final V get(K k) {
        if (this.cPX != null) {
            return this.cPX.get(k);
        }
        throw new NullPointerException("mData == null");
    }

    public final V put(K k, V v) {
        if (this.cPX != null) {
            return this.cPX.put(k, v);
        }
        throw new NullPointerException("mData == null");
    }

    public final synchronized Map<K, V> snapshot() {
        if (this.cPX == null) {
            throw new NullPointerException("mData == null");
        }
        return this.cPX.snapshot();
    }

    public final synchronized String toString() {
        if (this.cPX == null) {
            throw new NullPointerException("mData == null");
        }
        return this.cPX.toString();
    }
}
