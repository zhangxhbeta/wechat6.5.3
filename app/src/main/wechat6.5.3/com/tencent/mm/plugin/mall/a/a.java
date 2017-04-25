package com.tencent.mm.plugin.mall.a;

import android.util.SparseArray;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.xr;
import com.tencent.mm.protocal.c.xs;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a extends k implements j {
    private b cif;
    private e cii;
    private String hic;
    public ArrayList<MallFunction> hid;
    public ArrayList<MallNews> hie;
    public ArrayList<com.tencent.mm.plugin.wallet_core.model.mall.a> hif;
    public SparseArray<String> hig;
    public int hih;

    public a(int i, String str) {
        this(i, str, null, null);
    }

    public a(int i, String str, String str2, String str3, String str4) {
        this(i, str, str3, String.format("appid=%s&funcid=%s&url=%s", new Object[]{str2, str3, URLEncoder.encode(str4, "ISO-8859-1").toString()}));
    }

    private a(int i, String str, String str2, String str3) {
        this.hid = null;
        this.hie = null;
        this.hif = null;
        this.hig = null;
        this.hih = 0;
        this.hih = i;
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new xr();
        aVar.czo = new xs();
        aVar.uri = "/cgi-bin/micromsg-bin/getpayfunctionlist";
        aVar.czm = 495;
        aVar.czp = 227;
        aVar.czq = 1000000227;
        this.cif = aVar.Bv();
        xr xrVar = (xr) this.cif.czk.czs;
        xrVar.mzQ = str;
        LinkedList linkedList = new LinkedList();
        List bgM;
        if (be.kS(str2)) {
            bgM = c.bgL().bgM();
        } else {
            List list;
            MallNews mallNews = (MallNews) c.bgL().kRx.get(str2);
            if (mallNews == null || be.kS(mallNews.bax)) {
                list = null;
            } else {
                bgM = new ArrayList();
                bgM.add(mallNews.bax);
                list = bgM;
            }
            bgM = list;
        }
        if (r2 != null && r2.size() > 0) {
            String str4 = "";
            for (String str5 : r2) {
                arf com_tencent_mm_protocal_c_arf = new arf();
                com_tencent_mm_protocal_c_arf.JF(str5);
                linkedList.add(com_tencent_mm_protocal_c_arf);
                str4 = str4 + "; + " + str5;
            }
            v.d("MicroMsg.NetSceneGetPayFunctionList", "post with list : " + str4);
        }
        xrVar.mzS = linkedList;
        xrVar.mzR = linkedList.size();
        if (be.kS(str3)) {
            xrVar.gor = String.format("tpa_country=%s", new Object[]{Integer.valueOf(i)});
        } else {
            xrVar.gor = String.format("%s&tpa_country=%s", new Object[]{str3, Integer.valueOf(i)});
        }
        this.hic = str2;
        v.d("MicroMsg.NetSceneGetPayFunctionList", "telephonyNetIso " + str + " ExtInfo: " + xrVar.gor);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneGetPayFunctionList", "errCode " + i3 + ", errMsg " + str);
        if (i2 == 0 && i3 == 0) {
            xs xsVar = (xs) ((b) pVar).czl.czs;
            v.i("MicroMsg.NetSceneGetPayFunctionList", "resp.PayFunctionList wallet_regionL " + this.hih + " " + xsVar.mzT);
            try {
                if (!be.kS(xsVar.mzT)) {
                    JSONObject jSONObject = new JSONObject(xsVar.mzT);
                    String optString = jSONObject.optString("pay_func_list");
                    this.hid = com.tencent.mm.plugin.wallet_core.model.mall.b.u(new JSONArray(optString));
                    com.tencent.mm.plugin.wallet_core.model.k.bgf().c(this.hih, optString, jSONObject.optString("global_activity_list"), jSONObject.optString("pay_banner_list"), jSONObject.optString("type_info_list"));
                    c.ayF().hii.clear();
                }
            } catch (Throwable e) {
                v.a("MicroMsg.NetSceneGetPayFunctionList", e, "", new Object[0]);
            }
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 495;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
