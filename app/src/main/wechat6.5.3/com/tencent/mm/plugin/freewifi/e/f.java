package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.plugin.freewifi.c;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.sdk.platformtools.v;

public final class f extends e implements a {
    private String fWC = this.intent.getStringExtra("free_wifi_passowrd");

    public f(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        super(freeWifiFrontPageUI);
        v.i("MicroMsg.FreeWifi.ProtocolFour", "sessionKey=%s, step=%d, desc=Data retrieved. password=%s", new Object[]{m.s(this.intent), Integer.valueOf(m.t(this.intent)), this.fWC});
    }

    public final void connect() {
        final c cVar = new c(this.ssid, this.fZC, this.fWC);
        j.aph();
        j.apm().aoU().post(new Runnable(this) {
            final /* synthetic */ f fZH;

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                r8 = this;
                r5 = 1;
                r1 = 0;
                r2 = r0;
                r0 = new com.tencent.mm.plugin.freewifi.e.f$1$1;
                r0.<init>(r8);
                r3 = new com.tencent.mm.plugin.freewifi.c$1;
                r3.<init>(r2, r0);
                r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
                r4 = "connectivity";
                r0 = r0.getSystemService(r4);
                r0 = (android.net.ConnectivityManager) r0;
                r0 = r0.getNetworkInfo(r5);
                r0 = r0.isConnected();
                if (r0 == 0) goto L_0x0035;
            L_0x0025:
                r0 = r2.ssid;
                r4 = com.tencent.mm.plugin.freewifi.model.d.apb();
                r0 = r0.equals(r4);
                if (r0 == 0) goto L_0x0035;
            L_0x0031:
                r3.onSuccess();
            L_0x0034:
                return;
            L_0x0035:
                r0 = java.lang.Thread.currentThread();
                r4 = android.os.Looper.getMainLooper();
                r4 = r4.getThread();
                if (r0 != r4) goto L_0x004c;
            L_0x0043:
                r0 = new java.lang.RuntimeException;
                r1 = "ConnectNetworkHelper组件不能在主线程中运行。";
                r0.<init>(r1);
                throw r0;
            L_0x004c:
                r0 = new com.tencent.mm.plugin.freewifi.ConnectSsidPasswordHelper$2;
                r0.<init>(r2);
                r2.fWx = r0;
                r0 = new android.content.IntentFilter;
                r0.<init>();
                r4 = "android.net.wifi.STATE_CHANGE";
                r0.addAction(r4);
                r4 = "android.net.wifi.supplicant.STATE_CHANGE";
                r0.addAction(r4);
                r4 = r2.fWu;	 Catch:{ all -> 0x0131 }
                r4.lock();	 Catch:{ all -> 0x0131 }
                r4 = r2.aXH;	 Catch:{ all -> 0x0131 }
                r5 = r2.fWx;	 Catch:{ all -> 0x0131 }
                r4.registerReceiver(r5, r0);	 Catch:{ all -> 0x0131 }
                r0 = r2.aNW;	 Catch:{ all -> 0x0131 }
                r0 = r0.isWifiEnabled();	 Catch:{ all -> 0x0131 }
                if (r0 != 0) goto L_0x00a7;
            L_0x0078:
                r0 = new com.tencent.mm.plugin.freewifi.e;	 Catch:{ all -> 0x0131 }
                r4 = r2.aXH;	 Catch:{ all -> 0x0131 }
                r0.<init>(r4);	 Catch:{ all -> 0x0131 }
                r0 = r0.aoo();	 Catch:{ all -> 0x0131 }
                r4 = "MicroMsg.FreeWifi.ConnectSsidPasswordHelper";
                r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0131 }
                r6 = "enable ret = ";
                r5.<init>(r6);	 Catch:{ all -> 0x0131 }
                r5 = r5.append(r0);	 Catch:{ all -> 0x0131 }
                r5 = r5.toString();	 Catch:{ all -> 0x0131 }
                com.tencent.mm.sdk.platformtools.v.i(r4, r5);	 Catch:{ all -> 0x0131 }
                if (r0 == 0) goto L_0x00a7;
            L_0x009b:
                r3.kR(r0);	 Catch:{ all -> 0x0131 }
                r2.aom();
                r0 = r2.fWu;
                r0.unlock();
                goto L_0x0034;
            L_0x00a7:
                r0 = r2.ssid;	 Catch:{ all -> 0x0131 }
                r4 = r2.fWC;	 Catch:{ all -> 0x0131 }
                r5 = 3;
                r6 = 0;
                r0 = com.tencent.mm.plugin.freewifi.model.d.c(r0, r4, r5, r6);	 Catch:{ all -> 0x0131 }
                if (r0 == 0) goto L_0x00c3;
            L_0x00b3:
                r2.aom();	 Catch:{ all -> 0x0131 }
                r3.kR(r0);	 Catch:{ all -> 0x0131 }
                r2.aom();
                r0 = r2.fWu;
                r0.unlock();
                goto L_0x0034;
            L_0x00c3:
                r0 = r1;
            L_0x00c4:
                r1 = r2.connected;	 Catch:{ InterruptedException -> 0x00d7 }
                if (r1 != 0) goto L_0x0118;
            L_0x00c8:
                r1 = r2.fWB;	 Catch:{ InterruptedException -> 0x00d7 }
                if (r1 != 0) goto L_0x0118;
            L_0x00cc:
                r0 = r2.aPJ;	 Catch:{ InterruptedException -> 0x00d7 }
                r4 = r2.cAo;	 Catch:{ InterruptedException -> 0x00d7 }
                r1 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ InterruptedException -> 0x00d7 }
                r0 = r0.await(r4, r1);	 Catch:{ InterruptedException -> 0x00d7 }
                goto L_0x00c4;
            L_0x00d7:
                r0 = move-exception;
                r1 = "MicroMsg.FreeWifi.ConnectSsidPasswordHelper";
                r4 = "sessionKey=%s, step=%d, desc=ConnectNetworkHelper encounter interrupted exception. msg=%s";
                r5 = 3;
                r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0131 }
                r6 = 0;
                r7 = r2.aXH;	 Catch:{ all -> 0x0131 }
                r7 = r7.getIntent();	 Catch:{ all -> 0x0131 }
                r7 = com.tencent.mm.plugin.freewifi.m.s(r7);	 Catch:{ all -> 0x0131 }
                r5[r6] = r7;	 Catch:{ all -> 0x0131 }
                r6 = 1;
                r7 = r2.aXH;	 Catch:{ all -> 0x0131 }
                r7 = r7.getIntent();	 Catch:{ all -> 0x0131 }
                r7 = com.tencent.mm.plugin.freewifi.m.t(r7);	 Catch:{ all -> 0x0131 }
                r7 = java.lang.Integer.valueOf(r7);	 Catch:{ all -> 0x0131 }
                r5[r6] = r7;	 Catch:{ all -> 0x0131 }
                r6 = 2;
                r0 = r0.getMessage();	 Catch:{ all -> 0x0131 }
                r5[r6] = r0;	 Catch:{ all -> 0x0131 }
                com.tencent.mm.sdk.platformtools.v.i(r1, r4, r5);	 Catch:{ all -> 0x0131 }
                r0 = -17;
                r3.kR(r0);	 Catch:{ all -> 0x0131 }
                r2.aom();
                r0 = r2.fWu;
                r0.unlock();
                goto L_0x0034;
            L_0x0118:
                if (r0 != 0) goto L_0x0129;
            L_0x011a:
                r0 = -16;
                r3.kR(r0);	 Catch:{ all -> 0x0131 }
            L_0x011f:
                r2.aom();
                r0 = r2.fWu;
                r0.unlock();
                goto L_0x0034;
            L_0x0129:
                r0 = r2.connected;	 Catch:{ all -> 0x0131 }
                if (r0 == 0) goto L_0x013b;
            L_0x012d:
                r3.onSuccess();	 Catch:{ all -> 0x0131 }
                goto L_0x011f;
            L_0x0131:
                r0 = move-exception;
                r2.aom();
                r1 = r2.fWu;
                r1.unlock();
                throw r0;
            L_0x013b:
                r0 = r2.fWB;	 Catch:{ all -> 0x0131 }
                if (r0 == 0) goto L_0x011f;
            L_0x013f:
                r0 = -18;
                r3.kR(r0);	 Catch:{ all -> 0x0131 }
                goto L_0x011f;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.e.f.1.run():void");
            }
        });
    }
}
