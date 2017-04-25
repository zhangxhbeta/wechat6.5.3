package com.tencent.mm.as;

import com.tencent.mm.as.t.a;
import com.tencent.mm.bg.g.c;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.b;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.d;
import com.tencent.mm.v.e;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.util.HashMap;

public class k implements ag {
    private static HashMap<Integer, c> bXq;
    private static ac dhA = null;
    private static ad dhz = null;
    private q dhs = new q();
    private o dht;
    private s dhu;
    private a dhv = null;
    private h dhw = null;
    private g dhx = null;
    private i dhy = null;

    static {
        HashMap hashMap = new HashMap();
        bXq = hashMap;
        hashMap.put(Integer.valueOf("VIDEOINFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return o.cic;
            }
        });
        bXq.put(Integer.valueOf("VIDEOPLAYHISTORY_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return s.cic;
            }
        });
        bXq.put(Integer.valueOf("SIGHTDRAFTSINFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return h.cic;
            }
        });
    }

    private static k KU() {
        k kVar = (k) ak.yP().fY(k.class.getName());
        if (kVar != null) {
            return kVar;
        }
        Object kVar2 = new k();
        ak.yP().a(k.class.getName(), kVar2);
        return kVar2;
    }

    public static o KV() {
        if (ak.uz()) {
            if (KU().dht == null) {
                k KU = KU();
                ak.yW();
                KU.dht = new o(com.tencent.mm.model.c.wE());
            }
            return KU().dht;
        }
        throw new b();
    }

    public static s KW() {
        if (ak.uz()) {
            if (KU().dhu == null) {
                k KU = KU();
                ak.yW();
                KU.dhu = new s(com.tencent.mm.model.c.wE());
            }
            return KU().dhu;
        }
        throw new b();
    }

    public static h KX() {
        if (ak.uz()) {
            if (KU().dhw == null) {
                k KU = KU();
                ak.yW();
                KU.dhw = new h(com.tencent.mm.model.c.wE());
            }
            return KU().dhw;
        }
        throw new b();
    }

    public static a KY() {
        if (ak.uz()) {
            if (KU().dhv == null) {
                KU().dhv = new a();
            }
            return KU().dhv;
        }
        throw new b();
    }

    public static i KZ() {
        if (ak.uz()) {
            if (KU().dhy == null) {
                KU().dhy = new i();
            }
            return KU().dhy;
        }
        throw new b();
    }

    public static g La() {
        if (ak.uz()) {
            if (KU().dhx == null) {
                KU().dhx = new g();
            }
            return KU().dhx;
        }
        throw new b();
    }

    private static void Lb() {
        boolean z = false;
        if (dhA == null || dhz == null) {
            String str = "MicroMsg.SubCoreVideo";
            String str2 = "check decoder thread available fail, handler[%B] thread[%B] stack[%s]";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(dhA != null);
            if (dhz != null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = be.bur();
            v.w(str, str2, objArr);
            if (dhA != null) {
                dhA.removeCallbacksAndMessages(null);
            }
            if (dhz != null) {
                dhz.a(null);
            } else {
                dhz = new ad("Short-Video-Decoder-Thread-" + System.currentTimeMillis());
            }
            dhA = new ac(dhz.htb.getLooper());
        }
    }

    public static boolean b(Runnable runnable, long j) {
        if (runnable == null) {
            return false;
        }
        Lb();
        if (j > 0) {
            dhA.postDelayed(runnable, j);
        } else {
            dhA.post(runnable);
        }
        return true;
    }

    public static boolean e(Runnable runnable) {
        if (runnable == null) {
            return true;
        }
        Lb();
        if (dhA == null) {
            v.e("MicroMsg.SubCoreVideo", "short video decoder handler is null");
            return false;
        }
        dhA.removeCallbacks(runnable);
        return true;
    }

    public final void th() {
        try {
            if (KU().dhv != null) {
                e eVar = KU().dhv;
                eVar.aVw = 0;
                if (eVar.dit != null) {
                    eVar.dit.ph();
                }
                if (eVar.diu != null) {
                    d dVar = eVar.diu;
                    v.i("MicroMsg.NetSceneUploadVideo", "stop %s", dVar.cMU);
                    if (!be.kS(dVar.cMU)) {
                        g.DZ().ip(dVar.cMU);
                    }
                    dVar.dgr = true;
                }
                ak.vy().b(149, eVar);
                ak.vy().b(150, eVar);
            }
            if (KU().dhy != null) {
                i iVar = KU().dhy;
                iVar.aVw = 0;
                v.i("MicroMsg.SightMassSendService", "stop, cur cdn client id %s", iVar.dgW);
                if (!be.kS(iVar.dgW)) {
                    g.DZ().ip(iVar.dgW);
                }
            }
        } catch (Throwable e) {
            v.a("MicroMsg.SubCoreVideo", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
        d.c.aw(Integer.valueOf(43));
        d.c.aw(Integer.valueOf(44));
        d.c.aw(Integer.valueOf(62));
        if (dhA != null) {
            dhA.removeCallbacksAndMessages(null);
        }
        try {
            a KY = KY();
            v.i("MicroMsg.VideoService", "quitVideoSendThread: %s", KY.dio);
            if (KY.dio != null) {
                try {
                    KY.dio.quit();
                    KY.diq = false;
                    KY.dip = null;
                    KY.dio = null;
                } catch (Exception e2) {
                    v.e("MicroMsg.VideoService", "quitVideoSendThread error: %s", e2.getMessage());
                }
            }
        } catch (Exception e22) {
            v.e("MicroMsg.SubCoreVideo", "onAccountRelease, quitVideoSendThread error: %s", e22.getMessage());
        }
    }

    public final HashMap<Integer, c> ti() {
        return bXq;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        d.c.a(Integer.valueOf(43), this.dhs);
        d.c.a(Integer.valueOf(44), this.dhs);
        d.c.a(Integer.valueOf(62), this.dhs);
        if (dhA != null) {
            dhA.removeCallbacksAndMessages(null);
        }
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ k dhB;

            {
                this.dhB = r1;
            }

            public final void run() {
                if (ak.uz()) {
                    o KV = k.KV();
                    v.i("MicroMsg.VideoInfoStorage", "fail all massSendInfos, sql %s", "UPDATE videoinfo2 SET status = 198, lastmodifytime = " + (System.currentTimeMillis() / 1000) + " WHERE masssendid > 0  AND " + "status = 200");
                    KV.cuX.dF("videoinfo2", r1);
                    k.KX().KQ();
                    k.KX().KO();
                    for (f fVar : k.KX().KM()) {
                        v.i("MicroMsg.SubCoreVideo", "do delete sight draft file, name %s", fVar.field_fileName);
                        com.tencent.mm.loader.stub.b.deleteFile(g.kV(fVar.field_fileName));
                        com.tencent.mm.loader.stub.b.deleteFile(g.kW(fVar.field_fileName));
                    }
                }
            }
        });
        ak.yW();
        File file = new File(com.tencent.mm.model.c.xg());
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
    }

    public final void aH(boolean z) {
    }
}
