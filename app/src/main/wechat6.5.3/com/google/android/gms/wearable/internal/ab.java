package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public final class ab implements Creator<AddListenerRequest> {
    static void a(AddListenerRequest addListenerRequest, Parcel parcel, int i) {
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, addListenerRequest.mVersionCode);
        b.a(parcel, 2, addListenerRequest.aEF == null ? null : addListenerRequest.aEF.asBinder());
        b.a(parcel, 3, addListenerRequest.aEG, i);
        b.a(parcel, 4, addListenerRequest.aEH);
        b.a(parcel, 5, addListenerRequest.aEI);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        int b = a.b(parcel);
        int i = 0;
        String str2 = null;
        IntentFilter[] intentFilterArr = null;
        IBinder iBinder = null;
        while (parcel.dataPosition() < b) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = a.e(parcel, readInt);
                    break;
                case 2:
                    iBinder = a.l(parcel, readInt);
                    break;
                case 3:
                    intentFilterArr = (IntentFilter[]) a.b(parcel, readInt, IntentFilter.CREATOR);
                    break;
                case 4:
                    str2 = a.k(parcel, readInt);
                    break;
                case 5:
                    str = a.k(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AddListenerRequest(i, iBinder, intentFilterArr, str2, str);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new AddListenerRequest[i];
    }
}
