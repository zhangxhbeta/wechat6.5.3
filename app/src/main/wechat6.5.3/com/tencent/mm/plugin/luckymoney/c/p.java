package com.tencent.mm.plugin.luckymoney.c;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.acd;
import com.tencent.mm.protocal.c.ace;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.wallet_core.b.k;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONObject;

public abstract class p extends k {
    b cif;
    private e cii;

    public abstract void a(int i, String str, JSONObject jSONObject);

    public abstract String axK();

    public final void u(Map<String, String> map) {
        String xF = com.tencent.mm.model.k.xF();
        ak.yW();
        u LX = c.wH().LX(xF);
        if (LX != null) {
            map.put("province", LX.bvq());
            map.put("city", LX.getCityCode());
        }
        if (this.cif == null) {
            a aVar = new a();
            aVar.czn = new acd();
            aVar.czo = new ace();
            aVar.uri = axK();
            aVar.czm = getType();
            aVar.czp = 0;
            aVar.czq = 0;
            this.cif = aVar.Bv();
            this.cif.czB = true;
        }
        acd com_tencent_mm_protocal_c_acd = (acd) this.cif.czk.czs;
        com_tencent_mm_protocal_c_acd.mDi = axL();
        com_tencent_mm_protocal_c_acd.mDj = 1;
        Object[] toArray = map.keySet().toArray();
        Arrays.sort(toArray);
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (Object obj : toArray) {
            String str = (String) map.get(obj);
            if (!be.kS(str)) {
                if (i != 0) {
                    stringBuilder.append("&");
                }
                stringBuilder.append(obj);
                stringBuilder.append("=");
                stringBuilder.append(str);
                i = true;
            }
        }
        v.i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + com_tencent_mm_protocal_c_acd.mDi + ", req = " + stringBuilder.toString());
        com_tencent_mm_protocal_c_acd.mDk = new are().ba(stringBuilder.toString().getBytes());
    }

    public final void c(int i, int i2, String str, com.tencent.mm.network.p pVar) {
        v.i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + axL() + ", errType = " + i + ", errCode = " + i2 + ", errMsg = " + str);
        ace com_tencent_mm_protocal_c_ace = (ace) ((b) pVar).czl.czs;
        if (i == 0 && i2 == 0) {
            int i3 = com_tencent_mm_protocal_c_ace.mDm;
            String b = m.b(com_tencent_mm_protocal_c_ace.mDl);
            if (i3 != 0 || be.kS(b)) {
                str = com_tencent_mm_protocal_c_ace.mDn;
                i2 = 2;
                i = BaseReportManager.MAX_READ_COUNT;
            } else {
                i3 = com_tencent_mm_protocal_c_ace.aZk;
                try {
                    JSONObject jSONObject = new JSONObject(b);
                    int i4 = jSONObject.getInt("retcode");
                    b = com_tencent_mm_protocal_c_ace.errorMsg;
                    if (be.kS(b)) {
                        b = jSONObject.optString("retmsg");
                    }
                    if (axN() || (i4 == 0 && i3 == 0)) {
                        a(i4, b, jSONObject);
                    } else {
                        int i5;
                        if (i3 == 0) {
                            i5 = -1000;
                        } else {
                            i5 = i3;
                        }
                        str = b;
                        i2 = i5;
                        i = BaseReportManager.MAX_READ_COUNT;
                    }
                } catch (Throwable e) {
                    v.a("MicroMsg.NetSceneLuckyMoneyBase", e, "", new Object[0]);
                    str = aa.getContext().getString(2131236155);
                    i2 = 2;
                    i = BaseReportManager.MAX_READ_COUNT;
                }
            }
        } else {
            Map q = bf.q(str, "e");
            if (q != null) {
                v.d("MicroMsg.NetSceneLuckyMoneyBase", "CDN error!");
                str = (String) q.get(".e.Content");
            } else {
                str = aa.getContext().getString(2131236155);
            }
        }
        if (i != 0) {
            v.e("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + axL() + ", errType = " + i + ", errCode = " + i2 + ", errMsg = " + str);
        }
        this.cii.a(i, i2, str, this);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public int axL() {
        return -1;
    }

    public final int axM() {
        return axL();
    }

    public boolean axN() {
        return false;
    }
}
