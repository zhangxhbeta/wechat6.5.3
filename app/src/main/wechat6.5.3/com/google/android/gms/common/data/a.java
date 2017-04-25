package com.google.android.gms.common.data;

import java.util.Iterator;

public abstract class a<T> implements b<T> {
    public final DataHolder amM;

    protected a(DataHolder dataHolder) {
        this.amM = dataHolder;
        if (this.amM != null) {
            this.amM.amY = this;
        }
    }

    public int getCount() {
        return this.amM == null ? 0 : this.amM.amX;
    }

    public Iterator<T> iterator() {
        return new e(this);
    }

    public final void release() {
        if (this.amM != null) {
            this.amM.close();
        }
    }
}
