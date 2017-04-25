package com.tencent.mm.plugin.appbrand;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.k.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.AppBrandTaskManager;
import com.tencent.mm.protocal.c.cp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

public final class AppBrandTaskUsageRecorder {

    private static final class UpdateTask extends MainProcessTask {
        public static final Creator<UpdateTask> CREATOR = new Creator<UpdateTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new UpdateTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new UpdateTask[i];
            }
        };
        public final String aWH;
        public final String appId;
        public cp dIo = null;
        public final boolean dzw;
        public final int dzx;
        public final int dzy;

        public final void OL() {
            a.vA().x(new Runnable(this) {
                final /* synthetic */ UpdateTask dzz;

                {
                    this.dzz = r1;
                }

                public final void run() {
                    if (com.tencent.mm.plugin.appbrand.a.a.dzS != null) {
                        com.tencent.mm.plugin.appbrand.a.a.dzS.a(this.dzz.aWH, this.dzz.dzx, this.dzz.dzw, this.dzz.dzy);
                    }
                    if (this.dzz.dzw) {
                        k.a(this.dzz.aWH, new k.a(this) {
                            final /* synthetic */ AnonymousClass1 dzA;

                            {
                                this.dzA = r1;
                            }

                            public final void a(k.a.a aVar, AppBrandSysConfig appBrandSysConfig) {
                                if (!k.a.a.dQA.equals(aVar)) {
                                    return;
                                }
                                if (new com.tencent.mm.plugin.appbrand.launching.k(appBrandSysConfig, this.dzA.dzz.dzx, this.dzA.dzz.dzy, (byte) 0).QG()) {
                                    AppBrandTaskManager.ab(this.dzA.dzz.appId, this.dzA.dzz.dzx);
                                    return;
                                }
                                this.dzA.dzz.dIo = appBrandSysConfig.dDE;
                                this.dzA.dzz.PP();
                            }
                        });
                    }
                }
            });
        }

        public final void OM() {
            a.aD(this);
            if (this.dIo != null) {
                final cp cpVar = this.dIo;
                ad.o(new Runnable(this) {
                    final /* synthetic */ UpdateTask dzz;

                    public final void run() {
                        AppBrandSysConfig mr = a.mr(this.dzz.appId);
                        if (mr != null) {
                            mr.dDE = cpVar;
                        }
                    }
                });
            }
        }

        UpdateTask(String str, String str2, int i, boolean z) {
            this.aWH = str;
            this.appId = str2;
            this.dzx = i;
            this.dzw = z;
            AppBrandStatObject ms = a.ms(str2);
            if (ms == null) {
                this.dzy = BaseReportManager.MAX_READ_COUNT;
            } else {
                this.dzy = ms.scene;
            }
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.aWH);
            parcel.writeString(this.appId);
            parcel.writeByte(this.dzw ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.dzx);
            parcel.writeInt(this.dzy);
            if (this.dIo != null) {
                l.a(this.dIo, parcel);
            }
        }

        UpdateTask(Parcel parcel) {
            this.aWH = parcel.readString();
            this.appId = parcel.readString();
            this.dzw = parcel.readByte() != (byte) 0;
            this.dzx = parcel.readInt();
            this.dzy = parcel.readInt();
            try {
                this.dIo = l.d(parcel);
            } catch (Exception e) {
                this.dIo = null;
            }
        }
    }

    public static void a(AppBrandSysConfig appBrandSysConfig, final boolean z) {
        if (appBrandSysConfig != null && !be.kS(appBrandSysConfig.appId) && appBrandSysConfig.dDB.dBr >= 0) {
            final String str = appBrandSysConfig.appId;
            final String str2 = appBrandSysConfig.aWH;
            final int i = appBrandSysConfig.dDB.dBr;
            a.vA().x(new Runnable() {
                public final void run() {
                    AppBrandMainProcessService.a((UpdateTask) a.aC(new UpdateTask(str2, str, i, z)));
                }
            });
        }
    }
}
