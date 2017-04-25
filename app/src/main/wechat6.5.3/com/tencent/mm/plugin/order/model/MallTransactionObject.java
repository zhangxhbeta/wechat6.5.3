package com.tencent.mm.plugin.order.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.HelpCenter;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class MallTransactionObject implements Parcelable {
    public static final Creator<MallTransactionObject> CREATOR = new Creator<MallTransactionObject>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new MallTransactionObject(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MallTransactionObject[i];
        }
    };
    public int aTg;
    public int aYp;
    public int cLB;
    public String dDo;
    public String desc;
    public String eWA;
    public double eWz = 0.0d;
    public List<HelpCenter> hMG = new LinkedList();
    public int hMH = -1;
    public String hMJ;
    public int hMR;
    public String hMS;
    public String hMT;
    public String hMU;
    public String hMV;
    public String hMW;
    public String hMX;
    public String hMY;
    public String hMZ;
    public int hNA;
    public String hNB;
    public String hNC;
    public String hND;
    public String hNE;
    public String hNF;
    public String hNG;
    public double hNH;
    public String hNI;
    public String hNa;
    public String hNb;
    public int hNc;
    public String hNd;
    public String hNe;
    public String hNf;
    public String hNg;
    public String hNh;
    public String hNi;
    public String hNj;
    public String hNk;
    public String hNl;
    public double hNm;
    public String hNn;
    public String hNo;
    public String hNp;
    public String hNq;
    public String hNr;
    public int hNs;
    public int hNt;
    public double hNu;
    public String hNv;
    public int hNw;
    public String hNx;
    public int hNy;
    public int hNz;
    public int type;

    public int describeContents() {
        return 0;
    }

    public MallTransactionObject(Parcel parcel) {
        this.aYp = parcel.readInt();
        this.hMR = parcel.readInt();
        this.aTg = parcel.readInt();
        this.hMS = parcel.readString();
        this.hMT = parcel.readString();
        this.hMU = parcel.readString();
        this.hMV = parcel.readString();
        this.desc = parcel.readString();
        this.hMW = parcel.readString();
        this.hMX = parcel.readString();
        this.eWz = parcel.readDouble();
        this.hMY = parcel.readString();
        this.hMZ = parcel.readString();
        this.hNa = parcel.readString();
        this.hNb = parcel.readString();
        this.cLB = parcel.readInt();
        this.hNc = parcel.readInt();
        this.eWA = parcel.readString();
        this.hNd = parcel.readString();
        this.hNe = parcel.readString();
        this.hNg = parcel.readString();
        this.hNh = parcel.readString();
        this.hMJ = parcel.readString();
        this.hNi = parcel.readString();
        this.dDo = parcel.readString();
        this.hNj = parcel.readString();
        this.hNk = parcel.readString();
        this.hNl = parcel.readString();
        this.hNm = parcel.readDouble();
        this.hNn = parcel.readString();
        this.hNo = parcel.readString();
        this.hNp = parcel.readString();
        this.hNq = parcel.readString();
        this.hNs = parcel.readInt();
        this.hNy = parcel.readInt();
        this.hNu = parcel.readDouble();
        this.hNv = parcel.readString();
        this.hNw = parcel.readInt();
        this.hNx = parcel.readString();
        this.hNy = parcel.readInt();
        this.hNz = parcel.readInt();
        this.hNA = parcel.readInt();
        this.hNB = parcel.readString();
        this.hNC = parcel.readString();
        this.hND = parcel.readString();
        this.hNE = parcel.readString();
        this.hNF = parcel.readString();
        this.hNG = parcel.readString();
        this.hNH = parcel.readDouble();
        this.hNI = parcel.readString();
        this.hNr = parcel.readString();
        this.hMH = parcel.readInt();
        int readInt = parcel.readInt();
        this.hMG = new LinkedList();
        for (int i = 0; i < readInt; i++) {
            this.hMG.add((HelpCenter) parcel.readParcelable(HelpCenter.class.getClassLoader()));
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.aYp);
        parcel.writeInt(this.hMR);
        parcel.writeInt(this.aTg);
        parcel.writeString(this.hMS);
        parcel.writeString(this.hMT);
        parcel.writeString(this.hMU);
        parcel.writeString(this.hMV);
        parcel.writeString(this.desc);
        parcel.writeString(this.hMW);
        parcel.writeString(this.hMX);
        parcel.writeDouble(this.eWz);
        parcel.writeString(this.hMY);
        parcel.writeString(this.hMZ);
        parcel.writeString(this.hNa);
        parcel.writeString(this.hNb);
        parcel.writeInt(this.cLB);
        parcel.writeInt(this.hNc);
        parcel.writeString(this.eWA);
        parcel.writeString(this.hNd);
        parcel.writeString(this.hNe);
        parcel.writeString(this.hNg);
        parcel.writeString(this.hNh);
        parcel.writeString(this.hMJ);
        parcel.writeString(this.hNi);
        parcel.writeString(this.dDo);
        parcel.writeString(this.hNj);
        parcel.writeString(this.hNk);
        parcel.writeString(this.hNl);
        parcel.writeDouble(this.hNm);
        parcel.writeString(this.hNn);
        parcel.writeString(this.hNo);
        parcel.writeString(this.hNp);
        parcel.writeString(this.hNq);
        parcel.writeInt(this.hNs);
        parcel.writeInt(this.hNy);
        parcel.writeDouble(this.hNu);
        parcel.writeString(this.hNv);
        parcel.writeInt(this.hNw);
        parcel.writeString(this.hNx);
        parcel.writeInt(this.hNy);
        parcel.writeInt(this.hNz);
        parcel.writeInt(this.hNA);
        parcel.writeString(this.hNB);
        parcel.writeString(this.hNC);
        parcel.writeString(this.hND);
        parcel.writeString(this.hNE);
        parcel.writeString(this.hNF);
        parcel.writeString(this.hNG);
        parcel.writeDouble(this.hNH);
        parcel.writeString(this.hNI);
        parcel.writeString(this.hNr);
        parcel.writeInt(this.hMH);
        parcel.writeInt(this.hMG.size());
        for (HelpCenter writeParcelable : this.hMG) {
            parcel.writeParcelable(writeParcelable, i);
        }
    }

    public static MallTransactionObject v(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        MallTransactionObject mallTransactionObject = new MallTransactionObject();
        mallTransactionObject.type = jSONObject.optInt("rec_type", 1);
        mallTransactionObject.aYp = jSONObject.optInt("sub_pay_type", 0);
        mallTransactionObject.hMR = jSONObject.optInt("pay_scene");
        mallTransactionObject.aTg = jSONObject.optInt("user_type");
        mallTransactionObject.hMS = jSONObject.optString("buy_uin");
        mallTransactionObject.hMT = jSONObject.optString("buy_name");
        mallTransactionObject.hMU = jSONObject.optString("sale_uin");
        mallTransactionObject.hMV = jSONObject.optString("sale_name");
        mallTransactionObject.eWA = jSONObject.optString("trans_id");
        mallTransactionObject.hNd = jSONObject.optString("sp_billno");
        mallTransactionObject.desc = jSONObject.optString("goods_name");
        mallTransactionObject.hMW = jSONObject.optString("goods_detail");
        mallTransactionObject.eWz = jSONObject.optDouble("fee") / 100.0d;
        mallTransactionObject.hMY = jSONObject.optString("fee_color");
        mallTransactionObject.hMZ = jSONObject.optString("trade_state");
        mallTransactionObject.hNa = jSONObject.optString("trade_state_name");
        mallTransactionObject.hNb = jSONObject.optString("trade_state_color");
        mallTransactionObject.hNe = jSONObject.optString("buy_bank_name");
        mallTransactionObject.hNf = jSONObject.optString("card_tail");
        mallTransactionObject.cLB = jSONObject.optInt("create_timestamp");
        mallTransactionObject.hNc = jSONObject.optInt("modify_timestamp");
        mallTransactionObject.hNg = jSONObject.optString("fee_type");
        JSONObject optJSONObject = jSONObject.optJSONObject("appinfo");
        if (optJSONObject != null) {
            mallTransactionObject.hNh = optJSONObject.optString("app_username");
            mallTransactionObject.hMJ = optJSONObject.optString("app_telephone");
            mallTransactionObject.hNi = optJSONObject.optString("app_nickname");
            mallTransactionObject.dDo = optJSONObject.optString("app_icon_url");
            mallTransactionObject.hNq = optJSONObject.optString("safeguard_url");
            mallTransactionObject.hNr = optJSONObject.optString(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME);
        }
        mallTransactionObject.hNj = jSONObject.optString("deliver_price");
        mallTransactionObject.hNk = jSONObject.optString("preferential_price");
        mallTransactionObject.hNl = jSONObject.optString("discount");
        mallTransactionObject.hNm = jSONObject.optDouble("original_total_fee") / 100.0d;
        mallTransactionObject.hNn = jSONObject.optString("total_price");
        mallTransactionObject.hNo = jSONObject.optString("receipt_company");
        mallTransactionObject.hNp = jSONObject.optString("biz_pledge");
        mallTransactionObject.hNs = jSONObject.optInt("pre_fetch_timestamp");
        mallTransactionObject.hNt = jSONObject.optInt("arrived_timestamp");
        mallTransactionObject.hNu = jSONObject.optDouble("transfer_fee") / 100.0d;
        mallTransactionObject.hNv = jSONObject.optString("receiver_name");
        mallTransactionObject.hNw = jSONObject.optInt("allow_resend_msg");
        mallTransactionObject.hNx = jSONObject.optString("charge_fee");
        mallTransactionObject.hNy = jSONObject.optInt("receive_timestamp");
        mallTransactionObject.hNz = jSONObject.optInt("refund_timestamp");
        mallTransactionObject.hNA = jSONObject.optInt("create_timestamp");
        mallTransactionObject.hNB = jSONObject.optString("buy_bank_type");
        mallTransactionObject.hNC = jSONObject.optString("payer_name");
        mallTransactionObject.hND = jSONObject.optString("true_name");
        mallTransactionObject.hNE = jSONObject.optString("refund_bank_type");
        mallTransactionObject.hNF = jSONObject.optString("rateinfo");
        mallTransactionObject.hNG = jSONObject.optString("original_feeinfo");
        mallTransactionObject.hNH = jSONObject.optDouble("fetch_total_fee") / 100.0d;
        mallTransactionObject.hNI = jSONObject.optString("fetch_total_fee_color");
        mallTransactionObject.hMH = jSONObject.optInt("userroll_type");
        mallTransactionObject.hMG = w(jSONObject);
        return mallTransactionObject;
    }

    private static List<HelpCenter> w(JSONObject jSONObject) {
        List<HelpCenter> linkedList = new LinkedList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("help_center");
            for (int i = 0; i < jSONArray.length(); i++) {
                HelpCenter helpCenter = new HelpCenter();
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                helpCenter.fJm = jSONObject2.optBoolean("is_show_button");
                helpCenter.name = jSONObject2.optString("name");
                helpCenter.url = jSONObject2.optString("url");
                linkedList.add(helpCenter);
            }
        } catch (Throwable e) {
            v.a("MicroMsg.MallTransactionObject", e, "", new Object[0]);
            v.e("MicroMsg.MallTransactionObject", "parseHelpCenter error %s", new Object[]{e.getMessage()});
        }
        return linkedList;
    }
}
