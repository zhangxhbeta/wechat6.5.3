package com.tencent.mm.plugin.tmassistant.a;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Looper;
import android.support.v4.app.w.d;
import com.tencent.mm.e.a.fe;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.model.ak;
import com.tencent.mm.pluginsdk.model.downloader.FileDownloadService;
import com.tencent.mm.pluginsdk.model.downloader.c;
import com.tencent.mm.pluginsdk.model.downloader.e;
import com.tencent.mm.pluginsdk.model.downloader.f;
import com.tencent.mm.pluginsdk.model.downloader.g;
import com.tencent.mm.pluginsdk.model.downloader.i;
import com.tencent.mm.pluginsdk.ui.FileDownloadConfirmUI;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.al;
import com.tencent.mm.storage.am;
import com.tencent.tmassistantsdk.downloadclient.ITMAssistantDownloadSDKClientListener;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKManager;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.downloadservice.TMAssistantDownloadSDKService;
import com.tencent.tmassistantsdk.storage.TMAssistantFile;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a extends i {
    private byte[] cGJ = new byte[0];
    ah gpy = new ah(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ a kmF;

        {
            this.kmF = r1;
        }

        public final boolean oU() {
            if (!this.kmF.baC()) {
                this.kmF.gpy.ea(60000);
            }
            return true;
        }
    }, false);
    HashSet<Long> kmA = new HashSet();
    Map<String, String> kmB = null;
    private ITMAssistantDownloadSDKClientListener kmC = new ITMAssistantDownloadSDKClientListener(this) {
        final /* synthetic */ a kmF;

        {
            this.kmF = r1;
        }

        public final void OnDwonloadSDKServiceInvalid(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient) {
            v.e("MicroMsg.FileDownloaderImplTMAssistant", "TMAssistant Service unavailable");
            Iterator it = this.kmF.kmA.iterator();
            while (it.hasNext()) {
                al dG = c.dG(((Long) it.next()).longValue());
                if (dG != null) {
                    c.w(dG.field_downloadId, 4);
                    a.a(4, dG.field_downloadId, "", 0);
                    a.a(this.kmF, dG.field_downloadUrl, 5, 0, false);
                }
            }
            this.kmF.kmA.clear();
            a.a(101, 0, "", 0);
        }

        public final void OnDownloadSDKTaskStateChanged(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient, String str, int i, int i2, String str2) {
            v.i("MicroMsg.FileDownloaderImplTMAssistant", "OnDownloadSDKTaskStateChanged State: " + i + " | ErrorCode: " + i2 + " | ErrorMsg: " + str2);
            al GM = c.GM(str);
            if (GM == null) {
                v.e("MicroMsg.FileDownloaderImplTMAssistant", "getDownloadInfoByURL failed");
                return;
            }
            v.i("MicroMsg.FileDownloaderImplTMAssistant", "State: %d, Id: %d, Path: %s, File Exists: %b, URL: %s", new Object[]{Integer.valueOf(i), Long.valueOf(GM.field_downloadId), GM.field_filePath, Boolean.valueOf(new File(GM.field_filePath).exists()), str});
            switch (i) {
                case 1:
                    return;
                case 2:
                    c.w(GM.field_downloadId, 1);
                    return;
                case 3:
                    c.w(GM.field_downloadId, 2);
                    return;
                case 4:
                    v.i("MicroMsg.FileDownloaderImplTMAssistant", "TMAssistant Download Succeed event received");
                    Intent intent = new Intent();
                    intent.putExtra(FileDownloadService.lCp, 1);
                    intent.setClass(this.kmF.mContext, FileDownloadService.class);
                    intent.putExtra(FileDownloadService.EXTRA_ID, GM.field_downloadId);
                    try {
                        this.kmF.mContext.startService(intent);
                    } catch (Exception e) {
                        v.e("MicroMsg.FileDownloaderImplTMAssistant", e.getMessage());
                    }
                    this.kmF.cancelNotification(str);
                    this.kmF.kmA.remove(Long.valueOf(GM.field_downloadId));
                    return;
                case 5:
                    a.a(this.kmF, str, i, 0, false);
                    this.kmF.kmA.remove(Long.valueOf(GM.field_downloadId));
                    c.w(GM.field_downloadId, 4);
                    a.a(4, GM.field_downloadId, "", i2);
                    return;
                case 6:
                    this.kmF.cancelNotification(str);
                    this.kmF.kmA.remove(Long.valueOf(GM.field_downloadId));
                    c.w(GM.field_downloadId, 5);
                    a.a(5, GM.field_downloadId, "", 0);
                    return;
                default:
                    return;
            }
        }

        public final void OnDownloadSDKTaskProgressChanged(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient, String str, long j, long j2) {
            Long l = (Long) this.kmF.kmy.get(str);
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            if (l == null || valueOf.longValue() - l.longValue() >= 500) {
                this.kmF.kmy.put(str, valueOf);
                v.i("MicroMsg.FileDownloaderImplTMAssistant", "onProgressChanged");
                a.a(this.kmF, str, 2, (int) ((100 * j) / j2), false);
                al GM = c.GM(str);
                if (GM == null) {
                    v.e("MicroMsg.FileDownloaderImplTMAssistant", "getDownloadInfoByURL failed");
                    return;
                }
                c.e(GM.field_downloadId, j, j2);
                a.a(7, GM.field_downloadId, "", 0);
            }
        }
    };
    private HashMap<String, Long> kmx = new HashMap();
    HashMap<String, Long> kmy = new HashMap();
    private ConcurrentHashMap<String, Integer> kmz = new ConcurrentHashMap();
    private TMAssistantDownloadSDKClient mClient = null;
    Context mContext = aa.getContext();

    static /* synthetic */ TMAssistantDownloadSDKClient a(a aVar) {
        if (aVar.mClient == null) {
            aVar.mClient = TMAssistantDownloadSDKManager.getInstance(aVar.mContext).getDownloadSDKClient("WechatDownloadClient");
            aVar.mClient.registerDownloadTaskListener(aVar.kmC);
        }
        aVar.gpy.ea(60000);
        return aVar.mClient;
    }

    static /* synthetic */ void a(a aVar, String str, int i, int i2, boolean z) {
        al GM = c.GM(str);
        if (GM == null) {
            v.e("MicroMsg.FileDownloaderImplTMAssistant", "updateNotification failed: null task info");
        } else if (GM.field_showNotification) {
            d dVar = new d(aVar.mContext);
            if (z) {
                long currentTimeMillis = System.currentTimeMillis();
                aVar.kmx.put(str, Long.valueOf(currentTimeMillis));
                dVar.b(currentTimeMillis);
            } else {
                Long l = (Long) aVar.kmx.get(str);
                if (l != null) {
                    dVar.b(l.longValue());
                }
            }
            dVar.a(GM.field_fileName);
            switch (i) {
                case 1:
                case 2:
                case 3:
                    dVar.L(17301633);
                    dVar.b(100, i2, i2 == 0);
                    dVar.b(aVar.mContext.getString(2131232766));
                    dVar.j(2, true);
                    long j = GM.field_downloadId;
                    Intent intent = new Intent(aVar.mContext, FileDownloadConfirmUI.class);
                    intent.putExtra("extra_download_id", j);
                    dVar.rI = PendingIntent.getActivity(aVar.mContext, (int) System.currentTimeMillis(), intent, 268435456);
                    break;
                case 4:
                case 6:
                    aVar.cancelNotification(str);
                    return;
                case 5:
                    dVar.L(17301634);
                    dVar.o(true);
                    dVar.rI = PendingIntent.getActivity(aa.getContext(), 0, new Intent(), 0);
                    dVar.b(aVar.mContext.getString(2131232764));
                    break;
            }
            synchronized (aVar.cGJ) {
                if (z) {
                    aVar.kmz.put(str, Integer.valueOf(ak.oH().b(dVar.build())));
                } else {
                    Integer num = (Integer) aVar.kmz.get(str);
                    if (num != null) {
                        ak.oH().notify(num.intValue(), dVar.build());
                    }
                }
            }
        }
    }

    public a() {
        super(null);
        Map hashMap = new HashMap();
        String property = System.getProperty("http.agent");
        v.i("MicroMsg.FileDownloaderImplTMAssistant", property);
        if (be.kS(property)) {
            property = "Mozilla/5.0 (Linux; Android) AppleWebkit (KHTML, like Gecko)";
        }
        property = property + " MicroMessenger";
        PackageInfo av = av(this.mContext, aa.getPackageName());
        if (av != null) {
            property = ((property + "/") + av.versionName) + "." + av.versionCode;
        }
        v.i("MicroMsg.FileDownloaderImplTMAssistant", "User-Agent: %s", new Object[]{property + " NetType/" + com.tencent.mm.sdk.platformtools.ak.getNetTypeString(aa.getContext())});
        hashMap.put("User-Agent", property);
        this.kmB = hashMap;
    }

    public final long a(final e eVar) {
        if (eVar == null || be.kS(eVar.lCg)) {
            v.e("MicroMsg.FileDownloaderImplTMAssistant", "Invalid Request");
            return -1;
        }
        final String str = eVar.lCg;
        String str2 = eVar.dzg;
        al GM = c.GM(str);
        if (GM != null) {
            f dn = dn(GM.field_downloadId);
            if (dn.status == 1) {
                return dn.id;
            }
        }
        baD();
        c.GK(str);
        c.GL(str2);
        final al b = g.b(eVar);
        b.field_downloadId = System.currentTimeMillis();
        b.field_status = 0;
        b.field_downloaderType = 2;
        c.a(b);
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ a kmF;

            public final void run() {
                if (eVar.lCl) {
                    b.field_md5 = g.GU(b.field_downloadUrl);
                }
                int i;
                try {
                    TMAssistantDownloadTaskInfo downloadTaskState = a.a(this.kmF).getDownloadTaskState(str);
                    if (downloadTaskState != null && downloadTaskState.mState == 4) {
                        a.GV(downloadTaskState.mSavePath);
                        v.i("MicroMsg.FileDownloaderImplTMAssistant", "Previous task file removed: %s, %s", new Object[]{downloadTaskState.mUrl, downloadTaskState.mSavePath});
                    }
                    a.a(this.kmF).cancelDownloadTask(str);
                    int startDownloadTask = a.a(this.kmF).startDownloadTask(str, 0, "resource/tm.android.unknown", a.lb(str), this.kmF.kmB);
                    if (startDownloadTask == 0) {
                        TMAssistantDownloadTaskInfo downloadTaskState2 = a.a(this.kmF).getDownloadTaskState(str);
                        v.i("MicroMsg.FileDownloaderImplTMAssistant", "Task Info from TMAssistant: URL: %s, PATH: %s", new Object[]{str, downloadTaskState2.mSavePath});
                        long j = b.field_downloadId;
                        String str = downloadTaskState2.mSavePath;
                        am wL = c.wL();
                        if (!(wL == null || be.kS(str))) {
                            wL.dF("FileDownloadInfo", "update FileDownloadInfo set filePath = \"" + str + "\" where downloadId = " + j);
                        }
                        c.e(b.field_downloadId, downloadTaskState2.mReceiveDataLen, downloadTaskState2.mTotalDataLen);
                        this.kmF.kmA.add(Long.valueOf(b.field_downloadId));
                        a.a(this.kmF, str, downloadTaskState2.mState, 0, true);
                        a.a(1, b.field_downloadId, downloadTaskState2.mSavePath, 0);
                        v.i("MicroMsg.FileDownloaderImplTMAssistant", "addDownloadTask: id: %d, url: %s, path: %s", new Object[]{Long.valueOf(b.field_downloadId), str, b.field_filePath});
                        return;
                    }
                    i = startDownloadTask;
                    c.w(b.field_downloadId, 4);
                    v.e("MicroMsg.FileDownloaderImplTMAssistant", "Adding Task via TMAssistant Failed: %d, url: %s", new Object[]{Integer.valueOf(i), str});
                    a.a(4, b.field_downloadId, "", 0);
                } catch (Exception e) {
                    Exception exception = e;
                    i = -1;
                    v.e("MicroMsg.FileDownloaderImplTMAssistant", "Adding task to TMAssistant failed: ", new Object[]{exception.toString()});
                }
            }
        });
        return b.field_downloadId;
    }

    public final int dm(final long j) {
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ a kmF;

            public final void run() {
                al dG = c.dG(j);
                if (dG != null) {
                    try {
                        a.a(this.kmF).cancelDownloadTask(dG.field_downloadUrl);
                        b.deleteFile(dG.field_filePath);
                        c.w(dG.field_downloadId, 5);
                        a.a(5, dG.field_downloadId, "", 0);
                        this.kmF.kmA.remove(Long.valueOf(dG.field_downloadId));
                        this.kmF.cancelNotification(dG.field_downloadUrl);
                        v.i("MicroMsg.FileDownloaderImplTMAssistant", "removeDownloadTask: id: %d, path: %s", new Object[]{Long.valueOf(j), dG.field_filePath});
                    } catch (Exception e) {
                        v.e("MicroMsg.FileDownloaderImplTMAssistant", "TMAssistant remove task failed: " + e.toString());
                    }
                }
            }
        });
        return 1;
    }

    public final f dn(long j) {
        final f fVar = new f();
        fVar.id = j;
        final al dG = c.dG(j);
        if (!(dG == null || be.kS(dG.field_downloadUrl))) {
            fVar.url = dG.field_downloadUrl;
            fVar.status = dG.field_status;
            new az<Void>(this) {
                final /* synthetic */ a kmF;

                protected final /* synthetic */ Object run() {
                    return baE();
                }

                private Void baE() {
                    try {
                        TMAssistantDownloadTaskInfo downloadTaskState = a.a(this.kmF).getDownloadTaskState(fVar.url);
                        if (downloadTaskState == null) {
                            fVar.status = 0;
                        } else {
                            switch (downloadTaskState.mState) {
                                case 1:
                                case 2:
                                    fVar.status = 1;
                                    break;
                                case 3:
                                    fVar.status = 2;
                                    break;
                                case 4:
                                    fVar.status = 3;
                                    break;
                                case 5:
                                    fVar.status = 4;
                                    break;
                                case 6:
                                    fVar.status = 5;
                                    break;
                                default:
                                    fVar.status = 0;
                                    break;
                            }
                            fVar.path = downloadTaskState.mSavePath;
                            fVar.beD = downloadTaskState.mReceiveDataLen;
                            fVar.beE = downloadTaskState.mTotalDataLen;
                            fVar.aZy = dG.field_md5;
                        }
                    } catch (Exception e) {
                        v.e("MicroMsg.FileDownloaderImplTMAssistant", "getDownloadTaskState faile: " + e.toString());
                    }
                    return null;
                }
            }.c(ak.vA().btx());
            v.i("MicroMsg.FileDownloaderImplTMAssistant", "queryDownloadTask: id: %d, status: %d, url: %s, path: %s", new Object[]{Long.valueOf(j), Integer.valueOf(fVar.status), fVar.url, fVar.path});
        }
        return fVar;
    }

    final boolean baC() {
        if (this.kmA == null || this.kmA.size() == 0) {
            TMAssistantDownloadSDKManager.getInstance(this.mContext).releaseDownloadSDKClient("WechatDownloadClient");
            if (this.mClient != null) {
                this.mClient.unRegisterDownloadTaskListener(this.kmC);
            }
            this.mClient = null;
            TMAssistantDownloadSDKManager.closeAllService(this.mContext);
            try {
                this.mContext.stopService(new Intent(this.mContext, TMAssistantDownloadSDKService.class));
            } catch (Exception e) {
                v.e("MicroMsg.FileDownloaderImplTMAssistant", "Error occurred when stopping TMAssistant Service: " + e.toString());
            }
            v.i("MicroMsg.FileDownloaderImplTMAssistant", "TMAssistantSDK Client released");
            return true;
        }
        v.i("MicroMsg.FileDownloaderImplTMAssistant", "Still have tasks running");
        return false;
    }

    final void cancelNotification(String str) {
        synchronized (this.cGJ) {
            Integer num = (Integer) this.kmz.get(str);
            if (num == null) {
                v.i("MicroMsg.FileDownloaderImplTMAssistant", "No notification id found");
                return;
            }
            ak.oH().cancel(num.intValue());
            v.i("MicroMsg.FileDownloaderImplTMAssistant", "cancelNotification, id = " + num);
            this.kmz.remove(str);
        }
    }

    private static PackageInfo av(Context context, String str) {
        PackageInfo packageInfo = null;
        if (str == null) {
            v.e("MicroMsg.FileDownloaderImplTMAssistant", "getPackageInfo fail, packageName is null");
        } else {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            } catch (Throwable e) {
                v.a("MicroMsg.FileDownloaderImplTMAssistant", e, "", new Object[0]);
            }
        }
        return packageInfo;
    }

    private static void baD() {
        if (!new File(TMAssistantFile.getSavePathRootDir() + "/.tmp/").exists()) {
            v.i("MicroMsg.FileDownloaderImplTMAssistant", "Make download dir result: %b", new Object[]{Boolean.valueOf(new File(TMAssistantFile.getSavePathRootDir() + "/.tmp/").mkdirs())});
        }
    }

    public final boolean do(final long j) {
        final al dG = c.dG(j);
        if (dG == null || be.kS(dG.field_downloadUrl)) {
            v.i("MicroMsg.FileDownloaderImplTMAssistant", "pauseDownloadTask: %d, record not found", new Object[]{Long.valueOf(j)});
            return false;
        } else if (dG.field_downloaderType != 2) {
            v.i("MicroMsg.FileDownloaderImplTMAssistant", "pauseDownloadTask: %d, downloader type not matched", new Object[]{Long.valueOf(j)});
            b.deleteFile(dG.field_filePath);
            c.dH(j);
            return false;
        } else {
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ a kmF;

                public final void run() {
                    try {
                        TMAssistantDownloadTaskInfo downloadTaskState = a.a(this.kmF).getDownloadTaskState(dG.field_downloadUrl);
                        if (downloadTaskState.mState == 1 || downloadTaskState.mState == 2) {
                            a.a(this.kmF).pauseDownloadTask(dG.field_downloadUrl);
                            c.w(dG.field_downloadId, 2);
                            a.a(2, dG.field_downloadId, "", 0);
                            this.kmF.kmA.remove(Long.valueOf(dG.field_downloadId));
                            this.kmF.cancelNotification(dG.field_downloadUrl);
                            v.i("MicroMsg.FileDownloaderImplTMAssistant", "pauseDownloadTask: %d ", new Object[]{Long.valueOf(j)});
                        }
                    } catch (Throwable e) {
                        v.e("MicroMsg.FileDownloaderImplTMAssistant", "pauseDownloadTask: %s", new Object[]{e.toString()});
                        v.a("MicroMsg.FileDownloaderImplTMAssistant", e, "", new Object[0]);
                    }
                }
            });
            return true;
        }
    }

    public final boolean dp(final long j) {
        final al dG = c.dG(j);
        if (dG == null || be.kS(dG.field_downloadUrl)) {
            v.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: %d, record not found", new Object[]{Long.valueOf(j)});
            return false;
        } else if (dG.field_downloaderType != 2) {
            v.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: %d, downloader type not matched", new Object[]{Long.valueOf(j)});
            b.deleteFile(dG.field_filePath);
            c.dH(j);
            return false;
        } else {
            baD();
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ a kmF;

                public final void run() {
                    try {
                        if (a.a(this.kmF).getDownloadTaskState(dG.field_downloadUrl).mState != 3) {
                            v.e("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask, not paused");
                            return;
                        }
                        if (a.a(this.kmF).startDownloadTask(dG.field_downloadUrl, 0, "resource/tm.android.unknown", dG.field_fileName, this.kmF.kmB) == 0) {
                            c.w(dG.field_downloadId, 1);
                            this.kmF.kmA.add(Long.valueOf(dG.field_downloadId));
                            a.a(this.kmF, dG.field_downloadUrl, 2, 0, true);
                            a.a(6, dG.field_downloadId, dG.field_filePath, 0);
                            v.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: %d", new Object[]{Long.valueOf(j)});
                            return;
                        }
                        c.w(dG.field_downloadId, 4);
                        a.a(4, dG.field_downloadId, "", 0);
                    } catch (Throwable e) {
                        v.e("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: %s", new Object[]{e.toString()});
                        v.a("MicroMsg.FileDownloaderImplTMAssistant", e, "", new Object[0]);
                    }
                }
            });
            return true;
        }
    }

    static void a(int i, long j, String str, int i2) {
        fe feVar = new fe();
        feVar.bex.bey = i;
        feVar.bex.id = j;
        feVar.bex.errCode = i2;
        feVar.bex.path = str;
        com.tencent.mm.sdk.c.a.nhr.z(feVar);
    }
}
