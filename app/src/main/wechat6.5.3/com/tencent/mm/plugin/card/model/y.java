package com.tencent.mm.plugin.card.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.uh;
import com.tencent.mm.protocal.c.ui;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;

public final class y extends k implements j {
    private final b cif;
    private e cii;
    public LinkedList<String> eAT;
    public int eAV;
    public int eAW;
    public int eAX;

    public y(String str) {
        a aVar = new a();
        aVar.czn = new uh();
        aVar.czo = new ui();
        aVar.uri = "/cgi-bin/micromsg-bin/getcardserial";
        aVar.czm = 577;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        ((uh) this.cif.czk.czs).bol = str;
    }

    public final int getType() {
        return 577;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            ui uiVar = (ui) this.cif.czl.czs;
            this.eAT = uiVar.eAT;
            this.eAV = uiVar.eAV;
            this.eAW = uiVar.eAW;
            this.eAX = uiVar.eAX;
        }
        v.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, resp request_time = %d, request_count = %d, refresh_interval = %d,", new Object[]{Integer.valueOf(this.eAV), Integer.valueOf(this.eAW), Integer.valueOf(this.eAX)});
        if (this.eAT != null) {
            v.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, resp codes size is " + this.eAT.size());
        }
        this.cii.a(i2, i3, str, this);
    }
}
