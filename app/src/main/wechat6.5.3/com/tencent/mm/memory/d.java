package com.tencent.mm.memory;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class d<T, S> {
    protected Queue<T> cnp = new ConcurrentLinkedQueue();
    protected S cnq;

    public d(S s) {
        this.cnq = s;
    }

    public final T pop() {
        return this.cnp.poll();
    }

    public final void put(T t) {
        this.cnp.add(t);
    }

    public final int size() {
        return this.cnp.size();
    }

    public final S wd() {
        return this.cnq;
    }
}
