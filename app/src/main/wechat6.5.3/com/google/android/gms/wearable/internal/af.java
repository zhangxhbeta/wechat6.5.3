package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public final class af implements Creator<PackageStorageInfo> {
    static void a(PackageStorageInfo packageStorageInfo, Parcel parcel) {
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, packageStorageInfo.versionCode);
        b.a(parcel, 2, packageStorageInfo.packageName);
        b.a(parcel, 3, packageStorageInfo.label);
        b.a(parcel, 4, packageStorageInfo.aFr);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        int b = a.b(parcel);
        int i = 0;
        long j = 0;
        String str2 = null;
        while (parcel.dataPosition() < b) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = a.e(parcel, readInt);
                    break;
                case 2:
                    str2 = a.k(parcel, readInt);
                    break;
                case 3:
                    str = a.k(parcel, readInt);
                    break;
                case 4:
                    j = a.f(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new PackageStorageInfo(i, str2, str, j);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new PackageStorageInfo[i];
    }
}
