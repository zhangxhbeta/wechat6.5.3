package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public final class ad implements Creator<NodeParcelable> {
    static void a(NodeParcelable nodeParcelable, Parcel parcel) {
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, nodeParcelable.mVersionCode);
        b.a(parcel, 2, nodeParcelable.afy);
        b.a(parcel, 3, nodeParcelable.aBs);
        b.c(parcel, 4, nodeParcelable.aFp);
        b.a(parcel, 5, nodeParcelable.aFq);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        boolean z = false;
        int b = a.b(parcel);
        int i = 0;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i2 = a.e(parcel, readInt);
                    break;
                case 2:
                    str2 = a.k(parcel, readInt);
                    break;
                case 3:
                    str = a.k(parcel, readInt);
                    break;
                case 4:
                    i = a.e(parcel, readInt);
                    break;
                case 5:
                    z = a.c(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new NodeParcelable(i2, str2, str, i, z);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new NodeParcelable[i];
    }
}
