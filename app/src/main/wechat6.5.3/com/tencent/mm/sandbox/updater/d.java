package com.tencent.mm.sandbox.updater;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.j;
import com.tencent.smtt.sdk.n;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.s;

public final class d implements a {
    private Intent intent;
    private Notification kkd;
    private a ngi;
    private int ngj;
    private boolean ngk;
    private boolean ngl;

    private static final class b {
        public static final d ngn = new d();
    }

    private final class a implements n {
        final /* synthetic */ d ngm;

        private a(d dVar) {
            this.ngm = dVar;
        }

        public final void hp(int i) {
            v.i("MicroMsg.MyTbsListener", "onDownloadFinish, result = %d", Integer.valueOf(i));
            k.cq(5, i);
            if (i != MMGIFException.D_GIF_ERR_CLOSE_FAILED) {
                if (i == 100) {
                    g.iuh.ch(4, 3);
                } else {
                    g.iuh.a(64, 3, 1, false);
                }
            }
            SharedPreferences sharedPreferences = aa.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
            if (sharedPreferences != null) {
                v.i("MicroMsg.MyTbsListener", "tbs has download finished, save to sharedpreference");
                Editor edit = sharedPreferences.edit();
                edit.putBoolean("tbs_download_finished", true);
                edit.apply();
            }
        }

        public final void hq(int i) {
            v.i("MicroMsg.MyTbsListener", "onInstallFinish, result = %d", Integer.valueOf(i));
            k.cq(6, i);
            if (i == 200 || i == 220) {
                g.iuh.ch(7, 6);
                d.a(this.ngm);
                return;
            }
            g.iuh.a(64, 6, 1, false);
        }

        public final void hr(int i) {
        }
    }

    static /* synthetic */ void a(d dVar) {
        if (dVar.ngk) {
            String bf = be.bf(aa.getContext());
            v.i("MicroMsg.TBSDownloadMgr", "topActivityName = %s", bf);
            Editor edit = aa.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
            edit.putString("tbs_download", "1");
            edit.putString("tbs_enable", "1");
            edit.putString("tbs_supported_ver_sec", "25406,99999999");
            edit.apply();
            if (be.kS(bf) || !bf.equalsIgnoreCase("com.tencent.mm.plugin.webview.ui.tools.WebViewUI")) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(com.tencent.mm.ui.d.d.nzM, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
                aa.getContext().sendBroadcast(intent);
                Context context = aa.getContext();
                android.support.v4.app.w.d dVar2 = new android.support.v4.app.w.d(context);
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                dVar2.L(com.tencent.mm.ax.a.bmo());
                dVar2.a(context.getString(2131236621));
                dVar2.b(context.getString(2131236620));
                dVar2.j(2, false);
                dVar2.o(true);
                dVar2.rI = PendingIntent.getActivity(aa.getContext(), 0, new Intent(), 0);
                dVar.kkd = dVar2.build();
                notificationManager.notify(dVar.ngj, dVar.kkd);
                intent = new Intent();
                intent.setComponent(new ComponentName(com.tencent.mm.ui.d.d.nzM, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
                aa.getContext().sendBroadcast(intent);
            }
        }
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
                v.i("TBSDownloadMgr.TbsLogClient", "TbsLogClient: " + str);
            }
        });
    }

    public static d bso() {
        return b.ngn;
    }

    private d() {
        this.ngi = null;
        this.intent = new Intent();
        this.kkd = null;
        this.ngj = TbsLog.TBSLOG_CODE_SDK_INIT;
        this.ngk = false;
        this.ngl = false;
    }

    public final void ir(boolean z) {
        if (this.ngi == null) {
            v.w("MicroMsg.TBSDownloadMgr", "TBS download not inited, ignore");
            return;
        }
        Context context = aa.getContext();
        boolean alC = j.alC();
        boolean o = j.o(context, this.ngk | this.ngl);
        boolean booleanExtra = this.intent.getBooleanExtra("intent_extra_download_ignore_network_type", false);
        boolean bNc = j.bNc();
        v.i("MicroMsg.TBSDownloadMgr", "setNetStatChanged, isWifi = %b, downloading = %b, needDownload = %b, ignoreNetworkType = %b", Boolean.valueOf(z), Boolean.valueOf(alC), Boolean.valueOf(o), Boolean.valueOf(booleanExtra));
        if ((z || booleanExtra) && !alC && o) {
            bsp();
            k.kZ(3);
        } else if (!z && !booleanExtra && alC && !bNc) {
            j.stopDownload();
            k.kZ(4);
        }
    }

    private void bsp() {
        j.fd(aa.getContext());
        SharedPreferences sharedPreferences = aa.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
        if (sharedPreferences != null) {
            v.i("MicroMsg.TBSDownloadMgr", "now start download,hasDownloadOverSea over sea = %b, is now oversea = %b", Boolean.valueOf(this.ngl), Boolean.valueOf(this.ngk));
            if (this.ngl || this.ngk) {
                sharedPreferences.edit().putBoolean("tbs_download_oversea", true).commit();
            }
        }
    }

    public final boolean R(Intent intent) {
        this.intent = intent;
        this.ngk = this.intent.getIntExtra("intent_extra_download_type", 1) == 2;
        SharedPreferences sharedPreferences = aa.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
        if (sharedPreferences != null) {
            this.ngl = sharedPreferences.getBoolean("tbs_download_oversea", false);
        }
        v.i("MicroMsg.TBSDownloadMgr", "isOverSea = %b, hasDownloadOverSea = %b", Boolean.valueOf(this.ngk), Boolean.valueOf(this.ngl));
        if (j.alC()) {
            v.i("MicroMsg.TBSDownloadMgr", "TBS already downloading, ignore duplicated request");
            return true;
        }
        Context context = aa.getContext();
        int tbsCoreVersion = WebView.getTbsCoreVersion(context);
        v.i("MicroMsg.TBSDownloadMgr", "TBS download, tbsCoreVersion = %d, needDownload = %b, isWifi = %b, ignoreNetworkType = %b", Integer.valueOf(tbsCoreVersion), Boolean.valueOf(j.o(context, this.ngk | this.ngl)), Boolean.valueOf(ak.isWifi(context)), Boolean.valueOf(this.intent.getBooleanExtra("intent_extra_download_ignore_network_type", false)));
        if ((!ak.isWifi(context) && !r5) || !r4) {
            return false;
        }
        if (this.ngi == null) {
            this.ngi = new a();
            QbSdk.setTbsListener(this.ngi);
            k.kZ(2);
        }
        bsp();
        k.kZ(3);
        return true;
    }

    public final boolean isBusy() {
        v.i("MicroMsg.TBSDownloadMgr", "isBusy isDownloading = %b, isInstalling = %b", Boolean.valueOf(j.alC()), Boolean.valueOf(QbSdk.getTBSInstalling()));
        if (j.alC() || r3) {
            return true;
        }
        return false;
    }

    public final void onDestroy() {
        v.i("MicroMsg.TBSDownloadMgr", "onDestroy");
    }
}
