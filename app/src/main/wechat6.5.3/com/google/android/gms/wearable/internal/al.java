package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public final class al implements Creator<StorageInfoResponse> {
    static void a(StorageInfoResponse storageInfoResponse, Parcel parcel) {
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, storageInfoResponse.versionCode);
        b.c(parcel, 2, storageInfoResponse.statusCode);
        b.a(parcel, 3, storageInfoResponse.aFr);
        b.b(parcel, 4, storageInfoResponse.aFs);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = 0;
        int b = a.b(parcel);
        long j = 0;
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
                    j = a.f(parcel, readInt);
                    break;
                case 4:
                    list = a.c(parcel, readInt, PackageStorageInfo.CREATOR);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new StorageInfoResponse(i2, i, j, list);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new StorageInfoResponse[i];
    }
}
