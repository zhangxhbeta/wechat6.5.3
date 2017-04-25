package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.wearable.g;
import java.util.Map.Entry;

public final class e implements Creator<DataItemParcelable> {
    static void a(DataItemParcelable dataItemParcelable, Parcel parcel, int i) {
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, dataItemParcelable.mVersionCode);
        b.a(parcel, 2, dataItemParcelable.mUri, i);
        Bundle bundle = new Bundle();
        bundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        for (Entry entry : dataItemParcelable.aFa.entrySet()) {
            bundle.putParcelable((String) entry.getKey(), new DataItemAssetParcelable((g) entry.getValue()));
        }
        b.a(parcel, 4, bundle);
        b.a(parcel, 5, dataItemParcelable.aDR);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = a.b(parcel);
        Bundle bundle = null;
        Uri uri = null;
        int i = 0;
        byte[] bArr = null;
        while (parcel.dataPosition() < b) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = a.e(parcel, readInt);
                    break;
                case 2:
                    uri = (Uri) a.a(parcel, readInt, Uri.CREATOR);
                    break;
                case 4:
                    bundle = a.m(parcel, readInt);
                    break;
                case 5:
                    bArr = a.n(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new DataItemParcelable(i, uri, bundle, bArr);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new DataItemParcelable[i];
    }
}
