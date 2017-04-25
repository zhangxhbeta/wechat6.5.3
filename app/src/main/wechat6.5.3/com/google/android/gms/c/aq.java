package com.google.android.gms.c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class aq extends af<aq> {
    public String apk;
    public String azM;
    public String azN;

    public final /* synthetic */ void a(af afVar) {
        aq aqVar = (aq) afVar;
        if (!TextUtils.isEmpty(this.azM)) {
            aqVar.azM = this.azM;
        }
        if (!TextUtils.isEmpty(this.apk)) {
            aqVar.apk = this.apk;
        }
        if (!TextUtils.isEmpty(this.azN)) {
            aqVar.azN = this.azN;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("network", this.azM);
        hashMap.put("action", this.apk);
        hashMap.put("target", this.azN);
        return af.ac(hashMap);
    }
}
