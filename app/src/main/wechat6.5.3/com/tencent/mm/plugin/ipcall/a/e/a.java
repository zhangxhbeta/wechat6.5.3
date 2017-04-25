package com.tencent.mm.plugin.ipcall.a.e;

public class a {
    public boolean bhY = false;

    public void start() {
        reset();
        this.bhY = true;
    }

    public void reset() {
    }

    protected void auO() {
    }

    public final void finish() {
        if (this.bhY) {
            auO();
            this.bhY = false;
        }
    }
}
