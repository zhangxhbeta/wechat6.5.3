package com.tencent.mm.pluginsdk.wallet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ay.c;
import com.tencent.mm.e.a.gg;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class e {
    public static boolean a(Context context, Bundle bundle, boolean z) {
        Intent intent = new Intent();
        intent.putExtra("orderhandlerui_checkapp_result", z);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        c.b(context, "wallet_index", ".ui.OrderHandlerUI", intent);
        return true;
    }

    public static boolean a(MMActivity mMActivity, d dVar, int i, a aVar) {
        Intent intent = new Intent();
        intent.putExtra("appId", dVar.appId);
        intent.putExtra("timeStamp", dVar.bkm);
        intent.putExtra("nonceStr", dVar.bkl);
        intent.putExtra("packageExt", dVar.bkn);
        intent.putExtra("signtype", dVar.bkk);
        intent.putExtra("paySignature", dVar.bko);
        intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, dVar.url);
        intent.putExtra("bizUsername", dVar.bkp);
        intent.putExtra("pay_channel", dVar.bks);
        intent.putExtra("pay_for_wallet_type", dVar.lVM);
        mMActivity.nDS = aVar;
        c.a(mMActivity, "wallet_index", ".ui.WalletBrandUI", intent, i, false);
        return true;
    }

    public static void dq(Context context) {
        b ggVar = new gg();
        com.tencent.mm.sdk.c.a.nhr.z(ggVar);
        Intent intent = new Intent();
        intent.putExtra("ftf_receiver_true_name", be.ah(ggVar.bfK.bfL, SQLiteDatabase.KeyEmpty));
        intent.putExtra("ftf_pay_url", be.ah(ggVar.bfK.bfM, SQLiteDatabase.KeyEmpty));
        intent.putExtra("ftf_can_set_amount", !k.xT());
        c.b(context, "collect", ".ui.CollectMainUI", intent);
    }

    public static boolean a(Context context, String str, String str2, int i, int i2) {
        return be.kS(str) ? false : a(context, a(str, str2, null, null, i, 0), i2);
    }

    public static PayInfo a(String str, String str2, String str3, String str4, int i, int i2) {
        PayInfo payInfo = new PayInfo();
        payInfo.fTG = str;
        payInfo.appId = str2;
        payInfo.kXn = null;
        payInfo.bkq = i;
        payInfo.biS = null;
        payInfo.bkh = 0;
        return payInfo;
    }

    public static boolean a(Context context, PayInfo payInfo, int i) {
        return a(context, false, SQLiteDatabase.KeyEmpty, payInfo, i);
    }

    public static boolean a(Context context, boolean z, String str, PayInfo payInfo, int i) {
        return a(context, z, str, payInfo, null, new Intent(), i);
    }

    public static boolean a(Context context, boolean z, String str, PayInfo payInfo, String str2, Intent intent, int i) {
        if (2 == payInfo.bkq || 1 == payInfo.bkq || 4 == payInfo.bkq || 36 == payInfo.bkq) {
            payInfo.lVz = false;
        } else {
            payInfo.lVz = true;
        }
        if (payInfo.bkq == 4 || payInfo.bkq == 1 || 36 == payInfo.bkq) {
            payInfo.lVA = true;
        } else {
            payInfo.lVA = false;
        }
        intent.putExtra("key_pay_info", payInfo);
        intent.putExtra("key_force_use_bind_serail", be.ma(str));
        intent.putExtra("key_is_force_use_given_card", z);
        intent.putExtra("key_receiver_true_name", str2);
        if (k.xT()) {
            c.b(context, "wallet_payu", ".pay.ui.WalletPayUPayUI", intent, i);
        } else {
            c.b(context, "wallet", ".pay.ui.WalletPayUI", intent, i);
        }
        return true;
    }

    public static boolean b(MMActivity mMActivity, d dVar, int i, a aVar) {
        Intent intent = new Intent();
        intent.putExtra("appId", dVar.appId);
        intent.putExtra("timeStamp", dVar.bkm);
        intent.putExtra("nonceStr", dVar.bkl);
        intent.putExtra("packageExt", dVar.bkn);
        intent.putExtra("signtype", dVar.bkk);
        intent.putExtra("paySignature", dVar.bko);
        intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, dVar.url);
        intent.putExtra("key_bind_scene", dVar.bkr);
        mMActivity.nDS = aVar;
        c.a(mMActivity, "wallet", ".bind.ui.WalletBindUI", intent, i, false);
        return true;
    }

    public static boolean K(Context context, int i) {
        Intent intent = new Intent();
        intent.putExtra("key_bind_scene", 5);
        intent.putExtra("key_offline_add_fee", i);
        c.b(context, "wallet", ".bind.ui.WalletBindUI", intent);
        return true;
    }

    public static boolean L(Context context, int i) {
        Intent intent = new Intent();
        intent.putExtra("key_scene_balance_manager", i);
        if (k.xT()) {
            c.b(context, "wallet_payu", ".balance.ui.WalletPayUBalanceManagerUI", intent);
        } else {
            c.b(context, "wallet", ".balance.ui.WalletBalanceManagerUI", intent);
        }
        return true;
    }

    public static boolean a(Context context, int i, String str, int i2, com.tencent.mm.plugin.wallet.a aVar) {
        Intent intent = new Intent();
        intent.putExtra("scene", i);
        intent.putExtra("receiver_name", str);
        if (i2 > 0) {
            intent.putExtra("pay_channel", i2);
        }
        com.tencent.mm.plugin.wallet.a.a(aVar, intent);
        if (k.xT()) {
            c.b(context, "wallet_payu", ".remittance.ui.PayURemittanceAdapterUI", intent);
        } else if (k.xU()) {
            c.b(context, "remittance", ".ui.RemittanceAdapterUI", intent);
            g.iuh.h(12097, Integer.valueOf(12), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()));
            g.iuh.h(11850, Integer.valueOf(7), Integer.valueOf(1));
        } else {
            c.b(context, "remittance", ".ui.RemittanceAdapterUI", intent);
            g.iuh.h(12097, Integer.valueOf(12), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()));
            g.iuh.h(11850, Integer.valueOf(3), Integer.valueOf(1));
        }
        return true;
    }
}
