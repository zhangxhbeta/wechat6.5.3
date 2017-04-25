package com.tencent.mm.plugin.nearby.a;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode;
import com.tencent.mm.protocal.c.afs;
import com.tencent.mm.protocal.c.afw;
import com.tencent.mm.protocal.c.afx;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.h;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.ArrayList;
import java.util.List;

public final class d extends k implements j {
    private final b cif;
    private e cii;

    public d(int i, float f, float f2, int i2, int i3, String str, String str2) {
        if (!(i == 1 || i == 2 || i == 3 || i == 4)) {
            v.e("MicroMsg.NetSceneLbsP", "OpCode Error :" + i);
        }
        a aVar = new a();
        aVar.czn = new afw();
        aVar.czo = new afx();
        aVar.uri = "/cgi-bin/micromsg-bin/lbsfind";
        aVar.czm = JsApiScanCode.CTRL_INDEX;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        afw com_tencent_mm_protocal_c_afw = (afw) this.cif.czk.czs;
        com_tencent_mm_protocal_c_afw.lZm = i;
        com_tencent_mm_protocal_c_afw.mjM = f;
        com_tencent_mm_protocal_c_afw.mjN = f2;
        com_tencent_mm_protocal_c_afw.mrA = i2;
        com_tencent_mm_protocal_c_afw.mrB = str;
        com_tencent_mm_protocal_c_afw.mrC = str2;
        com_tencent_mm_protocal_c_afw.mrD = i3;
        v.d("MicroMsg.NetSceneLbsP", "Req: opcode:" + i + " lon:" + f + " lat:" + f2 + " pre:" + i2 + " gpsSource:" + i3 + " mac" + str + " cell:" + str2);
        n.a(2001, f, f2, i2);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return JsApiScanCode.CTRL_INDEX;
    }

    public final int AG() {
        return ((afw) this.cif.czk.czs).lZm;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneLbsP", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        afx com_tencent_mm_protocal_c_afx = (afx) ((b) pVar).czl.czs;
        List arrayList = new ArrayList();
        for (int i4 = 0; i4 < com_tencent_mm_protocal_c_afx.mxQ.size(); i4++) {
            h hVar = new h();
            hVar.username = ((afs) com_tencent_mm_protocal_c_afx.mxQ.get(i4)).gln;
            hVar.bBY = ((afs) com_tencent_mm_protocal_c_afx.mxQ.get(i4)).mbX;
            hVar.cyD = ((afs) com_tencent_mm_protocal_c_afx.mxQ.get(i4)).mlY;
            hVar.cyC = ((afs) com_tencent_mm_protocal_c_afx.mxQ.get(i4)).mlZ;
            hVar.aP(true);
            arrayList.add(hVar);
        }
        com.tencent.mm.u.n.Bo().z(arrayList);
        if (AG() == 1 || AG() == 3 || AG() == 4) {
            if (i2 == 0 || i3 != -2001) {
                ak.yW();
                c.vf().set(8210, Long.valueOf(System.currentTimeMillis() + ((long) (com_tencent_mm_protocal_c_afx.mFL * BaseReportManager.MAX_READ_COUNT))));
            } else {
                ak.yW();
                c.vf().set(8210, Long.valueOf(0));
                this.cii.a(i2, i3, str, this);
                return;
            }
        } else if (AG() == 2) {
            ak.yW();
            c.vf().set(8210, Long.valueOf(0));
        }
        this.cii.a(i2, i3, str, this);
    }

    public final boolean aDy() {
        return ((afx) this.cif.czl.czs).mFM == 1;
    }

    public final int aDz() {
        return ((afx) this.cif.czl.czs).mFN;
    }

    public final List<afs> aDA() {
        List<afs> list = ((afx) this.cif.czl.czs).mxQ;
        if (list != null) {
            for (afs com_tencent_mm_protocal_c_afs : list) {
                ak.yW().xv().dJ(com_tencent_mm_protocal_c_afs.gln, com_tencent_mm_protocal_c_afs.mvR);
            }
        }
        return list;
    }
}
