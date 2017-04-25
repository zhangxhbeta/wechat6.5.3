package com.tencent.mm.plugin.webview.modelcache.downloaderimpl;

public final class h {
    public final String appId;
    public final String bsI;
    public final String bsJ;
    public final int bsK;
    public final String bsL;
    public final long bsM;
    public final Exception bsN;
    public final String filePath;
    public final String url;
    public final String version;

    public h(String str, String str2, String str3, String str4, String str5, String str6, int i, String str7, long j, Exception exception) {
        this.url = str;
        this.filePath = str2;
        this.version = str3;
        this.appId = str4;
        this.bsI = str5;
        this.bsJ = str6;
        this.bsK = i;
        this.bsL = str7;
        this.bsM = j;
        this.bsN = exception;
    }

    public final String toString() {
        return "WebViewCacheResponseWrapper{url='" + this.url + '\'' + ", filePath='" + this.filePath + '\'' + ", version='" + this.version + '\'' + ", appId='" + this.appId + '\'' + ", domain='" + this.bsI + '\'' + ", packageId='" + this.bsJ + '\'' + ", cacheType=" + this.bsK + ", contentType='" + this.bsL + '\'' + ", contentLength=" + this.bsM + ", exception=" + this.bsN + '}';
    }
}
