package com.tencent.mm.plugin.freewifi.model;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.RemoteException;
import com.tencent.mm.bg.g.c;
import com.tencent.mm.e.a.au;
import com.tencent.mm.e.a.eb;
import com.tencent.mm.e.a.ee;
import com.tencent.mm.e.a.fl;
import com.tencent.mm.e.a.fm;
import com.tencent.mm.e.a.mf;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bo;
import com.tencent.mm.network.m;
import com.tencent.mm.network.m.a;
import com.tencent.mm.plugin.freewifi.d.g;
import com.tencent.mm.plugin.freewifi.g.b;
import com.tencent.mm.plugin.freewifi.g.d;
import com.tencent.mm.plugin.freewifi.g.f;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.protocal.c.ark;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.protocal.c.cc;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class j implements ag {
    private static HashMap<Integer, c> bXq;
    private d fZa;
    private d fZb;
    private b fZc;
    private f fZd;
    private c fZe;
    private c fZf;
    private a fZg;
    private e fZh;
    private m fZi = new a(this) {
        private byte[] bXX = new byte[0];
        final /* synthetic */ j fZp;

        {
            this.fZp = r2;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void cI(int r9) {
            /*
            r8 = this;
            r1 = r8.bXX;
            monitor-enter(r1);
            r0 = com.tencent.mm.model.ak.uz();	 Catch:{ all -> 0x00ea }
            if (r0 != 0) goto L_0x0014;
        L_0x0009:
            r0 = "MicroMsg.FreeWifi.SubCoreFreeWifi";
            r2 = "account not ready";
            com.tencent.mm.sdk.platformtools.v.e(r0, r2);	 Catch:{ all -> 0x00ea }
            monitor-exit(r1);	 Catch:{ all -> 0x00ea }
        L_0x0013:
            return;
        L_0x0014:
            r0 = "MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi";
            r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ea }
            r3 = "onNetworkChange state=";
            r2.<init>(r3);	 Catch:{ all -> 0x00ea }
            r2 = r2.append(r9);	 Catch:{ all -> 0x00ea }
            r3 = ".(-1=NETWORK_UNKNOWN; 0=NETWORK_UNAVAILABLE; 1=NETWORK_CONNECTED; 2=GATEWAY_FAILED; 3=SERVER_FAILED; 4=CONNECTTING; 5=CONNECTED; 6=SERVER_DOWN)";
            r2 = r2.append(r3);	 Catch:{ all -> 0x00ea }
            r2 = r2.toString();	 Catch:{ all -> 0x00ea }
            com.tencent.mm.sdk.platformtools.v.i(r0, r2);	 Catch:{ all -> 0x00ea }
            r0 = com.tencent.mm.sdk.platformtools.aa.getContext();	 Catch:{ all -> 0x00ea }
            r2 = "connectivity";
            r0 = r0.getSystemService(r2);	 Catch:{ all -> 0x00ea }
            r0 = (android.net.ConnectivityManager) r0;	 Catch:{ all -> 0x00ea }
            r2 = 1;
            r2 = r0.getNetworkInfo(r2);	 Catch:{ all -> 0x00ea }
            if (r2 == 0) goto L_0x0088;
        L_0x0045:
            r3 = "MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi";
            r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ea }
            r5 = "wifiNetwork:";
            r4.<init>(r5);	 Catch:{ all -> 0x00ea }
            r4 = r4.append(r2);	 Catch:{ all -> 0x00ea }
            r4 = r4.toString();	 Catch:{ all -> 0x00ea }
            com.tencent.mm.sdk.platformtools.v.i(r3, r4);	 Catch:{ all -> 0x00ea }
            r3 = "MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi";
            r4 = " wifiNetwork.isAvailable()=%b,wifiNetwork.isConnected()=%b,wifiNetwork.isConnectedOrConnecting()=%b";
            r5 = 3;
            r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x00ea }
            r6 = 0;
            r7 = r2.isAvailable();	 Catch:{ all -> 0x00ea }
            r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ all -> 0x00ea }
            r5[r6] = r7;	 Catch:{ all -> 0x00ea }
            r6 = 1;
            r7 = r2.isConnected();	 Catch:{ all -> 0x00ea }
            r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ all -> 0x00ea }
            r5[r6] = r7;	 Catch:{ all -> 0x00ea }
            r6 = 2;
            r7 = r2.isConnectedOrConnecting();	 Catch:{ all -> 0x00ea }
            r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ all -> 0x00ea }
            r5[r6] = r7;	 Catch:{ all -> 0x00ea }
            com.tencent.mm.sdk.platformtools.v.i(r3, r4, r5);	 Catch:{ all -> 0x00ea }
        L_0x0088:
            r3 = 0;
            r0 = r0.getNetworkInfo(r3);	 Catch:{ all -> 0x00ea }
            if (r0 == 0) goto L_0x00cb;
        L_0x008f:
            r3 = "MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi";
            r4 = "mobileNetworkInfo";
            r5 = 1;
            r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x00ea }
            r6 = 0;
            r5[r6] = r0;	 Catch:{ all -> 0x00ea }
            com.tencent.mm.sdk.platformtools.v.i(r3, r4, r5);	 Catch:{ all -> 0x00ea }
            r3 = "MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi";
            r4 = " mobileNetworkInfo.isAvailable()=%b,mobileNetworkInfo.isConnected()=%b,mobileNetworkInfo.isConnectedOrConnecting()=%b";
            r5 = 3;
            r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x00ea }
            r6 = 0;
            r7 = r0.isAvailable();	 Catch:{ all -> 0x00ea }
            r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ all -> 0x00ea }
            r5[r6] = r7;	 Catch:{ all -> 0x00ea }
            r6 = 1;
            r7 = r0.isConnected();	 Catch:{ all -> 0x00ea }
            r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ all -> 0x00ea }
            r5[r6] = r7;	 Catch:{ all -> 0x00ea }
            r6 = 2;
            r0 = r0.isConnectedOrConnecting();	 Catch:{ all -> 0x00ea }
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ all -> 0x00ea }
            r5[r6] = r0;	 Catch:{ all -> 0x00ea }
            com.tencent.mm.sdk.platformtools.v.i(r3, r4, r5);	 Catch:{ all -> 0x00ea }
        L_0x00cb:
            r0 = 6;
            if (r0 == r9) goto L_0x00da;
        L_0x00ce:
            r0 = 4;
            if (r0 == r9) goto L_0x00da;
        L_0x00d1:
            if (r9 == 0) goto L_0x00da;
        L_0x00d3:
            r0 = -1;
            if (r0 == r9) goto L_0x00da;
        L_0x00d6:
            r0 = -9;
            if (r0 != r9) goto L_0x0115;
        L_0x00da:
            r0 = r2.isConnected();	 Catch:{ all -> 0x00ea }
            if (r0 != 0) goto L_0x00ed;
        L_0x00e0:
            r0 = com.tencent.mm.plugin.freewifi.model.f.a.fYK;	 Catch:{ all -> 0x00ea }
            r0.apc();	 Catch:{ all -> 0x00ea }
            monitor-exit(r1);	 Catch:{ all -> 0x00ea }
            goto L_0x0013;
        L_0x00ea:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x00ea }
            throw r0;
        L_0x00ed:
            r0 = com.tencent.mm.plugin.freewifi.model.f.a.fYK;	 Catch:{ all -> 0x00ea }
            r2 = com.tencent.mm.plugin.freewifi.model.d.aoZ();	 Catch:{ all -> 0x00ea }
            r0 = r0.a(r2);	 Catch:{ all -> 0x00ea }
            r2 = "MicroMsg.FreeWifi.SubCoreFreeWifi";
            r3 = "isWifiIndeedChanged=%b";
            r4 = 1;
            r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00ea }
            r5 = 0;
            r6 = java.lang.Boolean.valueOf(r0);	 Catch:{ all -> 0x00ea }
            r4[r5] = r6;	 Catch:{ all -> 0x00ea }
            com.tencent.mm.sdk.platformtools.v.i(r2, r3, r4);	 Catch:{ all -> 0x00ea }
            if (r0 == 0) goto L_0x0115;
        L_0x010e:
            r0 = com.tencent.mm.plugin.freewifi.model.j.apo();	 Catch:{ all -> 0x00ea }
            r0.aoR();	 Catch:{ all -> 0x00ea }
        L_0x0115:
            monitor-exit(r1);	 Catch:{ all -> 0x00ea }
            goto L_0x0013;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.model.j.6.cI(int):void");
        }
    };
    private com.tencent.mm.sdk.c.c fZj = new com.tencent.mm.sdk.c.c<au>(this) {
        final /* synthetic */ j fZp;

        {
            this.fZp = r2;
            this.nhz = au.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            au auVar = (au) bVar;
            v.d("MicroMsg.FreeWifi.SubCoreFreeWifi", "receive CheckWechatFreeWifiEvent");
            if (d.getNetworkType() != 0) {
                v.d("MicroMsg.FreeWifi.SubCoreFreeWifi", "not wifi");
            } else {
                j.api();
                auVar.aYw.aYy = b.fWU.aou();
                auVar.aYw.aYx = b.fWU.aot();
                String aoY = d.aoY();
                String aoW = d.aoW();
                if (!(be.kS(aoY) || be.kS(aoW))) {
                    com.tencent.mm.plugin.freewifi.g.c tP = j.apj().tP(aoY);
                    if (tP != null) {
                        auVar.aYw.aYz = tP.field_url;
                    }
                    auVar.aYw.ssid = aoY;
                    auVar.aYw.bssid = com.tencent.mm.plugin.freewifi.m.tC("MicroMsg.FreeWifi.FreeWifiManager");
                    auVar.aYw.aYA = com.tencent.mm.plugin.freewifi.m.tD("MicroMsg.FreeWifi.FreeWifiManager");
                    if (tP != null && aoY.equalsIgnoreCase(tP.field_ssid) && aoW.equalsIgnoreCase(tP.field_mac)) {
                        au.a aVar = auVar.aYw;
                        if (tP == null) {
                            v.e("MicroMsg.FreeWifi.FreeWifiManager", "filterLang, freewifi info is null");
                            aoY = null;
                        } else {
                            aoY = u.bsY();
                            aoY = aoY.equals("zh_CN") ? tP.field_showWordCn : (aoY.equals("zh_TW") || aoY.equals("zh_HK")) ? tP.field_showWordTw : tP.field_showWordEn;
                        }
                        aVar.aYB = aoY;
                        if (!(com.tencent.mm.plugin.freewifi.m.ty(auVar.aYw.aYB) || a.fWV.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_BAR_APPEARED", 0) == 1)) {
                            a.fWV.ay("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_BAR_APPEARED", 1);
                        }
                        if (tP.field_expiredTime - be.Nh() < 0) {
                            j.apo().aoR();
                        }
                    }
                }
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c fZk = new com.tencent.mm.sdk.c.c<mf>(this) {
        final /* synthetic */ j fZp;

        {
            this.fZp = r2;
            this.nhz = mf.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            mf mfVar = (mf) bVar;
            int networkType = d.getNetworkType();
            if (!(networkType == 0 || networkType == -1)) {
                v.i("MicroMsg.FreeWifi.SubCoreFreeWifi", "networkType is " + networkType + ", start to scan and report near field wifi, to get a pushed message for connecting wifi.");
                final String str = mfVar.bnp.userName;
                b.fYZ.a(new h.a(this) {
                    final /* synthetic */ AnonymousClass8 fZr;

                    public final void az(List<ScanResult> list) {
                        if (list != null && list.size() != 0) {
                            ark com_tencent_mm_protocal_c_ark = new ark();
                            com_tencent_mm_protocal_c_ark.mQC = new LinkedList();
                            for (ScanResult scanResult : list) {
                                if (scanResult != null) {
                                    cc ccVar = new cc();
                                    ccVar.mac = scanResult.BSSID;
                                    ccVar.mcu = scanResult.level;
                                    ccVar.ssid = scanResult.SSID;
                                    com_tencent_mm_protocal_c_ark.mQC.add(ccVar);
                                }
                            }
                            String aoC = com.tencent.mm.plugin.freewifi.m.aoC();
                            k.a aoy = k.aoy();
                            aoy.fXa = aoC;
                            aoy.fXc = k.b.ScanNearFieldWifiAndReport.fXM;
                            aoy.fXd = k.b.ScanNearFieldWifiAndReport.name;
                            aoy.bkh = 8;
                            aoy.aoA().aoz();
                            new com.tencent.mm.plugin.freewifi.d.k(str, com_tencent_mm_protocal_c_ark, 8, aoC).b(null);
                        }
                    }
                });
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c fZl = new com.tencent.mm.sdk.c.c<fl>(this) {
        final /* synthetic */ j fZp;

        {
            this.fZp = r2;
            this.nhz = fl.class.getName().hashCode();
        }

        private static boolean a(fl flVar) {
            if (flVar.beP.data == "MAIN_UI_EVENT_UPDATE_VIEW" && com.tencent.mm.plugin.freewifi.m.aoB()) {
                String str = "InterruptedProtocol31-" + System.currentTimeMillis();
                f.b apd = a.fYK.apd();
                if (!(apd == null || apd.fYO || System.currentTimeMillis() - apd.fYB > 180000 || com.tencent.mm.plugin.freewifi.m.ty(apd.fYM) || com.tencent.mm.plugin.freewifi.m.ty(apd.fYL) || com.tencent.mm.plugin.freewifi.m.ty(apd.fYN))) {
                    v.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=It gets info of the wifi switched to last time. apSSid=%s, apBssid=%s, mobileMac=%s, time=%d", new Object[]{str, Integer.valueOf(1), apd.fYL, apd.fYM, apd.fYN, Long.valueOf(apd.fYB)});
                    WifiInfo aoZ = d.aoZ();
                    v.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=It gets info of the wifi connected right now. wifiinfo = %s", new Object[]{str, Integer.valueOf(2), aoZ});
                    if (aoZ != null) {
                        String tz = com.tencent.mm.plugin.freewifi.m.tz(aoZ.getSSID());
                        if (com.tencent.mm.plugin.freewifi.m.tz(apd.fYL).equals(tz)) {
                            String bssid = aoZ.getBSSID();
                            String macAddress = aoZ.getMacAddress();
                            if (VERSION.SDK_INT > 22 && (macAddress == null || macAddress.equals("02:00:00:00:00:00"))) {
                                macAddress = com.tencent.mm.plugin.freewifi.m.aoD();
                            }
                            synchronized (a.fYK) {
                                if (apd != a.fYK.apd()) {
                                } else {
                                    v.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=it starts net request [GetInterruptedProtocol31] for schema url. apSSid=%s, apBssid=%s, mobileMac=%s", new Object[]{str, Integer.valueOf(3), tz, bssid, macAddress});
                                    new g(tz, bssid, macAddress).b(new com.tencent.mm.plugin.freewifi.e.c.AnonymousClass1(str, apd));
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c fZm = new com.tencent.mm.sdk.c.c<ee>(this) {
        final /* synthetic */ j fZp;

        {
            this.fZp = r2;
            this.nhz = ee.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            com.tencent.mm.plugin.freewifi.b.c.aoL().a((ee) bVar);
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c fZn = new com.tencent.mm.sdk.c.c<eb>(this) {
        final /* synthetic */ j fZp;

        {
            this.fZp = r2;
            this.nhz = eb.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            a.fYf.a((eb) bVar);
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c fZo = new com.tencent.mm.sdk.c.c<fm>(this) {
        final /* synthetic */ j fZp;

        {
            this.fZp = r2;
            this.nhz = fm.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            fm fmVar = (fm) bVar;
            com.tencent.mm.plugin.freewifi.e.b.apF();
            com.tencent.mm.plugin.freewifi.e.b.x(fmVar.beQ.intent);
            return false;
        }
    };
    private bo.b fvh = new bo.b(this) {
        final /* synthetic */ j fZp;

        {
            this.fZp = r1;
        }

        public final void a(com.tencent.mm.v.d.a aVar) {
            e app = j.app();
            bm bmVar = aVar.czu;
            if (1 != a.fWV.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_RECV_FREEWIFI_SYSMSG", 0)) {
                a.fWV.ay("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_RECV_FREEWIFI_SYSMSG", 1);
            }
            if (bmVar == null || bmVar.mbW == null) {
                v.e("MicroMsg.FreeWifi.FreeWifiMessageService", "cmdAddMsg is null");
                return;
            }
            String a = com.tencent.mm.platformtools.m.a(bmVar.mbW);
            v.i("MicroMsg.FreeWifi.FreeWifiMessageService", "freewifi push message cmdAM.NewMsgId=%d, msgContent=%s", new Object[]{Long.valueOf(bmVar.mcb), a});
            if (com.tencent.mm.plugin.freewifi.m.ty(a)) {
                v.e("MicroMsg.FreeWifi.FreeWifiMessageService", "msgContent is empty. return.");
                return;
            }
            com.tencent.mm.plugin.freewifi.c.a tF = com.tencent.mm.plugin.freewifi.c.a.tF(a);
            if (tF == null) {
                v.e("MicroMsg.FreeWifi.FreeWifiMessageService", "parse schemaMsg failed. return.");
                return;
            }
            new com.tencent.mm.plugin.freewifi.d.d(com.tencent.mm.plugin.freewifi.m.tB("MicroMsg.FreeWifi.FreeWifiMessageService"), com.tencent.mm.plugin.freewifi.m.tC("MicroMsg.FreeWifi.FreeWifiMessageService"), com.tencent.mm.plugin.freewifi.m.tD("MicroMsg.FreeWifi.FreeWifiMessageService"), tF.fYt, tF.fYq, tF.fYu, tF.ssid, tF.bssid).b(new com.tencent.mm.plugin.freewifi.model.e.AnonymousClass1(app, bmVar));
        }
    };

    static {
        HashMap hashMap = new HashMap();
        bXq = hashMap;
        hashMap.put(Integer.valueOf("FREEWIFIINFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return d.cic;
            }
        });
        bXq.put(Integer.valueOf("FREEWIFICONFIG_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return b.cic;
            }
        });
        bXq.put(Integer.valueOf("FREEWIFILOG_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return f.cic;
            }
        });
    }

    public static j aph() {
        j jVar = (j) ak.yP().fY("plugin.freewifi");
        if (jVar != null) {
            return jVar;
        }
        v.w("MicroMsg.FreeWifi.SubCoreFreeWifi", "not found in MMCore, new one");
        jVar = new j();
        ak.yP().a("plugin.freewifi", jVar);
        return jVar;
    }

    public static d api() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aph().fZa == null) {
            aph().fZa = new d();
        }
        return aph().fZa;
    }

    public static d apj() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aph().fZb == null) {
            j aph = aph();
            ak.yW();
            aph.fZb = new d(com.tencent.mm.model.c.wE());
        }
        return aph().fZb;
    }

    public static b apk() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aph().fZc == null) {
            j aph = aph();
            ak.yW();
            aph.fZc = new b(com.tencent.mm.model.c.wE());
        }
        return aph().fZc;
    }

    public static f apl() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aph().fZd == null) {
            j aph = aph();
            ak.yW();
            aph.fZd = new f(com.tencent.mm.model.c.wE());
        }
        return aph().fZd;
    }

    public static c apm() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aph().fZe == null) {
            aph().fZe = new c();
        }
        return aph().fZe;
    }

    public static c apn() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aph().fZf == null) {
            aph().fZf = new c();
        }
        return aph().fZf;
    }

    public static a apo() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aph().fZg == null) {
            aph().fZg = new a();
        }
        return aph().fZg;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        ak.yU().a("freewifi", this.fvh, true);
        ak.a(this.fZi);
        com.tencent.mm.sdk.c.a.nhr.e(this.fZj);
        com.tencent.mm.sdk.c.a.nhr.e(this.fZk);
        com.tencent.mm.sdk.c.a.nhr.e(this.fZl);
        com.tencent.mm.sdk.c.a.nhr.e(this.fZm);
        com.tencent.mm.sdk.c.a.nhr.e(this.fZn);
        com.tencent.mm.sdk.c.a.nhr.e(this.fZo);
        try {
            this.fZi.cI(-9);
        } catch (RemoteException e) {
            v.e("MicroMsg.FreeWifi.SubCoreFreeWifi", "netChanged.onNetworkChange(NETWORK_ACCOUNT_POST_RESET) error. e.getMessage()=" + e.getMessage());
        }
        b aoT = b.fYD;
        v.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "initialized");
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) aa.getContext().getSystemService("connectivity");
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            v.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoWifi=%s", new Object[]{networkInfo.toString()});
            IntentFilter intentFilter;
            if (networkInfo == null || !networkInfo.isConnected()) {
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
                v.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoMobile=%s", new Object[]{networkInfo2.toString()});
                if (networkInfo2 != null && networkInfo2.isConnected()) {
                    a aVar = new a();
                    aVar.fYB = System.currentTimeMillis();
                    aVar.type = 0;
                    aVar.ssid = "";
                    aVar.bssid = "";
                    aVar.fYC = com.tencent.mm.plugin.freewifi.m.tA(networkInfo2.getExtraInfo());
                    b.a(aoT.fYy.aoS(), aVar);
                    aoT.fYy = aVar;
                }
                intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                aoT.aom();
                aa.getContext().registerReceiver(aoT.fYz, intentFilter);
            }
            WifiInfo connectionInfo = ((WifiManager) aa.getContext().getSystemService("wifi")).getConnectionInfo();
            String tz = com.tencent.mm.plugin.freewifi.m.tz(connectionInfo.getSSID());
            String toLowerCase = com.tencent.mm.plugin.freewifi.m.tA(connectionInfo.getBSSID()).toLowerCase();
            a aVar2 = new a();
            aVar2.fYB = System.currentTimeMillis();
            aVar2.type = 1;
            aVar2.ssid = tz;
            aVar2.bssid = toLowerCase;
            aVar2.fYC = "";
            b.b(aoT.fYy.aoS(), aVar2);
            aoT.fYy = aVar2;
            intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            aoT.aom();
            aa.getContext().registerReceiver(aoT.fYz, intentFilter);
        } catch (Exception e2) {
            k.a aoy = k.aoy();
            aoy.aYz = "UnExpectedException";
            aoy.bpc = -1;
            aoy.eOP = com.tencent.mm.plugin.freewifi.m.e(e2);
            aoy.aoA().aoz();
            v.e("MicroMsg.FreeWifi.UnExcepctedException", com.tencent.mm.plugin.freewifi.m.f(e2));
        }
    }

    public final void aH(boolean z) {
    }

    public final void th() {
        ak.yU().b("freewifi", this.fvh, true);
        api();
        d.release();
        apm().release();
        ak.b(this.fZi);
        com.tencent.mm.sdk.c.a.nhr.f(this.fZj);
        com.tencent.mm.sdk.c.a.nhr.f(this.fZk);
        com.tencent.mm.sdk.c.a.nhr.f(this.fZl);
        com.tencent.mm.sdk.c.a.nhr.f(this.fZm);
        com.tencent.mm.sdk.c.a.nhr.f(this.fZn);
        com.tencent.mm.sdk.c.a.nhr.f(this.fZo);
        b.fYD.aom();
    }

    public final HashMap<Integer, c> ti() {
        return bXq;
    }

    public static e app() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aph().fZh == null) {
            aph().fZh = new e();
        }
        return aph().fZh;
    }
}
