package com.tencent.mm.plugin.webview.modelcache.downloaderimpl;

import com.tencent.mm.pluginsdk.k.a.c.k;
import com.tencent.mm.pluginsdk.k.a.c.m;
import com.tencent.mm.pluginsdk.k.a.c.n.a;
import com.tencent.mm.sdk.platformtools.v;
import java.util.concurrent.ConcurrentHashMap;

public final class c extends a<f> {
    private static final ConcurrentHashMap<String, Boolean> lgD = new ConcurrentHashMap();

    public c(f fVar) {
        super(fVar);
    }

    public final boolean Pb() {
        return true;
    }

    public final boolean Pc() {
        return false;
    }

    public final boolean Pd() {
        return true;
    }

    public final boolean Pf() {
        return false;
    }

    public final String Pa() {
        return "WebViewCache";
    }

    public final boolean dw(long j) {
        if (super.dw(j) && j < 5242880) {
            return true;
        }
        return false;
    }

    protected final m a(k kVar) {
        if (lgD.putIfAbsent(((f) this.lEi).OZ(), Boolean.TRUE) != null) {
            v.i("MicroMsg.ResDownloader.WebViewCacheDownloadNetworkRequestHandler", "request urlKey = %s, already downloading this file", new Object[]{((f) this.lEi).lCO});
            return null;
        }
        m a = super.a(kVar);
        lgD.remove(((f) this.lEi).OZ());
        return a;
    }

    public static void clearCache() {
        lgD.clear();
    }
}
