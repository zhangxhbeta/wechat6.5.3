package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.fingerprint.a;
import com.tencent.mm.pluginsdk.l.a.c;
import com.tencent.mm.pluginsdk.l.e;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d extends g implements j {
    public d() {
        Map hashMap = new HashMap();
        c bol = e.bol();
        String str = bol.bgr;
        String str2 = bol.bgs;
        hashMap.put("cpu_id", str);
        hashMap.put("uid", str2);
        u(hashMap);
    }

    public final int aed() {
        return 116;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (i == 0) {
            int optInt;
            if (jSONObject != null) {
                optInt = jSONObject.optInt("clear_rsa_key_level", 0);
            } else {
                optInt = 0;
            }
            a.ank();
            a.anl();
            new Object[1][0] = Integer.valueOf(optInt);
            com.tencent.mm.pluginsdk.j.a.lxX.anA();
            return;
        }
        v.e("MicroMsg.NetSceneTenpayCloseTouchPay", "do close fingerprint cgi failed!");
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        super.a(i, i2, i3, str, pVar, bArr);
        com.tencent.mm.plugin.report.service.g.iuh.h(13686, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            com.tencent.mm.plugin.fingerprint.a.e.dd(false);
            v.e("MicroMsg.NetSceneTenpayCloseTouchPay", "hy: do close fingerprint cgi success!");
            return;
        }
        v.e("MicroMsg.NetSceneTenpayCloseTouchPay", "hy: do close fingerprint cgi failed!");
    }

    public final int zg() {
        return 1597;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/closetouchpay";
    }
}
