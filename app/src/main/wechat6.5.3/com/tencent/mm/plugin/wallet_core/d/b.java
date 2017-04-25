package com.tencent.mm.plugin.wallet_core.d;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t.a;
import org.json.JSONObject;

public final class b {
    public static void F(JSONObject jSONObject) {
        if (jSONObject == null) {
            v.e("MicroMsg.WalletNetSceneUtil", "parseLuckyMoneySnsPayData() json is null");
            return;
        }
        v.i("MicroMsg.WalletNetSceneUtil", "parseLuckyMoneySnsPayData()");
        String str = "";
        String str2 = "";
        String str3 = "";
        String str4 = "";
        int optInt = jSONObject.optInt("is_open_sns_pay", 0);
        int optInt2 = jSONObject.optInt("can_open_sns_pay", 0);
        int optInt3 = jSONObject.optInt("is_white_user", 0);
        if (optInt2 == 1) {
            str = jSONObject.optString("open_sns_pay_title");
            str2 = jSONObject.optString("open_sns_pay_wording");
            ak.yW();
            c.vf().a(a.nsj, str);
            ak.yW();
            c.vf().a(a.nsk, str2);
        }
        v.i("MicroMsg.WalletNetSceneUtil", "is_open_sns_pay:" + optInt + ", can_open_sns_pay:" + optInt2 + ", is_white_user:" + optInt3);
        v.i("MicroMsg.WalletNetSceneUtil", "open_sns_pay_title:" + str + ", open_sns_pay_wording:" + str2);
        ak.yW();
        c.vf().a(a.nsg, Integer.valueOf(optInt));
        ak.yW();
        c.vf().a(a.nsh, Integer.valueOf(optInt2));
        ak.yW();
        c.vf().a(a.nsi, Integer.valueOf(optInt3));
        if (optInt3 == 1) {
            str = jSONObject.optString("set_sns_pay_title");
            str2 = jSONObject.optString("set_sns_pay_wording");
            ak.yW();
            c.vf().a(a.nsl, str);
            ak.yW();
            c.vf().a(a.nsm, str2);
        } else {
            str2 = str4;
            str = str3;
        }
        v.i("MicroMsg.WalletNetSceneUtil", "set_sns_pay_title:" + str + ", set_sns_pay_wording:" + str2);
        ak.yW();
        c.vf().iB(true);
    }
}
