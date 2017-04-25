package com.tencent.mm.plugin.appbrand.ui;

import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import com.tencent.mm.plugin.appbrand.jsapi.bu;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.d.d;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.j;
import com.tencent.smtt.sdk.n;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.s;

@com.tencent.mm.ui.base.a(7)
public final class AppBrandTBSDownloadProxyUI extends MMActivity {
    private a dRV = null;
    p dwg;

    private final class a implements n {
        final /* synthetic */ AppBrandTBSDownloadProxyUI dRW;

        private a(AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI) {
            this.dRW = appBrandTBSDownloadProxyUI;
        }

        public final void hp(int i) {
            v.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onDownloadFinish, result = %d", new Object[]{Integer.valueOf(i)});
            k.cq(5, i);
            if (i == 100 || i == 120 || i == bu.CTRL_INDEX) {
                g.iuh.a(366, 4, 1, false);
            } else {
                g.iuh.a(366, 5, 1, false);
            }
            SharedPreferences sharedPreferences;
            if (i != 110) {
                if (i == 100 || i == 120 || i == bu.CTRL_INDEX) {
                    g.iuh.ch(4, 3);
                } else {
                    this.dRW.dRV = null;
                    QbSdk.setTbsListener(this.dRW.dRV);
                    g.iuh.a(64, 3, 1, false);
                    this.dRW.setResult(0, new Intent());
                    this.dRW.finish();
                }
                sharedPreferences = aa.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
                if (sharedPreferences != null) {
                    v.i("MicroMsg.AppBrandTBSDownloadProxyUI", "tbs has download finished, save to sharedpreference");
                    Editor edit = sharedPreferences.edit();
                    edit.putBoolean("tbs_download_finished", true);
                    edit.apply();
                    return;
                }
                return;
            }
            sharedPreferences = aa.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
            if (sharedPreferences != null) {
                v.i("MicroMsg.AppBrandTBSDownloadProxyUI", "tbs has download finished, save to sharedpreference");
                edit = sharedPreferences.edit();
                edit.putBoolean("tbs_download_finished", true);
                edit.apply();
            }
            this.dRW.dRV = null;
            QbSdk.setTbsListener(this.dRW.dRV);
            this.dRW.setResult(0, new Intent());
            this.dRW.finish();
        }

        public final void hq(int i) {
            v.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onInstallFinish, result = %d", new Object[]{Integer.valueOf(i)});
            if (this.dRW.dwg != null) {
                this.dRW.dwg.dismiss();
                this.dRW.dwg = null;
            }
            k.cq(6, i);
            if (i == 200 || i == 220) {
                g.iuh.ch(7, 6);
                g.iuh.a(366, 6, 1, false);
                v.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onInstallFinish, restart tool");
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(d.nzM, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
                this.dRW.sendBroadcast(intent);
                this.dRW.dRV = null;
                QbSdk.setTbsListener(this.dRW.dRV);
                this.dRW.setResult(-1, new Intent());
                this.dRW.finish();
                return;
            }
            g.iuh.a(64, 6, 1, false);
            g.iuh.a(366, 7, 1, false);
            this.dRW.dRV = null;
            QbSdk.setTbsListener(this.dRW.dRV);
            this.dRW.setResult(0, new Intent());
            this.dRW.finish();
        }

        public final void hr(final int i) {
            v.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onDownloadProgress, percent = %d", new Object[]{Integer.valueOf(i)});
            if (this.dRW.dwg != null) {
                ad.o(new Runnable(this) {
                    final /* synthetic */ a dRZ;

                    public final void run() {
                        this.dRZ.dRW.dwg.setMessage(this.dRZ.dRW.nDR.nEl.getString(2131231009, new Object[]{String.valueOf(i)}));
                    }
                });
            }
        }
    }

    static /* synthetic */ void a(AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI) {
        OnClickListener anonymousClass4 = new OnClickListener(appBrandTBSDownloadProxyUI) {
            final /* synthetic */ AppBrandTBSDownloadProxyUI dRW;

            {
                this.dRW = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                g.iuh.a(366, 2, 1, false);
                com.tencent.mm.pluginsdk.model.v.a.hN(false);
                k.kZ(2);
                AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI = this.dRW;
                ActionBarActivity actionBarActivity = this.dRW.nDR.nEl;
                this.dRW.nDR.nEl.getString(2131231164);
                appBrandTBSDownloadProxyUI.dwg = com.tencent.mm.ui.base.g.a(actionBarActivity, this.dRW.nDR.nEl.getString(2131231008), true, null);
                this.dRW.dwg.setOnCancelListener(new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass4 dRY;

                    {
                        this.dRY = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        v.i("MicroMsg.AppBrandTBSDownloadProxyUI", "cancel loading download background");
                        this.dRY.dRW.setResult(2, new Intent());
                        this.dRY.dRW.finish();
                    }
                });
                AppBrandTBSDownloadProxyUI.b(this.dRW);
            }
        };
        OnClickListener anonymousClass5 = new OnClickListener(appBrandTBSDownloadProxyUI) {
            final /* synthetic */ AppBrandTBSDownloadProxyUI dRW;

            {
                this.dRW = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                g.iuh.a(366, 3, 1, false);
                v.i("MicroMsg.AppBrandTBSDownloadProxyUI", "user cancel");
                com.tencent.mm.pluginsdk.model.v.a.hN(false);
                this.dRW.setResult(2, new Intent());
                this.dRW.finish();
            }
        };
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(appBrandTBSDownloadProxyUI.nDR.nEl);
        aVar.Oq(appBrandTBSDownloadProxyUI.nDR.nEl.getString(2131231007));
        aVar.jk(false);
        aVar.wp(2131231006).a(anonymousClass4);
        aVar.wq(2131231005).b(anonymousClass5);
        aVar.RX().show();
        com.tencent.mm.pluginsdk.model.v.a.hN(true);
    }

    static /* synthetic */ void b(AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI) {
        if (appBrandTBSDownloadProxyUI.dRV == null) {
            appBrandTBSDownloadProxyUI.dRV = new a();
        }
        QbSdk.setTbsListener(appBrandTBSDownloadProxyUI.dRV);
        k.kZ(3);
        j.p(aa.getContext(), true);
    }

    static {
        TbsLog.setTbsLogClient(new s(aa.getContext()) {
            public final void i(String str, String str2) {
                v.i(str, str2);
            }

            public final void e(String str, String str2) {
                v.e(str, str2);
            }

            public final void w(String str, String str2) {
                v.w(str, str2);
            }

            public final void d(String str, String str2) {
                v.d(str, str2);
            }

            public final void v(String str, String str2) {
                v.v(str, str2);
            }

            public final void ot(String str) {
                v.i("AppBrandTBSDownloadProxyUI.TBSDownloadMgr.TbsLogClient", "TbsLogClient: " + str);
            }
        });
    }

    protected final int getLayoutId() {
        return -1;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onCreate");
        f.a(getWindow());
        v.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onCreate, kill tool");
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(d.nzM, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
        sendBroadcast(intent);
        boolean alC = j.alC();
        boolean tBSInstalling = QbSdk.getTBSInstalling();
        boolean bNc = j.bNc();
        v.i("MicroMsg.AppBrandTBSDownloadProxyUI", "now status, downloading = %b, installing = %b", new Object[]{Boolean.valueOf(alC), Boolean.valueOf(tBSInstalling)});
        if (alC || tBSInstalling) {
            if (bNc) {
                v.i("MicroMsg.AppBrandTBSDownloadProxyUI", "is foreground download");
                if (this.dRV == null) {
                    this.dRV = new a();
                }
                QbSdk.setTbsListener(this.dRV);
                v.i("MicroMsg.AppBrandTBSDownloadProxyUI", "is foreground download TBS already downloading, ignore duplicated request");
                ActionBarActivity actionBarActivity = this.nDR.nEl;
                this.nDR.nEl.getString(2131231164);
                this.dwg = com.tencent.mm.ui.base.g.a(actionBarActivity, this.nDR.nEl.getString(2131231008), true, null);
                this.dwg.setOnCancelListener(new OnCancelListener(this) {
                    final /* synthetic */ AppBrandTBSDownloadProxyUI dRW;

                    {
                        this.dRW = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        v.i("MicroMsg.AppBrandTBSDownloadProxyUI", "cancle loading download background");
                        this.dRW.setResult(2, new Intent());
                        this.dRW.finish();
                    }
                });
                return;
            }
            v.i("MicroMsg.AppBrandTBSDownloadProxyUI", "isBackGroundDownload reset download");
            j.stopDownload();
        }
        v.i("MicroMsg.AppBrandTBSDownloadProxyUI", "try to get need download");
        j.a(this.nDR.nEl, false, true, new com.tencent.smtt.sdk.j.a(this) {
            final /* synthetic */ AppBrandTBSDownloadProxyUI dRW;

            {
                this.dRW = r1;
            }

            public final void d(boolean z, int i) {
                if (!z || i < 36824) {
                    v.i("MicroMsg.AppBrandTBSDownloadProxyUI", "try to get need download fail result %s version %d", new Object[]{Boolean.valueOf(z), Integer.valueOf(i)});
                    this.dRW.setResult(0, new Intent());
                    this.dRW.finish();
                    return;
                }
                v.i("MicroMsg.AppBrandTBSDownloadProxyUI", "try to get need download success result %s version %d", new Object[]{Boolean.valueOf(z), Integer.valueOf(i)});
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass3 dRX;

                    {
                        this.dRX = r1;
                    }

                    public final void run() {
                        v.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onNeedDownloadFinish : showDialog");
                        AppBrandTBSDownloadProxyUI.a(this.dRX.dRW);
                    }
                });
            }
        });
    }

    protected final void onDestroy() {
        v.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onDestroy");
        super.onDestroy();
    }
}
