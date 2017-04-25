package com.tencent.mm.plugin.sns.e.a;

import com.tencent.mm.plugin.sns.data.e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.al;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.ak;

public final class a {
    public String aZy = "";
    public e jdH = null;
    public aib jfX;
    public String jka = "";
    public String jke = "";
    public boolean joq = false;
    public boolean jor = false;
    public int jos = 0;
    public ak jot;
    public String mediaId = "";
    public String url = "";

    public a(String str) {
        this.mediaId = str;
    }

    public final boolean init() {
        this.jka = al.cA(ad.xh(), this.mediaId);
        return true;
    }

    public final String aTi() {
        if (this.jos == 4) {
            return i.o(this.jfX);
        }
        if (this.jos == 6) {
            return i.p(this.jfX);
        }
        return this.joq ? i.m(this.jfX) : i.l(this.jfX);
    }

    public final String getPath() {
        if (be.kS(this.jka)) {
            init();
        }
        return this.jka;
    }
}
