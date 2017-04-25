package com.tencent.mm.wallet_core.b;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t.a;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public final class p {
    private static p piN;
    public String TAG = "MicroMsg.WalletDigCertManager";
    private int piL = 0;
    public Vector<o> piM = new Vector();

    public static void PO(String str) {
        ak.yW();
        c.vf().a(a.nto, str);
    }

    public static String bLi() {
        ak.yW();
        return (String) c.vf().get(a.nto, "");
    }

    public static p bLj() {
        if (piN == null) {
            piN = new p();
        }
        return piN;
    }

    public final boolean bLk() {
        if (be.kS(bLi()) || this.piL <= 0) {
            return false;
        }
        return true;
    }

    public final void J(JSONObject jSONObject) {
        this.piM = new Vector();
        int optInt = jSONObject.optInt("show_crt_info");
        this.piL = jSONObject.optInt("is_crt_install");
        ak.yW();
        c.vf().a(a.ntp, Integer.valueOf(optInt));
        String bLi = bLi();
        JSONArray optJSONArray = jSONObject.optJSONArray("crt_list");
        if (optJSONArray != null) {
            for (optInt = 0; optInt < optJSONArray.length(); optInt++) {
                try {
                    o oVar = new o(optJSONArray.getJSONObject(optInt));
                    if (oVar.piK == 0) {
                        this.piM.add(oVar);
                    } else if (be.kS(bLi)) {
                        v.i(this.TAG, "drop crt list no exist local drop: %s", new Object[]{oVar.mWk});
                    } else if (oVar.mWk.equals(bLi)) {
                        this.piM.add(oVar);
                    } else {
                        v.i(this.TAG, "drop crt list %s drop: %s", new Object[]{bLi, oVar.mWk});
                    }
                } catch (Exception e) {
                    v.i(this.TAG, "WalletDigCertManager error %s", new Object[]{e.getMessage()});
                }
            }
        }
    }

    public final void PP(String str) {
        if (!be.kS(str)) {
            if (str.equals(bLi())) {
                this.piL = 0;
                PO("");
                v.i(this.TAG, "clean token %s  stack %s ", new Object[]{str, be.bur().toString()});
                a.bKZ();
                a.clearCert(str);
            }
            Iterator it = this.piM.iterator();
            if (it.hasNext()) {
                this.piM.remove((o) it.next());
            }
        }
    }
}
