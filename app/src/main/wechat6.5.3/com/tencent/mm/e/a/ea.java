package com.tencent.mm.e.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public final class ea extends com.tencent.mm.sdk.c.b {
    public a bbV;
    public b bbW;

    public static final class a {
        public String[] aWv;
        public int bbX = 0;
        public Context context;
        public String[] selectionArgs;
        public Uri uri;
    }

    public static final class b {
        public Cursor bbY;
    }

    public ea() {
        this((byte) 0);
    }

    private ea(byte b) {
        this.bbV = new a();
        this.bbW = new b();
        this.nhx = false;
        this.bpT = null;
    }
}
