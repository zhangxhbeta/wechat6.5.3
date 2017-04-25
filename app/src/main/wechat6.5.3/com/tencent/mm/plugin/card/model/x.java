package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.iv;
import com.tencent.mm.protocal.c.uf;
import com.tencent.mm.protocal.c.ug;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;
import org.json.JSONObject;

public final class x extends k implements j {
    private final b cif;
    private e cii;
    public String eDA;
    public int eDB;
    public String eDC;
    public String eDn;
    public int eDz;

    public x(LinkedList<iv> linkedList, int i, String str, String str2, String str3, String str4, String str5, int i2) {
        a aVar = new a();
        aVar.czn = new uf();
        aVar.czo = new ug();
        aVar.uri = "/cgi-bin/micromsg-bin/getcardlistfromapp";
        aVar.czm = 690;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        uf ufVar = (uf) this.cif.czk.czs;
        ufVar.lZQ = linkedList;
        ufVar.bon = i;
        ufVar.mct = str;
        ufVar.fZW = str2;
        ufVar.lZM = str3;
        ufVar.lZL = str4;
        ufVar.mxa = str5;
        ufVar.lZN = i2;
    }

    public final int getType() {
        return 690;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, errType = " + i2 + " errCode = " + i3 + " netType = 690");
        if (i2 == 0 && i3 == 0) {
            this.eDn = ((ug) this.cif.czl.czs).eDn;
            if (TextUtils.isEmpty(this.eDn)) {
                v.e("MicroMsg.NetSceneGetCardListFromApp", "parseRespData json_ret is empty!");
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(this.eDn);
                    this.eDz = jSONObject.optInt("accept_button_status", 0);
                    this.eDA = jSONObject.optString("accept_button_wording");
                    this.eDB = jSONObject.optInt("private_status", 0);
                    this.eDC = jSONObject.optString("private_wording");
                } catch (Throwable e) {
                    v.a("MicroMsg.NetSceneGetCardListFromApp", e, "", new Object[0]);
                    v.e("MicroMsg.NetSceneGetCardListFromApp", "parseRespData:" + e.getMessage());
                }
            }
        }
        this.cii.a(i2, i3, str, this);
    }
}
