package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public final class ai implements Creator<RemoveLocalCapabilityResponse> {
    static void a(RemoveLocalCapabilityResponse removeLocalCapabilityResponse, Parcel parcel) {
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, removeLocalCapabilityResponse.versionCode);
        b.c(parcel, 2, removeLocalCapabilityResponse.statusCode);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = 0;
        int b = a.b(parcel);
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i2 = a.e(parcel, readInt);
                    break;
                case 2:
                    i = a.e(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new RemoveLocalCapabilityResponse(i2, i);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new RemoveLocalCapabilityResponse[i];
    }
}
