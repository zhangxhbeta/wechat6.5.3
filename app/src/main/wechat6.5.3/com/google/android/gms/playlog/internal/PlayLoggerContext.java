package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.v;
import java.util.Arrays;

public class PlayLoggerContext implements SafeParcelable {
    public static final b CREATOR = new b();
    public final int aBj;
    public final int aBk;
    public final String aBl;
    public final String aBm;
    public final boolean aBn;
    public final String aBo;
    public final boolean aBp;
    public final int aBq;
    public final String packageName;
    public final int versionCode;

    public PlayLoggerContext(int i, String str, int i2, int i3, String str2, String str3, boolean z, String str4, boolean z2, int i4) {
        this.versionCode = i;
        this.packageName = str;
        this.aBj = i2;
        this.aBk = i3;
        this.aBl = str2;
        this.aBm = str3;
        this.aBn = z;
        this.aBo = str4;
        this.aBp = z2;
        this.aBq = i4;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayLoggerContext)) {
            return false;
        }
        PlayLoggerContext playLoggerContext = (PlayLoggerContext) obj;
        return this.versionCode == playLoggerContext.versionCode && this.packageName.equals(playLoggerContext.packageName) && this.aBj == playLoggerContext.aBj && this.aBk == playLoggerContext.aBk && v.d(this.aBo, playLoggerContext.aBo) && v.d(this.aBl, playLoggerContext.aBl) && v.d(this.aBm, playLoggerContext.aBm) && this.aBn == playLoggerContext.aBn && this.aBp == playLoggerContext.aBp && this.aBq == playLoggerContext.aBq;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.versionCode), this.packageName, Integer.valueOf(this.aBj), Integer.valueOf(this.aBk), this.aBo, this.aBl, this.aBm, Boolean.valueOf(this.aBn), Boolean.valueOf(this.aBp), Integer.valueOf(this.aBq)});
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PlayLoggerContext[");
        stringBuilder.append("versionCode=").append(this.versionCode).append(',');
        stringBuilder.append("package=").append(this.packageName).append(',');
        stringBuilder.append("packageVersionCode=").append(this.aBj).append(',');
        stringBuilder.append("logSource=").append(this.aBk).append(',');
        stringBuilder.append("logSourceName=").append(this.aBo).append(',');
        stringBuilder.append("uploadAccount=").append(this.aBl).append(',');
        stringBuilder.append("loggingId=").append(this.aBm).append(',');
        stringBuilder.append("logAndroidId=").append(this.aBn).append(',');
        stringBuilder.append("isAnonymous=").append(this.aBp).append(',');
        stringBuilder.append("qosTier=").append(this.aBq);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        b.a(this, parcel);
    }
}
