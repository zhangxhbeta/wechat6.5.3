package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.a.a.k;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.v;
import com.google.android.gms.common.internal.v.a;
import java.util.Arrays;

public final class ConnectionResult implements SafeParcelable {
    public static final Creator<ConnectionResult> CREATOR = new i();
    public static final ConnectionResult akm = new ConnectionResult(0, null);
    public final int akn;
    public final PendingIntent ako;
    final int mVersionCode;

    ConnectionResult(int i, int i2, PendingIntent pendingIntent) {
        this.mVersionCode = i;
        this.akn = i2;
        this.ako = pendingIntent;
    }

    public ConnectionResult(int i, PendingIntent pendingIntent) {
        this(1, i, pendingIntent);
    }

    public final void a(Activity activity, int i) {
        if (iX()) {
            activity.startIntentSenderForResult(this.ako.getIntentSender(), i, null, 0, 0, 0);
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.akn == connectionResult.akn && v.d(this.ako, connectionResult.ako);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.akn), this.ako});
    }

    public final boolean iX() {
        return (this.akn == 0 || this.ako == null) ? false : true;
    }

    public final boolean iY() {
        return this.akn == 0;
    }

    public final String toString() {
        Object obj;
        a Y = v.Y(this);
        String str = "statusCode";
        int i = this.akn;
        switch (i) {
            case 0:
                obj = "SUCCESS";
                break;
            case 1:
                obj = "SERVICE_MISSING";
                break;
            case 2:
                obj = "SERVICE_VERSION_UPDATE_REQUIRED";
                break;
            case 3:
                obj = "SERVICE_DISABLED";
                break;
            case 4:
                obj = "SIGN_IN_REQUIRED";
                break;
            case 5:
                obj = "INVALID_ACCOUNT";
                break;
            case 6:
                obj = "RESOLUTION_REQUIRED";
                break;
            case 7:
                obj = "NETWORK_ERROR";
                break;
            case 8:
                obj = "INTERNAL_ERROR";
                break;
            case 9:
                obj = "SERVICE_INVALID";
                break;
            case 10:
                obj = "DEVELOPER_ERROR";
                break;
            case 11:
                obj = "LICENSE_CHECK_FAILED";
                break;
            case 13:
                obj = "CANCELED";
                break;
            case 14:
                obj = "TIMEOUT";
                break;
            case 15:
                obj = "INTERRUPTED";
                break;
            case 16:
                obj = "API_UNAVAILABLE";
                break;
            case 17:
                obj = "SIGN_IN_FAILED";
                break;
            case k.MG /*18*/:
                obj = "SERVICE_UPDATING";
                break;
            default:
                obj = "UNKNOWN_ERROR_CODE(" + i + ")";
                break;
        }
        return Y.h(str, obj).h("resolution", this.ako).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i.a(this, parcel, i);
    }
}
