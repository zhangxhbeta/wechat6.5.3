package com.tencent.mm.plugin.backup.bakpcmodel;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.e.a.jq;
import com.tencent.mm.e.b.af;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.backup.b.b;
import com.tencent.mm.plugin.backup.d.l;
import com.tencent.mm.plugin.backup.d.m;
import com.tencent.mm.plugin.backup.d.u;
import com.tencent.mm.plugin.backup.e.a;
import com.tencent.mm.plugin.backup.g.f;
import com.tencent.mm.plugin.backup.h.h;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.n;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.List;

public final class c implements com.tencent.mm.plugin.backup.b.b.d, com.tencent.mm.plugin.backup.movemodel.b.a {
    public String eaU;
    public String eaV;
    private d efS;
    public c ega;
    public a egb;
    public e egc;
    public b egd = new b();
    public e ege = new e();
    h egf;
    private com.tencent.mm.plugin.backup.movemodel.b egg;
    public int egh = -1;
    private String egi = SQLiteDatabase.KeyEmpty;
    public int egj = d.egy;
    public int egk = d.egr;
    private boolean egl = false;

    public interface b {
        void onError(int i);
    }

    class AnonymousClass3 implements com.tencent.mm.v.e {
        final /* synthetic */ c egm;
        final /* synthetic */ Runnable egp;
        final /* synthetic */ Runnable egq;

        AnonymousClass3(c cVar, Runnable runnable, Runnable runnable2) {
            this.egm = cVar;
            this.egp = runnable;
            this.egq = runnable2;
        }

        public final void a(int i, int i2, String str, k kVar) {
            if (kVar != this.egm.egf) {
                v.w("MicroMsg.BakPcProcessMgr", "last canceded scene");
                return;
            }
            if (i == 0 && i2 == 0) {
                v.i("MicroMsg.BakPcProcessMgr", "getPcPwd OK");
                com.tencent.mm.plugin.backup.g.b.P(((h) kVar).emD);
                this.egp.run();
            } else {
                this.egm.D(10010, new String("getPcPwd Fail"));
                v.i("MicroMsg.BakPcProcessMgr", "getPcPwd Fail");
                this.egq.run();
            }
            ak.vy().b(596, (com.tencent.mm.v.e) this);
        }
    }

    public interface a extends b {
        void UA();
    }

    public interface c extends b {
        void hZ(int i);

        void ia(int i);
    }

    public interface d extends b {
        void UB();

        void UC();

        void UD();

        void ib(int i);

        void ic(int i);

        void id(int i);
    }

    public interface e extends b {
        void UE();
    }

    public final void aX(String str, String str2) {
        this.eaU = str;
        this.eaV = str2;
    }

    public final synchronized void bQ(boolean z) {
        this.egl = z;
    }

    public final synchronized boolean Uv() {
        return this.egl;
    }

    public final synchronized void Uw() {
        this.efS = null;
        this.egd.efS = null;
        this.ege.efS = null;
    }

    public final synchronized void a(d dVar) {
        if (dVar == null) {
            if (this.efS instanceof com.tencent.mm.plugin.backup.j.a) {
                v.d("MicroMsg.BakPcProcessMgr", "setOperatorCallbck BakchatBannerView null ilegal, fking return");
            }
        }
        v.d("MicroMsg.BakPcProcessMgr", "setOperatorCallbck:%s", dVar);
        this.efS = dVar;
        this.egd.efS = dVar;
        this.ege.efS = dVar;
    }

    public final void TW() {
        if (this.ege.egK) {
            e eVar = this.ege;
            v.i("MicroMsg.RecoverPCServer", "startMerge");
            if (eVar.egL) {
                v.i("MicroMsg.RecoverPCServer", "hasStartMerge , return");
                return;
            }
            eVar.efY = 0;
            com.tencent.mm.plugin.backup.g.b.UK().egk = d.egw;
            eVar.egL = true;
            com.tencent.mm.plugin.backup.g.b.a(new com.tencent.mm.plugin.backup.g.b.a(eVar) {
                final /* synthetic */ e egP;

                {
                    this.egP = r1;
                }

                public final void run() {
                    e eVar = this.egP;
                    int X = e.X(eVar.egH);
                    v.i("MicroMsg.RecoverPCServer", "all msg item Count : " + X);
                    f.aF(be.Nj());
                    System.currentTimeMillis();
                    v.d("MicroMsg.RecoverPCServer", "readFromSdcard start");
                    com.tencent.mm.sdk.i.e.d(new AnonymousClass5(eVar, X), "RecoverPCServer_recoverFromSdcard", 1).start();
                }
            }, false);
            return;
        }
        v.e("MicroMsg.BakPcProcessMgr", "startMerge err state");
    }

    public final void pause() {
        if (this.egh == 1) {
            this.egd.pause();
        } else if (this.egh == 6) {
            this.ege.pause();
        }
    }

    final synchronized void D(int i, String str) {
        v.e("MicroMsg.BakPcProcessMgr", "callbackErr type:%d,  %s", Integer.valueOf(i), str);
        if (i == 10006 || i == 10008) {
            v.e("MicroMsg.BakPcProcessMgr", "callbackErr socketClose");
            this.egj = d.egy;
            this.egk = d.egr;
            Uz();
            com.tencent.mm.plugin.backup.g.b.UO().efK = 2;
            com.tencent.mm.plugin.backup.g.b.UO().zR();
            if (this.ega != null) {
                this.ega.onError(i);
            }
            if (this.egb != null) {
                this.egb.onError(i);
            }
            if (this.efS != null) {
                this.efS.onError(i);
            }
            if (this.egc != null) {
                this.egc.onError(i);
            }
        }
        if (i == 10009 || i == 10004) {
            v.e("MicroMsg.BakPcProcessMgr", "callbackErr ip not match or connect failed: %d", Integer.valueOf(i));
            com.tencent.mm.plugin.backup.g.b.UO().efK = 2;
            com.tencent.mm.plugin.backup.g.b.UO().zR();
            Ux();
        } else {
            v.d("MicroMsg.BakPcProcessMgr", "summerbak errtype:%d, authcallback[%s], operatorcallback[%s], eventCallback[%s]", Integer.valueOf(i), this.egb, this.efS, this.ega);
            if (i == 15) {
                if (this.egb != null) {
                    this.egb.onError(i);
                }
                if (this.efS != null) {
                    this.efS.onError(i);
                }
                if (this.ega != null) {
                    this.ega.ia(i);
                }
            }
            if (i == -1) {
                if (this.egb != null) {
                    this.egb.onError(i);
                } else if (this.efS != null) {
                    this.efS.onError(i);
                } else if (this.ega != null) {
                    this.ega.ia(i);
                }
            }
        }
    }

    public final void a(boolean z, int i, byte[] bArr, int i2) {
        if (z && bArr != null) {
            D(i, new String(bArr));
        }
        if (i == CdnLogic.MediaType_FAVORITE_FILE || i == CdnLogic.MediaType_FAVORITE_VIDEO) {
            com.tencent.mm.plugin.backup.g.b.UO().efK = 1;
            new com.tencent.mm.plugin.backup.b.a(com.tencent.mm.plugin.backup.g.b.Va(), com.tencent.mm.plugin.backup.g.b.Vb(), com.tencent.mm.plugin.backup.g.b.UV(), com.tencent.mm.plugin.backup.g.b.UZ(), com.tencent.mm.plugin.backup.movemodel.d.ekQ).Uh();
        }
        if (i == 3) {
            this.egh = -1;
            u uVar = new u();
            try {
                uVar.az(bArr);
                v.i("MicroMsg.BakPcProcessMgr", "recv cmd:%d (%s)", Integer.valueOf(uVar.eev), hY(uVar.eev));
                switch (uVar.eev) {
                    case 0:
                        if (ak.uz()) {
                            this.egh = uVar.eev;
                            if (this.egb != null) {
                                this.egb.UA();
                            } else {
                                v.i("MicroMsg.BakPcProcessMgr", "authCallback is null");
                                Intent className = new Intent().setClassName(aa.getContext(), "com.tencent.mm.ui.LauncherUI");
                                className.addFlags(335544320);
                                className.putExtra("nofification_type", "back_to_pcmgr_notification");
                                className.putExtra("newPCBackup", false);
                                aa.getContext().startActivity(className);
                            }
                            this.egj = d.egz;
                            this.egk = d.egr;
                            return;
                        }
                        v.w("MicroMsg.BakPcProcessMgr", "acc is not ready, not support pcmgr's auth");
                        a(uVar.eev, 1, null);
                        return;
                    case 1:
                        com.tencent.mm.plugin.backup.g.b.UJ().Tz();
                        com.tencent.mm.plugin.backup.g.b.UO().zR();
                        D(-1, null);
                        v.e("MicroMsg.BakPcProcessMgr", "summerback new version not support old pc backup request toast upgrade pc");
                        return;
                    case 3:
                        this.egk = d.egs;
                        this.egj = d.egC;
                        Uz();
                        a(uVar.eev, 0, null);
                        com.tencent.mm.sdk.i.e.c(new Runnable(this.egd) {
                            final /* synthetic */ b efZ;

                            {
                                this.efZ = r1;
                            }

                            public final void run() {
                                b bVar = this.efZ;
                                bVar.efY = 0;
                                bVar.efT = new e(bVar) {
                                    final /* synthetic */ b efZ;

                                    {
                                        this.efZ = r1;
                                    }

                                    public final void a(int i, int i2, String str, k kVar) {
                                        v.i("MicroMsg.BakPCServer", "onSceneEnd %s, %d, %d", ((com.tencent.mm.plugin.backup.e.b) kVar).eda.efo, Integer.valueOf(i), Integer.valueOf(i2));
                                        synchronized (this.efZ.lock) {
                                            this.efZ.efR.remove(r14.eda.efo);
                                            v.i("MicroMsg.BakPCServer", "onSceneEnd left: size:%d", Integer.valueOf(this.efZ.efR.size()));
                                            if (this.efZ.efR.size() <= 10) {
                                                this.efZ.lock.notifyAll();
                                            }
                                        }
                                        b bVar = this.efZ;
                                        bVar.efY++;
                                        if (this.efZ.efY % 100 == 0) {
                                            bVar = this.efZ;
                                            System.gc();
                                            long freeMemory = Runtime.getRuntime().freeMemory() / 1000;
                                            long totalMemory = Runtime.getRuntime().totalMemory() / 1000;
                                            v.i("MicroMsg.BakPCServer", "memoryInfo avail/total, dalvik[%dk, %dk, user:%dk], recoverCnt:%d", Long.valueOf(freeMemory), Long.valueOf(totalMemory), Long.valueOf(totalMemory - freeMemory), Integer.valueOf(bVar.efY));
                                        }
                                        this.efZ.Uu();
                                    }
                                };
                                com.tencent.mm.plugin.backup.b.b.a(5, bVar.efT);
                                String str = (String) com.tencent.mm.plugin.backup.g.b.Vd().vf().get(2, null);
                                for (String str2 : bVar.efQ) {
                                    af Mh = com.tencent.mm.plugin.backup.g.b.Vd().wK().Mh(str2);
                                    v.i("MicroMsg.BakPCServer", "backupImp username:%s, unReadCount:%d", str2, Integer.valueOf(Mh != null ? Mh.field_unReadCount : 0));
                                    if (!bVar.j(str2, str, Mh != null ? Mh.field_unReadCount : 0)) {
                                        v.i("MicroMsg.BakPCServer", "backupImp.backupChatMsg canceled");
                                        return;
                                    }
                                }
                                bVar.efU = true;
                                v.i("MicroMsg.BakPCServer", "send conplete waiting to send finishCmd");
                                bVar.Uu();
                            }
                        }, "BakPCServer_startBak").start();
                        return;
                    case 4:
                        this.egj = d.egy;
                        this.egk = d.egr;
                        Uz();
                        a(uVar.eev, 0, null);
                        if (this.egf != null) {
                            this.egf.cancel();
                            this.egf = null;
                        }
                        if (this.egd != null) {
                            this.egd.cancel();
                        }
                        if (this.egg != null) {
                            this.egg.cAv = true;
                            this.egg = null;
                        }
                        if (this.efS != null) {
                            this.efS.UD();
                            return;
                        }
                        return;
                    case 6:
                        this.egj = d.egE;
                        this.egk = d.egu;
                        Uz();
                        this.egh = uVar.eev;
                        if (this.ega != null) {
                            this.ega.hZ(uVar.eev);
                        } else {
                            v.i("MicroMsg.BakPcProcessMgr", "callback is null");
                        }
                        a UO = com.tencent.mm.plugin.backup.g.b.UO();
                        UO.efN++;
                        com.tencent.mm.plugin.backup.g.b.a(new com.tencent.mm.plugin.backup.g.b.a(this) {
                            final /* synthetic */ c egm;

                            {
                                this.egm = r1;
                            }

                            public final void run() {
                                m mVar = new m();
                                if (this.eiS) {
                                    mVar.eeK = this.dbSize;
                                    mVar.efi = this.eiU - this.dbSize;
                                    mVar.efh = this.eiT;
                                    c cVar = this.egm;
                                    c.a(6, 0, mVar);
                                    com.tencent.mm.plugin.backup.b.b.a(3, new com.tencent.mm.v.e(cVar) {
                                        final /* synthetic */ c egm;

                                        {
                                            this.egm = r1;
                                        }

                                        public final void a(int i, int i2, String str, k kVar) {
                                            com.tencent.mm.plugin.backup.b.b bVar = (com.tencent.mm.plugin.backup.b.b) kVar;
                                            if (i == 0 && i2 == 0) {
                                                if (kVar.getType() == 3) {
                                                    com.tencent.mm.plugin.backup.d.v vVar = (com.tencent.mm.plugin.backup.d.v) bVar.Ud();
                                                    if (vVar.eev == 2) {
                                                        final l lVar = vVar.efE;
                                                        Runnable anonymousClass1 = new Runnable(this) {
                                                            final /* synthetic */ AnonymousClass2 ego;

                                                            public final void run() {
                                                                this.ego.egm.a(lVar);
                                                            }
                                                        };
                                                        Runnable anonymousClass2 = new Runnable(this) {
                                                            final /* synthetic */ AnonymousClass2 ego;

                                                            {
                                                                this.ego = r1;
                                                            }

                                                            public final void run() {
                                                                c.hX(7);
                                                            }
                                                        };
                                                        c cVar = this.egm;
                                                        v.i("MicroMsg.BakPcProcessMgr", "doGetBakchatKey id: %s", lVar.ID);
                                                        ak.vy().a(596, new AnonymousClass3(cVar, anonymousClass1, anonymousClass2));
                                                        if (cVar.egf != null) {
                                                            cVar.egf.cancel();
                                                        }
                                                        cVar.egf = new h(r0);
                                                        ak.vy().a(cVar.egf, 0);
                                                    }
                                                }
                                                com.tencent.mm.plugin.backup.b.b.b(3, this);
                                                return;
                                            }
                                            v.e("MicroMsg.BakPcProcessMgr", "onSceneEnd:%d  err  [%d,%d]", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
                                        }
                                    });
                                    v.i("MicroMsg.BakPcProcessMgr", "send restore info cmd");
                                    new com.tencent.mm.plugin.backup.e.a(2).Uh();
                                    return;
                                }
                                if (this.dbSize > this.eiU && this.eiU > 0) {
                                    mVar.eeK = this.dbSize;
                                    mVar.efi = this.eiU - this.dbSize;
                                }
                                c.a(6, 14, mVar);
                                v.e("MicroMsg.BakPcProcessMgr", "init TempDB error");
                            }
                        }, false);
                        return;
                    case 7:
                        this.egj = d.egy;
                        this.egk = d.egr;
                        Uz();
                        a(uVar.eev, 0, null);
                        if (this.egf != null) {
                            this.egf.cancel();
                            this.egf = null;
                        }
                        if (this.ege != null) {
                            this.ege.cancel();
                        }
                        if (this.efS != null) {
                            this.efS.UD();
                            return;
                        }
                        return;
                    case 9:
                        a(uVar.eev, 0, null);
                        if (this.egd != null) {
                            this.egd.pause();
                            return;
                        }
                        return;
                    case 10:
                        a(uVar.eev, 0, null);
                        if (this.ege != null) {
                            this.ege.pause();
                            return;
                        }
                        return;
                    case 11:
                        a(uVar.eev, 0, null);
                        if (this.egd != null) {
                            this.egd.resume();
                            return;
                        }
                        return;
                    case 12:
                        a(uVar.eev, 0, null);
                        if (this.ege != null) {
                            this.ege.resume();
                            return;
                        }
                        return;
                    case 15:
                        com.tencent.mm.plugin.backup.g.b.UJ().Tz();
                        com.tencent.mm.plugin.backup.g.b.UO().zR();
                        D(15, null);
                        return;
                    case 16:
                        a(uVar.eev, 0, null);
                        if (this.egc != null) {
                            this.egc.UE();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } catch (Throwable e) {
                v.a("MicroMsg.BakPcProcessMgr", e, "buf to PacketCommandReq error", new Object[0]);
            }
            v.a("MicroMsg.BakPcProcessMgr", e, "buf to PacketCommandReq error", new Object[0]);
        }
    }

    public static void Ux() {
        Intent className = new Intent().setClassName(aa.getContext(), "com.tencent.mm.ui.LauncherUI");
        className.addFlags(335544320);
        className.putExtra("nofification_type", "back_to_pcmgr_error_notification");
        aa.getContext().startActivity(className);
    }

    public final int Uy() {
        v.i("MicroMsg.BakPcProcessMgr", "getPCProgressPercent now progress:%d", Integer.valueOf(this.egk));
        if (this.egk == d.egs || this.egk == d.egt) {
            return this.egd.efX;
        }
        if (this.egk == d.egu || this.egk == d.egv) {
            return this.ege.egO;
        }
        if (this.egk == d.egw || this.egk == d.egx) {
            return this.ege.egJ;
        }
        v.w("MicroMsg.BakPcProcessMgr", "wrong operatorStatus");
        return 0;
    }

    public final void hW(int i) {
        if (i == 0) {
            this.egj = d.egA;
        } else {
            this.egj = d.egy;
        }
        com.tencent.mm.plugin.backup.d.v vVar;
        if (i == 1) {
            vVar = new com.tencent.mm.plugin.backup.d.v();
            vVar.eev = 0;
            vVar.eeO = i;
            try {
                v.i("MicroMsg.BakPcProcessMgr", "send auth cmd resp, status:%d", Integer.valueOf(vVar.eeO));
                com.tencent.mm.plugin.backup.b.b.r(vVar.toByteArray(), 4);
                return;
            } catch (Throwable e) {
                v.a("MicroMsg.BakPcProcessMgr", e, "buf to PacketCommandResponse err", new Object[0]);
                return;
            }
        }
        com.tencent.mm.plugin.backup.d.k kVar = new com.tencent.mm.plugin.backup.d.k();
        kVar.eeZ = 0;
        kVar.efb = Build.MANUFACTURER;
        kVar.eeB = Build.MODEL;
        kVar.efa = 0;
        kVar.efc = VERSION.RELEASE;
        String str = t.cng;
        if (new File(com.tencent.mm.compatible.util.e.cni).exists() && com.tencent.mm.compatible.util.f.sj()) {
            File file = new File(com.tencent.mm.compatible.util.e.cnj);
            if (file.exists() || file.mkdirs()) {
                str = com.tencent.mm.compatible.util.e.cnj;
            }
        }
        kVar.eeY = str;
        kVar.eeX = com.tencent.mm.model.k.xH();
        kVar.eeW = com.tencent.mm.model.k.xF();
        kVar.eeV = com.tencent.mm.protocal.d.lWh;
        try {
            PackageInfo packageInfo = aa.getContext().getPackageManager().getPackageInfo(aa.getContext().getPackageName(), 0);
            kVar.eeV = packageInfo.versionName + ";" + packageInfo.versionCode + ";" + com.tencent.mm.protocal.d.lWh;
        } catch (Throwable e2) {
            v.a("MicroMsg.BakPcProcessMgr", e2, "get packageInfo failed", new Object[0]);
        }
        n.AX();
        Bitmap gI = com.tencent.mm.u.d.gI(kVar.eeW);
        byte[] bArr = null;
        if (gI != null) {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            gI.compress(CompressFormat.PNG, 0, byteArrayOutputStream);
            bArr = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable e3) {
                v.a("MicroMsg.BakPcProcessMgr", e3, "close", new Object[0]);
            }
        }
        n.AX();
        String s = com.tencent.mm.u.d.s(kVar.eeW, true);
        String str2 = "MicroMsg.BakPcProcessMgr";
        String str3 = ", bmHDPath:%s, bm.buf.len:%d";
        Object[] objArr = new Object[2];
        objArr[0] = s;
        objArr[1] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        v.i(str2, str3, objArr);
        if (!be.bl(bArr)) {
            kVar.efd = new com.tencent.mm.ba.b(bArr);
        }
        bArr = com.tencent.mm.a.e.d(s, 0, -1);
        if (!be.bl(bArr)) {
            kVar.efe = new com.tencent.mm.ba.b(bArr);
        }
        vVar = new com.tencent.mm.plugin.backup.d.v();
        vVar.eev = 0;
        vVar.eeO = i;
        vVar.efC = kVar;
        try {
            v.i("MicroMsg.BakPcProcessMgr", "send auth cmd resp, status:%d", Integer.valueOf(vVar.eeO));
            com.tencent.mm.plugin.backup.b.b.r(vVar.toByteArray(), 4);
        } catch (Throwable e22) {
            v.a("MicroMsg.BakPcProcessMgr", e22, "buf to PacketCommandResponse err", new Object[0]);
        }
    }

    public static void a(int i, int i2, m mVar) {
        com.tencent.mm.plugin.backup.d.v vVar = new com.tencent.mm.plugin.backup.d.v();
        vVar.eev = i;
        vVar.eeO = i2;
        vVar.efF = mVar;
        try {
            v.i("MicroMsg.BakPcProcessMgr", "send cmd resp, status:%d, cmd:%d (%s)", Integer.valueOf(i2), Integer.valueOf(i), hY(i));
            com.tencent.mm.plugin.backup.b.b.r(vVar.toByteArray(), 4);
        } catch (Throwable e) {
            v.a("MicroMsg.BakPcProcessMgr", e, "buf to PacketCommandResponse err", new Object[0]);
        }
    }

    public static void hX(int i) {
        u uVar = new u();
        uVar.eev = i;
        try {
            v.i("MicroMsg.BakPcProcessMgr", "sendNormalReq cmd :%d (%s)", Integer.valueOf(i), hY(i));
            com.tencent.mm.plugin.backup.b.b.r(uVar.toByteArray(), 3);
        } catch (Throwable e) {
            v.a("MicroMsg.BakPcProcessMgr", e, "buf to PacketCommandRequest err", new Object[0]);
        }
    }

    final synchronized void a(l lVar) {
        if (this.ege != null) {
            this.ege.cancel();
        }
        this.ege = new e();
        e eVar = this.ege;
        List list = lVar.eff;
        List list2 = lVar.efg;
        long j = lVar.eeN;
        eVar.egH = list;
        eVar.egI = list2;
        eVar.beg = false;
        eVar.cAv = false;
        eVar.efR.clear();
        eVar.efU = false;
        eVar.egK = false;
        eVar.egL = false;
        eVar.egJ = 0;
        eVar.egN = 0;
        eVar.egM = j;
        com.tencent.mm.plugin.backup.e.c.setProgress(0);
        this.ege.efS = this.efS;
        v.i("MicroMsg.BakPcProcessMgr", "reve textList:%d,  mediaList:%d, totalSize:%d", Integer.valueOf(lVar.eff.size()), Integer.valueOf(lVar.efg.size()), Long.valueOf(lVar.eeN));
        eVar = this.ege;
        eVar.efY = 0;
        if (eVar.egI.size() < lVar.eeS || eVar.egH.size() < lVar.eeR) {
            com.tencent.mm.plugin.backup.b.b.a(3, new com.tencent.mm.v.e(eVar) {
                final /* synthetic */ e egP;

                {
                    this.egP = r1;
                }

                public final void a(int i, int i2, String str, k kVar) {
                    com.tencent.mm.plugin.backup.d.v vVar = (com.tencent.mm.plugin.backup.d.v) ((b) kVar).Ud();
                    if (vVar.eev == 2) {
                        l lVar = vVar.efE;
                        this.egP.egI.addAll(lVar.efg);
                        this.egP.egH.addAll(lVar.eff);
                        v.i("MicroMsg.RecoverPCServer", "MediaSize:[%d / %d], digestSize: [%d / %d]", Integer.valueOf(this.egP.egI.size()), Integer.valueOf(this.egP.egH.size()), Integer.valueOf(lVar.eeS), Integer.valueOf(lVar.eeR));
                        if (this.egP.egI.size() < lVar.eeS || this.egP.egH.size() < lVar.eeR) {
                            v.i("MicroMsg.RecoverPCServer", "send restore info cmd again~");
                            new a(2).Uh();
                            return;
                        }
                        this.egP.egM = lVar.eeN;
                        v.i("MicroMsg.RecoverPCServer", "down RestoreInfo complete, totalSize:%d", Long.valueOf(this.egP.egM));
                        b.b(3, this);
                        com.tencent.mm.sdk.i.e.a(new Runnable(this) {
                            final /* synthetic */ AnonymousClass2 egQ;

                            {
                                this.egQ = r1;
                            }

                            public final void run() {
                                e.a(this.egQ.egP);
                            }
                        }, "RecoverPCServer_recover_getIDList");
                    }
                }
            });
            v.i("MicroMsg.RecoverPCServer", "send restore info cmd");
            new com.tencent.mm.plugin.backup.e.a(2).Uh();
        } else {
            v.i("MicroMsg.RecoverPCServer", "startRecover start directly");
            com.tencent.mm.sdk.i.e.a(new Runnable(eVar) {
                final /* synthetic */ e egP;

                {
                    this.egP = r1;
                }

                public final void run() {
                    e.a(this.egP);
                }
            }, "RecoverPCServer_recover");
        }
    }

    public static void Uz() {
        com.tencent.mm.sdk.c.a.nhr.z(new jq());
    }

    private static String hY(int i) {
        switch (i) {
            case -1:
                return "COMMAND_NOT_SUPPORT";
            case 0:
                return "AUTHORIZE";
            case 1:
                return "BACKUP_INFO";
            case 2:
                return "RESTORE_INFO";
            case 3:
                return "BACKUP_START";
            case 4:
                return "BACKUP_CANCEL";
            case 5:
                return "BACKUP_FINISH";
            case 6:
                return "RESTORE_START";
            case 7:
                return "RESTORE_CANCE";
            case 8:
                return "RESTORE_FINISH";
            case 9:
                return "BACKUP_PAUSE";
            case 10:
                return "RESTORE_PAUSE";
            case 11:
                return "BACKUP_RESUME";
            case 12:
                return "RESTORE_RESUME";
            case 13:
                return "MERGE_PROGRESS";
            case 14:
                return "LOGOFF";
            case 15:
                return "EXIT";
            case 16:
                return "SHOW_BACKUP_RESTORE";
            case 17:
                return "COMMAND_WECHAT_LEAVE";
            default:
                return String.valueOf(i);
        }
    }

    public final void p(int i, long j) {
        if (this.efS != null) {
            this.efS.ib(i);
        }
        u uVar = new u();
        uVar.eev = 19;
        uVar.efz = 0;
        uVar.efA = i;
        uVar.efB = j;
        try {
            v.i("MicroMsg.BakPcProcessMgr", "sendCalcuProcess cmd, progress :%d", Integer.valueOf(i));
            com.tencent.mm.plugin.backup.b.b.r(uVar.toByteArray(), 3);
        } catch (Throwable e) {
            v.a("MicroMsg.BakPcProcessMgr", e, "buf to PacketCommandRequest err", new Object[0]);
        }
    }
}
