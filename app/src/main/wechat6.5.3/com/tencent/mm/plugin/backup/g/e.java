package com.tencent.mm.plugin.backup.g;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.network.aa;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.backup.f.d;
import com.tencent.mm.plugin.backup.f.g;
import com.tencent.mm.plugin.backup.h.a;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.c.dx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.v.f;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public final class e implements com.tencent.mm.v.e, f {
    private static int eiV = 15;
    private final Random ciF = new Random();
    private final ac cnC = new ac(Looper.getMainLooper());
    private int efY = 0;
    u eiW;
    i eiX = new i();
    private HashMap<Integer, String> eiY = new HashMap();
    private HashMap<Integer, String> eiZ = new HashMap();
    private int eja;
    private HashMap<String, Integer> ejb = new HashMap();
    private int ejc = 0;
    private int ejd;
    private int eje = 0;
    public m ejf = null;
    private boolean ejg = false;
    private final Object lock = new Object();

    public final void bR(boolean z) {
        this.ejg = false;
        b.vy().b(323, (com.tencent.mm.v.e) this);
        b.vy().b(324, (com.tencent.mm.v.e) this);
        b.vy().b(321, (com.tencent.mm.v.e) this);
        b.vy().b(322, (com.tencent.mm.v.e) this);
        v.d("MicroMsg.BackupServer", "removeSceneEndListener ");
        for (Integer intValue : this.eiY.keySet()) {
            b.vy().cancel(intValue.intValue());
        }
        for (Integer intValue2 : this.eiZ.keySet()) {
            b.vy().cancel(intValue2.intValue());
        }
        this.ciF.setSeed(be.Nj());
        this.ejb.clear();
        this.eja = 0;
        this.ejc = 0;
        this.ejd = 0;
        this.eiY.clear();
        this.eiZ.clear();
        this.eiX.VR();
        if (this.eiW != null) {
            v.i("MicroMsg.BackupServer", "cancelBak kill thread");
            synchronized (this.lock) {
                this.eiW.kill();
            }
        }
        if (z) {
            this.eiX.reset();
        }
    }

    private void ig(final int i) {
        if (i < 0) {
            v.f("MicroMsg.BackupServer", "startTask no tryCount left");
        } else if (this.eiW == null || !this.eiW.isAlive()) {
            final String str = (String) b.Vd().vf().get(2, null);
            this.eiW = new u(this) {
                final /* synthetic */ e eji;

                public final void run() {
                    int i = !be.kS(this.eji.eiX.VO()) ? 1 : 0;
                    Iterator it = this.eji.eiX.VN().iterator();
                    int i2 = i;
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        v.d("MicroMsg.BackupServer", "mmbakup  " + str);
                        if (!Wa()) {
                            int i3;
                            if (i2 != 0) {
                                if (str.equals(this.eji.eiX.VO())) {
                                    i2 = 0;
                                } else {
                                    continue;
                                }
                            }
                            af Mh = b.Vd().wK().Mh(str);
                            if (Mh != null) {
                                i3 = Mh.field_unReadCount;
                            } else {
                                i3 = 0;
                            }
                            try {
                                v.i("MicroMsg.BackupServer", "backupImp username:%s, unReadCount:%d", str, Integer.valueOf(i3));
                                if (this.eji.k(str, str, i3) < 0) {
                                    return;
                                }
                            } catch (Throwable e) {
                                v.a("MicroMsg.BackupServer", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                                v.f("MicroMsg.BackupServer", "BackupServer.startTask MMThread.run() %s", e);
                            }
                        } else {
                            return;
                        }
                    }
                    this.eji.cnC.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass2 ejk;

                        {
                            this.ejk = r1;
                        }

                        public final void run() {
                            v.d("MicroMsg.BackupServer", "read finish !");
                            this.ejk.eji.eiX.ih(2);
                            this.ejk.eji.Vo();
                        }
                    });
                }
            };
            this.eiW.setPriority(1);
            this.eiW.start();
        } else if (this.eiW.Wa()) {
            new ac(Looper.getMainLooper()).postDelayed(new Runnable(this) {
                final /* synthetic */ e eji;

                public final void run() {
                    this.eji.ig(i - 1);
                }
            }, 50);
        } else {
            v.i("MicroMsg.BackupServer", "startTask the thread is normal run, no need to start new");
        }
    }

    private int k(String str, String str2, int i) {
        LinkedList linkedList;
        int i2 = aa.bk(com.tencent.mm.sdk.platformtools.aa.getContext()) ? 16384 : 8192;
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        PLong pLong = new PLong();
        v.d("MicroMsg.BackupServer", "backupChatMsg start " + str);
        Object obj = (!str.equals(this.eiX.VO()) || this.eiX.VP() == 0) ? null : 1;
        long j = 0;
        Cursor MQ = b.Vd().wJ().MQ(str);
        if (MQ.moveToFirst()) {
            Object obj2 = obj;
            linkedList = linkedList2;
            while (!MQ.isAfterLast()) {
                if (this.eiW.Wa()) {
                    MQ.close();
                    return -1;
                }
                bx atVar = new at();
                atVar.b(MQ);
                if (obj2 != null) {
                    if (atVar.field_msgSvrId == this.eiX.VP()) {
                        obj = null;
                    } else {
                        obj = obj2;
                    }
                    MQ.moveToNext();
                    obj2 = obj;
                } else {
                    dx a;
                    long j2;
                    LinkedList linkedList4;
                    try {
                        a = d.a(atVar, false, str2, pLong, linkedList3, i > 0);
                        i--;
                    } catch (Throwable e) {
                        v.a("MicroMsg.BackupServer", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                        v.f("MicroMsg.BackupServer", "backupChatMsg %s" + e);
                        a = null;
                    }
                    if (a != null) {
                        linkedList.add(a);
                        j2 = a.mcb;
                    } else {
                        j2 = j;
                    }
                    if (pLong.value > ((long) i2)) {
                        v.d("MicroMsg.BackupServer", "limitSize " + pLong.value);
                        int a2 = a(linkedList, linkedList3, pLong.value);
                        if (a2 < 0) {
                            MQ.close();
                            return a2;
                        }
                        this.eiX.n(str, j2);
                        pLong.value = 0;
                        linkedList4 = new LinkedList();
                        linkedList3.clear();
                    } else {
                        linkedList4 = linkedList;
                    }
                    MQ.moveToNext();
                    j = j2;
                    linkedList = linkedList4;
                }
            }
        } else {
            linkedList = linkedList2;
        }
        if (pLong.value > 0) {
            int a3 = a(linkedList, linkedList3, pLong.value);
            pLong.value = 0;
            if (a3 < 0) {
                MQ.close();
                return a3;
            }
            this.eiX.n(str, j);
        }
        MQ.close();
        v.d("MicroMsg.BackupServer", "backupChatMsg end " + str);
        return 0;
    }

    private int a(LinkedList<dx> linkedList, LinkedList<g> linkedList2, long j) {
        String m = com.tencent.mm.a.g.m((be.Nj() + this.ciF.nextDouble()).getBytes());
        synchronized (this.lock) {
            d dVar = new d();
            dVar.bNv = m;
            dVar.ehx = linkedList;
            dVar.ehw = (int) j;
            this.eiX.a(dVar);
            Iterator it = linkedList2.iterator();
            while (it.hasNext()) {
                g gVar = (g) it.next();
                gVar.bNv = m;
                this.eiX.a(gVar);
            }
            if (!q.dpV) {
                Vo();
            }
            if (this.eiX.VM() >= 30) {
                try {
                    v.i("MicroMsg.BackupServer", "prepareUpload work thread wait()");
                    this.lock.wait();
                } catch (Throwable e) {
                    v.a("MicroMsg.BackupServer", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    return -1;
                }
            }
        }
        return 0;
    }

    private void Vo() {
        this.cnC.post(new Runnable(this) {
            final /* synthetic */ e eji;

            {
                this.eji = r1;
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                r6 = this;
                r5 = 0;
                r0 = r6.eji;
                r0 = com.tencent.mm.sdk.platformtools.be.kS(r0.eiX.VC());
                if (r0 == 0) goto L_0x0013;
            L_0x0009:
                r0 = "MicroMsg.BackupServer";
                r1 = "checkUpload break  ";
                com.tencent.mm.sdk.platformtools.v.d(r0, r1);
            L_0x0012:
                return;
            L_0x0013:
                r0 = r6.eji;
                r0 = r0.eiX;
                r0 = r0.VJ();
                if (r0 != 0) goto L_0x0012;
            L_0x001f:
                r0 = r6.eji;
                r0 = r0.eiX;
                r0 = r0.VD();
                if (r0 != 0) goto L_0x0063;
            L_0x002b:
                r0 = new com.tencent.mm.plugin.backup.h.e;
                r1 = r6.eji;
                r1 = r1.eiX;
                r1 = r1.VC();
                r2 = android.os.Build.MODEL;
                r3 = r6.eji;
                r3 = r3.eiX;
                r3 = r3.VS();
                r4 = r6.eji;
                r4 = r4.eiX;
                r4 = r4.VT();
                r0.<init>(r1, r2, r3, r4);
                r1 = com.tencent.mm.plugin.backup.g.b.vy();
                r0 = r1.a(r0, r5);
                if (r0 != 0) goto L_0x0012;
            L_0x005a:
                r0 = r6.eji;
                r1 = "send UploadHead";
                r0.f(3, -1, r1);
                goto L_0x0012;
            L_0x0063:
                r0 = r6.eji;
                r1 = r0.lock;
                monitor-enter(r1);
                r0 = r6.eji;	 Catch:{ all -> 0x010f }
                r0 = r0.eiX;	 Catch:{ all -> 0x010f }
                r0 = r0.VM();	 Catch:{ all -> 0x010f }
                r2 = 15;
                if (r0 >= r2) goto L_0x0081;
            L_0x0078:
                r0 = r6.eji;	 Catch:{ all -> 0x010f }
                r0 = r0.lock;	 Catch:{ all -> 0x010f }
                r0.notify();	 Catch:{ all -> 0x010f }
            L_0x0081:
                r0 = "MicroMsg.BackupServer";
                r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x010f }
                r3 = "msgList ";
                r2.<init>(r3);	 Catch:{ all -> 0x010f }
                r3 = r6.eji;	 Catch:{ all -> 0x010f }
                r3 = r3.eiX;	 Catch:{ all -> 0x010f }
                r3 = r3.VL();	 Catch:{ all -> 0x010f }
                r3 = r3.size();	 Catch:{ all -> 0x010f }
                r2 = r2.append(r3);	 Catch:{ all -> 0x010f }
                r3 = " ";
                r2 = r2.append(r3);	 Catch:{ all -> 0x010f }
                r3 = r6.eji;	 Catch:{ all -> 0x010f }
                r3 = r3.eiX;	 Catch:{ all -> 0x010f }
                r3 = r3.VK();	 Catch:{ all -> 0x010f }
                r3 = r3.size();	 Catch:{ all -> 0x010f }
                r2 = r2.append(r3);	 Catch:{ all -> 0x010f }
                r2 = r2.toString();	 Catch:{ all -> 0x010f }
                com.tencent.mm.sdk.platformtools.v.d(r0, r2);	 Catch:{ all -> 0x010f }
                r0 = r6.eji;	 Catch:{ all -> 0x010f }
                r0 = r0.eiX;	 Catch:{ all -> 0x010f }
                r0 = r0.VM();	 Catch:{ all -> 0x010f }
                if (r0 != 0) goto L_0x011c;
            L_0x00ca:
                r0 = r6.eji;	 Catch:{ all -> 0x010f }
                r0 = r0.eiX;	 Catch:{ all -> 0x010f }
                r0 = r0.VD();	 Catch:{ all -> 0x010f }
                r2 = 2;
                if (r0 != r2) goto L_0x011c;
            L_0x00d7:
                r0 = "MicroMsg.BackupServer";
                r2 = "bak data is finish";
                com.tencent.mm.sdk.platformtools.v.d(r0, r2);	 Catch:{ all -> 0x010f }
                r0 = new com.tencent.mm.plugin.backup.h.d;	 Catch:{ all -> 0x010f }
                r2 = r6.eji;	 Catch:{ all -> 0x010f }
                r2 = r2.eiX;	 Catch:{ all -> 0x010f }
                r2 = r2.VC();	 Catch:{ all -> 0x010f }
                r3 = r6.eji;	 Catch:{ all -> 0x010f }
                r3 = r3.eiX;	 Catch:{ all -> 0x010f }
                r3 = r3.VB();	 Catch:{ all -> 0x010f }
                r0.<init>(r2, r3);	 Catch:{ all -> 0x010f }
                r2 = com.tencent.mm.plugin.backup.g.b.vy();	 Catch:{ all -> 0x010f }
                r3 = 0;
                r0 = r2.a(r0, r3);	 Catch:{ all -> 0x010f }
                if (r0 != 0) goto L_0x0112;
            L_0x0104:
                r0 = r6.eji;	 Catch:{ all -> 0x010f }
                r2 = "send UploadEnd";
                r0.f(3, -1, r2);	 Catch:{ all -> 0x010f }
                monitor-exit(r1);	 Catch:{ all -> 0x010f }
                goto L_0x0012;
            L_0x010f:
                r0 = move-exception;
                monitor-exit(r1);	 Catch:{ all -> 0x010f }
                throw r0;
            L_0x0112:
                r0 = r6.eji;	 Catch:{ all -> 0x010f }
                r0 = r0.eiX;	 Catch:{ all -> 0x010f }
                r2 = 3;
                r0.ih(r2);	 Catch:{ all -> 0x010f }
            L_0x011c:
                r0 = r6.eji;	 Catch:{ all -> 0x010f }
                r0 = r0.eja;	 Catch:{ all -> 0x010f }
                r2 = com.tencent.mm.plugin.backup.g.e.eiV;	 Catch:{ all -> 0x010f }
                if (r0 <= r2) goto L_0x012b;
            L_0x0128:
                monitor-exit(r1);	 Catch:{ all -> 0x010f }
                goto L_0x0012;
            L_0x012b:
                monitor-exit(r1);	 Catch:{ all -> 0x010f }
                r0 = r6.eji;
                r0 = r0.Vp();
                if (r0 == 0) goto L_0x013b;
            L_0x0134:
                r0 = r6.eji;
                r0.Vo();
                goto L_0x0012;
            L_0x013b:
                r0 = r6.eji;
                r0 = r0.Vq();
                if (r0 == 0) goto L_0x0012;
            L_0x0143:
                r0 = r6.eji;
                r0.Vo();
                goto L_0x0012;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.g.e.3.run():void");
            }
        });
    }

    private boolean Vp() {
        d dVar;
        synchronized (this.lock) {
            Iterator it = this.eiX.VL().iterator();
            while (it.hasNext()) {
                d dVar2 = (d) it.next();
                if (!this.eiY.containsValue(dVar2.bNv)) {
                    Object obj;
                    LinkedList linkedList = dVar2.ehx;
                    Iterator it2 = this.eiX.VK().iterator();
                    while (it2.hasNext()) {
                        g gVar = (g) it2.next();
                        Iterator it3 = linkedList.iterator();
                        while (it3.hasNext()) {
                            if (((dx) it3.next()).mcb == gVar.ehN) {
                                obj = null;
                                break;
                            }
                        }
                    }
                    obj = 1;
                    if (obj != null) {
                        dVar = dVar2;
                        break;
                    }
                }
            }
            dVar = null;
        }
        if (dVar == null) {
            return false;
        }
        k gVar2 = new com.tencent.mm.plugin.backup.h.g(this.eiX.VB(), this.eiX.VC(), dVar.bNv, dVar.ehx, dVar.ehw);
        if (b.vy().a(gVar2, 0)) {
            this.eiY.put(Integer.valueOf(gVar2.hashCode()), dVar.bNv);
            this.eja++;
            return true;
        }
        f(3, -1, "send BakChatUploadMsg");
        return false;
    }

    private boolean Vq() {
        g gVar;
        synchronized (this.lock) {
            g gVar2 = null;
            while (true) {
                int i;
                Iterator it = this.eiX.VK().iterator();
                while (it.hasNext()) {
                    g gVar3 = (g) it.next();
                    if (!this.eiZ.containsValue(gVar3.mediaId)) {
                        if (com.tencent.mm.a.e.aR(gVar3.path)) {
                            gVar = gVar3;
                            i = 0;
                        } else {
                            this.eiX.aH(gVar3.ehN);
                            i = 1;
                            gVar = gVar2;
                        }
                        if (i == 0) {
                            break;
                        }
                        gVar2 = gVar;
                    }
                }
                i = 0;
                gVar = gVar2;
                if (i == 0) {
                    break;
                }
                gVar2 = gVar;
            }
        }
        if (gVar == null) {
            return false;
        }
        k fVar = new com.tencent.mm.plugin.backup.h.f(this.eiX.VB(), this.eiX.VC(), gVar.mediaId, gVar.path, this, gVar.bNv);
        if (b.vy().a(fVar, 0)) {
            this.eiZ.put(Integer.valueOf(fVar.hashCode()), gVar.mediaId);
            this.eja++;
            return true;
        }
        f(3, -1, "send BakChatUploadMedia");
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.d("MicroMsg.BackupServer", "onGYNetEnd errType:" + i + " errCode:" + i2 + " " + kVar.getType());
        a aVar = (a) kVar;
        if (!aVar.pm(this.eiX.VC())) {
            v.d("MicroMsg.BackupServer", "scene back is old");
        } else if (kVar.getType() == 321) {
            this.efY = 0;
            if (this.eiX.VD() != 0) {
                v.e("MicroMsg.BackupServer", "onSceneEnd redundancy uploadHead");
            } else if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.backup.h.e eVar = (com.tencent.mm.plugin.backup.h.e) kVar;
                this.eiX.ik(eVar.Wx());
                this.eiX.ih(1);
                v.d("MicroMsg.BackupServer", "bakchatSvrID  " + eVar.Wx());
                ig(100);
            } else {
                v.e("MicroMsg.BackupServer", "start error  ");
                f(i, i2, "UploadHead " + str);
            }
        } else if (kVar.getType() == 322) {
            if (!(this.eiX.VJ() || this.ejf == null)) {
                this.ejf.VW();
            }
            if (i == 0 && i2 == 0) {
                v.d("MicroMsg.BackupServer", "end ok  ");
                com.tencent.mm.plugin.backup.h.f.WA();
                this.eje = 1;
                if (!this.eiX.VJ()) {
                    f.a(this.ejc, be.Nj(), 1);
                    if (this.ejf != null) {
                        this.ejf.VX();
                    }
                }
                bR(true);
                com.tencent.mm.a.e.e(new File(b.Vj()));
                b.Vi();
                return;
            }
            v.e("MicroMsg.BackupServer", "end error  ");
            this.eiX.ih(2);
            f(i, i2, "UploadEnd " + str);
        } else {
            this.eja = this.eja == 0 ? 0 : this.eja - 1;
            switch (kVar.getType()) {
                case 323:
                    synchronized (this.lock) {
                        this.eiY.remove(Integer.valueOf(kVar.hashCode()));
                    }
                    break;
                case 324:
                    synchronized (this.lock) {
                        this.eiZ.remove(Integer.valueOf(kVar.hashCode()));
                    }
                    break;
            }
            this.efY++;
            if (this.efY % 100 == 0) {
                System.gc();
                long freeMemory = Runtime.getRuntime().freeMemory() / 1000;
                long totalMemory = Runtime.getRuntime().totalMemory() / 1000;
                v.i("MicroMsg.BackupServer", "memoryInfo avail/total, dalvik[%dk, %dk, user:%dk], recoverCnt:%d", Long.valueOf(freeMemory), Long.valueOf(totalMemory), Long.valueOf(totalMemory - freeMemory), Integer.valueOf(this.efY));
            }
            if (i == 0 && i2 == 0) {
                a aVar2 = (a) kVar;
                switch (aVar2.getType()) {
                    case 323:
                        synchronized (this.lock) {
                            String str2 = ((com.tencent.mm.plugin.backup.h.g) aVar2).bNv;
                            this.eiX.pk(str2);
                            this.eiX.bm(be.a((Integer) this.ejb.get(str2), 0) + this.eiX.VQ(), this.ejc);
                        }
                        break;
                    case 324:
                        synchronized (this.lock) {
                            com.tencent.mm.plugin.backup.h.f fVar = (com.tencent.mm.plugin.backup.h.f) aVar2;
                            this.eiX.pj(fVar.mediaId);
                            String str3 = fVar.emz;
                            this.ejb.put(str3, Integer.valueOf(aVar2.Wz() + be.a((Integer) this.ejb.get(str3), 0)));
                        }
                        break;
                }
                Vo();
                v.d("MicroMsg.BackupServer", "bckMsgList: " + this.eiX.VL().size() + " mediaList : " + this.eiX.VK().size());
                if (kVar.getType() == 323 && this.ejf != null) {
                    this.ejd = aVar.Wy() + this.ejd;
                    if (!this.eiX.VJ() && this.ejf != null) {
                        this.ejf.VW();
                        return;
                    }
                    return;
                }
                return;
            }
            f(i, i2, str);
        }
    }

    private void f(int i, int i2, String str) {
        if (i == 3 && i2 == 9999) {
            v.i("MicroMsg.BackupServer", "dealWithErrType pause err ignore");
            return;
        }
        if (!this.eiX.VJ()) {
            this.eje = 2;
            v.f("MicroMsg.BackupServer", i + ", " + i2 + " " + str);
            com.tencent.mm.plugin.report.service.g.iuh.Y(10341, "1," + i + "/" + i2 + "/" + str);
            f.Vs();
            if (this.ejf != null) {
                this.ejf.VZ();
            }
        }
        com.tencent.mm.plugin.backup.h.f.pause();
        this.eiX.VR();
    }

    public final void a(int i, int i2, k kVar) {
        if (kVar.getType() == 324) {
            a aVar = (a) kVar;
            if (aVar.pm(this.eiX.VC())) {
                this.ejd += aVar.Wy();
                if (!this.eiX.VJ() && this.ejf != null) {
                    this.ejf.VW();
                    return;
                }
                return;
            }
            v.d("MicroMsg.BackupServer", "scene back is old");
        }
    }
}
