package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.protocal.c.vu;
import com.tencent.mm.protocal.c.vv;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.m;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class n extends k implements j {
    public static int fep = 0;
    public static int feq = 1;
    public static int fer = 1;
    public static int fes = 2;
    public static int fet = 256;
    private final b cif;
    private e cii;
    private String fdK;
    private int feu;

    public n(String str, int i) {
        a aVar = new a();
        aVar.czn = new vu();
        aVar.czo = new vv();
        aVar.uri = "/cgi-bin/micromsg-bin/mmgetemotionreward";
        aVar.czm = 822;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        this.fdK = str;
        this.feu = i;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.emoji.NetSceneGetEmotionReward", "errType:%d, errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            if (this.feu == fep) {
                com.tencent.mm.storage.a.n nVar = g.afx().fcm;
                String str2 = this.fdK;
                vv afR = afR();
                if (be.kS(str2) || afR == null) {
                    v.w("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID failed. productId or response is null.");
                } else {
                    try {
                        m mVar = new m();
                        mVar.field_productID = str2;
                        mVar.field_content = afR.toByteArray();
                        if (nVar.cie.replace("EmotionRewardInfo", "productID", mVar.py()) > 0) {
                            v.i("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID success. ProductId:%s", new Object[]{str2});
                        } else {
                            v.i("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID failed. ProductId:%s", new Object[]{str2});
                        }
                    } catch (Throwable e) {
                        v.e("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID exception:%s", new Object[]{be.e(e)});
                    }
                }
            }
            if (afR() == null || afR().myv == null) {
                v.i("MicroMsg.emoji.NetSceneGetEmotionReward", "getEmotionRewardRespone is null. so i think no such product reward information");
                g.afx().fco.bW(this.fdK, fet);
                g.afy().ap(this.fdK, fet);
            } else {
                g.afx().fco.bW(this.fdK, afR().myv.mbK);
                g.afy().ap(this.fdK, afR().myv.mbK);
            }
        } else if (i3 == 1) {
            g.afx().fco.bW(this.fdK, fet);
            g.afy().ap(this.fdK, fet);
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 822;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        vu vuVar = (vu) this.cif.czk.czs;
        vuVar.mdM = this.fdK;
        vuVar.lZm = this.feu;
        return a(eVar, this.cif, this);
    }

    public final vv afR() {
        return (vv) this.cif.czl.czs;
    }
}
