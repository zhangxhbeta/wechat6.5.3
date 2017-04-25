package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class d {
    public float bYf = -1000.0f;
    public float bYg = -1000.0f;
    Map<String, Object> eBj = new HashMap();
    int iOH = 0;
    long iOI = 0;
    String iOJ = "";

    public d() {
        this.eBj.clear();
    }

    public final void putValue(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            this.eBj.put(str, obj);
        }
    }
}
