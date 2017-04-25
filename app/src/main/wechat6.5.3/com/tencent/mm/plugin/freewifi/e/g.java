package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.h.j;
import com.tencent.mm.plugin.freewifi.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.b;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.protocal.c.dq;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.net.HttpURLConnection;
import java.net.URL;

public final class g extends e implements a {
    private a fZJ;
    private int fZK = 5;

    class AnonymousClass4 implements Runnable {
        final /* synthetic */ g fZL;
        final /* synthetic */ String fZM;
        final /* synthetic */ dq fZN;

        AnonymousClass4(g gVar, String str, dq dqVar) {
            this.fZL = gVar;
            this.fZM = str;
            this.fZN = dqVar;
        }

        public final void run() {
            String tL = g.tL(this.fZM);
            v.i("MicroMsg.FreeWifi.ProtocolOne", "get redirect location from loginurl : %s, %s", new Object[]{tL, this.fZM});
            if (!be.kS(tL)) {
                String bE = g.bE(tL, "res=");
                v.i("MicroMsg.FreeWifi.ProtocolOne", "get connect result from location : %s, %s", new Object[]{bE, tL});
                if (!be.kS(bE) && (bE.startsWith("success") || bE.startsWith("already"))) {
                    FreeWifiFrontPageUI freeWifiFrontPageUI = this.fZL.fZC;
                    d dVar = d.SUCCESS;
                    b bVar = new b();
                    bVar.gbO = this.fZN;
                    freeWifiFrontPageUI.a(dVar, bVar);
                    return;
                }
            }
            this.fZL.apI();
        }
    }

    static /* synthetic */ void a(g gVar) {
        gVar.fZJ = new a(gVar.ssid, gVar.fZC);
        gVar.fZJ.a(new a.a(gVar) {
            final /* synthetic */ g fZL;

            {
                this.fZL = r1;
            }

            public final void onSuccess() {
                v.i("MicroMsg.FreeWifi.ProtocolOne", "sessionKey=%s, step=%d, desc=Network. ", new Object[]{m.s(this.fZL.intent), Integer.valueOf(m.t(this.fZL.intent))});
                g.b(this.fZL);
            }

            public final void kR(int i) {
                this.fZL.apI();
            }
        });
    }

    static /* synthetic */ void b(g gVar) {
        String tL;
        int i = gVar.fZK;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                break;
            }
            v.i("MicroMsg.FreeWifi.ProtocolOne", "now retry count = %d", new Object[]{Integer.valueOf(i2)});
            String sP = j.sV().sP();
            v.i("MicroMsg.FreeWifi.ProtocolOne", "get check url from cinfig : %s", new Object[]{sP});
            if (be.kS(sP)) {
                v.i("MicroMsg.FreeWifi.ProtocolOne", "get check url from config failed, use the default url : %s", new Object[]{"http://10.1.0.6/redirect"});
                sP = "http://10.1.0.6/redirect";
            }
            tL = tL(sP);
            v.i("MicroMsg.FreeWifi.ProtocolOne", "get location from url : %s, %s", new Object[]{sP, tL});
            if (!be.kS(tL)) {
                break;
            }
            v.e("MicroMsg.FreeWifi.ProtocolOne", "get location from url failed : %s, %s", new Object[]{sP, tL});
            try {
                Thread.sleep(500);
                i = i2;
            } catch (Exception e) {
                i = i2;
            }
        }
        String bE = bE(tL, "auth=");
        v.i("MicroMsg.FreeWifi.ProtocolOne", "get apauthmessage from location : %s, %s", new Object[]{bE, tL});
        if (be.kS(bE)) {
            v.e("MicroMsg.FreeWifi.ProtocolOne", "get apauth message from location failed : %s", new Object[]{tL});
            gVar.apI();
            return;
        }
        v.i("MicroMsg.FreeWifi.ProtocolOne", "get ap auth data : %s, url : %s, mac : %s", new Object[]{bE, gVar.fZD, com.tencent.mm.plugin.freewifi.model.d.aoW()});
        if (be.kS(bE)) {
            gVar.apI();
        } else {
            new com.tencent.mm.plugin.freewifi.d.a(gVar.fZD, gVar.ssid, r3, "", bE, "", gVar.aPW, m.s(gVar.intent)).b(new e(gVar) {
                final /* synthetic */ g fZL;

                {
                    this.fZL = r1;
                }

                public final void a(int i, int i2, String str, k kVar) {
                    v.i("MicroMsg.FreeWifi.ProtocolOne", "errType : %d, errCode : %d, errMsg : %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                    if (i == 0 && i2 == 0) {
                        com.tencent.mm.plugin.freewifi.d.a aVar = (com.tencent.mm.plugin.freewifi.d.a) kVar;
                        v.i("MicroMsg.FreeWifi.ProtocolOne", "authUrl : %s", new Object[]{aVar.apr()});
                        dq apx = aVar.apx();
                        if (apx != null) {
                            v.i("MicroMsg.FreeWifi.ProtocolOne", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[]{apx.mbH, apx.efy, apx.gln, Integer.valueOf(apx.mex), apx.mey, apx.cHf});
                            com.tencent.mm.plugin.freewifi.model.j.apm().aoU().post(new AnonymousClass4(this.fZL, r0, apx));
                            return;
                        }
                        this.fZL.apI();
                        return;
                    }
                    this.fZL.apI();
                }
            });
        }
    }

    public g(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        super(freeWifiFrontPageUI);
    }

    public final void connect() {
        com.tencent.mm.plugin.freewifi.model.j.apm().aoU().post(new Runnable(this) {
            final /* synthetic */ g fZL;

            {
                this.fZL = r1;
            }

            public final void run() {
                g.a(this.fZL);
            }
        });
    }

    private void apI() {
        this.fZC.a(d.FAIL, FreeWifiFrontPageUI.a.gbL);
    }

    static String bE(String str, String str2) {
        if (be.kS(str)) {
            v.e("MicroMsg.FreeWifi.ProtocolOne", "null or nil header");
            return null;
        }
        String[] split;
        String[] split2 = str.split("\\?");
        if (str2.length() > 0) {
            split = split2[1].split("&");
        } else {
            split = split2;
        }
        if (split == null || split.length <= 0) {
            return null;
        }
        for (String str3 : split) {
            if (str3.startsWith(str2)) {
                return str3.substring(str2.length());
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
                    v.i("MicroMsg.FreeWifi.ProtocolOne", "code : %d, location : %s", new Object[]{Integer.valueOf(responseCode), httpURLConnection2.getHeaderField("Location")});
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return r1;
                } catch (Exception e) {
                    Exception exception2 = e;
                    httpURLConnection = httpURLConnection2;
                    exception = exception2;
                    try {
                        v.e("MicroMsg.FreeWifi.ProtocolOne", "get recirect location failed : %s", new Object[]{exception.getMessage()});
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
            v.e("MicroMsg.FreeWifi.ProtocolOne", "get recirect location failed : %s", new Object[]{exception.getMessage()});
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
