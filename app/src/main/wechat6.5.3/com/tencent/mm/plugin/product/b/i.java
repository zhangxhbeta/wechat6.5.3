package com.tencent.mm.plugin.product.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.c.ng;
import com.tencent.mm.protocal.c.yd;
import com.tencent.mm.protocal.c.ye;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i extends k implements j {
    private b cif;
    private e cii;
    public LinkedList<ng> hQA;
    public String mUrl;

    public i(String str, String str2) {
        a aVar = new a();
        aVar.czn = new yd();
        aVar.czo = new ye();
        aVar.uri = "/cgi-bin/micromsg-bin/getproductdiscount";
        aVar.czm = 579;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        yd ydVar = (yd) this.cif.czk.czs;
        ydVar.mjX = str;
        this.mUrl = str2;
        ydVar.glb = str2;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        ye yeVar = (ye) ((b) pVar).czl.czs;
        if (i2 == 0 && i3 == 0 && yeVar.mjY == 0) {
            v.d("MicroMsg.NetSceneMallGetProductDiscount", "resp.ProductInfo " + yeVar.mAc);
            try {
                JSONArray optJSONArray = new JSONObject(yeVar.mAc).optJSONArray("discount_list");
                if (optJSONArray != null) {
                    this.hQA = new LinkedList();
                    int length = optJSONArray.length();
                    for (int i4 = 0; i4 < length; i4++) {
                        JSONObject jSONObject = optJSONArray.getJSONObject(i4);
                        ng ngVar = new ng();
                        ngVar.aXz = jSONObject.getString(FFmpegMetadataRetriever.METADATA_KEY_TITLE);
                        ngVar.mjf = jSONObject.getInt("fee");
                        this.hQA.add(ngVar);
                    }
                }
            } catch (Exception e) {
            }
        }
        if (i3 == 0 && yeVar.mjY != 0) {
            i3 = yeVar.mjY;
            str = yeVar.mjZ;
        }
        v.d("MicroMsg.NetSceneMallGetProductDiscount", "errCode " + i3 + ", errMsg " + str);
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 579;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
