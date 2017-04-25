package com.tencent.mm.plugin.webview.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.acr;
import com.tencent.mm.protocal.c.sz;
import com.tencent.mm.protocal.c.ta;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.List;

public final class h extends k implements j {
    public final b cQA;
    private e cii;

    public h(List<acr> list, String str) {
        a aVar = new a();
        aVar.czn = new sz();
        aVar.czo = new ta();
        aVar.uri = "/cgi-bin/mmo2o-bin/getbeaconsingroup";
        aVar.czm = 1704;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cQA = aVar.Bv();
        sz szVar = (sz) this.cQA.czk.czs;
        szVar.mww.addAll(list);
        szVar.bmJ = str;
        v.i("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang]getBeaconsInGroupRequest.beacons.size:%d", new Object[]{Integer.valueOf(szVar.mww.size())});
    }

    public final int getType() {
        return 1704;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cQA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang][NetSceneGetBeaconSinGroup]:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            v.d("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang][NetSceneGetBeaconSinGroup]:net end ok");
        } else {
            v.d("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang][NetSceneGetBeaconSinGroup]:net end not ok");
        }
        this.cii.a(i2, i3, str, this);
    }
}
