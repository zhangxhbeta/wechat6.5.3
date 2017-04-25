package android.support.v4.e;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class g<K, V> {
    b vF;
    c vG;
    e vH;

    final class a<T> implements Iterator<T> {
        int hO;
        int mIndex;
        final int vI;
        boolean vJ = false;
        final /* synthetic */ g vK;

        a(g gVar, int i) {
            this.vK = gVar;
            this.vI = i;
            this.hO = gVar.bE();
        }

        public final boolean hasNext() {
            return this.mIndex < this.hO;
        }

        public final T next() {
            T j = this.vK.j(this.mIndex, this.vI);
            this.mIndex++;
            this.vJ = true;
            return j;
        }

        public final void remove() {
            if (this.vJ) {
                this.mIndex--;
                this.hO--;
                this.vJ = false;
                this.vK.P(this.mIndex);
                return;
            }
            throw new IllegalStateException();
        }
    }

    final class b implements Set<Entry<K, V>> {
        final /* synthetic */ g vK;

        b(g gVar) {
            this.vK = gVar;
        }

        public final /* synthetic */ boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends Entry<K, V>> collection) {
            int bE = this.vK.bE();
            for (Entry entry : collection) {
                this.vK.c(entry.getKey(), entry.getValue());
            }
            return bE != this.vK.bE();
        }

        public final void clear() {
            this.vK.bG();
        }

        public final boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            int g = this.vK.g(entry.getKey());
            if (g >= 0) {
                return b.d(this.vK.j(g, 1), entry.getValue());
            }
            return false;
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
            return this.vK.bE() == 0;
        }

        public final Iterator<Entry<K, V>> iterator() {
            return new d(this.vK);
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
            return this.vK.bE();
        }

        public final Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public final <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }

        public final boolean equals(Object obj) {
            return g.a((Set) this, obj);
        }

        public final int hashCode() {
            int bE = this.vK.bE() - 1;
            int i = 0;
            while (bE >= 0) {
                Object j = this.vK.j(bE, 0);
                Object j2 = this.vK.j(bE, 1);
                bE--;
                i += (j2 == null ? 0 : j2.hashCode()) ^ (j == null ? 0 : j.hashCode());
            }
            return i;
        }
    }

    final class c implements Set<K> {
        final /* synthetic */ g vK;

        c(g gVar) {
            this.vK = gVar;
        }

        public final boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public final void clear() {
            this.vK.bG();
        }

        public final boolean contains(Object obj) {
            return this.vK.g(obj) >= 0;
        }

        public final boolean containsAll(Collection<?> collection) {
            Map bF = this.vK.bF();
            for (Object containsKey : collection) {
                if (!bF.containsKey(containsKey)) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isEmpty() {
            return this.vK.bE() == 0;
        }

        public final Iterator<K> iterator() {
            return new a(this.vK, 0);
        }

        public final boolean remove(Object obj) {
            int g = this.vK.g(obj);
            if (g < 0) {
                return false;
            }
            this.vK.P(g);
            return true;
        }

        public final boolean removeAll(Collection<?> collection) {
            Map bF = this.vK.bF();
            int size = bF.size();
            for (Object remove : collection) {
                bF.remove(remove);
            }
            return size != bF.size();
        }

        public final boolean retainAll(Collection<?> collection) {
            return g.a(this.vK.bF(), (Collection) collection);
        }

        public final int size() {
            return this.vK.bE();
        }

        public final Object[] toArray() {
            return this.vK.T(0);
        }

        public final <T> T[] toArray(T[] tArr) {
            return this.vK.a((Object[]) tArr, 0);
        }

        public final boolean equals(Object obj) {
            return g.a((Set) this, obj);
        }

        public final int hashCode() {
            int i = 0;
            for (int bE = this.vK.bE() - 1; bE >= 0; bE--) {
                Object j = this.vK.j(bE, 0);
                i += j == null ? 0 : j.hashCode();
            }
            return i;
        }
    }

    final class d implements Iterator<Entry<K, V>>, Entry<K, V> {
        int mIndex;
        final /* synthetic */ g vK;
        int vL;
        boolean vM = false;

        public final /* bridge */ /* synthetic */ Object next() {
            this.mIndex++;
            this.vM = true;
            return this;
        }

        d(g gVar) {
            this.vK = gVar;
            this.vL = gVar.bE() - 1;
            this.mIndex = -1;
        }

        public final boolean hasNext() {
            return this.mIndex < this.vL;
        }

        public final void remove() {
            if (this.vM) {
                this.vK.P(this.mIndex);
                this.mIndex--;
                this.vL--;
                this.vM = false;
                return;
            }
            throw new IllegalStateException();
        }

        public final K getKey() {
            if (this.vM) {
                return this.vK.j(this.mIndex, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final V getValue() {
            if (this.vM) {
                return this.vK.j(this.mIndex, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final V setValue(V v) {
            if (this.vM) {
                return this.vK.a(this.mIndex, (Object) v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final boolean equals(Object obj) {
            if (!this.vM) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Entry)) {
                return false;
            } else {
                Entry entry = (Entry) obj;
                if (b.d(entry.getKey(), this.vK.j(this.mIndex, 0)) && b.d(entry.getValue(), this.vK.j(this.mIndex, 1))) {
                    return true;
                }
                return false;
            }
        }

        public final int hashCode() {
            int i = 0;
            if (this.vM) {
                Object j = this.vK.j(this.mIndex, 0);
                Object j2 = this.vK.j(this.mIndex, 1);
                int hashCode = j == null ? 0 : j.hashCode();
                if (j2 != null) {
                    i = j2.hashCode();
                }
                return i ^ hashCode;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    final class e implements Collection<V> {
        final /* synthetic */ g vK;

        e(g gVar) {
            this.vK = gVar;
        }

        public final boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public final void clear() {
            this.vK.bG();
        }

        public final boolean contains(Object obj) {
            return this.vK.h(obj) >= 0;
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
            return this.vK.bE() == 0;
        }

        public final Iterator<V> iterator() {
            return new a(this.vK, 1);
        }

        public final boolean remove(Object obj) {
            int h = this.vK.h(obj);
            if (h < 0) {
                return false;
            }
            this.vK.P(h);
            return true;
        }

        public final boolean removeAll(Collection<?> collection) {
            int i = 0;
            int bE = this.vK.bE();
            boolean z = false;
            while (i < bE) {
                if (collection.contains(this.vK.j(i, 1))) {
                    this.vK.P(i);
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
            int bE = this.vK.bE();
            boolean z = false;
            while (i < bE) {
                if (!collection.contains(this.vK.j(i, 1))) {
                    this.vK.P(i);
                    i--;
                    bE--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public final int size() {
            return this.vK.bE();
        }

        public final Object[] toArray() {
            return this.vK.T(1);
        }

        public final <T> T[] toArray(T[] tArr) {
            return this.vK.a((Object[]) tArr, 1);
        }
    }

    protected abstract void P(int i);

    protected abstract V a(int i, V v);

    protected abstract int bE();

    protected abstract Map<K, V> bF();

    protected abstract void bG();

    protected abstract void c(K k, V v);

    protected abstract int g(Object obj);

    protected abstract int h(Object obj);

    protected abstract Object j(int i, int i2);

    g() {
    }

    public static <K, V> boolean a(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public final Object[] T(int i) {
        int bE = bE();
        Object[] objArr = new Object[bE];
        for (int i2 = 0; i2 < bE; i2++) {
            objArr[i2] = j(i2, i);
        }
        return objArr;
    }

    public final <T> T[] a(T[] tArr, int i) {
        T[] tArr2;
        int bE = bE();
        if (tArr.length < bE) {
            tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), bE);
        } else {
            tArr2 = tArr;
        }
        for (int i2 = 0; i2 < bE; i2++) {
            tArr2[i2] = j(i2, i);
        }
        if (tArr2.length > bE) {
            tArr2[bE] = null;
        }
        return tArr2;
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
            if (set.size() == set2.size() && set.containsAll(set2)) {
                return true;
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }
}
