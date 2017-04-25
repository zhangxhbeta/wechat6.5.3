package com.tencent.mm.plugin.freewifi.model;

import android.content.Intent;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.net.HttpURLConnection;
import java.net.URL;

public final class g {
    int fYP = 5;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ int fXS;
        final /* synthetic */ b fYQ;
        final /* synthetic */ g fYR;
        final /* synthetic */ String fYd;
        final /* synthetic */ Intent val$intent;

        AnonymousClass1(g gVar, String str, Intent intent, b bVar, int i) {
            this.fYR = gVar;
            this.fYd = str;
            this.val$intent = intent;
            this.fYQ = bVar;
            this.fXS = i;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            r10 = this;
            r9 = 3;
            r8 = 2;
            r7 = 0;
            r6 = 1;
            r0 = r10.fYR;
            r0 = r0.fYP;
        L_0x0008:
            r1 = r0 + -1;
            if (r0 <= 0) goto L_0x00c0;
        L_0x000c:
            r0 = "MicroMsg.FreeWifi.FreeWifiNetwork";
            r2 = "now retry count = %d";
            r3 = new java.lang.Object[r6];
            r4 = java.lang.Integer.valueOf(r1);
            r3[r7] = r4;
            com.tencent.mm.sdk.platformtools.v.i(r0, r2, r3);
            r0 = r10.fYd;
            r2 = r10.val$intent;
            com.tencent.mm.plugin.freewifi.model.g.b(r0, r6, r2);
            r0 = com.tencent.mm.h.j.sV();
            r0 = r0.sP();
            r2 = "MicroMsg.FreeWifi.FreeWifiNetwork";
            r3 = "get check url from cinfig : %s";
            r4 = new java.lang.Object[r6];
            r4[r7] = r0;
            com.tencent.mm.sdk.platformtools.v.i(r2, r3, r4);
            r2 = com.tencent.mm.sdk.platformtools.be.kS(r0);
            if (r2 == 0) goto L_0x0052;
        L_0x003f:
            r0 = "MicroMsg.FreeWifi.FreeWifiNetwork";
            r2 = "get check url from config failed, use the default url : %s";
            r3 = new java.lang.Object[r6];
            r4 = "http://10.1.0.6/redirect";
            r3[r7] = r4;
            com.tencent.mm.sdk.platformtools.v.i(r0, r2, r3);
            r0 = "http://10.1.0.6/redirect";
        L_0x0052:
            r2 = com.tencent.mm.plugin.freewifi.model.g.tL(r0);
            r3 = "MicroMsg.FreeWifi.FreeWifiNetwork";
            r4 = "get location from url : %s, %s";
            r5 = new java.lang.Object[r8];
            r5[r7] = r0;
            r5[r6] = r2;
            com.tencent.mm.sdk.platformtools.v.i(r3, r4, r5);
            r3 = com.tencent.mm.sdk.platformtools.be.kS(r2);
            if (r3 == 0) goto L_0x0084;
        L_0x006b:
            r3 = "MicroMsg.FreeWifi.FreeWifiNetwork";
            r4 = "get location from url failed : %s, %s";
            r5 = new java.lang.Object[r8];
            r5[r7] = r0;
            r5[r6] = r2;
            com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);
            r2 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
            java.lang.Thread.sleep(r2);	 Catch:{ Exception -> 0x0081 }
            r0 = r1;
            goto L_0x0008;
        L_0x0081:
            r0 = move-exception;
            r0 = r1;
            goto L_0x0008;
        L_0x0084:
            r0 = "auth=";
            r0 = com.tencent.mm.plugin.freewifi.model.g.bD(r2, r0);
            r1 = "MicroMsg.FreeWifi.FreeWifiNetwork";
            r3 = "get apauthmessage from location : %s, %s";
            r4 = new java.lang.Object[r8];
            r4[r7] = r0;
            r4[r6] = r2;
            com.tencent.mm.sdk.platformtools.v.i(r1, r3, r4);
            r1 = com.tencent.mm.sdk.platformtools.be.kS(r0);
            if (r1 == 0) goto L_0x00b4;
        L_0x00a0:
            r1 = "MicroMsg.FreeWifi.FreeWifiNetwork";
            r3 = "get apauth message from location failed : %s";
            r4 = new java.lang.Object[r6];
            r4[r7] = r2;
            com.tencent.mm.sdk.platformtools.v.e(r1, r3, r4);
            r1 = r10.fYd;
            r2 = r10.val$intent;
            com.tencent.mm.plugin.freewifi.model.g.b(r1, r9, r2);
        L_0x00b4:
            r1 = r10.fYQ;
            if (r1 == 0) goto L_0x00bf;
        L_0x00b8:
            r1 = r10.fYQ;
            r2 = r10.fXS;
            r1.az(r0, r2);
        L_0x00bf:
            return;
        L_0x00c0:
            r0 = r10.fYQ;
            if (r0 == 0) goto L_0x00cc;
        L_0x00c4:
            r0 = r10.fYQ;
            r1 = 0;
            r2 = r10.fXS;
            r0.az(r1, r2);
        L_0x00cc:
            r0 = r10.fYd;
            r1 = r10.val$intent;
            com.tencent.mm.plugin.freewifi.model.g.b(r0, r9, r1);
            goto L_0x00bf;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.model.g.1.run():void");
        }
    }

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ g fYR;
        final /* synthetic */ String fYS;
        final /* synthetic */ a fYT = null;
        final /* synthetic */ String fYd;
        final /* synthetic */ Intent val$intent;

        AnonymousClass2(g gVar, String str, String str2, Intent intent, a aVar) {
            this.fYR = gVar;
            this.fYS = str;
            this.fYd = str2;
            this.val$intent = intent;
        }

        public final void run() {
            String tL = g.tL(this.fYS);
            v.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get redirect location from loginurl : %s, %s", new Object[]{tL, this.fYS});
            if (!be.kS(tL)) {
                String bD = g.bD(tL, "res=");
                v.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get connect result from location : %s, %s", new Object[]{bD, tL});
                if (!be.kS(bD) && (bD.startsWith("success") || bD.startsWith("already"))) {
                    g.b(this.fYd, 2, this.val$intent);
                    j.apj().tQ(this.fYd);
                    return;
                }
            }
            g.b(this.fYd, 3, this.val$intent);
        }
    }

    public interface a {
    }

    public interface b {
        void az(String str, int i);
    }

    static /* synthetic */ void b(String str, int i, Intent intent) {
        v.i("MicroMsg.FreeWifi.FreeWifiNetwork", "update ssid  : %s to new state : %d", new Object[]{str, Integer.valueOf(i)});
        if (i == 3) {
            v.e("MicroMsg.FreeWifi.FreeWifiNetwork", "new state is connect failed, update local freewifiinfo expired time to now");
            c tO = j.apj().tO(str);
            if (tO != null) {
                tO.field_expiredTime = be.Nh() - 10;
                boolean a = j.apj().a(tO, new String[0]);
                v.i("MicroMsg.FreeWifi.FreeWifiNetwork", "update local freewifi info expired time : ssid is : %s, now time is : %d, update ret : %b", new Object[]{str, Long.valueOf(tO.field_expiredTime), Boolean.valueOf(a)});
            }
        }
        d.a(str, i, intent);
    }

    static /* synthetic */ String bD(String str, String str2) {
        if (be.kS(str)) {
            v.e("MicroMsg.FreeWifi.FreeWifiNetwork", "null or nil header");
        } else {
            String[] split = str.split("\\?");
            String[] split2 = str2.length() > 0 ? split[1].split("&") : split;
            if (split2 != null && split2.length > 0) {
                for (String str3 : split2) {
                    if (str3.startsWith(str2)) {
                        return str3.substring(str2.length());
                    }
                }
            }
        }
        return null;
    }

    static String tL(String str) {
        HttpURLConnection httpURLConnection;
        Exception exception;
        Throwable th;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection2 != null) {
                try {
                    httpURLConnection2.setConnectTimeout(30000);
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    int responseCode = httpURLConnection2.getResponseCode();
                    v.i("MicroMsg.FreeWifi.FreeWifiNetwork", "code : %d, location : %s", new Object[]{Integer.valueOf(responseCode), httpURLConnection2.getHeaderField("Location")});
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return r1;
                } catch (Exception e) {
                    Exception exception2 = e;
                    httpURLConnection = httpURLConnection2;
                    exception = exception2;
                    try {
                        v.e("MicroMsg.FreeWifi.FreeWifiNetwork", "get recirect location failed : %s", new Object[]{exception.getMessage()});
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    httpURLConnection = httpURLConnection2;
                    th = th4;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            }
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            return null;
        } catch (Exception e2) {
            exception = e2;
            httpURLConnection = null;
            v.e("MicroMsg.FreeWifi.FreeWifiNetwork", "get recirect location failed : %s", new Object[]{exception.getMessage()});
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return null;
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }
}
