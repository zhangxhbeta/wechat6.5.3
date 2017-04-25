package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.EmailSignInConfig;
import com.google.android.gms.auth.api.signin.FacebookSignInConfig;
import com.google.android.gms.auth.api.signin.GoogleSignInConfig;
import com.google.android.gms.common.internal.safeparcel.b;

public final class a implements Creator<SignInConfiguration> {
    static void a(SignInConfiguration signInConfiguration, Parcel parcel, int i) {
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, signInConfiguration.versionCode);
        b.a(parcel, 2, signInConfiguration.akg);
        b.a(parcel, 3, signInConfiguration.akh);
        b.a(parcel, 4, signInConfiguration.aki, i);
        b.a(parcel, 5, signInConfiguration.akj, i);
        b.a(parcel, 6, signInConfiguration.akk, i);
        b.a(parcel, 7, signInConfiguration.akl);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        int b = com.google.android.gms.common.internal.safeparcel.a.b(parcel);
        int i = 0;
        FacebookSignInConfig facebookSignInConfig = null;
        GoogleSignInConfig googleSignInConfig = null;
        EmailSignInConfig emailSignInConfig = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < b) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.a.e(parcel, readInt);
                    break;
                case 2:
                    str3 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                case 4:
                    emailSignInConfig = (EmailSignInConfig) com.google.android.gms.common.internal.safeparcel.a.a(parcel, readInt, EmailSignInConfig.CREATOR);
                    break;
                case 5:
                    googleSignInConfig = (GoogleSignInConfig) com.google.android.gms.common.internal.safeparcel.a.a(parcel, readInt, GoogleSignInConfig.CREATOR);
                    break;
                case 6:
                    facebookSignInConfig = (FacebookSignInConfig) com.google.android.gms.common.internal.safeparcel.a.a(parcel, readInt, FacebookSignInConfig.CREATOR);
                    break;
                case 7:
                    str = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new SignInConfiguration(i, str3, str2, emailSignInConfig, googleSignInConfig, facebookSignInConfig, str);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + b, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new SignInConfiguration[i];
    }
}
