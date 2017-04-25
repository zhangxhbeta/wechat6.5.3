package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.dg;
import com.tencent.mm.protocal.c.dh;
import com.tencent.mm.protocal.c.oj;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.text.DecimalFormat;

public final class b extends k implements j {
    public static int fdH = 6;
    public static int fdI = 7;
    public static int fdJ = 10;
    private final com.tencent.mm.v.b cif;
    private e cxf;
    private String fdK;
    private oj fdL;

    public b(String str, oj ojVar) {
        a aVar = new a();
        aVar.czn = new dg();
        aVar.czo = new dh();
        aVar.uri = "/cgi-bin/micromsg-bin/mmaskforreward";
        aVar.czm = 830;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        this.fdK = str;
        this.fdL = ojVar;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.emoji.NetSceneAskForReward", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.cxf.a(i2, i3, str, this);
    }

    public final int getType() {
        return 830;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cxf = eVar2;
        dg dgVar = (dg) this.cif.czk.czs;
        dgVar.mdM = this.fdK;
        oj ojVar = new oj();
        ojVar.gnz = this.fdL.gnz;
        ojVar.mqB = this.fdL.mqB;
        ojVar.mqA = new DecimalFormat("0.00").format(Float.valueOf(this.fdL.mqA));
        dgVar.mdN = ojVar;
        return a(eVar, this.cif, this);
    }

    public final dh afI() {
        return (dh) this.cif.czl.czs;
    }
}
