package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bck;
import com.tencent.mm.protocal.c.bcl;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.List;

public final class r extends k implements j {
    private int cKy;
    private final b cif;
    private e cii;
    private List<String> few = new ArrayList();

    public r(List<String> list, int i) {
        a aVar = new a();
        aVar.czn = new bck();
        aVar.czo = new bcl();
        aVar.uri = "/cgi-bin/micromsg-bin/mmuploadmypanellist";
        aVar.czm = 717;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        this.few = list;
        this.cKy = i;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.emoji.NetSceneUploadMyPanelList", "errType:%d, errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            ak.yW();
            c.vf().a(t.a.noD, Long.valueOf(System.currentTimeMillis()));
            ak.yW();
            c.vf().a(t.a.noG, Boolean.valueOf(true));
            g.iuh.a(165, 0, 1, false);
        } else {
            ak.yW();
            c.vf().a(t.a.noD, Long.valueOf((System.currentTimeMillis() - 86400000) + 3600000));
            g.iuh.a(165, 1, 1, false);
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 717;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        bck com_tencent_mm_protocal_c_bck = (bck) this.cif.czk.czs;
        com_tencent_mm_protocal_c_bck.lZm = this.cKy;
        if (this.few != null) {
            for (Object obj : this.few) {
                Object obj2;
                if (!be.kS(obj2) && obj2.equals(String.valueOf(com.tencent.mm.storage.a.a.nwJ))) {
                    obj2 = "com.tencent.xin.emoticon.tusiji";
                }
                com_tencent_mm_protocal_c_bck.mYg.add(obj2);
                v.d("MicroMsg.emoji.NetSceneUploadMyPanelList", "product id is:%s", new Object[]{obj2});
            }
            v.i("MicroMsg.emoji.NetSceneUploadMyPanelList", "opcode is:%d mProductIdList size:%s", new Object[]{Integer.valueOf(this.cKy), Integer.valueOf(this.few.size())});
        }
        return a(eVar, this.cif, this);
    }
}
