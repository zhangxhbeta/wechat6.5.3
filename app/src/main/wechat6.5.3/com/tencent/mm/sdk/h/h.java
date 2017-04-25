package com.tencent.mm.sdk.h;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

public abstract class h<T, E> {
    public int nmk = 0;
    private final Hashtable<T, Object> nml = new Hashtable();
    private final HashSet<E> nmm = new HashSet();

    public abstract void o(T t, E e);

    public final void lock() {
        this.nmk++;
    }

    public final void unlock() {
        this.nmk--;
        if (this.nmk <= 0) {
            this.nmk = 0;
            buE();
        }
    }

    public synchronized void a(T t, Looper looper) {
        if (!this.nml.containsKey(t)) {
            if (looper != null) {
                this.nml.put(t, looper);
            } else {
                this.nml.put(t, new Object());
            }
        }
    }

    public final synchronized void remove(T t) {
        this.nml.remove(t);
    }

    public final synchronized void removeAll() {
        this.nml.clear();
    }

    private synchronized Vector<T> buD() {
        Vector<T> vector;
        vector = new Vector();
        vector.addAll(this.nml.keySet());
        return vector;
    }

    public final boolean bg(E e) {
        boolean add;
        synchronized (this.nmm) {
            add = this.nmm.add(e);
        }
        return add;
    }

    public final void Ls() {
        if ((this.nmk > 0 ? 1 : null) == null) {
            buE();
        }
    }

    private void buE() {
        Vector buD = buD();
        if (buD.size() <= 0) {
            this.nmm.clear();
            return;
        }
        synchronized (this.nmm) {
            ArrayList arrayList = new ArrayList(this.nmm);
            this.nmm.clear();
        }
        Map hashMap = new HashMap();
        Iterator it = buD.iterator();
        while (it.hasNext()) {
            final Object next = it.next();
            Object obj = this.nml.get(next);
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                final Object next2 = it2.next();
                if (!(next2 == null || obj == null)) {
                    if (obj instanceof Looper) {
                        Looper looper = (Looper) obj;
                        ac acVar = (ac) hashMap.get(looper);
                        if (acVar == null) {
                            acVar = new ac(looper);
                            hashMap.put(looper, acVar);
                        }
                        acVar.post(new Runnable(this) {
                            final /* synthetic */ h nmp;

                            public final void run() {
                                this.nmp.o(next, next2);
                            }
                        });
                    } else {
                        o(next, next2);
                    }
                }
            }
        }
    }
}
