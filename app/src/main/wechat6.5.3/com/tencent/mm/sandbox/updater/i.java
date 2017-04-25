package com.tencent.mm.sandbox.updater;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.modelcontrol.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aqx;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sandbox.updater.e.AnonymousClass3;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public final class i implements a, f {
    public int aPY;
    public String aQa;
    public String aZy;
    public int bgA;
    public byte[] cAN;
    public String desc;
    public byte[] dlf;
    public byte[] dlh;
    private Intent intent;
    public int jHv;
    private Notification kkd;
    protected Context mContext;
    public String[] nfS;
    public int nfp;
    c ngH;
    ArrayList<f> ngI;
    public String[] ngJ;
    public String ngK;
    public com.tencent.mm.b.i ngL;
    public com.tencent.mm.b.i.a ngM;
    public boolean ngN;
    public boolean ngO;
    public boolean ngP;
    public String ngQ;
    boolean ngR;
    long ngS;
    e ngT;
    private long ngU;
    private com.tencent.mm.sandbox.b.a ngV;
    public int size;
    public int uin;

    private static final class a {
        public static final i ngY = new i();
    }

    static /* synthetic */ void a(i iVar, int i, int i2) {
        CharSequence string = iVar.mContext.getString(2131231026);
        if (i < i2) {
            long j = (((long) i) * 100) / ((long) i2);
            if (j - iVar.ngU >= 1) {
                iVar.ngU = j;
                CharSequence charSequence = iVar.mContext.getString(2131231029) + String.valueOf(iVar.ngU) + "%";
                Intent intent = new Intent(iVar.intent);
                intent.setClass(iVar.mContext, AppUpdaterUI.class);
                intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                Builder contentIntent = new Builder(iVar.mContext).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(string).setContentText(charSequence).setContentIntent(PendingIntent.getActivity(iVar.mContext, 0, intent, 134217728));
                contentIntent.setLargeIcon(BitmapFactory.decodeResource(iVar.mContext.getResources(), 2130839359));
                contentIntent.setSmallIcon(com.tencent.mm.ax.a.bmo());
                iVar.kkd = contentIntent.getNotification();
                iVar.kkd.icon = 2130839359;
            } else {
                return;
            }
        }
        charSequence = iVar.mContext.getString(2131231025);
        intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(new File(iVar.ngH.bsf())), "application/vnd.android.package-archive");
        intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
        contentIntent = new Builder(iVar.mContext).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(string).setContentText(charSequence).setContentIntent(PendingIntent.getActivity(iVar.mContext, 0, intent, 134217728));
        contentIntent.setLargeIcon(BitmapFactory.decodeResource(iVar.mContext.getResources(), 2130839359));
        contentIntent.setSmallIcon(com.tencent.mm.ax.a.bmo());
        iVar.kkd = contentIntent.getNotification();
        iVar.kkd.icon = 2130839359;
        Notification notification = iVar.kkd;
        notification.flags |= 16;
        if (!iVar.ngO) {
            ((NotificationManager) iVar.mContext.getSystemService("notification")).notify(99, iVar.kkd);
        }
    }

    static /* synthetic */ void b(i iVar) {
        v.i("MicroMsg.UpdaterManager", "showDownloadFullPackNotification()");
        CharSequence string = iVar.mContext.getString(2131231028, new Object[]{be.aw((long) iVar.size)});
        Intent intent = iVar.intent;
        intent.putExtra("intent_extra_force_download_full", true);
        iVar.kkd = new Builder(iVar.mContext).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(string).setContentText(null).setContentIntent(PendingIntent.getService(iVar.mContext, 0, intent, 134217728)).getNotification();
        iVar.kkd.icon = 2130839359;
        Notification notification = iVar.kkd;
        notification.flags |= 16;
        ((NotificationManager) iVar.mContext.getSystemService("notification")).notify(99, iVar.kkd);
    }

    static /* synthetic */ void e(i iVar) {
        CharSequence string = iVar.mContext.getString(2131231027);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://weixin.qq.com/m"));
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        iVar.kkd = new Builder(iVar.mContext).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(string).setContentText(null).setContentIntent(PendingIntent.getActivity(iVar.mContext, 0, intent, 134217728)).getNotification();
        iVar.kkd.icon = 2130839359;
        Notification notification = iVar.kkd;
        notification.flags |= 16;
        ((NotificationManager) iVar.mContext.getSystemService("notification")).notify(99, iVar.kkd);
    }

    private i() {
        this.ngH = null;
        this.ngI = new ArrayList(1);
        this.bgA = d.lWh;
        this.ngN = false;
        this.ngO = false;
        this.ngP = false;
        this.ngR = false;
        this.intent = null;
        this.kkd = null;
        this.mContext = null;
        this.ngT = new e(this);
        this.ngU = -1;
        this.ngV = new com.tencent.mm.sandbox.b.a(this) {
            final /* synthetic */ i ngX;

            {
                this.ngX = r1;
            }

            public final void bY(int i, int i2) {
                v.i("MicroMsg.UpdaterManager", "total=%d, offset=%d", Integer.valueOf(i), Integer.valueOf(i2));
                if (this.ngX.jHv != 2) {
                    i.a(this.ngX, i2, i);
                }
                this.ngX.bY(i, i2);
            }

            public final void a(int i, int i2, aqx com_tencent_mm_protocal_c_aqx) {
                this.ngX.ngR = false;
                this.ngX.ngT.stop();
                this.ngX.ngS = System.currentTimeMillis();
                if (this.ngX.ngH == null) {
                    this.ngX.T(2, true);
                } else if (i == 200 && i2 == 0) {
                    v.i("MicroMsg.UpdaterManager", "packCallback onSceneEnd ok");
                    if (this.ngX.jHv != 2) {
                        i.a(this.ngX, 100, 100);
                    }
                    if (this.ngX.ngN) {
                        h.Q(this.ngX.mContext, 0);
                    } else {
                        h.Q(this.ngX.mContext, 9);
                    }
                    this.ngX.ngK = MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "yyb_pkg_sig_prefs", 4).getString(aa.getPackageName(), SQLiteDatabase.KeyEmpty);
                    v.i("MicroMsg.UpdaterManager", "summertoken downloadsuccess onSceneEnd sig[%s], path[%s]", this.ngX.ngK, this.ngX.ngH.bsf());
                    if (be.kS(this.ngX.ngK)) {
                        g.iuh.a(322, 8, 1, false);
                        g.iuh.h(11098, Integer.valueOf(4008));
                    } else {
                        try {
                            com.tencent.mm.b.c.a(new File(this.ngX.ngH.bsf()), this.ngX.ngK);
                            v.i("MicroMsg.UpdaterManager", "summertoken downloadsuccess writeSecurityCode done");
                            g.iuh.a(322, 6, 1, false);
                            g.iuh.h(11098, Integer.valueOf(4006), this.ngX.ngK);
                        } catch (Exception e) {
                            v.w("MicroMsg.UpdaterManager", "summertoken downloadsuccess writeSecurityCode e: " + e.getMessage());
                            g.iuh.a(322, 7, 1, false);
                            g.iuh.h(11098, Integer.valueOf(4007), e.getMessage());
                        }
                    }
                    if (this.ngX.jHv == 1) {
                        h.R(this.ngX.mContext, 8);
                        h.a(this.ngX.aZy, this.ngX.ngK, this.ngX.desc, this.ngX.size, this.ngX.jHv, this.ngX.nfp, this.ngX.ngQ);
                        this.ngX.Bg(this.ngX.ngH.bsf());
                    } else if (this.ngX.jHv == 0) {
                        this.ngX.Bg(this.ngX.ngH.bsf());
                    } else if (this.ngX.jHv == 2) {
                        h.R(this.ngX.mContext, 1);
                        h.a(this.ngX.aZy, this.ngX.ngK, this.ngX.desc, this.ngX.size, this.ngX.jHv, this.ngX.nfp, this.ngX.ngQ);
                    }
                    h.bsy();
                } else if (i2 == -13) {
                    v.e("MicroMsg.UpdaterManager", "session timeout, killself and restart");
                    UpdaterService.cn();
                    AppUpdaterUI.bsj();
                    h.bsx();
                } else {
                    if (!(this.ngX.ngH instanceof c) || this.ngX.nfp == 4) {
                        v.e("MicroMsg.UpdaterManager", "update failed");
                        h.Q(this.ngX.mContext, 10);
                        if (this.ngX.jHv == 1) {
                            i.e(this.ngX);
                        } else if (this.ngX.jHv == 0) {
                            this.ngX.T(1, true);
                        }
                    } else {
                        v.e("MicroMsg.UpdaterManager", "download package from cdn error.");
                        if (this.ngX.ngN) {
                            if (i == 3 || i == 4 || i == 2 || i == 1 || i == 13) {
                                h.Q(this.ngX.mContext, i);
                            }
                            this.ngX.ngN = false;
                            if (this.ngX.jHv == 1) {
                                i.b(this.ngX);
                            } else if (this.ngX.jHv == 0) {
                                this.ngX.T(1, true);
                            } else if (this.ngX.jHv == 2) {
                                this.ngX.bsD();
                            }
                        } else {
                            this.ngX.ngH = new b(this.ngX.size, this.ngX.aZy, this.ngX.nfp, this.ngX.uin, this.ngX.dlf, this.ngX.cAN, this.ngX.ngJ, this.ngX.jHv == 2);
                            this.ngX.bsC();
                        }
                    }
                    this.ngX.a(this.ngX.ngH);
                }
            }

            public final void dW(long j) {
                e eVar = this.ngX.ngT;
                eVar.aSW.post(new com.tencent.mm.sandbox.updater.e.AnonymousClass2(eVar, j));
            }

            public final void dX(long j) {
                e eVar = this.ngX.ngT;
                eVar.aSW.post(new AnonymousClass3(eVar, j));
            }
        };
        this.mContext = aa.getContext();
    }

    public final void ir(boolean z) {
        v.i("MicroMsg.UpdaterManager", "summerupdate setNetStatChanged isWifi %s", Boolean.valueOf(z));
        e eVar = this.ngT;
        if (eVar.fMm != z) {
            eVar.is(true);
            eVar.fMm = z;
        }
        if (this.jHv != 2 || this.ngR) {
            v.i("MicroMsg.UpdaterManager", "downloadMode %s downloading %s", Integer.valueOf(this.jHv), Boolean.valueOf(this.ngR));
        } else if (z) {
            if (S(this.intent)) {
                it(true);
            }
        } else if (this.ngR) {
            cancel();
        }
    }

    public final boolean R(Intent intent) {
        boolean S = S(intent);
        v.i("MicroMsg.UpdaterManager", "summerupdate handleCommand(Intent intent) ret need download[%b]", Boolean.valueOf(S));
        if (S) {
            it(false);
        }
        return S;
    }

    public final boolean S(Intent intent) {
        v.i("MicroMsg.UpdaterManager", "handleCommand(Intent intent)");
        if (intent == null) {
            v.i("MicroMsg.UpdaterManager", "intent == null");
            return false;
        }
        int intExtra = intent.getIntExtra("intent_update_type", 3);
        int intExtra2 = intent.getIntExtra("intent_extra_download_mode", 1);
        String stringExtra = intent.getStringExtra("intent_extra_md5");
        if (this.ngR && !stringExtra.equalsIgnoreCase(this.aZy) && this.jHv == 2) {
            cancel();
        } else if (this.ngR) {
            v.i("MicroMsg.UpdaterManager", "downloading, duplicate download request");
            return true;
        }
        h.bsy();
        reset();
        this.intent = intent;
        this.aPY = intent.getIntExtra("intent_extra_updateMode", 0);
        this.aQa = intent.getStringExtra("intent_extra_marketUrl");
        this.ngJ = intent.getStringArrayExtra("intent_short_ips");
        this.bgA = intent.getIntExtra("intent_client_version", d.lWh);
        d.lWh = this.bgA;
        this.nfp = intExtra;
        this.dlf = intent.getByteArrayExtra("intent_extra_session");
        this.cAN = intent.getByteArrayExtra("intent_extra_cookie");
        this.dlh = intent.getByteArrayExtra("intent_extra_ecdhkey");
        this.uin = intent.getIntExtra("intent_extra_uin", 0);
        this.aZy = stringExtra;
        this.desc = intent.getStringExtra("intent_extra_desc");
        this.size = intent.getIntExtra("intent_extra_size", 0);
        this.nfS = intent.getStringArrayExtra("intent_extra_download_url");
        this.jHv = intExtra2;
        this.ngP = intent.getBooleanExtra("intent_extra_force_download_full", false);
        String stringExtra2 = intent.getStringExtra("intent_extra_patchInfo");
        if (stringExtra2 != null) {
            v.i("MicroMsg.UpdaterManager", "patchXml != null");
            this.ngL = com.tencent.mm.b.i.be(stringExtra2);
        }
        stringExtra2 = intent.getStringExtra("intent_extra_extinfo");
        v.d("MicroMsg.UpdaterManager", "summerupdate extInfo[%s]", stringExtra2);
        if (!be.kS(stringExtra2)) {
            this.ngQ = (String) bf.q(stringExtra2, "extinfo").get(".extinfo.notautodownloadrange");
            v.i("MicroMsg.UpdaterManager", "summerupdate notAutoDownloadRange[%s]", this.ngQ);
        }
        v.i("MicroMsg.UpdaterManager", "summerupdate handleCommand() downloadMode %s downloading %s", Integer.valueOf(intExtra2), Boolean.valueOf(this.ngR));
        if (intExtra != TbsLog.TBSLOG_CODE_SDK_INIT || this.nfS == null || this.nfS.length <= 0) {
            if (this.nfS != null) {
                for (String str : this.nfS) {
                    v.i("MicroMsg.UpdaterManager", "download url : " + str);
                }
            }
            v.i("MicroMsg.UpdaterManager", "md5 = %s , size = %s", stringExtra, Integer.valueOf(this.size));
            if (stringExtra == null || this.size == 0) {
                return false;
            }
            if (intExtra == 2) {
                v.i("MicroMsg.UpdaterManager", "summerupdate handleCommandWithoutDownload recommended control[%b]", Boolean.valueOf(b.iu(this.ngQ)));
                if (b.iu(this.ngQ)) {
                    g.iuh.a(405, 78, 1, true);
                    return false;
                }
            }
            if (this.ngL != null) {
                v.i("MicroMsg.UpdaterManager", "patchInfo != null");
                stringExtra2 = h.dA(this.mContext);
                this.ngM = this.ngL.bd(stringExtra2);
                v.i("MicroMsg.UpdaterManager", "increase apkMD5 = " + stringExtra2 + " : " + (this.ngM == null ? "not match" : "match"));
            }
            v.i("MicroMsg.UpdaterManager", "forceDownloadFull : %s", Boolean.valueOf(this.ngP));
            if (this.ngM == null || c.JK(stringExtra)) {
                v.i("MicroMsg.UpdaterManager", "had try to download full pack.");
            } else {
                v.i("MicroMsg.UpdaterManager", "isIncresmentUpdate");
                this.ngN = true;
            }
            stringExtra2 = h.Nd();
            if (be.kS(stringExtra2) || stringExtra2.equals(stringExtra)) {
                return true;
            }
            h.bsz();
            return true;
        } else if (intExtra2 != 2) {
            return true;
        } else {
            v.e("MicroMsg.UpdaterManager", "error! DOWNLOAD_MODE_SLIENCE download don't go here! we must process it before start download");
            return true;
        }
    }

    public final void bsA() {
        it(false);
    }

    private void it(boolean z) {
        boolean z2 = true;
        v.i("MicroMsg.UpdaterManager", "download() isWifiRetry %s", Boolean.valueOf(z));
        v.i("MicroMsg.UpdaterManager", "summerupdate download() downloadMode %s downloading %s", Integer.valueOf(this.jHv), Boolean.valueOf(this.ngR));
        if (this.intent == null) {
            v.e("MicroMsg.UpdaterManager", "download() haven't handleCommand");
        } else if (this.ngR) {
            v.i("MicroMsg.UpdaterManager", "download() downloading, duplicate download request");
        } else if (h.getExternalStorageState().equals("mounted")) {
            if (this.jHv == 2 && !z) {
                h.R(this.mContext, 0);
            }
            String yO = c.yO(this.aZy);
            v.i("MicroMsg.UpdaterManager", yO);
            if (yO != null) {
                v.i("MicroMsg.UpdaterManager", "update package already exist.");
                T(1, true);
                Bg(yO);
                if (this.jHv == 2 && !h.JM(this.aZy)) {
                    h.a(this.aZy, this.ngK, this.desc, this.size, this.jHv, this.nfp, this.ngQ);
                    return;
                }
                return;
            }
            if (this.ngP) {
                if (this.ngH != null) {
                    this.ngH.deleteTempFile();
                }
                h.Q(this.mContext, 11);
            }
            if (!this.ngP && this.ngN && this.ngL != null && this.ngM != null) {
                v.i("MicroMsg.UpdaterManager", "Incresment Update");
                h.Q(this.mContext, 5);
                if (f.G((long) (this.size + this.ngM.size))) {
                    cancel();
                    int i = this.ngM.size;
                    String str = this.aZy;
                    int i2 = this.nfp;
                    String str2 = this.ngL.aQl + this.ngM.url;
                    String str3 = this.ngM.aQp;
                    String str4 = this.ngM.aQo;
                    if (this.jHv != 2) {
                        z2 = false;
                    }
                    this.ngH = new c(i, str, i2, str2, str3, str4, z2);
                    bsC();
                    return;
                }
                bsB();
            } else if (f.G((long) this.size)) {
                bsD();
            } else {
                v.e("MicroMsg.UpdaterManager", "SDCard is full");
                bsB();
            }
        } else {
            v.e("MicroMsg.UpdaterManager", "no sdcard.");
            MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "system_config_prefs", 0).edit().putLong("recomended_update_ignore", be.Nh() - 86400).commit();
            T(2, true);
            bsl();
        }
    }

    public final void T(final int i, boolean z) {
        this.ngO = z;
        new ac().postDelayed(new Runnable(this) {
            final /* synthetic */ i ngX;

            public final void run() {
                ((NotificationManager) this.ngX.mContext.getSystemService("notification")).cancel(99);
                v.d("MicroMsg.UpdaterManager", "finishType == " + i);
                if (i == 2 && this.ngX.nfp == 1) {
                    Intent intent = new Intent();
                    intent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP");
                    this.ngX.mContext.sendBroadcast(intent, "com.tencent.mm.permission.MM_MESSAGE");
                }
            }
        }, 300);
    }

    public final void cancel() {
        if (this.ngH != null) {
            this.ngR = false;
            this.ngH.cancel();
            this.ngH = null;
            this.ngS = System.currentTimeMillis();
            this.ngT.stop();
        }
    }

    private void reset() {
        cancel();
        this.aPY = 0;
        this.aQa = null;
        this.ngJ = null;
        this.bgA = d.lWh;
        this.nfp = 0;
        this.dlf = null;
        this.cAN = null;
        this.dlh = null;
        this.uin = 0;
        this.aZy = null;
        this.size = 0;
        this.desc = null;
        this.nfS = null;
        this.ngL = null;
        this.ngM = null;
        this.ngN = false;
        this.ngO = false;
        this.jHv = 0;
        this.ngP = false;
        this.intent = null;
        this.ngR = false;
        this.kkd = null;
        this.ngU = 0;
    }

    private void bsB() {
        MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "system_config_prefs", 0).edit().putLong("recomended_update_ignore", be.Nh() - 86400).commit();
        T(2, true);
        bsm();
    }

    private void bsC() {
        if (this.jHv == 2 && !ak.isWifi(this.mContext)) {
            h.bsw();
            v.i("MicroMsg.UpdaterManager", "we stop download, when silence and not wifi!");
        } else if (this.jHv == 2 && e.JL(this.aZy)) {
            v.e("MicroMsg.UpdaterManager", "the traffice is overload, not download anymore in silence mode!");
            this.ngT.stop();
        } else {
            this.ngT.bD(this.aZy, this.size);
            if (this.ngH != null) {
                T(1, false);
                this.ngR = true;
                this.ngH.a(this.ngV);
                aRx();
                if (this.jHv == 2) {
                    h.bsw();
                }
            }
        }
    }

    private void bsD() {
        cancel();
        v.i("MicroMsg.UpdaterManager", "downloadFullPack");
        h.Q(this.mContext, 7);
        if (this.nfS == null || this.nfS.length <= 0) {
            this.ngH = new b(this.size, this.aZy, this.nfp, this.uin, this.dlf, this.cAN, this.ngJ, this.jHv == 2);
            g.iuh.a(405, 77, 1, true);
        } else {
            this.ngH = new c(this.size, this.aZy, this.nfp, this.nfS, this.jHv == 2);
            g.iuh.a(405, 76, 1, true);
        }
        bsC();
    }

    public final void bY(int i, int i2) {
        Iterator it = this.ngI.iterator();
        while (it.hasNext()) {
            ((f) it.next()).bY(i, i2);
        }
    }

    public final void aRx() {
        Iterator it = this.ngI.iterator();
        while (it.hasNext()) {
            ((f) it.next()).aRx();
        }
    }

    public final void Bg(String str) {
        Iterator it = this.ngI.iterator();
        while (it.hasNext()) {
            ((f) it.next()).Bg(str);
        }
    }

    public final void a(c cVar) {
        Iterator it = this.ngI.iterator();
        while (it.hasNext()) {
            ((f) it.next()).a(cVar);
        }
    }

    public final void bsl() {
        Iterator it = this.ngI.iterator();
        while (it.hasNext()) {
            ((f) it.next()).bsl();
        }
    }

    public final void bsm() {
        Iterator it = this.ngI.iterator();
        while (it.hasNext()) {
            ((f) it.next()).bsm();
        }
    }

    public final boolean isBusy() {
        if (this.ngR || System.currentTimeMillis() - this.ngS <= UpdaterService.nhb) {
            v.i("MicroMsg.UpdaterManager", "dont stop, because of updateManager.isDownloading() %s / updateManager.getIdleTimestamp() %s / System.currentTimeMillis() - updateManager.getIdleTimestamp() %s", Boolean.valueOf(this.ngR), Long.valueOf(this.ngS), Long.valueOf(System.currentTimeMillis() - this.ngS));
            return true;
        }
        v.i("MicroMsg.UpdaterManager", "not busy");
        return false;
    }

    public final void onDestroy() {
        v.i("MicroMsg.UpdaterManager", "onDestroy");
        if (!this.ngR) {
            reset();
            T(1, true);
        }
    }
}
