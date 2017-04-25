package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.appbrand.c;
import com.tencent.mm.ui.appbrand.c.a;
import java.util.HashSet;
import java.util.Set;

public enum AppBrandStickInChattingPluginLogic {
    ;
    
    private static final Watcher dzl = null;
    private static final Set<a> dzm = null;

    private static final class OperateTask extends MainProcessTask {
        public static final Creator<OperateTask> CREATOR = null;
        boolean dzo;
        String dzp;
        int dzq;
        int op;

        public final void OL() {
            switch (this.op) {
                case 1:
                    this.dzo = c.I(this.dzp, this.dzq);
                    PP();
                    return;
                case 2:
                    c.ca(this.dzp, this.dzq);
                    return;
                default:
                    return;
            }
        }

        static OperateTask J(String str, int i) {
            OperateTask operateTask = new OperateTask();
            operateTask.op = 1;
            operateTask.dzp = str;
            operateTask.dzq = i;
            return operateTask;
        }

        static OperateTask K(String str, int i) {
            OperateTask operateTask = new OperateTask();
            operateTask.op = 2;
            operateTask.dzp = str;
            operateTask.dzq = i;
            return operateTask;
        }

        OperateTask() {
            this.op = 0;
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.op);
            parcel.writeByte(this.dzo ? (byte) 1 : (byte) 0);
            parcel.writeString(this.dzp);
            parcel.writeInt(this.dzq);
        }

        OperateTask(Parcel parcel) {
            boolean z = false;
            this.op = 0;
            this.op = parcel.readInt();
            if (parcel.readByte() != (byte) 0) {
                z = true;
            }
            this.dzo = z;
            this.dzp = parcel.readString();
            this.dzq = parcel.readInt();
        }

        static {
            CREATOR = new Creator<OperateTask>() {
                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    return new OperateTask(parcel);
                }

                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new OperateTask[i];
                }
            };
        }
    }

    private static final class Watcher extends MainProcessTask {
        public static final Creator<Watcher> CREATOR = null;
        private static boolean dzr;
        String dzp;
        int dzq;

        static {
            dzr = false;
            CREATOR = new Creator<Watcher>() {
                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    return new Watcher(parcel);
                }

                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new Watcher[i];
                }
            };
        }

        public final int describeContents() {
            return 0;
        }

        public final void OL() {
            if (!dzr) {
                com.tencent.mm.plugin.appbrand.k.a.aC(this);
                c.c(new a(this) {
                    final /* synthetic */ Watcher dzs;

                    {
                        this.dzs = r1;
                    }

                    public final void L(String str, int i) {
                        this.dzs.dzp = str;
                        this.dzs.dzq = i;
                        this.dzs.PP();
                    }
                });
                dzr = true;
            }
        }

        public final void OM() {
        }

        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.dzp);
            parcel.writeInt(this.dzq);
        }

        Watcher() {
        }

        Watcher(Parcel parcel) {
            this.dzp = parcel.readString();
            this.dzq = parcel.readInt();
        }
    }

    static {
        dzl = new Watcher();
        dzm = new HashSet();
    }

    public static void a(a aVar) {
        AppBrandMainProcessService.b(dzl);
        if (aVar != null) {
            dzm.add(aVar);
        }
    }

    public static void b(a aVar) {
        if (aVar != null) {
            dzm.remove(aVar);
        }
    }

    public static void a(Context context, String str, String str2, String str3, int i) {
        c.b(context, str, str2, str3, i);
    }

    public static void mD(String str) {
        if (!be.kS(str)) {
            int i = a.mr(str).dDB.dBr;
            if (i >= 0 && a.ms(str).scene == 1022) {
                AppBrandMainProcessService.a(OperateTask.K(str, i));
            }
        }
    }

    public static boolean I(String str, int i) {
        if (be.kS(str) || i < 0) {
            return false;
        }
        MainProcessTask J = OperateTask.J(str, i);
        if (AppBrandMainProcessService.b(J) && J.dzo) {
            return true;
        }
        return false;
    }
}
