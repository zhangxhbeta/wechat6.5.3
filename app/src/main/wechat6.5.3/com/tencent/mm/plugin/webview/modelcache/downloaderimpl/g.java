package com.tencent.mm.plugin.webview.modelcache.downloaderimpl;

import com.tencent.mm.sdk.platformtools.be;

public final class g {
    public final String appId;
    public final String bsI;
    public final String bsJ;
    public final int bsK;
    public final String lgE;
    public final int networkType;
    public final String url;

    public g(String str, String str2, String str3, String str4, String str5, int i) {
        this(str, str2, str3, str4, str5, i, 2);
    }

    public g(String str, String str2, String str3, String str4, String str5, int i, int i2) {
        this.url = str;
        this.lgE = str2;
        this.appId = str3;
        this.bsI = str4;
        this.bsJ = str5;
        this.bsK = i;
        this.networkType = i2;
    }

    public final String toString() {
        return "WebViewCacheRequestWrapper{url='" + this.url + '\'' + ", fileVersion='" + this.lgE + '\'' + ", appId='" + this.appId + '\'' + ", domain='" + this.bsI + '\'' + ", packageId='" + this.bsJ + '\'' + ", cacheType=" + this.bsK + ", networkType=" + this.networkType + '}';
    }

    public final int hashCode() {
        return String.format("%s_%s_%s_%s_%s_%s", new Object[]{this.url, this.lgE, this.appId, this.bsI, this.bsJ, Integer.valueOf(this.bsK)}).hashCode();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (be.ma(this.url).equals(gVar.url) && be.ma(this.lgE).equals(gVar.lgE) && be.ma(this.appId).equals(gVar.appId) && be.ma(this.bsI).equals(gVar.bsI) && be.ma(this.bsJ).equals(gVar.bsJ) && this.bsK == gVar.bsK) {
                return true;
            }
        }
        return false;
    }
}
