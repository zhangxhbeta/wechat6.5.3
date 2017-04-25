package com.tencent.mm.plugin.appbrand.ui;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.launching.d;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

final class AppBrandPrepareTask extends MainProcessTask {
    public static final Creator<AppBrandPrepareTask> CREATOR = new Creator<AppBrandPrepareTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AppBrandPrepareTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandPrepareTask[i];
        }
    };
    private int dRm;
    private String dRs;
    private int dRt;
    private boolean dRu;
    private String dRv;
    private AppBrandSysConfig dRw;
    private int dRx;
    a dRy;

    interface a {
        void Sh();

        void e(AppBrandSysConfig appBrandSysConfig);
    }

    static /* synthetic */ void a(AppBrandPrepareTask appBrandPrepareTask, int i) {
        appBrandPrepareTask.dRx = i;
        switch (i) {
            case 2:
                com.tencent.mm.plugin.appbrand.k.a.aD(appBrandPrepareTask);
                break;
        }
        appBrandPrepareTask.PP();
    }

    AppBrandPrepareTask(String str, int i, int i2) {
        this.dRx = 0;
        this.dRs = str;
        this.dRt = i;
        this.dRm = i2;
    }

    private AppBrandPrepareTask(Parcel parcel) {
        this.dRx = 0;
        f(parcel);
    }

    public final void OL() {
        if (!be.kS(this.dRs)) {
            com.tencent.mm.plugin.appbrand.k.a.aC(this);
            e.a(new Runnable(new d(this, this.dRs, this.dRt, this.dRm) {
                final /* synthetic */ AppBrandPrepareTask dRz;

                public final void QD() {
                    AppBrandPrepareTask.a(this.dRz, 1);
                }

                public final void c(AppBrandSysConfig appBrandSysConfig) {
                    this.dRz.dRw = appBrandSysConfig;
                    if (this.dRz.dRw != null) {
                        AppBrandSysConfig a = this.dRz.dRw;
                        ak.yW();
                        a.uin = c.ww();
                    }
                    AppBrandPrepareTask.a(this.dRz, 2);
                }
            }) {
                final /* synthetic */ d dLq;

                {
                    this.dLq = r1;
                }

                public final void run() {
                    try {
                        this.dLq.c(this.dLq.QE());
                    } catch (Throwable e) {
                        v.a("MicroMsg.AppBrand.AppLaunchPrepareProcess", e, "call() exp ", new Object[0]);
                        f.he(2131230956);
                        this.dLq.c(null);
                    }
                }
            }, "AppBrandLaunchingPrepareProcess");
        }
    }

    public final void OM() {
        v.i("MicroMsg.AppBrandPrepareTask", "runInClientProcess, event = %d", new Object[]{Integer.valueOf(this.dRx)});
        switch (this.dRx) {
            case 1:
                if (this.dRy != null) {
                    this.dRy.Sh();
                    return;
                }
                return;
            case 2:
                if (this.dRy != null) {
                    if (this.dRw != null) {
                        v.i("MicroMsg.AppBrandPrepareTask", "runInClientProcess, prepare done, appPkg [%d | %s], libPkg [%d | %s]", new Object[]{Integer.valueOf(this.dRw.dDB.dBs), be.ec(this.dRw.dDB.dBt), Integer.valueOf(this.dRw.dDC.dBs), be.ec(this.dRw.dDC.dBt)});
                    } else {
                        v.i("MicroMsg.AppBrandPrepareTask", "runInClientProcess, config null");
                    }
                    this.dRy.e(this.dRw);
                } else {
                    v.e("MicroMsg.AppBrandPrepareTask", "runInClientProcess, prepare done, but callback is null");
                }
                com.tencent.mm.plugin.appbrand.k.a.aD(this);
                return;
            default:
                return;
        }
    }

    public final void f(Parcel parcel) {
        this.dRs = parcel.readString();
        this.dRt = parcel.readInt();
        this.dRv = parcel.readString();
        this.dRu = parcel.readByte() != (byte) 0;
        this.dRm = parcel.readInt();
        this.dRx = parcel.readInt();
        this.dRw = (AppBrandSysConfig) parcel.readParcelable(AppBrandSysConfig.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.dRs);
        parcel.writeInt(this.dRt);
        parcel.writeString(this.dRv);
        parcel.writeByte(this.dRu ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.dRm);
        parcel.writeInt(this.dRx);
        parcel.writeParcelable(this.dRw, i);
    }
}
