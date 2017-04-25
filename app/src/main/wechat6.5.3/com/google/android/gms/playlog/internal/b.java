package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.tencent.mars.comm.NetStatusUtil;

public final class b implements Creator<PlayLoggerContext> {
    static void a(PlayLoggerContext playLoggerContext, Parcel parcel) {
        int t = com.google.android.gms.common.internal.safeparcel.b.t(parcel, 20293);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1, playLoggerContext.versionCode);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, playLoggerContext.packageName);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 3, playLoggerContext.aBj);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 4, playLoggerContext.aBk);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 5, playLoggerContext.aBl);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 6, playLoggerContext.aBm);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 7, playLoggerContext.aBn);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 8, playLoggerContext.aBo);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 9, playLoggerContext.aBp);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 10, playLoggerContext.aBq);
        com.google.android.gms.common.internal.safeparcel.b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        int i = 0;
        int b = a.b(parcel);
        boolean z = true;
        boolean z2 = false;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        int i3 = 0;
        String str4 = null;
        int i4 = 0;
        while (parcel.dataPosition() < b) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i4 = a.e(parcel, readInt);
                    break;
                case 2:
                    str4 = a.k(parcel, readInt);
                    break;
                case 3:
                    i3 = a.e(parcel, readInt);
                    break;
                case 4:
                    i2 = a.e(parcel, readInt);
                    break;
                case 5:
                    str3 = a.k(parcel, readInt);
                    break;
                case 6:
                    str2 = a.k(parcel, readInt);
                    break;
                case 7:
                    z = a.c(parcel, readInt);
                    break;
                case 8:
                    str = a.k(parcel, readInt);
                    break;
                case NetStatusUtil.MOBILE /*9*/:
                    z2 = a.c(parcel, readInt);
                    break;
                case NetStatusUtil.LTE /*10*/:
                    i = a.e(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new PlayLoggerContext(i4, str4, i3, i2, str3, str2, z, str, z2, i);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new PlayLoggerContext[i];
    }
}
