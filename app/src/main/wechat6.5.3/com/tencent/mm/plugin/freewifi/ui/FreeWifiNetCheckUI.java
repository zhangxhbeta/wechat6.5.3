package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import com.tencent.mm.plugin.freewifi.d.h;
import com.tencent.mm.plugin.freewifi.d.i;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.protocal.c.aoj;
import com.tencent.mm.protocal.c.ark;
import com.tencent.mm.protocal.c.cc;
import com.tencent.mm.protocal.c.qz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.v.e;
import java.util.LinkedList;
import java.util.List;

public class FreeWifiNetCheckUI extends MMActivity {
    private ah aSW;
    private String apU;
    private int bkh;
    ImageView gcb;
    private final int gce = 1;
    private final int gcf = 2;
    private int[] gch = new int[]{2130838252, 2130838253, 2130838254, 2130838255, 2130838256};
    ac gci = new ac(this) {
        final /* synthetic */ FreeWifiNetCheckUI gcq;
        int i = 0;

        {
            this.gcq = r2;
        }

        public final void handleMessage(Message message) {
            if (message.what == 1) {
                if (this.i >= this.gcq.gch.length) {
                    this.i = 0;
                }
                this.gcq.gcb.setImageResource(this.gcq.gch[this.i]);
                this.i++;
            } else if (message.what == 2) {
                this.gcq.gcb.setImageResource(this.gcq.gch[this.gcq.gch.length - 1]);
            }
            super.handleMessage(message);
        }
    };
    private a gcp;
    private Intent intent;
    private int scene;

    static /* synthetic */ void a(FreeWifiNetCheckUI freeWifiNetCheckUI, String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("free_wifi_error_ui_error_msg", str);
        intent.putExtra("free_wifi_error_ui_error_msg_detail1", str2);
        intent.setClass(freeWifiNetCheckUI, FreeWifiErrorUI.class);
        freeWifiNetCheckUI.finish();
        freeWifiNetCheckUI.startActivity(intent);
    }

    static /* synthetic */ void c(FreeWifiNetCheckUI freeWifiNetCheckUI) {
        Intent intent = new Intent();
        intent.setClass(freeWifiNetCheckUI, FreeWifiNoWifiUI.class);
        freeWifiNetCheckUI.startActivity(intent);
    }

    public void finish() {
        if (this.aSW != null) {
            this.aSW.QI();
        }
        this.gci.sendEmptyMessage(2);
        super.finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131232984);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FreeWifiNetCheckUI gcq;

            {
                this.gcq = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.gcq.finish();
                return true;
            }
        });
        this.intent = getIntent();
        m.r(this.intent);
        this.apU = getIntent().getStringExtra("free_wifi_ap_key");
        this.scene = getIntent().getIntExtra("free_wifi_source", 1);
        v.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiNetCheckUI.onCreate, desc=it goes into black loading ui and starts to connect. get qrcode key = %s, current connected ssid = %s", new Object[]{m.s(this.intent), Integer.valueOf(m.t(this.intent)), this.apU, d.aoY()});
        this.gcb = (ImageView) findViewById(2131757085);
        this.aSW = new ah(new a(this) {
            final /* synthetic */ FreeWifiNetCheckUI gcq;

            {
                this.gcq = r1;
            }

            public final boolean oU() {
                this.gcq.gci.sendEmptyMessage(1);
                return true;
            }
        }, true);
        this.aSW.ea(200);
        String str;
        switch (this.scene) {
            case 1:
                getIntent().putExtra("free_wifi_channel_id", 2);
                this.bkh = 2;
                if (!be.kS(this.apU)) {
                    Uri uri = null;
                    str = "";
                    try {
                        uri = Uri.parse(this.apU);
                        str = uri.getQueryParameter("q");
                    } catch (Exception e) {
                        finish();
                    }
                    if (!"pc".equalsIgnoreCase(str)) {
                        "_test".equals(str);
                        aqh();
                        break;
                    }
                    str = uri.getQueryParameter("appid");
                    final String queryParameter = uri.getQueryParameter("shopid");
                    final String queryParameter2 = uri.getQueryParameter("ticket");
                    m.d(getIntent(), queryParameter2);
                    k.a aoy = k.aoy();
                    aoy.fWY = queryParameter;
                    aoy.fWZ = str;
                    aoy.fXa = queryParameter2;
                    aoy.fXc = b.GetPcFrontPage.fXM;
                    aoy.fXd = b.GetPcFrontPage.name;
                    aoy.aoA().aoz();
                    v.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=handlePcRequest, desc=It starts NetSceneGetPcFrontPage.shopid=%s, appid=%s, ticket=%s", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent())), queryParameter, str, queryParameter2});
                    new h(str, Integer.valueOf(queryParameter).intValue(), queryParameter2).b(new e(this) {
                        final /* synthetic */ FreeWifiNetCheckUI gcq;

                        public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                            if (i == 0 && i2 == 0) {
                                qz apu = ((h) kVar).apu();
                                if (apu != null) {
                                    Intent intent = this.gcq.getIntent();
                                    intent.putExtra("free_wifi_appid", apu.mbH);
                                    intent.putExtra("free_wifi_head_img_url", apu.muL);
                                    intent.putExtra("free_wifi_welcome_msg", apu.muM);
                                    intent.putExtra("free_wifi_welcome_sub_title", apu.muO);
                                    intent.putExtra("free_wifi_privacy_url", apu.muN);
                                    intent.putExtra("free_wifi_app_nickname", apu.efy);
                                    intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PC_ENCRYPTED_SHOPID", queryParameter);
                                    intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PC_TICKET", queryParameter2);
                                    intent.setClass(this.gcq, FreeWifiPcUI.class);
                                    this.gcq.finish();
                                    this.gcq.startActivity(intent);
                                }
                            } else if (!m.bG(i, i2) || m.ty(str)) {
                                FreeWifiNetCheckUI.a(this.gcq, this.gcq.getString(2131232953), this.gcq.getString(2131232954));
                            } else {
                                FreeWifiNetCheckUI.a(this.gcq, str + "(" + m.a(m.u(this.gcq.intent), b.GetPcFrontPageReturn, i2) + ")", "");
                            }
                            k.a aoy = k.aoy();
                            aoy.fWY = queryParameter;
                            aoy.fWZ = str;
                            aoy.fXa = queryParameter2;
                            aoy.fXc = b.GetPcFrontPageReturn.fXM;
                            aoy.fXd = b.GetPcFrontPageReturn.name;
                            aoy.bpc = i2;
                            aoy.aoA().aoz();
                            v.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=handlePcRequest, desc=NetSceneGetPcFrontPage returns.errcode=%d", new Object[]{m.s(this.gcq.getIntent()), Integer.valueOf(m.t(this.gcq.getIntent())), Integer.valueOf(i2)});
                        }
                    });
                    break;
                }
                v.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
                finish();
                break;
            case 4:
                str = getIntent().getStringExtra("free_wifi_jsapi_param_type");
                if ("1".equals(str)) {
                    getIntent().putExtra("free_wifi_channel_id", 9);
                    this.bkh = 9;
                } else if ("0".equals(str)) {
                    getIntent().putExtra("free_wifi_channel_id", 8);
                    this.bkh = 8;
                } else {
                    getIntent().putExtra("free_wifi_channel_id", 4);
                    this.bkh = 4;
                }
                str = getIntent().getStringExtra("free_wifi_jsapi_param_type");
                if (!str.equals("0") || !be.kS(this.apU)) {
                    if (!str.equals("0")) {
                        if (!str.equals("1")) {
                            v.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "undefined jsapi type");
                            finish();
                            break;
                        }
                        str = getIntent().getStringExtra("free_wifi_jsapi_param_username");
                        if (!d.isWifiEnabled()) {
                            d.aoV();
                        }
                        b.fYZ.a(new com.tencent.mm.plugin.freewifi.model.h.a(this) {
                            final /* synthetic */ FreeWifiNetCheckUI gcq;

                            public final void az(List<ScanResult> list) {
                                if (list == null || list.size() == 0) {
                                    this.gcq.finish();
                                    FreeWifiNetCheckUI.c(this.gcq);
                                    return;
                                }
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
                                k.a aoy = k.aoy();
                                aoy.fXa = m.s(this.gcq.intent);
                                aoy.fXc = b.ScanNearFieldWifiAndReport.fXM;
                                aoy.fXd = b.ScanNearFieldWifiAndReport.name;
                                aoy.bkh = 9;
                                aoy.aoA().aoz();
                                new com.tencent.mm.plugin.freewifi.d.k(str, com_tencent_mm_protocal_c_ark, 9, m.s(this.gcq.getIntent())).b(new e(this) {
                                    final /* synthetic */ AnonymousClass5 gcu;

                                    {
                                        this.gcu = r1;
                                    }

                                    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                                        String apE = ((com.tencent.mm.plugin.freewifi.d.k) kVar).apE();
                                        if (be.kS(apE)) {
                                            this.gcu.gcq.finish();
                                            FreeWifiNetCheckUI.c(this.gcu.gcq);
                                            return;
                                        }
                                        this.gcu.gcq.apU = apE;
                                        this.gcu.gcq.getIntent().putExtra("free_wifi_ap_key", apE);
                                        this.gcu.gcq.bkh = 9;
                                        this.gcu.gcq.aqh();
                                    }
                                });
                            }
                        });
                        break;
                    }
                    aqh();
                    break;
                }
                v.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key fail");
                finish();
                break;
                break;
            case 5:
                this.bkh = getIntent().getIntExtra("free_wifi_channel_id", 1);
                if (!be.kS(this.apU)) {
                    aqh();
                    break;
                }
                v.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
                finish();
                break;
            case 6:
                getIntent().putExtra("free_wifi_channel_id", 10);
                this.bkh = 10;
                if (!be.kS(this.apU)) {
                    aqh();
                    break;
                }
                v.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
                finish();
                break;
            default:
                v.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "unkown scene, just finish");
                finish();
                break;
        }
        v.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiNetCheckUI.handleRequstByScene, desc=it decides the channel. channel=%d", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(this.intent)), Integer.valueOf(this.bkh)});
    }

    private void aqh() {
        if (be.kS(this.apU)) {
            v.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
            finish();
            return;
        }
        this.gcp = new a(this, this.apU, this.bkh);
        v.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiNetCheckUI.connectFreewifi, desc=base params are ready and it will connets wifi.apKey=%s, channel=%d", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(this.intent)), this.apU, Integer.valueOf(this.bkh)});
        a aVar = this.gcp;
        if (be.kS(aVar.aYz)) {
            v.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
            aVar.aXH.finish();
        }
        aVar.aXH.getIntent().putExtra("free_wifi_url", aVar.aYz);
        aVar.aXH.getIntent().putExtra("free_wifi_ap_key", aVar.aYz);
        if (be.kS(aVar.aYz)) {
            v.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ap key is null");
            aVar.aXH.finish();
            return;
        }
        v.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo, desc=it starts net request [getApInfo] for retrieving protocol type and frontpage info. apKey=%s, channel=%d", new Object[]{m.s(aVar.intent), Integer.valueOf(m.t(aVar.intent)), aVar.aYz, Integer.valueOf(aVar.bkh)});
        k.a aoy = k.aoy();
        aoy.aYz = aVar.aYz;
        aoy.fXa = m.s(aVar.intent);
        aoy.fXc = b.GetFrontPage.fXM;
        aoy.fXd = b.GetFrontPage.name;
        aoy.bkh = aVar.bkh;
        aoy.fXb = m.u(aVar.intent);
        aoy.aoA().b(aVar.intent, false).aoz();
        new com.tencent.mm.plugin.freewifi.d.a(aVar.aYz, aVar.bkh, m.s(aVar.intent)).v(aVar.aXH).b(new e(aVar) {
            final /* synthetic */ a gbh;

            {
                this.gbh = r1;
            }

            public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                boolean z;
                com.tencent.mm.plugin.freewifi.k.a aoy = k.aoy();
                aoy.aYz = this.gbh.aYz;
                aoy.fXa = m.s(this.gbh.intent);
                aoy.fXc = b.GetFrontPageReturn.fXM;
                aoy.fXd = b.GetFrontPageReturn.name;
                aoy.fXb = m.u(this.gbh.intent);
                aoy.bkh = this.gbh.bkh;
                aoy.bpc = i2;
                aoy.eOP = str;
                k aoA = aoy.aoA();
                Intent intent = this.gbh.intent;
                if (i2 != 0) {
                    z = true;
                } else {
                    z = false;
                }
                aoA.b(intent, z).aoz();
                v.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback, desc=net request [getApInfo] returns. errType=%d, errCode=%d, errMsg=%s", new Object[]{m.s(this.gbh.intent), Integer.valueOf(m.t(this.gbh.intent)), Integer.valueOf(i), Integer.valueOf(i2), str});
                if (i == 0 && i2 == 0) {
                    a aVar = this.gbh;
                    if (kVar instanceof com.tencent.mm.plugin.freewifi.d.a) {
                        com.tencent.mm.plugin.freewifi.d.a aVar2 = (com.tencent.mm.plugin.freewifi.d.a) kVar;
                        aVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_SHOULD_BIND_PHONE", aVar2.apt());
                        qz apu = aVar2.apu();
                        if (apu != null) {
                            v.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo/getFrontPage), desc=net request [getapinfo] gets response. frontpageinfo:  appid: %s, nickName: %s, userName: %s, headImgUrl: %s, welcomeMsg: %s, privacyDescriUrl: %s, timestamp=%s, sign=%s, HasMobile=%d", new Object[]{m.s(aVar.intent), Integer.valueOf(m.t(aVar.intent)), apu.mbH, apu.efy, apu.gln, apu.muL, apu.muM, apu.muN, apu.mgs, apu.mmV, Integer.valueOf(apu.lZq)});
                            aVar.intent.putExtra("free_wifi_appid", apu.mbH);
                            aVar.intent.putExtra("free_wifi_head_img_url", apu.muL);
                            aVar.intent.putExtra("free_wifi_welcome_msg", apu.muM);
                            aVar.intent.putExtra("free_wifi_privacy_url", apu.muN);
                            aVar.intent.putExtra("free_wifi_app_nickname", apu.efy);
                            aVar.intent.putExtra("free_wifi_welcome_sub_title", apu.muO);
                        }
                        if (aVar.bkh != 2) {
                            aVar.aXH.getIntent().putExtra("free_wifi_jump_to_main_ui", true);
                        }
                        aoj aps = aVar2.aps();
                        if (aps == null) {
                            v.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get qstring from server is null");
                            aVar.aXH.finish();
                            aoy = k.aoy();
                            aoy.aYz = aVar.aYz;
                            aoy.fXa = m.s(aVar.intent);
                            aoy.fXc = b.GetFrontPageReturnDataCheck.fXM;
                            aoy.fXd = b.GetFrontPageReturnDataCheck.name;
                            aoy.fXb = m.u(aVar.intent);
                            aoy.bkh = aVar.bkh;
                            aoy.bpc = -1;
                            aoy.eOP = "qstrInfo is null.";
                            aoy.aoA().b(aVar.intent, true).aoz();
                            return;
                        } else if (m.ty(aps.fvp)) {
                            v.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get qstrInfo.ssid from server is empty");
                            aVar.aXH.finish();
                            aoy = k.aoy();
                            aoy.aYz = aVar.aYz;
                            aoy.fXa = m.s(aVar.intent);
                            aoy.fXc = b.GetFrontPageReturnDataCheck.fXM;
                            aoy.fXd = b.GetFrontPageReturnDataCheck.name;
                            aoy.fXb = m.u(aVar.intent);
                            aoy.bkh = aVar.bkh;
                            aoy.bpc = -1;
                            aoy.eOP = "qstrInfo.Ssid is empty.";
                            aoy.aoA().b(aVar.intent, true).aoz();
                            return;
                        } else {
                            aVar.intent.putExtra("free_wifi_ssid", aps.fvp);
                            v.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=net request [getApInfo/getFrontPage] gets response. qstrInfo:  prototype = %d, ssid : %s, pssword : %s", new Object[]{m.s(aVar.intent), Integer.valueOf(m.t(aVar.intent)), Integer.valueOf(aps.mOy), aps.fvp, aps.mrz});
                            String apv = aVar2.apv();
                            String apw = aVar2.apw();
                            aVar.intent.putExtra("free_wifi_openid", apv);
                            aVar.intent.putExtra("free_wifi_tid", apw);
                            aVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP", apu.mgs);
                            aVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_SIGN", apu.mmV);
                            v.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=net request [getApInfo/getFrontPage] gets response. openId=%s, tid=%s", new Object[]{m.s(aVar.intent), Integer.valueOf(m.t(aVar.intent)), apv, apw});
                            aVar.intent.putExtra("free_wifi_protocol_type", aps.mOy);
                            if (aps.mOy == 10) {
                                if (be.kS(aps.fvp) || be.kS(aps.mrz)) {
                                    v.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ssid or password is null");
                                    aVar.aXH.finish();
                                    return;
                                }
                                aVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 4);
                                aVar.intent.putExtra("free_wifi_auth_type", 2);
                                aVar.intent.putExtra("free_wifi_passowrd", aps.mrz);
                                aVar.intent.setClass(aVar.aXH, FreeWifiFrontPageUI.class);
                                aVar.aXH.startActivity(aVar.intent);
                                aVar.aXH.finish();
                                aVar.aXH.overridePendingTransition(2130968680, 2130968677);
                                return;
                            } else if (aps.mOy == 11) {
                                if (be.kS(aps.fvp) || be.kS(aps.mrz)) {
                                    v.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ssid or password is null");
                                    aVar.aXH.finish();
                                    return;
                                }
                                aVar.intent.putExtra("free_wifi_auth_type", 2);
                                aVar.intent.putExtra("free_wifi_passowrd", aps.mrz);
                                aVar.intent.setClass(aVar.aXH, FreewifiActivateWeChatNoAuthStateUI.class);
                                aVar.aXH.startActivity(aVar.intent);
                                aVar.aXH.finish();
                                aVar.aXH.overridePendingTransition(2130968680, 2130968677);
                                return;
                            } else if (aps.mOy == 12) {
                                aVar.intent.putExtra("free_wifi_auth_type", 1);
                                aVar.intent.setClass(aVar.aXH, FreeWifiActivateAuthStateUI.class);
                                aVar.aXH.startActivity(aVar.intent);
                                aVar.aXH.finish();
                                aVar.aXH.overridePendingTransition(2130968680, 2130968677);
                                return;
                            } else if (aps.mOy == 31) {
                                aVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 31);
                                v.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it goes into protocal 31 handle branch.", new Object[]{m.s(aVar.intent), Integer.valueOf(m.t(aVar.intent))});
                                String stringExtra = aVar.intent.getStringExtra("free_wifi_schema_ticket");
                                v.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it tries to get ticket. ticket=%s.", new Object[]{m.s(aVar.intent), Integer.valueOf(m.t(aVar.intent)), stringExtra});
                                if (be.kS(stringExtra)) {
                                    aVar.aXH.finish();
                                    aoy = k.aoy();
                                    aoy.aYz = aVar.aYz;
                                    aoy.fXa = m.s(aVar.intent);
                                    aoy.fXc = b.GetFrontPageReturnDataCheck.fXM;
                                    aoy.fXd = b.GetFrontPageReturnDataCheck.name;
                                    aoy.bkh = aVar.bkh;
                                    aoy.fXb = m.u(aVar.intent);
                                    aoy.bpc = -1;
                                    aoy.eOP = "31 ticket is empty.";
                                    aoy.aoA().b(aVar.intent, true).aoz();
                                    return;
                                }
                                String str2 = aps.fvp;
                                String str3 = apu.mgs;
                                String str4 = apu.mmV;
                                WifiInfo aoZ = d.aoZ();
                                if (aoZ == null) {
                                    v.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=it tries to get current connected wifi info but return null, so it fails to connect wifi. ", new Object[]{m.s(aVar.intent), Integer.valueOf(m.t(aVar.intent))});
                                    aVar.tR(aVar.aXH.getString(2131232957));
                                    aoy = k.aoy();
                                    aoy.aYz = aVar.aYz;
                                    aoy.fXa = m.s(aVar.intent);
                                    aoy.fXc = b.GetFrontPageReturnDataCheck.fXM;
                                    aoy.fXd = b.GetFrontPageReturnDataCheck.name;
                                    aoy.bkh = aVar.bkh;
                                    aoy.fXb = m.u(aVar.intent);
                                    aoy.bpc = -1;
                                    aoy.eOP = "wifiInfo is empty.";
                                    aoy.aoA().b(aVar.intent, true).aoz();
                                    return;
                                }
                                boolean tH = d.tH(str2);
                                String str5 = "MicroMsg.FreeWifi.FreeWifiNetCheckUI";
                                String str6 = "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=it gets connected wifi info. wifiInfo=%s, is_current_connected_ssid_equals_target_ssid=%b";
                                Object[] objArr = new Object[4];
                                objArr[0] = m.s(aVar.intent);
                                objArr[1] = Integer.valueOf(m.t(aVar.intent));
                                objArr[2] = aoZ == null ? "null" : aoZ.toString();
                                objArr[3] = Boolean.valueOf(tH);
                                v.i(str5, str6, objArr);
                                str5 = m.tz(aoZ.getSSID());
                                str6 = aoZ.getBSSID();
                                String macAddress = aoZ.getMacAddress();
                                if (VERSION.SDK_INT > 22 && (macAddress == null || macAddress.equals("02:00:00:00:00:00"))) {
                                    macAddress = m.aoD();
                                }
                                v.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo desc=it starts net request [GetPortalApInfo]  for portal ap info. apKey=%s, apSsid=%s, apBssid=%s, mobileMac=%s, ticket=%s", new Object[]{m.s(aVar.intent), Integer.valueOf(m.t(aVar.intent)), aVar.aYz, str5, str6, macAddress, stringExtra});
                                aoy = k.aoy();
                                aoy.aYz = aVar.aYz;
                                aoy.fXa = m.s(aVar.intent);
                                aoy.fXc = b.GetFrontPageReturnDataCheck.fXM;
                                aoy.fXd = b.GetFrontPageReturnDataCheck.name;
                                aoy.bkh = aVar.bkh;
                                aoy.fXb = m.u(aVar.intent);
                                aoy.bpc = 0;
                                aoy.eOP = "";
                                aoy.aoA().b(aVar.intent, true).aoz();
                                aoy = k.aoy();
                                aoy.ssid = aVar.intent.getStringExtra("free_wifi_ssid");
                                aoy.aYz = aVar.aYz;
                                aoy.fWZ = aVar.intent.getStringExtra("free_wifi_appid");
                                aoy.fXa = m.s(aVar.intent);
                                aoy.fXb = m.u(aVar.intent);
                                aoy.fXc = b.GetPortalApInfo.fXM;
                                aoy.fXd = b.GetPortalApInfo.name;
                                aoy.bkh = m.v(aVar.intent);
                                aoy.fXb = m.u(aVar.intent);
                                aoy.aoA().b(aVar.intent, false).aoz();
                                new i(aVar.aYz, str5, str6, macAddress, stringExtra, m.s(aVar.intent)).v(aVar.aXH).b(new AnonymousClass2(aVar, apv, apw, str3, str4));
                                return;
                            } else if (aps.mOy == 32) {
                                aVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 32);
                                v.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it goes into protocal 32 handle branch.", new Object[]{m.s(aVar.intent), Integer.valueOf(m.t(aVar.intent))});
                                aVar.intent.setClass(aVar.aXH, FreeWifiFrontPageUI.class);
                                aVar.aXH.startActivity(aVar.intent);
                                aVar.aXH.finish();
                                aVar.aXH.overridePendingTransition(2130968680, 2130968677);
                                return;
                            } else if (aps.mOy == 1) {
                                aVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 1);
                                aVar.intent.putExtra("free_wifi_auth_type", 1);
                                aVar.intent.setClass(aVar.aXH, FreeWifiFrontPageUI.class);
                                aVar.aXH.startActivity(aVar.intent);
                                aVar.aXH.finish();
                                aVar.aXH.overridePendingTransition(2130968680, 2130968677);
                                return;
                            } else {
                                aVar.aXH.finish();
                                aVar.tR(aVar.aXH.getString(2131232959));
                                return;
                            }
                        }
                    }
                    aVar.tR(aVar.aXH.getString(2131232957));
                } else if (m.bG(i, i2) && !m.ty(str)) {
                    this.gbh.tR(str + "(" + m.a(m.u(this.gbh.intent), b.GetFrontPageReturn, i2) + ")");
                } else if (i2 == -30031) {
                    this.gbh.tR(this.gbh.aXH.getString(2131232958));
                } else {
                    this.gbh.tR(this.gbh.aXH.getString(2131232957) + "(" + String.format("%02d", new Object[]{Integer.valueOf(m.u(this.gbh.intent))}) + b.GetFrontPageReturn.fXM + Math.abs(i2) + ")");
                }
            }
        });
    }

    protected final int getLayoutId() {
        return 2130903663;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.gcp != null) {
            this.gcp = null;
        }
        this.aSW.QI();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }
}
