package com.tencent.mm.plugin.wallet_core.id_verify.a;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.wallet_core.model.f;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.protocal.c.yq;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import org.json.JSONObject;

public final class b extends k implements j {
    private com.tencent.mm.v.b cif;
    private e cii;
    private long kMr = 10;

    public b() {
        v.i("MicroMsg.NetSceneGetRealnameWording", "NetSceneGetRealnameWording call");
        a aVar = new a();
        yp ypVar = new yp();
        ypVar.mkb = f.bfP();
        aVar.czn = ypVar;
        aVar.czo = new yq();
        aVar.uri = "/cgi-bin/mmpay-bin/getrealnamewording";
        aVar.czm = 1666;
        this.cif = aVar.Bv();
        this.cif.czB = true;
    }

    public final int getType() {
        return 1666;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneGetRealnameWording", "onGYNetEnd,errType=" + i2 + "errCode=" + i3);
        if (i2 == 0 && i3 == 0) {
            long j;
            yq yqVar = (yq) ((com.tencent.mm.v.b) pVar).czl.czs;
            if (yqVar.mAA <= 0) {
                j = this.kMr;
            } else {
                j = yqVar.mAA;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("bindcardTitle", yqVar.mAt);
                jSONObject.put("bindcardSubTitle", yqVar.mAu);
                jSONObject.put("bindIdTitle", yqVar.mAv);
                jSONObject.put("bindIdSubTitle", yqVar.mAw);
                jSONObject.put("extral_wording", yqVar.mAx);
                jSONObject.put("question_answer_switch", yqVar.mAy);
                jSONObject.put("question_answer_url", yqVar.mAz);
                jSONObject.put("cache_time", j);
                jSONObject.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
                jSONObject.put("isShowBindCard", yqVar.mAB);
                jSONObject.put("isShowBindCardVerify", yqVar.mAD);
                jSONObject.put("isShowBindId", yqVar.mAC);
                jSONObject.put("bindCardVerifyTitle", yqVar.mAE);
                jSONObject.put("bindCardVerifySubtitle", yqVar.mAF);
                jSONObject.put("bindCardVerifyAlertViewRightBtnTxt", yqVar.mAG);
                jSONObject.put("bindCardVerifyAlertViewContent", yqVar.mAH);
                jSONObject.put("isShowBindCardVerifyAlertView", yqVar.mAI);
                ak.yW();
                c.vf().a(t.a.nsC, jSONObject.toString());
                ak.yW();
                c.vf().iB(true);
            } catch (Throwable e) {
                v.a("MicroMsg.NetSceneGetRealnameWording", e, "", new Object[0]);
            }
        }
        this.cii.a(i2, i3, str, this);
    }
}
