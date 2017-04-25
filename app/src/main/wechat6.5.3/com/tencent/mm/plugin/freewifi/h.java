package com.tencent.mm.plugin.freewifi;

import android.net.Uri;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.c.aa;
import com.tencent.mm.sdk.platformtools.v;

public final class h {
    private com.tencent.mm.plugin.freewifi.g.b fWK;
    private String fWL;

    enum a {
        version("version", "2"),
        httpConnectTimeoutMillis("httpConnectTimeoutMillis", "5000"),
        httpReadTimeoutMillis("httpReadTimeoutMillis", "5000"),
        pingEnabled("pingEnabled", "1"),
        pingUrl("pingUrl", "http://o2o.gtimg.com/wifi/echo"),
        threeTwoBlackUrl("threeTwoBlackUrl", "http://o2o.gtimg.com/wifi/echo.html");
        
        String apU;
        String fWS;

        private a(String str, String str2) {
            this.apU = str;
            this.fWS = str2;
        }
    }

    private static class b {
        private static h fWU = new h();
    }

    private h() {
        this.fWK = j.apk();
    }

    public final synchronized void a(aa aaVar) {
        aop();
        if (aaVar == null || aaVar.lZI == null) {
            v.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config is null.");
        } else {
            this.fWK.apK();
            if (aaVar.lZI.version == -1) {
                this.fWK.Kz();
                v.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "all local config data deleted.");
                this.fWK.apK();
            } else if (aaVar.lZI.version > aoq()) {
                v.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.version is %d, local version is %d.", new Object[]{Integer.valueOf(aaVar.lZI.version), Integer.valueOf(aoq())});
                v.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.version = %d " + aaVar.lZI.version);
                v.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.httpConnectTimeoutMillis = %d " + aaVar.lZI.mnM);
                v.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.httpReadTimeoutMillis = %d " + aaVar.lZI.mnN);
                v.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.pingUrl = %s " + aaVar.lZI.aYy);
                v.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.pingEnabled = %s " + aaVar.lZI.aYx);
                v.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.ThreeTwoBlackUrl = %s " + aaVar.lZI.mnO);
                kT(aaVar.lZI.mnM);
                kU(aaVar.lZI.mnN);
                tu(aaVar.lZI.aYy);
                tt(aaVar.lZI.aYx);
                tv(aaVar.lZI.mnO);
                kS(aaVar.lZI.version);
                v.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "local config data changed.");
                this.fWK.apK();
            }
        }
    }

    private synchronized void aop() {
        try {
            String tN = this.fWK.tN(a.version.apU);
            if (!m.ty(tN) && Integer.valueOf(tN).intValue() < Integer.valueOf(a.version.fWS).intValue()) {
                kT(Integer.valueOf(a.httpConnectTimeoutMillis.fWS).intValue());
                kU(Integer.valueOf(a.httpReadTimeoutMillis.fWS).intValue());
                tu(a.pingUrl.fWS);
                tt(a.pingEnabled.fWS);
                tv(a.threeTwoBlackUrl.fWS);
                kS(Integer.valueOf(a.version.fWS).intValue());
            }
        } catch (Exception e) {
            v.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "updateDiskDbCacheIfLowerThanDefault exception. " + m.f(e));
        }
    }

    public final synchronized int aoq() {
        int intValue;
        aop();
        try {
            String tN = this.fWK.tN(a.version.apU);
            if (m.ty(tN)) {
                intValue = Integer.valueOf(a.version.fWS).intValue();
            } else {
                intValue = Integer.valueOf(tN).intValue();
            }
        } catch (Exception e) {
            intValue = Integer.valueOf(a.version.fWS).intValue();
        }
        return intValue;
    }

    private synchronized void kS(int i) {
        if (i > Integer.valueOf(a.version.fWS).intValue()) {
            j.apk().bF(a.version.apU, String.valueOf(i));
        }
    }

    public final int aor() {
        aop();
        try {
            String tN = this.fWK.tN(a.httpConnectTimeoutMillis.apU);
            if (m.ty(tN)) {
                return Integer.valueOf(a.httpConnectTimeoutMillis.fWS).intValue();
            }
            return Integer.valueOf(tN).intValue();
        } catch (Exception e) {
            return Integer.valueOf(a.httpConnectTimeoutMillis.fWS).intValue();
        }
    }

    private static void kT(int i) {
        if (i > 0) {
            j.apk().bF(a.httpConnectTimeoutMillis.apU, String.valueOf(i));
        }
    }

    public final int aos() {
        aop();
        try {
            String tN = this.fWK.tN(a.httpReadTimeoutMillis.apU);
            if (m.ty(tN)) {
                return Integer.valueOf(a.httpReadTimeoutMillis.fWS).intValue();
            }
            return Integer.valueOf(tN).intValue();
        } catch (Exception e) {
            return Integer.valueOf(a.httpReadTimeoutMillis.fWS).intValue();
        }
    }

    private void kU(int i) {
        if (i > 0) {
            this.fWK.bF(a.httpReadTimeoutMillis.apU, String.valueOf(i));
        }
    }

    public final String aot() {
        aop();
        try {
            if ("0".equals(this.fWK.tN(a.pingEnabled.apU))) {
                return "0";
            }
            return "1";
        } catch (Exception e) {
            return a.pingEnabled.fWS;
        }
    }

    private void tt(String str) {
        if ("0".equals(str) || "1".equals(str)) {
            try {
                this.fWK.bF(a.pingEnabled.apU, str);
            } catch (Exception e) {
            }
        }
    }

    public final String aou() {
        aop();
        try {
            String tN = this.fWK.tN(a.pingUrl.apU);
            if (m.ty(tN)) {
                return a.pingUrl.fWS;
            }
            Uri.parse(tN);
            return tN;
        } catch (Exception e) {
            return a.pingUrl.fWS;
        }
    }

    private void tu(String str) {
        if (!m.ty(str)) {
            try {
                Uri.parse(str);
                this.fWK.bF(a.pingUrl.apU, str);
            } catch (Exception e) {
            }
        }
    }

    public final String aov() {
        aop();
        try {
            String tN = this.fWK.tN(a.threeTwoBlackUrl.apU);
            if (m.ty(tN)) {
                return a.threeTwoBlackUrl.fWS;
            }
            Uri.parse(tN);
            return tN;
        } catch (Exception e) {
            return a.threeTwoBlackUrl.fWS;
        }
    }

    private void tv(String str) {
        if (!m.ty(str)) {
            try {
                Uri.parse(str);
                this.fWK.bF(a.threeTwoBlackUrl.apU, str);
            } catch (Exception e) {
            }
        }
    }

    public final String getUserAgent() {
        if (m.ty(this.fWL)) {
            this.fWL = s.aW(com.tencent.mm.sdk.platformtools.aa.getContext(), null).toLowerCase();
        }
        return this.fWL;
    }
}
