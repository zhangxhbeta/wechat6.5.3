package com.google.android.gms.c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class ap extends af<ap> {
    public String azE;
    public int azF;
    private int azG;
    private String azH;
    public String azI;
    private boolean azJ;
    private boolean azK;
    private boolean azL;

    public ap() {
        this((byte) 0);
    }

    private ap(byte b) {
        UUID randomUUID = UUID.randomUUID();
        int leastSignificantBits = (int) (randomUUID.getLeastSignificantBits() & 2147483647L);
        if (leastSignificantBits == 0) {
            leastSignificantBits = (int) (randomUUID.getMostSignificantBits() & 2147483647L);
            if (leastSignificantBits == 0) {
                leastSignificantBits = Integer.MAX_VALUE;
            }
        }
        this(false, leastSignificantBits);
    }

    private ap(boolean z, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Given Integer is zero");
        }
        this.azF = i;
        this.azK = false;
    }

    private void lb() {
        if (this.azL) {
            throw new IllegalStateException("ScreenViewInfo is immutable");
        }
    }

    public final /* synthetic */ void a(af afVar) {
        ap apVar = (ap) afVar;
        if (!TextUtils.isEmpty(this.azE)) {
            String str = this.azE;
            apVar.lb();
            apVar.azE = str;
        }
        if (this.azF != 0) {
            int i = this.azF;
            apVar.lb();
            apVar.azF = i;
        }
        if (this.azG != 0) {
            i = this.azG;
            apVar.lb();
            apVar.azG = i;
        }
        if (!TextUtils.isEmpty(this.azH)) {
            str = this.azH;
            apVar.lb();
            apVar.azH = str;
        }
        if (!TextUtils.isEmpty(this.azI)) {
            Object obj = this.azI;
            apVar.lb();
            if (TextUtils.isEmpty(obj)) {
                apVar.azI = null;
            } else {
                apVar.azI = obj;
            }
        }
        if (this.azJ) {
            boolean z = this.azJ;
            apVar.lb();
            apVar.azJ = z;
        }
        if (this.azK) {
            z = this.azK;
            apVar.lb();
            apVar.azK = z;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("screenName", this.azE);
        hashMap.put("interstitial", Boolean.valueOf(this.azJ));
        hashMap.put("automatic", Boolean.valueOf(this.azK));
        hashMap.put("screenId", Integer.valueOf(this.azF));
        hashMap.put("referrerScreenId", Integer.valueOf(this.azG));
        hashMap.put("referrerScreenName", this.azH);
        hashMap.put("referrerUri", this.azI);
        return af.ac(hashMap);
    }
}
