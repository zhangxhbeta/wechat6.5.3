package com.google.android.gms.c;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class p<K, V> {
    b ayt;
    c ayu;
    e ayv;

    final class a<T> implements Iterator<T> {
        final /* synthetic */ p ayw;
        int hO;
        int mIndex;
        final int vI;
        boolean vJ = false;

        a(p pVar, int i) {
            this.ayw = pVar;
            this.vI = i;
            this.hO = pVar.bE();
        }

        public final boolean hasNext() {
            return this.mIndex < this.hO;
        }

        public final T next() {
            T j = this.ayw.j(this.mIndex, this.vI);
            this.mIndex++;
            this.vJ = true;
            return j;
        }

        public final void remove() {
            if (this.vJ) {
                this.mIndex--;
                this.hO--;
                this.vJ = false;
                this.ayw.P(this.mIndex);
                return;
            }
            throw new IllegalStateException();
        }
    }

    final class b implements Set<Entry<K, V>> {
        final /* synthetic */ p ayw;

        b(p pVar) {
            this.ayw = pVar;
        }

        public final /* synthetic */ boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends Entry<K, V>> collection) {
            int bE = this.ayw.bE();
            for (Entry entry : collection) {
                this.ayw.c(entry.getKey(), entry.getValue());
            }
            return bE != this.ayw.bE();
        }

        public final void clear() {
            this.ayw.bG();
        }

        public final boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            int g = this.ayw.g(entry.getKey());
            return g >= 0 ? n.d(this.ayw.j(g, 1), entry.getValue()) : false;
        }

        public final boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public final boolean equals(Object obj) {
            return p.a((Set) this, obj);
        }

        public final int hashCode() {
            int bE = this.ayw.bE() - 1;
            int i = 0;
            while (bE >= 0) {
                Object j = this.ayw.j(bE, 0);
                Object j2 = this.ayw.j(bE, 1);
                bE--;
                i += (j2 == null ? 0 : j2.hashCode()) ^ (j == null ? 0 : j.hashCode());
            }
            return i;
        }

        public final boolean isEmpty() {
            return this.ayw.bE() == 0;
        }

        public final Iterator<Entry<K, V>> iterator() {
            return new d(this.ayw);
        }

        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public final boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public final boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public final int size() {
            return this.ayw.bE();
        }

        public final Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public final <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    final class c implements Set<K> {
        final /* synthetic */ p ayw;

        c(p pVar) {
            this.ayw = pVar;
        }

        public final boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public final void clear() {
            this.ayw.bG();
        }

        public final boolean contains(Object obj) {
            return this.ayw.g(obj) >= 0;
        }

        public final boolean containsAll(Collection<?> collection) {
            Map bF = this.ayw.bF();
            for (Object containsKey : collection) {
                if (!bF.containsKey(containsKey)) {
                    return false;
                }
            }
            return true;
        }

        public final boolean equals(Object obj) {
            return p.a((Set) this, obj);
        }

        public final int hashCode() {
            int i = 0;
            for (int bE = this.ayw.bE() - 1; bE >= 0; bE--) {
                Object j = this.ayw.j(bE, 0);
                i += j == null ? 0 : j.hashCode();
            }
            return i;
        }

        public final boolean isEmpty() {
            return this.ayw.bE() == 0;
        }

        public final Iterator<K> iterator() {
            return new a(this.ayw, 0);
        }

        public final boolean remove(Object obj) {
            int g = this.ayw.g(obj);
            if (g < 0) {
                return false;
            }
            this.ayw.P(g);
            return true;
        }

        public final boolean removeAll(Collection<?> collection) {
            Map bF = this.ayw.bF();
            int size = bF.size();
            for (Object remove : collection) {
                bF.remove(remove);
            }
            return size != bF.size();
        }

        public final boolean retainAll(Collection<?> collection) {
            Map bF = this.ayw.bF();
            int size = bF.size();
            Iterator it = bF.keySet().iterator();
            while (it.hasNext()) {
                if (!collection.contains(it.next())) {
                    it.remove();
                }
            }
            return size != bF.size();
        }

        public final int size() {
            return this.ayw.bE();
        }

        public final Object[] toArray() {
            return this.ayw.T(0);
        }

        public final <T> T[] toArray(T[] tArr) {
            return this.ayw.a((Object[]) tArr, 0);
        }
    }

    final class d implements Iterator<Entry<K, V>>, Entry<K, V> {
        final /* synthetic */ p ayw;
        int mIndex;
        int vL;
        boolean vM = false;

        d(p pVar) {
            this.ayw = pVar;
            this.vL = pVar.bE() - 1;
            this.mIndex = -1;
        }

        public final boolean equals(Object obj) {
            if (!this.vM) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Entry)) {
                return false;
            } else {
                Entry entry = (Entry) obj;
                return n.d(entry.getKey(), this.ayw.j(this.mIndex, 0)) && n.d(entry.getValue(), this.ayw.j(this.mIndex, 1));
            }
        }

        public final K getKey() {
            if (this.vM) {
                return this.ayw.j(this.mIndex, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final V getValue() {
            if (this.vM) {
                return this.ayw.j(this.mIndex, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final boolean hasNext() {
            return this.mIndex < this.vL;
        }

        public final int hashCode() {
            int i = 0;
            if (this.vM) {
                Object j = this.ayw.j(this.mIndex, 0);
                Object j2 = this.ayw.j(this.mIndex, 1);
                int hashCode = j == null ? 0 : j.hashCode();
                if (j2 != null) {
                    i = j2.hashCode();
                }
                return i ^ hashCode;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final /* bridge */ /* synthetic */ Object next() {
            this.mIndex++;
            this.vM = true;
            return this;
        }

        public final void remove() {
            if (this.vM) {
                this.ayw.P(this.mIndex);
                this.mIndex--;
                this.vL--;
                this.vM = false;
                return;
            }
            throw new IllegalStateException();
        }

        public final V setValue(V v) {
            if (this.vM) {
                return this.ayw.a(this.mIndex, (Object) v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    final class e implements Collection<V> {
        final /* synthetic */ p ayw;

        e(p pVar) {
            this.ayw = pVar;
        }

        public final boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public final void clear() {
            this.ayw.bG();
        }

        public final boolean contains(Object obj) {
            return this.ayw.h(obj) >= 0;
        }

        public final boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isEmpty() {
            return this.ayw.bE() == 0;
        }

        public final Iterator<V> iterator() {
            return new a(this.ayw, 1);
        }

        public final boolean remove(Object obj) {
            int h = this.ayw.h(obj);
            if (h < 0) {
                return false;
            }
            this.ayw.P(h);
            return true;
        }

        public final boolean removeAll(Collection<?> collection) {
            int i = 0;
            int bE = this.ayw.bE();
            boolean z = false;
            while (i < bE) {
                if (collection.contains(this.ayw.j(i, 1))) {
                    this.ayw.P(i);
                    i--;
                    bE--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public final boolean retainAll(Collection<?> collection) {
            int i = 0;
            int bE = this.ayw.bE();
            boolean z = false;
            while (i < bE) {
                if (!collection.contains(this.ayw.j(i, 1))) {
                    this.ayw.P(i);
                    i--;
                    bE--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public final int size() {
            return this.ayw.bE();
        }

        public final Object[] toArray() {
            return this.ayw.T(1);
        }

        public final <T> T[] toArray(T[] tArr) {
            return this.ayw.a((Object[]) tArr, 1);
        }
    }

    p() {
    }

    public static <T> boolean a(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            return set.size() == set2.size() && set.containsAll(set2);
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    protected abstract void P(int i);

    public final Object[] T(int i) {
        int bE = bE();
        Object[] objArr = new Object[bE];
        for (int i2 = 0; i2 < bE; i2++) {
            objArr[i2] = j(i2, i);
        }
        return objArr;
    }

    protected abstract V a(int i, V v);

    public final <T> T[] a(T[] tArr, int i) {
        int bE = bE();
        T[] tArr2 = tArr.length < bE ? (Object[]) Array.newInstance(tArr.getClass().getComponentType(), bE) : tArr;
        for (int i2 = 0; i2 < bE; i2++) {
            tArr2[i2] = j(i2, i);
        }
        if (tArr2.length > bE) {
            tArr2[bE] = null;
        }
        return tArr2;
    }

    protected abstract int bE();

    protected abstract Map<K, V> bF();

    protected abstract void bG();

    protected abstract void c(K k, V v);

    protected abstract int g(Object obj);

    protected abstract int h(Object obj);

    protected abstract Object j(int i, int i2);
}
