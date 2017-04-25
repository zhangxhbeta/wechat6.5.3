package com.google.android.gms.c;

import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import java.util.HashMap;
import java.util.Map;

public final class ak extends af<ak> {
    public String afy;
    public String azi;
    public String azj;
    public String azk;
    public String azl;
    public String azm;
    public String azn;
    public String azo;
    public String azp;
    public String mName;

    public final /* synthetic */ void a(af afVar) {
        ak akVar = (ak) afVar;
        if (!TextUtils.isEmpty(this.mName)) {
            akVar.mName = this.mName;
        }
        if (!TextUtils.isEmpty(this.azi)) {
            akVar.azi = this.azi;
        }
        if (!TextUtils.isEmpty(this.azj)) {
            akVar.azj = this.azj;
        }
        if (!TextUtils.isEmpty(this.azk)) {
            akVar.azk = this.azk;
        }
        if (!TextUtils.isEmpty(this.azl)) {
            akVar.azl = this.azl;
        }
        if (!TextUtils.isEmpty(this.afy)) {
            akVar.afy = this.afy;
        }
        if (!TextUtils.isEmpty(this.azm)) {
            akVar.azm = this.azm;
        }
        if (!TextUtils.isEmpty(this.azn)) {
            akVar.azn = this.azn;
        }
        if (!TextUtils.isEmpty(this.azo)) {
            akVar.azo = this.azo;
        }
        if (!TextUtils.isEmpty(this.azp)) {
            akVar.azp = this.azp;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("name", this.mName);
        hashMap.put("source", this.azi);
        hashMap.put("medium", this.azj);
        hashMap.put("keyword", this.azk);
        hashMap.put("content", this.azl);
        hashMap.put(SlookAirButtonFrequentContactAdapter.ID, this.afy);
        hashMap.put("adNetworkId", this.azm);
        hashMap.put("gclid", this.azn);
        hashMap.put("dclid", this.azo);
        hashMap.put("aclid", this.azp);
        return af.ac(hashMap);
    }
}
