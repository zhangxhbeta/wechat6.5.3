package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.mm.compatible.d.p;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t.a;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends g {
    public int kJX;
    public String kJY;
    public int kJZ;
    public String kKa;
    public String kKb;

    public b() {
        Map hashMap = new HashMap();
        hashMap.put("deviceid", p.getDeviceID(aa.getContext()));
        u(hashMap);
    }

    public final int aed() {
        return 0;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.i("MicroMsg.NetSceneTenpayPayManager", "errCode:" + i + ";errMsg:" + str);
        v.d("MicroMsg.NetSceneTenpayPayManager", "json: %s", new Object[]{jSONObject.toString()});
        if (i == 0) {
            String optString = jSONObject.optString("is_show_deduct", "0");
            if (!qw(optString)) {
                optString = "0";
            }
            this.kJX = Integer.valueOf(optString).intValue();
            this.kJY = jSONObject.optString("deduct_show_url", "");
            optString = jSONObject.optString("deduct_cache_time", "");
            if (!qw(optString)) {
                optString = "84600";
            }
            this.kJZ = Integer.valueOf(optString).intValue();
            this.kKa = jSONObject.optString("deduct_title", "");
            this.kKb = jSONObject.optString("realname_url", "");
            optString = jSONObject.optString("payway_select_wording", "");
            String optString2 = jSONObject.optString("payway_change_wording", "");
            u uVar = new u();
            uVar.field_is_show = this.kJX;
            uVar.field_pref_key = "wallet_open_auto_pay";
            uVar.field_pref_title = this.kKa;
            uVar.field_pref_url = this.kJY;
            com.tencent.mm.plugin.wallet_core.c.g bfZ = k.bfZ();
            String str2 = "wallet_open_auto_pay";
            if (!be.kS(str2)) {
                bfZ.cie.dF("WalletPrefInfo", "delete from WalletPrefInfo where pref_key='" + str2 + "'");
            }
            v.i("MicroMsg.NetSceneTenpayPayManager", "deductCacheTime %s", new Object[]{Integer.valueOf(this.kJZ)});
            k.bfZ().b(uVar);
            ak.yW();
            c.vf().a(a.nsy, Long.valueOf(new Date().getTime() / 1000));
            ak.yW();
            c.vf().a(a.nsz, Integer.valueOf(this.kJZ));
            ak.yW();
            c.vf().a(a.nsF, this.kKb);
            if (!be.kS(optString)) {
                ak.yW();
                c.vf().a(a.nsM, optString);
            }
            if (!be.kS(optString2)) {
                ak.yW();
                c.vf().a(a.nsN, optString2);
            }
            ak.yW();
            c.vf().iB(true);
            com.tencent.mm.wallet_core.b.p.bLj().J(jSONObject);
        }
    }

    public static boolean aZc() {
        ak.yW();
        long longValue = ((Long) c.vf().get(a.nsy, Long.valueOf(0))).longValue();
        ak.yW();
        v.i("MicroMsg.NetSceneTenpayPayManager", "check isExpire %s %s %s", new Object[]{Long.valueOf(longValue), Integer.valueOf(r0), Long.valueOf(((long) ((Integer) c.vf().get(a.nsz, Integer.valueOf(0))).intValue()) + longValue)});
        if (longValue <= 0) {
            return true;
        }
        if (Long.valueOf(new Date().getTime() / 1000).longValue() > longValue + ((long) r0)) {
            return true;
        }
        return false;
    }

    private static boolean qw(String str) {
        if (be.kS(str)) {
            return false;
        }
        int length = str.length();
        char charAt;
        do {
            length--;
            if (length < 0) {
                return true;
            }
            charAt = str.charAt(length);
            if (charAt < '0') {
                return false;
            }
        } while (charAt <= '9');
        return false;
    }

    public final int zg() {
        return 1654;
    }

    public final int bfq() {
        return 100000;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/paymanage";
    }
}
