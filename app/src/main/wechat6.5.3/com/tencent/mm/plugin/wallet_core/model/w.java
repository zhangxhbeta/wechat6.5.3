package com.tencent.mm.plugin.wallet_core.model;

import android.text.TextUtils;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t.a;
import com.tencent.mm.wallet_core.b.m;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class w {
    public static void D(JSONObject jSONObject) {
        v.i("MicroMsg.WalletQueryBankcardParser", "parseQueryBankcard()");
        try {
            aa aaVar;
            Object obj;
            Bankcard bankcard;
            Bankcard bankcard2;
            Object ah;
            h hVar;
            String optString = jSONObject.optString("time_stamp");
            if (!be.kS(optString)) {
                m.setTimeStamp(optString);
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("user_info");
            v.i("MicroMsg.WalletQueryBankcardParser", "getUserInfo()");
            aa aaVar2 = new aa();
            if (jSONObject2 == null || jSONObject2.length() <= 0) {
                v.e("MicroMsg.WalletQueryBankcardParser", "getUserInfo() json == null or json.length() == 0");
                aaVar = null;
            } else {
                aaVar2.field_is_reg = jSONObject2.getInt("is_reg");
                aaVar2.field_true_name = jSONObject2.optString("true_name");
                aaVar2.field_cre_type = jSONObject2.optInt("cre_type", -1);
                aaVar2.field_main_card_bind_serialno = jSONObject2.optString("last_card_bind_serialno");
                aaVar2.field_ftf_pay_url = jSONObject2.optString("transfer_url");
                aaVar2.field_reset_passwd_flag = jSONObject2.optString("reset_passwd_flag");
                aaVar2.field_find_passwd_url = jSONObject2.optString("reset_passwd_url");
                k.bga();
                ab.Df(aaVar2.field_main_card_bind_serialno);
                aaVar2.field_isDomesticUser = "2".equals(jSONObject2.optString("icard_user_flag", "2"));
                JSONObject optJSONObject = jSONObject2.optJSONObject("touch_info");
                if (optJSONObject != null) {
                    aaVar2.field_is_open_touch = optJSONObject.optInt("is_open_touch", 0);
                    v.i("MicroMsg.WalletQueryBankcardParser", "getUserInfo field_is_open_touch() is " + aaVar2.field_is_open_touch);
                } else {
                    int i;
                    v.e("MicroMsg.WalletQueryBankcardParser", "touch_info is null ");
                    if (k.bga().bgx()) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    aaVar2.field_is_open_touch = i;
                    v.e("MicroMsg.WalletQueryBankcardParser", "old field_is_open_touch is " + aaVar2.field_is_open_touch);
                }
                aaVar2.field_lct_wording = jSONObject2.optString("lct_wording");
                aaVar2.field_lct_url = jSONObject2.optString("lct_url");
                v.i("MicroMsg.WalletQueryBankcardParser", "field_lct_wording: " + aaVar2.field_lct_wording + ", field_lct_url:" + aaVar2.field_lct_url);
                aaVar = aaVar2;
            }
            aaVar.field_switchConfig = jSONObject.getJSONObject("switch_info").getInt("switch_bit");
            optString = jSONObject.optString("support_bank_word");
            ak.yW();
            c.vf().a(a.npk, be.ma(optString));
            ArrayList p = p(jSONObject.optJSONArray("Array"));
            ArrayList q = q(jSONObject.optJSONArray("virtual_card_array"));
            JSONObject optJSONObject2 = jSONObject.optJSONObject("balance_info");
            String str = "MicroMsg.WalletQueryBankcardParser";
            String str2 = "Bankcard getBalance %s";
            Object[] objArr = new Object[1];
            if (optJSONObject2 == null) {
                optString = "";
            } else {
                obj = optJSONObject2;
            }
            objArr[0] = optString;
            v.i(str, str2, objArr);
            if (optJSONObject2 == null || optJSONObject2.length() <= 0) {
                v.i("MicroMsg.WalletQueryBankcardParser", "getBalance() json == null or json.length() == 0");
                bankcard = null;
            } else {
                final Bankcard bankcard3 = new Bankcard((byte) 0);
                final long optLong = optJSONObject2.optLong("balance_version", -1);
                final long optLong2 = optJSONObject2.optLong("time_out", 7200);
                final int optInt = optJSONObject2.optInt("avail_balance");
                e.a(new String[]{"wallet_balance_version", "wallet_balance_last_update_time", "wallet_balance"}, new e.a() {
                    public final void B(Map<String, Object> map) {
                        if (map != null) {
                            long a = be.a((Long) map.get("wallet_balance_version"), -1);
                            long a2 = be.a((Long) map.get("wallet_balance_last_update_time"), -1);
                            if (a2 < 0 || a < 0 || a2 + optLong2 > be.Nj() || optLong >= a) {
                                e.a(new e.c("wallet_balance_version", Long.valueOf(optLong)), new e.c("wallet_balance_last_update_time", Long.valueOf(be.Nj())), new e.c("wallet_balance", Double.valueOf(((double) optInt) / 100.0d)));
                                bankcard3.kNv = ((double) optInt) / 100.0d;
                                return;
                            }
                            v.w("MicroMsg.WalletQueryBankcardParser", "hy: new balance comes but last msg is not timeout and balance version is smaller than before");
                        }
                    }
                });
                bankcard3.kNv = ((double) optJSONObject2.optInt("avail_balance")) / 100.0d;
                bankcard3.kNw = optJSONObject2.optString("balance_show_wording");
                bankcard3.kNz = optJSONObject2.optString("max_fetch_wording");
                bankcard3.kNA = optJSONObject2.optString("avail_fetch_wording");
                bankcard3.kNx = ((double) optJSONObject2.optInt("fetch_balance")) / 100.0d;
                bankcard3.field_cardType |= Bankcard.kNo;
                bankcard3.field_bankcardType = optJSONObject2.optString("balance_bank_type");
                bankcard3.field_bindSerial = optJSONObject2.optString("balance_bind_serial");
                bankcard3.field_forbidWord = optJSONObject2.optString("balance_forbid_word");
                if (be.kS(bankcard3.field_forbidWord)) {
                    bankcard3.field_bankcardState = 0;
                } else {
                    bankcard3.field_bankcardState = 8;
                }
                bankcard3.field_fetchArriveTime = optJSONObject2.optLong("fetch_arrive_time");
                bankcard3.field_mobile = optJSONObject2.optString("mobile");
                bankcard3.field_support_micropay = optJSONObject2.optInt("support_micropay", 0) == 1;
                v.i("MicroMsg.WalletQueryBankcardParser", "getBalance() support_micropay:" + optJSONObject2.optInt("support_micropay", 0));
                bankcard3.kNy = optJSONObject2.optString("balance_list_url");
                optString = aa.getContext().getString(2131235981);
                bankcard3.field_desc = optString;
                bankcard3.field_bankName = optString;
                bankcard3.field_bankcardTail = "10000";
                bankcard3.field_forbid_title = optJSONObject2.optString("forbid_title");
                bankcard3.field_forbid_url = optJSONObject2.optString("forbid_url");
                bankcard = bankcard3;
            }
            v.i("MicroMsg.WalletQueryBankcardParser", "hy: cache time: %d", new Object[]{Integer.valueOf(jSONObject.optInt("query_cache_time"))});
            JSONArray optJSONArray = jSONObject.optJSONArray("history_card_array");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                v.e("MicroMsg.WalletQueryBankcardParser", "getHistroyBankcard() json == null or json.length() == 0");
                bankcard2 = null;
            } else {
                bankcard2 = c.bfJ().y(optJSONArray.getJSONObject(0));
                bankcard2.field_cardType |= Bankcard.kNp;
            }
            optJSONArray = jSONObject.optJSONArray("balance_notice");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("fetch_notice");
            if (optJSONArray != null) {
                ah = be.ah(optJSONArray.toString(), "");
            } else {
                str = "";
            }
            v.i("MicroMsg.WalletQueryBankcardParser", "hy: balance notice: %s, fetchNotice: %s", new Object[]{ah, optJSONArray2 != null ? be.ah(optJSONArray2.toString(), "") : ""});
            ak.yW();
            c.vf().a(a.npi, ah);
            ak.yW();
            c.vf().a(a.npj, obj);
            ak.yW();
            c.vf().iB(true);
            if (!be.kS(jSONObject.optString("query_order_time"))) {
                v.i("MicroMsg.WalletQueryBankcardParser", "hy: has query order time. set to subcore");
                k.bga().De(jSONObject.optString("query_order_time"));
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("loan_entry_info");
            if (optJSONObject3 == null) {
                v.e("MicroMsg.WalletQueryBankcardParser", "getLoanEntryInfo json is null");
                hVar = null;
            } else {
                v.i("MicroMsg.WalletQueryBankcardParser", "getLoanEntryInfo()");
                hVar = new h();
                hVar.field_title = optJSONObject3.optString("title");
                hVar.field_loan_jump_url = optJSONObject3.optString("loan_jump_url");
                v.i("MicroMsg.WalletQueryBankcardParser", "getLoanEntryInfo() field_loan_jump_url:" + hVar.field_loan_jump_url);
                hVar.field_is_show_entry = optJSONObject3.optInt("is_show_entry", 0);
                hVar.field_tips = optJSONObject3.optString("tips");
                hVar.field_is_overdue = optJSONObject3.optInt("is_overdue", 0);
                if (optJSONObject3.has("available_otb")) {
                    hVar.field_available_otb = e.d(optJSONObject3.optDouble("available_otb") / 100.0d, "CNY");
                }
                if (optJSONObject3.has("index")) {
                    hVar.field_red_dot_index = optJSONObject3.optInt("index");
                }
                v.i("MicroMsg.WalletQueryBankcardParser", "getLoanEntryInfo() field_index:" + hVar.field_red_dot_index + "  field_is_overdue:" + hVar.field_is_overdue + "  field_is_show_entry:" + hVar.field_is_show_entry);
            }
            optJSONObject3 = jSONObject.optJSONObject("fetch_info");
            b bVar = k.bga().kQU;
            v.d("MicroMsg.WalletQueryBankcardParser", "fetchInfo: %s", new Object[]{bVar});
            if (optJSONObject3 != null) {
                bVar = a(optJSONObject3, true);
            } else {
                v.e("MicroMsg.WalletQueryBankcardParser", "parseQueryBankcard() fetch_info is null");
            }
            k.bga().a(aaVar, p, q, bankcard, bankcard2, hVar, bVar, r8);
        } catch (Throwable e) {
            v.e("MicroMsg.WalletQueryBankcardParser", "parseQueryBankcard Exception :" + e.getMessage());
            v.a("MicroMsg.WalletQueryBankcardParser", e, "", new Object[0]);
        }
    }

    public static b a(JSONObject jSONObject, boolean z) {
        int i = 0;
        if (jSONObject == null) {
            v.e("MicroMsg.WalletQueryBankcardParser", "getBalanceFetchInfo(), json is null");
            return null;
        }
        v.e("MicroMsg.WalletQueryBankcardParser", "getBalanceFetchInfo(), json is valid");
        b bVar = new b();
        bVar.kNj = jSONObject.optString("fetch_charge_title");
        v.i("MicroMsg.WalletQueryBankcardParser", "fetch_charge_title:" + bVar.kNj);
        if (z) {
            v.i("MicroMsg.WalletQueryBankcardParser", "isBindQuery true");
            bVar.kFC = jSONObject.optInt("is_cal_charge", 0);
            bVar.kFB = jSONObject.optInt("is_show_charge", 0);
            bVar.kFD = jSONObject.optInt("is_full_fetch_direct", 0);
            bVar.kFE = jSONObject.optDouble("min_charge_fee", 0.0d) / 100.0d;
            bVar.irs = jSONObject.optDouble("remain_fee", 0.0d) / 100.0d;
            v.i("MicroMsg.WalletQueryBankcardParser", " is_cal_charge:" + bVar.kFC + " is_show_charge:" + bVar.kFB + " min_charge_fee:" + bVar.kFE + " remain_fee:" + bVar.irs + " is_full_fetch_direct:" + bVar.kFD);
        } else {
            v.i("MicroMsg.WalletQueryBankcardParser", "isBindQuery false");
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("item");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            v.e("MicroMsg.WalletQueryBankcardParser", "getBalanceFetchInfo(), itemJsonArray is null");
        } else {
            bVar.kNk = new LinkedList();
            while (i < optJSONArray.length()) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    b.a aVar = new b.a();
                    aVar.apU = optJSONObject.optString("key");
                    aVar.value = optJSONObject.optString(Columns.VALUE);
                    v.i("MicroMsg.WalletQueryBankcardParser", "feeItem.key is " + aVar.apU + " , feeItem.value is " + aVar.value);
                    if (!(TextUtils.isEmpty(aVar.apU) || TextUtils.isEmpty(aVar.value))) {
                        bVar.kNk.add(aVar);
                    }
                } else {
                    v.e("MicroMsg.WalletQueryBankcardParser", "item index " + i + " is empty");
                }
                i++;
            }
            v.i("MicroMsg.WalletQueryBankcardParser", "itemsList size is " + bVar.kNk.size());
        }
        return bVar;
    }

    private static ArrayList<Bankcard> p(JSONArray jSONArray) {
        v.i("MicroMsg.WalletQueryBankcardParser", "getBankcards()");
        ArrayList<Bankcard> arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                Bankcard y = c.bfJ().y(jSONArray.getJSONObject(i));
                if (y != null) {
                    if (y.bfG()) {
                        y.field_desc = y.field_bankName;
                    } else if (y.bfH()) {
                        y.field_desc = aa.getContext().getString(2131236154, new Object[]{y.field_bankName, y.field_bankcardTail});
                    } else if (y.bfF()) {
                        y.field_desc = aa.getContext().getString(2131236551, new Object[]{y.field_bankName, y.field_bankcardTail});
                    } else {
                        y.field_desc = aa.getContext().getString(2131236168, new Object[]{y.field_bankName, y.field_bankcardTail});
                    }
                    arrayList.add(y);
                }
            }
        }
        return arrayList;
    }

    private static ArrayList<Bankcard> q(JSONArray jSONArray) {
        ArrayList<Bankcard> arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                Bankcard bankcard = new Bankcard();
                bankcard.field_cardType |= Bankcard.kNn;
                bankcard.field_bankName = jSONObject.getString("bank_name");
                bankcard.field_bankcardType = jSONObject.getString("bank_type");
                bankcard.field_bankcardTypeName = jSONObject.optString("bankacc_type_name");
                bankcard.kNr = jSONObject.getString("card_id");
                bankcard.field_bizUsername = jSONObject.getString("app_username");
                bankcard.field_wxcreditState = jSONObject.getInt("card_status");
                if (bankcard.field_wxcreditState != 2) {
                    bankcard.field_bankcardState = 9;
                } else {
                    bankcard.field_bankcardState = 0;
                }
                bankcard.field_desc = aa.getContext().getString(2131236551, new Object[]{bankcard.field_bankName, bankcard.field_bankcardTail});
                bankcard.kND = new d();
                bankcard.kND.hGg = jSONObject.getString("logo_url");
                bankcard.kND.kNF = jSONObject.getString("background_logo_url");
                bankcard.kND.kNG = jSONObject.getString("big_logo_url");
                arrayList.add(bankcard);
            }
        }
        return arrayList;
    }
}
