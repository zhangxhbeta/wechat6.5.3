package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.w;

public final class CredentialRequest implements SafeParcelable {
    public static final Creator<CredentialRequest> CREATOR = new c();
    final CredentialPickerConfig ajA;
    final CredentialPickerConfig ajB;
    final boolean ajy;
    final String[] ajz;
    final int mVersionCode;

    CredentialRequest(int i, boolean z, String[] strArr, CredentialPickerConfig credentialPickerConfig, CredentialPickerConfig credentialPickerConfig2) {
        this.mVersionCode = i;
        this.ajy = z;
        this.ajz = (String[]) w.Z(strArr);
        if (credentialPickerConfig == null) {
            credentialPickerConfig = new a().iT();
        }
        this.ajA = credentialPickerConfig;
        if (credentialPickerConfig2 == null) {
            credentialPickerConfig2 = new a().iT();
        }
        this.ajB = credentialPickerConfig2;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        c.a(this, parcel, i);
    }
}
