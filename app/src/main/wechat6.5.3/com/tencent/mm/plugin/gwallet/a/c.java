package com.tencent.mm.plugin.gwallet.a;

public final class c {
    public int gDS;
    String mMessage;

    public c(int i, String str) {
        this.gDS = i;
        if (str == null || str.trim().length() == 0) {
            this.mMessage = b.lN(i);
        } else {
            this.mMessage = str + " (response: " + b.lN(i) + ")";
        }
    }

    public final boolean iY() {
        return this.gDS == 0;
    }

    public final String toString() {
        return "IabResult: " + this.mMessage;
    }
}
