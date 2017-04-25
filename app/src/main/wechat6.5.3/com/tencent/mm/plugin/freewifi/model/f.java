package com.tencent.mm.plugin.freewifi.model;

import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.v;

public final class f {
    private b fYJ;

    private static class a {
        private static f fYK = new f();
    }

    public static final class b {
        public long fYB;
        public String fYL;
        public String fYM;
        public String fYN;
        public boolean fYO;

        b(String str, String str2, String str3, long j) {
            this.fYL = m.tz(str);
            this.fYM = str2;
            this.fYN = str3;
            this.fYB = j;
            this.fYO = false;
        }
    }

    private f() {
    }

    public final synchronized void apc() {
        if (this.fYJ != null) {
            v.i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "last WifiInfo stored in memmory : ssid=%s, bssid=%s ", new Object[]{this.fYJ.fYL, this.fYJ.fYM});
        } else {
            v.i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "last WifiInfo stored in memmory is null.");
        }
        this.fYJ = null;
        v.i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "new WifiInfo stored in memmory is null.");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean a(android.net.wifi.WifiInfo r9) {
        /*
        r8 = this;
        r7 = 1;
        r0 = 0;
        monitor-enter(r8);
        if (r9 == 0) goto L_0x0017;
    L_0x0005:
        r1 = r9.getSSID();	 Catch:{ all -> 0x00b8 }
        if (r1 == 0) goto L_0x0017;
    L_0x000b:
        r1 = r9.getBSSID();	 Catch:{ all -> 0x00b8 }
        if (r1 == 0) goto L_0x0017;
    L_0x0011:
        r1 = r9.getMacAddress();	 Catch:{ all -> 0x00b8 }
        if (r1 != 0) goto L_0x0022;
    L_0x0017:
        r1 = "MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi";
        r2 = "WifiInfo got Currently is null. Cannot compared with last WifiInfo.";
        com.tencent.mm.sdk.platformtools.v.i(r1, r2);	 Catch:{ all -> 0x00b8 }
    L_0x0020:
        monitor-exit(r8);
        return r0;
    L_0x0022:
        r1 = r8.fYJ;	 Catch:{ all -> 0x00b8 }
        if (r1 == 0) goto L_0x00ae;
    L_0x0026:
        r1 = "MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi";
        r2 = "last WifiInfo stored in memmory : ssid=%s, bssid=%s ";
        r3 = 2;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x00b8 }
        r4 = 0;
        r5 = r8.fYJ;	 Catch:{ all -> 0x00b8 }
        r5 = r5.fYL;	 Catch:{ all -> 0x00b8 }
        r3[r4] = r5;	 Catch:{ all -> 0x00b8 }
        r4 = 1;
        r5 = r8.fYJ;	 Catch:{ all -> 0x00b8 }
        r5 = r5.fYM;	 Catch:{ all -> 0x00b8 }
        r3[r4] = r5;	 Catch:{ all -> 0x00b8 }
        com.tencent.mm.sdk.platformtools.v.i(r1, r2, r3);	 Catch:{ all -> 0x00b8 }
        r1 = r9.getSSID();	 Catch:{ all -> 0x00b8 }
        r1 = com.tencent.mm.plugin.freewifi.m.tz(r1);	 Catch:{ all -> 0x00b8 }
        r2 = r8.fYJ;	 Catch:{ all -> 0x00b8 }
        r2 = r2.fYL;	 Catch:{ all -> 0x00b8 }
        r1 = r1.equals(r2);	 Catch:{ all -> 0x00b8 }
        if (r1 == 0) goto L_0x0060;
    L_0x0052:
        r1 = r9.getBSSID();	 Catch:{ all -> 0x00b8 }
        r2 = r8.fYJ;	 Catch:{ all -> 0x00b8 }
        r2 = r2.fYM;	 Catch:{ all -> 0x00b8 }
        r1 = r1.equalsIgnoreCase(r2);	 Catch:{ all -> 0x00b8 }
        if (r1 != 0) goto L_0x0020;
    L_0x0060:
        r3 = r9.getMacAddress();	 Catch:{ all -> 0x00b8 }
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x00b8 }
        r1 = 22;
        if (r0 <= r1) goto L_0x0079;
    L_0x006a:
        if (r3 == 0) goto L_0x0075;
    L_0x006c:
        r0 = "02:00:00:00:00:00";
        r0 = r3.equals(r0);	 Catch:{ all -> 0x00b8 }
        if (r0 == 0) goto L_0x0079;
    L_0x0075:
        r3 = com.tencent.mm.plugin.freewifi.m.aoD();	 Catch:{ all -> 0x00b8 }
    L_0x0079:
        r0 = new com.tencent.mm.plugin.freewifi.model.f$b;	 Catch:{ all -> 0x00b8 }
        r1 = r9.getSSID();	 Catch:{ all -> 0x00b8 }
        r1 = com.tencent.mm.plugin.freewifi.m.tz(r1);	 Catch:{ all -> 0x00b8 }
        r2 = r9.getBSSID();	 Catch:{ all -> 0x00b8 }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x00b8 }
        r6 = 0;
        r0.<init>(r1, r2, r3, r4);	 Catch:{ all -> 0x00b8 }
        r8.fYJ = r0;	 Catch:{ all -> 0x00b8 }
        r0 = "MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi";
        r1 = "new WifiInfo stored in memmory : ssid=%s, bssid=%s ";
        r2 = 2;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x00b8 }
        r3 = 0;
        r4 = r8.fYJ;	 Catch:{ all -> 0x00b8 }
        r4 = r4.fYL;	 Catch:{ all -> 0x00b8 }
        r2[r3] = r4;	 Catch:{ all -> 0x00b8 }
        r3 = 1;
        r4 = r8.fYJ;	 Catch:{ all -> 0x00b8 }
        r4 = r4.fYM;	 Catch:{ all -> 0x00b8 }
        r2[r3] = r4;	 Catch:{ all -> 0x00b8 }
        com.tencent.mm.sdk.platformtools.v.i(r0, r1, r2);	 Catch:{ all -> 0x00b8 }
        r0 = r7;
        goto L_0x0020;
    L_0x00ae:
        r0 = "MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi";
        r1 = "last WifiInfo stored in memmory is null.";
        com.tencent.mm.sdk.platformtools.v.i(r0, r1);	 Catch:{ all -> 0x00b8 }
        goto L_0x0060;
    L_0x00b8:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.model.f.a(android.net.wifi.WifiInfo):boolean");
    }

    public final synchronized b apd() {
        return this.fYJ;
    }

    public final synchronized void ape() {
        if (this.fYJ != null) {
            b bVar;
            b bVar2 = this.fYJ;
            if (bVar2.fYO) {
                bVar = bVar2;
            } else {
                bVar = new b(bVar2.fYL, bVar2.fYM, bVar2.fYN, bVar2.fYB);
                bVar.fYO = true;
            }
            this.fYJ = bVar;
        }
    }
}
