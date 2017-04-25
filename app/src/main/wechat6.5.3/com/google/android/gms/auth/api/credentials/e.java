package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;
import java.util.List;

public final class e implements Creator<PasswordSpecification> {
    static void a(PasswordSpecification passwordSpecification, Parcel parcel) {
        int t = b.t(parcel, 20293);
        b.a(parcel, 1, passwordSpecification.ajF);
        b.c(parcel, 1000, passwordSpecification.mVersionCode);
        b.a(parcel, 2, passwordSpecification.ajG);
        List list = passwordSpecification.ajH;
        if (list != null) {
            int t2 = b.t(parcel, 3);
            int size = list.size();
            parcel.writeInt(size);
            for (int i = 0; i < size; i++) {
                parcel.writeInt(((Integer) list.get(i)).intValue());
            }
            b.u(parcel, t2);
        }
        b.c(parcel, 4, passwordSpecification.ajI);
        b.c(parcel, 5, passwordSpecification.ajJ);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = a.b(parcel);
        int i = 0;
        int i2 = 0;
        List list = null;
        List list2 = null;
        String str = null;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    str = a.k(parcel, readInt);
                    break;
                case 2:
                    list2 = a.q(parcel, readInt);
                    break;
                case 3:
                    ArrayList arrayList;
                    int a = a.a(parcel, readInt);
                    int dataPosition = parcel.dataPosition();
                    if (a == 0) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList();
                        int readInt2 = parcel.readInt();
                        for (int i4 = 0; i4 < readInt2; i4++) {
                            arrayList.add(Integer.valueOf(parcel.readInt()));
                        }
                        parcel.setDataPosition(dataPosition + a);
                    }
                    list = arrayList;
                    break;
                case 4:
                    i2 = a.e(parcel, readInt);
                    break;
                case 5:
                    i = a.e(parcel, readInt);
                    break;
                case 1000:
                    i3 = a.e(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new PasswordSpecification(i3, str, list2, list, i2, i);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new PasswordSpecification[i];
    }
}
