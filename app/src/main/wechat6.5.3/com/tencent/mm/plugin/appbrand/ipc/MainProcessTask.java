package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashSet;
import java.util.Set;

public abstract class MainProcessTask implements Parcelable {
    private static final Set<Object> dEG = new HashSet();
    Messenger dEH;
    public String lpS = (Process.myPid() + hashCode());

    public abstract void OL();

    public void OM() {
    }

    public void f(Parcel parcel) {
    }

    public void writeToParcel(Parcel parcel, int i) {
    }

    public int describeContents() {
        return 0;
    }

    public final boolean PP() {
        if (this.dEH == null) {
            return false;
        }
        Message obtain = Message.obtain();
        obtain.setData(AppBrandMainProcessService.a(this, false));
        try {
            this.dEH.send(obtain);
            return true;
        } catch (Exception e) {
            v.e("MicroMsg.MainProcessTask", e.getMessage());
            return false;
        }
    }

    public final void PQ() {
        dEG.add(this);
    }

    public final void PR() {
        dEG.remove(this);
    }
}
