package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.p.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetServiceRequest implements SafeParcelable {
    public static final Creator<GetServiceRequest> CREATOR = new j();
    final int anM;
    int anN;
    String anO;
    IBinder anP;
    Scope[] anQ;
    Bundle anR;
    Account anS;
    final int version;

    public GetServiceRequest(int i) {
        this.version = 2;
        this.anN = b.akq;
        this.anM = i;
    }

    GetServiceRequest(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account) {
        this.version = i;
        this.anM = i2;
        this.anN = i3;
        this.anO = str;
        if (i < 2) {
            Account account2 = null;
            if (iBinder != null) {
                account2 = a.b(a.g(iBinder));
            }
            this.anS = account2;
        } else {
            this.anP = iBinder;
            this.anS = account;
        }
        this.anQ = scopeArr;
        this.anR = bundle;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        j.a(this, parcel, i);
    }
}
