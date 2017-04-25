package com.tencent.mm.e.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.protocal.c.pw;

public final class ew extends com.tencent.mm.sdk.c.b {
    public a bdC;
    public b bdD;

    public static final class a {
        public long aZa;
        public pw bdE;
        public ImageView bdF;
        public int bdG;
        public boolean bdH = false;
        public boolean bdI = false;
        public boolean bdJ = true;
        public Context context;
        public int height;
        public int maxWidth;
        public int opType = -1;
        public int width;
    }

    public static final class b {
        public Bitmap bdK;
        public int ret = -1;
    }

    public ew() {
        this((byte) 0);
    }

    private ew(byte b) {
        this.bdC = new a();
        this.bdD = new b();
        this.nhx = false;
        this.bpT = null;
    }
}
