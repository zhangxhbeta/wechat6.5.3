package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public final class q implements Creator<GetConnectedNodesResponse> {
    static void a(GetConnectedNodesResponse getConnectedNodesResponse, Parcel parcel) {
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, getConnectedNodesResponse.versionCode);
        b.c(parcel, 2, getConnectedNodesResponse.statusCode);
        b.b(parcel, 3, getConnectedNodesResponse.aFk);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = 0;
        int b = a.b(parcel);
        List list = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i2 = a.e(parcel, readInt);
                    break;
                case 2:
                    i = a.e(parcel, readInt);
                    break;
                case 3:
                    list = a.c(parcel, readInt, NodeParcelable.CREATOR);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GetConnectedNodesResponse(i2, i, list);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new GetConnectedNodesResponse[i];
    }
}
