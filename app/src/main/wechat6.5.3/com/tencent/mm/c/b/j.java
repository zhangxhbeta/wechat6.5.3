package com.tencent.mm.c.b;

import com.tencent.mm.compatible.util.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;

public final class j {
    private static int aVI = 100;
    String aST = "";
    private b aVF = new b(aa.getContext());
    private b aVG = new b(com.tencent.mm.compatible.b.b.a.caU);
    public a aVH = null;
    private int status = 0;

    public interface a {
        void onError();
    }

    public final boolean bz(String str) {
        com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
        if (this.aST.length() > 0) {
            v.e("MicroMsg.SimpleVoiceRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
            return false;
        }
        this.aST = str;
        try {
            this.aVF.requestFocus();
            this.aVG.a(new com.tencent.mm.c.b.b.a(this) {
                final /* synthetic */ j aVJ;

                {
                    this.aVJ = r1;
                }

                public final void onError() {
                    this.aVJ.aVF.si();
                    if (this.aVJ.aVH != null) {
                        this.aVJ.aVH.onError();
                    }
                    try {
                        this.aVJ.aVG.release();
                        this.aVJ.status = -1;
                    } catch (Exception e) {
                        v.e("MicroMsg.SimpleVoiceRecorder", "setErrorListener File[" + this.aVJ.aST + "] ErrMsg[" + e.getStackTrace() + "]");
                    }
                }
            });
            this.aVG.pe();
            this.aVG.pf();
            this.aVG.pd();
            this.aVG.setOutputFile(this.aST);
            this.aVG.setMaxDuration(3600010);
            this.aVG.prepare();
            this.aVG.start();
            v.d("MicroMsg.SimpleVoiceRecorder", "StartRecord File[" + this.aST + "] start time:" + aVar.sn());
            this.status = 1;
            return true;
        } catch (Exception e) {
            this.aVF.si();
            v.e("MicroMsg.SimpleVoiceRecorder", "StartRecord File[" + this.aST + "] ErrMsg[" + e.getMessage() + "]");
            this.status = -1;
            return false;
        }
    }

    public final boolean pb() {
        this.aVF.si();
        if (this.aVG == null) {
            return true;
        }
        try {
            this.aVG.ph();
            this.aVG.release();
            this.aST = "";
            this.status = 0;
            return true;
        } catch (Exception e) {
            v.e("MicroMsg.SimpleVoiceRecorder", "StopRecord File[" + this.aST + "] ErrMsg[" + e.getMessage() + "]");
            this.status = -1;
            return false;
        }
    }

    public final int getMaxAmplitude() {
        if (this.status != 1) {
            return 0;
        }
        int maxAmplitude = this.aVG.getMaxAmplitude();
        if (maxAmplitude > aVI) {
            aVI = maxAmplitude;
        }
        return (maxAmplitude * 100) / aVI;
    }
}
