package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.w.a;

public class AddListenerRequest implements SafeParcelable {
    public static final Creator<AddListenerRequest> CREATOR = new ab();
    public final w aEF;
    public final IntentFilter[] aEG;
    public final String aEH;
    public final String aEI;
    final int mVersionCode;

    AddListenerRequest(int i, IBinder iBinder, IntentFilter[] intentFilterArr, String str, String str2) {
        this.mVersionCode = i;
        if (iBinder != null) {
            this.aEF = a.s(iBinder);
        } else {
            this.aEF = null;
        }
        this.aEG = intentFilterArr;
        this.aEH = str;
        this.aEI = str2;
    }

    public AddListenerRequest(ap apVar) {
        this.mVersionCode = 1;
        this.aEF = apVar;
        this.aEG = apVar.aFW;
        this.aEH = apVar.aFX;
        this.aEI = apVar.aFY;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ab.a(this, parcel, i);
    }
}
