package com.tencent.mm.modelvoice;

import com.tencent.mm.c.b.a;
import com.tencent.mm.c.b.b;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.h;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class t implements a {
    private static int aVI = 100;
    String aST = SQLiteDatabase.KeyEmpty;
    private b aVG;
    private h.a djN = null;
    private int status = 0;

    public final int getStatus() {
        return this.status;
    }

    public final int pc() {
        b bVar = this.aVG;
        return ((bVar.aTG == com.tencent.mm.compatible.b.b.a.PCM || bVar.aTG == com.tencent.mm.compatible.b.b.a.SILK) && bVar.aTF != null) ? bVar.aTF.aUs : 1;
    }

    public final void a(h.a aVar) {
        this.djN = aVar;
    }

    public t(com.tencent.mm.compatible.b.b.a aVar) {
        this.aVG = new b(aVar);
    }

    public final boolean bx(String str) {
        g.a aVar = new g.a();
        if (this.aST.length() > 0) {
            v.e("VoiceRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
            return false;
        }
        this.aST = str;
        try {
            this.aVG.a(new b.a(this) {
                final /* synthetic */ t djO;

                {
                    this.djO = r1;
                }

                public final void onError() {
                    if (this.djO.djN != null) {
                        this.djO.djN.onError();
                    }
                    try {
                        this.djO.aVG.release();
                        this.djO.status = -1;
                    } catch (Exception e) {
                        v.e("VoiceRecorder", "setErrorListener File[" + this.djO.aST + "] ErrMsg[" + e.getStackTrace() + "]");
                    }
                }
            });
            this.aVG.pe();
            this.aVG.pf();
            this.aVG.pd();
            this.aVG.setOutputFile(this.aST);
            this.aVG.setMaxDuration(70000);
            this.aVG.prepare();
            this.aVG.start();
            v.d("VoiceRecorder", "StartRecord File[" + this.aST + "] start time:" + aVar.sn());
            this.status = 1;
            return true;
        } catch (Exception e) {
            v.e("VoiceRecorder", "StartRecord File[" + this.aST + "] ErrMsg[" + e.getMessage() + "]");
            this.status = -1;
            return false;
        }
    }

    public final boolean pb() {
        if (this.aVG == null) {
            return true;
        }
        try {
            this.aVG.ph();
            this.aVG.release();
            this.aST = SQLiteDatabase.KeyEmpty;
            this.status = 0;
            return true;
        } catch (Exception e) {
            v.e("VoiceRecorder", "StopRecord File[" + this.aST + "] ErrMsg[" + e.getMessage() + "]");
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
