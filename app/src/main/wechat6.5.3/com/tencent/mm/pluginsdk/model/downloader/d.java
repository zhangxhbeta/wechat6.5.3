package com.tencent.mm.pluginsdk.model.downloader;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import com.tencent.mm.a.e;
import com.tencent.mm.b.c;
import com.tencent.mm.e.a.gj;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsimple.ai;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.al;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class d {
    private static Map<Long, Long> lBU = new HashMap();
    private static int lBZ = 2;
    private static d lCb;
    m lBV;
    private m lBW;
    private m lBX;
    private m lBY;
    a lCa;

    static /* synthetic */ void GP(String str) {
        v.i("MicroMsg.FileDownloadManager", "APK File Path: %s", str);
        if (!be.kS(str)) {
            p.c(aa.getContext(), Uri.fromFile(new File(str)));
        }
    }

    static /* synthetic */ PendingIntent dm(String str, String str2) {
        Intent intent = new Intent();
        Context context = aa.getContext();
        intent.setClass(context, FileDownloadService.class);
        intent.putExtra(FileDownloadService.lCp, 3);
        intent.putExtra(FileDownloadService.lCq, str);
        intent.putExtra(FileDownloadService.lCr, str2);
        return PendingIntent.getService(context, (int) System.currentTimeMillis(), intent, 0);
    }

    public static d bnK() {
        if (lCb == null) {
            lCb = new d();
        }
        return lCb;
    }

    private d() {
        bnN();
        if (!ak.uz() || ak.uG()) {
            v.i("MicroMsg.FileDownloadManager", "not login, use the default tmassist downloader");
        } else {
            lBZ = be.getInt(j.sU().getValue("FileDownloaderType"), 2);
            v.i("MicroMsg.FileDownloadManager", "get downloader type from dynamic config = %d", Integer.valueOf(lBZ));
        }
        this.lCa = new a();
    }

    private m bnL() {
        v.i("MicroMsg.FileDownloadManager", "mDownloaderType = " + lBZ);
        if (this.lBV != null) {
            return this.lBV;
        }
        b gjVar = new gj();
        a.nhr.z(gjVar);
        int i = gjVar.bfU.bfb;
        if (i > 0) {
            lBZ = i;
        }
        if (lBZ == 1) {
            this.lBV = bnM();
        } else {
            if (this.lBY == null) {
                this.lBY = new k(this.lCa);
            }
            this.lBV = this.lBY;
        }
        return this.lBV;
    }

    final m bnM() {
        if (this.lBX == null) {
            this.lBX = new h(this.lCa);
        }
        return this.lBX;
    }

    public final long a(e eVar) {
        if (ak.uz() && !ak.uG()) {
            return bnL().a(eVar);
        }
        long a = bnM().a(eVar);
        if (a >= 0) {
            lBU.put(Long.valueOf(a), Long.valueOf(0));
            aa.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(a), 0).commit();
            v.i("MicroMsg.FileDownloadManager", "Add id: %d to offline ids", Long.valueOf(a));
            return a;
        }
        v.i("MicroMsg.FileDownloadManager", "add download task to system downloader failed, use browser to download it");
        if (this.lBW == null) {
            this.lBW = new j(this.lCa);
        }
        this.lBW.a(eVar);
        return a;
    }

    public final int dm(long j) {
        if (dI(j)) {
            return bnM().dm(j);
        }
        return bnL().dm(j);
    }

    public final f dn(long j) {
        if (dI(j)) {
            return bnM().dn(j);
        }
        f fVar;
        al dG = c.dG(j);
        if (dG != null && dG.field_status == 3 && e.aR(dG.field_filePath)) {
            fVar = new f();
            fVar.id = j;
            fVar.url = dG.field_downloadUrl;
            fVar.status = 3;
            fVar.path = dG.field_filePath;
            fVar.aZy = dG.field_md5;
            fVar.beD = dG.field_downloadedSize;
            fVar.beE = dG.field_totalSize;
            fVar.jPw = dG.field_autoDownload;
            fVar.bfb = dG.field_downloaderType;
        } else {
            fVar = bnL().dn(j);
            if (dG != null) {
                fVar.jPw = dG.field_autoDownload;
                fVar.bfb = dG.field_downloaderType;
            }
        }
        v.i("MicroMsg.FileDownloadManager", "getDownloadTaskInfo: id: %d, url: %s, status: %d, path: %s, md5: %s, totalsize: %d, autodownload: %b, downloaderType: %d", Long.valueOf(fVar.id), fVar.url, Integer.valueOf(fVar.status), fVar.path, fVar.aZy, Long.valueOf(fVar.beE), Boolean.valueOf(fVar.jPw), Integer.valueOf(fVar.bfb));
        return fVar;
    }

    public final f GN(String str) {
        al GJ = c.GJ(str);
        if (GJ != null) {
            return dn(GJ.field_downloadId);
        }
        return new f();
    }

    public final f GO(String str) {
        al GM = c.GM(str);
        if (GM != null) {
            return dn(GM.field_downloadId);
        }
        return new f();
    }

    public final boolean do(long j) {
        if (dI(j)) {
            return bnM().do(j);
        }
        return bnL().do(j);
    }

    public final boolean dp(long j) {
        if (dI(j)) {
            return bnM().dp(j);
        }
        return bnL().dp(j);
    }

    private static void bnN() {
        SharedPreferences sharedPreferences = aa.getContext().getSharedPreferences("off_line_download_ids", 0);
        if (sharedPreferences != null) {
            Map all = sharedPreferences.getAll();
            if (all != null && all.size() != 0) {
                lBU.clear();
                for (Entry entry : all.entrySet()) {
                    if (!(entry == null || be.kS((String) entry.getKey()))) {
                        try {
                            long j = be.getLong((String) entry.getKey(), 0);
                            long longValue = ((Long) entry.getValue()).longValue();
                            long currentTimeMillis = System.currentTimeMillis() - j;
                            if (currentTimeMillis - j > 0 && currentTimeMillis - j < 86400000) {
                                lBU.put(Long.valueOf(j), Long.valueOf(longValue));
                            }
                        } catch (Throwable e) {
                            v.e("MicroMsg.FileDownloadManager", "parse download task failed: " + e.toString());
                            v.a("MicroMsg.FileDownloadManager", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                        }
                    }
                }
                sharedPreferences.edit().clear();
                for (Entry entry2 : lBU.entrySet()) {
                    sharedPreferences.edit().putLong(entry2.getKey(), ((Long) entry2.getValue()).longValue());
                }
                sharedPreferences.edit().commit();
            }
        }
    }

    static void a(String str, String str2, PendingIntent pendingIntent) {
        android.support.v4.app.w.d dVar = new android.support.v4.app.w.d(aa.getContext());
        dVar.a(str);
        dVar.b((CharSequence) str2);
        dVar.L(17301634);
        dVar.o(true);
        if (pendingIntent != null) {
            dVar.rI = pendingIntent;
        } else {
            dVar.rI = PendingIntent.getActivity(aa.getContext(), 0, new Intent(), 0);
        }
        ak.oH().b(dVar.build());
        v.i("MicroMsg.FileDownloadManager", "show notification");
    }

    static boolean dI(long j) {
        return lBU.containsKey(Long.valueOf(j));
    }

    static boolean dJ(long j) {
        return lBU.containsValue(Long.valueOf(j));
    }

    static void p(long j, long j2) {
        lBU.put(Long.valueOf(j), Long.valueOf(j2));
        aa.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(j), j2).commit();
    }

    static long dK(long j) {
        Long l = (Long) lBU.get(Long.valueOf(j));
        return l == null ? -1 : l.longValue();
    }

    static long dL(long j) {
        for (Entry entry : lBU.entrySet()) {
            if (((Long) entry.getValue()).longValue() == j) {
                return ((Long) entry.getKey()).longValue();
            }
        }
        return -1;
    }

    final void dM(long j) {
        v.d("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded id[%d], stack[%s]", Long.valueOf(j), be.bur());
        final Context context = aa.getContext();
        if (dI(j)) {
            this.lCa.r(j, dn(j).path);
            return;
        }
        final al dG = c.dG(j);
        if (dG != null) {
            if (be.kS(dG.field_packageName)) {
                String GH = p.GH(dG.field_filePath);
                if (!be.kS(GH)) {
                    dG.field_packageName = GH;
                    v.i("MicroMsg.FileDownloadManager", "get package name from file : %s, %s", dG.field_filePath, GH);
                    c.b(dG);
                }
            }
            final int GI = p.GI(dG.field_filePath);
            v.d("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded field_packageName[%s], field_filePath[%s], versionCode[%d]", dG.field_packageName, dG.field_filePath, Integer.valueOf(GI));
            final long j2 = j;
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ d lCd;

                public final void run() {
                    new ai(dG.field_packageName, GI).a(ak.vy().cAa, new com.tencent.mm.v.e(this) {
                        final /* synthetic */ AnonymousClass1 lCe;

                        {
                            this.lCe = r1;
                        }

                        public final void a(int i, int i2, String str, k kVar) {
                            kVar.czK = true;
                            g gVar;
                            Object[] objArr;
                            if (i == 0 && i2 == 0) {
                                String string = MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "yyb_pkg_sig_prefs", 4).getString(dG.field_packageName, SQLiteDatabase.KeyEmpty);
                                v.i("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded sig[%s]", string);
                                if (be.kS(string)) {
                                    g.iuh.a(322, 26, 1, false);
                                    gVar = g.iuh;
                                    objArr = new Object[2];
                                    objArr[0] = Integer.valueOf(4026);
                                    objArr[1] = String.format("%s,%s", new Object[]{dG.field_packageName, dG.field_filePath});
                                    gVar.h(11098, objArr);
                                } else {
                                    g gVar2;
                                    Object[] objArr2;
                                    try {
                                        c.a(new File(dG.field_filePath), string);
                                        v.i("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded writeSecurityCode done");
                                        g.iuh.a(322, 25, 1, false);
                                        gVar2 = g.iuh;
                                        objArr2 = new Object[2];
                                        objArr2[0] = Integer.valueOf(4025);
                                        objArr2[1] = String.format("%s,%s,%s", new Object[]{dG.field_packageName, dG.field_filePath, string});
                                        gVar2.h(11098, objArr2);
                                    } catch (Exception e) {
                                        v.w("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded writeSecurityCode e: " + e.getMessage());
                                        g.iuh.a(322, 27, 1, false);
                                        gVar2 = g.iuh;
                                        objArr2 = new Object[2];
                                        objArr2[0] = Integer.valueOf(4027);
                                        objArr2[1] = String.format("%s,%s,%s", new Object[]{dG.field_packageName, dG.field_filePath, e.getMessage()});
                                        gVar2.h(11098, objArr2);
                                    }
                                }
                            } else {
                                v.w("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded get pkg sig error");
                                g.iuh.a(322, 28, 1, false);
                                gVar = g.iuh;
                                objArr = new Object[2];
                                objArr[0] = Integer.valueOf(4028);
                                objArr[1] = String.format("%s,%s,%d,%d", new Object[]{dG.field_packageName, dG.field_filePath, Integer.valueOf(i), Integer.valueOf(i2)});
                                gVar.h(11098, objArr);
                            }
                            ad.o(new Runnable(this) {
                                final /* synthetic */ AnonymousClass1 lCf;

                                {
                                    this.lCf = r1;
                                }

                                public final void run() {
                                    PendingIntent pendingIntent = null;
                                    if (dG.field_fileType == 1) {
                                        pendingIntent = d.dm(dG.field_filePath, dG.field_md5);
                                    }
                                    d dVar;
                                    String str;
                                    if (dG.field_showNotification && be.kS(dG.field_fileName)) {
                                        dVar = this.lCf.lCe.lCd;
                                        str = dG.field_downloadUrl;
                                        d.a(context.getString(2131232765), SQLiteDatabase.KeyEmpty, pendingIntent);
                                    } else if (dG.field_showNotification && !be.kS(dG.field_fileName)) {
                                        dVar = this.lCf.lCe.lCd;
                                        str = dG.field_downloadUrl;
                                        d.a(dG.field_fileName, context.getString(2131232765), pendingIntent);
                                    }
                                    if (dG.field_autoInstall && dG.field_fileType == 1) {
                                        d.GP(dG.field_filePath);
                                    }
                                    this.lCf.lCe.lCd.lCa.r(j2, dG.field_filePath);
                                }
                            });
                        }
                    });
                }
            });
        }
    }
}
