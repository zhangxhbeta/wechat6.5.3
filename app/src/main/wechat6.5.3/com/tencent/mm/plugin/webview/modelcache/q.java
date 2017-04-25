package com.tencent.mm.plugin.webview.modelcache;

import com.tencent.mm.sdk.platformtools.v;

public final class q {
    public final String appId;
    public final String bsI;
    public final int bsK;
    public final String bsL;
    public final long bsM;
    public final String filePath;

    public q(String str, String str2, String str3, long j, String str4, int i) {
        this.appId = str;
        this.bsI = str2;
        this.filePath = str3;
        this.bsM = j;
        this.bsL = str4;
        this.bsK = i;
    }

    public static q f(i iVar) {
        v.i("MicroMsg.WebViewCacheResWrapper", "fromWebViewCacheRes = %s", new Object[]{new q(iVar.field_appId, iVar.field_domain, iVar.field_localPath, iVar.field_contentLength, iVar.field_contentType, iVar.field_cacheType).toString()});
        return new q(iVar.field_appId, iVar.field_domain, iVar.field_localPath, iVar.field_contentLength, iVar.field_contentType, iVar.field_cacheType);
    }

    public final String toString() {
        return "WebViewCacheResWrapper{appId='" + this.appId + '\'' + ", domain='" + this.bsI + '\'' + ", filePath='" + this.filePath + '\'' + ", contentLength=" + this.bsM + ", contentType='" + this.bsL + '\'' + ", cacheType=" + this.bsK + '}';
    }
}
