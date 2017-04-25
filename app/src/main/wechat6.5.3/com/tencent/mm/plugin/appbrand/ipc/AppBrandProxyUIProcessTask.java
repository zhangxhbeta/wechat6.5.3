package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import java.lang.reflect.Constructor;

public abstract class AppBrandProxyUIProcessTask implements com.tencent.mm.ui.MMActivity.a {
    public b dEB;

    public static abstract class ProcessRequest implements Parcelable {
        public abstract Class<? extends AppBrandProxyUIProcessTask> PF();

        public ProcessRequest(Parcel parcel) {
            e(parcel);
        }

        public boolean PN() {
            return false;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
        }

        public void e(Parcel parcel) {
        }
    }

    public static abstract class ProcessResult implements Parcelable {
        public abstract void e(Parcel parcel);

        public ProcessResult(Parcel parcel) {
            e(parcel);
        }
    }

    static final class a {
        static <_Model extends AppBrandProxyUIProcessTask> _Model nm(String str) {
            try {
                Constructor declaredConstructor = Class.forName(str).getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                return (AppBrandProxyUIProcessTask) declaredConstructor.newInstance(new Object[0]);
            } catch (Throwable e) {
                v.e("MicroMsg.AppBrand.IpcProxyUIModelFactory", "create mode object using className(%s), exp = %s", new Object[]{str, be.e(e)});
                return null;
            }
        }
    }

    public interface b<R extends ProcessResult> {
        void c(R r);
    }

    public abstract void a(ProcessRequest processRequest);

    public final MMActivity PL() {
        return this.dEB.PL();
    }

    public final void a(final ProcessResult processResult) {
        Runnable anonymousClass1 = new Runnable(this) {
            final /* synthetic */ AppBrandProxyUIProcessTask dEC;

            public final void run() {
                if (this.dEC.dEB != null) {
                    this.dEC.dEB.a(processResult);
                }
            }
        };
        if (this.dEB != null) {
            this.dEB.runOnUiThread(anonymousClass1);
        }
    }

    public void a(int i, int i2, Intent intent) {
    }

    public void PE() {
    }
}
