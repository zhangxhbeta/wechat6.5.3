package com.tencent.mm.e.a;

import android.content.Context;
import android.os.Bundle;

public final class j extends com.tencent.mm.sdk.c.b {
    public a aWx;
    public b aWy;

    public static final class a {
        public boolean aWA;
        public boolean aWB;
        public String aWz;
        public int actionCode;
        public Context context;
    }

    public static final class b {
        public Bundle aWC;
    }

    public j() {
        this((byte) 0);
    }

    private j(byte b) {
        this.aWx = new a();
        this.aWy = new b();
        this.nhx = false;
        this.bpT = null;
    }
}
