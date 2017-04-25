package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.sdk.platformtools.v;

public class e {
    protected int aPW = this.intent.getIntExtra("free_wifi_channel_id", 0);
    protected String aYz = this.intent.getStringExtra("free_wifi_ap_key");
    protected String appId = this.intent.getStringExtra("free_wifi_appid");
    protected int bbT = this.intent.getIntExtra("free_wifi_source", 1);
    protected FreeWifiFrontPageUI fZC;
    protected String fZD = this.intent.getStringExtra("free_wifi_url");
    protected int fZE = this.intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
    protected String fZF = this.intent.getStringExtra("free_wifi_app_nickname");
    protected final Intent intent;
    protected String ssid = this.intent.getStringExtra("free_wifi_ssid");

    public e(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        this.fZC = freeWifiFrontPageUI;
        this.intent = freeWifiFrontPageUI.getIntent();
        v.i("MicroMsg.FreeWifi.ProtocolBase", "sessionKey=%s, step=%d, desc=Data retrieved. ssid=%s, fullUrl=%s, apKey=%s, source=%s, channelId=%d, appid=%s, appNickName=%s, protocolNumber=%d", new Object[]{m.s(this.intent), Integer.valueOf(m.t(this.intent)), this.ssid, this.fZD, this.aYz, Integer.valueOf(this.bbT), Integer.valueOf(this.aPW), this.appId, this.fZF, Integer.valueOf(this.fZE)});
    }
}
