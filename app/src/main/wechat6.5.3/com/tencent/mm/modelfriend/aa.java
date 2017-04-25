package com.tencent.mm.modelfriend;

import com.tencent.mm.model.ak;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.agl;
import com.tencent.mm.protocal.c.agm;
import com.tencent.mm.protocal.c.agn;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.h;
import com.tencent.mm.u.n;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aa extends k implements j {
    private final b cif;
    private e cii = null;

    public aa(String str, List<String[]> list) {
        int i = 0;
        a aVar = new a();
        aVar.czn = new agm();
        aVar.czo = new agn();
        aVar.uri = "/cgi-bin/micromsg-bin/listmfriend";
        aVar.czm = 431;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        agm com_tencent_mm_protocal_c_agm = (agm) this.cif.czk.czs;
        com_tencent_mm_protocal_c_agm.mpB = str;
        com_tencent_mm_protocal_c_agm.mGd = 0;
        if (list != null) {
            i = list.size();
        }
        com_tencent_mm_protocal_c_agm.mGb = i;
        com_tencent_mm_protocal_c_agm.mGe = new LinkedList();
        com_tencent_mm_protocal_c_agm.mGc = new LinkedList();
        if (list != null) {
            for (String[] strArr : list) {
                if (!be.kS(strArr[2])) {
                    com_tencent_mm_protocal_c_agm.mGc.add(new arf().JF(strArr[2]));
                }
            }
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final LinkedList<agl> Fx() {
        LinkedList linkedList = ((agn) this.cif.czl.czs).mGf;
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                agl com_tencent_mm_protocal_c_agl = (agl) it.next();
                ak.yW().xv().dJ(com_tencent_mm_protocal_c_agl.gln, com_tencent_mm_protocal_c_agl.mvR);
            }
        }
        return ((agn) this.cif.czl.czs).mGf;
    }

    public final int getType() {
        return 431;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        final agn com_tencent_mm_protocal_c_agn = (agn) this.cif.czl.czs;
        ak.vA().a(new ad.a(this) {
            final /* synthetic */ aa cIm;

            public final boolean Ba() {
                return false;
            }

            public final boolean AZ() {
                if (com_tencent_mm_protocal_c_agn != null && com_tencent_mm_protocal_c_agn.mGf.size() > 0) {
                    Iterator it = com_tencent_mm_protocal_c_agn.mGf.iterator();
                    while (it.hasNext()) {
                        agl com_tencent_mm_protocal_c_agl = (agl) it.next();
                        if (com_tencent_mm_protocal_c_agl.eeO == 1) {
                            h hVar = new h();
                            hVar.username = com_tencent_mm_protocal_c_agl.gln;
                            hVar.cyD = com_tencent_mm_protocal_c_agl.mlY;
                            hVar.cyC = com_tencent_mm_protocal_c_agl.mlZ;
                            hVar.bkU = -1;
                            v.d("MicroMsg.NetSceneListMFriend", "getmlist  %s b[%s] s[%s]", hVar.getUsername(), hVar.Be(), hVar.Bf());
                            hVar.bBY = 3;
                            hVar.aP(true);
                            n.Bo().a(hVar);
                        }
                    }
                }
                return true;
            }

            public final String toString() {
                return super.toString() + "|onGYNetEnd";
            }
        });
        this.cii.a(i2, i3, str, this);
    }
}
