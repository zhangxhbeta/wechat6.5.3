package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.v;
import com.google.android.gms.common.internal.w;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Credential implements SafeParcelable {
    public static final Creator<Credential> CREATOR = new a();
    final String afy;
    final String ajo;
    final String ajp;
    final Uri ajq;
    final List<IdToken> ajr;
    final String ajs;
    final String ajt;
    final String aju;
    final String ajv;
    final String mName;
    final int mVersionCode;

    Credential(int i, String str, String str2, String str3, String str4, Uri uri, List<IdToken> list, String str5, String str6, String str7, String str8) {
        this.mVersionCode = i;
        this.ajo = str;
        this.ajp = str2;
        this.afy = (String) w.Z(str3);
        this.mName = str4;
        this.ajq = uri;
        this.ajr = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.ajs = str5;
        this.ajt = str6;
        this.aju = str7;
        this.ajv = str8;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Credential)) {
            return false;
        }
        Credential credential = (Credential) obj;
        return TextUtils.equals(this.afy, credential.afy) && TextUtils.equals(this.mName, credential.mName) && v.d(this.ajq, credential.ajq) && TextUtils.equals(this.ajs, credential.ajs) && TextUtils.equals(this.ajt, credential.ajt) && TextUtils.equals(this.aju, credential.aju);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.afy, this.mName, this.ajq, this.ajs, this.ajt, this.aju});
    }

    public void writeToParcel(Parcel parcel, int i) {
        a.a(this, parcel, i);
    }
}
