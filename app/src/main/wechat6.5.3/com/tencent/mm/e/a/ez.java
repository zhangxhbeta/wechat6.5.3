package com.tencent.mm.e.a;

import android.content.Context;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.qb;
import com.tencent.mm.protocal.c.qf;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.v.k;
import java.util.List;

public final class ez extends com.tencent.mm.sdk.c.b {
    public a bdQ;
    public b bdR;

    public static final class a {
        public k aZJ;
        public long aZa;
        public qf aZf;
        public pw bdS;
        public com.tencent.mm.sdk.h.g.a bdT;
        public Runnable bdU;
        public String bdV;
        public int bdW = 0;
        public int bdX = 0;
        public Context context;
        public ac handler;
        public String path;
        public String title;
        public String toUser;
        public int type = 0;
    }

    public static final class b {
        public List bdY;
        public String bdZ;
        public String bea;
        public qb beb;
        public d bec;
        public List bed;
        public boolean bee = false;
        public boolean bef = false;
        public boolean beg = false;
        public double beh = 0.0d;
        public String path;
        public int ret = -1;
    }

    public ez() {
        this((byte) 0);
    }

    private ez(byte b) {
        this.bdQ = new a();
        this.bdR = new b();
        this.nhx = false;
        this.bpT = null;
    }
}
