package com.tencent.mm.pluginsdk.k.a.c;

import android.database.Cursor;
import com.tencent.mm.compatible.d.w;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t.a;
import java.util.LinkedList;
import java.util.List;

final class o {
    public static void bof() {
        if (ak.uz() && !ak.uG() && getNetworkType() != 0) {
            long Nh = be.Nh();
            ak.yW();
            if (be.a((Long) c.vf().get(a.USERINFO_RES_DOWNLOADER_CHECK_RESUME_INTERVAL_LONG, null), 0) < Nh) {
                long j = 3600 + Nh;
                ak.yW();
                c.vf().a(a.USERINFO_RES_DOWNLOADER_CHECK_RESUME_INTERVAL_LONG, Long.valueOf(j));
                v.i("MicroMsg.PostTaskCheckResume", "doCheckResume");
                a.lED.vA().x(new Runnable() {
                    public final void run() {
                        List list = null;
                        p bog = a.lED;
                        int networkType = o.getNetworkType();
                        v.i("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, networkType = %d", Integer.valueOf(networkType));
                        if (networkType == 0) {
                            v.i("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, networkType is unavailable");
                        } else if (bog.lfs) {
                            if (bog.lfs) {
                                long Ni = be.Ni();
                                Cursor Kp = bog.lEA.Kp();
                                if (Kp != null) {
                                    if (Kp.getCount() <= 0) {
                                        Kp.close();
                                    } else {
                                        list = new LinkedList();
                                        Kp.moveToFirst();
                                        do {
                                            r rVar = new r();
                                            rVar.b(Kp);
                                            list.add(rVar);
                                        } while (Kp.moveToNext());
                                        Kp.close();
                                    }
                                }
                                v.i("MicroMsg.ResDownloaderCore", "queryAll: cost = %d", Long.valueOf(be.ay(Ni)));
                            }
                            if (be.bP(r0)) {
                                v.i("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, no record stored, skip this resumeAll-op");
                                return;
                            }
                            for (r rVar2 : r0) {
                                if (!be.kS(rVar2.field_groupId1)) {
                                    int hashCode = rVar2.field_groupId1.hashCode();
                                    for (h hVar : q.boh()) {
                                        if (hashCode == be.ma(hVar.Pa()).hashCode()) {
                                            hVar.biT().a(rVar2, networkType);
                                        }
                                    }
                                }
                            }
                        } else {
                            v.e("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, core can not work");
                        }
                    }
                });
            }
        }
    }

    static int getNetworkType() {
        switch (w.sb()) {
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                return 2;
        }
    }
}
