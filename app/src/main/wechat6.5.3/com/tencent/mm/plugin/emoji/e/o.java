package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.ol;
import com.tencent.mm.protocal.c.xx;
import com.tencent.mm.protocal.c.xy;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class o extends k implements j {
    private int cVh;
    private final b cif;
    private e cii;
    public byte[] fek;
    private int fev;

    public o(int i, byte[] bArr) {
        this(i, bArr, (byte) 0);
    }

    private o(int i, byte[] bArr, byte b) {
        this.fek = null;
        a aVar = new a();
        aVar.czn = new xx();
        aVar.czo = new xy();
        aVar.uri = "/cgi-bin/micromsg-bin/mmgetpersonaldesigner";
        aVar.czm = 720;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        this.fev = i;
        this.fek = bArr;
        this.cVh = 0;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.emoji.NetSceneGetPersonalDesigner", "NetSceneGetPersonalDesigner errType:%d,errcode:%d,errMsg:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        xy xyVar = (xy) ((b) pVar).czl.czs;
        if (xyVar.mcz != null) {
            this.fek = m.a(xyVar.mcz);
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 720;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        xx xxVar = (xx) this.cif.czk.czs;
        xxVar.mxS = this.fev;
        if (this.fek != null) {
            xxVar.mcz = m.H(this.fek);
        } else {
            xxVar.mcz = new are();
        }
        xxVar.maG = this.cVh;
        v.d("MicroMsg.emoji.NetSceneGetPersonalDesigner", xxVar.mcz == null ? "Buf is NULL" : xxVar.mcz.toString());
        return a(eVar, this.cif, this);
    }

    public final xy afS() {
        return this.cif == null ? null : (xy) this.cif.czl.czs;
    }

    public static com.tencent.mm.plugin.emoji.model.e a(xy xyVar) {
        v.d("MicroMsg.emoji.NetSceneGetPersonalDesigner", "getEmotionListModel");
        if (xyVar == null) {
            return null;
        }
        com.tencent.mm.plugin.emoji.model.e eVar = new com.tencent.mm.plugin.emoji.model.e();
        if (!(xyVar == null || xyVar.myi == null)) {
            eVar.fcS = xyVar.myi.size();
            List arrayList = new ArrayList();
            Iterator it = xyVar.myi.iterator();
            while (it.hasNext()) {
                ol olVar = (ol) it.next();
                if (olVar.mdM != null) {
                    arrayList.add(new f(olVar));
                }
            }
            eVar.fcT = arrayList;
        }
        return eVar;
    }

    protected final int a(p pVar) {
        return k.b.czU;
    }

    protected final int ul() {
        return 100;
    }
}
