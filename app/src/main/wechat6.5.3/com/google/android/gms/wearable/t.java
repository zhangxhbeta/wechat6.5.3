package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public final class t implements Creator<ConnectionConfiguration> {
    static void a(ConnectionConfiguration connectionConfiguration, Parcel parcel) {
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, connectionConfiguration.mVersionCode);
        b.a(parcel, 2, connectionConfiguration.mName);
        b.a(parcel, 3, connectionConfiguration.aDU);
        b.c(parcel, 4, connectionConfiguration.amO);
        b.c(parcel, 5, connectionConfiguration.aDV);
        b.a(parcel, 6, connectionConfiguration.aDW);
        b.a(parcel, 7, connectionConfiguration.aga);
        b.a(parcel, 8, connectionConfiguration.aDX);
        b.a(parcel, 9, connectionConfiguration.aDY);
        b.a(parcel, 10, connectionConfiguration.aDZ);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        boolean z = false;
        int b = a.b(parcel);
        String str2 = null;
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        int i2 = 0;
        String str3 = null;
        String str4 = null;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i3 = a.e(parcel, readInt);
                    break;
                case 2:
                    str4 = a.k(parcel, readInt);
                    break;
                case 3:
                    str3 = a.k(parcel, readInt);
                    break;
                case 4:
                    i2 = a.e(parcel, readInt);
                    break;
                case 5:
                    i = a.e(parcel, readInt);
                    break;
                case 6:
                    z3 = a.c(parcel, readInt);
                    break;
                case 7:
                    z2 = a.c(parcel, readInt);
                    break;
                case 8:
                    str2 = a.k(parcel, readInt);
                    break;
                case 9:
                    z = a.c(parcel, readInt);
                    break;
                case 10:
                    str = a.k(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ConnectionConfiguration(i3, str4, str3, i2, i, z3, z2, str2, z, str);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ConnectionConfiguration[i];
    }
}
