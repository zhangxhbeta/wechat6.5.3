package com.google.android.gms.c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class an extends af<an> {
    public String apk;
    public String azA;
    public long azB;
    public String sa;

    public final /* synthetic */ void a(af afVar) {
        an anVar = (an) afVar;
        if (!TextUtils.isEmpty(this.sa)) {
            anVar.sa = this.sa;
        }
        if (!TextUtils.isEmpty(this.apk)) {
            anVar.apk = this.apk;
        }
        if (!TextUtils.isEmpty(this.azA)) {
            anVar.azA = this.azA;
        }
        if (this.azB != 0) {
            anVar.azB = this.azB;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("category", this.sa);
        hashMap.put("action", this.apk);
        hashMap.put("label", this.azA);
        hashMap.put("value", Long.valueOf(this.azB));
        return af.ac(hashMap);
    }
}
