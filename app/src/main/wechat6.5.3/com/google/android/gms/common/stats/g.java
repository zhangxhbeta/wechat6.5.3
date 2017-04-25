package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.tencent.mars.comm.NetStatusUtil;
import java.util.List;

public final class g implements Creator<WakeLockEvent> {
    static void a(WakeLockEvent wakeLockEvent, Parcel parcel) {
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, wakeLockEvent.mVersionCode);
        b.a(parcel, 2, wakeLockEvent.aqa);
        b.a(parcel, 4, wakeLockEvent.aql);
        b.c(parcel, 5, wakeLockEvent.aqm);
        b.a(parcel, 6, wakeLockEvent.aqn);
        b.a(parcel, 8, wakeLockEvent.aqi);
        b.a(parcel, 10, wakeLockEvent.aqq);
        b.c(parcel, 11, wakeLockEvent.aqb);
        b.a(parcel, 12, wakeLockEvent.aqo);
        b.a(parcel, 13, wakeLockEvent.aqr);
        b.c(parcel, 14, wakeLockEvent.aqp);
        float f = wakeLockEvent.aqs;
        b.b(parcel, 15, 4);
        parcel.writeFloat(f);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = a.b(parcel);
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        List list = null;
        String str2 = null;
        long j2 = 0;
        int i4 = 0;
        String str3 = null;
        String str4 = null;
        float f = 0.0f;
        while (parcel.dataPosition() < b) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = a.e(parcel, readInt);
                    break;
                case 2:
                    j = a.f(parcel, readInt);
                    break;
                case 4:
                    str = a.k(parcel, readInt);
                    break;
                case 5:
                    i3 = a.e(parcel, readInt);
                    break;
                case 6:
                    list = a.q(parcel, readInt);
                    break;
                case 8:
                    j2 = a.f(parcel, readInt);
                    break;
                case NetStatusUtil.LTE /*10*/:
                    str3 = a.k(parcel, readInt);
                    break;
                case 11:
                    i2 = a.e(parcel, readInt);
                    break;
                case 12:
                    str2 = a.k(parcel, readInt);
                    break;
                case 13:
                    str4 = a.k(parcel, readInt);
                    break;
                case 14:
                    i4 = a.e(parcel, readInt);
                    break;
                case 15:
                    f = a.h(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new WakeLockEvent(i, j, i2, str, i3, list, str2, j2, i4, str3, str4, f);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new WakeLockEvent[i];
    }
}
