package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.v;
import java.util.Arrays;

public final class Status implements g, SafeParcelable {
    public static final Creator<Status> CREATOR = new t();
    public static final Status ala = new Status(0);
    public static final Status alb = new Status(14);
    public static final Status alc = new Status(8);
    public static final Status ald = new Status(15);
    public static final Status ale = new Status(16);
    public final int akn;
    final PendingIntent ako;
    public final String alf;
    final int mVersionCode;

    public Status(int i) {
        this(i, null);
    }

    Status(int i, int i2, String str, PendingIntent pendingIntent) {
        this.mVersionCode = i;
        this.akn = i2;
        this.alf = str;
        this.ako = pendingIntent;
    }

    public Status(int i, String str) {
        this(1, i, str, null);
    }

    public Status(String str) {
        this(1, 8, str, null);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.mVersionCode == status.mVersionCode && this.akn == status.akn && v.d(this.alf, status.alf) && v.d(this.ako, status.ako);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.mVersionCode), Integer.valueOf(this.akn), this.alf, this.ako});
    }

    public final boolean iY() {
        return this.akn <= 0;
    }

    public final Status jo() {
        return this;
    }

    public final String toString() {
        return v.Y(this).h("statusCode", this.alf != null ? this.alf : b.bG(this.akn)).h("resolution", this.ako).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        t.a(this, parcel, i);
    }
}
