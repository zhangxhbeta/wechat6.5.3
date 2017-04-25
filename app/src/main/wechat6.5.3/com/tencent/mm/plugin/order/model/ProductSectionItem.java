package com.tencent.mm.plugin.order.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class ProductSectionItem implements Parcelable {
    public static final Creator<ProductSectionItem> CREATER = new Creator<ProductSectionItem>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ProductSectionItem(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ProductSectionItem[i];
        }
    };
    public int count;
    public List<Skus> hOu;
    public String hOv;
    public String hOw;
    public String iconUrl;
    public String jumpUrl;
    public String name;
    public int scene;

    public static class Skus implements Parcelable {
        public static final Creator<Skus> CREATER = new Creator<Skus>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new Skus(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new Skus[i];
            }
        };
        public String apU;
        public String value;

        public Skus(Parcel parcel) {
            this.apU = parcel.readString();
            this.value = parcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.apU);
            parcel.writeString(this.value);
        }

        public static String aS(List<Skus> list) {
            if (list == null || list.size() == 0) {
                return "";
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                Skus skus = (Skus) list.get(i);
                if (i != 0) {
                    stringBuilder.append("、");
                }
                stringBuilder.append(skus.value);
            }
            return stringBuilder.toString();
        }
    }

    public ProductSectionItem(Parcel parcel) {
        this.iconUrl = parcel.readString();
        this.name = parcel.readString();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.hOu = new ArrayList();
            for (int i = 0; i < readInt; i++) {
                Skus skus = new Skus();
                skus.apU = parcel.readString();
                skus.value = parcel.readString();
                this.hOu.add(skus);
            }
        }
        this.count = parcel.readInt();
        this.hOv = parcel.readString();
        this.jumpUrl = parcel.readString();
        this.hOw = parcel.readString();
        this.scene = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.name);
        if (this.hOu != null) {
            parcel.writeInt(this.hOu.size());
            for (int i2 = 0; i2 < this.hOu.size(); i2++) {
                Skus skus = (Skus) this.hOu.get(i2);
                parcel.writeString(skus.apU);
                parcel.writeString(skus.value);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.count);
        parcel.writeString(this.hOv);
        parcel.writeString(this.jumpUrl);
        parcel.writeString(this.hOw);
        parcel.writeInt(this.scene);
    }
}
