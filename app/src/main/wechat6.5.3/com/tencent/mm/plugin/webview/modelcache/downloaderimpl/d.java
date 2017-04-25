package com.tencent.mm.plugin.webview.modelcache.downloaderimpl;

import com.tencent.mm.pluginsdk.k.a.c.r;

public final class d extends com.tencent.mm.pluginsdk.k.a.c.a {
    private final String appId;
    private final String bsI;
    private final String bsJ;
    private final int bsK;

    static final class a extends com.tencent.mm.pluginsdk.k.a.c.a.a<d> {
        String appId;
        String bsI;
        String bsJ;
        int bsK;

        public a(String str) {
            super(str);
        }

        public final d biV() {
            return new d(this.url, this.lgE, this.dby, this.appId, this.bsI, this.bsJ, this.bsK);
        }
    }

    protected d(String str, String str2, long j, String str3, String str4, String str5, int i) {
        super(str, a.T(str3, str4, str), str2, 2, 2, a.Eu(str), j, null, "WebViewCache", str4, 0);
        this.bsI = str4;
        this.appId = str3;
        this.bsJ = str5;
        this.bsK = i;
    }

    public final r biU() {
        r biU = super.biU();
        biU.field_appId = this.appId;
        biU.field_wvCacheType = this.bsK;
        biU.field_packageId = this.bsJ;
        return biU;
    }
}
