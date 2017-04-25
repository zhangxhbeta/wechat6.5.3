package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.wallet.a.c;
import com.tencent.mm.plugin.wallet.a.d;
import com.tencent.mm.plugin.wallet.a.l;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class Orders implements Parcelable {
    public static final Creator<Orders> CREATOR = new Creator<Orders>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Orders(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Orders[i];
        }
    };
    public static int kPu = 0;
    public static int kPv = 1;
    public String cID;
    public String eRq = "0";
    public String fTG = "";
    public String fwh = "";
    public String hGg;
    public String hNg;
    public double iro;
    public int kLu;
    public String kMS;
    public long kOT;
    public double kOU = 0.0d;
    public double kOV = 0.0d;
    public int kOW;
    public String kOX;
    public int kOY;
    public String kOZ;
    public String kPa;
    public String kPb;
    public String kPc;
    public int kPd;
    public boolean kPe = false;
    public String kPf = "";
    public long kPg = 0;
    public String kPh = "";
    public String kPi;
    public Set<String> kPj = new HashSet();
    public int kPk = 0;
    public String kPl = "";
    public List<Commodity> kPm = new ArrayList();
    public c kPn = new c();
    public int kPo = 0;
    public String kPp = "";
    public String kPq = "";
    public DeductInfo kPr;
    public long kPs;
    public long kPt;
    public String token = "";
    public String username;

    public static class Commodity implements Parcelable {
        public static final Creator<Commodity> CREATOR = new Creator<Commodity>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new Commodity(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new Commodity[i];
            }
        };
        public String desc;
        public String eWA;
        public double eWz = 0.0d;
        public String hMJ;
        public String hMS;
        public String hMT;
        public String hMU;
        public String hMV;
        public String hMX;
        public String hMZ;
        public String hNa;
        public int hNc;
        public String hNe;
        public String hNg;
        public String hNh;
        public String hNl;
        public String kPA;
        public String kPB;
        public List<b> kPC = new ArrayList();
        public a kPD = new a();
        public int kPd;
        public double kPw = 0.0d;
        public String kPx;
        public String kPy;
        public List<DiscountInfo> kPz = new ArrayList();

        public int describeContents() {
            return 0;
        }

        public Commodity(Parcel parcel) {
            this.hMS = parcel.readString();
            this.hMT = parcel.readString();
            this.hMU = parcel.readString();
            this.hMV = parcel.readString();
            this.desc = parcel.readString();
            this.hMX = parcel.readString();
            this.eWz = parcel.readDouble();
            this.hMZ = parcel.readString();
            this.hNa = parcel.readString();
            this.hNc = parcel.readInt();
            this.eWA = parcel.readString();
            this.hNe = parcel.readString();
            this.hNg = parcel.readString();
            this.hNh = parcel.readString();
            this.hMJ = parcel.readString();
            this.kPy = parcel.readString();
            this.hNl = parcel.readString();
            parcel.readTypedList(this.kPz, DiscountInfo.CREATOR);
            this.kPA = parcel.readString();
            this.kPB = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.hMS);
            parcel.writeString(this.hMT);
            parcel.writeString(this.hMU);
            parcel.writeString(this.hMV);
            parcel.writeString(this.desc);
            parcel.writeString(this.hMX);
            parcel.writeDouble(this.eWz);
            parcel.writeString(this.hMZ);
            parcel.writeString(this.hNa);
            parcel.writeInt(this.hNc);
            parcel.writeString(this.eWA);
            parcel.writeString(this.hNe);
            parcel.writeString(this.hNg);
            parcel.writeString(this.hNh);
            parcel.writeString(this.hMJ);
            parcel.writeString(this.kPy);
            parcel.writeString(this.hNl);
            parcel.writeTypedList(this.kPz);
            parcel.writeString(this.kPA);
            parcel.writeString(this.kPB);
        }
    }

    public static class DeductInfo implements Parcelable {
        public static final Creator<DeductInfo> CREATOR = new Creator<DeductInfo>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new DeductInfo(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new DeductInfo[i];
            }
        };
        public String desc;
        public int kJG;
        public String kPE;
        public List<DeductShowInfo> kPF = new ArrayList();
        public int kPG;
        public String title;

        public DeductInfo(Parcel parcel) {
            this.title = parcel.readString();
            this.desc = parcel.readString();
            this.kJG = parcel.readInt();
            this.kPE = parcel.readString();
            this.kPG = parcel.readInt();
            parcel.readTypedList(this.kPF, DeductShowInfo.CREATOR);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.title);
            parcel.writeString(this.desc);
            parcel.writeInt(this.kJG);
            parcel.writeString(this.kPE);
            parcel.writeInt(this.kPG);
            parcel.writeTypedList(this.kPF);
        }
    }

    public static class DeductShowInfo implements Parcelable {
        public static final Creator<DeductShowInfo> CREATOR = new Creator<DeductShowInfo>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new DeductShowInfo(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new DeductShowInfo[i];
            }
        };
        public String name;
        public String url;
        public String value;

        protected DeductShowInfo(Parcel parcel) {
            this.name = parcel.readString();
            this.value = parcel.readString();
            this.url = parcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.name);
            parcel.writeString(this.value);
            parcel.writeString(this.url);
        }
    }

    public static class DiscountInfo implements Parcelable {
        public static final Creator<DiscountInfo> CREATOR = new Creator<DiscountInfo>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new DiscountInfo(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new DiscountInfo[i];
            }
        };
        public double kPH;
        public String kPI;

        public DiscountInfo(Parcel parcel) {
            this.kPH = parcel.readDouble();
            this.kPI = parcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeDouble(this.kPH);
            parcel.writeString(this.kPI);
        }
    }

    public static class a {
        public String text = "";
        public String url = "";
    }

    public static class b {
        public String hNh;
        public String hRr;
        public String kPJ;
        public int kPK;
        public long kPL;
        public int kPM;
        public int kPN;
        public int kPO;
        public int kPP;
        public String kPQ;
        public String name;
        public String title;
        public int type;
        public String url;
    }

    public static Orders z(JSONObject jSONObject) {
        boolean z = true;
        Orders orders = null;
        if (jSONObject != null) {
            orders = new Orders();
            try {
                orders.kOT = be.Ni();
                orders.kOU = jSONObject.getDouble("total_fee") / 100.0d;
                orders.eRq = jSONObject.getString("num");
                orders.kLu = jSONObject.optInt("bank_card_tag", 1);
                orders.hNg = jSONObject.optString("fee_type", "");
                orders.iro = jSONObject.optDouble("charge_fee", 0.0d) / 100.0d;
                orders.kOV = jSONObject.optDouble("fetch_fee", 0.0d) / 100.0d;
                orders.kOW = jSONObject.optInt("is_assign_userinfo_pay");
                orders.kMS = jSONObject.optString("true_name");
                orders.kOX = jSONObject.optString("cre_id");
                orders.kOY = jSONObject.optInt("ce_type");
                orders.kOZ = jSONObject.optString("assign_pay_info");
                JSONArray jSONArray = jSONObject.getJSONArray("Array");
                orders.kPs = jSONObject.optLong("free_fee");
                orders.kPt = jSONObject.optLong("remain_fee");
                boolean z2 = jSONObject.optInt("support_all_bank", 0) == 1;
                if (z2) {
                    orders.kPj = new HashSet();
                }
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    Commodity commodity = new Commodity();
                    commodity.desc = jSONObject2.getString("desc");
                    commodity.eWz = ((double) jSONObject2.getInt("fee")) / 100.0d;
                    commodity.hMX = jSONObject2.optInt("count", 1);
                    commodity.hMZ = jSONObject2.getString("pay_status");
                    commodity.hNe = jSONObject2.optString("buy_bank_name");
                    commodity.hNa = jSONObject2.getString("pay_status_name");
                    commodity.hMU = jSONObject2.optString("spid");
                    commodity.hMV = jSONObject2.optString("sp_name");
                    commodity.hNc = jSONObject2.optInt("modify_timestamp");
                    commodity.eWA = jSONObject2.getString("transaction_id");
                    commodity.hNg = jSONObject2.optString("fee_type");
                    if (be.kS(orders.hNg)) {
                        orders.hNg = commodity.hNg;
                    }
                    commodity.hNh = jSONObject2.optString("appusername");
                    commodity.hMJ = jSONObject2.optString("app_telephone");
                    orders.kPm.add(commodity);
                    if (!z2) {
                        orders.kPi = jSONObject2.optString("support_bank");
                        orders.kPj = CZ(orders.kPi);
                    }
                }
                if (jSONObject.has("is_open_fee_protocal")) {
                    orders.kPe = e.e(jSONObject, "is_open_fee_protocal");
                } else {
                    orders.kPe = Bankcard.cI(orders.kLu, 2);
                }
                orders.kPn = A(jSONObject);
                JSONObject optJSONObject = jSONObject.optJSONObject("bindqueryresp");
                if (optJSONObject == null) {
                    v.e("MicroMsg.Orders", "bindqueryresp is null ");
                } else {
                    optJSONObject = optJSONObject.optJSONObject("user_info");
                    if (optJSONObject == null) {
                        v.e("MicroMsg.Orders", "user_info is null ");
                    } else {
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("touch_info");
                        if (optJSONObject2 == null) {
                            v.e("MicroMsg.Orders", "touch_info is null ");
                        } else {
                            orders.kPk = com.tencent.mm.pluginsdk.j.a.lxX.anu() ? optJSONObject2.optInt("use_touch_pay", 0) : 0;
                            orders.kPl = optJSONObject2.optString("touch_forbidword");
                            String optString = optJSONObject2.optString("touch_challenge");
                            if (1 != optJSONObject2.optInt("need_change_auth_key")) {
                                z = false;
                            }
                            o.kQn.fUl = optString;
                            o.kQn.fUm = z;
                            v.i("MicroMsg.Orders", "hy: use_touch_pay is %s, challenge is: %s, is need change: %b", new Object[]{Integer.valueOf(orders.kPk), optString, Boolean.valueOf(z)});
                        }
                    }
                }
                orders.kPo = jSONObject.optInt("needbindcardtoshowfavinfo");
                orders.kPp = jSONObject.optString("discount_wording");
                orders.kPq = jSONObject.optString("favor_rule_wording");
                a(orders, jSONObject.optJSONObject("entrustpayinfo"));
            } catch (Throwable e) {
                v.a("MicroMsg.Orders", e, "", new Object[0]);
            }
        }
        return orders;
    }

    private static c A(JSONObject jSONObject) {
        c cVar = new c();
        JSONObject optJSONObject = jSONObject.optJSONObject("favinfo");
        if (optJSONObject == null) {
            v.d("MicroMsg.Orders", "Parse getJsonObject(favinfo) null");
            return cVar;
        }
        int i;
        cVar.kHy = ((double) optJSONObject.optLong("tradeAmount")) / 100.0d;
        cVar.kHz = ((double) optJSONObject.optLong("totalFavAmount")) / 100.0d;
        cVar.kHA = ((double) optJSONObject.optLong("afterFavorTradeAmount")) / 100.0d;
        cVar.kHB = optJSONObject.optString("favorComposeId");
        cVar.kHE = optJSONObject.optInt("useNaturalDefense");
        cVar.kHF = optJSONObject.optString("discountWording");
        cVar.kHG = optJSONObject.optString("favorRuleWording");
        cVar.kHH = optJSONObject.optDouble("showFavorAmount", 0.0d) / 100.0d;
        cVar.kHI = optJSONObject.optDouble("invariableFavorAmount", 0.0d) / 100.0d;
        cVar.kHJ = optJSONObject.optInt("isVariableFavor");
        cVar.kHK = optJSONObject.optString("invariableFavorDesc");
        cVar.kHL = optJSONObject.optString("variableFavorDesc");
        JSONArray optJSONArray = optJSONObject.optJSONArray("tradeFavList");
        for (i = 0; i < optJSONArray.length(); i++) {
            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
            l lVar = new l();
            lVar.kIc = jSONObject2.optInt("favType");
            lVar.kId = jSONObject2.optInt("favSubType");
            lVar.kIe = jSONObject2.optLong("favProperty");
            lVar.kIf = jSONObject2.optString("favorTypeDesc");
            lVar.kHv = jSONObject2.optString("favId");
            lVar.kIg = jSONObject2.optString("favName");
            lVar.kIh = jSONObject2.optString("favDesc");
            lVar.kHw = jSONObject2.optString("favorUseManual");
            lVar.kHx = jSONObject2.optString("favorRemarks");
            lVar.kIi = ((double) jSONObject2.optLong("favPrice")) / 100.0d;
            lVar.kIj = ((double) jSONObject2.optLong("realFavFee")) / 100.0d;
            lVar.kIk = jSONObject2.optInt("needBankPay");
            lVar.kIl = jSONObject2.optString("bankNo");
            lVar.hNe = jSONObject2.optString("bankName");
            lVar.kIm = jSONObject2.optString("bankLogoUrl");
            cVar.kHC.add(lVar);
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("favorComposeList");
        if (optJSONObject2 != null) {
            cVar.kHD = new d();
            optJSONArray = optJSONObject2.optJSONArray("favorComposeInfo");
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                optJSONObject2 = optJSONArray.getJSONObject(i2);
                com.tencent.mm.plugin.wallet.a.e eVar = new com.tencent.mm.plugin.wallet.a.e();
                eVar.kHO = optJSONObject2.optString("faovrComposeId");
                eVar.kHP = ((double) optJSONObject2.optLong("totalFavorAmount")) / 100.0d;
                eVar.kHA = ((double) optJSONObject2.optLong("afterFavorTradeAmount")) / 100.0d;
                eVar.kHH = optJSONObject2.optDouble("showFavorAmount", 0.0d) / 100.0d;
                eVar.kHI = optJSONObject2.optDouble("invariableFavorAmount", 0.0d) / 100.0d;
                eVar.kHJ = optJSONObject2.optInt("isVariableFavor");
                eVar.kHK = optJSONObject2.optString("invariableFavorDesc");
                eVar.kHL = optJSONObject2.optString("variableFavorDesc");
                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("composeArray");
                for (i = 0; i < optJSONArray2.length(); i++) {
                    JSONObject jSONObject3 = optJSONArray2.getJSONObject(i);
                    com.tencent.mm.plugin.wallet.a.b bVar = new com.tencent.mm.plugin.wallet.a.b();
                    bVar.kHv = jSONObject3.optString("favId");
                    bVar.kHw = jSONObject3.optString("favorUseManual");
                    bVar.kHx = jSONObject3.optString("favorRemarks");
                    eVar.kHQ.add(bVar);
                }
                cVar.kHD.kHM.add(eVar);
            }
        }
        return cVar;
    }

    public static Orders a(JSONObject jSONObject, Orders orders) {
        if (jSONObject == null || orders == null) {
            v.w("MicroMsg.Orders", "oldOrders is null");
        } else {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("appservice");
                if (optJSONObject != null) {
                    orders.kPb = optJSONObject.optString("app_recommend_desc");
                    orders.kPc = optJSONObject.optString("app_telephone");
                    orders.kPd = optJSONObject.optInt("recommend_level", 2);
                    orders.fwh = optJSONObject.optString("share_to_friends_url");
                }
                int i = orders.kPd;
                List<Commodity> list = orders.kPm;
                orders.kPf = jSONObject.optString("pay_result_tips");
                JSONArray jSONArray = jSONObject.getJSONArray("payresult");
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    Commodity commodity;
                    if (list != null && list.size() == 1) {
                        commodity = (Commodity) list.get(0);
                        commodity.kPC = new ArrayList();
                        commodity.kPz = new ArrayList();
                        commodity.eWA = jSONObject2.getString("transaction_id");
                        a(commodity, jSONObject2, i);
                    } else if (list != null) {
                        String string = jSONObject2.getString("transaction_id");
                        for (Commodity commodity2 : list) {
                            if (string != null && string.equals(commodity2.eWA)) {
                                a(commodity2, jSONObject2, i);
                                break;
                            }
                        }
                    }
                }
                optJSONObject = jSONObject.optJSONObject("extinfo");
                if (optJSONObject != null) {
                    orders.kPg = optJSONObject.optLong("fetch_pre_arrive_time") * 1000;
                    orders.kPh = optJSONObject.optString("fetch_pre_arrive_time_wording");
                }
            } catch (Throwable e) {
                v.a("MicroMsg.Orders", e, "", new Object[0]);
            }
        }
        return orders;
    }

    private static void a(Commodity commodity, JSONObject jSONObject, int i) {
        int i2 = 0;
        commodity.hNl = jSONObject.optString("discount");
        commodity.hMZ = jSONObject.getString("pay_status");
        commodity.hNa = jSONObject.getString("pay_status_name");
        commodity.hNe = jSONObject.optString("buy_bank_name");
        commodity.hNc = jSONObject.optInt("pay_timestamp");
        commodity.kPy = jSONObject.optString("card_tail");
        commodity.kPd = i;
        commodity.kPA = jSONObject.optString("rateinfo");
        commodity.kPB = jSONObject.optString("original_feeinfo");
        if (jSONObject.has("total_fee")) {
            commodity.eWz = jSONObject.optDouble("total_fee", 0.0d) / 100.0d;
        }
        commodity.kPw = jSONObject.optDouble("original_total_fee", -1.0d) / 100.0d;
        commodity.hNg = jSONObject.optString("fee_type", "");
        JSONObject optJSONObject = jSONObject.optJSONObject("subscribe_biz_info");
        if (optJSONObject != null) {
            b bVar = new b();
            bVar.type = kPu;
            bVar.name = optJSONObject.optString("nickname");
            bVar.hNh = optJSONObject.optString("username");
            commodity.kPx = bVar.hNh;
            bVar.hRr = optJSONObject.optString("logo_round_url");
            bVar.url = optJSONObject.optString("subscribe_biz_url");
            if (!(be.kS(bVar.name) || be.kS(bVar.url))) {
                commodity.kPC.add(bVar);
            }
        }
        JSONArray jSONArray = jSONObject.getJSONArray("activity_info");
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
            b bVar2 = new b();
            bVar2.type = kPv;
            bVar2.hRr = jSONObject2.optString("icon");
            bVar2.name = jSONObject2.optString("wording");
            bVar2.url = jSONObject2.optString("url");
            bVar2.kPJ = jSONObject2.optString("btn_text");
            bVar2.kPK = jSONObject2.optInt(Columns.TYPE);
            bVar2.title = jSONObject2.optString("title");
            bVar2.kPL = jSONObject2.optLong("activity_id");
            bVar2.kPM = jSONObject2.optInt("activity_type", 0);
            bVar2.kPQ = jSONObject2.optString("small_title");
            bVar2.kPN = jSONObject2.optInt("award_id");
            bVar2.kPO = jSONObject2.optInt("send_record_id");
            bVar2.kPP = jSONObject2.optInt("user_record_id");
            commodity.kPC.add(bVar2);
        }
        optJSONObject = jSONObject.optJSONObject("link_ativity_info");
        if (optJSONObject != null) {
            commodity.kPD.text = optJSONObject.optString("text");
            commodity.kPD.url = optJSONObject.optString("url");
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("discount_array");
        if (optJSONArray != null) {
            int length2 = optJSONArray.length();
            while (i2 < length2) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                DiscountInfo discountInfo = new DiscountInfo();
                if (optJSONObject2 != null) {
                    discountInfo.kPH = optJSONObject2.optDouble("payment_amount");
                    discountInfo.kPI = optJSONObject2.optString("favor_desc");
                    commodity.kPz.add(discountInfo);
                }
                i2++;
            }
        }
    }

    private static void a(Orders orders, JSONObject jSONObject) {
        int i = 0;
        if (jSONObject != null) {
            v.i("MicroMsg.Orders", "parseDeductInfo json is not null");
            orders.kPr = new DeductInfo();
            orders.kPr.title = jSONObject.optString("contract_title");
            orders.kPr.desc = jSONObject.optString("contract_desc");
            orders.kPr.kJG = jSONObject.optInt("auto_deduct_flag", 0);
            orders.kPr.kPE = jSONObject.optString("contract_url");
            orders.kPr.kPG = jSONObject.optInt("is_select_pay_way", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("show_info");
            int length = optJSONArray.length();
            if (length > 0) {
                orders.kPr.kPF = new ArrayList();
                while (i < length) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        DeductShowInfo deductShowInfo = new DeductShowInfo();
                        deductShowInfo.name = optJSONObject.optString("name");
                        deductShowInfo.value = optJSONObject.optString(Columns.VALUE);
                        deductShowInfo.url = optJSONObject.optString("url");
                        orders.kPr.kPF.add(deductShowInfo);
                    } else {
                        v.e("MicroMsg.Orders", "parseDeductInfo's showInfo get a null value from json,index=" + i);
                    }
                    i++;
                }
                return;
            }
            v.e("MicroMsg.Orders", "parseDeductInfo's showInfo len is " + length);
            return;
        }
        v.i("MicroMsg.Orders", "parseDeductInfo json is null");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("reqKey:").append(this.fTG).append("\n");
        stringBuilder.append("token").append(this.token).append("\n");
        stringBuilder.append("num").append(this.eRq).append("\n");
        stringBuilder.append("totalFee").append(this.kOU).append("\n");
        return stringBuilder.toString();
    }

    public int describeContents() {
        return 0;
    }

    private static HashSet<String> CZ(String str) {
        HashSet<String> hashSet = new HashSet();
        if (!be.kS(str)) {
            for (Object add : str.split("\\|")) {
                hashSet.add(add);
            }
            if (hashSet.size() > 0) {
                hashSet.retainAll(hashSet);
            } else {
                hashSet.clear();
            }
        }
        return hashSet;
    }

    public Orders(Parcel parcel) {
        boolean z = true;
        this.kOT = parcel.readLong();
        this.fTG = parcel.readString();
        this.token = parcel.readString();
        this.eRq = parcel.readString();
        this.kOU = parcel.readDouble();
        this.kLu = parcel.readInt();
        this.hNg = parcel.readString();
        this.iro = parcel.readDouble();
        this.kOV = parcel.readDouble();
        this.kOW = parcel.readInt();
        this.kMS = parcel.readString();
        this.kOX = parcel.readString();
        this.kOY = parcel.readInt();
        this.kOZ = parcel.readString();
        this.username = parcel.readString();
        this.cID = parcel.readString();
        this.hGg = parcel.readString();
        this.kPa = parcel.readString();
        this.kPb = parcel.readString();
        this.kPc = parcel.readString();
        this.kPd = parcel.readInt();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.kPe = z;
        this.kPf = parcel.readString();
        this.fwh = parcel.readString();
        this.kPg = parcel.readLong();
        this.kPh = parcel.readString();
        parcel.readTypedList(this.kPm, Commodity.CREATOR);
        this.kPi = parcel.readString();
        this.kPj = CZ(this.kPi);
        this.kPk = parcel.readInt();
        this.kPl = parcel.readString();
        this.kPr = (DeductInfo) parcel.readParcelable(DeductInfo.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.kOT);
        parcel.writeString(this.fTG);
        parcel.writeString(this.token);
        parcel.writeString(this.eRq);
        parcel.writeDouble(this.kOU);
        parcel.writeInt(this.kLu);
        parcel.writeString(this.hNg);
        parcel.writeDouble(this.iro);
        parcel.writeDouble(this.kOV);
        parcel.writeInt(this.kOW);
        parcel.writeString(this.kMS);
        parcel.writeString(this.kOX);
        parcel.writeInt(this.kOY);
        parcel.writeString(this.kOZ);
        parcel.writeString(this.username);
        parcel.writeString(this.cID);
        parcel.writeString(this.hGg);
        parcel.writeString(this.kPa);
        parcel.writeString(this.kPb);
        parcel.writeString(this.kPc);
        parcel.writeInt(this.kPd);
        parcel.writeInt(this.kPe ? 1 : 0);
        parcel.writeString(this.kPf);
        parcel.writeString(this.fwh);
        parcel.writeLong(this.kPg);
        parcel.writeString(this.kPh);
        parcel.writeTypedList(this.kPm);
        parcel.writeString(this.kPi);
        parcel.writeInt(this.kPk);
        parcel.writeString(this.kPl);
        parcel.writeParcelable(this.kPr, 1);
    }
}
