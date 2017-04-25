package com.tencent.mm.e.a;

import android.content.Context;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.b.a.d;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.qf;
import com.tencent.mm.storage.at;
import java.util.List;

public final class kw extends com.tencent.mm.sdk.c.b {
    public a bmf;
    public b bmg;

    public static final class a {
        public long bao = 0;
        public pw bdE;
        public String bdV;
        public String bdZ;
        public bp blL;
        public String bmh;
        public qf bmi;
        public int bmj = 0;
        public at bmk;
        public List<at> bml;
        public String bmm;
        public String bmn;
        public d bmo;
        public Context context;
        public String desc;
        public String title;
        public String toUser;
        public int type = 0;
    }

    public static final class b {
        public String bdZ;
        public bp blL;
        public d bmo;
        public c bmp;
        public String bmq;
        public boolean bmr = false;
        public boolean bms = false;
    }

    public kw() {
        this((byte) 0);
    }

    private kw(byte b) {
        this.bmf = new a();
        this.bmg = new b();
        this.nhx = false;
        this.bpT = null;
    }
}
