package com.tencent.mm.plugin.sns.a.a;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.at;
import com.tencent.mm.protocal.c.au;
import com.tencent.mm.protocal.c.av;
import com.tencent.mm.protocal.c.aw;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class d extends k implements j {
    private b cif;
    public e cii;

    public d(String str, int i, int i2, at atVar, aw awVar, int i3, String str2) {
        a aVar = new a();
        aVar.czn = new au();
        aVar.czo = new av();
        aVar.uri = "/cgi-bin/mmoc-bin/ad/exposure";
        aVar.czm = 1231;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        au auVar = (au) this.cif.czk.czs;
        auVar.mbp = i2;
        auVar.type = 2;
        auVar.scene = i;
        auVar.cZv = str;
        if (atVar != null) {
            auVar.mbq = atVar;
            v.i("MicroMsg.NetSceneAdExposure", "exposure_info " + atVar.mbn);
        }
        if (awVar != null) {
            auVar.mbr = awVar;
            v.i("MicroMsg.NetSceneAdExposure", "social_info " + awVar.mbt + " " + awVar.mbs);
        }
        WifiManager wifiManager = (WifiManager) aa.getContext().getSystemService("wifi");
        if (wifiManager != null) {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo != null) {
                auVar.bssid = be.ah(connectionInfo.getBSSID(), "");
                auVar.ssid = be.ah(connectionInfo.getSSID(), "");
            }
        }
        auVar.mbc = System.currentTimeMillis();
        auVar.mbe = i3;
        if (str2 != null) {
            auVar.mbb = str2;
        }
        v.i("MicroMsg.NetSceneAdExposure", "##time viewid " + str + " sceneType " + i + " type: 2 duration " + i2 + " ad_type " + i3 + " descXml:" + str2);
    }

    public d(String str, int i, int i2) {
        a aVar = new a();
        aVar.czn = new au();
        aVar.czo = new av();
        aVar.uri = "/cgi-bin/mmoc-bin/ad/exposure";
        aVar.czm = 1231;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        au auVar = (au) this.cif.czk.czs;
        auVar.type = 1;
        auVar.scene = i;
        auVar.cZv = str;
        auVar.mbe = i2;
        WifiManager wifiManager = (WifiManager) aa.getContext().getSystemService("wifi");
        if (wifiManager != null) {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo != null) {
                auVar.bssid = be.ah(connectionInfo.getBSSID(), "");
                auVar.ssid = be.ah(connectionInfo.getSSID(), "");
            }
        }
        auVar.mbc = System.currentTimeMillis();
        v.i("MicroMsg.NetSceneAdExposure", "##show viewid " + str + " sceneType " + i + " adtype: " + i2);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 1231;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneAdExposure", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        av avVar = (av) this.cif.czl.czs;
        v.i("MicroMsg.NetSceneAdExposure", "resp " + avVar.ret + " msg: " + avVar.lcr);
        this.cii.a(i2, i3, str, this);
    }
}
