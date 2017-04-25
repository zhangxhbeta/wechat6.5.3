package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;

public enum AppBrandLaunchingLogic {
    ;

    private static final class SyncBizContactProxyRequest extends ProcessRequest {
        public static final Creator<SyncBizContactProxyRequest> CREATOR = null;
        public String dDn;
        public AppBrandStatObject dLg;
        public int dzx;
        public String username;
        public int version;

        protected final void e(Parcel parcel) {
            this.username = parcel.readString();
            this.dLg = (AppBrandStatObject) parcel.readParcelable(AppBrandStatObject.class.getClassLoader());
            this.dDn = parcel.readString();
            this.dzx = parcel.readInt();
            this.version = parcel.readInt();
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.username);
            parcel.writeParcelable(this.dLg, i);
            parcel.writeString(this.dDn);
            parcel.writeInt(this.dzx);
            parcel.writeInt(this.version);
        }

        SyncBizContactProxyRequest() {
        }

        SyncBizContactProxyRequest(Parcel parcel) {
            super(parcel);
        }

        protected final Class<? extends AppBrandProxyUIProcessTask> PF() {
            return a.class;
        }

        static {
            CREATOR = new Creator<SyncBizContactProxyRequest>() {
                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    return new SyncBizContactProxyRequest(parcel);
                }

                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new SyncBizContactProxyRequest[i];
                }
            };
        }
    }

    private static final class a extends AppBrandProxyUIProcessTask {
        private p dDX;
        SyncBizContactProxyRequest dLh;

        class AnonymousClass3 extends n {
            final /* synthetic */ a dLi;
            final /* synthetic */ String dLl;
            final /* synthetic */ String dLm;
            final /* synthetic */ String dzt;

            AnonymousClass3(a aVar, String str, String str2, String str3, String str4) {
                this.dLi = aVar;
                this.dzt = str2;
                this.dLl = str3;
                this.dLm = str4;
                super(str);
            }

            final void onReady() {
                AppBrandLaunchingLogic.a(this.dLi.PL(), this.dzt, this.dLl, this.appId, this.dLi.dLh.dzx, this.dLm, this.dLi.dLh.dDn, this.dLi.dLh.dLg, false);
                this.dLi.RB();
            }

            final void RU() {
                this.dLi.RB();
            }

            final void azS() {
                super.azS();
                this.dLi.RB();
            }
        }

        protected final void a(ProcessRequest processRequest) {
            MMActivity PL = PL();
            aa.getResources().getString(2131231164);
            this.dDX = g.a(PL, aa.getResources().getString(2131233521), true, new OnCancelListener(this) {
                final /* synthetic */ a dLi;

                {
                    this.dLi = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    com.tencent.mm.plugin.appbrand.k.a.aD(this.dLi);
                    this.dLi.RB();
                }
            });
            com.tencent.mm.plugin.appbrand.k.a.aC(this);
            this.dLh = (SyncBizContactProxyRequest) processRequest;
            com.tencent.mm.plugin.appbrand.k.a.vA().x(new Runnable(this) {
                final /* synthetic */ a dLi;

                {
                    this.dLi = r1;
                }

                public final void run() {
                    AppBrandSysConfig appBrandSysConfig = null;
                    try {
                        appBrandSysConfig = new j(this.dLi.dLh.username, this.dLi.dLh.dzx, this.dLi.dLh.version).QE();
                    } catch (Throwable e) {
                        v.a("MicroMsg.AppBrand.SyncBizContactProxyTask", e, "get attr ", new Object[0]);
                    }
                    a aVar = this.dLi;
                    if (appBrandSysConfig == null) {
                        v.i("MicroMsg.AppBrand.SyncBizContactProxyTask", "onGetWxaAttr null return");
                        f.nJ(com.tencent.mm.plugin.appbrand.k.a.d(2131230967, "(-1,-1,-1)"));
                        aVar.RB();
                    } else if (new m(appBrandSysConfig.appId).aBC()) {
                        aVar.RB();
                    } else {
                        com.tencent.mm.plugin.appbrand.k.a.aD(aVar);
                        new AnonymousClass3(aVar, appBrandSysConfig.appId, aVar.dLh.username, appBrandSysConfig.aZU, appBrandSysConfig.dDo).j(aVar.PL());
                    }
                }
            });
        }

        protected final void PE() {
            com.tencent.mm.plugin.appbrand.k.a.aD(this);
        }

        void RB() {
            if (this.dDX != null) {
                this.dDX.dismiss();
            }
            a(null);
        }
    }

    public static void a(MMActivity mMActivity, String str, String str2, String str3, int i, String str4, String str5, AppBrandStatObject appBrandStatObject, boolean z) {
        if (!z || !new m(str).aBC()) {
            final MMActivity mMActivity2 = mMActivity;
            final String str6 = str;
            final String str7 = str2;
            final int i2 = i;
            final String str8 = str4;
            final String str9 = str5;
            final AppBrandStatObject appBrandStatObject2 = appBrandStatObject;
            n anonymousClass1 = new n(str3) {
                final void onReady() {
                    AppBrandLaunchingLogic.a(mMActivity2, str6, str7, this.appId, i2, str8, str9, appBrandStatObject2);
                }
            };
            if (z) {
                anonymousClass1.j(mMActivity);
            } else {
                anonymousClass1.onReady();
            }
        }
    }

    public static void a(Context context, String str, String str2, int i, int i2, AppBrandStatObject appBrandStatObject) {
        v.i("MicroMsg.AppBrandLaunchingLogic", "startApp, context = %s, brandId = %s", new Object[]{context, str});
        if (!be.kS(str)) {
            ProcessRequest syncBizContactProxyRequest = new SyncBizContactProxyRequest();
            syncBizContactProxyRequest.username = str;
            syncBizContactProxyRequest.dLg = appBrandStatObject;
            syncBizContactProxyRequest.dDn = str2;
            syncBizContactProxyRequest.dzx = i;
            if (i != 0) {
                i2 = -1;
            }
            syncBizContactProxyRequest.version = i2;
            com.tencent.mm.plugin.appbrand.ipc.a.a(context, syncBizContactProxyRequest);
        }
    }

    public static void a(String str, String str2, int i, AppBrandStatObject appBrandStatObject) {
        a(null, str, str2, 0, i, appBrandStatObject);
    }
}
