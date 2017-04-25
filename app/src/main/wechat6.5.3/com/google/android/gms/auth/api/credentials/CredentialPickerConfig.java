package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class CredentialPickerConfig implements SafeParcelable {
    public static final Creator<CredentialPickerConfig> CREATOR = new b();
    final boolean ajw;
    final boolean ajx;
    final int mVersionCode;

    public static class a {
        boolean ajw = false;
        boolean ajx = true;

        public final CredentialPickerConfig iT() {
            return new CredentialPickerConfig();
        }
    }

    CredentialPickerConfig(int i, boolean z, boolean z2) {
        this.mVersionCode = i;
        this.ajw = z;
        this.ajx = z2;
    }

    private CredentialPickerConfig(a aVar) {
        this(1, aVar.ajw, aVar.ajx);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        b.a(this, parcel);
    }
}
