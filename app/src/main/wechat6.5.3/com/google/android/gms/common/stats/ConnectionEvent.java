package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ConnectionEvent implements SafeParcelable {
    public static final Creator<ConnectionEvent> CREATOR = new a();
    final long aqa;
    int aqb;
    final String aqc;
    final String aqd;
    final String aqe;
    final String aqf;
    final String aqg;
    final String aqh;
    final long aqi;
    final long aqj;
    private long aqk;
    final int mVersionCode;

    ConnectionEvent(int i, long j, int i2, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this.mVersionCode = i;
        this.aqa = j;
        this.aqb = i2;
        this.aqc = str;
        this.aqd = str2;
        this.aqe = str3;
        this.aqf = str4;
        this.aqk = -1;
        this.aqg = str5;
        this.aqh = str6;
        this.aqi = j2;
        this.aqj = j3;
    }

    public ConnectionEvent(long j, int i, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this(1, j, i, str, str2, str3, str4, str5, str6, j2, j3);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        a.a(this, parcel);
    }
}
