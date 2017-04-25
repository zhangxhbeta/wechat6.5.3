package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.w;
import java.util.List;

public class AccountChangeEventsResponse implements SafeParcelable {
    public static final Creator<AccountChangeEventsResponse> CREATOR = new g();
    final int ajd;
    final List<AccountChangeEvent> ajk;

    AccountChangeEventsResponse(int i, List<AccountChangeEvent> list) {
        this.ajd = i;
        this.ajk = (List) w.Z(list);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        g.a(this, parcel);
    }
}
