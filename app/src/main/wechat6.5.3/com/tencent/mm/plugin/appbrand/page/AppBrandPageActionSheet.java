package com.tencent.mm.plugin.appbrand.page;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.modelappbrand.AppBrandExportUrlParams;
import com.tencent.mm.plugin.appbrand.AppBrandStickInChattingPluginLogic;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.config.j;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiShareAppMessage;
import com.tencent.mm.plugin.appbrand.jsapi.bk;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.appbrand.IconHeaderView;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.f;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class AppBrandPageActionSheet {
    f dNk;
    private IconHeaderView dNl;
    h dNm;
    l dNn;
    Set<c> dNo = new HashSet();
    String dzg;

    public enum c {
        ShareAppMsg,
        ShareToTimeLine,
        EnableDebug,
        ShowPkgInfo,
        Exit,
        BackToWeChat,
        SendToDesktop,
        AboutUs;

        static c hh(int i) {
            for (c cVar : values()) {
                if (cVar.ordinal() == i) {
                    return cVar;
                }
            }
            return null;
        }
    }

    private static class SendShortcutToDesktopTask extends MainProcessTask {
        public static final Creator<SendShortcutToDesktopTask> CREATOR = new Creator<SendShortcutToDesktopTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SendShortcutToDesktopTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SendShortcutToDesktopTask[i];
            }
        };
        private int cUv;
        private String username;

        public SendShortcutToDesktopTask(String str, int i) {
            this.username = str;
            this.cUv = i;
        }

        public SendShortcutToDesktopTask(Parcel parcel) {
            f(parcel);
        }

        public final void OL() {
            final Context context = aa.getContext();
            com.tencent.mm.plugin.base.a.a.p(context, this.username, this.cUv);
            ad.g(new Runnable(this) {
                final /* synthetic */ SendShortcutToDesktopTask dNA;

                public final void run() {
                    if (com.tencent.mm.plugin.base.a.a.o(context, this.dNA.username, this.dNA.cUv)) {
                        g.iuh.a(443, 1, 1, false);
                    }
                }
            }, 1000);
        }

        public final void f(Parcel parcel) {
            this.username = parcel.readString();
            this.cUv = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.username);
            parcel.writeInt(this.cUv);
        }
    }

    private static class SetAppDebugModeTask extends MainProcessTask {
        public static final Creator<SetAppDebugModeTask> CREATOR = new Creator<SetAppDebugModeTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                SetAppDebugModeTask setAppDebugModeTask = new SetAppDebugModeTask();
                setAppDebugModeTask.f(parcel);
                return setAppDebugModeTask;
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SetAppDebugModeTask[i];
            }
        };
        public boolean aZw;
        public String appId;

        private SetAppDebugModeTask() {
        }

        public final void OL() {
            j OO = com.tencent.mm.plugin.appbrand.a.a.OO();
            String str = this.appId;
            boolean z = this.aZw;
            if (!be.kS(str)) {
                ContentValues contentValues = new ContentValues(1);
                contentValues.put("debugEnabled", Boolean.valueOf(z));
                OO.dBf.update("AppBrandWxaAppInfo", contentValues, String.format("%s=?", new Object[]{"appId"}), new String[]{str});
            }
        }

        public final void f(Parcel parcel) {
            this.appId = parcel.readString();
            this.aZw = parcel.readByte() != (byte) 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.appId);
            parcel.writeByte(this.aZw ? (byte) 1 : (byte) 0);
        }
    }

    private static final class a extends e {
        private static final int CTRL_INDEX = 75;
        private static final String NAME = "onShareAppMessage";

        private a() {
        }
    }

    private static final class b extends e {
        private static final int CTRL_INDEX = 76;
        private static final String NAME = "onMenuShareTimeline";

        private b() {
        }
    }

    static /* synthetic */ void a(AppBrandPageActionSheet appBrandPageActionSheet, Context context) {
        AppBrandSysConfig mr = com.tencent.mm.plugin.appbrand.a.mr(appBrandPageActionSheet.dzg);
        if (mr != null) {
            String str = "";
            AppBrandStatObject ms = com.tencent.mm.plugin.appbrand.a.ms(appBrandPageActionSheet.dzg);
            AppBrandProfileUI.a(context, mr.aWH, ms != null ? be.ma(ms.aZj) : str, new AppBrandExportUrlParams(mr.appId, 3, appBrandPageActionSheet.dNn.dOM, mr.dDB.dBr, mr.dDB.dBs));
            appBrandPageActionSheet.a(6, "", 1, 0);
        }
    }

    static /* synthetic */ void a(AppBrandPageActionSheet appBrandPageActionSheet, l lVar, c cVar, String str) {
        if (!appBrandPageActionSheet.dNo.contains(cVar)) {
            lVar.d(cVar.ordinal(), str);
        }
    }

    AppBrandPageActionSheet(final Context context, String str, h hVar, Set<c> set) {
        this.dzg = str;
        this.dNm = hVar;
        this.dNn = hVar.dNn;
        if (set != null) {
            this.dNo.addAll(set);
        }
        AppBrandSysConfig mr = com.tencent.mm.plugin.appbrand.a.mr(this.dzg);
        this.dNk = new f(context, f.pbS, true);
        this.dNl = new IconHeaderView(context);
        this.dNk.dd(this.dNl);
        this.dNl.J(mr.aZU);
        this.dNl.j(new OnClickListener(this) {
            final /* synthetic */ AppBrandPageActionSheet dNp;

            public final void onClick(View view) {
                AppBrandPageActionSheet.a(this.dNp, context);
                this.dNp.dNk.bKi();
            }
        });
        this.dNl.F(com.tencent.mm.plugin.appbrand.appcache.c.gX(mr.dDB.dBr));
        com.tencent.mm.t.a.b.AL().a(this.dNl.nPI, mr.dDo, com.tencent.mm.t.a.a.AK(), com.tencent.mm.t.a.c.cxH);
        this.dNk.jXn = new com.tencent.mm.ui.base.n.c(this) {
            final /* synthetic */ AppBrandPageActionSheet dNp;

            public final void a(l lVar) {
                if (com.tencent.mm.plugin.appbrand.a.mr(this.dNp.dzg).dDB.dBr == 1) {
                    String string;
                    if (com.tencent.mm.plugin.appbrand.a.mr(this.dNp.dzg).dDp) {
                        string = context.getString(2131230932);
                    } else {
                        string = context.getString(2131230935);
                    }
                    AppBrandPageActionSheet.a(this.dNp, lVar, c.EnableDebug, string);
                }
                AppBrandPageActionSheet.a(this.dNp, lVar, c.ShareAppMsg, context.getString(2131230997));
                if (com.tencent.mm.sdk.b.b.bsI()) {
                    AppBrandPageActionSheet.a(this.dNp, lVar, c.ShowPkgInfo, context.getString(2131231001));
                }
                AppBrandPageActionSheet.a(this.dNp, lVar, c.BackToWeChat, context.getString(2131230908));
                AppBrandPageActionSheet.a(this.dNp, lVar, c.SendToDesktop, context.getString(2131230989));
                if (com.tencent.mm.sdk.b.b.bsI()) {
                    AppBrandPageActionSheet appBrandPageActionSheet = this.dNp;
                    c cVar = c.Exit;
                    int color = context.getResources().getColor(2131689961);
                    CharSequence string2 = context.getString(2131230915);
                    if (!appBrandPageActionSheet.dNo.contains(cVar)) {
                        lVar.a(cVar.ordinal(), color, string2);
                    }
                }
            }
        };
        this.dNk.jXo = new d(this) {
            final /* synthetic */ AppBrandPageActionSheet dNp;

            public final void c(MenuItem menuItem, int i) {
                int i2 = 1;
                boolean z = false;
                AppBrandSysConfig mr = com.tencent.mm.plugin.appbrand.a.mr(this.dNp.dzg);
                c hh = c.hh(menuItem.getItemId());
                if (hh != null) {
                    AppBrandPageActionSheet appBrandPageActionSheet;
                    Context context;
                    switch (hh) {
                        case ShareAppMsg:
                            appBrandPageActionSheet = this.dNp;
                            mr = com.tencent.mm.plugin.appbrand.a.mr(appBrandPageActionSheet.dzg);
                            SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(appBrandPageActionSheet.dNm.getContext(), "pref_appbrand_" + mr.uin, 4);
                            if (mr.dDB.dBr != 1 || sharedPreferences.contains("has_share_dev_tips")) {
                                if (mr.dDB.dBr == 2 && !sharedPreferences.contains("has_share_beta_tips")) {
                                    sharedPreferences.edit().putLong("has_share_beta_tips", System.currentTimeMillis()).commit();
                                    com.tencent.mm.ui.base.g.a(appBrandPageActionSheet.dNm.getContext(), 2131236726, 2131231164, false, new DialogInterface.OnClickListener(appBrandPageActionSheet) {
                                        final /* synthetic */ AppBrandPageActionSheet dNp;

                                        {
                                            this.dNp = r1;
                                        }

                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            this.dNp.bqx();
                                        }
                                    });
                                    break;
                                }
                                appBrandPageActionSheet.bqx();
                                break;
                            }
                            sharedPreferences.edit().putLong("has_share_dev_tips", System.currentTimeMillis()).commit();
                            com.tencent.mm.ui.base.g.a(appBrandPageActionSheet.dNm.getContext(), 2131236727, 2131231164, false, new DialogInterface.OnClickListener(appBrandPageActionSheet) {
                                final /* synthetic */ AppBrandPageActionSheet dNp;

                                {
                                    this.dNp = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    this.dNp.bqx();
                                }
                            });
                            break;
                            break;
                        case ShareToTimeLine:
                            appBrandPageActionSheet = this.dNp;
                            if (!com.tencent.mm.plugin.appbrand.h.c.a(com.tencent.mm.plugin.appbrand.a.mr(appBrandPageActionSheet.dzg), appBrandPageActionSheet.dNn.getContext())) {
                                b bVar = new b();
                                Map hashMap = new HashMap();
                                hashMap.put("title", com.tencent.mm.plugin.appbrand.a.mr(appBrandPageActionSheet.dzg).aZU);
                                hashMap.put("desc", "");
                                hashMap.put("path", appBrandPageActionSheet.dNn.dOM);
                                hashMap.put("imgUrl", com.tencent.mm.plugin.appbrand.a.mr(appBrandPageActionSheet.dzg).dDo);
                                bVar.a(appBrandPageActionSheet.dNm).o(hashMap).PX();
                                bk.Ql();
                                break;
                            }
                            break;
                        case EnableDebug:
                            AppBrandPageActionSheet appBrandPageActionSheet2 = this.dNp;
                            context = context;
                            String str = this.dNp.dzg;
                            MainProcessTask setAppDebugModeTask = new SetAppDebugModeTask();
                            setAppDebugModeTask.appId = str;
                            setAppDebugModeTask.aZw = !com.tencent.mm.plugin.appbrand.a.mr(appBrandPageActionSheet2.dzg).dDp;
                            AppBrandMainProcessService.a(setAppDebugModeTask);
                            Toast.makeText(context, setAppDebugModeTask.aZw ? context.getString(2131230922) : context.getString(2131230921), 0).show();
                            if (context instanceof Activity) {
                                ((Activity) context).finish();
                                break;
                            }
                            break;
                        case ShowPkgInfo:
                            Context context2 = context;
                            AppBrandSysConfig mr2 = com.tencent.mm.plugin.appbrand.a.mr(this.dNp.dzg);
                            String str2 = "";
                            str2 = mr2.dDC.dBr == 0 ? str2 + String.format("公共库版本: %d\n", new Object[]{Integer.valueOf(mr2.dDC.dBs)}) : str2 + String.format("测试版公共库更新时间: %s\n", new Object[]{be.ec(mr2.dDC.dBt)});
                            Toast.makeText(context2, mr2.dDB.dBr == 0 ? str2 + String.format("正式包版本: %d", new Object[]{Integer.valueOf(mr2.dDB.dBs)}) : str2 + String.format(com.tencent.mm.plugin.appbrand.appcache.c.gX(mr2.dDB.dBr) + " 更新时间: %s", new Object[]{be.ec(mr2.dDB.dBt)}), 1).show();
                            break;
                        case Exit:
                            if (context instanceof Activity) {
                                ((Activity) context).finish();
                                this.dNp.a(10, "", 1, 0);
                                break;
                            }
                            break;
                        case BackToWeChat:
                            if (mr != null) {
                                if (this.dNp.dNm == null) {
                                    context = aa.getContext();
                                } else {
                                    context = this.dNp.dNm.getContext();
                                }
                                AppBrandStickInChattingPluginLogic.a(context, mr.aZU, mr.aWH, mr.appId, mr.dDB.dBr);
                                this.dNp.a(13, "", 1, 0);
                                com.tencent.mm.plugin.appbrand.c.gV(com.tencent.mm.plugin.appbrand.c.b.dza);
                                com.tencent.mm.plugin.appbrand.report.a.a(context, this.dNp.dzg, "", System.currentTimeMillis(), 6, 0);
                                break;
                            }
                            break;
                        case SendToDesktop:
                            appBrandPageActionSheet = this.dNp;
                            Context context3 = context;
                            Object obj = mr.aWH;
                            int i3 = mr.dDB.dBr;
                            if (!(context3 == null || TextUtils.isEmpty(obj))) {
                                AppBrandMainProcessService.a(new SendShortcutToDesktopTask(obj, i3));
                                appBrandPageActionSheet.a(14, "", 1, 0);
                                z = true;
                            }
                            com.tencent.mm.ui.base.g.bf(context, context.getString(z ? 2131230902 : 2131230901));
                            break;
                        case AboutUs:
                            AppBrandPageActionSheet.a(this.dNp, context);
                            break;
                        default:
                            i2 = 0;
                            break;
                    }
                    if (i2 != 0) {
                        this.dNp.dNk.bKi();
                    }
                }
            }
        };
        if (VERSION.SDK_INT >= 23 && (context instanceof Activity)) {
            this.dNk.pbZ = com.tencent.mm.plugin.appbrand.ui.f.b(((Activity) context).getWindow());
        }
        this.dNk.bKh();
    }

    final void a(int i, String str, int i2, int i3) {
        com.tencent.mm.plugin.appbrand.report.a.a(this.dzg, this.dNn.dOM, i, str, be.Nh(), 1, 0);
    }

    final void bqx() {
        a aVar = new a();
        Map hashMap = new HashMap();
        hashMap.put("title", com.tencent.mm.plugin.appbrand.a.mr(this.dzg).aZU);
        hashMap.put("desc", "");
        hashMap.put("path", this.dNn.dON);
        hashMap.put("imgUrl", com.tencent.mm.plugin.appbrand.a.mr(this.dzg).dDo);
        JsApiShareAppMessage.Ql();
        aVar.a(this.dNm).o(hashMap).PX();
    }
}
