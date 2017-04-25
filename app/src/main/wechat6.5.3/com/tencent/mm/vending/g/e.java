package com.tencent.mm.vending.g;

import android.os.Looper;
import android.util.Pair;
import com.tencent.mm.vending.h.f;
import com.tencent.mm.vending.h.g;
import com.tencent.mm.vending.h.h;
import com.tencent.mm.vending.j.k;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import junit.framework.Assert;

public class e<_Var> implements c<_Var> {
    int aKy = 0;
    f pgV = new f(this.phl, this.pht);
    Object phA;
    private volatile boolean phh = false;
    volatile int phi = d.phL;
    Queue<a> phj = new LinkedList();
    private volatile com.tencent.mm.vending.h.d phk = this.phl;
    private volatile com.tencent.mm.vending.h.d phl = g.bKQ();
    volatile Object phm;
    volatile Object phn;
    a pho;
    private long php = -1;
    private boolean phq = false;
    b phr = new b(this);
    private com.tencent.mm.vending.h.d phs;
    private com.tencent.mm.vending.h.f.a pht = new com.tencent.mm.vending.h.f.a(this) {
        final /* synthetic */ e phB;

        {
            this.phB = r1;
        }

        public final void bKM() {
            f bKN = f.bKN();
            bKN.phU.set(this.phB);
        }

        public final void bq(Object obj) {
            f.bKN().phU.remove();
            synchronized (this.phB) {
                a aVar = this.phB.pho;
                this.phB.pho = null;
                if (this.phB.phi == d.phQ) {
                    return;
                }
                if (this.phB.phi == d.phP) {
                    e eVar = this.phB;
                    eVar.aKy++;
                    com.tencent.mm.vending.f.a.i("Vending.Pipeline", "Functional %s, gonna retry %s.", aVar.phI.toString(), Integer.valueOf(this.phB.aKy));
                    ((LinkedList) this.phB.phj).add(0, aVar);
                } else if (this.phB.phn != null) {
                    this.phB.phm = this.phB.phn;
                    this.phB.phn = null;
                } else {
                    this.phB.phm = obj;
                }
                if (this.phB.phi == d.phO) {
                    return;
                }
                this.phB.phi = d.phM;
                this.phB.bp(this.phB.phm);
            }
        }

        public final void interrupt() {
            this.phB.kt(true);
        }
    };
    List<Pair<com.tencent.mm.vending.g.d.a, com.tencent.mm.vending.h.d>> phu;
    private List<Pair<com.tencent.mm.vending.g.d.b, com.tencent.mm.vending.h.d>> phv;
    private boolean phw = false;
    boolean phx = false;
    private boolean phy = false;
    private Object phz;

    private static class a {
        public com.tencent.mm.vending.h.d aQW;
        public com.tencent.mm.vending.c.a phI;
        public long phJ;
        public boolean phK;

        public a(com.tencent.mm.vending.c.a aVar, com.tencent.mm.vending.h.d dVar, long j, boolean z) {
            this.phI = aVar;
            this.aQW = dVar;
            this.phJ = j;
            this.phK = z;
        }
    }

    public static class c extends Error {
        public c(String str, Object... objArr) {
            super(String.format(str, objArr));
        }
    }

    private enum d {
        ;

        static {
            phL = 1;
            phM = 2;
            phN = 3;
            phO = 4;
            phP = 5;
            phQ = 6;
            phR = 7;
            phS = new int[]{phL, phM, phN, phO, phP, phQ, phR};
        }
    }

    class b implements b {
        final /* synthetic */ e phB;

        b(e eVar) {
            this.phB = eVar;
        }

        public final void bo(Object obj) {
            synchronized (this.phB) {
                if (this.phB.phi == d.phQ) {
                    return;
                }
                this.phB.kt(false);
                this.phB.phx = true;
                this.phB.phA = obj;
                if (this.phB.phu != null) {
                    for (Pair a : this.phB.phu) {
                        this.phB.a(a, obj);
                    }
                }
            }
        }

        public final void bKI() {
            synchronized (this.phB) {
                synchronized (this.phB) {
                    if (this.phB.phi == d.phQ || this.phB.phi == d.phL) {
                    } else {
                        this.phB.phi = d.phO;
                    }
                }
            }
        }

        public final void r(Object... objArr) {
            synchronized (this.phB) {
                if (this.phB.phi != d.phO) {
                    return;
                }
                e eVar = this.phB;
                Object s = objArr.length == 0 ? null : objArr.length == 1 ? objArr[0] : k.s(objArr);
                eVar.phn = s;
                resume();
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void resume() {
            /*
            r3 = this;
            r1 = r3.phB;
            monitor-enter(r1);
            r0 = r3.phB;	 Catch:{ all -> 0x0023 }
            r0 = r0.phi;	 Catch:{ all -> 0x0023 }
            r2 = com.tencent.mm.vending.g.e.d.phO;	 Catch:{ all -> 0x0023 }
            if (r0 == r2) goto L_0x000d;
        L_0x000b:
            monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        L_0x000c:
            return;
        L_0x000d:
            r0 = r3.phB;	 Catch:{ all -> 0x0023 }
            r0 = r0.pho;	 Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x0026;
        L_0x0013:
            r0 = r3.phB;	 Catch:{ all -> 0x0023 }
            r0 = r0.pho;	 Catch:{ all -> 0x0023 }
            r2 = r3.phB;	 Catch:{ all -> 0x0023 }
            r2 = r2.phj;	 Catch:{ all -> 0x0023 }
            r2 = r2.peek();	 Catch:{ all -> 0x0023 }
            if (r0 != r2) goto L_0x0026;
        L_0x0021:
            monitor-exit(r1);	 Catch:{ all -> 0x0023 }
            goto L_0x000c;
        L_0x0023:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0023 }
            throw r0;
        L_0x0026:
            r0 = r3.phB;	 Catch:{ all -> 0x0023 }
            r2 = com.tencent.mm.vending.g.e.d.phM;	 Catch:{ all -> 0x0023 }
            r0.phi = r2;	 Catch:{ all -> 0x0023 }
            r0 = r3.phB;	 Catch:{ all -> 0x0023 }
            r0 = r0.phr;	 Catch:{ all -> 0x0023 }
            r2 = com.tencent.mm.vending.g.g.bKJ();	 Catch:{ all -> 0x0023 }
            if (r0 == r2) goto L_0x0052;
        L_0x0036:
            r0 = r3.phB;	 Catch:{ all -> 0x0023 }
            r0 = r0.phn;	 Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x0049;
        L_0x003c:
            r0 = r3.phB;	 Catch:{ all -> 0x0023 }
            r2 = r3.phB;	 Catch:{ all -> 0x0023 }
            r2 = r2.phn;	 Catch:{ all -> 0x0023 }
            r0.phm = r2;	 Catch:{ all -> 0x0023 }
            r0 = r3.phB;	 Catch:{ all -> 0x0023 }
            r2 = 0;
            r0.phn = r2;	 Catch:{ all -> 0x0023 }
        L_0x0049:
            r0 = r3.phB;	 Catch:{ all -> 0x0023 }
            r2 = r3.phB;	 Catch:{ all -> 0x0023 }
            r2 = r2.phm;	 Catch:{ all -> 0x0023 }
            r0.bp(r2);	 Catch:{ all -> 0x0023 }
        L_0x0052:
            monitor-exit(r1);	 Catch:{ all -> 0x0023 }
            goto L_0x000c;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.vending.g.e.b.resume():void");
        }
    }

    public c<_Var> lS(String str) {
        if (str == null) {
            Assert.assertNotNull("schedulerTypeString should not be null!", str);
        } else {
            this.phk = g.PN(str);
            Assert.assertNotNull("mCurrentScheduler should not be null!", this.phk);
        }
        return this;
    }

    public c<_Var> b(com.tencent.mm.vending.h.d dVar) {
        if (dVar == null) {
            Assert.assertNotNull("scheduler should not be null!", dVar);
        } else {
            this.phk = dVar;
        }
        return this;
    }

    public c<_Var> b(com.tencent.mm.vending.e.b bVar) {
        Assert.assertNotNull("keeper should not be null!", bVar);
        bVar.a(this);
        return this;
    }

    public c<_Var> bp(boolean z) {
        this.phq = z;
        return this;
    }

    public synchronized c<_Var> b(final com.tencent.mm.vending.g.c.a<_Var> aVar) {
        g(new Object[0]);
        a(new com.tencent.mm.vending.c.a<_Var, _Var>(this) {
            final /* synthetic */ e phB;

            public final _Var aq(_Var _Var) {
                return aVar.call();
            }
        }, true);
        return this;
    }

    public synchronized c<_Var> g(Object... objArr) {
        c<_Var> cVar;
        if (this.phi != d.phL) {
            cVar = this;
        } else {
            this.phi = d.phM;
            Object s = objArr.length == 0 ? null : objArr.length == 1 ? objArr[0] : k.s(objArr);
            this.phm = s;
            bp(this.phm);
            s = this;
        }
        return cVar;
    }

    public void dead() {
        kt(true);
    }

    public final b bKJ() {
        return this.phr;
    }

    public <_Ret> c<_Ret> e(com.tencent.mm.vending.c.a<_Ret, _Var> aVar) {
        return lS("Vending.UI").c(aVar);
    }

    public <_Ret> c<_Ret> d(com.tencent.mm.vending.c.a<_Ret, _Var> aVar) {
        return lS("Vending.LOGIC").c(aVar);
    }

    private synchronized <_Ret> c<_Ret> a(com.tencent.mm.vending.c.a<_Ret, _Var> aVar, boolean z) {
        c<_Ret> cVar;
        bKL();
        this.phj.add(new a(aVar, this.phk, this.php, z));
        this.php = -1;
        if (this.phi == d.phL) {
            cVar = this;
        } else if (this.phi != d.phM) {
            r0 = this;
        } else {
            bp(this.phm);
            r0 = this;
        }
        return cVar;
    }

    public synchronized <_Ret> c<_Ret> c(com.tencent.mm.vending.c.a<_Ret, _Var> aVar) {
        return a((com.tencent.mm.vending.c.a) aVar, this.phq);
    }

    private synchronized void bKL() {
        if (this.phh) {
            throw new c("This Pipeline(%s) has terminate and do not allow any next().", this);
        }
    }

    final synchronized void a(final Pair<com.tencent.mm.vending.g.d.a, com.tencent.mm.vending.h.d> pair, final Object obj) {
        com.tencent.mm.vending.h.d dVar = (com.tencent.mm.vending.h.d) pair.second;
        Runnable anonymousClass3 = new Runnable(this) {
            final /* synthetic */ e phB;

            public final void run() {
                ((com.tencent.mm.vending.g.d.a) pair.first).aA(obj);
            }
        };
        if (dVar == null) {
            com.tencent.mm.vending.f.a.e("Vending.Pipeline", "Default scheduler %s is not available!!!", this.phl);
        }
        dVar.g(anonymousClass3);
    }

    private synchronized void b(final Pair<com.tencent.mm.vending.g.d.b, com.tencent.mm.vending.h.d> pair, final Object obj) {
        new f((com.tencent.mm.vending.h.d) pair.second, null).a(new com.tencent.mm.vending.c.a<Void, Void>(this) {
            final /* synthetic */ e phB;

            public final /* synthetic */ Object aq(Object obj) {
                ((com.tencent.mm.vending.g.d.b) pair.first).ap(obj);
                return phb;
            }
        }, null, this.phq);
    }

    private synchronized void a(com.tencent.mm.vending.g.d.a aVar, com.tencent.mm.vending.h.d dVar) {
        bKK();
        if (this.phu == null) {
            this.phu = new LinkedList();
        }
        Pair pair = new Pair(aVar, dVar);
        if (this.phx) {
            a(pair, this.phA);
        } else {
            this.phu.add(pair);
        }
    }

    private synchronized void a(com.tencent.mm.vending.g.d.b bVar, com.tencent.mm.vending.h.d dVar) {
        bKK();
        bp(this.phm);
        if (this.phv == null) {
            this.phv = new LinkedList();
        }
        Pair pair = new Pair(bVar, dVar);
        if (this.phw) {
            b(pair, this.phz);
        } else {
            this.phv.add(pair);
        }
    }

    public final synchronized d<_Var> bKK() {
        this.phh = true;
        return this;
    }

    public final synchronized d<_Var> a(com.tencent.mm.vending.g.d.a aVar) {
        a(aVar, this.phl);
        return this;
    }

    public final synchronized d<_Var> a(com.tencent.mm.vending.g.d.b<_Var> bVar) {
        a((com.tencent.mm.vending.g.d.b) bVar, this.phl);
        return this;
    }

    final synchronized void kt(boolean z) {
        if (!(this.phi == d.phQ || this.phi == d.phR)) {
            if (z) {
                if (this.phj.size() > 0) {
                    com.tencent.mm.vending.f.a.w("Vending.Pipeline", "Pipe is not finish and be interrupt! %s pipes did not run", Integer.valueOf(this.phj.size()));
                }
            }
            this.phi = d.phQ;
            this.phj.clear();
            this.phm = null;
            if (this.phs != null) {
                this.phs.cancel();
            }
        }
    }

    final synchronized void bp(final Object obj) {
        if (this.phi == d.phM) {
            this.phi = d.phN;
            a aVar = (a) this.phj.peek();
            if (aVar != null) {
                final com.tencent.mm.vending.c.a aVar2 = aVar.phI;
                com.tencent.mm.vending.h.d dVar = aVar.aQW;
                long j = aVar.phJ;
                final boolean z = aVar.phK;
                if (this.phi == d.phO) {
                    com.tencent.mm.vending.f.a.i("Vending.Pipeline", "This pipeline is Pausing. We will stop dequeFunctionAndInvoke and waiting resume() call", new Object[0]);
                } else {
                    this.pho = (a) this.phj.poll();
                    this.pgV.c(dVar);
                    if (j < 0) {
                        this.pgV.a(aVar2, obj, z);
                    } else {
                        if (Looper.myLooper() == null) {
                            this.phs = new com.tencent.mm.vending.h.c();
                        } else {
                            this.phs = new h(Looper.myLooper(), Looper.myLooper().toString());
                        }
                        this.phs.d(new Runnable(this) {
                            final /* synthetic */ e phB;

                            public final void run() {
                                this.phB.pgV.a(aVar2, obj, z);
                            }
                        }, j);
                    }
                }
            } else if (this.phh) {
                this.phi = d.phR;
                this.phw = true;
                this.phz = obj;
                if (this.phv != null) {
                    for (Pair b : this.phv) {
                        b(b, this.phz);
                    }
                }
            } else {
                this.phi = d.phM;
            }
        }
    }
}
