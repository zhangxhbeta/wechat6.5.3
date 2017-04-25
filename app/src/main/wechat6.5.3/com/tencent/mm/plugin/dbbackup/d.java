package com.tencent.mm.plugin.dbbackup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.PowerManager;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.a.h;
import com.tencent.mm.ae.n;
import com.tencent.mm.as.k;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.jx;
import com.tencent.mm.h.f;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.r;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.mmdb.repair.BackupTask;
import com.tencent.mmdb.repair.DBDumpUtil.ExecuteSqlCallback;
import com.tencent.mmdb.repair.RecoverTask;
import com.tencent.mmdb.repair.RepairKit.MasterInfo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public final class d implements ag {
    private BroadcastReceiver eUP;
    boolean eUQ = false;
    boolean eUR = true;
    Runnable eUT;
    BackupTask eXO;
    RecoverTask eXP;
    Runnable eXQ;
    boolean eXR = false;
    boolean eXS = false;
    long eXT = 0;
    long eXU = 600000;
    long eXV = 0;
    int eXW = 10;
    private boolean eXX = false;
    final SimpleDateFormat eXY = new SimpleDateFormat("HH:mm:ss.SSS");
    private c eXZ;

    class AnonymousClass5 implements b {
        final /* synthetic */ b eYn;
        final /* synthetic */ d eYo;
        int eYx = 0;

        public AnonymousClass5(d dVar, b bVar) {
            this.eYo = dVar;
            this.eYn = bVar;
        }

        public final void gu(int i) {
            while (true) {
                if (this.eYx > 0) {
                    v.i("MicroMsg.SubCoreDBBackup", "Recovery stage %d result: %d", Integer.valueOf(this.eYx), Integer.valueOf(i));
                }
                if (i == 0) {
                    g.iuh.a(181, 29, 1, false);
                    if (this.eYn != null) {
                        this.eYn.gu(i);
                        return;
                    }
                    return;
                } else if (i == -2) {
                    g.iuh.a(181, 3, 1, false);
                    if (this.eYn != null) {
                        this.eYn.gu(i);
                        return;
                    }
                    return;
                } else {
                    int i2 = this.eYx + 1;
                    this.eYx = i2;
                    switch (i2) {
                        case 1:
                            v.i("MicroMsg.SubCoreDBBackup", "Database recovery stage %d: REPAIR", Integer.valueOf(this.eYx));
                            i = this.eYo.a(this);
                            break;
                        case 2:
                            v.i("MicroMsg.SubCoreDBBackup", "Database recovery stage %d: BACKUP RECOVER", Integer.valueOf(this.eYx));
                            i = this.eYo.a(null, (b) this);
                            break;
                        case 3:
                            v.i("MicroMsg.SubCoreDBBackup", "Database recovery stage %d: DUMP", Integer.valueOf(this.eYx));
                            i = this.eYo.b(this);
                            break;
                        default:
                            if (this.eYn != null) {
                                this.eYn.gu(i);
                                return;
                            }
                            return;
                    }
                    if (i == 0) {
                        return;
                    }
                }
            }
        }
    }

    private static long[] qU(String str) {
        BufferedReader bufferedReader;
        Throwable e;
        try {
            bufferedReader = new BufferedReader(new FileReader(str + ".bcur"));
            try {
                long parseLong = Long.parseLong(bufferedReader.readLine());
                long parseLong2 = Long.parseLong(bufferedReader.readLine());
                long parseLong3 = Long.parseLong(bufferedReader.readLine());
                long parseLong4 = Long.parseLong(bufferedReader.readLine());
                long[] jArr = new long[]{parseLong, parseLong2, parseLong3, parseLong4};
                try {
                    bufferedReader.close();
                    return jArr;
                } catch (IOException e2) {
                    return jArr;
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    v.a("MicroMsg.SubCoreDBBackup", e, "Failed to read previous cursor '%s'", str);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e4) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    e = th;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw e;
                }
            }
        } catch (Exception e6) {
            e = e6;
            bufferedReader = null;
            v.a("MicroMsg.SubCoreDBBackup", e, "Failed to read previous cursor '%s'", str);
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return null;
        } catch (Throwable th2) {
            e = th2;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw e;
        }
    }

    static boolean a(String str, long[] jArr) {
        FileWriter fileWriter;
        Throwable e;
        try {
            fileWriter = new FileWriter(str + ".bcur");
            try {
                for (long l : jArr) {
                    fileWriter.write(Long.toString(l) + "\n");
                }
                try {
                    fileWriter.close();
                    return true;
                } catch (IOException e2) {
                    return true;
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    v.a("MicroMsg.SubCoreDBBackup", e, "Failed to write previous cursor '%s'", str);
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException e4) {
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    e = th;
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw e;
                }
            }
        } catch (IOException e6) {
            e = e6;
            fileWriter = null;
            v.a("MicroMsg.SubCoreDBBackup", e, "Failed to write previous cursor '%s'", str);
            if (fileWriter != null) {
                fileWriter.close();
            }
            return false;
        } catch (Throwable th2) {
            e = th2;
            fileWriter = null;
            if (fileWriter != null) {
                fileWriter.close();
            }
            throw e;
        }
    }

    public final boolean a(boolean z, b bVar) {
        long j;
        String[] strArr;
        boolean z2;
        int i;
        ak.yW();
        final String xo = com.tencent.mm.model.c.xo();
        SQLiteDatabase bxY = com.tencent.mm.model.c.wE().bxY();
        final String str = xo + ".bak";
        String str2 = str + ".tmp";
        final String str3 = xo + ".sm";
        final String str4 = str3 + ".tmp";
        int i2 = 8;
        if (z) {
            StringBuilder stringBuilder = new StringBuilder();
            ak.yW();
            if (new File(stringBuilder.append(com.tencent.mm.model.c.xo()).append(".bak").toString()).canRead()) {
                i2 = 24;
                FileOp.p(str, str2);
            } else {
                z = false;
            }
        }
        long j2 = -1;
        long j3 = -1;
        long j4 = -1;
        Cursor rawQuery = bxY.rawQuery("SELECT max(msgId) FROM message;", null);
        if (rawQuery.moveToFirst()) {
            j2 = rawQuery.getLong(0);
        }
        rawQuery.close();
        rawQuery = bxY.rawQuery("SELECT max(id) FROM ImgInfo2;", null);
        if (rawQuery.moveToFirst()) {
            j3 = rawQuery.getLong(0);
        }
        rawQuery.close();
        rawQuery = bxY.rawQuery("SELECT max(rowid) FROM videoinfo2;", null);
        if (rawQuery.moveToFirst()) {
            j = rawQuery.getLong(0);
        } else {
            j = -1;
        }
        rawQuery.close();
        rawQuery = bxY.rawQuery("SELECT max(rowid) FROM EmojiInfo;", null);
        if (rawQuery.moveToFirst()) {
            j4 = rawQuery.getLong(0);
        }
        rawQuery.close();
        final long[] jArr = new long[]{j2, j3, j, j4};
        final long[] qU = z ? qU(xo) : null;
        if (qU == null || qU.length < 4) {
            strArr = new String[]{"message", "msgId <= " + jArr[0], "ImgInfo2", "id <= " + jArr[1], "videoinfo2", "rowid <= " + jArr[2], "EmojiInfo", "rowid <= " + jArr[3], "conversation", null, "rconversation", null};
        } else {
            strArr = new String[12];
            strArr[0] = "message";
            strArr[1] = String.format("msgId > %d AND msgId <= %d", new Object[]{Long.valueOf(qU[0]), Long.valueOf(jArr[0])});
            strArr[2] = "ImgInfo2";
            strArr[3] = String.format("id > %d AND id <= %d", new Object[]{Long.valueOf(qU[1]), Long.valueOf(jArr[1])});
            strArr[4] = "videoinfo2";
            strArr[5] = String.format("rowid > %d AND rowid <= %d", new Object[]{Long.valueOf(qU[2]), Long.valueOf(jArr[2])});
            strArr[6] = "EmojiInfo";
            strArr[7] = String.format("rowid > %d AND rowid <= %d", new Object[]{Long.valueOf(qU[3]), Long.valueOf(jArr[3])});
            strArr[8] = "conversation";
            strArr[9] = null;
            strArr[10] = "rconversation";
            strArr[11] = null;
        }
        if (qU == null) {
            z2 = false;
        } else {
            z2 = z;
        }
        if (this.eXX) {
            i = i2 | 3;
        } else {
            i = i2;
        }
        synchronized (this) {
            if (this.eXO == null && this.eXP == null && this.eXQ == null) {
                byte[] n = com.tencent.mm.a.g.n((p.rJ() + com.tencent.mm.model.c.ww()).getBytes());
                try {
                    final SQLiteDatabase sQLiteDatabase = bxY;
                    final byte[] bArr = n;
                    final String str5 = str2;
                    final b bVar2 = bVar;
                    this.eXO = new BackupTask(this, bxY, str2, n, i, strArr) {
                        private long eYa;
                        private long eYb;
                        private long eYc;
                        final /* synthetic */ d eYo;

                        protected final void onStart() {
                            long j = 0;
                            this.eYa = System.nanoTime();
                            File file = new File(str3);
                            if (!(z2 && file.exists())) {
                                boolean save = MasterInfo.save(sQLiteDatabase, str4, bArr);
                                File file2 = new File(str4);
                                if (save) {
                                    file.delete();
                                    save = file2.renameTo(file);
                                } else {
                                    file2.delete();
                                }
                                long nanoTime = System.nanoTime() - this.eYa;
                                String str = "MicroMsg.SubCoreDBBackup";
                                String str2 = "Master table backup %s, elapsed %.3f";
                                Object[] objArr = new Object[2];
                                objArr[0] = save ? "SUCCEEDED" : "FAILED";
                                objArr[1] = Float.valueOf(((float) nanoTime) / 1.0E9f);
                                v.i(str, str2, objArr);
                                g.iuh.a(181, save ? 24 : 25, 1, false);
                            }
                            this.eYb = new File(xo).length();
                            this.eYc = new File(str5).length();
                            String str3 = "MicroMsg.SubCoreDBBackup";
                            String str4 = "Backup started [%s, cursor: %d ~ %d]";
                            Object[] objArr2 = new Object[3];
                            objArr2[0] = z2 ? "incremental" : "new";
                            objArr2[1] = Long.valueOf(qU != null ? qU[0] : 0);
                            if (jArr != null) {
                                j = jArr[0];
                            }
                            objArr2[2] = Long.valueOf(j);
                            v.i(str3, str4, objArr2);
                            int i = z2 ? 10011 : 10000;
                            g gVar = g.iuh;
                            Object[] objArr3 = new Object[2];
                            objArr3[0] = Integer.valueOf(i);
                            objArr3[1] = String.format("%d|%d|%s", new Object[]{Long.valueOf(this.eYb), Long.valueOf(this.eYc), this.eYo.eXY.format(new Date())});
                            gVar.h(11098, objArr3);
                        }

                        protected final void onFinish(int i) {
                            int i2;
                            int i3;
                            long nanoTime = System.nanoTime() - this.eYa;
                            File file = new File(str5);
                            long length = file.length();
                            if (i == 0) {
                                d.a(xo, jArr);
                                File file2 = new File(str);
                                file2.delete();
                                file.renameTo(file2);
                                if (z2) {
                                    i2 = 19;
                                    i3 = 10012;
                                } else {
                                    i2 = 16;
                                    i3 = CdnLogic.MediaType_FAVORITE_FILE;
                                }
                            } else {
                                file.delete();
                                if (i == 1) {
                                    if (z2) {
                                        i2 = 20;
                                        i3 = 10013;
                                    } else {
                                        i2 = 17;
                                        i3 = CdnLogic.MediaType_FAVORITE_VIDEO;
                                    }
                                } else if (z2) {
                                    i2 = 21;
                                    i3 = 10014;
                                } else {
                                    i2 = 18;
                                    i3 = 10003;
                                }
                            }
                            String str = "MicroMsg.SubCoreDBBackup";
                            String str2 = "Database %s backup %s, elapsed %.2f seconds.";
                            Object[] objArr = new Object[3];
                            objArr[0] = z2 ? "incremental" : "new";
                            String str3 = i == 0 ? "succeeded" : i == 1 ? "canceled" : "failed";
                            objArr[1] = str3;
                            objArr[2] = Float.valueOf(((float) nanoTime) / 1.0E9f);
                            v.i(str, str2, objArr);
                            g.iuh.a(181, (long) i2, 1, false);
                            g gVar = g.iuh;
                            Object[] objArr2 = new Object[2];
                            objArr2[0] = Integer.valueOf(i3);
                            objArr2[1] = String.format("%d|%d|%d|%d|%d|%s", new Object[]{Long.valueOf(this.eYb), Long.valueOf(this.eYc), Long.valueOf(length), Integer.valueOf(statementCount()), Long.valueOf(nanoTime / 1000000), this.eYo.eXY.format(new Date())});
                            gVar.h(11098, objArr2);
                            if (bVar2 != null) {
                                bVar2.gu(i);
                            }
                            synchronized (this.eYo) {
                                this.eYo.eXO = null;
                            }
                        }
                    };
                    this.eXO.run();
                    return true;
                } catch (Throwable e) {
                    v.a("MicroMsg.SubCoreDBBackup", e, "Failed to start database backup. Path: %s", str);
                    return false;
                }
            }
            v.i("MicroMsg.SubCoreDBBackup", "Backup or recover task is in progress, %s canceled", "backup");
            return false;
        }
    }

    public final synchronized boolean aen() {
        boolean z = false;
        synchronized (this) {
            if (this.eXO != null) {
                try {
                    this.eXO.cancel();
                    z = true;
                } catch (Exception e) {
                }
            }
        }
        return z;
    }

    public final synchronized int a(String str, b bVar) {
        int i;
        ak.yW();
        String str2 = str == null ? com.tencent.mm.model.c.xo() + ".bak" : str;
        final long bum = be.bum();
        File file = new File(str2);
        if (!file.canRead()) {
            i = -3;
        } else if (bum < file.length() * 10) {
            i = -2;
        } else {
            try {
                final String str3 = str2;
                final b bVar2 = bVar;
                this.eXP = new RecoverTask(this, com.tencent.mm.model.c.wE().bxY(), str2, com.tencent.mm.a.g.n((p.rJ() + com.tencent.mm.model.c.ww()).getBytes())) {
                    private long eYa;
                    final /* synthetic */ d eYo;
                    private long eYp;

                    protected final void onStart() {
                        ak.yW();
                        com.tencent.mm.model.c.wJ();
                        com.tencent.mm.model.c.wK();
                        n.GH();
                        k.KV();
                        this.eYp = new File(str3).length();
                        g gVar = g.iuh;
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(10004);
                        objArr[1] = String.format("%d|%d", new Object[]{Long.valueOf(this.eYp), Long.valueOf(bum)});
                        gVar.h(11098, objArr);
                        this.eYa = System.nanoTime();
                    }

                    protected final void onFinish(int i) {
                        int i2;
                        int i3;
                        ak.yW();
                        au wJ = com.tencent.mm.model.c.wJ();
                        au.bwT();
                        wJ.bwV();
                        wJ.bwU();
                        n.GH().Gr();
                        com.tencent.mm.model.c.wK().bvH();
                        synchronized (this.eYo) {
                            this.eYo.eXP = null;
                        }
                        long nanoTime = System.nanoTime() - this.eYa;
                        int successCount = successCount();
                        int failureCount = failureCount();
                        String str = "MicroMsg.SubCoreDBBackup";
                        String str2 = "Database recover %s, elapsed %.2f seconds. [success: %d, failure: %d]";
                        Object[] objArr = new Object[4];
                        String str3 = i == 0 ? "succeeded" : i == 1 ? "canceled" : "failed";
                        objArr[0] = str3;
                        objArr[1] = Float.valueOf(((float) nanoTime) / 1.0E9f);
                        objArr[2] = Integer.valueOf(successCount);
                        objArr[3] = Integer.valueOf(failureCount);
                        v.i(str, str2, objArr);
                        if (i == 0) {
                            i2 = 10005;
                            i3 = 22;
                        } else if (i == 1) {
                            i2 = 10006;
                            i3 = -1;
                        } else {
                            i2 = 10007;
                            i3 = 23;
                            g.iuh.c("DBRepair", "Backup recover failed: " + lastError(), null);
                        }
                        g gVar = g.iuh;
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = Integer.valueOf(i2);
                        objArr2[1] = String.format("%d|%d|%d|%d", new Object[]{Long.valueOf(this.eYp), Long.valueOf(nanoTime / 1000000), Integer.valueOf(successCount), Integer.valueOf(failureCount)});
                        gVar.h(11098, objArr2);
                        if (i3 >= 0) {
                            g.iuh.a(181, (long) i3, 1, false);
                        }
                        if (bVar2 != null) {
                            bVar2.gu(i);
                        }
                    }
                };
                this.eXP.run(false);
                i = 0;
            } catch (Throwable e) {
                v.a("MicroMsg.SubCoreDBBackup", e, "Failed to start database recovery, path: %s", str2);
                i = -1;
            }
        }
        return i;
    }

    public final synchronized int a(b bVar) {
        int i;
        final com.tencent.mm.model.c yW = ak.yW();
        final String vd = com.tencent.mm.model.c.vd();
        long bum = be.bum();
        File file = new File(vd);
        if (file.canRead()) {
            if (((float) bum) < ((float) file.length()) * 1.5f) {
                i = -2;
            } else {
                File file2 = new File(com.tencent.mm.model.c.xo() + ".sm");
                final String absolutePath = file2.canRead() ? file2.getAbsolutePath() : null;
                final b bVar2 = bVar;
                Runnable anonymousClass3 = new Runnable(this) {
                    final /* synthetic */ d eYo;
                    final String[] eYs = new String[]{"message", "ImgInfo2", "videoinfo2", "EmojiInfo", "conversation", "rconversation"};

                    /* JADX WARNING: inconsistent code. */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void run() {
                        /*
                        r13 = this;
                        r4 = 1;
                        r3 = 0;
                        r9 = 0;
                        com.tencent.mm.model.c.wJ();	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        com.tencent.mm.model.c.wK();	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        com.tencent.mm.ae.n.GH();	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        com.tencent.mm.as.k.KV();	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        r0.<init>();	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        r1 = com.tencent.mm.compatible.d.p.rJ();	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        r0 = r0.append(r1);	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        r1 = com.tencent.mm.model.c.ww();	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        r0 = r0.append(r1);	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        r0 = r0.toString();	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        r0 = r0.getBytes();	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        r1 = com.tencent.mm.a.g.n(r0);	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        r0 = com.tencent.mm.a.g.m(r0);	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        r2 = 0;
                        r5 = 7;
                        r0 = r0.substring(r2, r5);	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        r5 = r0.getBytes();	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        r0 = com.tencent.mm.model.c.wE();	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        r6 = r0.bxY();	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        r10 = java.lang.System.nanoTime();	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        r0 = 16;
                        r2 = new byte[r0];	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        r0 = r3;	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        if (r0 == 0) goto L_0x020d;
                    L_0x0052:
                        r0 = r3;	 Catch:{ Exception -> 0x0112, all -> 0x01d2 }
                        r7 = r13.eYs;	 Catch:{ Exception -> 0x0112, all -> 0x01d2 }
                        r1 = com.tencent.mmdb.repair.RepairKit.MasterInfo.load(r0, r1, r7, r2);	 Catch:{ Exception -> 0x0112, all -> 0x01d2 }
                        r0 = "MicroMsg.SubCoreDBBackup";
                        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0207, all -> 0x01f1 }
                        r8 = "Loaded saved master: ";
                        r7.<init>(r8);	 Catch:{ Exception -> 0x0207, all -> 0x01f1 }
                        r8 = r3;	 Catch:{ Exception -> 0x0207, all -> 0x01f1 }
                        r7 = r7.append(r8);	 Catch:{ Exception -> 0x0207, all -> 0x01f1 }
                        r7 = r7.toString();	 Catch:{ Exception -> 0x0207, all -> 0x01f1 }
                        com.tencent.mm.sdk.platformtools.v.i(r0, r7);	 Catch:{ Exception -> 0x0207, all -> 0x01f1 }
                    L_0x0072:
                        if (r1 != 0) goto L_0x020a;
                    L_0x0074:
                        r0 = r13.eYs;	 Catch:{ Exception -> 0x013d, all -> 0x01f1 }
                        r1 = com.tencent.mmdb.repair.RepairKit.MasterInfo.make(r0);	 Catch:{ Exception -> 0x013d, all -> 0x01f1 }
                        r0 = "MicroMsg.SubCoreDBBackup";
                        r2 = "Saved master not available.";
                        com.tencent.mm.sdk.platformtools.v.w(r0, r2);	 Catch:{ Exception -> 0x013d, all -> 0x01f1 }
                        r0 = r9;
                    L_0x0084:
                        r2 = new com.tencent.mmdb.repair.RepairKit;	 Catch:{ Exception -> 0x013d, all -> 0x01f1 }
                        r7 = r4;	 Catch:{ Exception -> 0x013d, all -> 0x01f1 }
                        r2.<init>(r7, r5, r0);	 Catch:{ Exception -> 0x013d, all -> 0x01f1 }
                        r0 = 1;
                        r5 = r2.output(r6, r1, r0);	 Catch:{ Exception -> 0x01fe, all -> 0x01f5 }
                        r0 = r2.isHeaderCorrupted();	 Catch:{ Exception -> 0x01fe, all -> 0x01f5 }
                        if (r0 == 0) goto L_0x009c;
                    L_0x0096:
                        r0 = r2.isDataCorrupted();	 Catch:{ Exception -> 0x01fe, all -> 0x01f5 }
                        if (r0 != 0) goto L_0x0199;
                    L_0x009c:
                        r0 = r4;
                    L_0x009d:
                        r3 = r5 & r0;
                        r1.release();	 Catch:{ Exception -> 0x01fe, all -> 0x01f5 }
                        r2.release();	 Catch:{ Exception -> 0x0203, all -> 0x01f9 }
                        r0 = com.tencent.mm.model.c.wJ();	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        com.tencent.mm.storage.au.bwT();	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        r0.bwV();	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        r0.bwU();	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        r0 = com.tencent.mm.ae.n.GH();	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        r0.Gr();	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        r0 = com.tencent.mm.model.c.wK();	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        r0.bvH();	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        r1 = r13.eYo;	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        monitor-enter(r1);	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        r0 = r13.eYo;	 Catch:{ all -> 0x019c }
                        r2 = 0;
                        r0.eXQ = r2;	 Catch:{ all -> 0x019c }
                        monitor-exit(r1);	 Catch:{ all -> 0x019c }
                        r0 = java.lang.System.nanoTime();	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        r4 = r0 - r10;
                        r1 = "MicroMsg.SubCoreDBBackup";
                        r2 = "DB repair %s, elapsed %.2f seconds.";
                        r0 = 2;
                        r6 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        r7 = 0;
                        if (r3 == 0) goto L_0x01a2;
                    L_0x00db:
                        r0 = "succeeded";
                    L_0x00de:
                        r6[r7] = r0;	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        r0 = 1;
                        r4 = (float) r4;	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        r5 = 1315859240; // 0x4e6e6b28 float:1.0E9 double:6.50120845E-315;
                        r4 = r4 / r5;
                        r4 = java.lang.Float.valueOf(r4);	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        r6[r0] = r4;	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        com.tencent.mm.sdk.platformtools.v.i(r1, r2, r6);	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        if (r3 == 0) goto L_0x01a7;
                    L_0x00f1:
                        r0 = 26;
                        r1 = r5;	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        if (r1 == 0) goto L_0x00fd;
                    L_0x00f7:
                        r1 = r5;	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        r2 = 0;
                        r1.gu(r2);	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                    L_0x00fd:
                        r1 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        r2 = 181; // 0xb5 float:2.54E-43 double:8.94E-322;
                        r4 = (long) r0;	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        r6 = 1;
                        r8 = 0;
                        r1.a(r2, r4, r6, r8);	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        r1 = r13.eYo;
                        monitor-enter(r1);
                        r0 = r13.eYo;	 Catch:{ all -> 0x01e8 }
                        r2 = 0;
                        r0.eXQ = r2;	 Catch:{ all -> 0x01e8 }
                        monitor-exit(r1);	 Catch:{ all -> 0x01e8 }
                    L_0x0111:
                        return;
                    L_0x0112:
                        r0 = move-exception;
                        r1 = r9;
                    L_0x0114:
                        r7 = "MicroMsg.SubCoreDBBackup";
                        r0 = r0.getMessage();	 Catch:{ Exception -> 0x013d, all -> 0x01f1 }
                        com.tencent.mm.sdk.platformtools.v.e(r7, r0);	 Catch:{ Exception -> 0x013d, all -> 0x01f1 }
                        r0 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ Exception -> 0x013d, all -> 0x01f1 }
                        r7 = "DBRepair";
                        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x013d, all -> 0x01f1 }
                        r12 = "Failed to load saved master: ";
                        r8.<init>(r12);	 Catch:{ Exception -> 0x013d, all -> 0x01f1 }
                        r12 = com.tencent.mmdb.repair.RepairKit.lastError();	 Catch:{ Exception -> 0x013d, all -> 0x01f1 }
                        r8 = r8.append(r12);	 Catch:{ Exception -> 0x013d, all -> 0x01f1 }
                        r8 = r8.toString();	 Catch:{ Exception -> 0x013d, all -> 0x01f1 }
                        r12 = 0;
                        r0.c(r7, r8, r12);	 Catch:{ Exception -> 0x013d, all -> 0x01f1 }
                        goto L_0x0072;
                    L_0x013d:
                        r0 = move-exception;
                        r10 = r9;
                        r9 = r1;
                    L_0x0140:
                        r1 = "MicroMsg.SubCoreDBBackup";
                        r2 = "Failed to repair database '%s'";
                        r3 = 1;
                        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x01fc }
                        r4 = 0;
                        r5 = r4;	 Catch:{ all -> 0x01fc }
                        r3[r4] = r5;	 Catch:{ all -> 0x01fc }
                        com.tencent.mm.sdk.platformtools.v.a(r1, r0, r2, r3);	 Catch:{ all -> 0x01fc }
                        r0 = r5;	 Catch:{ all -> 0x01fc }
                        if (r0 == 0) goto L_0x015b;
                    L_0x0155:
                        r0 = r5;	 Catch:{ all -> 0x01fc }
                        r1 = -1;
                        r0.gu(r1);	 Catch:{ all -> 0x01fc }
                    L_0x015b:
                        r0 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ all -> 0x01fc }
                        r1 = "DBRepair";
                        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01fc }
                        r3 = "Repair failed: ";
                        r2.<init>(r3);	 Catch:{ all -> 0x01fc }
                        r3 = com.tencent.mmdb.repair.RepairKit.lastError();	 Catch:{ all -> 0x01fc }
                        r2 = r2.append(r3);	 Catch:{ all -> 0x01fc }
                        r2 = r2.toString();	 Catch:{ all -> 0x01fc }
                        r3 = 0;
                        r0.c(r1, r2, r3);	 Catch:{ all -> 0x01fc }
                        r1 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ all -> 0x01fc }
                        r2 = 181; // 0xb5 float:2.54E-43 double:8.94E-322;
                        r4 = 27;
                        r6 = 1;
                        r8 = 0;
                        r1.a(r2, r4, r6, r8);	 Catch:{ all -> 0x01fc }
                        r1 = r13.eYo;
                        monitor-enter(r1);
                        r0 = r13.eYo;	 Catch:{ all -> 0x01eb }
                        r2 = 0;
                        r0.eXQ = r2;	 Catch:{ all -> 0x01eb }
                        monitor-exit(r1);	 Catch:{ all -> 0x01eb }
                        if (r10 == 0) goto L_0x0192;
                    L_0x018f:
                        r10.release();
                    L_0x0192:
                        if (r9 == 0) goto L_0x0111;
                    L_0x0194:
                        r9.release();
                        goto L_0x0111;
                    L_0x0199:
                        r0 = r3;
                        goto L_0x009d;
                    L_0x019c:
                        r0 = move-exception;
                        monitor-exit(r1);	 Catch:{ all -> 0x019c }
                        throw r0;	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                    L_0x019f:
                        r0 = move-exception;
                        r10 = r9;
                        goto L_0x0140;
                    L_0x01a2:
                        r0 = "failed";
                        goto L_0x00de;
                    L_0x01a7:
                        r0 = 27;
                        r1 = r5;	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        if (r1 == 0) goto L_0x01b3;
                    L_0x01ad:
                        r1 = r5;	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        r2 = -1;
                        r1.gu(r2);	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                    L_0x01b3:
                        r1 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        r2 = "DBRepair";
                        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        r4 = "Repair failed: ";
                        r3.<init>(r4);	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        r4 = com.tencent.mmdb.repair.RepairKit.lastError();	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        r3 = r3.append(r4);	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        r3 = r3.toString();	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        r4 = 0;
                        r1.c(r2, r3, r4);	 Catch:{ Exception -> 0x019f, all -> 0x01d2 }
                        goto L_0x00fd;
                    L_0x01d2:
                        r0 = move-exception;
                        r10 = r9;
                    L_0x01d4:
                        r1 = r13.eYo;
                        monitor-enter(r1);
                        r2 = r13.eYo;	 Catch:{ all -> 0x01ee }
                        r3 = 0;
                        r2.eXQ = r3;	 Catch:{ all -> 0x01ee }
                        monitor-exit(r1);	 Catch:{ all -> 0x01ee }
                        if (r10 == 0) goto L_0x01e2;
                    L_0x01df:
                        r10.release();
                    L_0x01e2:
                        if (r9 == 0) goto L_0x01e7;
                    L_0x01e4:
                        r9.release();
                    L_0x01e7:
                        throw r0;
                    L_0x01e8:
                        r0 = move-exception;
                        monitor-exit(r1);	 Catch:{ all -> 0x01e8 }
                        throw r0;
                    L_0x01eb:
                        r0 = move-exception;
                        monitor-exit(r1);	 Catch:{ all -> 0x01eb }
                        throw r0;
                    L_0x01ee:
                        r0 = move-exception;
                        monitor-exit(r1);	 Catch:{ all -> 0x01ee }
                        throw r0;
                    L_0x01f1:
                        r0 = move-exception;
                        r10 = r9;
                        r9 = r1;
                        goto L_0x01d4;
                    L_0x01f5:
                        r0 = move-exception;
                        r9 = r1;
                        r10 = r2;
                        goto L_0x01d4;
                    L_0x01f9:
                        r0 = move-exception;
                        r10 = r2;
                        goto L_0x01d4;
                    L_0x01fc:
                        r0 = move-exception;
                        goto L_0x01d4;
                    L_0x01fe:
                        r0 = move-exception;
                        r9 = r1;
                        r10 = r2;
                        goto L_0x0140;
                    L_0x0203:
                        r0 = move-exception;
                        r10 = r2;
                        goto L_0x0140;
                    L_0x0207:
                        r0 = move-exception;
                        goto L_0x0114;
                    L_0x020a:
                        r0 = r2;
                        goto L_0x0084;
                    L_0x020d:
                        r1 = r9;
                        goto L_0x0072;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.dbbackup.d.3.run():void");
                    }
                };
                e.a(anonymousClass3, "DB Repair");
                this.eXQ = anonymousClass3;
                i = 0;
            }
        } else {
            i = -3;
        }
        return i;
    }

    public final int b(final b bVar) {
        ak.yW();
        final File file = new File(com.tencent.mm.model.c.vd());
        if (!file.canRead()) {
            return -3;
        }
        StringBuilder append = new StringBuilder().append(p.rJ());
        ak.yW();
        final String substring = com.tencent.mm.a.g.m(append.append(com.tencent.mm.model.c.ww()).toString().getBytes()).substring(0, 7);
        v.i("MicroMsg.SubCoreDBBackup", "db recover needSize : %d blockSize:%d", Long.valueOf(file.length() * 2), Long.valueOf(be.bum()));
        if (be.bum() < file.length() * 2) {
            return -2;
        }
        ak.vA().btu();
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ d eYo;

            public final void run() {
                int i;
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                }
                ak.yW();
                String xp = com.tencent.mm.model.c.xp();
                String str = xp + file.getName().replace(".db", "temp.db");
                v.i("MicroMsg.SubCoreDBBackup", "temp db path is %s", str);
                file.renameTo(new File(str));
                String str2 = xp + "sqlTemp.sql";
                List asList = Arrays.asList(new String[]{"getcontactinfo", "contact", "contact_ext", "ContactCmdBuf", "rcontact", "img_flag", "userinfo"});
                final int[] iArr = new int[1];
                long currentTimeMillis = System.currentTimeMillis();
                ak.yW();
                boolean a = com.tencent.mm.model.c.wE().a(str, substring, str2, asList, new ExecuteSqlCallback(this) {
                    final /* synthetic */ AnonymousClass4 eYw;

                    public final String preExecute(String str) {
                        int[] iArr = iArr;
                        iArr[0] = iArr[0] + 1;
                        return null;
                    }
                });
                if (a) {
                    ak.yW();
                    com.tencent.mm.model.c.wJ();
                    au.bwT();
                    ak.yW();
                    com.tencent.mm.model.c.wK().bvH();
                    ak.yW();
                    com.tencent.mm.model.c.wJ().bwV();
                    ak.yW();
                    com.tencent.mm.model.c.wJ().bwU();
                    i = 12;
                } else {
                    i = 15;
                }
                g.iuh.a(181, (long) i, 1, false);
                v.i("MicroMsg.SubCoreDBBackup", "execute %d sql and last %d", Integer.valueOf(iArr[0]), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                g gVar = g.iuh;
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(a ? 1 : 0);
                objArr[1] = iArr;
                objArr[2] = Long.valueOf(r2);
                gVar.h(11224, objArr);
                ak.vA().btw();
                if (bVar != null) {
                    bVar.gu(a ? 0 : -1);
                }
            }
        });
        return 0;
    }

    public final HashMap<Integer, com.tencent.mm.bg.g.c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        boolean z2;
        ak.yW();
        r vf = com.tencent.mm.model.c.vf();
        SQLiteDatabase bxY = com.tencent.mm.model.c.wE().bxY();
        this.eXV = vf.vc(237569);
        this.eXW = vf.getInt(237570, 10);
        this.eXX = vf.getInt(237571, 0) != 0;
        Context context = aa.getContext();
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            if (intExtra == 2 || intExtra == 5) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.eUQ = z2;
        } else {
            this.eUQ = false;
        }
        this.eUR = ((PowerManager) context.getSystemService("power")).isScreenOn();
        this.eXZ = new c<jx>(this) {
            final /* synthetic */ d eYo;

            {
                this.eYo = r2;
                this.nhz = jx.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                d dVar;
                f sU = j.sU();
                if (com.tencent.mm.sdk.b.b.bsI()) {
                    this.eYo.eXS = true;
                    this.eYo.eXT = Long.MAX_VALUE;
                } else {
                    int i = sU.getInt("AndroidDBBackupPercentage", 0);
                    ak.yW();
                    this.eYo.eXS = h.aq(com.tencent.mm.model.c.ww(), 100) < i;
                    this.eYo.eXT = (long) sU.getInt("AndroidDBBackupMaxDBSizeMB", 0);
                    dVar = this.eYo;
                    dVar.eXT *= 1048576;
                }
                this.eYo.eXU = (long) sU.getInt("AndroidDBBackupWaitSeconds", 600);
                dVar = this.eYo;
                dVar.eXU *= 1000;
                String str = "MicroMsg.SubCoreDBBackup";
                String str2 = "Auto backup enabled: %b, max size: %s, debugger: %b";
                Object[] objArr = new Object[3];
                objArr[0] = Boolean.valueOf(this.eYo.eXS);
                objArr[1] = this.eYo.eXT == Long.MAX_VALUE ? "not limited" : Long.valueOf(this.eYo.eXT);
                objArr[2] = Boolean.valueOf(com.tencent.mm.sdk.b.b.bsI());
                v.d(str, str2, objArr);
                return true;
            }
        };
        a.nhr.e(this.eXZ);
        this.eUP = new BroadcastReceiver(this) {
            final /* synthetic */ d eYo;

            {
                this.eYo = r1;
            }

            public final void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                boolean z = true;
                switch (action.hashCode()) {
                    case -2128145023:
                        if (action.equals("android.intent.action.SCREEN_OFF")) {
                            z = true;
                            break;
                        }
                        break;
                    case -1886648615:
                        if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                            z = true;
                            break;
                        }
                        break;
                    case -1454123155:
                        if (action.equals("android.intent.action.SCREEN_ON")) {
                            z = false;
                            break;
                        }
                        break;
                    case 1019184907:
                        if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                            z = true;
                            break;
                        }
                        break;
                }
                switch (z) {
                    case false:
                        this.eYo.eUR = true;
                        break;
                    case true:
                        this.eYo.eUR = false;
                        break;
                    case true:
                        this.eYo.eUQ = true;
                        break;
                    case true:
                        this.eYo.eUQ = false;
                        break;
                }
                v.v("MicroMsg.SubCoreDBBackup", "Action received: %s, interactive: %s, charging: %s", action, Boolean.valueOf(this.eYo.eUR), Boolean.valueOf(this.eYo.eUQ));
                if (this.eYo.eXS && this.eYo.eUT == null && this.eYo.eUQ && !this.eYo.eUR) {
                    if (System.currentTimeMillis() - this.eYo.eXV < 86400000) {
                        v.d("MicroMsg.SubCoreDBBackup", "Last backup time not matched.");
                        return;
                    }
                    z = this.eYo.eXW < 10;
                    final b anonymousClass1 = new b(this) {
                        final /* synthetic */ AnonymousClass7 eYy;

                        public final void gu(int i) {
                            this.eYy.eYo.eXR = false;
                            ak.yW();
                            r vf = com.tencent.mm.model.c.vf();
                            this.eYy.eYo.eXV = System.currentTimeMillis();
                            if (i == 0) {
                                vf.setLong(237569, this.eYy.eYo.eXV);
                                if (z) {
                                    d dVar = this.eYy.eYo;
                                    dVar.eXW++;
                                } else {
                                    this.eYy.eYo.eXW = 0;
                                }
                                vf.setInt(237570, this.eYy.eYo.eXW);
                            } else if (i != 1) {
                                vf.setLong(237569, this.eYy.eYo.eXV);
                                if (z) {
                                    this.eYy.eYo.eXW = 10;
                                    vf.setInt(237570, this.eYy.eYo.eXW);
                                }
                            } else {
                                return;
                            }
                            vf.iB(false);
                        }
                    };
                    this.eYo.eUT = new Runnable(this) {
                        final /* synthetic */ AnonymousClass7 eYy;

                        public final void run() {
                            this.eYy.eYo.eUT = null;
                            ak.yW();
                            long length = new File(com.tencent.mm.model.c.xo()).length();
                            long bum = be.bum();
                            if (length == 0) {
                                v.i("MicroMsg.SubCoreDBBackup", "Invalid database size, backup canceled.");
                            } else if (length > this.eYy.eYo.eXT || length > bum) {
                                v.i("MicroMsg.SubCoreDBBackup", "Not enough disk space, backup canceled.");
                                g gVar = g.iuh;
                                Object[] objArr = new Object[2];
                                objArr[0] = Integer.valueOf(10008);
                                objArr[1] = String.format("%d|%d", new Object[]{Long.valueOf(length), Long.valueOf(bum)});
                                gVar.h(11098, objArr);
                            } else {
                                this.eYy.eYo.eXR = this.eYy.eYo.a(z, anonymousClass1);
                                if (this.eYy.eYo.eXR) {
                                    v.i("MicroMsg.SubCoreDBBackup", "Auto database backup started.");
                                }
                            }
                        }
                    };
                    ak.vA().f(this.eYo.eUT, this.eYo.eXU);
                    v.i("MicroMsg.SubCoreDBBackup", "Auto database backup scheduled.");
                    g.iuh.h(11098, Integer.valueOf(10009), this.eYo.eXY.format(new Date()));
                } else if (this.eYo.eUT != null) {
                    ak.vA().btx().removeCallbacks(this.eYo.eUT);
                    this.eYo.eUT = null;
                    v.i("MicroMsg.SubCoreDBBackup", "Auto database backup canceled.");
                    g.iuh.h(11098, Integer.valueOf(10010), this.eYo.eXY.format(new Date()));
                } else if (this.eYo.eXR) {
                    this.eYo.aen();
                    this.eYo.eXR = false;
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        context.registerReceiver(this.eUP, intentFilter);
        com.tencent.mm.pluginsdk.a.b.a(new c(this), "//backupdb", "//recoverdb", "//repairdb", "//corruptdb");
        String str = "MicroMsg.SubCoreDBBackup";
        String str2 = "Auto database backup %s. Device status:%s interactive,%s charging.";
        Object[] objArr = new Object[3];
        objArr[0] = this.eXS ? "enabled" : "disabled";
        objArr[1] = this.eUR ? SQLiteDatabase.KeyEmpty : " not";
        objArr[2] = this.eUQ ? SQLiteDatabase.KeyEmpty : " not";
        v.i(str, str2, objArr);
        String str3 = bxY.getPath() + ".sm";
        str = str3 + ".tmp";
        File file = new File(str3);
        if (!file.isFile()) {
            long nanoTime = System.nanoTime();
            StringBuilder append = new StringBuilder().append(p.rJ());
            ak.yW();
            z2 = MasterInfo.save(bxY, str, com.tencent.mm.a.g.n(append.append(com.tencent.mm.model.c.ww()).toString().getBytes()));
            File file2 = new File(str);
            if (z2) {
                file.delete();
                z2 = file2.renameTo(file);
            } else {
                file2.delete();
            }
            long nanoTime2 = System.nanoTime() - nanoTime;
            str = "MicroMsg.SubCoreDBBackup";
            String str4 = "Master table backup %s, elapsed %.3f";
            Object[] objArr2 = new Object[2];
            objArr2[0] = z2 ? "SUCCEEDED" : "FAILED";
            objArr2[1] = Float.valueOf(((float) nanoTime2) / 1.0E9f);
            v.i(str, str4, objArr2);
            g.iuh.a(181, z2 ? 24 : 25, 1, false);
        }
    }

    public final void aH(boolean z) {
    }

    public final void th() {
        aen();
        this.eXR = false;
        if (this.eUT != null) {
            ak.vA().btx().removeCallbacks(this.eUT);
            this.eUT = null;
        }
        if (this.eXZ != null) {
            a.nhr.f(this.eXZ);
            this.eXZ = null;
        }
        if (this.eUP != null) {
            aa.getContext().unregisterReceiver(this.eUP);
            this.eUP = null;
        }
        com.tencent.mm.pluginsdk.a.b.A("//backupdb", "//recoverdb", "//repairdb", "//corruptdb");
    }
}
