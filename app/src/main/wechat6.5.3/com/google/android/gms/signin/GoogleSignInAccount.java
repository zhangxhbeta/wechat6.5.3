package com.google.android.gms.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.w;

public class GoogleSignInAccount implements SafeParcelable {
    public static final Creator<GoogleSignInAccount> CREATOR = new a();
    String aBr;
    String aBs;
    Uri aBt;
    String afy;
    String ajC;
    final int versionCode;

    GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri) {
        this.versionCode = i;
        this.afy = w.U(str);
        this.ajC = str2;
        this.aBr = str3;
        this.aBs = str4;
        this.aBt = uri;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        a.a(this, parcel, i);
    }
}
