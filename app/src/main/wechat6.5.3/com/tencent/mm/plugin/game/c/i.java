package com.tencent.mm.plugin.game.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import com.tencent.mm.a.e;
import com.tencent.mm.model.ak;
import com.tencent.mm.pluginsdk.model.downloader.d;
import com.tencent.mm.pluginsdk.model.downloader.l;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.al;
import com.tencent.mm.storage.am;
import com.tencent.tmassistantsdk.openSDK.ITMQQDownloaderOpenSDKListener;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKParam;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public final class i implements l, ITMQQDownloaderOpenSDKListener {
    private static i ghP = null;
    private static BroadcastReceiver ghQ = null;
    private static Set<b> ghR = Collections.synchronizedSet(new HashSet());
    private static HashMap<String, c> ghS = new HashMap();

    private static class a extends BroadcastReceiver {
        private a() {
        }

        public final void onReceive(Context context, Intent intent) {
            al alVar = null;
            if (context != null && intent != null) {
                String action = intent.getAction();
                v.i("MicroMsg.GameInstallationReceiver", action);
                if (be.kS(action)) {
                    v.e("MicroMsg.GameInstallationReceiver", "action is null or nill, ignore");
                } else if (action.equals("android.intent.action.PACKAGE_ADDED")) {
                    action = "";
                    try {
                        action = intent.getDataString();
                    } catch (Throwable e) {
                        v.e("MicroMsg.GameInstallationReceiver", "%s", new Object[]{be.e(e)});
                    }
                    v.i("MicroMsg.GameInstallationReceiver", "get added package name : %s", new Object[]{action});
                    if (be.kS(action)) {
                        v.e("MicroMsg.GameInstallationReceiver", "get installed broadcast, while the package name is null or nil");
                        return;
                    }
                    if (action.startsWith("package:")) {
                        action = action.substring(8);
                    }
                    if (!ak.uz() || ak.uG()) {
                        v.e("MicroMsg.GameInstallationReceiver", "no user login");
                        return;
                    }
                    com.tencent.mm.model.c yW = ak.yW();
                    if (yW != null) {
                        al alVar2;
                        am wL = yW.wL();
                        if (be.kS(action)) {
                            v.e("MicroMsg.FileDownloadInfoStorage", "Null or nil PakcageName");
                            alVar2 = null;
                        } else {
                            Cursor rawQuery = wL.rawQuery("select * from FileDownloadInfo where packageName='" + action + "' order by downloadId desc limit 1", new String[0]);
                            if (rawQuery == null) {
                                alVar2 = null;
                            } else {
                                if (rawQuery.moveToFirst()) {
                                    alVar = new al();
                                    alVar.b(rawQuery);
                                }
                                if (rawQuery != null) {
                                    rawQuery.close();
                                }
                                alVar2 = alVar;
                            }
                        }
                        if (alVar2 == null) {
                            v.e("MicroMsg.GameInstallationReceiver", "No AppInfo found for package: %s", new Object[]{action});
                            return;
                        }
                        if (e.aR(alVar2.field_filePath)) {
                            com.tencent.mm.loader.stub.b.deleteFile(alVar2.field_filePath);
                            com.tencent.mm.pluginsdk.model.downloader.c.GL(alVar2.field_appId);
                        }
                        c cVar = (c) i.ghS.get(alVar2.field_downloadUrl);
                        if (cVar == null) {
                            v.e("MicroMsg.GameInstallationReceiver", "No ReportInfo found for url: %s", new Object[]{alVar2.field_downloadUrl});
                            return;
                        }
                        if (be.kS(cVar.aZh)) {
                            cVar.aZh = i.a(cVar);
                        }
                        af.a(cVar.appId, cVar.scene, 5, cVar.aZy, alVar2.field_downloadUrl, cVar.ghW, cVar.aZh);
                    }
                }
            }
        }
    }

    public interface b {
        void g(int i, String str, boolean z);
    }

    private static class c {
        String aZh = "";
        String aZy = "";
        String appId = "";
        String ghW = "";
        int scene = 0;

        c(String str, int i, String str2, String str3, String str4) {
            this.aZy = str;
            this.scene = i;
            this.appId = str2;
            this.ghW = str3;
            this.aZh = str4;
        }
    }

    private i() {
    }

    public static i ark() {
        if (ghP == null) {
            ghP = new i();
        }
        return ghP;
    }

    public static void a(b bVar) {
        synchronized (ghR) {
            ghR.add(bVar);
        }
    }

    public static void b(b bVar) {
        synchronized (ghR) {
            ghR.remove(bVar);
            v.d("MicroMsg.GameDownloadEventBus", "removeListener, size:%d, listener:%s", new Object[]{Integer.valueOf(ghR.size()), bVar});
        }
    }

    public static void are() {
        if (ghP == null) {
            ghP = new i();
        }
        if (ghQ == null) {
            ghQ = new a();
        }
        d.bnK();
        com.tencent.mm.pluginsdk.model.downloader.a.a(ghP);
        at.arX();
        at.registerListener(ghP);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        aa.getContext().registerReceiver(ghQ, intentFilter);
    }

    public static void arf() {
        d.bnK();
        com.tencent.mm.pluginsdk.model.downloader.a.b(ghP);
        at.arX();
        at.unregisterListener(ghP);
        aa.getContext().unregisterReceiver(ghQ);
        ghP = null;
        ghR.clear();
        ghS.clear();
    }

    private void p(long j, int i) {
        boolean z = true;
        al dG = com.tencent.mm.pluginsdk.model.downloader.c.dG(j);
        if (dG != null) {
            int i2;
            String str;
            String str2 = dG.field_downloadUrl;
            switch (i) {
                case 1:
                    i2 = 1;
                    break;
                case 2:
                    i2 = 6;
                    break;
                case 3:
                    i2 = 3;
                    break;
                case 4:
                    i2 = 2;
                    break;
                case 5:
                    i2 = 8;
                    break;
                case 6:
                    str = dG.field_appId;
                    if (dG.field_autoDownload) {
                        z = false;
                    }
                    f(i, str, z);
                case 7:
                    i2 = 7;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            c cVar = (c) ghS.get(str2);
            if (cVar == null) {
                v.e("MicroMsg.GameDownloadEventBus", "No report info found, abort reporting: %s", new Object[]{str2});
            } else {
                if (be.kS(cVar.aZh)) {
                    cVar.aZh = a(cVar);
                }
                af.a(cVar.appId, cVar.scene, i2, cVar.aZy, str2, cVar.ghW, cVar.aZh);
            }
            str = dG.field_appId;
            if (dG.field_autoDownload) {
                z = false;
            }
            f(i, str, z);
        }
    }

    private void f(final int i, final String str, final boolean z) {
        ad.o(new Runnable(this) {
            final /* synthetic */ i ghV;

            public final void run() {
                synchronized (i.ghR) {
                    for (b g : i.ghR) {
                        g.g(i, str, z);
                    }
                }
            }
        });
    }

    public static void a(String str, String str2, int i, String str3, String str4) {
        if (!be.kS(str)) {
            ghS.put(str, new c(str2, i, str3, "", str4));
        }
    }

    public static void a(String str, String str2, int i, String str3, String str4, String str5) {
        if (!be.kS(str)) {
            ghS.put(str, new c(str2, i, str3, str4, str5));
        }
    }

    public final void onTaskStarted(long j, String str) {
        p(j, 1);
    }

    public final void g(long j, String str) {
        if (be.kS(str) || !e.aR(str)) {
            d.bnK().dm(j);
        } else {
            p(j, 3);
        }
    }

    public final void q(long j, int i) {
        p(j, 5);
        al dG = com.tencent.mm.pluginsdk.model.downloader.c.dG(j);
        if (dG != null) {
            k(dG.field_appId, i, null);
        }
    }

    public final void onTaskRemoved(long j) {
        int i = 0;
        p(j, 4);
        al dG = com.tencent.mm.pluginsdk.model.downloader.c.dG(j);
        if (dG != null) {
            Context context = aa.getContext();
            CharSequence charSequence = dG.field_appId;
            SharedPreferences sharedPreferences = context.getSharedPreferences("game_center_pref", 0);
            String string = sharedPreferences.getString("download_app_id_time_map", "");
            if (!be.kS(string) && string.contains(charSequence)) {
                String str = new String();
                String[] split = string.split(",");
                while (i < split.length) {
                    String str2 = split[i];
                    if (!str2.contains(charSequence)) {
                        str = i == split.length + -1 ? str + str2 : str + str2 + ",";
                    }
                    i++;
                }
                sharedPreferences.edit().putString("download_app_id_time_map", str).apply();
            }
        }
    }

    public final void onTaskPaused(long j) {
        p(j, 2);
    }

    public final void bV(long j) {
        p(j, 6);
    }

    public final void bW(long j) {
        p(j, 7);
    }

    public final void OnDownloadTaskStateChanged(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, int i, int i2, String str) {
        int i3 = 2;
        v.i("MicroMsg.GameDownloadEventBus", "OnDownloadTaskStateChanged, status = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i2 == 0) {
            switch (i) {
                case 1:
                case 2:
                    i3 = 1;
                    break;
                case 3:
                    break;
                case 4:
                    i3 = 3;
                    break;
                case 5:
                    i3 = 5;
                    break;
                case 6:
                    i3 = 4;
                    break;
                default:
                    i3 = 0;
                    break;
            }
            if (i3 != 0) {
                f(i3, tMQQDownloaderOpenSDKParam.taskPackageName, true);
            }
        }
    }

    public final void OnDownloadTaskProgressChanged(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, long j, long j2) {
    }

    public final void OnQQDownloaderInvalid() {
    }

    public final void OnServiceFree() {
    }

    private static String a(c cVar) {
        al GJ = com.tencent.mm.pluginsdk.model.downloader.c.GJ(cVar.appId);
        if (GJ == null) {
            return null;
        }
        if (GJ.field_downloaderType == 1) {
            return "downloader_type_system";
        }
        return "downloader_type_tmassistant";
    }

    public static void k(String str, int i, String str2) {
        if (i == 710 || i == 711) {
            i = com.tencent.mm.pluginsdk.model.downloader.b.lBS;
        }
        v.i("MicroMsg.GameDownloadEventBus", "errCode = " + i);
        au.asf();
        t.a(str, 2, i, null, str2);
    }
}
