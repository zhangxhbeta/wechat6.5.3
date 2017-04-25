package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.w;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class e<T> implements Iterator<T> {
    protected final b<T> ang;
    protected int anh = -1;

    public e(b<T> bVar) {
        this.ang = (b) w.Z(bVar);
    }

    public final boolean hasNext() {
        return this.anh < this.ang.getCount() + -1;
    }

    public final T next() {
        if (hasNext()) {
            b bVar = this.ang;
            int i = this.anh + 1;
            this.anh = i;
            return bVar.get(i);
        }
        throw new NoSuchElementException("Cannot advance the iterator beyond " + this.anh);
    }

    public final void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
