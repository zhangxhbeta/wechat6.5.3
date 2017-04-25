package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public final class n implements Creator<GetCloudSyncSettingResponse> {
    static void a(GetCloudSyncSettingResponse getCloudSyncSettingResponse, Parcel parcel) {
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, getCloudSyncSettingResponse.versionCode);
        b.c(parcel, 2, getCloudSyncSettingResponse.statusCode);
        b.a(parcel, 3, getCloudSyncSettingResponse.enabled);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        boolean z = false;
        int b = a.b(parcel);
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
                    z = a.c(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GetCloudSyncSettingResponse(i2, i, z);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new GetCloudSyncSettingResponse[i];
    }
}
