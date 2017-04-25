package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public final class e implements Creator<SafeParcelResponse> {
    static void a(SafeParcelResponse safeParcelResponse, Parcel parcel, int i) {
        Parcelable parcelable;
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, safeParcelResponse.mVersionCode);
        Parcel kq = safeParcelResponse.kq();
        if (kq != null) {
            int t2 = b.t(parcel, 2);
            parcel.appendFrom(kq, 0, kq.dataSize());
            b.u(parcel, t2);
        }
        switch (safeParcelResponse.apX) {
            case 0:
                parcelable = null;
                break;
            case 1:
                parcelable = safeParcelResponse.apO;
                break;
            case 2:
                parcelable = safeParcelResponse.apO;
                break;
            default:
                throw new IllegalStateException("Invalid creation type: " + safeParcelResponse.apX);
        }
        b.a(parcel, 3, parcelable, i);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        FieldMappingDictionary fieldMappingDictionary = null;
        int b = a.b(parcel);
        int i = 0;
        Parcel parcel2 = null;
        while (parcel.dataPosition() < b) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = a.e(parcel, readInt);
                    break;
                case 2:
                    parcel2 = a.r(parcel, readInt);
                    break;
                case 3:
                    fieldMappingDictionary = (FieldMappingDictionary) a.a(parcel, readInt, FieldMappingDictionary.CREATOR);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new SafeParcelResponse(i, parcel2, fieldMappingDictionary);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new SafeParcelResponse[i];
    }
}
