package com.tencent.mm.plugin.mmsight.model;

import android.app.ActivityManager;
import android.graphics.Point;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.compatible.d.l;
import com.tencent.mm.plugin.mmsight.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import org.json.JSONObject;

public final class a {
    static a hlJ;
    public int cGx;
    public int cdi = 0;
    public int ceS;
    public long fileSize;
    String hlK = (VERSION.SDK_INT);
    int hlL;
    int hlM;
    String hlN;
    int hlO;
    int hlP;
    public String hlQ;
    public String hlR;
    public String hlS;
    public String hlT;
    public int hlU;
    public int hlV;
    public int hlW;
    public int hlX;
    public int hlY;
    public int hlZ;
    public int hma;
    public int hmb;
    public int hmc;
    public int hmd;
    public int hme;
    public int hmf;
    public int hmg;
    int hmh;
    public int hmi;
    public int hmj;
    public int hmk;
    public long hml;
    public int hmm;
    JSONObject kLx = null;
    String model = Build.MODEL;

    public static a azP() {
        if (hlJ == null) {
            reset();
        }
        return hlJ;
    }

    public static void reset() {
        a aVar = new a();
        hlJ = aVar;
        aVar.hlL = ((ActivityManager) aa.getContext().getSystemService("activity")).getLargeMemoryClass();
        hlJ.hlM = b.azK();
        hlJ.hlN = l.ry();
        Point ch = b.ch(aa.getContext());
        hlJ.hlO = ch.x;
        hlJ.hlP = ch.y;
    }

    public final String bRQ() {
        if (this.kLx == null) {
            try {
                this.kLx = new JSONObject();
                JSONObject jSONObject = new JSONObject();
                this.kLx.put("wxcamera", jSONObject);
                jSONObject.put("model", this.model);
                jSONObject.put("apiLevel", this.hlK);
                jSONObject.put("screen", String.format("%dx%d", new Object[]{Integer.valueOf(this.hlO), Integer.valueOf(this.hlP)}));
                jSONObject.put("crop", String.format("%dx%d", new Object[]{Integer.valueOf(this.hlU), Integer.valueOf(this.hlV)}));
                jSONObject.put("preview", String.format("%dx%d", new Object[]{Integer.valueOf(this.hlW), Integer.valueOf(this.hlX)}));
                jSONObject.put("encoder", String.format("%dx%d", new Object[]{Integer.valueOf(this.hlY), Integer.valueOf(this.hlZ)}));
                jSONObject.put("rotate", this.cdi);
                jSONObject.put("deviceoutfps", this.hma);
                jSONObject.put("recordfps", this.hmb);
                jSONObject.put("recordertype", this.hmc);
                jSONObject.put("needRotateEachFrame", this.ceS);
                jSONObject.put("isNeedRealtimeScale", this.hmd);
                jSONObject.put("resolutionLimit", this.hme);
                jSONObject.put("videoBitrate", this.cGx);
                jSONObject.put("wait2playtime", this.hml);
                jSONObject.put("useback", this.hmm);
                jSONObject.put("presetIndex", g.hns != null ? g.hns.fWf : -1);
            } catch (Throwable e) {
                v.a("MicroMsg.CaptureStatistics", e, "buildJson error", new Object[0]);
            }
        }
        return this.kLx.toString();
    }
}
