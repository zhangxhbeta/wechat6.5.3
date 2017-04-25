package com.tencent.c.a.a;

import android.content.Context;
import android.preference.PreferenceManager;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

public final class n implements Runnable {
    public static long aOM = -1;
    private a aOK = null;
    int aOL = 0;
    private Context mContext = null;
    private int mType = 0;

    public n(Context context, int i) {
        this.mContext = context;
        this.mType = i;
    }

    private void nU() {
        g o = r.T(this.mContext).o(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(1)})));
        g o2 = r.T(this.mContext).o(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(2)})));
        g o3 = r.T(this.mContext).o(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(4)})));
        if (!s.b(o, o2) || !s.b(o, o3)) {
            o = s.a(s.a(o, o2), s.a(o, o3));
            new StringBuilder("local mid check failed, redress with mid:").append(o.toString());
            r.T(this.mContext).b(o);
        }
    }

    private void a(JSONObject jSONObject) {
        if (i.aOA != null && j.aOG != 1) {
            if (j.aOH <= 0 || this.aOL <= j.aOH) {
                i.aOA.aK("[" + new m(this.mContext, jSONObject).nT().toString() + "]");
                aOM = System.currentTimeMillis();
                this.aOL++;
                return;
            }
            new StringBuilder("limit dispatch:").append(j.aOH);
        }
    }

    public final void run() {
        new StringBuilder("request type:").append(this.mType);
        switch (this.mType) {
            case 1:
                a(null);
                return;
            case 2:
                if (this.aOK == null) {
                    this.aOK = r.T(this.mContext).nW();
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (i.aOB <= 0) {
                    i.aOB = PreferenceManager.getDefaultSharedPreferences(this.mContext).getLong("__MID_LAST_CHECK_TIME__", 0);
                }
                long abs = Math.abs(currentTimeMillis - i.aOB);
                new StringBuilder("check entity: ").append(this.aOK.toString()).append(",duration:").append(abs);
                if (this.aOK.aOb < 0 || this.aOK.aOb > 100) {
                    this.aOK.aOb = 3;
                }
                long j = ((long) this.aOK.aOb) * e.aOv;
                new StringBuilder("duration:").append(abs).append(",maxCheckDays:").append(j).append(",mLastCheckTime:").append(i.aOB).append(",mCheckEntity:").append(this.aOK);
                if (abs >= j) {
                    nU();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("dur", abs);
                        jSONObject.put("md", j);
                        jSONObject.put("lct", i.aOB);
                        jSONObject.put("cur", currentTimeMillis);
                    } catch (JSONException e) {
                    }
                    if (aOM <= 0) {
                        a(jSONObject);
                        return;
                    }
                    return;
                } else if (abs > e.aOv) {
                    nU();
                    return;
                } else {
                    return;
                }
            default:
                new StringBuilder("wrong type:").append(this.mType);
                return;
        }
    }
}
