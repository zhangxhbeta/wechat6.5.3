package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public final class h implements Creator<GetAllCapabilitiesResponse> {
    static void a(GetAllCapabilitiesResponse getAllCapabilitiesResponse, Parcel parcel) {
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, getAllCapabilitiesResponse.versionCode);
        b.c(parcel, 2, getAllCapabilitiesResponse.statusCode);
        b.b(parcel, 3, getAllCapabilitiesResponse.aFc);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = 0;
        int b = a.b(parcel);
        List list = null;
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
                case 3:
                    list = a.c(parcel, readInt, CapabilityInfoParcelable.CREATOR);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GetAllCapabilitiesResponse(i2, i, list);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new GetAllCapabilitiesResponse[i];
    }
}
