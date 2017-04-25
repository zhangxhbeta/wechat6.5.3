package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.plugin.freewifi.d.i;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class a {
    Activity aXH;
    String aYz;
    int bkh;
    Intent intent;

    class AnonymousClass2 implements e {
        final /* synthetic */ a gbh;
        final /* synthetic */ String gbi;
        final /* synthetic */ String gbj;
        final /* synthetic */ String gbk;
        final /* synthetic */ String gbl;

        AnonymousClass2(a aVar, String str, String str2, String str3, String str4) {
            this.gbh = aVar;
            this.gbi = str;
            this.gbj = str2;
            this.gbk = str3;
            this.gbl = str4;
        }

        public final void a(int i, int i2, String str, k kVar) {
            v.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo.callback, desc=net request [GetPortalApInfo] returns. errType=%d, errCode=%d, errMsg=%s", new Object[]{m.s(this.gbh.intent), Integer.valueOf(m.t(this.gbh.intent)), Integer.valueOf(i), Integer.valueOf(i2), str});
            com.tencent.mm.plugin.freewifi.k.a aoy;
            if (i == 0 && i2 == 0) {
                aoy = com.tencent.mm.plugin.freewifi.k.aoy();
                aoy.aYz = this.gbh.aYz;
                aoy.fXa = m.s(this.gbh.intent);
                aoy.fXc = b.GetPortalApInfoReturn.fXM;
                aoy.fXd = b.GetPortalApInfoReturn.name;
                aoy.bkh = this.gbh.bkh;
                aoy.bpc = i2;
                aoy.eOP = str;
                aoy.aoA().b(this.gbh.intent, false).aoz();
                i iVar = (i) kVar;
                String apB = iVar.apB();
                if (m.ty(apB)) {
                    v.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=authUrl is empty, so it fails to connect wifi. ", new Object[]{m.s(this.gbh.intent), Integer.valueOf(m.t(this.gbh.intent))});
                    this.gbh.tR(this.gbh.aXH.getString(2131232957));
                    aoy = com.tencent.mm.plugin.freewifi.k.aoy();
                    aoy.aYz = this.gbh.aYz;
                    aoy.fXa = m.s(this.gbh.intent);
                    aoy.fXc = b.GetPortalApInfoReturnDataCheck.fXM;
                    aoy.fXd = b.GetPortalApInfoReturnDataCheck.name;
                    aoy.bkh = this.gbh.bkh;
                    aoy.fXb = m.u(this.gbh.intent);
                    aoy.bpc = -1;
                    aoy.eOP = "31 auth url is empty.";
                    aoy.aoA().b(this.gbh.intent, true).aoz();
                    return;
                }
                String tA = m.tA(iVar.apC());
                String tA2 = m.tA(this.gbi);
                String tA3 = m.tA(this.gbj);
                StringBuilder stringBuilder = new StringBuilder(apB);
                if (apB.indexOf("?") != -1) {
                    stringBuilder.append("&extend=").append(tA);
                } else {
                    stringBuilder.append("?extend=").append(tA);
                }
                stringBuilder.append("&openId=").append(tA2).append("&tid=").append(tA3).append("&timestamp=").append(m.tA(this.gbk)).append("&sign=").append(m.tA(this.gbl));
                v.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=it gets authentication url. http url=%s ", new Object[]{m.s(this.gbh.intent), Integer.valueOf(m.t(this.gbh.intent)), stringBuilder.toString()});
                this.gbh.intent.putExtra("free_wifi_portal_ap_info_authurl_with_params", stringBuilder.toString());
                this.gbh.intent.setClass(this.gbh.aXH, FreeWifiFrontPageUI.class);
                this.gbh.aXH.startActivity(this.gbh.intent);
                this.gbh.aXH.finish();
                this.gbh.aXH.overridePendingTransition(2130968680, 2130968677);
                aoy = com.tencent.mm.plugin.freewifi.k.aoy();
                aoy.aYz = this.gbh.aYz;
                aoy.fXa = m.s(this.gbh.intent);
                aoy.fXc = b.GetPortalApInfoReturnDataCheck.fXM;
                aoy.fXd = b.GetPortalApInfoReturnDataCheck.name;
                aoy.bkh = this.gbh.bkh;
                aoy.fXb = m.u(this.gbh.intent);
                aoy.bpc = 0;
                aoy.eOP = "";
                aoy.aoA().b(this.gbh.intent, true).aoz();
                return;
            }
            aoy = com.tencent.mm.plugin.freewifi.k.aoy();
            aoy.aYz = this.gbh.aYz;
            aoy.fXa = m.s(this.gbh.intent);
            aoy.fXc = b.GetPortalApInfoReturn.fXM;
            aoy.fXd = b.GetPortalApInfoReturn.name;
            aoy.bkh = this.gbh.bkh;
            aoy.fXb = m.u(this.gbh.intent);
            aoy.bpc = i2;
            aoy.eOP = str;
            aoy.aoA().b(this.gbh.intent, true).aoz();
            if (m.bG(i, i2) && !m.ty(str)) {
                this.gbh.tR(str + "(" + m.a(m.u(this.gbh.intent), b.GetPortalApInfoReturn, i2) + ")");
            } else if (m.ty(str)) {
                this.gbh.tR(this.gbh.aXH.getString(2131232957));
            } else {
                this.gbh.tR(str);
            }
        }
    }

    public a(Activity activity, String str, int i) {
        if (activity == null || be.kS(str)) {
            throw new IllegalArgumentException("acitvity or apKey cannot be null.");
        }
        this.aXH = activity;
        this.intent = activity.getIntent();
        this.aYz = str;
        this.bkh = i;
    }

    final void tR(String str) {
        Intent intent = new Intent();
        intent.putExtra("free_wifi_error_ui_error_msg", str);
        intent.setClass(this.aXH, FreeWifiErrorUI.class);
        this.aXH.finish();
        this.aXH.startActivity(intent);
    }
}
