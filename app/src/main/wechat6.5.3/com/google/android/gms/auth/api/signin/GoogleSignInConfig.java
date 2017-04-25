package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;

public class GoogleSignInConfig implements SafeParcelable {
    public static final Creator<GoogleSignInConfig> CREATOR = new c();
    final ArrayList<Scope> akf;
    final int versionCode;

    public GoogleSignInConfig() {
        this(1, new ArrayList());
    }

    GoogleSignInConfig(int i, ArrayList<Scope> arrayList) {
        this.versionCode = i;
        this.akf = arrayList;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        c.a(this, parcel);
    }
}
