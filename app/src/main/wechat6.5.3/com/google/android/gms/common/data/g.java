package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public final class g implements Creator<DataHolder> {
    public static DataHolder a(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int b = a.b(parcel);
        CursorWindow[] cursorWindowArr = null;
        String[] strArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    strArr = a.p(parcel, readInt);
                    break;
                case 2:
                    cursorWindowArr = (CursorWindow[]) a.b(parcel, readInt, CursorWindow.CREATOR);
                    break;
                case 3:
                    i = a.e(parcel, readInt);
                    break;
                case 4:
                    bundle = a.m(parcel, readInt);
                    break;
                case 1000:
                    i2 = a.e(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new a.a("Overread allowed size end=" + b, parcel);
        }
        DataHolder dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i, bundle);
        dataHolder.jG();
        return dataHolder;
    }

    static void a(DataHolder dataHolder, Parcel parcel, int i) {
        int t = b.t(parcel, 20293);
        b.a(parcel, 1, dataHolder.amS);
        b.c(parcel, 1000, dataHolder.mVersionCode);
        b.a(parcel, 2, dataHolder.amU, i);
        b.c(parcel, 3, dataHolder.akn);
        b.a(parcel, 4, dataHolder.amV);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new DataHolder[i];
    }
}
