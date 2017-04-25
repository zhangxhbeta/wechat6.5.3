package com.tencent.mm.kernel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import junit.framework.Assert;

public final class f<T> {
    private final HashMap<T, a<T>> ckt = new HashMap();

    private static class a<T> {
        ArrayList<a> cku;
        ArrayList<a> ckv;
        T ckw;
        boolean ckx;

        private a(T t) {
            this.ckx = false;
            this.ckw = t;
        }

        public final String toString() {
            return "Ref-" + this.ckw.toString();
        }
    }

    private synchronized a<T> ao(T t) {
        a<T> aVar;
        aVar = (a) this.ckt.get(t);
        if (aVar == null) {
            aVar = new a(t);
            this.ckt.put(t, aVar);
        }
        return aVar;
    }

    public final synchronized void n(T t, T t2) {
        Assert.assertNotNull(t);
        Assert.assertNotNull(t2);
        a ao = ao(t);
        a ao2 = ao(t2);
        Object[] objArr = new Object[]{ao, ao2};
        if (ao != ao2) {
            if (ao.cku == null) {
                ao.cku = new ArrayList(2);
            }
            ao.cku.add(ao2);
            if (ao2.ckv == null) {
                ao2.ckv = new ArrayList(2);
            }
            ao2.ckv.add(ao);
        }
    }

    public final ArrayList<T> vp() {
        ArrayList<T> arrayList = new ArrayList();
        for (Entry entry : this.ckt.entrySet()) {
            if (!((a) entry.getValue()).ckx) {
                arrayList.add(entry.getKey());
            }
        }
        return arrayList;
    }

    public final ArrayList<T> vq() {
        ArrayList<T> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Entry entry : this.ckt.entrySet()) {
            if (((a) entry.getValue()).cku == null) {
                ((a) entry.getValue()).ckx = true;
                arrayList2.add(entry.getValue());
                arrayList.add(entry.getKey());
                new Object[1][0] = entry.getKey();
            }
        }
        new Object[1][0] = arrayList2;
        new Object[1][0] = this.ckt;
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            Object[] objArr = new Object[]{r0.ckv, ((a) it.next()).cku};
            a(((a) it.next()).ckv, arrayList);
        }
        return arrayList;
    }

    private void a(ArrayList<a> arrayList, ArrayList<T> arrayList2) {
        new Object[1][0] = arrayList;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                Object[] objArr = new Object[]{aVar, Boolean.valueOf(aVar.ckx), aVar.cku};
                if (!aVar.ckx) {
                    int i;
                    Iterator it2 = aVar.cku.iterator();
                    while (it2.hasNext()) {
                        Object[] objArr2 = new Object[]{r1, Boolean.valueOf(((a) it2.next()).ckx)};
                        if (!((a) it2.next()).ckx) {
                            i = 0;
                            break;
                        }
                    }
                    boolean z = true;
                    if (i != 0) {
                        aVar.ckx = true;
                        arrayList2.add(aVar.ckw);
                        new Object[1][0] = aVar.ckw;
                        if (aVar.ckv != null) {
                            a(aVar.ckv, arrayList2);
                        }
                    }
                }
            }
        }
    }
}
