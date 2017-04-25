package com.tencent.mm.pluginsdk.k.a.c;

import com.tencent.mm.pluginsdk.k.a.c.g.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class l implements b {
    protected volatile int dTX = 15000;
    private final String filePath;
    public final String lCO;
    final int lCY;
    private final String lEs;
    protected volatile int lEt = 20000;
    protected volatile int lEu = 15000;
    private final String lgE;
    private final String method;
    final int networkType;
    final int priority;
    protected final Map<String, String> requestHeaders = new HashMap();
    final String url;

    public l(String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, int i3) {
        this.lCO = str;
        this.filePath = str2;
        this.lgE = str3;
        this.lEs = str4;
        this.url = str5;
        this.method = str6;
        this.lCY = i;
        this.networkType = i2;
        this.priority = Math.max(i3, 0);
    }

    public boolean bnS() {
        return false;
    }

    public String Pa() {
        return this.lEs;
    }

    public String OZ() {
        return this.filePath;
    }

    public final String bnQ() {
        return this.lCO;
    }

    public final void R(Map<String, String> map) {
        if (map.size() != 0) {
            this.requestHeaders.putAll(map);
        }
    }

    public final Map<String, String> getRequestHeaders() {
        if (this.requestHeaders.size() == 0) {
            return null;
        }
        return Collections.unmodifiableMap(this.requestHeaders);
    }

    public final int getConnectTimeout() {
        return this.dTX;
    }

    public final int getReadTimeout() {
        return this.lEt;
    }

    public final int boc() {
        return this.lEu;
    }
}
