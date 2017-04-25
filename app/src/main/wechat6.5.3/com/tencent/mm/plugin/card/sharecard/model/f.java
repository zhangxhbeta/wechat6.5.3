package com.tencent.mm.plugin.card.sharecard.model;

import android.text.TextUtils;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ahv;
import com.tencent.mm.protocal.c.ahw;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import org.json.JSONObject;

public final class f extends k implements j {
    private final b cif;
    private e cii;
    public String eBA;
    public String eBw;
    public int eBx = 0;
    public String eBy;
    public int eBz;
    public String eEx;

    public f(String str, int i, int i2, int i3) {
        a aVar = new a();
        aVar.czn = new ahv();
        aVar.czo = new ahw();
        aVar.uri = "/cgi-bin/micromsg-bin/marksharecard";
        aVar.czm = 907;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        ahv com_tencent_mm_protocal_c_ahv = (ahv) this.cif.czk.czs;
        com_tencent_mm_protocal_c_ahv.bol = str;
        com_tencent_mm_protocal_c_ahv.mHt = i2;
        com_tencent_mm_protocal_c_ahv.mHs = i;
        com_tencent_mm_protocal_c_ahv.scene = i3;
        this.eEx = str;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneMarkShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[]{Integer.valueOf(907), Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            ahw com_tencent_mm_protocal_c_ahw = (ahw) this.cif.czl.czs;
            v.i("MicroMsg.NetSceneMarkShareCard", "json_ret:" + com_tencent_mm_protocal_c_ahw.eDn);
            Object obj = com_tencent_mm_protocal_c_ahw.eDn;
            if (TextUtils.isEmpty(obj)) {
                v.e("MicroMsg.NetSceneMarkShareCard", "parseJson json_ret is empty!");
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(obj);
                    this.eBw = jSONObject.optString("mark_user");
                    this.eBx = jSONObject.optInt("mark_succ", 0);
                    this.eBy = jSONObject.optString("mark_card_id");
                    this.eBz = jSONObject.optInt("expire_time", 0);
                    this.eBA = jSONObject.optString("pay_qrcode_wording");
                } catch (Throwable e) {
                    v.a("MicroMsg.NetSceneMarkShareCard", e, "", new Object[0]);
                }
            }
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 907;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
