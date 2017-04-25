package com.google.android.gms.auth.api.signin;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.ArrayList;

public final class b implements Creator<FacebookSignInConfig> {
    static void a(FacebookSignInConfig facebookSignInConfig, Parcel parcel, int i) {
        int t = com.google.android.gms.common.internal.safeparcel.b.t(parcel, 20293);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1, facebookSignInConfig.versionCode);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, facebookSignInConfig.OH, i);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, new ArrayList(facebookSignInConfig.akf));
        com.google.android.gms.common.internal.safeparcel.b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = a.b(parcel);
        Intent intent = null;
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < b) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = a.e(parcel, readInt);
                    break;
                case 2:
                    intent = (Intent) a.a(parcel, readInt, Intent.CREATOR);
                    break;
                case 3:
                    arrayList = a.q(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new FacebookSignInConfig(i, intent, arrayList);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new FacebookSignInConfig[i];
    }
}
