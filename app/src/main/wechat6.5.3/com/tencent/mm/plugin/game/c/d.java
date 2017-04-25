package com.tencent.mm.plugin.game.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.downloader.f;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;
import java.util.LinkedList;

public final class d {
    private static BroadcastReceiver ghI = null;
    private static boolean ghJ = false;
    private static int ghK = -1;
    private static ac ghL = new ac(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            a aVar = (a) message.obj;
            switch (message.what) {
                case 1:
                    int netType = ak.getNetType(aa.getContext());
                    if (aVar != null && netType == 0) {
                        boolean dp = com.tencent.mm.pluginsdk.model.downloader.d.bnK().dp(aVar.bew);
                        if (!dp) {
                            com.tencent.mm.pluginsdk.model.downloader.d.bnK().dm(aVar.bew);
                            if (aVar.ghM != null) {
                                d.b(aVar.ghM);
                            }
                        }
                        v.i("MicroMsg.GameAutoDownloader", "resumeTask, ret = " + dp);
                        return;
                    }
                    return;
                case 2:
                    if (aVar != null) {
                        com.tencent.mm.pluginsdk.model.downloader.d.bnK().dm(aVar.bew);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    private static class a {
        long bew;
        n ghM;

        private a() {
        }
    }

    private static class b extends BroadcastReceiver {
        private b() {
        }

        public final void onReceive(Context context, Intent intent) {
            if (!com.tencent.mm.model.ak.uz() || com.tencent.mm.model.ak.uG()) {
                v.e("MicroMsg.GameAutoDownloader", "acc has not ready");
                return;
            }
            int netType = ak.getNetType(aa.getContext());
            if (netType != d.ghK) {
                d.ghK = netType;
                v.i("MicroMsg.GameAutoDownloader", "onNetStateChange, netState = " + netType);
                LinkedList ary = au.asc().ary();
                if (!be.bP(ary)) {
                    d.F(ary);
                    Iterator it;
                    n nVar;
                    if (netType == 0) {
                        it = ary.iterator();
                        while (it.hasNext()) {
                            nVar = (n) it.next();
                            nVar.arp();
                            d.a(nVar, false);
                        }
                        return;
                    }
                    it = ary.iterator();
                    while (it.hasNext()) {
                        nVar = (n) it.next();
                        nVar.arp();
                        d.e(nVar);
                    }
                }
            }
        }
    }

    static /* synthetic */ void F(LinkedList linkedList) {
        Object linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            n nVar = (n) it.next();
            if (nVar.field_expireTime <= System.currentTimeMillis() / 1000) {
                v.i("MicroMsg.GameAutoDownloader", "expireTime expireTime = %d, currentTime = %d, appid = %s", new Object[]{Long.valueOf(nVar.field_expireTime), Long.valueOf(System.currentTimeMillis() / 1000), nVar.field_appId});
                f GN = com.tencent.mm.pluginsdk.model.downloader.d.bnK().GN(nVar.field_appId);
                if (GN != null) {
                    v.i("MicroMsg.GameAutoDownloader", "downloadId = %d, status = %d", new Object[]{Long.valueOf(GN.id), Integer.valueOf(GN.status)});
                    if (GN.id > 0) {
                        Message message = new Message();
                        message.what = 2;
                        a aVar = new a();
                        aVar.bew = GN.id;
                        aVar.ghM = nVar;
                        message.obj = aVar;
                        ghL.sendMessageDelayed(message, 2000);
                    }
                    au.asc().c(nVar, new String[0]);
                    linkedList2.add(nVar);
                } else {
                    return;
                }
            }
        }
        if (!be.bP(linkedList2)) {
            Iterator it2 = linkedList2.iterator();
            while (it2.hasNext()) {
                linkedList.remove((n) it2.next());
            }
        }
    }

    static /* synthetic */ void e(n nVar) {
        f GN = com.tencent.mm.pluginsdk.model.downloader.d.bnK().GN(nVar.field_appId);
        if (GN != null) {
            v.i("MicroMsg.GameAutoDownloader", "pauseDownloadTask, downloadId = %d, status = %d", new Object[]{Long.valueOf(GN.id), Integer.valueOf(GN.status)});
            if (GN.status == 1) {
                boolean z = com.tencent.mm.pluginsdk.model.downloader.d.bnK().do(GN.id);
                if (!z) {
                    com.tencent.mm.pluginsdk.model.downloader.d.bnK().dm(GN.id);
                }
                v.i("MicroMsg.GameAutoDownloader", "pauseDownloadTask ret = " + z);
            }
        }
    }

    public static void are() {
        if (ghI == null) {
            ghI = new b();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            aa.getContext().registerReceiver(ghI, intentFilter);
            ghJ = true;
        } catch (Exception e) {
            v.e("MicroMsg.GameAutoDownloader", e.getMessage());
            ghJ = false;
        }
    }

    public static void arf() {
        if (ghI != null) {
            try {
                aa.getContext().unregisterReceiver(ghI);
            } catch (Exception e) {
                v.e("MicroMsg.GameAutoDownloader", e.getMessage());
            }
        }
        ghI = null;
        ghJ = false;
    }

    public static void a(n nVar) {
        nVar.arp();
        if (nVar.giy == 0) {
            int i = 0;
        } else {
            boolean z = true;
        }
        if (i == 0) {
            f GN = com.tencent.mm.pluginsdk.model.downloader.d.bnK().GN(nVar.field_appId);
            v.i("MicroMsg.GameAutoDownloader", "downloadId = %d, status = %d", new Object[]{Long.valueOf(GN.id), Integer.valueOf(GN.status)});
            if (GN.id > 0) {
                com.tencent.mm.pluginsdk.model.downloader.d.bnK().dm(GN.id);
            }
            au.asc().c(nVar, new String[0]);
            return;
        }
        a(nVar, true);
    }

    private static void b(n nVar) {
        if (!com.tencent.mm.model.ak.uz()) {
            v.e("MicroMsg.GameAutoDownloader", "MMCore is not ready");
        } else if (com.tencent.mm.model.ak.uG()) {
            v.e("MicroMsg.GameAutoDownloader", "MMCore.isHold() = " + com.tencent.mm.model.ak.uG());
        } else {
            boolean z;
            int i = nVar.gii;
            com.tencent.mm.model.ak.yW();
            if (!c.isSDCardAvailable()) {
                v.e("MicroMsg.GameAutoDownloader", "sdCard is not available");
                z = false;
            } else if (com.tencent.mm.compatible.util.f.G((long) i)) {
                z = true;
            } else {
                v.e("MicroMsg.GameAutoDownloader", "sdCard have not enough space, need size = " + i);
                z = false;
            }
            if (!z) {
                return;
            }
            if (be.kS(nVar.gig) || be.kS(nVar.gih) || be.kS(nVar.field_appId)) {
                v.e("MicroMsg.GameAutoDownloader", "mAppDownloadURL = %s, mAppMD5 = %s, appId = %s", new Object[]{nVar.gig, nVar.gih, nVar.field_appId});
                return;
            }
            com.tencent.mm.pluginsdk.model.app.f aC = g.aC(nVar.field_appId, true);
            if (aC == null) {
                v.e("MicroMsg.GameAutoDownloader", "appInfo = null");
                return;
            }
            v.i("MicroMsg.GameAutoDownloader", "startDownloadTask, appid = %s, url = %s, md5 = %s", new Object[]{nVar.field_appId, nVar.gig, nVar.gih});
            com.tencent.mm.pluginsdk.model.downloader.e.a aVar = new com.tencent.mm.pluginsdk.model.downloader.e.a();
            aVar.GQ(nVar.gig);
            aVar.setAppId(nVar.field_appId);
            aVar.GT(aC.field_packageName);
            aVar.GR(g.a(aa.getContext(), aC, null));
            aVar.GS(nVar.gih);
            aVar.hO(false);
            aVar.hP(false);
            aVar.tE(1);
            aVar.hQ(true);
            long a = com.tencent.mm.pluginsdk.model.downloader.d.bnK().a(aVar.lCn);
            v.i("MicroMsg.GameAutoDownloader", "startDownloadTask id = " + a);
            if (a > 0) {
                i.a(nVar.gig, nVar.gih, 1999, nVar.field_appId, null, null);
            }
        }
    }

    private static void a(n nVar, boolean z) {
        if (be.kS(nVar.field_appId)) {
            v.e("MicroMsg.GameAutoDownloader", "appid = " + nVar.field_appId);
            return;
        }
        v.i("MicroMsg.GameAutoDownloader", "addDownloadTask, appid = %s, initDownload = %s", new Object[]{nVar.field_appId, Boolean.valueOf(z)});
        f GN = com.tencent.mm.pluginsdk.model.downloader.d.bnK().GN(nVar.field_appId);
        if (GN == null) {
            return;
        }
        if (g.o(aa.getContext(), nVar.field_appId)) {
            au.asc().c(nVar, new String[0]);
            v.i("MicroMsg.GameAutoDownloader", "app is installed, appid = " + nVar.field_appId);
            return;
        }
        v.i("MicroMsg.GameAutoDownloader", "downloadId = %d, status = %d", new Object[]{Long.valueOf(GN.id), Integer.valueOf(GN.status)});
        switch (GN.status) {
            case 0:
            case 4:
            case 5:
                if (ak.getNetType(aa.getContext()) == 0 && ghJ) {
                    b(nVar);
                    return;
                }
                return;
            case 1:
                if (z && !GN.jPw) {
                    au.asc().c(nVar, new String[0]);
                    return;
                }
                return;
            case 2:
                if (!z || GN.jPw) {
                    Message message = new Message();
                    message.what = 1;
                    a aVar = new a();
                    aVar.bew = GN.id;
                    aVar.ghM = nVar;
                    message.obj = aVar;
                    ghL.sendMessageDelayed(message, 2000);
                    return;
                }
                au.asc().c(nVar, new String[0]);
                return;
            case 3:
                au.asc().c(nVar, new String[0]);
                return;
            default:
                return;
        }
    }
}
