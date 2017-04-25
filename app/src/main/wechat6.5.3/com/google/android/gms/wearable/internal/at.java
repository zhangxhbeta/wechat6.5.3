package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public final class at implements Creator<AmsEntityUpdateParcelable> {
    static void a(AmsEntityUpdateParcelable amsEntityUpdateParcelable, Parcel parcel) {
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, amsEntityUpdateParcelable.mVersionCode);
        b.a(parcel, 2, amsEntityUpdateParcelable.aEJ);
        b.a(parcel, 3, amsEntityUpdateParcelable.aEK);
        b.a(parcel, 4, amsEntityUpdateParcelable.mValue);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        byte b = (byte) 0;
        int b2 = a.b(parcel);
        String str = null;
        byte b3 = (byte) 0;
        int i = 0;
        while (parcel.dataPosition() < b2) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = a.e(parcel, readInt);
                    break;
                case 2:
                    b3 = a.d(parcel, readInt);
                    break;
                case 3:
                    b = a.d(parcel, readInt);
                    break;
                case 4:
                    str = a.k(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == b2) {
            return new AmsEntityUpdateParcelable(i, b3, b, str);
        }
        throw new a.a("Overread allowed size end=" + b2, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new AmsEntityUpdateParcelable[i];
    }
}
