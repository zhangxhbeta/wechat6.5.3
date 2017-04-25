package com.google.android.gms.c;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class m<K, V> extends q<K, V> implements Map<K, V> {
    p<K, V> ayl;

    private p<K, V> kO() {
        if (this.ayl == null) {
            this.ayl = new p<K, V>(this) {
                final /* synthetic */ m aym;

                {
                    this.aym = r1;
                }

                protected final void P(int i) {
                    this.aym.removeAt(i);
                }

                protected final V a(int i, V v) {
                    q qVar = this.aym;
                    int i2 = (i << 1) + 1;
                    V v2 = qVar.vU[i2];
                    qVar.vU[i2] = v;
                    return v2;
                }

                protected final int bE() {
                    return this.aym.hO;
                }

                protected final Map<K, V> bF() {
                    return this.aym;
                }

                protected final void bG() {
                    this.aym.clear();
                }

                protected final void c(K k, V v) {
                    this.aym.put(k, v);
                }

                protected final int g(Object obj) {
                    return obj == null ? this.aym.bK() : this.aym.indexOf(obj, obj.hashCode());
                }

                protected final int h(Object obj) {
                    return this.aym.indexOfValue(obj);
                }

                protected final Object j(int i, int i2) {
                    return this.aym.vU[(i << 1) + i2];
                }
            };
        }
        return this.ayl;
    }

    public Set<Entry<K, V>> entrySet() {
        p kO = kO();
        if (kO.ayt == null) {
            kO.ayt = new b(kO);
        }
        return kO.ayt;
    }

    public Set<K> keySet() {
        p kO = kO();
        if (kO.ayu == null) {
            kO.ayu = new c(kO);
        }
        return kO.ayu;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        int size = this.hO + map.size();
        if (this.vT.length < size) {
            Object obj = this.vT;
            Object obj2 = this.vU;
            super.bO(size);
            if (this.hO > 0) {
                System.arraycopy(obj, 0, this.vT, 0, this.hO);
                System.arraycopy(obj2, 0, this.vU, 0, this.hO << 1);
            }
            q.b(obj, obj2, this.hO);
        }
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Collection<V> values() {
        p kO = kO();
        if (kO.ayv == null) {
            kO.ayv = new e(kO);
        }
        return kO.ayv;
    }
}
