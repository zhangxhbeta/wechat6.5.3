package com.tencent.mm.plugin.wallet_payu.bind.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mm.wallet_core.d.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class NetScenePayUElementQuery extends a {
    public String kYp;
    public PayUBankcardElement kYr;

    public static class PayUBankcardElement implements Parcelable {
        public String bnG = "";
        public String ecR = "";
        public String hNe = "";
        public String kYs = "";
        public String kYt = "";

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.kYs);
            parcel.writeString(this.hNe);
            parcel.writeString(this.kYt);
            parcel.writeString(this.bnG);
            parcel.writeString(this.ecR);
        }
    }

    public NetScenePayUElementQuery(String str) {
        this.kYp = str;
        Map hashMap = new HashMap();
        hashMap.put("card_number", str);
        u(hashMap);
    }

    public final int bfC() {
        return 22;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.kYr = new PayUBankcardElement();
        this.kYr.kYs = jSONObject.optString("bin");
        this.kYr.hNe = jSONObject.optString("bank_name");
        this.kYr.kYt = jSONObject.optString("issuer_type");
        this.kYr.bnG = jSONObject.optString("card_type");
        this.kYr.ecR = jSONObject.optString("payu_reference");
    }
}
