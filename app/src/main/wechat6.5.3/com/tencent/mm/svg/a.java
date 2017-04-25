package com.tencent.mm.svg;

import android.os.Looper;
import java.util.HashMap;
import java.util.LinkedList;

final class a<T> {
    private HashMap<Looper, LinkedList<T>> nyb = new HashMap();
    private LinkedList<T> nyc = new LinkedList();

    a() {
    }

    protected final synchronized T bya() {
        T t;
        t = null;
        if (this.nyc.size() != 0) {
            t = this.nyc.poll();
        }
        return t;
    }

    protected final synchronized void a(Looper looper, T t) {
        LinkedList linkedList;
        if (this.nyb.containsKey(looper)) {
            linkedList = (LinkedList) this.nyb.get(looper);
        } else {
            linkedList = new LinkedList();
            this.nyb.put(looper, linkedList);
        }
        linkedList.add(t);
    }

    protected final synchronized void a(Looper looper) {
        if (this.nyb.containsKey(looper)) {
            this.nyc.addAll((LinkedList) this.nyb.remove(looper));
        }
    }
}
