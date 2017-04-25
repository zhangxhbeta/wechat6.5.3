package com.tencent.mm.ae;

import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.mm.a.e;
import com.tencent.mm.a.f;
import com.tencent.mm.ae.a.a;
import com.tencent.mm.ae.h.AnonymousClass6;
import com.tencent.mm.bg.g.c;
import com.tencent.mm.e.a.mq;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.d;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.HashMap;

public class n implements ag {
    private static HashMap<Integer, c> bXq;
    private SFSContext cOA = null;
    private SFSContext cOB = null;
    private f cOq;
    private h cOr;
    private b cOs;
    private i cOt = new i();
    private c cOu = null;
    private g cOv = new g();
    private a cOw = null;
    private o cOx = null;
    private com.tencent.mm.sdk.c.c cOy = new com.tencent.mm.sdk.c.c<mq>(this) {
        final /* synthetic */ n cOC;

        {
            this.cOC = r2;
            this.nhz = mq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            bx bxVar = ((mq) bVar).bnZ.aXd;
            h GF = n.GF();
            d ai = n.GH().ai(bxVar.field_msgId);
            ai.fv(0);
            n.GH().a(Long.valueOf(ai.cLu), ai);
            int i = ai.Gp() ? 1 : 0;
            String l = n.GH().l(ai.cLv, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
            if (l == null || l.equals(SQLiteDatabase.KeyEmpty) || !e.aR(l)) {
                v.e("MicroMsg.ImgService", "sendMsgImage: filePath is null or empty");
            } else {
                ad.o(new AnonymousClass6(GF, ai, i));
            }
            return false;
        }
    };
    private a cOz = null;

    private static n GE() {
        n nVar = (n) ak.yP().fY(n.class.getName());
        if (nVar != null) {
            return nVar;
        }
        Object nVar2 = new n();
        ak.yP().a(n.class.getName(), nVar2);
        return nVar2;
    }

    public static h GF() {
        if (GE().cOr == null) {
            GE().cOr = new h();
        }
        return GE().cOr;
    }

    public static b GG() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (GE().cOs == null) {
            GE().cOs = new b();
        }
        return GE().cOs;
    }

    public static f GH() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (GE().cOq == null) {
            n GE = GE();
            ak.yW();
            GE.cOq = new f(com.tencent.mm.model.c.wE());
        }
        return GE().cOq;
    }

    public static c GI() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (GE().cOu == null) {
            GE().cOu = new c();
        }
        return GE().cOu;
    }

    public static a GJ() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (GE().cOw == null) {
            GE().cOw = new a(Looper.getMainLooper());
        }
        return GE().cOw;
    }

    public static o GK() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (GE().cOx == null) {
            GE().cOx = new o();
        }
        return GE().cOx;
    }

    public static a GL() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (GE().cOz == null) {
            GE().cOz = new a(aa.getContext());
        }
        return GE().cOz;
    }

    public static SFSContext GM() {
        return null;
    }

    public final void th() {
        n GE = GE();
        if (GE.cOr != null) {
            com.tencent.mm.v.e eVar = GE.cOr;
            eVar.aVw = 0;
            ak.vy().b((int) MMGIFException.D_GIF_ERR_CLOSE_FAILED, eVar);
        }
        if (GE.cOw != null) {
            c.a aVar = GE.cOw;
            synchronized (aVar.cKP) {
                aVar.cKP.clear();
                aVar.cKQ = 0;
                GI().a(aVar);
            }
            com.tencent.mm.sdk.c.a.nhr.f(aVar.cLb);
            com.tencent.mm.sdk.c.a.nhr.f(aVar.cLc);
        }
        if (GE.cOu != null) {
            com.tencent.mm.v.e eVar2 = GE.cOu;
            v.i("ModelImage.DownloadImgService", "on detach");
            v.i("ModelImage.DownloadImgService", "cancel all net scene");
            eVar2.cLl = true;
            eVar2.b(eVar2.cLj);
            while (eVar2.cLh.size() > 0) {
                eVar2.b((b) eVar2.cLh.get(0));
            }
            eVar2.Gk();
            ak.vy().b((int) MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM, eVar2);
        }
        if (GE.cOx != null) {
            o oVar = GE.cOx;
            v.i("MicroMsg.UrlImageCacheService", "detach");
            oVar.cOD.clear();
            oVar.cOF = true;
        }
        GN();
        d.c.aw(Integer.valueOf(3));
        d.c.aw(Integer.valueOf(23));
        com.tencent.mm.cache.a.a.a("local_cdn_img_cache", null);
        com.tencent.mm.sdk.c.a.nhr.f(this.cOy);
        if (GE.cOz != null) {
            GE.cOz.detach();
            GE.cOz = null;
        }
        if (GE.cOA != null) {
            GE.cOA.release();
            GE.cOA = null;
        }
        if (GE.cOB != null) {
            GE.cOB.release();
            GE.cOB = null;
        }
    }

    public static void GN() {
        f fVar = GE().cOq;
        if (fVar != null) {
            v.i("MicroMsg.ImgInfoStorage", "clearCacheMap stack:%s", be.bur());
            fVar.cMb.a(new f.a<String, Bitmap>(fVar) {
                final /* synthetic */ f cMo;

                {
                    this.cMo = r1;
                }
            });
        }
        a aVar = GE().cOz;
        if (aVar != null) {
            aVar.detach();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        bXq = hashMap;
        hashMap.put(Integer.valueOf("IMGINFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return f.cic;
            }
        });
    }

    public final HashMap<Integer, c> ti() {
        return bXq;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        d.c.a(Integer.valueOf(3), this.cOv);
        d.c.a(Integer.valueOf(23), this.cOv);
        com.tencent.mm.cache.a.a.a("local_cdn_img_cache", this.cOt);
        com.tencent.mm.sdk.c.a.nhr.e(this.cOy);
    }

    public final void aH(boolean z) {
    }
}
