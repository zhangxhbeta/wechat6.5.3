package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AncsNotificationParcelable implements SafeParcelable {
    public static final Creator<AncsNotificationParcelable> CREATOR = new av();
    String aBs;
    final String aEL;
    final String aEM;
    final String aEN;
    final String aEO;
    byte aEP;
    byte aEQ;
    byte aER;
    byte aES;
    final String azg;
    int dW;
    final int mVersionCode;

    AncsNotificationParcelable(int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, byte b, byte b2, byte b3, byte b4) {
        this.dW = i2;
        this.mVersionCode = i;
        this.azg = str;
        this.aEL = str2;
        this.aEM = str3;
        this.aEN = str4;
        this.aEO = str5;
        this.aBs = str6;
        this.aEP = b;
        this.aEQ = b2;
        this.aER = b3;
        this.aES = b4;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AncsNotificationParcelable ancsNotificationParcelable = (AncsNotificationParcelable) obj;
        return this.aES != ancsNotificationParcelable.aES ? false : this.aER != ancsNotificationParcelable.aER ? false : this.aEQ != ancsNotificationParcelable.aEQ ? false : this.aEP != ancsNotificationParcelable.aEP ? false : this.dW != ancsNotificationParcelable.dW ? false : this.mVersionCode != ancsNotificationParcelable.mVersionCode ? false : !this.azg.equals(ancsNotificationParcelable.azg) ? false : (this.aEL == null ? ancsNotificationParcelable.aEL != null : !this.aEL.equals(ancsNotificationParcelable.aEL)) ? false : !this.aBs.equals(ancsNotificationParcelable.aBs) ? false : !this.aEM.equals(ancsNotificationParcelable.aEM) ? false : !this.aEO.equals(ancsNotificationParcelable.aEO) ? false : this.aEN.equals(ancsNotificationParcelable.aEN);
    }

    public int hashCode() {
        return (((((((((((((((((this.aEL != null ? this.aEL.hashCode() : 0) + (((((this.mVersionCode * 31) + this.dW) * 31) + this.azg.hashCode()) * 31)) * 31) + this.aEM.hashCode()) * 31) + this.aEN.hashCode()) * 31) + this.aEO.hashCode()) * 31) + this.aBs.hashCode()) * 31) + this.aEP) * 31) + this.aEQ) * 31) + this.aER) * 31) + this.aES;
    }

    public String toString() {
        return "AncsNotificationParcelable{mVersionCode=" + this.mVersionCode + ", mId=" + this.dW + ", mAppId='" + this.azg + '\'' + ", mDateTime='" + this.aEL + '\'' + ", mNotificationText='" + this.aEM + '\'' + ", mTitle='" + this.aEN + '\'' + ", mSubtitle='" + this.aEO + '\'' + ", mDisplayName='" + this.aBs + '\'' + ", mEventId=" + this.aEP + ", mEventFlags=" + this.aEQ + ", mCategoryId=" + this.aER + ", mCategoryCount=" + this.aES + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        av.a(this, parcel);
    }
}
