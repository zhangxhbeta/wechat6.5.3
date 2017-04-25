package com.tencent.mm.plugin.voiceprint.model;

import android.os.Message;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

public final class p implements com.tencent.mm.compatible.b.d.a {
    public static int aVI = 100;
    public String aST = "";
    public k aSV = null;
    public com.tencent.mm.compatible.util.b djL;
    private int ete = 0;
    public long fTb = 0;
    public boolean kfK = false;
    public int kfN = 0;
    public b koW;
    public String koX;
    public boolean koY = false;
    public a koZ = null;

    public interface a {
        void baV();
    }

    private final class b extends Thread {
        ac handler;
        final /* synthetic */ p kpa;

        public b(final p pVar) {
            this.kpa = pVar;
            this.handler = new ac(this) {
                final /* synthetic */ b kpc;

                public final void handleMessage(Message message) {
                    if (this.kpc.kpa.kfN > 0) {
                        this.kpc.kpa.kfN = 2;
                    }
                }
            };
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            r7 = this;
            r6 = 0;
            r0 = r7.kpa;
            r0 = r0.aSV;
            if (r0 != 0) goto L_0x0013;
        L_0x0009:
            r0 = "MicroMsg.VoicePrintRecoder";
            r1 = "Stop Record Failed recorder == null";
            com.tencent.mm.sdk.platformtools.v.e(r0, r1);
        L_0x0012:
            return;
        L_0x0013:
            r1 = r7.kpa;
            monitor-enter(r1);
            r0 = r7.kpa;	 Catch:{ all -> 0x00ac }
            r0 = r0.aST;	 Catch:{ all -> 0x00ac }
            r2 = 1;
            r0 = com.tencent.mm.plugin.voiceprint.model.m.as(r0, r2);	 Catch:{ all -> 0x00ac }
            r2 = "MicroMsg.VoicePrintRecoder";
            r3 = "fullPathName %s";
            r4 = 1;
            r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00ac }
            r5 = 0;
            r4[r5] = r0;	 Catch:{ all -> 0x00ac }
            com.tencent.mm.sdk.platformtools.v.d(r2, r3, r4);	 Catch:{ all -> 0x00ac }
            r2 = r7.kpa;	 Catch:{ all -> 0x00ac }
            r2.koX = r0;	 Catch:{ all -> 0x00ac }
            r2 = r7.kpa;	 Catch:{ all -> 0x00ac }
            r2 = r2.djL;	 Catch:{ all -> 0x00ac }
            if (r2 == 0) goto L_0x0045;
        L_0x003c:
            r2 = r7.kpa;	 Catch:{ all -> 0x00ac }
            r2 = r2.djL;	 Catch:{ all -> 0x00ac }
            r2.requestFocus();	 Catch:{ all -> 0x00ac }
        L_0x0045:
            r2 = r7.kpa;	 Catch:{ all -> 0x00ac }
            r2 = r2.aSV;	 Catch:{ all -> 0x00ac }
            r0 = r2.bx(r0);	 Catch:{ all -> 0x00ac }
            if (r0 != 0) goto L_0x00af;
        L_0x0051:
            r0 = r7.kpa;	 Catch:{ all -> 0x00ac }
            r0.aST = null;	 Catch:{ all -> 0x00ac }
            r0 = "MicroMsg.VoicePrintRecoder";
            r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ac }
            r3 = "Thread Start Record  Error fileName[";
            r2.<init>(r3);	 Catch:{ all -> 0x00ac }
            r3 = r7.kpa;	 Catch:{ all -> 0x00ac }
            r3 = r3.aST;	 Catch:{ all -> 0x00ac }
            r2 = r2.append(r3);	 Catch:{ all -> 0x00ac }
            r3 = "]";
            r2 = r2.append(r3);	 Catch:{ all -> 0x00ac }
            r2 = r2.toString();	 Catch:{ all -> 0x00ac }
            com.tencent.mm.sdk.platformtools.v.d(r0, r2);	 Catch:{ all -> 0x00ac }
            r0 = r7.kpa;	 Catch:{ all -> 0x00ac }
            r0 = r0.aSV;	 Catch:{ all -> 0x00ac }
            r0.pb();	 Catch:{ all -> 0x00ac }
            r0 = r7.kpa;	 Catch:{ all -> 0x00ac }
            r0.aSV = null;	 Catch:{ all -> 0x00ac }
            r0 = r7.kpa;	 Catch:{ all -> 0x00ac }
            r0 = r0.djL;	 Catch:{ all -> 0x00ac }
            if (r0 == 0) goto L_0x0098;
        L_0x008f:
            r0 = r7.kpa;	 Catch:{ all -> 0x00ac }
            r0 = r0.djL;	 Catch:{ all -> 0x00ac }
            r0.si();	 Catch:{ all -> 0x00ac }
        L_0x0098:
            r0 = r7.kpa;	 Catch:{ all -> 0x00ac }
            r0 = r0.koZ;	 Catch:{ all -> 0x00ac }
            if (r0 == 0) goto L_0x00a9;
        L_0x00a0:
            r0 = r7.kpa;	 Catch:{ all -> 0x00ac }
            r0 = r0.koZ;	 Catch:{ all -> 0x00ac }
            r0.baV();	 Catch:{ all -> 0x00ac }
        L_0x00a9:
            monitor-exit(r1);	 Catch:{ all -> 0x00ac }
            goto L_0x0012;
        L_0x00ac:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x00ac }
            throw r0;
        L_0x00af:
            r0 = r7.kpa;	 Catch:{ all -> 0x00ac }
            r2 = com.tencent.mm.sdk.platformtools.be.Nj();	 Catch:{ all -> 0x00ac }
            r0.fTb = r2;	 Catch:{ all -> 0x00ac }
            r0 = "MicroMsg.VoicePrintRecoder";
            r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ac }
            r3 = "Thread Started Record fileName[";
            r2.<init>(r3);	 Catch:{ all -> 0x00ac }
            r3 = r7.kpa;	 Catch:{ all -> 0x00ac }
            r3 = r3.aST;	 Catch:{ all -> 0x00ac }
            r2 = r2.append(r3);	 Catch:{ all -> 0x00ac }
            r3 = "]";
            r2 = r2.append(r3);	 Catch:{ all -> 0x00ac }
            r2 = r2.toString();	 Catch:{ all -> 0x00ac }
            com.tencent.mm.sdk.platformtools.v.d(r0, r2);	 Catch:{ all -> 0x00ac }
            monitor-exit(r1);	 Catch:{ all -> 0x00ac }
            r0 = r7.handler;
            r2 = 1;
            r0.sendEmptyMessageDelayed(r6, r2);
            goto L_0x0012;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.voiceprint.model.p.b.run():void");
        }
    }

    public final void cK(int i) {
        v.d("MicroMsg.VoicePrintRecoder", " Recorder onBluetoothHeadsetStateChange :" + i);
        if (!this.kfK) {
            this.kfK = true;
            ak.yX().b(this);
            this.aSV = new k();
            this.koW = new b(this);
            this.koW.start();
            this.koY = false;
            this.kfN = 1;
        }
    }

    public final boolean ph() {
        long j = 0;
        ak.yX().qT();
        this.koY = false;
        v.d("MicroMsg.VoicePrintRecoder", "stop Record :" + this.aST);
        synchronized (this) {
            v.d("MicroMsg.VoicePrintRecoder", "stop synchronized Record :" + this.aST);
            if (this.aSV != null) {
                this.aSV.pb();
            }
        }
        if (this.kfN != 2) {
            this.aST = null;
            this.koY = false;
            v.d("MicroMsg.VoicePrintRecoder", "Stop " + this.aST);
        } else {
            if (this.fTb > 0) {
                j = be.az(this.fTb);
            }
            this.ete = (int) j;
            if (this.ete < BaseReportManager.MAX_READ_COUNT) {
                v.d("MicroMsg.VoicePrintRecoder", "Stop " + this.aST + " by voiceLen: " + this.ete);
                this.aST = "";
                this.koY = false;
            } else {
                this.koY = true;
                v.d("MicroMsg.VoicePrintRecoder", "Stop file success: " + this.aST);
            }
            this.aST = "";
        }
        this.kfN = -1;
        v.d("MicroMsg.VoicePrintRecoder", "bLongEnough " + this.koY);
        if (this.djL != null) {
            this.djL.si();
        }
        return this.koY;
    }
}
