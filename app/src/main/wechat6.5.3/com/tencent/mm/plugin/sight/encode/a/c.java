package com.tencent.mm.plugin.sight.encode.a;

import android.media.MediaRecorder;
import android.os.Message;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.sight.encode.a.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class c implements a {
    private ac hov = new ac(this, ak.vA().htb.getLooper()) {
        final /* synthetic */ c iWR;

        public final void handleMessage(Message message) {
            if (this.iWR.iWQ != null) {
                this.iWR.iWQ.aAu();
                this.iWR.iWQ = null;
            }
        }
    };
    private MediaRecorder iWO;
    private int iWP;
    a iWQ;

    public final int a(com.tencent.mm.plugin.sight.encode.a.a.a r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = 0;
        r7.iWQ = r8;
        r1 = r7.iWO;	 Catch:{ Exception -> 0x0017, all -> 0x0032 }
        if (r1 == 0) goto L_0x0011;	 Catch:{ Exception -> 0x0017, all -> 0x0032 }
    L_0x0007:
        r1 = r7.iWO;	 Catch:{ Exception -> 0x0017, all -> 0x0032 }
        r1.prepare();	 Catch:{ Exception -> 0x0017, all -> 0x0032 }
        r1 = r7.iWO;	 Catch:{ Exception -> 0x0017, all -> 0x0032 }
        r1.start();	 Catch:{ Exception -> 0x0017, all -> 0x0032 }
    L_0x0011:
        r1 = r7.hov;
        r1.sendEmptyMessage(r0);
    L_0x0016:
        return r0;
    L_0x0017:
        r1 = move-exception;
        r2 = "MicroMsg.SightAACEncoder";	 Catch:{ Exception -> 0x0017, all -> 0x0032 }
        r3 = "start record aac.mp4 error:%s";	 Catch:{ Exception -> 0x0017, all -> 0x0032 }
        r4 = 1;	 Catch:{ Exception -> 0x0017, all -> 0x0032 }
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0017, all -> 0x0032 }
        r5 = 0;	 Catch:{ Exception -> 0x0017, all -> 0x0032 }
        r6 = r1.getMessage();	 Catch:{ Exception -> 0x0017, all -> 0x0032 }
        r4[r5] = r6;	 Catch:{ Exception -> 0x0017, all -> 0x0032 }
        com.tencent.mm.sdk.platformtools.v.a(r2, r1, r3, r4);	 Catch:{ Exception -> 0x0017, all -> 0x0032 }
        r1 = r7.hov;
        r1.sendEmptyMessage(r0);
        r0 = -1;
        goto L_0x0016;
    L_0x0032:
        r1 = move-exception;
        r2 = r7.hov;
        r2.sendEmptyMessage(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sight.encode.a.c.a(com.tencent.mm.plugin.sight.encode.a.a$a):int");
    }

    public final int aa(int i, String str) {
        v.i("MicroMsg.SightAACEncoder", "sight aac encoder init, bufID[%d] tempPath[%s], sampleRate[%d]", Integer.valueOf(i), str, Integer.valueOf(b.aOO()));
        this.iWP = i;
        this.iWO = new MediaRecorder();
        try {
            this.iWO.setAudioSource(5);
        } catch (Throwable e) {
            v.a("MicroMsg.SightAACEncoder", e, "Set Audio Source CAMCORDER FAIL", SQLiteDatabase.KeyEmpty);
            this.iWO.setAudioSource(1);
        }
        this.iWO.setOutputFormat(2);
        this.iWO.setAudioEncoder(3);
        this.iWO.setAudioChannels(1);
        this.iWO.setAudioEncodingBitRate(b.aOP());
        this.iWO.setAudioSamplingRate(b.aOO());
        this.iWO.setOutputFile(str);
        return 0;
    }

    public final int a(a.b bVar) {
        if (this.iWO != null) {
            try {
                this.iWO.stop();
                this.iWO.release();
                this.iWO = null;
                if (bVar == null) {
                    return 0;
                }
                bVar.aAv();
                return 0;
            } catch (Throwable e) {
                v.a("MicroMsg.SightAACEncoder", e, "stop record aac.mp4 error:%s", e.getMessage());
                return -1;
            }
        } else if (bVar == null) {
            return 0;
        } else {
            bVar.aAv();
            return 0;
        }
    }

    public final void aPN() {
    }

    public final int aPM() {
        return this.iWP;
    }
}
