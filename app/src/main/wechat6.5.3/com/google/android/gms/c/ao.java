package com.google.android.gms.c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class ao extends af<ao> {
    public String azC;
    public boolean azD;

    public final /* synthetic */ void a(af afVar) {
        ao aoVar = (ao) afVar;
        if (!TextUtils.isEmpty(this.azC)) {
            aoVar.azC = this.azC;
        }
        if (this.azD) {
            aoVar.azD = this.azD;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("description", this.azC);
        hashMap.put("fatal", Boolean.valueOf(this.azD));
        return af.ac(hashMap);
    }
}
