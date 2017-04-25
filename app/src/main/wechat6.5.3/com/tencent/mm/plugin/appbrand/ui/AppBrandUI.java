package com.tencent.mm.plugin.appbrand.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.ActivityManager.TaskDescription;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.b.a.i;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.appbrand.AppBrandTaskUsageRecorder;
import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.page.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController;
import com.tencent.mm.plugin.appbrand.widget.input.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.Iterator;

@a(1)
public class AppBrandUI extends MMActivity implements android.support.v4.app.a.a {
    private f dNh;
    private boolean dSa;
    private AppBrandInitConfig dSb;
    private AppBrandSysConfig dSc;
    private AppBrandStatObject dSd;
    private FrameLayout dSe;
    private e dSf;
    private boolean dSg;
    private boolean dSh;
    private boolean dSj = false;
    private Runnable dSk = new Runnable(this) {
        final /* synthetic */ AppBrandUI dSm;

        {
            this.dSm = r1;
        }

        public final void run() {
            g.iuh.a(369, 11, 1, false);
        }
    };
    private Runnable dSl = new Runnable(this) {
        final /* synthetic */ AppBrandUI dSm;

        {
            this.dSm = r1;
        }

        public final void run() {
            this.dSm.finish();
        }
    };
    private String dzg;
    private AppBrandMainProcessService.a lqB = new AppBrandMainProcessService.a(this) {
        final /* synthetic */ AppBrandUI dSm;
        private boolean dSo = false;

        {
            this.dSm = r2;
        }

        public final void onServiceConnected() {
            if (this.dSo) {
                AppBrandUI.h(this.dSm);
            }
            this.dSo = false;
            v.i("MicroMsg.AppBrandUI", "onServiceConnected(%s)", new Object[]{aa.getProcessName()});
        }

        public final void Rh() {
            this.dSo = true;
            v.i("MicroMsg.AppBrandUI", "onServiceDisconnected(%s)", new Object[]{aa.getProcessName()});
            long timestamp = AppBrandRemoteTaskController.getTimestamp();
            SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "pref_appbrand_process", 4);
            Editor edit = sharedPreferences.edit();
            if (sharedPreferences.getLong("on_wxa_process_connected_time", 0) == timestamp) {
                edit.remove("on_wxa_process_connected_time");
                edit.commit();
                g.iuh.a(365, 1, 1, false);
                v.v("MicroMsg.AppBrandReporter", "delete timestamp(%s) and report(%d)", new Object[]{Long.valueOf(timestamp), Integer.valueOf(365)});
                return;
            }
            v.v("MicroMsg.AppBrandReporter", "do not need to report(%d), timestamp(cur : %s, sp : %s)", new Object[]{Long.valueOf(timestamp), Integer.valueOf(365), Long.valueOf(timestamp), Long.valueOf(sharedPreferences.getLong("on_wxa_process_connected_time", 0))});
        }
    };
    private h lqC = null;
    private Handler mHandler;

    static /* synthetic */ void a(AppBrandUI appBrandUI, AppBrandSysConfig appBrandSysConfig) {
        com.tencent.mm.plugin.appbrand.a.a(appBrandSysConfig);
        com.tencent.mm.plugin.appbrand.a.mt(appBrandSysConfig.appId);
        if (d.dW(21)) {
            Bitmap bitmap;
            int bn = com.tencent.mm.plugin.webview.ui.tools.d.bn(com.tencent.mm.plugin.appbrand.a.mu(appBrandSysConfig.appId).dCs.dCA, -16777216);
            String str = appBrandSysConfig.aZU;
            if (appBrandUI.dSf != null) {
                e eVar = appBrandUI.dSf;
                if (!(eVar.dSq == null || eVar.dSq.getDrawable() == null)) {
                    if (eVar.dSq.getDrawable() instanceof BitmapDrawable) {
                        bitmap = ((BitmapDrawable) eVar.dSq.getDrawable()).getBitmap();
                    } else if (eVar.dSq.getDrawable() instanceof i) {
                        bitmap = ((i) eVar.dSq.getDrawable()).mBitmap;
                    }
                    appBrandUI.setTaskDescription(new TaskDescription(str, bitmap, bn));
                }
            }
            bitmap = null;
            appBrandUI.setTaskDescription(new TaskDescription(str, bitmap, bn));
        }
        appBrandUI.a(appBrandSysConfig, appBrandUI.dSd, false);
        com.tencent.mm.plugin.appbrand.a.a(appBrandSysConfig.appId, new com.tencent.mm.plugin.appbrand.f(appBrandUI, appBrandSysConfig.appId));
        appBrandUI.dNh = new f(appBrandUI, appBrandSysConfig.appId);
        com.tencent.mm.plugin.appbrand.a.a(appBrandSysConfig.appId, appBrandUI.dNh);
        appBrandUI.dNh.dNI = new f.a(appBrandUI) {
            final /* synthetic */ AppBrandUI dSm;

            {
                this.dSm = r1;
            }

            public final void Ro() {
                this.dSm.runOnUiThread(new Runnable(this) {
                    final /* synthetic */ AnonymousClass2 dSn;

                    {
                        this.dSn = r1;
                    }

                    public final void run() {
                        AppBrandUI.e(this.dSn.dSm);
                        AppBrandUI.f(this.dSn.dSm);
                    }
                });
            }
        };
        appBrandUI.dSe.addView(appBrandUI.dNh, 0);
        if (be.kS(appBrandUI.dSb.dDn)) {
            f fVar = appBrandUI.dNh;
            fVar.dNG.dNX = 1;
            fVar.nY(fVar.dNB.Pv());
        } else {
            appBrandUI.dNh.nY(appBrandUI.dSb.dDn);
        }
        com.tencent.mm.plugin.appbrand.page.d.nX(appBrandUI.dzg);
        appBrandUI.dNh.Rn();
        AppBrandTaskUsageRecorder.a(appBrandUI.dSc, false);
        g.iuh.a(369, 2, 1, false);
    }

    static /* synthetic */ void e(AppBrandUI appBrandUI) {
        if (appBrandUI.dSf == null) {
            v.e("MicroMsg.AppBrandUI", "hideSplash, splash view null");
            return;
        }
        e eVar = appBrandUI.dSf;
        eVar.postDelayed(new Runnable(eVar) {
            final /* synthetic */ e dSx;

            {
                this.dSx = r1;
            }

            public final void run() {
                final ViewParent parent = this.dSx.getParent();
                if (parent instanceof ViewGroup) {
                    this.dSx.pQW.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter(this) {
                        final /* synthetic */ AnonymousClass1 dSz;

                        public final void onAnimationEnd(Animator animator) {
                            ((ViewGroup) parent).removeView(this.dSz.dSx);
                        }
                    }).start();
                    this.dSx.dSq.animate().scaleX(0.0f).scaleY(0.0f).translationY((float) (-(this.dSx.dSq.getHeight() / 2))).setInterpolator(new DecelerateInterpolator()).start();
                    this.dSx.dSr.animate().translationX((float) (this.dSx.lqF.getLeft() - this.dSx.dSr.getLeft())).translationY((float) (-this.dSx.dSr.getTop())).setInterpolator(new DecelerateInterpolator()).start();
                    this.dSx.dSs.animate().alpha(0.0f).translationY((float) (-this.dSx.dSs.getTop())).setInterpolator(new DecelerateInterpolator()).start();
                }
            }
        }, 100);
        appBrandUI.dSf = null;
    }

    static /* synthetic */ void f(AppBrandUI appBrandUI) {
        long currentTimeMillis = System.currentTimeMillis() - appBrandUI.dSb.startTime;
        com.tencent.mm.plugin.appbrand.report.a.c(currentTimeMillis, appBrandUI.dSj);
        String str = "MicroMsg.AppBrandUI";
        String str2 = "onHideSplash: %s, cost: %dms, download : %b";
        Object[] objArr = new Object[3];
        objArr[0] = appBrandUI.dSb != null ? appBrandUI.dSb.aZU : "";
        objArr[1] = Long.valueOf(currentTimeMillis);
        objArr[2] = Boolean.valueOf(appBrandUI.dSj);
        v.i(str, str2, objArr);
        com.tencent.mm.plugin.appbrand.report.a.n(6, System.currentTimeMillis() - appBrandUI.dSb.startTime);
        com.tencent.mm.plugin.appbrand.report.a.ok(appBrandUI.dzg);
    }

    static /* synthetic */ void g(AppBrandUI appBrandUI) {
        if (appBrandUI.lqC == null || !appBrandUI.lqC.isShowing()) {
            a aVar = new a(appBrandUI);
            aVar.Oq(appBrandUI.getString(2131236725));
            aVar.jk(false);
            aVar.wp(2131230918).a(new OnClickListener(appBrandUI) {
                final /* synthetic */ AppBrandUI dSm;

                {
                    this.dSm = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    this.dSm.finish();
                    AppBrandRemoteTaskController.bRz();
                }
            });
            appBrandUI.lqC = aVar.RX();
            appBrandUI.lqC.show();
        }
    }

    static /* synthetic */ void h(AppBrandUI appBrandUI) {
        AppBrandRemoteTaskController.RO();
        MMToClientEvent.nn(appBrandUI.dzg);
        c.mB(appBrandUI.dzg);
        if (appBrandUI.dSa) {
            v.e("MicroMsg.AppBrandUI", "Main Process Restarted, start prepare again");
            appBrandUI.bRO();
        }
    }

    static /* synthetic */ void j(AppBrandUI appBrandUI) {
        v.i("MicroMsg.AppBrandUI", "ResourceReady: %b, WebViewReady: %b", new Object[]{Boolean.valueOf(appBrandUI.dSg), Boolean.valueOf(appBrandUI.dSh)});
        if (appBrandUI.dSg && appBrandUI.dSh) {
            appBrandUI.runOnUiThread(new Runnable(appBrandUI) {
                final /* synthetic */ AppBrandUI dSm;

                {
                    this.dSm = r1;
                }

                public final void run() {
                    AppBrandUI.a(this.dSm, this.dSm.dSc);
                    this.dSm.dSa = false;
                    this.dSm.mHandler.removeCallbacks(this.dSm.dSk);
                }
            });
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mHandler = new Handler();
        this.dSe = new FrameLayout(this.nDR.nEl);
        this.dSe.setLayoutParams(new LayoutParams(-1, -1));
        setContentView(this.dSe);
        e.a((MMActivity) this, this.dSe);
        Bundle extras = getIntent().getExtras();
        extras.setClassLoader(AppBrandInitConfig.class.getClassLoader());
        this.dSb = (AppBrandInitConfig) extras.getParcelable("key_appbrand_init_config");
        this.dSd = (AppBrandStatObject) extras.getParcelable("key_appbrand_stat_object");
        this.dSa = true;
        bRF();
        if (((getIntent().getFlags() & 1048576) != 0) && this.dSb != null) {
            this.dSb.startTime = System.currentTimeMillis();
        }
    }

    public void onNewIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        extras.setClassLoader(AppBrandInitConfig.class.getClassLoader());
        AppBrandInitConfig appBrandInitConfig = (AppBrandInitConfig) extras.getParcelable("key_appbrand_init_config");
        this.dSd = (AppBrandStatObject) extras.getParcelable("key_appbrand_stat_object");
        if (appBrandInitConfig != null) {
            boolean z;
            if (this.dSb == null || appBrandInitConfig == null) {
                z = false;
            } else if (!appBrandInitConfig.appId.equals(this.dzg)) {
                z = true;
            } else if (appBrandInitConfig.dzx != this.dSb.dzx) {
                z = true;
            } else {
                Object Pv = com.tencent.mm.plugin.appbrand.a.mu(this.dzg).Pv();
                String str = be.kS(appBrandInitConfig.dDn) ? Pv : appBrandInitConfig.dDn;
                if (!be.kS(this.dSb.dDn)) {
                    Pv = this.dSb.dDn;
                }
                z = !str.equals(Pv);
            }
            if (z) {
                this.dSb = appBrandInitConfig;
                this.dSa = true;
            } else if (!this.dSa) {
                a(this.dSc, this.dSd, true);
            }
        }
        bRF();
    }

    public void onResume() {
        super.onResume();
        v.i("MicroMsg.AppBrandUI", "onResume");
        if (!this.dSa) {
            this.dNh.Rn();
            AppBrandRemoteTaskController.RO();
            AppBrandTaskUsageRecorder.a(this.dSc, true);
            c.gV(b.dyZ);
            com.tencent.mm.plugin.appbrand.page.d.nX(this.dzg);
            this.mHandler.removeCallbacks(this.dSl);
            c.mA(this.dzg);
        } else if (this.dSb == null) {
            finish();
        } else {
            AppBrandInitConfig appBrandInitConfig = this.dSb;
            com.tencent.mm.plugin.appbrand.report.a.n(0, System.currentTimeMillis() - appBrandInitConfig.startTime);
            String str = appBrandInitConfig.iconUrl;
            String str2 = appBrandInitConfig.aZU;
            e eVar = new e(this);
            eVar.as(str, str2);
            if (bRE()) {
                eVar.dSw = true;
                eVar.lqE.bF(true);
            }
            if (this.dSf == null) {
                this.dSf = eVar;
                this.dSe.addView(this.dSf, -1, -1);
            }
            OE();
            this.dzg = appBrandInitConfig.appId;
            this.dSb = appBrandInitConfig;
            this.dSc = null;
            this.dSg = false;
            this.dSh = false;
            v.i("MicroMsg.AppBrandUI", "appOnCreate: %s, %s", new Object[]{this.dSb.aZU, this.dSb.appId});
            AppBrandMainProcessService.a(this.lqB);
            AppBrandRemoteTaskController.a(this.dSb, getClass().getCanonicalName());
            AppBrandRemoteTaskController.a(new AppBrandRemoteTaskController.a(this) {
                final /* synthetic */ AppBrandUI dSm;

                {
                    this.dSm = r1;
                }

                public final void remove() {
                    this.dSm.finish();
                }

                public final void bRB() {
                    AppBrandUI.g(this.dSm);
                }
            });
            AppBrandRemoteTaskController.RO();
            MMToClientEvent.nn(this.dzg);
            c.mx(this.dzg);
            final long currentTimeMillis = System.currentTimeMillis();
            com.tencent.mm.pluginsdk.model.v.di("weapp_id", this.dSb.appId);
            com.tencent.mm.pluginsdk.model.v.di("weapp_name", this.dSb.aZU);
            com.tencent.mm.plugin.appbrand.task.a.a(new com.tencent.mm.plugin.appbrand.task.a.a(this) {
                final /* synthetic */ AppBrandUI dSm;

                public final void onReady() {
                    this.dSm.dSh = true;
                    com.tencent.mm.plugin.appbrand.report.a.n(2, System.currentTimeMillis() - currentTimeMillis);
                    AppBrandUI.j(this.dSm);
                }
            });
            bRO();
            g.iuh.a(369, 1, 1, false);
            this.mHandler.postDelayed(this.dSk, 10000);
        }
    }

    public void onPause() {
        super.onPause();
        v.i("MicroMsg.AppBrandUI", "onPause");
        if (!this.dSa) {
            f fVar = this.dNh;
            if (fVar.dNC.size() != 0) {
                ((com.tencent.mm.plugin.appbrand.page.e) fVar.dNC.getFirst()).QX();
                fVar.dNG.dNZ = System.currentTimeMillis();
            }
            com.tencent.mm.plugin.appbrand.page.c.nX(this.dzg);
            this.mHandler.postDelayed(this.dSl, (long) (this.dSc.dDs * BaseReportManager.MAX_READ_COUNT));
            c.mz(this.dzg);
        }
    }

    private void OE() {
        if (!be.kS(this.dzg)) {
            com.tencent.mm.plugin.appbrand.a.mv(this.dzg);
            com.tencent.mm.plugin.appbrand.a.a(this.dzg, null);
            com.tencent.mm.plugin.appbrand.a.a(this.dzg, null);
            c.mC(this.dzg);
        }
        if (this.dNh != null) {
            this.dSe.removeView(this.dNh);
            this.dNh.OE();
        }
        axg();
    }

    public void finish() {
        if (VERSION.SDK_INT >= 21) {
            finishAndRemoveTask();
        } else {
            super.finish();
        }
        bRG();
        com.tencent.mm.plugin.appbrand.report.a.RK();
    }

    public boolean moveTaskToBack(boolean z) {
        boolean moveTaskToBack = super.moveTaskToBack(z);
        bRG();
        return moveTaskToBack;
    }

    public void onDestroy() {
        super.onDestroy();
        v.i("MicroMsg.AppBrandUI", "onDestroy: %s, %s", new Object[]{this.dSb.aZU, this.dSb.appId});
        if (this.dSb != null) {
            AppBrandMainProcessService.b(this.lqB);
            AppBrandRemoteTaskController.RP();
            MMToClientEvent.no(this.dzg);
            c.my(this.dzg);
        }
        OE();
        AppBrandRemoteTaskController.RQ();
    }

    public void onBackPressed() {
        if (this.dSf != null || this.dNh == null) {
            finish();
            return;
        }
        Object obj;
        f fVar = this.dNh;
        com.tencent.mm.plugin.appbrand.page.h QZ = fVar.Rm().QZ();
        if (QZ.dOf.size() == 0) {
            obj = null;
        } else {
            QZ.runOnUiThread(new Runnable(QZ) {
                final /* synthetic */ h dOj;

                {
                    this.dOj = r1;
                }

                public final void run() {
                    Iterator it = this.dOj.dOf.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
            });
            obj = 1;
        }
        if (obj == null) {
            fVar.Rl();
        }
    }

    protected final void PK() {
        super.PK();
        getWindow().requestFeature(10);
        getWindow().getDecorView().setFitsSystemWindows(true);
        aq(10);
        aq(1);
        e.a(this);
    }

    protected final int NO() {
        return 1;
    }

    public final boolean Sk() {
        return true;
    }

    protected final int getLayoutId() {
        return -1;
    }

    private void a(AppBrandSysConfig appBrandSysConfig, AppBrandStatObject appBrandStatObject, boolean z) {
        AppBrandIDKeyBatchReport.RD().dPz = 1;
        AppBrandMainProcessService.a(AppBrandIDKeyBatchReport.RD());
        if (appBrandStatObject == null) {
            v.e("MicroMsg.AppBrandUI", "statObject is null!");
            return;
        }
        appBrandStatObject.appId = appBrandSysConfig.appId;
        appBrandStatObject.aZj = "SessionId@" + hashCode() + "#" + System.currentTimeMillis();
        appBrandStatObject.bpy = appBrandSysConfig.dDB.dBs;
        appBrandStatObject.dJB = appBrandSysConfig.dDB.dBr + 1;
        appBrandStatObject.dPB = com.tencent.mm.plugin.appbrand.report.a.br(this);
        appBrandStatObject.isInit = z;
        appBrandStatObject.dPP = 0;
        appBrandStatObject.dPR = 0;
        appBrandStatObject.dPS = "";
        appBrandStatObject.dPT = "";
        com.tencent.mm.plugin.appbrand.a.a(appBrandStatObject);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.tencent.mm.plugin.appbrand.a.a(this.dzg, i, strArr, iArr);
    }

    public void onTrimMemory(int i) {
        v.i("MicroMsg.AppBrandUI", "onTrimMemory, level = %d", new Object[]{Integer.valueOf(i)});
    }

    private void bRO() {
        final long currentTimeMillis = System.currentTimeMillis();
        MainProcessTask appBrandPrepareTask = new AppBrandPrepareTask(this.dSb.aWH, this.dSb.dzx, bRD());
        appBrandPrepareTask.dRy = new a(this) {
            final /* synthetic */ AppBrandUI dSm;

            public final void e(final AppBrandSysConfig appBrandSysConfig) {
                if (!this.dSm.nDT && !this.dSm.isFinishing()) {
                    if (appBrandSysConfig == null) {
                        g.iuh.a(369, 3, 1, false);
                        this.dSm.finish();
                        return;
                    }
                    com.tencent.mm.plugin.appbrand.report.a.n(1, System.currentTimeMillis() - currentTimeMillis);
                    this.dSm.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass6 dSp;

                        public final void run() {
                            if (this.dSp.dSm.dSf != null) {
                                this.dSp.dSm.dSf.as(appBrandSysConfig.dDo, appBrandSysConfig.aZU);
                            }
                            this.dSp.dSm.dSc = appBrandSysConfig;
                            this.dSp.dSm.dSg = true;
                            AppBrandUI.j(this.dSp.dSm);
                        }
                    });
                }
            }

            public final void Sh() {
                this.dSm.dSj = true;
            }
        };
        com.tencent.mm.plugin.appbrand.k.a.aC(appBrandPrepareTask);
        AppBrandMainProcessService.a(appBrandPrepareTask);
        this.dSj = false;
    }

    private int bRD() {
        if (this.dSd == null) {
            return 0;
        }
        return this.dSd.scene;
    }

    private boolean bRE() {
        return bRD() == 1023;
    }

    private void bRF() {
        if (this.dSb != null) {
            if (bRE()) {
                com.tencent.mm.plugin.appbrand.k.a.bt(this.nDR.nEl);
            } else {
                com.tencent.mm.plugin.appbrand.k.a.hG(this.nDR.nEl);
            }
        }
    }

    private void bRG() {
        if (this.dSb != null) {
            com.tencent.mm.plugin.appbrand.k.a.bu(this.nDR.nEl);
        }
    }
}
