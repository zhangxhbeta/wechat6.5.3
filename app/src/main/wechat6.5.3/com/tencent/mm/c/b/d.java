package com.tencent.mm.c.b;

import android.media.AudioRecord;
import android.media.AudioRecord.OnRecordPositionUpdateListener;
import android.os.HandlerThread;
import com.tencent.mm.c.b.c.a;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Arrays;

public final class d extends f {
    boolean aTY;
    AudioRecord aUm;
    a aUn;
    byte[] aUv = null;
    private int aUw;
    int aUx;
    boolean aUy;
    private OnRecordPositionUpdateListener aUz = new OnRecordPositionUpdateListener(this) {
        final /* synthetic */ d aUA;

        {
            this.aUA = r1;
        }

        public final void onMarkerReached(AudioRecord audioRecord) {
        }

        public final void onPeriodicNotification(AudioRecord audioRecord) {
            if (!this.aUA.aUP && this.aUA.aUm != null) {
                if (this.aUA.aTY || this.aUA.aUv == null) {
                    this.aUA.aUv = new byte[this.aUA.aUx];
                }
                int read = this.aUA.aUm.read(this.aUA.aUv, 0, this.aUA.aUx);
                v.d("MicroMsg.RecordModeAsyncCallback", "OnRecordPositionUpdateListener, read ret: " + read);
                if (this.aUA.aUt != null) {
                    this.aUA.aUt.c(read, this.aUA.aUv);
                }
                if (read > this.aUA.aUv.length) {
                    read = this.aUA.aUv.length;
                }
                if (this.aUA.aUy && read > 0) {
                    Arrays.fill(this.aUA.aUv, 0, read, (byte) 0);
                }
                if (this.aUA.aUn != null && read > 0) {
                    this.aUA.aUn.d(this.aUA.aUv, read);
                }
            }
        }
    };
    private HandlerThread sM = null;

    public d(AudioRecord audioRecord, a aVar, boolean z, int i, int i2) {
        this.aUm = audioRecord;
        this.aUn = aVar;
        this.aTY = z;
        this.aUw = i;
        this.aUx = i2;
    }

    public final boolean pj() {
        if (this.sM != null) {
            v.e("MicroMsg.RecordModeAsyncCallback", "alreay started record");
            return false;
        }
        this.sM = e.bJ("RecordModeAsyncCallback_handlerThread", 10);
        this.sM.start();
        this.aUm.setRecordPositionUpdateListener(this.aUz, ac.fetchFreeHandler(this.sM.getLooper()));
        this.aUm.setPositionNotificationPeriod(this.aUw);
        if (this.aTY || this.aUv == null) {
            this.aUv = new byte[this.aUx];
        }
        int read = this.aUm.read(this.aUv, 0, this.aUx);
        v.d("MicroMsg.RecordModeAsyncCallback", "startRecord, read ret: " + read);
        if (this.aUn != null && read > 0) {
            this.aUn.d(this.aUv, read);
        }
        return true;
    }

    public final void oT() {
        this.aUm.setRecordPositionUpdateListener(null);
        this.aUm = null;
        this.sM.quit();
        this.sM = null;
    }

    public final void an(boolean z) {
        this.aUy = z;
    }
}
