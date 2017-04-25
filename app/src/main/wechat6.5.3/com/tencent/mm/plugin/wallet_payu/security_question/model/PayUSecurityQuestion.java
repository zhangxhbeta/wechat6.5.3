package com.tencent.mm.plugin.wallet_payu.security_question.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PayUSecurityQuestion implements Parcelable {
    public static final Creator<PayUSecurityQuestion> CREATOR = new Creator<PayUSecurityQuestion>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PayUSecurityQuestion(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PayUSecurityQuestion[i];
        }
    };
    public String desc;
    public String id;

    public PayUSecurityQuestion(String str, String str2) {
        this.id = str;
        this.desc = str2;
    }

    public PayUSecurityQuestion(Parcel parcel) {
        this.id = parcel.readString();
        this.desc = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.desc);
    }
}
