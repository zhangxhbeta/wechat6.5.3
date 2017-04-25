package com.tencent.mm.plugin.order.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.order.model.ProductSectionItem.Skus;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class MallOrderDetailObject {
    public String fCO;
    public String gcD;
    public MallTransactionObject hMC;
    public b hMD;
    public ArrayList<ProductSectionItem> hME;
    public List<a> hMF;
    public List<HelpCenter> hMG = new LinkedList();
    int hMH = -1;
    public String hMI;
    public String hMJ;
    public int hMK;

    public static class HelpCenter implements Parcelable {
        public static final Creator<HelpCenter> CREATOR = new Creator<HelpCenter>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new HelpCenter(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new HelpCenter[i];
            }
        };
        public boolean fJm;
        public String name;
        public String url;

        protected HelpCenter() {
        }

        protected HelpCenter(Parcel parcel) {
            this.name = parcel.readString();
            this.url = parcel.readString();
            this.fJm = parcel.readByte() != (byte) 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.name);
            parcel.writeString(this.url);
            parcel.writeByte((byte) (this.fJm ? 1 : 0));
        }

        public int describeContents() {
            return 0;
        }
    }

    public static class a {
        public boolean eBV;
        public int jumpType;
        public String jumpUrl;
        public String name;
        public int type = 0;
        public String value;
    }

    public static class b {
        public String bea;
        public String gkT;
        public String hML;
        public String hMM;
        public int hrm;
    }

    static ArrayList<ProductSectionItem> t(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject.getJSONObject("product_section");
        if (jSONObject2 == null) {
            return null;
        }
        JSONArray jSONArray = jSONObject2.getJSONArray("items");
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        ArrayList<ProductSectionItem> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject3 = jSONArray.getJSONObject(i);
            ProductSectionItem productSectionItem = new ProductSectionItem();
            productSectionItem.iconUrl = jSONObject3.optString("icon_url");
            productSectionItem.name = jSONObject3.optString("name");
            try {
                productSectionItem.hOu = u(jSONObject3);
            } catch (Throwable e) {
                v.a("MicroMsg.MallOrderDetailObject", e, "", new Object[0]);
            } catch (Throwable e2) {
                v.a("MicroMsg.MallOrderDetailObject", e2, "", new Object[0]);
            }
            productSectionItem.count = jSONObject3.optInt("count");
            productSectionItem.hOv = jSONObject3.optString("price");
            productSectionItem.jumpUrl = jSONObject3.optString("jump_url");
            productSectionItem.hOw = jSONObject3.optString("pid");
            productSectionItem.scene = jSONObject3.optInt("scene");
            arrayList.add(productSectionItem);
        }
        return arrayList;
    }

    private static List<Skus> u(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONArray("skus");
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        List<Skus> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            Skus skus = new Skus();
            skus.apU = jSONObject2.optString("key");
            skus.value = jSONObject2.optString("value");
            arrayList.add(skus);
        }
        return arrayList;
    }
}
