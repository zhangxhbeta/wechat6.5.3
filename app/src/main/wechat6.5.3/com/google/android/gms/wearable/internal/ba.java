package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public final class ba implements Creator<ChannelEventParcelable> {
    static void a(ChannelEventParcelable channelEventParcelable, Parcel parcel, int i) {
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, channelEventParcelable.mVersionCode);
        b.a(parcel, 2, channelEventParcelable.aEV, i);
        b.c(parcel, 3, channelEventParcelable.type);
        b.c(parcel, 4, channelEventParcelable.aEW);
        b.c(parcel, 5, channelEventParcelable.aEX);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = 0;
        int b = a.b(parcel);
        ChannelImpl channelImpl = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < b) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i4 = a.e(parcel, readInt);
                    break;
                case 2:
                    channelImpl = (ChannelImpl) a.a(parcel, readInt, ChannelImpl.CREATOR);
                    break;
                case 3:
                    i3 = a.e(parcel, readInt);
                    break;
                case 4:
                    i2 = a.e(parcel, readInt);
                    break;
                case 5:
                    i = a.e(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ChannelEventParcelable(i4, channelImpl, i3, i2, i);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ChannelEventParcelable[i];
    }
}
