package com.tencent.mm.pluginsdk.model.downloader;

import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.al;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

final class h extends i {
    ah dwn = new ah(new a(this) {
        final /* synthetic */ h lCu;

        {
            this.lCu = r1;
        }

        public final boolean oU() {
            ak.vA().x(new Runnable(this.lCu) {
                final /* synthetic */ h lCu;

                {
                    this.lCu = r1;
                }

                public final void run() {
                    try {
                        Iterator it = this.lCu.lCt.iterator();
                        while (it.hasNext()) {
                            h.a(this.lCu, Long.valueOf(((Long) it.next()).longValue()));
                        }
                    } catch (Exception e) {
                        v.e("MicroMsg.FileDownloaderImpl23", e.getMessage());
                    }
                }
            });
            h hVar = this.lCu;
            boolean z = hVar.lCt == null || hVar.lCt.size() == 0;
            if (!z) {
                this.lCu.dwn.ea(500);
            }
            return true;
        }
    }, false);
    private DownloadManager lCs = ((DownloadManager) this.mContext.getSystemService("download"));
    CopyOnWriteArraySet<Long> lCt = new CopyOnWriteArraySet();
    private Context mContext = aa.getContext();

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.tencent.mm.pluginsdk.model.downloader.h r9, java.lang.Long r10) {
        /*
        r3 = 2;
        r8 = 0;
        r7 = 1;
        r6 = -1;
        r0 = r10.longValue();
        r0 = com.tencent.mm.pluginsdk.model.downloader.c.dG(r0);
        if (r0 == 0) goto L_0x002d;
    L_0x000e:
        r1 = new android.app.DownloadManager$Query;
        r1.<init>();
        r2 = new long[r7];
        r4 = r0.field_sysDownloadId;
        r2[r8] = r4;
        r1.setFilterById(r2);
        r2 = r9.lCs;	 Catch:{ Exception -> 0x002e }
        r1 = r2.query(r1);	 Catch:{ Exception -> 0x002e }
        if (r1 != 0) goto L_0x0043;
    L_0x0024:
        r0 = "MicroMsg.FileDownloaderImpl23";
        r1 = "query download status failed: cursor is null";
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
    L_0x002d:
        return;
    L_0x002e:
        r0 = move-exception;
        r1 = "MicroMsg.FileDownloaderImpl23";
        r2 = "query downloadinfo from downloadmanager failed:%s, sysDownloadId:%d";
        r3 = new java.lang.Object[r3];
        r0 = r0.toString();
        r3[r8] = r0;
        r3[r7] = r10;
        com.tencent.mm.sdk.platformtools.v.e(r1, r2, r3);
        goto L_0x002d;
    L_0x0043:
        r2 = r1.moveToFirst();
        if (r2 == 0) goto L_0x006e;
    L_0x0049:
        r2 = "status";
        r2 = r1.getColumnIndex(r2);
        r3 = "local_uri";
        r3 = r1.getColumnIndex(r3);
        r4 = "bytes_so_far";
        r4 = r1.getColumnIndex(r4);
        r5 = "total_size";
        r5 = r1.getColumnIndex(r5);
        if (r2 == r6) goto L_0x006e;
    L_0x0067:
        r2 = r1.getInt(r2);	 Catch:{ Exception -> 0x0092 }
        switch(r2) {
            case 1: goto L_0x0072;
            case 2: goto L_0x0072;
            case 4: goto L_0x00bc;
            case 8: goto L_0x00cc;
            case 16: goto L_0x00a5;
            default: goto L_0x006e;
        };
    L_0x006e:
        r1.close();
        goto L_0x002d;
    L_0x0072:
        if (r4 == r6) goto L_0x007a;
    L_0x0074:
        r2 = r1.getLong(r4);	 Catch:{ Exception -> 0x0092 }
        r0.field_downloadedSize = r2;	 Catch:{ Exception -> 0x0092 }
    L_0x007a:
        if (r5 == r6) goto L_0x0082;
    L_0x007c:
        r2 = r1.getLong(r5);	 Catch:{ Exception -> 0x0092 }
        r0.field_totalSize = r2;	 Catch:{ Exception -> 0x0092 }
    L_0x0082:
        r2 = 1;
        r0.field_status = r2;	 Catch:{ Exception -> 0x0092 }
        com.tencent.mm.pluginsdk.model.downloader.c.b(r0);	 Catch:{ Exception -> 0x0092 }
        r0 = r9.lCa;	 Catch:{ Exception -> 0x0092 }
        r2 = r10.longValue();	 Catch:{ Exception -> 0x0092 }
        r0.dF(r2);	 Catch:{ Exception -> 0x0092 }
        goto L_0x006e;
    L_0x0092:
        r0 = move-exception;
        r2 = "MicroMsg.FileDownloaderImpl23";
        r3 = "query download info failed: [%s]";
        r4 = new java.lang.Object[r7];
        r0 = r0.toString();
        r4[r8] = r0;
        com.tencent.mm.sdk.platformtools.v.e(r2, r3, r4);
        goto L_0x006e;
    L_0x00a5:
        r2 = r9.lCt;	 Catch:{ Exception -> 0x0092 }
        r2.remove(r10);	 Catch:{ Exception -> 0x0092 }
        r2 = com.tencent.mm.pluginsdk.model.downloader.b.lBT;	 Catch:{ Exception -> 0x0092 }
        r3 = 4;
        r0.field_status = r3;	 Catch:{ Exception -> 0x0092 }
        com.tencent.mm.pluginsdk.model.downloader.c.b(r0);	 Catch:{ Exception -> 0x0092 }
        r0 = r9.lCa;	 Catch:{ Exception -> 0x0092 }
        r4 = r10.longValue();	 Catch:{ Exception -> 0x0092 }
        r0.v(r4, r2);	 Catch:{ Exception -> 0x0092 }
        goto L_0x006e;
    L_0x00bc:
        r2 = 2;
        r0.field_status = r2;	 Catch:{ Exception -> 0x0092 }
        com.tencent.mm.pluginsdk.model.downloader.c.b(r0);	 Catch:{ Exception -> 0x0092 }
        r0 = r9.lCa;	 Catch:{ Exception -> 0x0092 }
        r2 = r10.longValue();	 Catch:{ Exception -> 0x0092 }
        r0.dE(r2);	 Catch:{ Exception -> 0x0092 }
        goto L_0x006e;
    L_0x00cc:
        r2 = r9.lCt;	 Catch:{ Exception -> 0x0092 }
        r2.remove(r10);	 Catch:{ Exception -> 0x0092 }
        r2 = 3;
        r0.field_status = r2;	 Catch:{ Exception -> 0x0092 }
        com.tencent.mm.pluginsdk.model.downloader.c.b(r0);	 Catch:{ Exception -> 0x0092 }
        if (r3 == r6) goto L_0x006e;
    L_0x00d9:
        r2 = r1.getString(r3);	 Catch:{ Exception -> 0x0092 }
        r0 = "";
        r3 = com.tencent.mm.sdk.platformtools.be.kS(r2);	 Catch:{ Exception -> 0x0092 }
        if (r3 != 0) goto L_0x00ee;
    L_0x00e6:
        r0 = android.net.Uri.parse(r2);	 Catch:{ Exception -> 0x0092 }
        r0 = r0.getPath();	 Catch:{ Exception -> 0x0092 }
    L_0x00ee:
        r2 = r9.lCa;	 Catch:{ Exception -> 0x0092 }
        r4 = r10.longValue();	 Catch:{ Exception -> 0x0092 }
        r2.r(r4, r0);	 Catch:{ Exception -> 0x0092 }
        goto L_0x006e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.model.downloader.h.a(com.tencent.mm.pluginsdk.model.downloader.h, java.lang.Long):void");
    }

    public h(a aVar) {
        super(aVar);
    }

    public final long a(final e eVar) {
        if (eVar.lCm) {
            v.e("MicroMsg.FileDownloaderImpl23", "autoDownloadTask not use system downloader, appid = %s", eVar.dzg);
            return -1;
        } else if (eVar == null || be.kS(eVar.lCg)) {
            v.e("MicroMsg.FileDownloaderImpl23", "Invalid Request");
            return -1;
        } else {
            String str = eVar.lCg;
            String str2 = SQLiteDatabase.KeyEmpty;
            al GM = c.GM(str);
            if (GM != null) {
                f dN = dN(GM.field_sysDownloadId);
                if (dN.status == 1) {
                    return dN.id;
                }
                str2 = GM.field_filePath;
            }
            String absolutePath = com.tencent.mm.compatible.util.h.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
            if (!be.kS(absolutePath)) {
                File file = new File(absolutePath);
                if (!file.exists()) {
                    boolean mkdir = file.mkdir();
                    v.i("MicroMsg.FileDownloaderImpl23", "download folder not exist, make new one : [%b]", Boolean.valueOf(mkdir));
                }
            }
            i.GV(str2);
            c.GK(str);
            c.GL(eVar.dzg);
            final al b = g.b(eVar);
            b.field_downloadId = System.currentTimeMillis();
            b.field_status = 0;
            b.field_downloaderType = 1;
            b.field_filePath = com.tencent.mm.compatible.util.h.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/" + i.lb(str);
            c.a(b);
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ h lCu;

                public final void run() {
                    if (eVar.lCl) {
                        b.field_md5 = g.GU(b.field_downloadUrl);
                    }
                    long c = this.lCu.c(b);
                    if (c > 0) {
                        b.field_sysDownloadId = c;
                        b.field_status = 1;
                        c.b(b);
                        this.lCu.lCa.q(b.field_downloadId, b.field_filePath);
                        d.bnK();
                        if (d.dI(b.field_downloadId)) {
                            d.bnK();
                            d.p(b.field_downloadId, c);
                        }
                        this.lCu.lCt.add(Long.valueOf(b.field_downloadId));
                        if (this.lCu.dwn.btC()) {
                            this.lCu.dwn.ea(100);
                        }
                        v.i("MicroMsg.FileDownloaderImpl23", "addDownloadTask: id: %d, url: %s, path: %s", Long.valueOf(b.field_downloadId), b.field_downloadUrl, b.field_filePath);
                        return;
                    }
                    b.field_status = 4;
                    c.b(b);
                    this.lCu.lCa.v(b.field_downloadId, b.lBT);
                    v.e("MicroMsg.FileDownloaderImpl23", "addDownloadTask Failed: Invalid downloadId");
                }
            });
            return b.field_downloadId;
        }
    }

    public final int dm(long j) {
        int remove;
        Exception e;
        d.bnK();
        if (d.dI(j)) {
            d.bnK();
            long dK = d.dK(j);
            return this.lCs.remove(new long[]{dK});
        }
        al dG = c.dG(j);
        if (dG == null) {
            v.e("MicroMsg.FileDownloaderImpl23", "Invalid id");
            return 0;
        }
        try {
            remove = this.lCs.remove(new long[]{dG.field_sysDownloadId});
            try {
                v.i("MicroMsg.FileDownloaderImpl23", "removeDownloadTask: id: %d", Long.valueOf(j));
            } catch (Exception e2) {
                e = e2;
                v.e("MicroMsg.FileDownloaderImpl23", "remove task error:[%d], [%s]", Long.valueOf(j), e.toString());
                b.deleteFile(dG.field_filePath);
                v.i("MicroMsg.FileDownloaderImpl23", "removeDownloadTask: path: %s", dG.field_filePath);
                dG.field_status = 5;
                c.b(dG);
                this.lCa.dD(j);
                this.lCt.remove(Long.valueOf(j));
                return remove;
            }
        } catch (Exception e3) {
            e = e3;
            remove = 0;
            v.e("MicroMsg.FileDownloaderImpl23", "remove task error:[%d], [%s]", Long.valueOf(j), e.toString());
            b.deleteFile(dG.field_filePath);
            v.i("MicroMsg.FileDownloaderImpl23", "removeDownloadTask: path: %s", dG.field_filePath);
            dG.field_status = 5;
            c.b(dG);
            this.lCa.dD(j);
            this.lCt.remove(Long.valueOf(j));
            return remove;
        }
        b.deleteFile(dG.field_filePath);
        v.i("MicroMsg.FileDownloaderImpl23", "removeDownloadTask: path: %s", dG.field_filePath);
        dG.field_status = 5;
        c.b(dG);
        this.lCa.dD(j);
        this.lCt.remove(Long.valueOf(j));
        return remove;
    }

    public final f dn(long j) {
        d.bnK();
        if (d.dI(j)) {
            d.bnK();
            f dN = dN(d.dK(j));
            dN.id = j;
            dN.bfb = 1;
            return dN;
        }
        al dG = c.dG(j);
        if (dG == null) {
            return new f();
        }
        if (dG.field_status == 4 || dG.field_status == 2 || dG.field_status == 5 || dG.field_status == 3) {
            dN = new f();
            dN.id = dG.field_downloadId;
            dN.url = dG.field_downloadUrl;
            dN.status = dG.field_status;
            dN.path = dG.field_filePath;
            dN.aZy = dG.field_md5;
            dN.jPw = dG.field_autoDownload;
            dN.bfb = dG.field_downloaderType;
            return dN;
        }
        dN = dN(dG.field_sysDownloadId);
        dN.id = j;
        dN.aZy = dG.field_md5;
        dN.jPw = dG.field_autoDownload;
        dN.bfb = dG.field_downloaderType;
        return dN;
    }

    final long c(al alVar) {
        try {
            Request request = new Request(Uri.parse(alVar.field_downloadUrl));
            request.setAllowedNetworkTypes(3);
            request.setShowRunningNotification(alVar.field_showNotification);
            request.setVisibleInDownloadsUi(alVar.field_showNotification);
            if (!be.kS(alVar.field_fileName)) {
                request.setTitle(alVar.field_fileName);
            }
            request.setDestinationUri(Uri.fromFile(new File(alVar.field_filePath)));
            long enqueue = this.lCs.enqueue(request);
            if (enqueue > 0) {
                return enqueue;
            }
            v.e("MicroMsg.FileDownloaderImpl23", "addToSysDownloadManager Failed: Invalid downloadId");
            return -1;
        } catch (Exception e) {
            v.e("MicroMsg.FileDownloaderImpl23", "Add download task failed: %s, url: %s", e.toString(), alVar.field_downloadUrl);
            return -1;
        }
    }

    private f dN(long j) {
        f fVar = new f();
        Query query = new Query();
        query.setFilterById(new long[]{j});
        try {
            Cursor query2 = this.lCs.query(query);
            if (query2 == null) {
                v.e("MicroMsg.FileDownloaderImpl23", "query download status failed: cursor is null");
            } else {
                if (query2.moveToFirst()) {
                    int columnIndex = query2.getColumnIndex("status");
                    int columnIndex2 = query2.getColumnIndex("uri");
                    int columnIndex3 = query2.getColumnIndex("local_uri");
                    int columnIndex4 = query2.getColumnIndex("bytes_so_far");
                    int columnIndex5 = query2.getColumnIndex("total_size");
                    if (columnIndex != -1) {
                        try {
                            switch (query2.getInt(columnIndex)) {
                                case 1:
                                case 2:
                                    fVar.status = 1;
                                    break;
                                case 4:
                                    fVar.status = 2;
                                    break;
                                case 8:
                                    fVar.status = 3;
                                    break;
                                case 16:
                                    fVar.status = 4;
                                    break;
                            }
                        } catch (Exception e) {
                            v.e("MicroMsg.FileDownloaderImpl23", "query download info failed: [%s]", e.toString());
                            fVar.status = 4;
                        }
                    }
                    if (columnIndex2 != -1) {
                        fVar.url = query2.getString(columnIndex2);
                    }
                    if (columnIndex3 != -1) {
                        String string = query2.getString(columnIndex3);
                        if (be.kS(string)) {
                            v.e("MicroMsg.FileDownloaderImpl23", "get download uri failed");
                        } else {
                            v.i("MicroMsg.FileDownloaderImpl23", "get download uri: [%s]", string);
                            fVar.path = Uri.parse(string).getPath();
                            v.i("MicroMsg.FileDownloaderImpl23", "get download path: [%s]", fVar.path);
                        }
                    }
                    if (columnIndex4 != -1) {
                        fVar.beD = query2.getLong(columnIndex4);
                    }
                    if (columnIndex5 != -1) {
                        fVar.beE = query2.getLong(columnIndex5);
                    }
                }
                query2.close();
                v.i("MicroMsg.FileDownloaderImpl23", "querySysDownloadManager: id: %d, status: %d, url: %s, path: %s", Long.valueOf(j), Integer.valueOf(fVar.status), fVar.url, fVar.path);
            }
        } catch (Exception e2) {
            v.e("MicroMsg.FileDownloaderImpl23", "query downloadinfo from downloadmanager failed:%s, sysDownloadId:%d", e2.toString(), Long.valueOf(j));
        }
        return fVar;
    }

    public final boolean do(long j) {
        f dn = dn(j);
        if (dn == null) {
            v.i("MicroMsg.FileDownloaderImpl23", "pauseDownloadTask: %d, record not found", Long.valueOf(j));
            return false;
        } else if (dn.status != 1) {
            v.i("MicroMsg.FileDownloaderImpl23", "pauseDownloadTask: %d, Task is not running", Long.valueOf(j));
            return true;
        } else {
            v.i("MicroMsg.FileDownloaderImpl23", "pauseDownloadTask: %d, Task removed: %d", Long.valueOf(j), Integer.valueOf(dm(j)));
            if (dm(j) > 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean dp(long j) {
        al dG = c.dG(j);
        if (dG == null) {
            v.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, record not found", Long.valueOf(j));
            return false;
        } else if (dG.field_downloaderType != 1) {
            v.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, downloader not matched", Long.valueOf(j));
            b.deleteFile(dG.field_filePath);
            c.dH(j);
            return false;
        } else if (dG.field_status == 1) {
            v.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, not in paused status", Long.valueOf(j));
            return false;
        } else {
            long c = c(dG);
            if (c > 0) {
                dG.field_sysDownloadId = c;
                dG.field_status = 1;
                c.b(dG);
                return true;
            }
            v.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, restart failed");
            return false;
        }
    }
}
