package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public final class aj implements Creator<SendMessageResponse> {
    static void a(SendMessageResponse sendMessageResponse, Parcel parcel) {
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, sendMessageResponse.versionCode);
        b.c(parcel, 2, sendMessageResponse.statusCode);
        b.c(parcel, 3, sendMessageResponse.arX);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = 0;
        int b = a.b(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i3 = a.e(parcel, readInt);
                    break;
                case 2:
                    i2 = a.e(parcel, readInt);
                    break;
                case 3:
                    i = a.e(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new SendMessageResponse(i3, i2, i);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new SendMessageResponse[i];
    }
}
