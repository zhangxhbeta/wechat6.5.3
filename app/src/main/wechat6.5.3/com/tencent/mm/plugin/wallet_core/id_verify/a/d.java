package com.tencent.mm.plugin.wallet_core.id_verify.a;

import com.tencent.mm.network.e;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.azm;
import com.tencent.mm.protocal.c.azn;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.wallet_core.b.g;
import com.tencent.mm.wallet_core.b.l;
import com.tenpay.android.wechat.TenpayUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d extends g {
    public String token;

    public d(String str, String str2, int i) {
        Map hashMap = new HashMap();
        hashMap.put("flag", "1");
        hashMap.put("true_name", str);
        hashMap.put("identify_card", str2);
        hashMap.put("cre_type", "1");
        hashMap.put("realname_scene", String.valueOf(i));
        v.i("MicroMsg.NetSceneRealNameVerify", "realname_scene=%d", new Object[]{Integer.valueOf(i)});
        u(hashMap);
    }

    public final int bfq() {
        return 0;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (i == 0) {
            this.token = jSONObject.optString("token");
        }
    }

    public final void x(boolean z, boolean z2) {
        b bVar = this.cif;
        if (bVar == null) {
            a aVar = new a();
            aVar.czn = new azm();
            aVar.czo = new azn();
            aVar.uri = "/cgi-bin/mmpay-bin/tenpay/realnameauthen";
            aVar.czm = 1616;
            aVar.czp = 185;
            aVar.czq = 1000000185;
            bVar = aVar.Bv();
            bVar.czB = true;
        }
        b bVar2 = bVar;
        azm com_tencent_mm_protocal_c_azm = (azm) bVar2.czk.czs;
        if (z2) {
            com_tencent_mm_protocal_c_azm.mDj = 1;
        }
        this.cif = bVar2;
    }

    public final String CX(String str) {
        return TenpayUtil.signWith3Des(str);
    }

    public final void a(b bVar, are com_tencent_mm_protocal_c_are) {
        ((azm) bVar.czk.czs).mDk = com_tencent_mm_protocal_c_are;
    }

    public final void b(b bVar, are com_tencent_mm_protocal_c_are) {
        ((azm) bVar.czk.czs).mNe = com_tencent_mm_protocal_c_are;
    }

    public final l c(b bVar) {
        azn com_tencent_mm_protocal_c_azn = (azn) bVar.czl.czs;
        l lVar = new l();
        lVar.mDo = com_tencent_mm_protocal_c_azn.mDo;
        lVar.mDn = com_tencent_mm_protocal_c_azn.mDn;
        lVar.mDm = com_tencent_mm_protocal_c_azn.mDm;
        lVar.mDl = com_tencent_mm_protocal_c_azn.mDl;
        lVar.fvD = com_tencent_mm_protocal_c_azn.mNg;
        lVar.piF = com_tencent_mm_protocal_c_azn.mNf;
        return lVar;
    }

    public final int getType() {
        return 1616;
    }

    public final int a(e eVar, com.tencent.mm.v.e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
