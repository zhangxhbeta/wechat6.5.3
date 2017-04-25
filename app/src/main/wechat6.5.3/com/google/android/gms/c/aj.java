package com.google.android.gms.c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class aj extends af<aj> {
    public String afG;
    public String afH;
    public String azg;
    public String azh;

    public final void a(aj ajVar) {
        if (!TextUtils.isEmpty(this.afG)) {
            ajVar.afG = this.afG;
        }
        if (!TextUtils.isEmpty(this.afH)) {
            ajVar.afH = this.afH;
        }
        if (!TextUtils.isEmpty(this.azg)) {
            ajVar.azg = this.azg;
        }
        if (!TextUtils.isEmpty(this.azh)) {
            ajVar.azh = this.azh;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("appName", this.afG);
        hashMap.put("appVersion", this.afH);
        hashMap.put("appId", this.azg);
        hashMap.put("appInstallerId", this.azh);
        return af.ac(hashMap);
    }
}
