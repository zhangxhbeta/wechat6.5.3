package com.tencent.mm.m.a;

import android.util.SparseArray;
import com.tencent.mm.m.a.g.a;
import java.util.ArrayList;

public abstract class h<K, T extends a> {
    public d chQ;

    public abstract ArrayList<T> e(ArrayList<Object> arrayList);

    public abstract T ue();

    public h(d dVar, int i) {
        this.chQ = dVar;
        this.chQ.aI(true);
        this.chQ.a(new a(this) {
            final /* synthetic */ h chR;

            {
                this.chR = r1;
            }

            public final a tZ() {
                return this.chR.ue();
            }

            public final ArrayList<a> e(ArrayList<Object> arrayList) {
                return this.chR.e(arrayList);
            }
        });
        if (i != 0) {
            this.chQ.eo(i);
        }
        getCount();
    }

    public final void close() {
        this.chQ.close();
        this.chQ = null;
    }

    public final int getCount() {
        return this.chQ.getCount();
    }

    public final boolean isClosed() {
        return this.chQ.isClosed();
    }

    public final boolean ub() {
        return this.chQ.ub();
    }

    public final void b(Object obj, T t) {
        this.chQ.a(obj, t);
    }

    public final SparseArray<K>[] uc() {
        return this.chQ.uc();
    }

    public final boolean ak(Object obj) {
        return this.chQ.ak(obj);
    }
}
