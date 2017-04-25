package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ResultReceiver implements Parcelable {
    public static final Creator<ResultReceiver> CREATOR = new Creator<ResultReceiver>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ResultReceiver(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ResultReceiver[i];
        }
    };
    public final Handler mHandler = null;
    public final boolean uX = false;
    public a uY;

    class b implements Runnable {
        final /* synthetic */ ResultReceiver uZ;
        final int va;
        final Bundle vb;

        public b(ResultReceiver resultReceiver, int i, Bundle bundle) {
            this.uZ = resultReceiver;
            this.va = i;
            this.vb = bundle;
        }

        public final void run() {
            this.uZ.onReceiveResult(this.va, this.vb);
        }
    }

    class a extends android.support.v4.os.a.a {
        final /* synthetic */ ResultReceiver uZ;

        a(ResultReceiver resultReceiver) {
            this.uZ = resultReceiver;
        }

        public final void send(int i, Bundle bundle) {
            if (this.uZ.mHandler != null) {
                this.uZ.mHandler.post(new b(this.uZ, i, bundle));
            } else {
                this.uZ.onReceiveResult(i, bundle);
            }
        }
    }

    public void onReceiveResult(int i, Bundle bundle) {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.uY == null) {
                this.uY = new a(this);
            }
            parcel.writeStrongBinder(this.uY.asBinder());
        }
    }

    ResultReceiver(Parcel parcel) {
        this.uY = android.support.v4.os.a.a.b(parcel.readStrongBinder());
    }
}
