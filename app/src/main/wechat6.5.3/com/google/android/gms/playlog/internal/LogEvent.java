package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class LogEvent implements SafeParcelable {
    public static final a CREATOR = new a();
    public final long aBf;
    public final long aBg;
    public final byte[] aBh;
    public final Bundle aBi;
    public final String tag;
    public final int versionCode;

    LogEvent(int i, long j, long j2, String str, byte[] bArr, Bundle bundle) {
        this.versionCode = i;
        this.aBf = j;
        this.aBg = j2;
        this.tag = str;
        this.aBh = bArr;
        this.aBi = bundle;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("tag=").append(this.tag).append(",");
        stringBuilder.append("eventTime=").append(this.aBf).append(",");
        stringBuilder.append("eventUptime=").append(this.aBg).append(",");
        if (!(this.aBi == null || this.aBi.isEmpty())) {
            stringBuilder.append("keyValues=");
            for (String str : this.aBi.keySet()) {
                stringBuilder.append("(").append(str).append(",");
                stringBuilder.append(this.aBi.getString(str)).append(")");
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        a.a(this, parcel);
    }
}
