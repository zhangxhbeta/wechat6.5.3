package com.tencent.mm.plugin.sns.a.a;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ap;
import com.tencent.mm.protocal.c.aq;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class c extends k implements j {
    private b cif;
    public e cii;

    public c(String str, int i, int i2, String str2, int i3) {
        this(str, i, i2, str2, i3, 0, 0, SQLiteDatabase.KeyEmpty);
    }

    public c(String str, int i, int i2, String str2, int i3, int i4, int i5, String str3) {
        a aVar = new a();
        aVar.czn = new ap();
        aVar.czo = new aq();
        aVar.uri = "/cgi-bin/mmoc-bin/ad/click";
        aVar.czm = 1232;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        v.i("MicroMsg.NetSceneAdClick", "NetSceneAdClick clickPos: " + i + " viewId: " + str + " sceneType: " + i2 + " adtype " + i3);
        if (!be.kS(str2)) {
            v.i("MicroMsg.NetSceneAdClick", "descXml: " + str2);
        }
        ap apVar = (ap) this.cif.czk.czs;
        apVar.cZy = i;
        apVar.cZv = str;
        apVar.scene = i2;
        apVar.mbb = str2;
        WifiManager wifiManager = (WifiManager) aa.getContext().getSystemService("wifi");
        if (wifiManager != null) {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo != null) {
                apVar.bssid = be.ah(connectionInfo.getBSSID(), SQLiteDatabase.KeyEmpty);
                apVar.ssid = be.ah(connectionInfo.getSSID(), SQLiteDatabase.KeyEmpty);
            }
        }
        apVar.mbc = System.currentTimeMillis();
        apVar.mbe = i3;
        apVar.mbf = i4;
        apVar.bbT = i5;
        apVar.mbg = str3;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 1232;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneAdClick", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.cii.a(i2, i3, str, this);
    }
}
