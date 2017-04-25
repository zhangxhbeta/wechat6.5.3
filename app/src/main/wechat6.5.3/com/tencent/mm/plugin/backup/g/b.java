package com.tencent.mm.plugin.backup.g;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Looper;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.a.e;
import com.tencent.mm.al.n;
import com.tencent.mm.as.o;
import com.tencent.mm.bg.f;
import com.tencent.mm.bg.f.a;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.bj;
import com.tencent.mm.e.a.nc;
import com.tencent.mm.e.a.w;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelstat.l;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.backup.backupmodel.c;
import com.tencent.mm.plugin.backup.backupmodel.d;
import com.tencent.mm.plugin.backup.movemodel.g;
import com.tencent.mm.plugin.backup.movemodel.h;
import com.tencent.mm.plugin.backup.movemodel.i;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.k;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.r;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

public final class b implements ag {
    private static boolean cjj = false;
    private static SharedPreferences eiE;
    private static int eiG = 0;
    private static boolean eiH = false;
    private static b eie;
    private String edV = "ok";
    private h eiA;
    private g eiB;
    private c eiC;
    private i eiD;
    private HashMap<Integer, l> eiF;
    private com.tencent.mm.model.bo.b eiI = new com.tencent.mm.model.bo.b(this) {
        final /* synthetic */ b eiJ;

        {
            this.eiJ = r1;
        }

        public final void a(com.tencent.mm.v.d.a aVar) {
            v.d("MicroMsg.BackupCore.BackupToPc", "backupcore onrecieveMsg");
            com.tencent.mm.plugin.report.service.g.iuh.a(400, 0, 1, false);
            String str = (String) bf.q(m.a(aVar.czu.mbW), "sysmsg").get(".sysmsg.MMBakChatNotify.url");
            if (be.kS(str)) {
                v.e("MicroMsg.BackupCore.BackupToPc", "MMBakChatNotify url is null");
            }
            aa.getContext().startService(be.v(aa.getContext(), new Intent("com.tencent.mm.plugin.backup.backuppcmodel.BackupPcService")).putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, str).putExtra("isFromWifi", true));
            v.d("MicroMsg.BackupCore.BackupToPc", "GET_CONNECT_INFO start end");
        }
    };
    private e eif;
    private x eig;
    private n eih;
    private k eii;
    private v eij;
    private z eik;
    private ac eil = null;
    private byte[] eim;
    private byte[] ein = "key".getBytes();
    private String eio = "id";
    private String eip = "hello";
    private String eiq = "tickit";
    private byte[] eir;
    private byte[] eis;
    private d eit;
    private com.tencent.mm.plugin.backup.bakpcmodel.c eiu;
    private com.tencent.mm.plugin.backup.backuppcmodel.a eiv;
    private com.tencent.mm.plugin.backup.backuppcmodel.c eiw;
    private com.tencent.mm.plugin.backup.backuppcmodel.b eix;
    private com.tencent.mm.plugin.backup.bakpcmodel.a eiy;
    private com.tencent.mm.plugin.backup.backupmodel.a eiz;

    public static class a implements Runnable {
        public long dbSize = 0;
        public boolean eiS = true;
        public long eiT = 0;
        public long eiU = 0;

        public void run() {
        }
    }

    static /* synthetic */ int Bm() {
        int i = eiG;
        eiG = i + 1;
        return i;
    }

    static /* synthetic */ int Lq() {
        int i = eiG;
        eiG = i - 1;
        return i;
    }

    static /* synthetic */ void Vn() {
        long Ni = be.Ni();
        ak.yW();
        com.tencent.mm.model.c.wB();
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        String stringBuilder2 = stringBuilder.append(com.tencent.mm.model.c.xn()).append(".tem").toString();
        ak.yW();
        j.n(stringBuilder2, com.tencent.mm.model.c.xn(), false);
        stringBuilder = new StringBuilder();
        ak.yW();
        stringBuilder2 = stringBuilder.append(com.tencent.mm.model.c.xo()).append(".tem").toString();
        ak.yW();
        j.n(stringBuilder2, com.tencent.mm.model.c.xo(), false);
        com.tencent.mm.kernel.a.uD();
        com.tencent.mm.kernel.a.uO();
        Vi();
        yV();
        v.i("MicroMsg.BackupCore", "recoverFromTempDBImp finish :%d", Long.valueOf(be.ay(Ni)));
    }

    static /* synthetic */ boolean a(PLong pLong, PLong pLong2, PLong pLong3, a aVar) {
        ak.yW();
        com.tencent.mm.model.c.wB();
        v.d("MicroMsg.BackupCore", "initTempDBimp after close db");
        ak.yW();
        int aQ = e.aQ(com.tencent.mm.model.c.xn());
        ak.yW();
        pLong3.value = (long) (aQ + e.aQ(com.tencent.mm.model.c.xo()));
        long j = pLong3.value;
        ak.yW();
        if (g.a(j, pLong, pLong2, com.tencent.mm.model.c.xq())) {
            ak.yW();
            String xn = com.tencent.mm.model.c.xn();
            StringBuilder stringBuilder = new StringBuilder();
            ak.yW();
            j.n(xn, stringBuilder.append(com.tencent.mm.model.c.xn()).append(".tem").toString(), false);
            ak.yW();
            xn = com.tencent.mm.model.c.xo();
            stringBuilder = new StringBuilder();
            ak.yW();
            j.n(xn, stringBuilder.append(com.tencent.mm.model.c.xo()).append(".tem").toString(), false);
            v.i("MicroMsg.BackupCore", "initTempDBimp before resetAccUin");
            com.tencent.mm.kernel.a.uD();
            com.tencent.mm.kernel.a.uO();
            v.i("MicroMsg.BackupCore", "initTempDBimp before closeDB");
            Vd().wB();
            v.i("MicroMsg.BackupCore", "initTempDBimp before TemAccStg setAccInfo");
            z Vd = Vd();
            ak.yW();
            String xq = com.tencent.mm.model.c.xq();
            ak.yW();
            String xp = com.tencent.mm.model.c.xp();
            ak.yW();
            v.i("MicroMsg.TempStorage", "accPath %s, cachePath %s, accUin:%d", xq, xp, Integer.valueOf(com.tencent.mm.model.c.ww()));
            Vd.uin = r3;
            Vd.cka = xq;
            Vd.cachePath = xp;
            v.i("MicroMsg.BackupCore", "initTempDBimp before TemAccStg initDB");
            z Vd2 = Vd();
            StringBuilder stringBuilder2 = new StringBuilder();
            ak.yW();
            xq = stringBuilder2.append(com.tencent.mm.model.c.xn()).append(".tem").toString();
            ak.yW();
            int ww = com.tencent.mm.model.c.ww();
            stringBuilder2 = new StringBuilder();
            ak.yW();
            xp = stringBuilder2.append(com.tencent.mm.model.c.xo()).append(".tem").toString();
            Vd2.ckb = new com.tencent.mm.bg.g(new com.tencent.mm.bg.g.a(Vd2) {
                final /* synthetic */ z ekn;

                {
                    this.ekn = r1;
                }

                public final void vl() {
                    if (this.ekn.ekm != null) {
                        f fVar = this.ekn.ekm;
                        for (Object obj : fVar.nxH.keySet()) {
                            ((com.tencent.mm.bg.h) fVar.nxH.get(obj)).bxZ();
                        }
                    }
                }

                public final void vm() {
                }

                public final void vn() {
                    if (this.ekn.ekm != null) {
                        f fVar = this.ekn.ekm;
                        if (fVar.nxI.size() != 0) {
                            v.i("MicroMsg.MemoryStorage", "attachTable begin stg:%s size:%d", "stg_null", Integer.valueOf(fVar.nxI.size()));
                            if (fVar.nxs == null) {
                                v.e("MicroMsg.MemoryStorage", "attachTable db is null");
                            } else if (fVar.nxF.inTransaction()) {
                                v.w("MicroMsg.MemoryStorage", "attachTable is in transcation ,give up attach table size:%d", Integer.valueOf(fVar.nxI.size()));
                            } else {
                                while (fVar.nxI.size() > 0) {
                                    if (fVar.nxF.inTransaction()) {
                                        v.w("MicroMsg.MemoryStorage", "attachTable is in transcation , break attach table size:%d", Integer.valueOf(fVar.nxI.size()));
                                        return;
                                    }
                                    a aVar = (a) fVar.nxI.peek();
                                    if (aVar == null) {
                                        fVar.nxI.poll();
                                    } else {
                                        String tableName = aVar.getTableName();
                                        if (be.kS(tableName)) {
                                            v.e("MicroMsg.MemoryStorage", "attachTable Error table Name :%s", tableName);
                                            fVar.nxI.poll();
                                        } else if (com.tencent.mm.bg.e.a(fVar.nxs, tableName)) {
                                            v.e("MicroMsg.MemoryStorage", "attachTable Error Attach table twice :%s", tableName);
                                            fVar.nxI.poll();
                                        } else {
                                            if (fVar.NO(tableName) != 0) {
                                                try {
                                                    if (fVar.lAZ) {
                                                        fVar.nxs.execSQL("DETACH DATABASE old");
                                                        v.i("MicroMsg.MemoryStorage", "DETACH DATABASE ");
                                                        fVar.lAZ = false;
                                                    }
                                                    if (be.kS(fVar.nxF.getKey())) {
                                                        fVar.nxs.execSQL("ATTACH DATABASE '" + fVar.nxF.getPath() + "' AS old ");
                                                    } else {
                                                        fVar.nxs.execSQL("ATTACH DATABASE '" + fVar.nxF.getPath() + "' AS old KEY '" + fVar.nxF.getKey() + "'");
                                                    }
                                                    v.i("MicroMsg.MemoryStorage", "ATTACH DATABASE ");
                                                    fVar.lAZ = true;
                                                } catch (Throwable e) {
                                                    fVar.lAZ = false;
                                                    v.e("MicroMsg.MemoryStorage", "ERROR : attach disk db [%s] , will do again !", e.getMessage());
                                                    v.e("MicroMsg.MemoryStorage", "exception:%s", be.e(e));
                                                }
                                                if (fVar.NO(tableName) != 0) {
                                                    v.e("MicroMsg.MemoryStorage", "copy table failed :" + tableName);
                                                    return;
                                                }
                                            }
                                            v.i("MicroMsg.MemoryStorage", "attachTable %s succ , waitsize:%d finsize:%d", tableName, Integer.valueOf(fVar.nxI.size()), Integer.valueOf(fVar.nxH.size()));
                                            fVar.nxH.put(tableName, new com.tencent.mm.bg.h(fVar.nxF, tableName));
                                            aVar.a(fVar);
                                            fVar.nxI.poll();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            });
            if (Vd2.ckb.a(xq, xp, SQLiteDatabase.KeyEmpty, (long) ww, p.rJ(), new HashMap(), false)) {
                Vd2.ckd = new r(Vd2.ckb);
                Vd2.ejZ = new com.tencent.mm.storage.aa(Vd2.ckb);
                Vd2.ekb = new com.tencent.mm.storage.ac(Vd2.ckb);
                Vd2.eka = new au(Vd2.ckb, Vd2.ejZ, Vd2.ekb);
                Vd2.eka.a(new aj(Vd2.eka));
                Vd2.eka.a(new com.tencent.mm.storage.m(Vd2.eka));
                Vd2.eke = new ay(Vd2.ckb);
                Vd2.ekc = new com.tencent.mm.ae.f(Vd2.ckb);
                if (com.tencent.mm.ay.c.EH("emoji")) {
                    Vd2.ekd = new com.tencent.mm.storage.a.f(Vd2.ckb);
                }
                Vd2.crb = new com.tencent.mm.storage.p(Vd2.ckb);
                Vd2.ekg = new com.tencent.mm.u.g(Vd2.ckb);
                Vd2.djz = new u(Vd2.ckb);
                Vd2.dht = new o(Vd2.ckb);
                Vd2.ekf = new com.tencent.mm.ar.m(Vd2.ckb);
                Vd2.ekh = new l(Vd2.ckb);
                Vd2.eki = new n(Vd2.ckb);
                Vd2.cUy = new com.tencent.mm.al.b(Vd2.ckb);
                Vd2.ekj = new k(Vd2.ckb);
                Vd2.ekk = new com.tencent.mm.pluginsdk.model.app.i(Vd2.ckb);
                Vd2.ekl = new com.tencent.mm.pluginsdk.model.app.c(Vd2.ckb);
                Vd2.cDi = new com.tencent.mm.modelbiz.d(Vd2.ckb);
                Vd2.cke = new az(Vd2.ckd);
                Vd2.cke.c(new com.tencent.mm.sdk.h.g.a(Vd2) {
                    final /* synthetic */ z ekn;

                    {
                        this.ekn = r1;
                    }

                    public final void a(String str, com.tencent.mm.sdk.h.i iVar) {
                        p.dr(str);
                    }
                });
                Vd2.cke.bxg();
                v.i("MicroMsg.BackupCore", "initTempDBimp after TemAccStg initDB");
                yV();
                aVar.eiS = true;
                aVar.eiT = pLong.value;
                aVar.eiU = pLong2.value;
                aVar.dbSize = pLong3.value;
                xn = Vj();
                File file = new File(xn);
                if (!file.exists()) {
                    file.mkdirs();
                }
                file = new File(xn + "mmbakItem/");
                if (!file.exists()) {
                    file.mkdirs();
                }
                file = new File(xn + "mmbakMeida/");
                if (!file.exists()) {
                    file.mkdirs();
                }
                return true;
            }
            throw new com.tencent.mm.model.b((byte) 0);
        }
        v.e("MicroMsg.BackupCore", "data free error, len %d", Long.valueOf(pLong3.value));
        aVar.eiS = false;
        aVar.eiT = pLong.value;
        aVar.eiU = pLong2.value;
        aVar.dbSize = pLong3.value;
        return false;
    }

    static {
        v.i("MicroMsg.BackupEventListener", "init addListener");
        com.tencent.mm.sdk.c.a.nhr.e(new com.tencent.mm.sdk.c.c<com.tencent.mm.e.a.u>() {
            {
                this.nhz = com.tencent.mm.e.a.u.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                b.reset();
                return false;
            }
        });
        com.tencent.mm.sdk.c.a.nhr.e(new com.tencent.mm.sdk.c.c<com.tencent.mm.e.a.v>() {
            {
                this.nhz = com.tencent.mm.e.a.v.class.getName().hashCode();
            }

            private static boolean a(com.tencent.mm.e.a.v vVar) {
                com.tencent.mm.plugin.backup.backuppcmodel.a UL = b.UL();
                int i = vVar.aXi.aXj ? 14 : 15;
                com.tencent.mm.plugin.backup.d.u uVar = new com.tencent.mm.plugin.backup.d.u();
                uVar.eev = i;
                try {
                    String str;
                    String str2 = "MicroMsg.BackupPcProcessMgr";
                    String str3 = "sendNormalReq cmd :%d (%s)";
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(i);
                    switch (i) {
                        case 15:
                            str = "EXIT";
                            break;
                        default:
                            str = "LOGOFF";
                            break;
                    }
                    objArr[1] = str;
                    v.i(str2, str3, objArr);
                    com.tencent.mm.plugin.backup.b.b.r(uVar.toByteArray(), 3);
                } catch (Throwable e) {
                    v.a("MicroMsg.BackupPcProcessMgr", e, "buf to PacketCommandRequest err", new Object[0]);
                }
                new ac(Looper.getMainLooper()).postDelayed(new Runnable(UL) {
                    final /* synthetic */ a ebE;

                    {
                        this.ebE = r1;
                    }

                    public final void run() {
                        com.tencent.mm.plugin.backup.g.b.UP().stop();
                    }
                }, 100);
                return false;
            }
        });
        com.tencent.mm.sdk.c.a.nhr.e(new com.tencent.mm.sdk.c.c<bj>() {
            {
                this.nhz = bj.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                bj bjVar = (bj) bVar;
                bjVar.aYR.aYS = new com.tencent.mm.plugin.backup.backuppcui.a(bjVar.aYQ.context);
                return false;
            }
        });
    }

    public static d UJ() {
        if (Vc().eit == null) {
            Vc().eit = new d();
        }
        return Vc().eit;
    }

    public static com.tencent.mm.plugin.backup.bakpcmodel.c UK() {
        if (Vc().eiu == null) {
            Vc().eiu = new com.tencent.mm.plugin.backup.bakpcmodel.c();
        }
        return Vc().eiu;
    }

    public static com.tencent.mm.plugin.backup.backuppcmodel.a UL() {
        if (Vc().eiv == null) {
            Vc().eiv = new com.tencent.mm.plugin.backup.backuppcmodel.a();
        }
        return Vc().eiv;
    }

    public static com.tencent.mm.plugin.backup.backuppcmodel.c UM() {
        if (Vc().eiw == null) {
            Vc().eiw = new com.tencent.mm.plugin.backup.backuppcmodel.c();
        }
        return Vc().eiw;
    }

    public static com.tencent.mm.plugin.backup.backuppcmodel.b UN() {
        if (Vc().eix == null) {
            Vc().eix = new com.tencent.mm.plugin.backup.backuppcmodel.b();
        }
        return Vc().eix;
    }

    public static com.tencent.mm.plugin.backup.bakpcmodel.a UO() {
        if (Vc().eiy == null) {
            Vc().eiy = new com.tencent.mm.plugin.backup.bakpcmodel.a();
        }
        return Vc().eiy;
    }

    public static com.tencent.mm.plugin.backup.backupmodel.a UP() {
        if (Vc().eiz == null) {
            Vc().eiz = new com.tencent.mm.plugin.backup.backupmodel.a();
        }
        return Vc().eiz;
    }

    public static h UQ() {
        if (Vc().eiA == null) {
            Vc().eiA = new h();
        }
        return Vc().eiA;
    }

    public static g UR() {
        if (Vc().eiB == null) {
            Vc().eiB = new g();
        }
        return Vc().eiB;
    }

    public static c US() {
        if (Vc().eiC == null) {
            Vc().eiC = new c();
        }
        return Vc().eiC;
    }

    public static i UT() {
        if (Vc().eiD == null) {
            Vc().eiD = new i();
        }
        return Vc().eiD;
    }

    public static SharedPreferences UU() {
        Vc();
        if (eiE == null) {
            eiE = aa.getContext().getSharedPreferences("BACKUP_CONFIG", 4);
        }
        Vc();
        return eiE;
    }

    public static byte[] UV() {
        return Vc().ein;
    }

    public static void O(byte[] bArr) {
        Vc().ein = bArr;
    }

    public static String UW() {
        return Vc().eiq;
    }

    public static void oV(String str) {
        Vc().eiq = str;
    }

    public static byte[] UX() {
        return Vc().eir;
    }

    public static void P(byte[] bArr) {
        Vc().eir = bArr;
    }

    public static byte[] UY() {
        return Vc().eis;
    }

    public static void Q(byte[] bArr) {
        Vc().eis = bArr;
    }

    public static String UZ() {
        return Vc().eio;
    }

    public static void oW(String str) {
        Vc().eio = str;
    }

    public static String Va() {
        return Vc().eip;
    }

    public static void oX(String str) {
        Vc().eip = str;
    }

    public static String Vb() {
        return Vc().edV;
    }

    public static void oY(String str) {
        Vc().edV = str;
    }

    public b() {
        v.i("MicroMsg.BackupCore", "BackupCore init");
        com.tencent.mm.sdk.i.e.c(new Runnable(this) {
            final /* synthetic */ b eiJ;

            {
                this.eiJ = r1;
            }

            public final void run() {
                Looper.prepare();
                this.eiJ.eil = new ac();
                Looper.loop();
            }
        }, "BackupCore_parpareInUI").start();
    }

    public static boolean isValid() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() != 0) {
            return true;
        }
        throw new com.tencent.mm.model.b();
    }

    public static b Vc() {
        if (eie == null) {
            eie = new b();
        }
        return eie;
    }

    public static z Vd() {
        if (Vc().eik == null) {
            Vc().eik = new z();
        }
        return Vc().eik;
    }

    public static e Ve() {
        if (Vc().eif == null) {
            Vc().eif = new e();
        }
        return Vc().eif;
    }

    public static x Vf() {
        if (Vc().eig == null) {
            Vc().eig = new x();
        }
        return Vc().eig;
    }

    private static n Vg() {
        if (Vc().eih == null) {
            Vc().eih = new n();
        }
        return Vc().eih;
    }

    public static l if(int i) {
        if (Vc().eiF == null) {
            b Vc = Vc();
            Vc.eiF = new HashMap();
            Vc.eiF.put(Integer.valueOf(3), new q());
            Vc.eiF.put(Integer.valueOf(47), new o());
            Vc.eiF.put(Integer.valueOf(49), new p());
            Vc.eiF.put(Integer.valueOf(34), new t());
            s sVar = new s();
            Vc.eiF.put(Integer.valueOf(43), sVar);
            Vc.eiF.put(Integer.valueOf(44), sVar);
            Vc.eiF.put(Integer.valueOf(62), sVar);
            r rVar = new r();
            Vc.eiF.put(Integer.valueOf(48), rVar);
            Vc.eiF.put(Integer.valueOf(42), rVar);
            Vc.eiF.put(Integer.valueOf(10000), rVar);
            Vc.eiF.put(Integer.valueOf(1), rVar);
            Vc.eiF.put(Integer.valueOf(37), rVar);
            Vc.eiF.put(Integer.valueOf(40), rVar);
            Vc.eiF.put(Integer.valueOf(50), rVar);
        }
        return (l) Vc().eiF.get(Integer.valueOf(i));
    }

    public static com.tencent.mm.plugin.backup.f.f oZ(String str) {
        if (Vc().eii == null) {
            Vc().eii = new k();
        }
        k kVar = Vc().eii;
        if (kVar.ejB == null) {
            kVar.VV();
        }
        for (com.tencent.mm.plugin.backup.f.f fVar : kVar.ejB.values()) {
            if (fVar.ehJ != null && fVar.ehJ.equals(str)) {
                return fVar;
            }
        }
        return null;
    }

    public static com.tencent.mm.plugin.backup.f.f pa(String str) {
        if (Vc().eii == null) {
            Vc().eii = new k();
        }
        k kVar = Vc().eii;
        if (kVar.ejB == null) {
            kVar.VV();
        }
        return (com.tencent.mm.plugin.backup.f.f) kVar.ejB.get(str);
    }

    public static v Vh() {
        if (Vc().eij == null) {
            Vc().eij = new v();
        }
        return Vc().eij;
    }

    public static void a(final a aVar, boolean z) {
        final long Ni = be.Ni();
        v.i("MicroMsg.BackupCore", "initTempDB needSyncPauser:%b %s", Boolean.valueOf(z), be.bur());
        ad.g(new Runnable() {
            public final void run() {
                b.isValid();
                v.i("MicroMsg.BackupCore", "initTempDB, initTempDBCount:%d  timediff:%d ", Integer.valueOf(b.eiG), Long.valueOf(be.ay(Ni)));
                b.Bm();
                ak.vA().a(new com.tencent.mm.sdk.platformtools.ad.a(this) {
                    final /* synthetic */ AnonymousClass2 eiL;

                    {
                        this.eiL = r1;
                    }

                    public final boolean Ba() {
                        v.i("MicroMsg.BackupCore", "initTempDB onPostExecute");
                        aVar.run();
                        b.Lq();
                        return false;
                    }

                    public final boolean AZ() {
                        b.Vi();
                        b.a(new PLong(), new PLong(), new PLong(), aVar);
                        return true;
                    }

                    public final String toString() {
                        return super.toString() + "|initTempDB";
                    }
                });
            }
        }, 1000);
    }

    private static void yV() {
        com.tencent.mm.sdk.c.a.nhr.z(new w());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(final java.lang.Runnable r4, final int r5) {
        /*
        r0 = 1;
        r1 = 0;
        r2 = Ve();
        r2.bR(r1);
        r2 = Vf();
        r2.bR(r1);
        r2 = Vg();
        r2.cancel();
        if (r5 < 0) goto L_0x0065;
    L_0x0019:
        r2 = Ve();
        r3 = r2.eiX;
        r3 = r3.VJ();
        if (r3 == 0) goto L_0x008f;
    L_0x0025:
        r3 = r2.eiW;
        if (r3 == 0) goto L_0x0031;
    L_0x0029:
        r2 = r2.eiW;
        r2 = r2.isAlive();
        if (r2 != 0) goto L_0x008f;
    L_0x0031:
        r2 = r0;
    L_0x0032:
        if (r2 == 0) goto L_0x0095;
    L_0x0034:
        r2 = Vf();
        r3 = r2.ejQ;
        r3 = r3.VJ();
        if (r3 == 0) goto L_0x0091;
    L_0x0040:
        r3 = r2.eiW;
        if (r3 == 0) goto L_0x004c;
    L_0x0044:
        r2 = r2.eiW;
        r2 = r2.isAlive();
        if (r2 != 0) goto L_0x0091;
    L_0x004c:
        r2 = r0;
    L_0x004d:
        if (r2 == 0) goto L_0x0095;
    L_0x004f:
        r2 = Vg();
        r3 = r2.beg;
        if (r3 == 0) goto L_0x0093;
    L_0x0057:
        r2 = r2.ejG;
        r2 = r2.isEmpty();
        if (r2 == 0) goto L_0x0093;
    L_0x005f:
        if (r0 == 0) goto L_0x0095;
    L_0x0061:
        r0 = eiG;
        if (r0 != 0) goto L_0x0095;
    L_0x0065:
        if (r5 >= 0) goto L_0x0070;
    L_0x0067:
        r0 = "MicroMsg.BackupCore";
        r1 = "closeTempDB no left tryCount!!";
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
    L_0x0070:
        r0 = "MicroMsg.BackupCore";
        r1 = "closeDB before";
        com.tencent.mm.sdk.platformtools.v.i(r0, r1);
        r0 = Vd();
        r0.wB();
        r0 = "MicroMsg.BackupCore";
        r1 = "closeDB after";
        com.tencent.mm.sdk.platformtools.v.i(r0, r1);
        if (r4 == 0) goto L_0x008e;
    L_0x008b:
        r4.run();
    L_0x008e:
        return;
    L_0x008f:
        r2 = r1;
        goto L_0x0032;
    L_0x0091:
        r2 = r1;
        goto L_0x004d;
    L_0x0093:
        r0 = r1;
        goto L_0x005f;
    L_0x0095:
        r0 = new com.tencent.mm.sdk.platformtools.ac;
        r1 = android.os.Looper.getMainLooper();
        r0.<init>(r1);
        r1 = new com.tencent.mm.plugin.backup.g.b$3;
        r1.<init>(r4, r5);
        r2 = 50;
        r0.postDelayed(r1, r2);
        goto L_0x008e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.g.b.a(java.lang.Runnable, int):void");
    }

    public static void h(final Runnable runnable) {
        a(new Runnable() {
            public final void run() {
                v.i("MicroMsg.BackupCore", "recoverFromTempDB closeTempDB ok");
                v.bta();
                ak.vA().a(new com.tencent.mm.sdk.platformtools.ad.a(this) {
                    final /* synthetic */ AnonymousClass4 eiP;

                    {
                        this.eiP = r1;
                    }

                    public final boolean Ba() {
                        runnable.run();
                        com.tencent.mm.sdk.c.a.nhr.z(new nc());
                        return false;
                    }

                    public final boolean AZ() {
                        v.i("MicroMsg.BackupCore", "doInBackground start");
                        v.bta();
                        b.Vn();
                        e.e(new File(b.Vj()));
                        v Vh = b.Vh();
                        Vh.handler.post(new Runnable(Vh) {
                            final /* synthetic */ v ejO;

                            {
                                this.ejO = r1;
                            }

                            public final void run() {
                                Iterator it = this.ejO.ejM.iterator();
                                while (it.hasNext()) {
                                    a aVar = (a) it.next();
                                    if (aVar.type == 2 && aVar.obj != null && (aVar.obj instanceof String)) {
                                        String str = (String) aVar.obj;
                                        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.RecoverDelayData", "getContact" + str);
                                        com.tencent.mm.model.ab.a.crZ.I(str, SQLiteDatabase.KeyEmpty);
                                    } else if (aVar.type == 1 && aVar.obj != null && (aVar.obj instanceof String)) {
                                        am.bnA().Gx((String) aVar.obj);
                                    }
                                }
                                this.ejO.ejM.clear();
                            }
                        });
                        v.i("MicroMsg.BackupCore", "doInBackground end");
                        v.bta();
                        return true;
                    }

                    public final String toString() {
                        return super.toString() + "|recoverFromTempDB";
                    }
                });
            }
        }, 100);
    }

    public static void i(final Runnable runnable) {
        a(new Runnable() {
            public final void run() {
                v.i("MicroMsg.BackupCore", "backupFromTempDB closeTempDB ok");
                v.bta();
                ak.vA().a(new com.tencent.mm.sdk.platformtools.ad.a(this) {
                    final /* synthetic */ AnonymousClass5 eiR;

                    {
                        this.eiR = r1;
                    }

                    public final boolean Ba() {
                        runnable.run();
                        return false;
                    }

                    public final boolean AZ() {
                        v.i("MicroMsg.BackupCore", "doInBackground.");
                        b.Vi();
                        return true;
                    }

                    public final String toString() {
                        return super.toString() + "|backupcloseTempDB";
                    }
                });
            }
        }, 100);
    }

    public static void Vi() {
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        com.tencent.mm.loader.stub.b.deleteFile(stringBuilder.append(com.tencent.mm.model.c.xn()).append(".tem").toString());
        stringBuilder = new StringBuilder();
        ak.yW();
        com.tencent.mm.loader.stub.b.deleteFile(stringBuilder.append(com.tencent.mm.model.c.xn()).append(".ini.tem").toString());
        stringBuilder = new StringBuilder();
        ak.yW();
        com.tencent.mm.loader.stub.b.deleteFile(stringBuilder.append(com.tencent.mm.model.c.xo()).append(".tem").toString());
        stringBuilder = new StringBuilder();
        ak.yW();
        com.tencent.mm.loader.stub.b.deleteFile(stringBuilder.append(com.tencent.mm.model.c.xo()).append(".ini.tem").toString());
    }

    public static String Vj() {
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        return stringBuilder.append(com.tencent.mm.model.c.xq()).append("backup/").toString();
    }

    public static String Vk() {
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        return stringBuilder.append(com.tencent.mm.model.c.xq()).append("backupReport/").toString();
    }

    public static com.tencent.mm.v.n vy() {
        return ak.vy();
    }

    public static byte[] Vl() {
        int i = -1;
        if (Vc().eim == null) {
            Vc().eim = e.d(Vj() + "mmbakinfo.ini", 0, -1);
        }
        String str = "MicroMsg.BackupCore";
        String str2 = "summerbak getPwd len[%d], stack[%s]";
        Object[] objArr = new Object[2];
        if (Vc().eim != null) {
            i = Vc().eim.length;
        }
        objArr[0] = Integer.valueOf(i);
        objArr[1] = be.bur();
        v.i(str, str2, objArr);
        return Vc().eim;
    }

    public static void Vm() {
        v.i("MicroMsg.BackupCore", "holdReset");
        cjj = true;
    }

    public static void reset() {
        if (cjj) {
            eiH = true;
            return;
        }
        if (!(eie == null || eie.eif == null)) {
            eie.eif.bR(false);
        }
        if (!(eie == null || eie.eig == null)) {
            eie.eig.bR(false);
        }
        if (!(eie == null || eie.eih == null)) {
            eie.eih.cancel();
        }
        eie = null;
    }

    public final HashMap<Integer, com.tencent.mm.bg.g.c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        ak.yU().a("MMBakChatNotify", this.eiI, true);
    }

    public final void aH(boolean z) {
    }

    public final void th() {
        ak.yU().b("MMBakChatNotify", this.eiI, true);
    }
}
