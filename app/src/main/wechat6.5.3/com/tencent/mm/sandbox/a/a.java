package com.tencent.mm.sandbox.a;

import com.tencent.mm.b.i;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsimple.ai;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sandbox.SubCoreSandBox;
import com.tencent.mm.pluginsdk.j.ae;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.zu;
import com.tencent.mm.protocal.c.zv;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class a extends k implements j, ae {
    public final b cif;
    private e cii;

    public a(int i) {
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new zu();
        aVar.czo = new zv();
        aVar.uri = "/cgi-bin/micromsg-bin/getupdateinfo";
        aVar.czm = MMGIFException.D_GIF_ERR_EOF_TOO_SOON;
        this.cif = aVar.Bv();
        zu zuVar = (zu) this.cif.czk.czs;
        zuVar.mBi = i;
        zuVar.lZo = f.aPW;
        if (10012 == q.dqj && q.dqk > 0) {
            zuVar.lZo = q.dqk;
        }
        switch (i) {
            case 1:
                g.iuh.a(405, 3, 1, true);
                break;
            case 2:
                g.iuh.a(405, 4, 1, true);
                break;
            case 3:
                g.iuh.a(405, 5, 1, true);
                break;
            case 4:
                g.iuh.a(405, 6, 1, true);
                break;
        }
        v.i("MicroMsg.NetSceneGetUpdateInfo", "summerupdate dkchan NetSceneGetUpdateInfo updateType:%d channel:%d release:%d, stack[%s]", Integer.valueOf(zuVar.mBi), Integer.valueOf(zuVar.lZo), Integer.valueOf(f.aPW), be.bur());
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 11;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken GetUpdateInfo onGYNetEnd errType[%d], errCode[%d], errMsg[%s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            g.iuh.a(405, 7, 1, true);
        } else {
            g.iuh.a(405, 8, 1, true);
            if (i2 == 4) {
                g.iuh.a(405, 9, 1, true);
                if (i3 == -16) {
                    g.iuh.a(405, 10, 1, true);
                } else if (i3 == -17) {
                    g.iuh.a(405, 11, 1, true);
                } else if (i3 == -18) {
                    g.iuh.a(405, 12, 1, true);
                }
            }
        }
        this.cii.a(i2, i3, str, this);
        String bsd = bsd();
        if (bsd != null) {
            v.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchVersionCode[%d]", Integer.valueOf(i.be(bsd).versionCode));
            ak.vy().a(new ai(aa.getPackageName(), r0), 0);
            g.iuh.a(405, 13, 1, true);
            return;
        }
        v.w("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchXml is null!");
        g.iuh.a(405, 14, 1, true);
    }

    public final int bsb() {
        return ((zv) this.cif.czl.czs).mBl;
    }

    public final String bsc() {
        return ((zv) this.cif.czl.czs).mBk;
    }

    public final int bmx() {
        return ((zv) this.cif.czl.czs).mBj;
    }

    public final String[] bmy() {
        zv zvVar = (zv) this.cif.czl.czs;
        String[] strArr = new String[zvVar.mBo.size()];
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            strArr[i] = ((arf) zvVar.mBo.get(i)).mQy;
        }
        return strArr;
    }

    public final String bsd() {
        v.d("MicroMsg.NetSceneGetUpdateInfo", "summertoken getPatchInfo[%s], stack[%s]", ((zv) this.cif.czl.czs).mBp, be.bur());
        return ((zv) this.cif.czl.czs).mBp;
    }

    public final zv bmz() {
        int i = 1;
        if (SubCoreSandBox.ivt) {
            zv zvVar = (zv) this.cif.czl.czs;
            zvVar.mBq = 1;
            zvVar.mBr = "http://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index";
            if (!SubCoreSandBox.ivu) {
                i = 0;
            }
            zvVar.mBs = i;
        }
        return (zv) this.cif.czl.czs;
    }
}
