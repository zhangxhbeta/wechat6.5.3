package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.xi;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.wallet_core.b.k;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a extends k {
    private final b cif;
    private e cii;
    private ArrayList<String> hKm;
    private String hKn;
    private String hKo;

    public final int getType() {
        return 606;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void c(int i, int i2, String str, p pVar) {
        if (i != 0) {
            v.e("MicroMsg.NetSceneGetOffLineInfo", "Cmd : 606" + ", errType = " + i + ", errCode = " + i2 + ", errMsg = " + str);
        }
        xi xiVar = (xi) ((b) pVar).czl.czs;
        if (i == 0 && i2 == 0) {
            try {
                if (!TextUtils.isEmpty(xiVar.mzD)) {
                    JSONObject jSONObject = new JSONObject(xiVar.mzD);
                    int optInt = jSONObject.optInt("InitValue");
                    int optInt2 = jSONObject.optInt("FastChangedLimit");
                    this.hKo = jSONObject.optString("guide_tips");
                    com.tencent.mm.plugin.offline.b.a.nR(optInt);
                    com.tencent.mm.plugin.offline.b.a.nS(optInt2);
                    v.v("MicroMsg.NetSceneGetOffLineInfo", "initValue:" + optInt + " fastChangeValue:" + optInt2);
                }
                if (!TextUtils.isEmpty(xiVar.mzE)) {
                    s(new JSONObject(xiVar.mzE));
                }
            } catch (Throwable e) {
                v.a("MicroMsg.NetSceneGetOffLineInfo", e, "", new Object[0]);
                i = 1000;
                i2 = 2;
                str = aa.getContext().getString(2131236155);
            }
        }
        if (this.cii != null) {
            this.cii.a(i, i2, str, this);
        }
    }

    private void s(JSONObject jSONObject) {
        this.hKn = jSONObject.optString("micropay_tips");
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("head_url_list");
            if (jSONArray != null && jSONArray.length() != 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.hKm.add((String) jSONArray.get(i));
                }
            }
        } catch (Throwable e) {
            v.a("MicroMsg.NetSceneGetOffLineInfo", e, "", new Object[0]);
        }
    }
}
