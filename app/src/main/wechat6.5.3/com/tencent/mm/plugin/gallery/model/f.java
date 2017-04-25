package com.tencent.mm.plugin.gallery.model;

import java.util.LinkedList;

public final class f<E> extends LinkedList<E> {
    private byte[] cGJ = new byte[0];

    public final E aqD() {
        E poll;
        synchronized (this.cGJ) {
            if (size() > 0) {
                poll = super.poll();
            } else {
                poll = null;
            }
        }
        return poll;
    }

    public final boolean aI(E e) {
        boolean contains;
        synchronized (this.cGJ) {
            contains = super.contains(e);
        }
        return contains;
    }

    public final void aJ(E e) {
        synchronized (this.cGJ) {
            if (aI(e)) {
                super.remove(e);
            }
        }
    }

    public final boolean add(E e) {
        boolean add;
        synchronized (this.cGJ) {
            add = super.add(e);
        }
        return add;
    }

    public final int size() {
        int size;
        synchronized (this.cGJ) {
            size = super.size();
        }
        return size;
    }
}
