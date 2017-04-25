package com.tencent.mm.as;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class g {
    Map<String, Integer> dgN = new HashMap();

    public interface a {
        void gu(int i);
    }

    private class b implements Runnable {
        String aZy;
        f dgO;
        final /* synthetic */ g dgP;
        String path;

        private b(g gVar) {
            this.dgP = gVar;
        }

        public final void run() {
            int i;
            v.i("MicroMsg.SightDraftService", "on SightDraftPerpareJob::run: path %s, md5 %s", this.path, this.aZy);
            long Nj = be.Nj();
            String str = this.path;
            String str2 = this.aZy;
            f fVar = new f();
            Cursor rawQuery = k.KX().cie.rawQuery("SELECT MAX(localId) FROM SightDraftInfo", null);
            if (rawQuery == null) {
                i = -1;
            } else {
                i = rawQuery.moveToFirst() ? rawQuery.getInt(0) + 1 : 0;
                rawQuery.close();
                v.v("MicroMsg.SightDraftStorage", "get max local id, result %d", Integer.valueOf(i));
            }
            fVar.field_localId = i;
            fVar.field_fileName = com.tencent.mm.a.g.m(String.format("path=%s,time1=%d,time2=%d", new Object[]{str, Long.valueOf(System.currentTimeMillis()), Long.valueOf(SystemClock.elapsedRealtime())}).getBytes());
            fVar.field_fileNameHash = fVar.field_fileName.hashCode();
            File file = new File(str);
            fVar.field_fileLength = file.length();
            if (be.kS(str2)) {
                fVar.field_fileMd5 = com.tencent.mm.a.g.g(file);
            } else {
                fVar.field_fileMd5 = str2;
            }
            fVar.field_fileStatus = 0;
            this.dgO = fVar;
            this.dgO.l("prepared finish:", Nj);
            this.dgP.dgN.put(this.path, Integer.valueOf(this.dgO.field_fileNameHash));
            k.KX().b(this.dgO);
        }
    }

    private class c implements Runnable {
        String aZy;
        String bdZ;
        final /* synthetic */ g dgP;
        a dgQ;
        int duration;
        String path;

        private c(g gVar) {
            this.dgP = gVar;
        }

        public final void run() {
            com.tencent.mm.sdk.h.c gv;
            v.i("MicroMsg.SightDraftService", "on SightDraftSaveJob::run: %s, %s", this.path, this.bdZ);
            Integer num = (Integer) this.dgP.dgN.get(this.path);
            if (num != null) {
                gv = k.KX().gv(num.intValue());
            } else {
                gv = null;
            }
            if (gv == null) {
                v.d("MicroMsg.SightDraftService", "get sight draft from DB fail, path %s", this.path);
                b bVar = new b();
                bVar.path = this.path;
                bVar.aZy = this.aZy;
                bVar.run();
                gv = bVar.dgO;
            }
            File file = new File(this.path);
            if (file.length() <= 0 || gv.field_fileLength != file.length()) {
                gv.field_fileStatus = 3;
                v.w("MicroMsg.SightDraftService", "save sight draft error, prepare length %d, current file length %d", Long.valueOf(gv.field_fileLength), Long.valueOf(file.length()));
                k.KX().a(gv, "localId");
                if (this.dgQ != null) {
                    this.dgQ.gu(1);
                }
                this.dgQ = null;
                return;
            }
            if (1 == p.ceJ.ceh) {
                v.i("MicroMsg.SightDraftService", "save sight draft, check file md5");
                if (!be.ma(com.tencent.mm.a.g.g(file)).equals(gv.field_fileMd5)) {
                    gv.field_fileStatus = 4;
                    v.w("MicroMsg.SightDraftService", "save sight draft error, prepare md5 %s, current file md5 %s", gv.field_fileMd5, r2);
                    k.KX().a(gv, "localId");
                    if (this.dgQ != null) {
                        this.dgQ.gu(2);
                    }
                    this.dgQ = null;
                    return;
                }
            }
            if (e.p(this.path, g.kV(gv.field_fileName)) <= 0) {
                gv.field_fileStatus = 5;
                v.w("MicroMsg.SightDraftService", "save sight draft error, copy %s to %s fail", this.path, g.kV(gv.field_fileName));
                k.KX().a(gv, "localId");
                if (this.dgQ != null) {
                    this.dgQ.gu(3);
                }
                this.dgQ = null;
                return;
            }
            e.p(this.bdZ, g.kW(gv.field_fileName));
            gv.field_fileDuration = this.duration;
            gv.field_createTime = be.Ni();
            gv.field_fileStatus = 1;
            k.KX().a(gv, "localId");
            k.KX().KO();
            gv.l("save draft:", -1);
            if (this.dgQ != null) {
                this.dgQ.gu(0);
            }
            this.dgQ = null;
        }
    }

    private class d implements Runnable {
        public String bdo;
        final /* synthetic */ g dgP;
        public a dgQ;
        public int dgR;

        private d(g gVar) {
            this.dgP = gVar;
        }

        public final void run() {
            com.tencent.mm.sdk.h.c gv = k.KX().gv(this.dgR);
            if (gv == null) {
                v.w("MicroMsg.SightDraftService", "want to send sight draft, but not found draft info, talker %s, draft hash %d", this.bdo, Integer.valueOf(this.dgR));
                return;
            }
            String lb = o.lb(this.bdo);
            if (-1 == p.d(lb, gv.field_fileDuration, this.bdo)) {
                v.w("MicroMsg.SightDraftService", "want to send sight draft, but prepare sight error, talker %s, draft hash %d", this.bdo, Integer.valueOf(this.dgR));
                return;
            }
            File file = new File(g.kV(gv.field_fileName));
            if (file.length() <= 0 || gv.field_fileLength != file.length()) {
                gv.field_fileStatus = 3;
                v.w("MicroMsg.SightDraftService", "want to send sight draft, but file length error, target length %d, current file length %d, talker %s, draft hash %d", Long.valueOf(gv.field_fileLength), Long.valueOf(file.length()), this.bdo, Integer.valueOf(this.dgR));
                k.KX().a(gv, "localId");
                if (this.dgQ != null) {
                    this.dgQ.gu(1);
                }
                this.dgQ = null;
                p.lj(lb);
                return;
            }
            if (1 == p.ceJ.ceh) {
                long currentTimeMillis = System.currentTimeMillis();
                String ma = be.ma(com.tencent.mm.a.g.g(file));
                v.i("MicroMsg.SightDraftService", "send sight draft, check file md5, time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                if (!ma.equals(gv.field_fileMd5)) {
                    gv.field_fileStatus = 4;
                    v.w("MicroMsg.SightDraftService", "save sight draft error, prepare md5 %s, current file md5 %s", gv.field_fileMd5, ma);
                    k.KX().a(gv, "localId");
                    if (this.dgQ != null) {
                        this.dgQ.gu(2);
                    }
                    this.dgQ = null;
                    p.lj(lb);
                    return;
                }
            }
            k.KV();
            e.p(g.kV(gv.field_fileName), o.lc(lb));
            k.KV();
            e.p(g.kW(gv.field_fileName), o.ld(lb));
            p.f(lb, gv.field_fileDuration, 62);
            int lk = p.lk(lb);
            v.i("MicroMsg.SightDraftService", "sight draft send to %s, draft hash %d, result %d", this.bdo, Integer.valueOf(this.dgR), Integer.valueOf(lk));
        }
    }

    public static final String kV(String str) {
        if (be.kS(str)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        return stringBuilder.append(com.tencent.mm.model.c.xg()).append(str).toString();
    }

    public static final String kW(String str) {
        if (be.kS(str)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        return stringBuilder.append(com.tencent.mm.model.c.xg()).append(str).append(".thumb").toString();
    }

    public final void ac(String str, String str2) {
        Runnable bVar = new b();
        bVar.path = str;
        bVar.aZy = str2;
        ak.vA().x(bVar);
    }

    public final void a(String str, String str2, String str3, int i, a aVar) {
        Runnable cVar = new c();
        cVar.path = str;
        cVar.bdZ = str2;
        cVar.aZy = str3;
        cVar.duration = i;
        cVar.dgQ = aVar;
        ak.vA().x(cVar);
    }
}
