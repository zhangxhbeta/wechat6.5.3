package com.tencent.mm.plugin.appbrand.task;

import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Process;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import junit.framework.Assert;

public class AppBrandRemoteTaskController extends MainProcessTask {
    public static final Creator<AppBrandRemoteTaskController> CREATOR = new Creator<AppBrandRemoteTaskController>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppBrandRemoteTaskController appBrandRemoteTaskController = new AppBrandRemoteTaskController();
            appBrandRemoteTaskController.f(parcel);
            return appBrandRemoteTaskController;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandRemoteTaskController[i];
        }
    };
    private static AppBrandRemoteTaskController dQa;
    private static long dQf;
    private a dQb;
    AppBrandInitConfig dQc;
    private String dQd;
    private long dQe;
    int lql = b.lqp;
    int lqm;
    private String mProcessName;

    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] lqn = new int[b.bRA().length];

        static {
            try {
                lqn[b.lqr - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                lqn[b.lqs - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                lqn[b.lqu - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                lqn[b.lqv - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                lqn[b.lqt - 1] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                lqn[b.lqw - 1] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public interface a {
        void bRB();

        void remove();
    }

    private enum b {
        ;

        public static int[] bRA() {
            return (int[]) lqz.clone();
        }

        static {
            lqp = 1;
            lqr = 2;
            lqs = 3;
            lqt = 4;
            lqu = 5;
            lqv = 6;
            lqw = 7;
            lqx = 8;
            lqz = new int[]{lqp, lqr, lqs, lqt, lqu, lqv, lqw, lqx};
        }
    }

    private static AppBrandRemoteTaskController RN() {
        if (dQa == null) {
            synchronized (AppBrandRemoteTaskController.class) {
                if (dQa == null) {
                    dQa = new AppBrandRemoteTaskController();
                }
            }
        }
        return dQa;
    }

    public static void a(a aVar) {
        RN().dQb = aVar;
    }

    public static void a(AppBrandInitConfig appBrandInitConfig, String str) {
        RN().dQc = appBrandInitConfig;
        RN().dQd = str;
        RN().mProcessName = aa.getProcessName();
    }

    public static void RO() {
        RN().lql = b.lqr;
        AppBrandMainProcessService.a(RN());
    }

    public static void RP() {
        RN().lql = b.lqs;
        AppBrandMainProcessService.a(RN());
    }

    public static void bRz() {
        RN().lql = b.lqu;
        RN().lqm = 0;
        AppBrandMainProcessService.a(RN());
    }

    public static void RQ() {
        RN().lql = b.lqv;
        AppBrandMainProcessService.b(RN());
        System.exit(0);
    }

    public static long getTimestamp() {
        return RN().dQe;
    }

    public final void OL() {
        switch (AnonymousClass2.lqn[this.lql - 1]) {
            case 1:
                b on = AppBrandTaskManager.on(this.dQd);
                on.dzg = this.dQc.appId;
                on.dQq = this;
                AppBrandTaskManager.a(on);
                AppBrandTaskManager.RV();
                synchronized (AppBrandRemoteTaskController.class) {
                    if (dQf == 0) {
                        long currentTimeMillis = System.currentTimeMillis();
                        dQf = currentTimeMillis;
                        Editor edit = MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "pref_appbrand_process", 4).edit();
                        edit.putLong("on_wxa_process_connected_time", currentTimeMillis);
                        edit.commit();
                        v.v("MicroMsg.AppBrandReporter", "update timestamp(%s)", new Object[]{Long.valueOf(currentTimeMillis)});
                    }
                    this.dQe = dQf;
                }
                return;
            case 2:
                RR();
                return;
            case 3:
                AppBrandTaskManager.hb(this.lqm);
                return;
            case 4:
                com.tencent.mm.t.b.gr(this.mProcessName);
                AppBrandTaskManager.ol(this.dQd);
                return;
            default:
                return;
        }
    }

    void RR() {
        if (this.dQc != null && AppBrandTaskManager.op(this.dQc.appId) != null) {
            AppBrandTaskManager.oq(this.dQc.appId);
            AppBrandTaskManager.RV();
        }
    }

    public final void OM() {
        switch (AnonymousClass2.lqn[this.lql - 1]) {
            case 2:
                RS();
                return;
            case 5:
                switch (this.lqm) {
                    case 0:
                        com.tencent.mm.t.b.gr(aa.getProcessName());
                        RS();
                        int myPid = Process.myPid();
                        com.tencent.recovery.b.yH(13);
                        Process.killProcess(myPid);
                        return;
                    case 1:
                        this.dQb.bRB();
                        return;
                    default:
                        return;
                }
            case 6:
                Assert.assertTrue("AppBrand Test Assert", false);
                return;
            default:
                return;
        }
    }

    private void RS() {
        if (this.dQb != null) {
            this.dQb.remove();
        }
        this.dQb = null;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.dQc, i);
        parcel.writeString(this.dQd);
        parcel.writeString(this.mProcessName);
        parcel.writeInt(this.lql == 0 ? -1 : this.lql - 1);
        parcel.writeInt(this.lqm);
        parcel.writeLong(this.dQe);
    }

    public final void f(Parcel parcel) {
        this.dQc = (AppBrandInitConfig) parcel.readParcelable(AppBrandInitConfig.class.getClassLoader());
        this.dQd = parcel.readString();
        this.mProcessName = parcel.readString();
        int readInt = parcel.readInt();
        this.lql = readInt == -1 ? 0 : b.bRA()[readInt];
        this.lqm = parcel.readInt();
        this.dQe = parcel.readLong();
    }
}
