package com.google.android.gms.analytics.internal;

public abstract class o extends n {
    private boolean agB;
    private boolean agC;

    protected o(q qVar) {
        super(qVar);
    }

    protected final void hX() {
        if (!isInitialized()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void hY() {
        hm();
        this.agB = true;
    }

    protected abstract void hm();

    public final boolean isInitialized() {
        return this.agB && !this.agC;
    }
}
