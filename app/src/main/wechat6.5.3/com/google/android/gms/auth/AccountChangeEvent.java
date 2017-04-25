package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.v;
import com.google.android.gms.common.internal.w;
import java.util.Arrays;

public class AccountChangeEvent implements SafeParcelable {
    public static final Creator<AccountChangeEvent> CREATOR = new e();
    final int ajd;
    final long aje;
    final String ajf;
    final int ajg;
    final int ajh;
    final String aji;

    AccountChangeEvent(int i, long j, String str, int i2, int i3, String str2) {
        this.ajd = i;
        this.aje = j;
        this.ajf = (String) w.Z(str);
        this.ajg = i2;
        this.ajh = i3;
        this.aji = str2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AccountChangeEvent)) {
            return false;
        }
        AccountChangeEvent accountChangeEvent = (AccountChangeEvent) obj;
        return this.ajd == accountChangeEvent.ajd && this.aje == accountChangeEvent.aje && v.d(this.ajf, accountChangeEvent.ajf) && this.ajg == accountChangeEvent.ajg && this.ajh == accountChangeEvent.ajh && v.d(this.aji, accountChangeEvent.aji);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.ajd), Long.valueOf(this.aje), this.ajf, Integer.valueOf(this.ajg), Integer.valueOf(this.ajh), this.aji});
    }

    public String toString() {
        String str = "UNKNOWN";
        switch (this.ajg) {
            case 1:
                str = "ADDED";
                break;
            case 2:
                str = "REMOVED";
                break;
            case 3:
                str = "RENAMED_FROM";
                break;
            case 4:
                str = "RENAMED_TO";
                break;
        }
        return "AccountChangeEvent {accountName = " + this.ajf + ", changeType = " + str + ", changeData = " + this.aji + ", eventIndex = " + this.ajh + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        e.a(this, parcel);
    }
}
