package com.tencent.mm.plugin.webview.modelcache;

import com.tencent.mm.sdk.platformtools.v;

public final class r {
    final String appId;
    final String bjG;
    final String bsI;
    final String bsJ;
    final int bsK;
    final String lfS;
    final a lfT;

    public r(String str, String str2, int i, String str3, String str4) {
        this.appId = str;
        this.bsI = str2;
        this.lfS = str3;
        this.bsK = i;
        this.bsJ = str4;
        v.i("MicroMsg.WebViewCacheResWriter", "init WebViewCacheResWriter, appId = %s, domain = %s, mainURL = %s, cacheType = %d", new Object[]{str, str2, str3, Integer.valueOf(i)});
        this.lfT = a.Ed(str);
        if (this.lfT != null) {
            a aVar = this.lfT;
            this.bjG = aVar.path + "/" + String.format("%d_%d_%d_%d", new Object[]{Integer.valueOf(str2.hashCode()), Integer.valueOf(i), Integer.valueOf(str3.hashCode()), Integer.valueOf(str4.hashCode())});
            return;
        }
        this.bjG = null;
        v.e("MicroMsg.WebViewCacheResWriter", "get null appIdResDir");
    }
}
