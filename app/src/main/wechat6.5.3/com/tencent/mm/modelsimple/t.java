package com.tencent.mm.modelsimple;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aok;
import com.tencent.mm.protocal.c.aol;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.smtt.sdk.WebView;

public final class t extends k implements j {
    public int cYY = 1;
    private b cif;
    private e cii;

    public t(int i) {
        a aVar = new a();
        aVar.czn = new aok();
        aVar.czo = new aol();
        aVar.uri = "/cgi-bin/micromsg-bin/queryhaspasswd";
        aVar.czm = WebView.NORMAL_MODE_ALPHA;
        aVar.czp = 132;
        aVar.czq = 1000000132;
        this.cif = aVar.Bv();
        ((aok) this.cif.czk.czs).maG = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return WebView.NORMAL_MODE_ALPHA;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.cii.a(i2, i3, str, this);
    }
}
