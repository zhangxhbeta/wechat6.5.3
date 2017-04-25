package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public final class WakeLockEvent implements SafeParcelable {
    public static final Creator<WakeLockEvent> CREATOR = new g();
    final long aqa;
    int aqb;
    final long aqi;
    private long aqk;
    final String aql;
    final int aqm;
    final List<String> aqn;
    final String aqo;
    int aqp;
    final String aqq;
    final String aqr;
    final float aqs;
    final int mVersionCode;

    WakeLockEvent(int i, long j, int i2, String str, int i3, List<String> list, String str2, long j2, int i4, String str3, String str4, float f) {
        this.mVersionCode = i;
        this.aqa = j;
        this.aqb = i2;
        this.aql = str;
        this.aqq = str3;
        this.aqm = i3;
        this.aqk = -1;
        this.aqn = list;
        this.aqo = str2;
        this.aqi = j2;
        this.aqp = i4;
        this.aqr = str4;
        this.aqs = f;
    }

    public WakeLockEvent(long j, int i, String str, int i2, List<String> list, String str2, long j2, int i3, String str3, String str4, float f) {
        this(1, j, i, str, i2, list, str2, j2, i3, str3, str4, f);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        g.a(this, parcel);
    }
}
