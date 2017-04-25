package com.tencent.mm.plugin.backup.g;

import android.os.Looper;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.backup.f.h;
import com.tencent.mm.plugin.backup.h.b;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.i.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.dx;
import com.tencent.mm.protocal.c.dy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.f;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class x implements e, f {
    private static int eiV = 15;
    private final ac cnC = new ac(Looper.getMainLooper());
    private int dgC = 0;
    private int efY = 0;
    u eiW;
    private HashMap<Integer, String> ejP = new HashMap();
    h ejQ = new h();
    private int ejR = 0;
    private int ejS = 0;
    private long ejT = 0;
    private int eje = 0;
    public m ejf = null;
    private boolean ejg = false;
    private Object lock = new Object();

    static /* synthetic */ int a(x xVar, int i) {
        int i2 = xVar.ejR + i;
        xVar.ejR = i2;
        return i2;
    }

    static /* synthetic */ void a(x xVar) {
        xVar.efY = 0;
        xVar.ejS = xVar.ejQ.getItemCount();
        v.i("MicroMsg.RecoverServer", "all msg item Count : " + xVar.ejS);
        f.aF(be.Nj());
        final long currentTimeMillis = System.currentTimeMillis();
        v.i("MicroMsg.RecoverServer", "net finish time: " + (currentTimeMillis - xVar.ejT));
        v.d("MicroMsg.RecoverServer", "readFromSdcard start");
        xVar.eiW = new u(xVar) {
            final /* synthetic */ x ejU;

            public final void run() {
                h.reset();
                h.UI();
                y yVar = new y();
                yVar.begin();
                HashMap hashMap = new HashMap();
                HashSet hashSet = new HashSet();
                for (String str : this.ejU.ejQ.VG()) {
                    if (Wa()) {
                        yVar.end();
                        return;
                    }
                    try {
                        int a = this.ejU.a(str, hashMap, yVar, hashSet);
                        if (a < 0) {
                            yVar.end();
                            v.w("MicroMsg.RecoverServer", "Thread has been killed");
                            return;
                        }
                        x.a(this.ejU, a);
                        v.i("MicroMsg.RecoverServer", "recover %d has done", Integer.valueOf(this.ejU.ejR));
                        this.ejU.cnC.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass2 ejW;

                            {
                                this.ejW = r1;
                            }

                            public final void run() {
                                boolean z = false;
                                if (this.ejW.ejU.ejQ.VJ() || this.ejW.ejU.ejf == null) {
                                    String str = "MicroMsg.RecoverServer";
                                    String str2 = "onRecordFinish failed: isPause:%b, cb is isNull:%b";
                                    Object[] objArr = new Object[2];
                                    objArr[0] = Boolean.valueOf(this.ejW.ejU.ejQ.VJ());
                                    if (this.ejW.ejU.ejf == null) {
                                        z = true;
                                    }
                                    objArr[1] = Boolean.valueOf(z);
                                    v.w(str, str2, objArr);
                                    return;
                                }
                                v.d("MicroMsg.RecoverServer", "read recover finish : ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            }
                        });
                    } catch (Throwable e) {
                        v.e("MicroMsg.RecoverServer", "Thread.run err:" + e.toString());
                        v.a("MicroMsg.RecoverServer", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                        v.f("MicroMsg.RecoverServer", "recoverFromSdcard MMThread.run() " + e.toString());
                    }
                }
                a.b(hashMap);
                yVar.end();
                v.i("MicroMsg.RecoverServer", "build temDB finish!");
                v.bta();
                b.h(new Runnable(this) {
                    final /* synthetic */ AnonymousClass2 ejW;

                    {
                        this.ejW = r1;
                    }

                    public final void run() {
                        v.i("MicroMsg.RecoverServer", "readFromSdcard end");
                        v.bta();
                        this.ejW.ejU.eje = 1;
                        f.c(be.Nj(), 1, this.ejW.ejU.ejQ.VI());
                        if (this.ejW.ejU.ejf != null) {
                            this.ejW.ejU.ejf.VY();
                        }
                        this.ejW.ejU.bR(true);
                        b.Vh().Wb();
                    }
                });
            }
        };
        xVar.eiW.setPriority(1);
        xVar.eiW.start();
    }

    public final void bR(boolean z) {
        this.ejg = false;
        b.vy().b(326, (e) this);
        b.vy().b(327, (e) this);
        for (Integer intValue : this.ejP.keySet()) {
            b.vy().cancel(intValue.intValue());
        }
        this.ejP.clear();
        this.dgC = 0;
        this.ejR = 0;
        this.ejS = 0;
        this.ejQ.bS(true);
        if (this.eiW != null) {
            v.i("MicroMsg.RecoverServer", "cancelBak kill thread");
            synchronized (this.lock) {
                this.eiW.kill();
            }
        }
        if (z) {
            this.ejQ.reset();
        }
    }

    private int a(String str, HashMap<String, Integer> hashMap, y yVar, HashSet<String> hashSet) {
        long currentTimeMillis = System.currentTimeMillis();
        byte[] d = com.tencent.mm.a.e.d(str, 0, -1);
        try {
            dy dyVar = (dy) new dy().az(d);
            Iterator it = dyVar.eeu.iterator();
            while (it.hasNext()) {
                dx dxVar = (dx) it.next();
                if (this.eiW.Wa()) {
                    return -1;
                }
                if (this.ejQ.VJ()) {
                    synchronized (this.lock) {
                        try {
                            this.lock.wait();
                        } catch (InterruptedException e) {
                            return -1;
                        }
                    }
                }
                try {
                    w.a(dxVar, hashMap, hashSet);
                    this.efY++;
                    if (this.efY % 100 == 0) {
                        UG();
                    }
                } catch (Throwable e2) {
                    v.e("MicroMsg.RecoverServer", "readFromSdcard err:" + e2.toString());
                    v.a("MicroMsg.RecoverServer", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
                h.ie(dxVar.efm);
                yVar.Wd();
            }
            h.UH();
            v.d("MicroMsg.RecoverServer", "read item time " + (System.currentTimeMillis() - currentTimeMillis));
            return dyVar.eeu.size();
        } catch (Throwable e3) {
            Throwable th = e3;
            String str2 = "MicroMsg.RecoverServer";
            String str3 = "read mmPath errr %s, %s, len:%d";
            Object[] objArr = new Object[3];
            objArr[0] = str;
            objArr[1] = th;
            objArr[2] = Integer.valueOf(d == null ? 0 : d.length);
            v.e(str2, str3, objArr);
            v.a("MicroMsg.RecoverServer", th, SQLiteDatabase.KeyEmpty, new Object[0]);
            return 0;
        }
    }

    private void Wc() {
        if (be.kS(this.ejQ.VC())) {
            v.d("MicroMsg.RecoverServer", "checkDownLoadData break  ");
        } else if (this.ejQ.VJ()) {
            v.d("MicroMsg.RecoverServer", "checkDownLoadData has paused");
        } else if (!q.dpV) {
            v.i("MicroMsg.RecoverServer", "checkDownLoadData dataItemIdList.size: " + this.ejQ.VF().size() + "  downloadingMap.size: " + this.ejP.size());
            if (this.ejQ.VF().isEmpty()) {
                v.d("MicroMsg.RecoverServer", "dataItemIdList is empty");
                if (this.ejQ.VE() == -1) {
                    this.ejQ.ii(0);
                    if (this.ejQ.VD() == 1) {
                        this.ejQ.ih(2);
                    } else if (this.ejQ.VD() == 2) {
                        this.ejQ.ih(3);
                    }
                }
                if (this.ejQ.VD() == 1 || this.ejQ.VD() == 2) {
                    if (!b.vy().a(new c(this.ejQ.VB(), this.ejQ.VC(), this.ejQ.VE(), this.ejQ.VD()), 0)) {
                        f(3, -1, " send RecoverHead");
                    }
                } else if (this.ejQ.VD() == 3) {
                    v.d("MicroMsg.RecoverServer", "recover downLoad finish");
                    b.WA();
                    if (this.ejf != null) {
                        m mVar = this.ejf;
                        this.ejQ.VI();
                        this.ejQ.VI();
                        mVar.VW();
                        this.ejf.VX();
                    }
                } else if (this.eiW == null || !this.eiW.isAlive()) {
                    if (this.ejf != null) {
                        this.ejf.VX();
                    }
                } else if (!this.ejQ.VJ()) {
                    synchronized (this.lock) {
                        this.lock.notify();
                    }
                }
            } else if (this.ejP.size() <= eiV) {
                for (String str : this.ejQ.VF()) {
                    if (!this.ejP.containsValue(str)) {
                        k bVar = new b(this.ejQ.VB(), this.ejQ.VC(), str, this.ejQ.VD(), b.Vj(), this);
                        if (b.vy().a(bVar, 0)) {
                            int hashCode = bVar.hashCode();
                            v.d("MicroMsg.RecoverServer", "downloadingMap put:" + hashCode + ":" + str + "  now size:" + this.ejP.size() + " isContain:" + this.ejP.containsKey(Integer.valueOf(hashCode)));
                            this.ejP.put(Integer.valueOf(hashCode), str);
                            if (this.ejP.size() > eiV) {
                                return;
                            }
                        } else {
                            v.e("MicroMsg.RecoverServer", "checkDownLoadData doScene RecoverData failed");
                            f(3, -1, "send RecoverData");
                            return;
                        }
                    }
                }
            }
        } else if (this.eiW != null && this.eiW.isAlive() && !this.ejQ.VJ()) {
            synchronized (this.lock) {
                this.lock.notify();
            }
        } else if (this.ejQ.VD() == 4) {
            v.w("MicroMsg.RecoverServer", "recoverFromSdcard is recovering");
        } else {
            this.ejQ.ih(4);
            this.ejQ.bS(false);
            b.a(new b.a(this) {
                final /* synthetic */ x ejU;

                {
                    this.ejU = r1;
                }

                public final void run() {
                    x.a(this.ejU);
                }
            }, false);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.RecoverServer", "onSceneEnd errType:" + i + " errCode:" + i2);
        if (((com.tencent.mm.plugin.backup.h.a) kVar).pm(this.ejQ.VC())) {
            if (kVar.getType() == 327) {
                int hashCode = kVar.hashCode();
                v.d("MicroMsg.RecoverServer", "downloadingMap remove:" + hashCode);
                this.ejP.remove(Integer.valueOf(hashCode));
            }
            if (i != 0 || i2 != 0) {
                f(i, i2, "sceneType" + kVar.getType() + " " + str);
                return;
            } else if (kVar.getType() == 326) {
                c cVar = (c) kVar;
                if (cVar.aKG != this.ejQ.VD()) {
                    v.w("MicroMsg.RecoverServer", "%d type is not the same with stateMode", Integer.valueOf(cVar.aKG));
                    return;
                }
                Iterator it = cVar.emu.iterator();
                while (it.hasNext()) {
                    arf com_tencent_mm_protocal_c_arf = (arf) it.next();
                    this.ejQ.pg(com_tencent_mm_protocal_c_arf.mQy);
                    if (this.ejQ.VD() == 1) {
                        this.ejQ.pi(b.Vj() + "mmbakItem/" + g.pd(com_tencent_mm_protocal_c_arf.mQy) + com_tencent_mm_protocal_c_arf.mQy);
                    }
                }
                v.d("MicroMsg.RecoverServer", "headIndex: " + this.ejQ.VE());
                if (cVar.endFlag == 0) {
                    this.ejQ.ii(cVar.index);
                    Wc();
                    return;
                }
                this.ejQ.ii(-1);
                Wc();
                return;
            } else if (kVar.getType() == 327) {
                b bVar = (b) kVar;
                this.ejQ.ph(bVar.bNv);
                this.ejQ.ij(this.ejQ.VH() + bVar.Wz());
                v.i("MicroMsg.RecoverServer", "dataItemIdList : " + this.ejQ.VF().size() + " downloadingMap:" + this.ejP.size());
                Wc();
                this.efY++;
                if (this.efY % 100 == 0) {
                    UG();
                    return;
                }
                return;
            } else {
                return;
            }
        }
        v.d("MicroMsg.RecoverServer", "scene back is old, this.bakChatClientId:" + this.ejQ.VC());
    }

    private void f(int i, int i2, String str) {
        if (i == 3 && i2 == 9999) {
            v.i("MicroMsg.RecoverServer", "dealWithErrType pause err ignore");
            return;
        }
        if (!(this.ejQ.VJ() || this.ejf == null)) {
            this.eje = 2;
            g.iuh.Y(10341, "2," + i + "/" + i2 + "/" + str);
            v.f("MicroMsg.RecoverServer", i + ", " + i2 + " " + str);
            f.Vu();
            if (this.ejf != null) {
                this.ejf.VZ();
            }
        }
        b.pause();
        this.ejQ.bS(true);
    }

    public final void a(int i, int i2, k kVar) {
        if (kVar.getType() == 327) {
            com.tencent.mm.plugin.backup.h.a aVar = (com.tencent.mm.plugin.backup.h.a) kVar;
            if (aVar.pm(this.ejQ.VC())) {
                this.dgC += aVar.Wy();
                if (this.ejf != null && !this.ejQ.VJ()) {
                    m mVar = this.ejf;
                    this.ejQ.VI();
                    mVar.VW();
                    return;
                }
                return;
            }
            v.d("MicroMsg.RecoverServer", "scene back is old");
        }
    }

    private void UG() {
        System.gc();
        long freeMemory = Runtime.getRuntime().freeMemory() / 1000;
        long totalMemory = Runtime.getRuntime().totalMemory() / 1000;
        v.i("MicroMsg.RecoverServer", "memoryInfo avail/total, dalvik[%dk, %dk, user:%dk], recoverCnt:%d", Long.valueOf(freeMemory), Long.valueOf(totalMemory), Long.valueOf(totalMemory - freeMemory), Integer.valueOf(this.efY));
    }
}
