package com.google.android.gms.c;

import android.text.TextUtils;
import com.google.android.gms.common.internal.w;
import java.util.HashMap;
import java.util.Map;

public final class h extends af<h> {
    public String agW;
    public String awZ;
    public String axa;
    public String axb;
    public boolean axc;
    public String axd;
    public boolean axe;
    public double axf;

    public final /* synthetic */ void a(af afVar) {
        boolean z = true;
        h hVar = (h) afVar;
        if (!TextUtils.isEmpty(this.awZ)) {
            hVar.awZ = this.awZ;
        }
        if (!TextUtils.isEmpty(this.agW)) {
            hVar.agW = this.agW;
        }
        if (!TextUtils.isEmpty(this.axa)) {
            hVar.axa = this.axa;
        }
        if (!TextUtils.isEmpty(this.axb)) {
            hVar.axb = this.axb;
        }
        if (this.axc) {
            hVar.axc = true;
        }
        if (!TextUtils.isEmpty(this.axd)) {
            hVar.axd = this.axd;
        }
        if (this.axe) {
            hVar.axe = this.axe;
        }
        if (this.axf != 0.0d) {
            double d = this.axf;
            if (d < 0.0d || d > 100.0d) {
                z = false;
            }
            w.b(z, "Sample rate must be between 0% and 100%");
            hVar.axf = d;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("hitType", this.awZ);
        hashMap.put("clientId", this.agW);
        hashMap.put("userId", this.axa);
        hashMap.put("androidAdId", this.axb);
        hashMap.put("AdTargetingEnabled", Boolean.valueOf(this.axc));
        hashMap.put("sessionControl", this.axd);
        hashMap.put("nonInteraction", Boolean.valueOf(this.axe));
        hashMap.put("sampleRate", Double.valueOf(this.axf));
        return af.ac(hashMap);
    }
}
