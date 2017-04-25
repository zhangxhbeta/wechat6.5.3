package com.tencent.mm.plugin.location.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.location.ui.impl.f;
import com.tencent.mm.protocal.c.alf;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.xl;
import com.tencent.mm.protocal.c.xm;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class h extends k implements j {
    public int bdf;
    public String biS;
    private Runnable cZn;
    public final b cif;
    private e cii;
    public boolean eDI = false;
    public int errCode;
    public int errType;
    public List<f> gKQ = new ArrayList();
    public byte[] gRZ;
    public byte[] gSa = null;
    public String gSb = "";

    public h(byte[] bArr, double d, double d2, int i, int i2, double d3, double d4, String str, String str2) {
        a aVar = new a();
        aVar.czn = new xl();
        aVar.czo = new xm();
        aVar.czo = new xm();
        aVar.uri = "/cgi-bin/micromsg-bin/getpoilist";
        aVar.czm = 457;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        xl xlVar = (xl) this.cif.czk.czs;
        xlVar.mzn = bArr == null ? new are() : new are().ba(bArr);
        xlVar.muW = str2;
        xlVar.mhZ = d;
        xlVar.mhY = d2;
        xlVar.maG = i;
        xlVar.lZm = i2;
        xlVar.mzK = d4;
        xlVar.mzJ = d3;
        this.bdf = xlVar.lZm;
        this.gSb = str;
        this.gRZ = bArr;
        v.i("MicroMsg.NetSceneGetPoiList", "lat %f lng %f scene %d opcode %d oriLat %f oriLng %f" + bArr, new Object[]{Double.valueOf(d), Double.valueOf(d2), Integer.valueOf(i), Integer.valueOf(i2), Double.valueOf(d4), Double.valueOf(d3)});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.d("MicroMsg.NetSceneGetPoiList", "scene done");
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 457;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneGetPoiList", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + "errMsg:" + str);
        this.errType = i2;
        this.errCode = i3;
        this.biS = str;
        xm xmVar = (xm) this.cif.czl.czs;
        this.gKQ.clear();
        v.d("MicroMsg.NetSceneGetPoiList", "url " + xmVar.mzt + " " + xmVar.mzO + " " + xmVar.glb);
        if (xmVar.mzM != null) {
            v.d("MicroMsg.NetSceneGetPoiList", "poi result %d ", new Object[]{Integer.valueOf(xmVar.mzM.size())});
            if (xmVar.mzM.size() > 0) {
                v.d("MicroMsg.NetSceneGetPoiList", "addr %s, province %s, street %s, city %s", new Object[]{((alf) xmVar.mzM.get(0)).mMa, ((alf) xmVar.mzM.get(0)).cHd, ((alf) xmVar.mzM.get(0)).moF, ((alf) xmVar.mzM.get(0)).cHe});
            }
            Iterator it = xmVar.mzM.iterator();
            while (it.hasNext()) {
                this.gKQ.add(new f((alf) it.next()));
            }
        }
        if (xmVar.mzn != null) {
            this.gSa = m.a(xmVar.mzn);
        }
        this.eDI = xmVar.mzN == 1;
        this.cii.a(i2, i3, str, this);
        if (this.cZn != null) {
            this.cZn.run();
        }
    }
}
