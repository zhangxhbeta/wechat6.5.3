package com.tencent.mm.modelbiz;

import com.tencent.mm.model.ak;
import com.tencent.mm.network.j;
import com.tencent.mm.protocal.c.tp;
import com.tencent.mm.protocal.c.tq;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import org.json.JSONObject;

public final class p extends k implements j {
    public b cif;
    private e cii;
    private Object data;

    public static void a(e eVar) {
        ak.vy().b(1285, eVar);
    }

    public static boolean k(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("brand_user_name", str2);
            jSONObject.put("bizchat_id", str3);
            return ak.vy().a(new p(str, jSONObject.toString()), 0);
        } catch (Exception e) {
            return false;
        }
    }

    private p(String str, String str2) {
        a aVar = new a();
        aVar.czn = new tp();
        aVar.czo = new tq();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizjsapiresult";
        aVar.czm = 1285;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        tp tpVar = (tp) this.cif.czk.czs;
        tpVar.mop = str;
        tpVar.of = 1;
        tpVar.data = str2;
        this.data = null;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneGetBizJsApiResult", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1285;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        v.i("MicroMsg.NetSceneGetBizJsApiResult", "do scene");
        return a(eVar, this.cif, this);
    }
}
