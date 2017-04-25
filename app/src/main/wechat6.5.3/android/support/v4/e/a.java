package android.support.v4.e;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a<K, V> extends i<K, V> implements Map<K, V> {
    g<K, V> vv;

    private g<K, V> bD() {
        if (this.vv == null) {
            this.vv = new g<K, V>(this) {
                final /* synthetic */ a vw;

                {
                    this.vw = r1;
                }

                protected final int bE() {
                    return this.vw.hO;
                }

                protected final Object j(int i, int i2) {
                    return this.vw.vU[(i << 1) + i2];
                }

                protected final int g(Object obj) {
                    return this.vw.indexOfKey(obj);
                }

                protected final int h(Object obj) {
                    return this.vw.indexOfValue(obj);
                }

                protected final Map<K, V> bF() {
                    return this.vw;
                }

                protected final void c(K k, V v) {
                    this.vw.put(k, v);
                }

                protected final V a(int i, V v) {
                    return this.vw.setValueAt(i, v);
                }

                protected final void P(int i) {
                    this.vw.removeAt(i);
                }

                protected final void bG() {
                    this.vw.clear();
                }
            };
        }
        return this.vv;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        int size = this.hO + map.size();
        if (this.vT.length < size) {
            Object obj = this.vT;
            Object obj2 = this.vU;
            super.U(size);
            if (this.hO > 0) {
                System.arraycopy(obj, 0, this.vT, 0, this.hO);
                System.arraycopy(obj2, 0, this.vU, 0, this.hO << 1);
            }
            i.a(obj, obj2, this.hO);
        }
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Set<Entry<K, V>> entrySet() {
        g bD = bD();
        if (bD.vF == null) {
            bD.vF = new b(bD);
        }
        return bD.vF;
    }

    public Set<K> keySet() {
        g bD = bD();
        if (bD.vG == null) {
            bD.vG = new c(bD);
        }
        return bD.vG;
    }

    public Collection<V> values() {
        g bD = bD();
        if (bD.vH == null) {
            bD.vH = new e(bD);
        }
        return bD.vH;
    }
}
