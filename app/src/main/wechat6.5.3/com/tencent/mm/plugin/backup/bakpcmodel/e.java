package com.tencent.mm.plugin.backup.bakpcmodel;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.backup.bakpcmodel.c.d;
import com.tencent.mm.plugin.backup.d.n;
import com.tencent.mm.plugin.backup.d.u;
import com.tencent.mm.plugin.backup.f.h;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.plugin.backup.g.g;
import com.tencent.mm.plugin.backup.g.w;
import com.tencent.mm.plugin.backup.g.y;
import com.tencent.mm.plugin.backup.i.a;
import com.tencent.mm.protocal.c.dx;
import com.tencent.mm.protocal.c.dy;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.v.f;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.mmdb.database.SQLiteDebug;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class e implements f {
    boolean beg = false;
    boolean cAv = false;
    HashSet<String> efR = new HashSet();
    d efS;
    private com.tencent.mm.v.e efT;
    boolean efU = false;
    int efY = 0;
    List<n> egH;
    List<n> egI;
    int egJ = 0;
    public boolean egK = false;
    boolean egL = false;
    long egM;
    long egN;
    int egO;
    Object lock = new Object();

    class AnonymousClass5 implements Runnable {
        final /* synthetic */ e egP;
        final /* synthetic */ int egR;

        AnonymousClass5(e eVar, int i) {
            this.egP = eVar;
            this.egR = i;
        }

        public final void run() {
            int a;
            Throwable e;
            h.reset();
            h.UI();
            y yVar = new y();
            yVar.begin();
            HashMap hashMap = new HashMap();
            HashSet hashSet = new HashSet();
            int i = 0;
            for (n nVar : this.egP.egH) {
                try {
                    a = this.egP.a(b.Vj() + "mmbakItem/" + g.pd(nVar.ID) + nVar.ID, hashMap, yVar, hashSet);
                    if (a < 0) {
                        yVar.end();
                        v.w("MicroMsg.RecoverPCServer", "Thread has been canceled");
                        return;
                    }
                    a += i;
                    try {
                        this.egP.bk(a, this.egR);
                        v.i("MicroMsg.RecoverPCServer", "recover has done: %d", Integer.valueOf(a));
                        i = a;
                    } catch (Exception e2) {
                        e = e2;
                        v.e("MicroMsg.RecoverPCServer", "Thread.run err:" + e.toString());
                        v.a("MicroMsg.RecoverPCServer", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                        v.f("MicroMsg.RecoverPCServer", "recoverFromSdcard MMThread.run() " + e.toString());
                        i = a;
                    }
                } catch (Throwable e3) {
                    Throwable th = e3;
                    a = i;
                    e = th;
                    v.e("MicroMsg.RecoverPCServer", "Thread.run err:" + e.toString());
                    v.a("MicroMsg.RecoverPCServer", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    v.f("MicroMsg.RecoverPCServer", "recoverFromSdcard MMThread.run() " + e.toString());
                    i = a;
                }
            }
            a.b(hashMap);
            yVar.end();
            this.egP.bk(100, 100);
            v.i("MicroMsg.RecoverPCServer", "build temDB finish!");
            v.bta();
            b.h(new Runnable(this) {
                final /* synthetic */ AnonymousClass5 egS;

                {
                    this.egS = r1;
                }

                public final void run() {
                    v.i("MicroMsg.RecoverPCServer", "readFromSdcard end");
                    v.bta();
                    b.UK().egk = d.egx;
                    this.egS.egP.egJ = 0;
                    if (this.egS.egP.efS != null) {
                        this.egS.egP.efS.UC();
                    } else {
                        v.i("MicroMsg.RecoverPCServer", "operatorCallback is null");
                    }
                    c.Uz();
                    new com.tencent.mm.plugin.backup.e.a(8).Uh();
                    v.i("MicroMsg.RecoverPCServer", "recover ok");
                    ak.yW();
                    c.vf().a(t.a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.valueOf(true));
                    a UO = b.UO();
                    UO.efO++;
                    b.UK().egj = d.egG;
                    this.egS.egP.cancel();
                    b.Vh().Wb();
                }
            });
        }
    }

    static /* synthetic */ void a(e eVar) {
        com.tencent.mm.a.e.e(new File(b.Vj()));
        eVar.efT = new com.tencent.mm.v.e(eVar) {
            final /* synthetic */ e egP;

            {
                this.egP = r1;
            }

            public final void a(int i, int i2, String str, k kVar) {
                v.i("MicroMsg.RecoverPCServer", "onSceneEnd %s, %d, %d", ((com.tencent.mm.plugin.backup.e.c) kVar).id, Integer.valueOf(i), Integer.valueOf(i2));
                synchronized (this.egP.lock) {
                    this.egP.efR.remove(r10.id);
                    v.i("MicroMsg.RecoverPCServer", "onSceneEnd left: size:%d", Integer.valueOf(this.egP.efR.size()));
                    if (this.egP.efR.size() <= 10) {
                        this.egP.lock.notifyAll();
                    }
                }
                e eVar = this.egP;
                eVar.efY++;
                if (this.egP.efY % SQLiteDebug.MAIN_THREAD_SLOW_QUERY_THRESHOLD == 0) {
                    this.egP.UG();
                }
                this.egP.UF();
            }
        };
        com.tencent.mm.plugin.backup.b.b.a(7, eVar.efT);
        for (n nVar : eVar.egI) {
            if (eVar.beg && !eVar.cAv) {
                v.i("MicroMsg.RecoverPCServer", "hit pause");
                synchronized (eVar.lock) {
                    try {
                        eVar.lock.wait();
                    } catch (Throwable e) {
                        v.a("MicroMsg.RecoverPCServer", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    }
                }
            }
            if (eVar.cAv) {
                v.i("MicroMsg.RecoverPCServer", "backupImp canceled");
                return;
            }
            com.tencent.mm.plugin.backup.e.c cVar = new com.tencent.mm.plugin.backup.e.c(b.Vj(), nVar.ID, 2, nVar.efj, eVar);
            synchronized (eVar.lock) {
                cVar.Uh();
                eVar.efR.add(nVar.ID);
                v.i("MicroMsg.RecoverPCServer", "media recoverImp now: size:%d", Integer.valueOf(eVar.efR.size()));
                if (eVar.efR.size() > 10) {
                    try {
                        eVar.lock.wait();
                    } catch (Throwable e2) {
                        v.a("MicroMsg.RecoverPCServer", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                    }
                }
            }
        }
        for (n nVar2 : eVar.egH) {
            if (eVar.beg && !eVar.cAv) {
                v.i("MicroMsg.RecoverPCServer", "hit pause");
                synchronized (eVar.lock) {
                    try {
                        eVar.lock.wait();
                    } catch (Throwable e22) {
                        v.a("MicroMsg.RecoverPCServer", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
                    }
                }
            }
            if (eVar.cAv) {
                v.i("MicroMsg.RecoverPCServer", "backupImp canceled");
                return;
            }
            cVar = new com.tencent.mm.plugin.backup.e.c(b.Vj(), nVar2.ID, 1, nVar2.efj, eVar);
            synchronized (eVar.lock) {
                cVar.Uh();
                eVar.efR.add(nVar2.ID);
                v.i("MicroMsg.RecoverPCServer", "digest recoverImp now: size:%d", Integer.valueOf(eVar.efR.size()));
                if (eVar.efR.size() > 10) {
                    try {
                        eVar.lock.wait();
                    } catch (Throwable e222) {
                        v.a("MicroMsg.RecoverPCServer", e222, SQLiteDatabase.KeyEmpty, new Object[0]);
                    }
                }
            }
        }
        eVar.efU = true;
        v.i("MicroMsg.RecoverPCServer", "send RestoreData req finish");
        eVar.UF();
    }

    public final void pause() {
        v.i("MicroMsg.RecoverPCServer", "pause");
        this.beg = true;
    }

    public final void resume() {
        v.i("MicroMsg.RecoverPCServer", "resume");
        this.beg = false;
        synchronized (this.lock) {
            this.lock.notifyAll();
        }
    }

    public final void cancel() {
        v.i("MicroMsg.RecoverPCServer", "cancel");
        this.cAv = true;
        synchronized (this.lock) {
            this.lock.notifyAll();
        }
        com.tencent.mm.plugin.backup.b.b.b(7, this.efT);
        this.efS = null;
        this.egK = false;
        this.egL = false;
        this.egJ = 0;
        this.egO = 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void UF() {
        /*
        r3 = this;
        r0 = r3.efU;
        if (r0 == 0) goto L_0x0008;
    L_0x0004:
        r0 = r3.cAv;
        if (r0 == 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r1 = r3.lock;
        monitor-enter(r1);
        r0 = r3.efR;	 Catch:{ all -> 0x001a }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x001a }
        if (r0 == 0) goto L_0x0053;
    L_0x0014:
        r0 = r3.cAv;	 Catch:{ all -> 0x001a }
        if (r0 == 0) goto L_0x001d;
    L_0x0018:
        monitor-exit(r1);	 Catch:{ all -> 0x001a }
        goto L_0x0008;
    L_0x001a:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001a }
        throw r0;
    L_0x001d:
        r0 = 1;
        r3.egK = r0;	 Catch:{ all -> 0x001a }
        r0 = 0;
        r3.egO = r0;	 Catch:{ all -> 0x001a }
        r0 = com.tencent.mm.plugin.backup.g.b.UK();	 Catch:{ all -> 0x001a }
        r2 = com.tencent.mm.plugin.backup.bakpcmodel.d.egF;	 Catch:{ all -> 0x001a }
        r0.egj = r2;	 Catch:{ all -> 0x001a }
        r0 = com.tencent.mm.plugin.backup.g.b.UK();	 Catch:{ all -> 0x001a }
        r2 = com.tencent.mm.plugin.backup.bakpcmodel.d.egv;	 Catch:{ all -> 0x001a }
        r0.egk = r2;	 Catch:{ all -> 0x001a }
        r0 = r3.efS;	 Catch:{ all -> 0x001a }
        if (r0 == 0) goto L_0x0055;
    L_0x0037:
        r0 = r3.efS;	 Catch:{ all -> 0x001a }
        r0.UB();	 Catch:{ all -> 0x001a }
    L_0x003c:
        r0 = 7;
        r2 = r3.efT;	 Catch:{ all -> 0x001a }
        com.tencent.mm.plugin.backup.b.b.b(r0, r2);	 Catch:{ all -> 0x001a }
        r0 = 0;
        r2 = 0;
        r3.bk(r0, r2);	 Catch:{ all -> 0x001a }
        com.tencent.mm.plugin.backup.bakpcmodel.c.Uz();	 Catch:{ all -> 0x001a }
        r0 = "MicroMsg.RecoverPCServer";
        r2 = "checkRecover publicRestAccUinEven";
        com.tencent.mm.sdk.platformtools.v.i(r0, r2);	 Catch:{ all -> 0x001a }
    L_0x0053:
        monitor-exit(r1);	 Catch:{ all -> 0x001a }
        goto L_0x0008;
    L_0x0055:
        r0 = "MicroMsg.RecoverPCServer";
        r2 = "operatorCallback is null";
        com.tencent.mm.sdk.platformtools.v.i(r0, r2);	 Catch:{ all -> 0x001a }
        goto L_0x003c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.bakpcmodel.e.UF():void");
    }

    public static int X(List<n> list) {
        int i = 0;
        for (n nVar : list) {
            try {
                i = ((dy) new dy().az(com.tencent.mm.a.e.d(b.Vj() + "mmbakItem/" + g.pd(nVar.ID) + nVar.ID, 0, -1))).eeu.size() + i;
            } catch (Throwable e) {
                v.a("MicroMsg.RecoverPCServer", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
        return i;
    }

    final void bk(int i, int i2) {
        int i3 = (int) (i == 0 ? 0 : (((long) i) * 100) / ((long) i2));
        if ((i == 0 && i2 == 0) || i3 > this.egJ) {
            this.egJ = i3;
            if (!(this.beg || this.cAv || this.efS == null || this.egJ < 0 || this.egJ > 100)) {
                this.efS.id(this.egJ);
            }
            u uVar = new u();
            uVar.eev = 13;
            uVar.efz = 0;
            uVar.efA = this.egJ;
            try {
                v.i("MicroMsg.RecoverPCServer", "send progress cmd, progress :%d", Integer.valueOf(i3));
                com.tencent.mm.plugin.backup.b.b.r(uVar.toByteArray(), 3);
            } catch (Throwable e) {
                v.a("MicroMsg.RecoverPCServer", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                v.e("MicroMsg.RecoverPCServer", "buf to PacketCommandRequest err");
            }
        }
    }

    final int a(String str, HashMap<String, Integer> hashMap, y yVar, HashSet<String> hashSet) {
        long currentTimeMillis = System.currentTimeMillis();
        byte[] d = com.tencent.mm.a.e.d(str, 0, -1);
        try {
            dy dyVar = (dy) new dy().az(d);
            Iterator it = dyVar.eeu.iterator();
            while (it.hasNext()) {
                dx dxVar = (dx) it.next();
                if (this.beg && !this.cAv) {
                    synchronized (this.lock) {
                        try {
                            this.lock.wait();
                        } catch (Throwable e) {
                            v.a("MicroMsg.RecoverPCServer", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                        }
                    }
                }
                if (this.cAv) {
                    v.i("MicroMsg.RecoverPCServer", "backupImp canceled");
                    return -1;
                }
                try {
                    w.a(dxVar, hashMap, hashSet);
                    this.efY++;
                    if (this.efY % 100 == 0) {
                        UG();
                    }
                } catch (Throwable e2) {
                    v.e("MicroMsg.RecoverPCServer", "readFromSdcard err:" + e2.toString());
                    v.a("MicroMsg.RecoverPCServer", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
                h.ie(dxVar.efm);
                yVar.Wd();
            }
            h.UH();
            v.d("MicroMsg.RecoverPCServer", "read item time " + (System.currentTimeMillis() - currentTimeMillis));
            return dyVar.eeu.size();
        } catch (Throwable e3) {
            Throwable th = e3;
            String str2 = "MicroMsg.RecoverPCServer";
            String str3 = "read mmPath errr %s, %s, len:%d";
            Object[] objArr = new Object[3];
            objArr[0] = str;
            objArr[1] = th;
            objArr[2] = Integer.valueOf(d == null ? 0 : d.length);
            v.e(str2, str3, objArr);
            v.a("MicroMsg.RecoverPCServer", th, SQLiteDatabase.KeyEmpty, new Object[0]);
            return 0;
        }
    }

    public final void UG() {
        System.gc();
        long freeMemory = Runtime.getRuntime().freeMemory() / 1000;
        long totalMemory = Runtime.getRuntime().totalMemory() / 1000;
        v.i("MicroMsg.RecoverPCServer", "memoryInfo avail/total, dalvik[%dk, %dk, user:%dk], recoverCnt:%d", Long.valueOf(freeMemory), Long.valueOf(totalMemory), Long.valueOf(totalMemory - freeMemory), Integer.valueOf(this.efY));
    }

    public final void a(int i, int i2, k kVar) {
        this.egN += (long) i;
        int i3 = this.egM == 0 ? 0 : (int) ((this.egN * 100) / this.egM);
        if (i3 > this.egO) {
            this.egO = i3;
            com.tencent.mm.plugin.backup.e.c.setProgress(this.egO);
        }
        if (this.beg || this.cAv || this.efS == null || this.egO < 0 || this.egO > 100) {
            v.d("MicroMsg.RecoverPCServer", "failed to call operatorCallback.onNetProgress:%d", Integer.valueOf(this.egO));
        } else {
            this.efS.ic(this.egO);
        }
    }
}
