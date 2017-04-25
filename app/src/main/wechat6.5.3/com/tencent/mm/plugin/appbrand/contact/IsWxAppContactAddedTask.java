package com.tencent.mm.plugin.appbrand.contact;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.a.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.be;

public final class IsWxAppContactAddedTask extends MainProcessTask {
    public static final Creator<IsWxAppContactAddedTask> CREATOR = new Creator<IsWxAppContactAddedTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new IsWxAppContactAddedTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IsWxAppContactAddedTask[i];
        }
    };
    public boolean aXR;
    public String userName;

    public final void OL() {
        boolean z = false;
        if (!(be.kS(this.userName) || this.userName.endsWith("@app"))) {
            this.userName += "@app";
        }
        b bVar = a.dzQ;
        if (!be.kS(this.userName)) {
            Cursor query = bVar.dBf.query("WxAppContact", new String[]{"UserName"}, String.format("%s=?", new Object[]{"UserName"}), new String[]{this.userName}, null, null, null);
            if (query != null) {
                boolean z2 = query.getCount() > 0;
                query.close();
                z = z2;
            }
        }
        this.aXR = z;
        PP();
    }

    public final void f(Parcel parcel) {
        this.userName = parcel.readString();
        this.aXR = parcel.readByte() != (byte) 0;
    }

    public final void OM() {
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.userName);
        parcel.writeByte(this.aXR ? (byte) 1 : (byte) 0);
    }

    private IsWxAppContactAddedTask(Parcel parcel) {
        f(parcel);
    }
}
