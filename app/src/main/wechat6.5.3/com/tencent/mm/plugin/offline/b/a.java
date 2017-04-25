package com.tencent.mm.plugin.offline.b;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ay;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.offline.d;
import com.tencent.mm.plugin.offline.g;
import com.tencent.mm.plugin.offline.i;
import com.tencent.mm.plugin.offline.j;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
    public static String eAS = "";
    private static String hMe = "";
    public static String hMf = "";
    public static int hMg = 1;
    public static String hMh = "";
    public static String hMi = "";
    public static String hMj = "";
    public static int hMk = 1;
    public static int hMl = 0;
    public static long hMm = 0;
    public static boolean hMn = false;
    public static String hMo = "";
    public static String hMp = "";
    private static Comparator<Bankcard> hMq = new Comparator<Bankcard>() {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return ((Bankcard) obj).field_bindSerial.compareToIgnoreCase(((Bankcard) obj2).field_bindSerial);
        }
    };
    private static Comparator<a> hMr = new Comparator<a>() {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return ((a) obj).hMu.compareToIgnoreCase(((a) obj2).hMu);
        }
    };

    public static class a {
        public int hMs;
        public String hMt;
        public String hMu;
    }

    public static class b {
        public String eBZ;
        public String hMt;
    }

    public static boolean aFk() {
        j.aEM();
        String nO = j.nO(196630);
        if (nO == null || !nO.equals("1")) {
            return false;
        }
        return true;
    }

    public static boolean aFl() {
        j.aEM();
        String nO = j.nO(196641);
        if (nO == null || !nO.equals("1")) {
            return false;
        }
        return true;
    }

    public static Bankcard aFm() {
        Bankcard bankcard;
        int i = 0;
        Object aFt = aFt();
        List hk = k.bga().hk(true);
        int i2 = 0;
        while (!TextUtils.isEmpty(aFt) && i2 < hk.size()) {
            bankcard = (Bankcard) hk.get(i2);
            if (bankcard != null && bankcard.field_support_micropay && aFt.equals(bankcard.field_bindSerial)) {
                return bankcard;
            }
            i2++;
        }
        xr("");
        bankcard = aFo();
        if (bankcard != null && bankcard.field_support_micropay) {
            return bankcard;
        }
        while (i < hk.size()) {
            bankcard = (Bankcard) hk.get(i);
            if (bankcard != null && bankcard.field_support_micropay && !bankcard.bfG()) {
                return bankcard;
            }
            i++;
        }
        bankcard = k.bga().kFU;
        return (bankcard == null || !bankcard.field_support_micropay) ? null : bankcard;
    }

    public static Bankcard aFn() {
        Bankcard aFm = aFm();
        if (aFm != null && aFm.field_support_micropay) {
            return aFm;
        }
        List hk = k.bga().hk(true);
        for (int i = 0; i < hk.size(); i++) {
            aFm = (Bankcard) hk.get(i);
            if (aFm != null && aFm.field_support_micropay) {
                return aFm;
            }
        }
        return null;
    }

    public static Bankcard aFo() {
        Bankcard a = k.bga().a(null, null, true, true);
        if (a == null) {
            v.e("MicroMsg.WalletOfflineUtil", "defaultBankcards == null");
        }
        return a;
    }

    public static int aFp() {
        return k.bga().hk(true).size();
    }

    public static List<Bankcard> eJ(boolean z) {
        List<Bankcard> arrayList = new ArrayList();
        List hk = k.bga().hk(true);
        for (int i = 0; i < hk.size(); i++) {
            Bankcard bankcard = (Bankcard) hk.get(i);
            if (!z) {
                arrayList.add(bankcard);
            } else if (bankcard != null && bankcard.field_support_micropay) {
                arrayList.add(bankcard);
            }
        }
        v.i("MicroMsg.WalletOfflineUtil", "getBindBankCardList() list size is " + arrayList.size());
        return arrayList;
    }

    public static int aFq() {
        j.aEM();
        String nO = j.nO(196629);
        if (TextUtils.isEmpty(nO) || !qw(nO)) {
            return 0;
        }
        return Integer.valueOf(nO).intValue();
    }

    public static void nR(int i) {
        j.aEM();
        j.T(196640, String.valueOf(i));
    }

    public static void nS(int i) {
        j.aEM();
        j.T(196642, String.valueOf(i));
    }

    public static String aFr() {
        j.aEM();
        return j.nO(196632);
    }

    public static String aFs() {
        j.aEM();
        return j.nO(196631);
    }

    public static void xq(String str) {
        j.aEM();
        j.T(196631, str);
    }

    public static void cn(Context context) {
        ai(context, context.getResources().getString(2131235741) + "&lang=" + u.bsY());
    }

    private static void ai(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        c.b(context, "webview", ".ui.tools.WebViewUI", intent);
    }

    public static boolean qw(String str) {
        if (str == null) {
            return false;
        }
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public static String aFt() {
        j.aEM();
        return j.nO(196633);
    }

    public static void xr(String str) {
        j.aEM();
        j.T(196633, str);
    }

    public static void aFu() {
        j.aEM();
        j.T(196630, "0");
        j.aEM();
        j.T(196626, "");
        j.aEM();
        j.T(196627, "");
        j.aEM();
        j.T(196628, "");
        j.aEM();
        j.T(196617, "");
        j.aEM();
        j.T(196632, "");
        j.aEM();
        j.T(196641, "");
        j.aEM();
        j.T(196647, "");
        j.aEM();
        j.T(196649, "");
        h("", "", "", "");
        j.aEM();
        j.T(196629, new StringBuilder("0").toString());
        xq("");
        j.aEM();
        j.aEN().hKX = null;
        j.aEM();
        j.aEP();
        j.aEM();
        String nO = j.nO(196617);
        com.tencent.mm.wallet_core.b.a.bKZ();
        com.tencent.mm.wallet_core.b.a.clearToken(nO);
        xv("");
        xs("");
    }

    public static void a(Activity activity, Orders orders) {
        v.i("MicroMsg.WalletOfflineUtil", "hy: whole pay msg coming. direct parse");
        if (orders == null) {
            v.e("MicroMsg.WalletOfflineUtil", "order == null");
        } else if (aFl()) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_orders", orders);
            bundle.putInt("key_pay_type", 2);
            com.tencent.mm.wallet_core.a.a(activity, i.class, bundle);
        }
    }

    public static Orders w(Map<String, String> map) {
        String str;
        String str2;
        String str3;
        String str4;
        Orders orders = new Orders();
        Commodity commodity = new Commodity();
        commodity.hMS = (String) map.get(".sysmsg.paymsg.user_roll.buy_uin");
        commodity.hMT = (String) map.get(".sysmsg.paymsg.user_roll.buy_name");
        commodity.hMU = (String) map.get(".sysmsg.paymsg.user_roll.sale_uin");
        commodity.hMV = (String) map.get(".sysmsg.paymsg.user_roll.sale_name");
        commodity.eWA = (String) map.get(".sysmsg.paymsg.user_roll.trans_id");
        commodity.desc = (String) map.get(".sysmsg.paymsg.user_roll.goods_name");
        commodity.eWz = ((double) be.getInt((String) map.get(".sysmsg.paymsg.user_roll.pay_num"), -1)) / 100.0d;
        commodity.hMZ = (String) map.get(".sysmsg.paymsg.user_roll.trade_state");
        commodity.hNa = (String) map.get(".sysmsg.paymsg.user_roll.trade_state_name");
        commodity.hNe = (String) map.get(".sysmsg.paymsg.user_roll.buy_bank_name");
        commodity.hNl = (String) map.get(".sysmsg.paymsg.user_roll.discount");
        commodity.hNc = be.getInt((String) map.get(".sysmsg.paymsg.user_roll.modify_timestamp"), 0);
        commodity.hNg = (String) map.get(".sysmsg.paymsg.user_roll.fee_type");
        commodity.hNh = (String) map.get(".sysmsg.paymsg.user_roll.appusername");
        commodity.hMJ = (String) map.get(".sysmsg.paymsg.user_roll.app_telephone");
        commodity.kPw = ((double) be.getInt((String) map.get(".sysmsg.paymsg.user_roll.buy_bank_name"), -1)) / 100.0d;
        com.tencent.mm.plugin.wallet_core.model.Orders.b bVar = new com.tencent.mm.plugin.wallet_core.model.Orders.b();
        bVar.name = (String) map.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.nickname");
        bVar.hNh = (String) map.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.username");
        bVar.type = Orders.kPu;
        commodity.kPx = bVar.hNh;
        bVar.hRr = (String) map.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.logo_round_url");
        bVar.url = (String) map.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.subscribe_biz_url");
        int i = be.getInt((String) map.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.recommend_level"), 1);
        commodity.kPd = i;
        commodity.kPA = (String) map.get(".sysmsg.paymsg.user_roll.rateinfo");
        commodity.kPB = (String) map.get(".sysmsg.paymsg.user_roll.original_feeinfo");
        if (!be.kS(bVar.name)) {
            commodity.kPC.add(bVar);
        }
        for (int i2 = 0; i2 < 255; i2++) {
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            String str11;
            String str12;
            com.tencent.mm.plugin.wallet_core.model.Orders.b bVar2 = new com.tencent.mm.plugin.wallet_core.model.Orders.b();
            if (i2 == 0) {
                str = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.icon");
                str2 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.wording");
                str3 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.url");
                str4 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.btn_text");
                str5 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.type");
                str6 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.title");
                str7 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.activity_type");
                str8 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.activity_id");
                str9 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.send_record_id");
                str10 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.award_id");
                str11 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.user_record_id");
                str12 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.small_title");
            } else {
                str = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".icon");
                str2 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".wording");
                str3 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".url");
                str4 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".btn_text");
                str5 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".type");
                str6 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".title");
                str7 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".activity_type");
                str8 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".activity_id");
                str9 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".send_record_id");
                str10 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".award_id");
                str11 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".user_record_id");
                str12 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".small_title");
            }
            if (be.kS(str2)) {
                v.i("MicroMsg.WalletOfflineUtil", "hy: activity end. total size: %d", new Object[]{Integer.valueOf(i2 + 1)});
                break;
            }
            bVar2.hRr = str;
            bVar2.name = str2;
            bVar2.url = str3;
            bVar2.kPJ = str4;
            bVar2.type = Orders.kPv;
            bVar2.kPK = be.getInt(str5, 0);
            bVar2.title = str6;
            bVar2.kPM = be.getInt(str7, 0);
            bVar2.kPL = be.getLong(str8, 0);
            bVar2.kPO = be.getInt(str9, 0);
            bVar2.kPN = be.getInt(str10, 0);
            bVar2.kPP = be.getInt(str11, 0);
            bVar2.kPQ = str12;
            commodity.kPC.add(bVar2);
        }
        str = (String) map.get(".sysmsg.paymsg.user_roll.link_ativity_info.text");
        str2 = (String) map.get(".sysmsg.paymsg.user_roll.link_ativity_info.url");
        commodity.kPD.text = str;
        commodity.kPD.url = str2;
        orders.kPm = new ArrayList();
        orders.kPm.add(commodity);
        orders.kPf = (String) map.get(".sysmsg.paymsg.user_roll.trade_state_name");
        orders.kPd = i;
        commodity.kPw = be.getDouble((String) map.get(".sysmsg.paymsg.user_roll.original_total_fee"), -1.0d) / 100.0d;
        if (TextUtils.isEmpty((String) map.get(".sysmsg.paymsg.user_roll.discount_array.record.favor_desc"))) {
            v.e("MicroMsg.WalletOfflineUtil", ".sysmsg.paymsg.user_roll.discount_array.record.favor_desc value is empty");
        } else {
            int i3 = 0;
            while (true) {
                if (i3 == 0) {
                    str = "";
                } else {
                    str = String.valueOf(i3);
                }
                str3 = ".sysmsg.paymsg.user_roll.discount_array.record" + str + ".favor_desc";
                str4 = ".sysmsg.paymsg.user_roll.discount_array.record" + str + ".payment_amount";
                if (TextUtils.isEmpty((CharSequence) map.get(str3)) || TextUtils.isEmpty((CharSequence) map.get(str4))) {
                    v.e("MicroMsg.WalletOfflineUtil", "favor_desc_key is " + str3 + ", payment_amount_key is " + str4 + ", break");
                } else {
                    DiscountInfo discountInfo = new DiscountInfo();
                    discountInfo.kPI = (String) map.get(str3);
                    discountInfo.kPH = be.getDouble((String) map.get(str4), 0.0d);
                    commodity.kPz.add(discountInfo);
                    i3++;
                }
            }
            v.e("MicroMsg.WalletOfflineUtil", "favor_desc_key is " + str3 + ", payment_amount_key is " + str4 + ", break");
        }
        return orders;
    }

    public static void a(Activity activity, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.WalletOfflineUtil", "hy: only transid coming. do old way");
        if (TextUtils.isEmpty(str)) {
            v.e("MicroMsg.WalletOfflineUtil", "transid == null");
        } else if (aFl()) {
            Bundle bundle = new Bundle();
            if (kVar instanceof com.tencent.mm.plugin.offline.a.b) {
                RealnameGuideHelper realnameGuideHelper = ((com.tencent.mm.plugin.offline.a.b) kVar).hKv;
                if (realnameGuideHelper != null) {
                    bundle.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                }
            }
            bundle.putString("key_trans_id", str);
            bundle.putInt("key_pay_type", 2);
            com.tencent.mm.wallet_core.a.a(activity, i.class, bundle);
        }
    }

    public static void f(Activity activity, int i) {
        PayInfo payInfo = new PayInfo();
        payInfo.bkr = 5;
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_pay_info", payInfo);
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putInt("key_bind_scene", 5);
        bundle.putInt("key_offline_add_fee", 0);
        if (i >= 0) {
            bundle.putInt("key_entry_scene", i);
        }
        if (!k.bga().bgv()) {
            if (k.bga().bgs()) {
                bundle.putBoolean("key_is_bind_bankcard", true);
                com.tencent.mm.wallet_core.a.a(activity, d.class, bundle);
                return;
            } else if (k.bga().bgw()) {
                bundle.putBoolean("key_is_bind_bankcard", true);
                com.tencent.mm.wallet_core.a.a(activity, d.class, bundle);
                return;
            }
        }
        com.tencent.mm.wallet_core.a.a(activity, com.tencent.mm.plugin.offline.c.class, bundle);
    }

    public static void E(Activity activity) {
        a(activity, "create", activity.getString(2131236530), 0);
    }

    private static void a(Activity activity, String str, String str2, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("oper", str);
        bundle.putInt("offline_chg_fee", i);
        bundle.putString("pwd_tips", str2);
        com.tencent.mm.wallet_core.a.a(activity, g.class, bundle);
    }

    public static void F(Activity activity) {
        a(activity, "freeze", activity.getString(2131236533), 0);
    }

    public static void G(Activity activity) {
        String str = "create";
        String str2 = "";
        j.aEM();
        String nO = j.nO(196640);
        int intValue = (TextUtils.isEmpty(nO) || !qw(nO)) ? 0 : Integer.valueOf(nO).intValue();
        a(activity, str, str2, intValue > 0 ? intValue * 100 : 20000);
    }

    public static void b(final Activity activity, String str) {
        com.tencent.mm.ui.base.g.a(activity, false, str, "", activity.getString(2131236542), activity.getString(2131231010), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                a.aFu();
                a.G(activity);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                activity.finish();
            }
        });
    }

    public static void aFv() {
        j.aEM();
        j.T(196643, "1");
    }

    public static void nT(int i) {
        j.aEM();
        j.T(196644, String.valueOf(i));
    }

    public static int aFw() {
        j.aEM();
        String nO = j.nO(196644);
        if (TextUtils.isEmpty(nO) || !qw(nO)) {
            return 0;
        }
        return Integer.valueOf(nO).intValue();
    }

    public static String axY() {
        if (!TextUtils.isEmpty(hMe)) {
            return hMe;
        }
        aFz();
        if (TextUtils.isEmpty(hMe)) {
            v.e("MicroMsg.WalletOfflineUtil", "token is null");
        }
        return hMe;
    }

    public static void h(String str, String str2, String str3, String str4) {
        hMe = str;
        hMf = str2;
        hMh = str3;
        hMi = str4;
        xs(hMh);
        ak.vy().a(new ay(new com.tencent.mm.model.ay.a() {
            public final void a(e eVar) {
                if (eVar != null && eVar.BU() != null) {
                    if (a.hMe != null) {
                        eVar.BU().h("offline_token", a.hMe.getBytes());
                    }
                    if (a.hMf != null) {
                        eVar.BU().h("offline_token_V2", a.hMf.getBytes());
                    }
                    if (a.hMi != null) {
                        eVar.BU().h("offline_key_list", a.hMi.getBytes());
                    }
                }
            }
        }), 0);
    }

    public static String aFx() {
        if (!TextUtils.isEmpty(hMf)) {
            return hMf;
        }
        aFz();
        if (TextUtils.isEmpty(hMf)) {
            v.e("MicroMsg.WalletOfflineUtil", "offline_token_v2 is null");
        }
        return hMf;
    }

    public static String aFy() {
        if (!TextUtils.isEmpty(hMh)) {
            return hMh;
        }
        if (TextUtils.isEmpty(hMh)) {
            j.aEM();
            String nO = j.nO(196656);
            hMh = nO;
            return nO;
        }
        if (TextUtils.isEmpty(hMh)) {
            v.e("MicroMsg.WalletOfflineUtil", "offline_card_list is null");
        }
        return hMh;
    }

    private static void xs(String str) {
        j.aEM();
        j.T(196656, str);
        hMh = str;
    }

    private static void aFz() {
        ak.vy().a(new ay(new com.tencent.mm.model.ay.a() {
            public final void a(e eVar) {
                if (eVar == null || eVar.BU() == null) {
                    v.e("MicroMsg.WalletOfflineUtil", "doLocalProxyScene dispatcher == null || dispatcher.getAccInfo() == null");
                    return;
                }
                byte[] gS = eVar.BU().gS("offline_token");
                if (gS != null) {
                    a.hMe = new String(gS);
                }
                gS = eVar.BU().gS("offline_token_V2");
                if (gS != null) {
                    a.hMf = new String(gS);
                }
                gS = eVar.BU().gS("offline_key_list");
                if (gS != null) {
                    a.hMi = new String(gS);
                }
            }
        }), 0);
    }

    public static LinkedList<a> xt(String str) {
        LinkedList<a> linkedList = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                linkedList = m(new JSONArray(str));
            } catch (Throwable e) {
                v.a("MicroMsg.WalletOfflineUtil", e, "", new Object[0]);
            }
        }
        return linkedList;
    }

    private static LinkedList<a> m(JSONArray jSONArray) {
        if (jSONArray.length() == 0) {
            return null;
        }
        LinkedList<a> linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject != null) {
                a aVar = new a();
                aVar.hMs = jSONObject.optInt("card_id");
                aVar.hMt = jSONObject.optString("bank_type");
                aVar.hMu = jSONObject.optString("bind_serial");
                linkedList.add(aVar);
            }
        }
        return linkedList;
    }

    public static String aFA() {
        j.aEM();
        return j.nO(196647);
    }

    private static String aFB() {
        j.aEM();
        return j.nO(196616);
    }

    public static void xu(String str) {
        j.aEM();
        j.T(196616, str);
    }

    public static void H(Activity activity) {
        com.tencent.mm.ui.base.g.bf(activity, activity.getResources().getString(2131236531));
        if (!TextUtils.isEmpty(aFB())) {
            ai(activity, aFB());
        }
    }

    public static boolean aFC() {
        List hk = k.bga().hk(true);
        LinkedList xt = xt(aFy());
        if (xt == null || hk.size() != xt.size()) {
            return false;
        }
        int i;
        Collections.sort(xt, hMr);
        Collections.sort(hk, hMq);
        StringBuilder stringBuilder = new StringBuilder();
        for (i = 0; i < xt.size(); i++) {
            stringBuilder.append(((a) xt.get(i)).hMu);
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        for (i = 0; i < hk.size(); i++) {
            stringBuilder2.append(((Bankcard) hk.get(i)).field_bindSerial);
        }
        if (z.Kg(stringBuilder.toString()).equals(z.Kg(stringBuilder2.toString()))) {
            return true;
        }
        return false;
    }

    public static void xv(String str) {
        j.aEM();
        j.T(196615, str);
        hMj = str;
    }

    private static LinkedList<b> xw(String str) {
        LinkedList<b> linkedList = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                linkedList = n(new JSONArray(str));
            } catch (Throwable e) {
                v.a("MicroMsg.WalletOfflineUtil", e, "", new Object[0]);
            }
        }
        return linkedList;
    }

    private static LinkedList<b> n(JSONArray jSONArray) {
        if (jSONArray.length() == 0) {
            return null;
        }
        LinkedList<b> linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject != null) {
                b bVar = new b();
                bVar.hMt = jSONObject.optString("bank_type");
                bVar.eBZ = jSONObject.optString("icon_url");
                linkedList.add(bVar);
            }
        }
        return linkedList;
    }

    public static int aFD() {
        j.aEM();
        String nO = j.nO(196649);
        if (TextUtils.isEmpty(nO) || !qw(nO)) {
            return 0;
        }
        return Integer.valueOf(nO).intValue();
    }

    public static boolean aFE() {
        Object aFr = aFr();
        if (TextUtils.isEmpty(aFr)) {
            return false;
        }
        if ((System.currentTimeMillis() / 1000) - Long.valueOf(aFr).longValue() >= ((long) aFD())) {
            return true;
        }
        return false;
    }

    public static String xx(String str) {
        String nO;
        int i = 0;
        LinkedList xt = xt(aFy());
        if (TextUtils.isEmpty(hMj)) {
            j.aEM();
            nO = j.nO(196615);
            hMj = nO;
        } else {
            nO = hMj;
        }
        LinkedList xw = xw(nO);
        if (xt == null || xw == null || xt.size() == 0 || xw.size() == 0) {
            v.e("MicroMsg.WalletOfflineUtil", "getBankLogoUrl() cardList == null || cardLogoList == null || cardList.size() == 0 || cardLogoList.size() == 0");
            return "";
        }
        String str2 = "";
        for (int i2 = 0; i2 < xt.size(); i2++) {
            a aVar = (a) xt.get(i2);
            if (aVar != null && str.equals(aVar.hMu)) {
                Object obj = aVar.hMt;
                break;
            }
        }
        String str3 = str2;
        if (TextUtils.isEmpty(obj)) {
            v.e("MicroMsg.WalletOfflineUtil", "getBankLogoUrl() bank_type == null, can not find this bank_type");
            return "";
        }
        str2 = "";
        while (i < xw.size()) {
            b bVar = (b) xw.get(i);
            if (bVar != null && obj.equals(bVar.hMt)) {
                return bVar.eBZ;
            }
            i++;
        }
        return str2;
    }
}
