package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public final class m implements Creator<GetCloudSyncOptInStatusResponse> {
    static void a(GetCloudSyncOptInStatusResponse getCloudSyncOptInStatusResponse, Parcel parcel) {
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, getCloudSyncOptInStatusResponse.versionCode);
        b.c(parcel, 2, getCloudSyncOptInStatusResponse.statusCode);
        b.a(parcel, 3, getCloudSyncOptInStatusResponse.aFg);
        b.a(parcel, 4, getCloudSyncOptInStatusResponse.aFh);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        boolean z = false;
        int b = a.b(parcel);
        boolean z2 = false;
        int i = 0;
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
                    z2 = a.c(parcel, readInt);
                    break;
                case 4:
                    z = a.c(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GetCloudSyncOptInStatusResponse(i2, i, z2, z);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new GetCloudSyncOptInStatusResponse[i];
    }
}
