package com.google.android.gms.c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class ar extends af<ar> {
    public String azA;
    public String azO;
    public long azP;
    public String sa;

    public final /* synthetic */ void a(af afVar) {
        ar arVar = (ar) afVar;
        if (!TextUtils.isEmpty(this.azO)) {
            arVar.azO = this.azO;
        }
        if (this.azP != 0) {
            arVar.azP = this.azP;
        }
        if (!TextUtils.isEmpty(this.sa)) {
            arVar.sa = this.sa;
        }
        if (!TextUtils.isEmpty(this.azA)) {
            arVar.azA = this.azA;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("variableName", this.azO);
        hashMap.put("timeInMillis", Long.valueOf(this.azP));
        hashMap.put("category", this.sa);
        hashMap.put("label", this.azA);
        return af.ac(hashMap);
    }
}
