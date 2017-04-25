package com.tencent.mm.plugin.freewifi;

import android.content.Intent;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class k {
    public static Map<String, String> fWW = new HashMap<String, String>() {
        {
            for (b bVar : b.values()) {
                put(bVar.name, bVar.fXN);
            }
        }
    };
    private String aYA;
    private String aYz;
    private int bkh;
    private int bpc;
    private String bssid;
    private String eOP;
    private int fWX;
    private String fWY;
    private String fWZ;
    private String fXa;
    private int fXb;
    private long fXc;
    private String fXd;
    private String fXe;
    private long fXf;
    private String ssid;

    public static class a {
        public String aYA;
        public String aYz;
        public int bkh;
        public int bpc;
        public String bssid;
        public String eOP;
        private int fWX;
        public String fWY;
        public String fWZ;
        public String fXa;
        public int fXb;
        public long fXc;
        public String fXd;
        public String fXe;
        private long fXf;
        public String ssid;

        private a() {
        }

        public final k aoA() {
            k kVar = new k();
            kVar.ssid = this.ssid;
            kVar.bssid = this.bssid;
            kVar.aYA = this.aYA;
            kVar.aYz = this.aYz;
            kVar.fWX = this.fWX;
            kVar.fWY = this.fWY;
            kVar.fWZ = this.fWZ;
            kVar.fXa = this.fXa;
            kVar.fXb = this.fXb;
            kVar.fXc = (long) Integer.valueOf("1" + String.format("%03d", new Object[]{Integer.valueOf(this.fXb)}) + String.format("%03d", new Object[]{Long.valueOf(this.fXc)})).intValue();
            kVar.fXd = this.fXd;
            kVar.bpc = this.bpc;
            kVar.bkh = this.bkh;
            kVar.fXe = this.fXe;
            kVar.fXf = this.fXf;
            kVar.eOP = this.eOP;
            return kVar;
        }
    }

    public enum b {
        GetFrontPage(10, "getFrontPage", "a"),
        GetFrontPageReturn(11, "getFrontpageReturn", "ar"),
        GetFrontPageReturnDataCheck(12, "getFrontPageReturnDataCheck", "ard"),
        AddNetwork(20, "addNetwork", "n"),
        GetBackPage(30, "getBackPage", "b"),
        GetBackPageReturn(31, "getBackPageReturn", "br"),
        GetBackPage33(32, "getBackPage33", "b33"),
        GetBackPage33Return(33, "getBackPage33Return", "b33r"),
        BackpageFinished(40, "backpageFinished", "bf"),
        QinghuaiBackpageFinished(50, "qinghuaiBackpageFinished", "qbf"),
        ScanNearFieldWifiAndReport(110, "scanNearFieldWifiAndReport", "sc"),
        GetThreeOneLock(290, "getThreeOneLock", "31lk"),
        GetPortalApInfo(300, "getPortalApInfo", "o"),
        GetPortalApInfoReturn(301, "getPortalApInfoReturn", "or"),
        GetPortalApInfoReturnDataCheck(302, "getPortalApInfoReturnDataCheck", "ord"),
        FrontPageUIClosed(303, "frontPageUIClosed", "af"),
        FrontPageUIClosedByGoBack(311, "frontPageUIClosedByGoBack", "afg"),
        FrontPageUIClosedByGoSuc(312, "frontPageUIClosedByGoSuc", "afs"),
        FrontPageUIClosedByGoContactInfoUI(313, "frontPageUIClosedByGoContactInfoUI", "afc"),
        ThreeOneAuth(305, "threeOneAuth", "31a"),
        ThreeTwoAuth(306, "threeTwoAuth", "32a"),
        ThreeTwoBlack(307, "threeTwoAuthBlack", "32ab"),
        ThreeThreeAuth(308, "threeThreeAuth", "33a"),
        GetPcFrontPage(210, "getPcFrontPage", "pca"),
        GetPcFrontPageReturn(211, "getPcFrontPageReturn", "pcar"),
        SetPcLoginUserInfo(212, "setPcLoginUserInfo", "pcset"),
        SetPcLoginUserInfoReturn(212, "setPcLoginUserInfoReturn", "pcsetr"),
        ManufacturerConnectLoading(500, "manufacturerConnectLoading", "mld");
        
        public long fXM;
        String fXN;
        public String name;

        private b(long j, String str, String str2) {
            if (j > 999 || j < 0) {
                throw new IllegalArgumentException("code must be between 0 and 999");
            }
            this.fXM = j;
            this.name = str;
            this.fXN = str2;
        }
    }

    public static String tx(String str) {
        return m.tA((String) fWW.get(str));
    }

    private k() {
    }

    public static a aoy() {
        return new a();
    }

    public final k aoz() {
        g.iuh.h(12804, new Object[]{m.tA(this.ssid), m.tA(this.bssid), m.tA(this.aYA), m.tA(this.aYz), Integer.valueOf(this.fWX), m.tA(this.fWY), m.tA(this.fWZ), m.tA(this.fXa), Integer.valueOf(this.fXb), Long.valueOf(this.fXc), m.tA(this.fXd), Integer.valueOf(this.bpc), Integer.valueOf(this.bkh), m.tA(this.fXe), Long.valueOf(this.fXf), m.tA(this.eOP)});
        return this;
    }

    public final k b(Intent intent, boolean z) {
        try {
            final int u = m.u(intent);
            if (u == 31) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("ssid", this.ssid);
                    jSONObject.put("bssid", this.bssid);
                    jSONObject.put("clientMac", this.aYA);
                    jSONObject.put("apKey", this.aYz);
                    jSONObject.put("qrtype", this.fWX);
                    jSONObject.put("mpShopId", this.fWY);
                    jSONObject.put("mpAppId", this.fWZ);
                    jSONObject.put("sessionKey", this.fXa);
                    jSONObject.put("protocolType", this.fXb);
                    jSONObject.put("stageCode", this.fXc);
                    jSONObject.put("stageName", this.fXd);
                    jSONObject.put("result", this.bpc);
                    jSONObject.put("channel", this.bkh);
                    jSONObject.put("mpUserName", this.fXe);
                    jSONObject.put("timeCost", this.fXf);
                    jSONObject.put("resultMsg", this.eOP);
                    jSONObject.put("logCurrentTimeMillis", System.currentTimeMillis());
                } catch (Exception e) {
                    v.e("MicroMsg.FreeWifi.FreeWifiQualityReporter", "JSONException e. " + m.f(e));
                }
                String jSONObject2 = jSONObject.toString();
                String stringExtra = intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_JSON");
                if (m.ty(stringExtra)) {
                    intent.putExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_JSON", jSONObject2);
                } else {
                    intent.putExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_JSON", stringExtra + "," + jSONObject2);
                }
                final long currentTimeMillis = System.currentTimeMillis();
                final String stringExtra2 = intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_ID");
                final String stringExtra3 = intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_JSON");
                if (z) {
                    j.apn().aoU().post(new Runnable(this) {
                        final /* synthetic */ k fXj;

                        public final void run() {
                            j.apl().a(stringExtra2, u, stringExtra3, currentTimeMillis);
                            if (m.aoF()) {
                                com.tencent.mm.plugin.freewifi.f.b.kZ(1);
                            }
                        }
                    });
                }
            }
        } catch (Exception e2) {
            v.e("MicroMsg.FreeWifi.FreeWifiQualityReporter", "reportWifiServer() write to local file exception. " + m.f(e2));
        }
        return this;
    }
}
