package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.protocal.c.oh;
import com.tencent.mm.protocal.c.vo;
import com.tencent.mm.protocal.c.vp;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.l;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;

public final class k extends com.tencent.mm.v.k implements j {
    private int ajd;
    private int cVh;
    private final b cif;
    private e cii;
    public String fdU;

    public k(String str, int i, int i2) {
        this.fdU = str;
        this.cVh = i;
        this.ajd = i2;
        a aVar = new a();
        aVar.czn = new vo();
        aVar.czo = new vp();
        aVar.uri = "/cgi-bin/micromsg-bin/getemotiondetail";
        aVar.czm = 412;
        aVar.czp = 211;
        aVar.czq = 1000000211;
        this.cif = aVar.Bv();
    }

    public k(String str, int i) {
        this(str, i, -1);
    }

    public final int getType() {
        return 412;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.i("MicroMsg.emoji.NetSceneGetEmotionDetail", "ProductID:%s, Scene:%d, Version:%d", new Object[]{this.fdU, Integer.valueOf(this.cVh), Integer.valueOf(this.ajd)});
        this.cii = eVar2;
        vo voVar = (vo) this.cif.czk.czs;
        voVar.mdM = this.fdU;
        voVar.maG = this.cVh;
        voVar.efl = this.ajd;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.emoji.NetSceneGetEmotionDetail", "ErrType:" + i2 + "   errCode:" + i3);
        if (i2 == 0 || i3 == 0 || i3 == 5) {
            if (i2 == 0 && i3 == 0) {
                l lVar = g.afx().fcl;
                String str2 = this.fdU;
                vp vpVar = (vp) this.cif.czl.czs;
                String dJ = u.dJ(aa.getContext());
                if (be.kS(str2) || vpVar == null) {
                    v.w("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionRewardResponseWithPID failed. productId or response is null.");
                }
                try {
                    com.tencent.mm.storage.a.k kVar = new com.tencent.mm.storage.a.k();
                    kVar.field_productID = str2;
                    kVar.field_content = vpVar.toByteArray();
                    kVar.field_lan = dJ;
                    if (lVar.cie.replace("EmotionDetailInfo", "productID", kVar.py()) > 0) {
                        v.i("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionDetailResponseWithPID success. ProductId:%s", new Object[]{str2});
                    } else {
                        v.i("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionDetailResponseWithPID failed. ProductId:%s", new Object[]{str2});
                    }
                } catch (Throwable e) {
                    v.e("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionRewardResponseWithPID exception:%s", new Object[]{be.e(e)});
                }
            }
            this.cii.a(i2, i3, str, this);
            return;
        }
        this.cii.a(i2, i3, str, this);
    }

    public final oh afN() {
        oh ohVar = new oh();
        return ((vp) this.cif.czl.czs).myd;
    }
}
