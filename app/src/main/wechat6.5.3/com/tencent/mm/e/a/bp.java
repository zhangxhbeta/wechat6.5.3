package com.tencent.mm.e.a;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.Fragment;
import com.tencent.mm.protocal.c.qf;
import com.tencent.mm.protocal.c.qo;
import com.tencent.mm.ui.snackbar.b.c;

public final class bp extends com.tencent.mm.sdk.c.b {
    public a aZd;
    public b aZe;

    public static final class a {
        public Activity aXH;
        public qf aZf;
        public qo aZg;
        public String aZh;
        public int aZi = 0;
        public String aZj;
        public int aZk = 0;
        public int aZl = 0;
        public OnClickListener aZm;
        public c aZn;
        public String desc;
        public Fragment og;
        public String title;
        public int type = 0;
    }

    public static final class b {
        public int ret = 0;
    }

    public bp() {
        this((byte) 0);
    }

    private bp(byte b) {
        this.aZd = new a();
        this.aZe = new b();
        this.nhx = false;
        this.bpT = null;
    }
}
