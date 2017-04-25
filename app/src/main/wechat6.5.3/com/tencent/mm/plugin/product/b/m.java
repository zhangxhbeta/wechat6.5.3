package com.tencent.mm.plugin.product.b;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.product.c.a;
import com.tencent.mm.plugin.product.c.c;
import com.tencent.mm.plugin.product.c.e;
import com.tencent.mm.plugin.product.c.f;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.j;
import com.tencent.mm.plugin.product.c.k;
import com.tencent.mm.plugin.product.c.l;
import com.tencent.mm.plugin.product.c.n;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class m {
    public String hQC;
    public int hQD;
    public int hQE = Integer.MAX_VALUE;
    public int hQF = Integer.MAX_VALUE;
    public c hQG;
    public n hQH;
    public LinkedList<l> hQI = new LinkedList();
    public f hQJ;
    public String hQK;
    public String hQL;
    public String hQM;
    public int status = 6;

    public static m a(m mVar, String str) {
        m mVar2;
        if (mVar == null) {
            mVar2 = new m();
        } else {
            mVar2 = mVar;
        }
        try {
            int length;
            int i;
            int i2;
            JSONArray optJSONArray;
            JSONObject jSONObject = new JSONObject(str);
            mVar2.hQC = jSONObject.getString("product_id");
            mVar2.hQD = jSONObject.getInt("product_type");
            mVar2.hQE = jSONObject.optInt("quantity", Integer.MAX_VALUE);
            mVar2.hQF = jSONObject.optInt("left_buy_quantity", Integer.MAX_VALUE);
            mVar2.status = jSONObject.optInt("status", 6);
            JSONObject optJSONObject = jSONObject.optJSONObject("ext_attr");
            if (optJSONObject != null) {
                mVar2.hQJ = new f();
                optJSONObject = optJSONObject.optJSONObject("product_ext");
                if (optJSONObject != null) {
                    f fVar = mVar2.hQJ;
                    j jVar = new j();
                    jVar.bkU = optJSONObject.getInt("flag");
                    fVar.hRg = jVar;
                } else {
                    mVar2.hQJ.hRh = jSONObject.optString("ext_attr");
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("base_attr");
            if (optJSONObject2 != null) {
                JSONObject jSONObject2;
                mVar2.hQG = new c();
                mVar2.hQG.name = optJSONObject2.getString("name");
                mVar2.hQG.hQS = optJSONObject2.getInt("ori_price");
                mVar2.hQG.hQT = optJSONObject2.getInt("up_price");
                mVar2.hQG.hQU = optJSONObject2.getInt("low_price");
                mVar2.hQG.hQV = new LinkedList();
                JSONArray jSONArray = optJSONObject2.getJSONArray("img_info");
                length = jSONArray.length();
                for (i = 0; i < length; i++) {
                    String string = jSONArray.getString(i);
                    if (!be.kS(string)) {
                        mVar2.hQG.hQV.add(string);
                    }
                }
                mVar2.hQG.cqK = optJSONObject2.getString("digest");
                mVar2.hQG.hNg = optJSONObject2.getString("fee_type");
                mVar2.hQG.hQW = optJSONObject2.getString("detail");
                optJSONObject = optJSONObject2.optJSONObject("share_info");
                if (optJSONObject != null) {
                    mVar2.hQG.hRe = new k();
                    mVar2.hQG.hRe.eBZ = optJSONObject.optString("icon_url");
                    mVar2.hQG.hRe.url = optJSONObject.optString("url");
                }
                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("sku_table");
                if (optJSONArray2 != null) {
                    mVar2.hQG.hRc = new LinkedList();
                    int length2 = optJSONArray2.length();
                    for (i = 0; i < length2; i++) {
                        jSONObject2 = optJSONArray2.getJSONObject(i);
                        com.tencent.mm.plugin.product.c.m mVar3 = new com.tencent.mm.plugin.product.c.m();
                        mVar3.hRo = jSONObject2.getString(SlookAirButtonFrequentContactAdapter.ID);
                        mVar3.hRp = jSONObject2.getString("name");
                        mVar3.hRq = new LinkedList();
                        JSONArray jSONArray2 = jSONObject2.getJSONArray("value_list");
                        int length3 = jSONArray2.length();
                        for (i2 = 0; i2 < length3; i2++) {
                            JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                            h hVar = new h();
                            hVar.id = jSONObject3.getString(SlookAirButtonFrequentContactAdapter.ID);
                            hVar.name = jSONObject3.getString("name");
                            hVar.hRi = true;
                            mVar3.hRq.add(hVar);
                        }
                        mVar2.hQG.hRc.add(mVar3);
                    }
                }
                optJSONArray = optJSONObject2.optJSONArray("actiongroup_attr");
                if (optJSONArray != null) {
                    mVar2.hQG.hRd = new LinkedList();
                    length = optJSONArray.length();
                    for (i = 0; i < length; i++) {
                        jSONObject2 = optJSONArray.getJSONObject(i);
                        a aVar = new a();
                        aVar.gkB = jSONObject2.getString("name");
                        aVar.efm = 0;
                        if (!be.kS(aVar.gkB)) {
                            mVar2.hQG.hRd.add(aVar);
                        }
                        JSONArray jSONArray3 = jSONObject2.getJSONArray("action_list");
                        int length4 = jSONArray3.length();
                        for (i2 = 0; i2 < length4; i2++) {
                            JSONObject jSONObject4 = jSONArray3.getJSONObject(i2);
                            a aVar2 = new a();
                            aVar2.gkB = jSONObject4.getString("name");
                            aVar2.hQO = jSONObject4.getString("tips");
                            aVar2.efm = jSONObject4.getInt("type");
                            aVar2.hQP = jSONObject4.getString("content");
                            aVar2.gnp = jSONObject4.getString("icon_url");
                            mVar2.hQG.hRd.add(aVar2);
                        }
                    }
                }
            }
            optJSONArray = jSONObject.optJSONArray("available_sku_list");
            if (optJSONArray != null) {
                length = optJSONArray.length();
                mVar2.hQI = new LinkedList();
                for (i2 = 0; i2 < length; i2++) {
                    optJSONObject = optJSONArray.getJSONObject(i2);
                    l lVar = new l();
                    lVar.hRl = optJSONObject.getString("id_info");
                    lVar.hRm = optJSONObject.getInt("price");
                    lVar.hQE = optJSONObject.getInt("quantity");
                    lVar.url = optJSONObject.getString("icon_url");
                    JSONArray jSONArray4 = optJSONObject.getJSONArray("express_fee");
                    int length5 = jSONArray4.length();
                    lVar.hRn = new LinkedList();
                    for (i = 0; i < length5; i++) {
                        JSONObject jSONObject5 = jSONArray4.getJSONObject(i);
                        e eVar = new e();
                        eVar.id = jSONObject5.getInt(SlookAirButtonFrequentContactAdapter.ID);
                        eVar.name = jSONObject5.getString("name");
                        eVar.value = jSONObject5.getInt("price");
                        lVar.hRn.add(eVar);
                    }
                    mVar2.hQI.add(lVar);
                }
            }
            optJSONObject = jSONObject.optJSONObject("seller_attr");
            if (optJSONObject != null) {
                mVar2.hQH = new n();
                mVar2.hQH.bmJ = optJSONObject.getString("appid");
                mVar2.hQH.name = optJSONObject.getString("name");
                mVar2.hQH.username = optJSONObject.getString("username");
                mVar2.hQH.hRr = optJSONObject.optString("logo");
                mVar2.hQH.bkU = optJSONObject.optInt("flag", 0);
            }
            optJSONObject = jSONObject.optJSONObject("oss_info");
            if (optJSONObject != null) {
                mVar2.hQL = optJSONObject.optString("self_buy_button_word");
                mVar2.hQM = optJSONObject.optString("product_mixed_h5_html");
            }
        } catch (Throwable e) {
            v.a("MicroMsg.ProductInfo", e, "", new Object[0]);
        }
        return mVar2;
    }

    public static m b(m mVar, String str) {
        int i = 0;
        if (mVar == null) {
            mVar = new m();
        }
        Map q = bf.q(str, "mallProductInfo");
        if (q == null) {
            return null;
        }
        mVar.hQC = be.ma((String) q.get(".mallProductInfo.id"));
        mVar.hQD = be.getInt((String) q.get(".mallProductInfo.type"), 0);
        mVar.hQG = new c();
        mVar.hQG.name = be.ma((String) q.get(".mallProductInfo.name"));
        mVar.hQG.cqK = be.ma((String) q.get(".mallProductInfo.digest"));
        mVar.hQG.hQT = be.getInt((String) q.get(".mallProductInfo.highPrice"), 0);
        mVar.hQG.hQU = be.getInt((String) q.get(".mallProductInfo.lowPrice"), 0);
        mVar.hQG.hQS = be.getInt((String) q.get(".mallProductInfo.originPrice"), 0);
        mVar.hQK = be.ma((String) q.get(".mallProductInfo.sourceUrl"));
        int i2 = be.getInt((String) q.get(".mallProductInfo.imgCount"), 0);
        if (i2 > 0) {
            mVar.hQG.hQV = new LinkedList();
            while (i < i2) {
                String ma;
                if (i == 0) {
                    ma = be.ma((String) q.get(".mallProductInfo.imgList.imgUrl"));
                } else {
                    ma = be.ma((String) q.get(".mallProductInfo.imgList.imgUrl" + i));
                }
                if (!be.kS(ma)) {
                    mVar.hQG.hQV.add(ma);
                }
                i++;
            }
        }
        mVar.hQG.hRe = new k();
        mVar.hQG.hRe.url = be.ma((String) q.get(".mallProductInfo.shareInfo.shareUrl"));
        mVar.hQG.hRe.eBZ = be.ma((String) q.get(".mallProductInfo.shareInfo.shareThumbUrl"));
        mVar.hQH = new n();
        mVar.hQH.bmJ = be.ma((String) q.get(".mallProductInfo.sellerInfo.appID"));
        mVar.hQH.name = be.ma((String) q.get(".mallProductInfo.sellerInfo.appName"));
        mVar.hQH.username = be.ma((String) q.get(".mallProductInfo.sellerInfo.usrName"));
        return mVar;
    }

    public final String aGs() {
        if (this.hQG != null && this.hQG.hRe != null && !be.kS(this.hQG.hRe.eBZ)) {
            return this.hQG.hRe.eBZ;
        }
        if (this.hQG == null || this.hQG.hQV == null || this.hQG.hQV.size() <= 0) {
            return null;
        }
        return (String) this.hQG.hQV.get(0);
    }
}
