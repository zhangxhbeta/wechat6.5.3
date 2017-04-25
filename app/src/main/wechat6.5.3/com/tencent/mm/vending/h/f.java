package com.tencent.mm.vending.h;

public final class f {
    private volatile d phk;
    volatile a pht;

    public interface a {
        void bKM();

        void bq(Object obj);

        void interrupt();
    }

    public f(d dVar, a aVar) {
        c(dVar);
        this.pht = aVar;
    }

    public final synchronized void c(d dVar) {
        d(dVar);
    }

    private synchronized void d(d dVar) {
        this.phk = dVar;
    }

    private synchronized void a(final com.tencent.mm.vending.c.a aVar, final Object obj, long j, boolean z) {
        d PN;
        Runnable anonymousClass1;
        d dVar = this.phk;
        if (aVar instanceof e) {
            e eVar = (e) aVar;
            if (!"Vending.ANY".equals(eVar.Ns())) {
                PN = g.PN(eVar.Ns());
                if (PN == null) {
                    anonymousClass1 = new Runnable(this) {
                        final /* synthetic */ f pia;

                        public final void run() {
                            if (this.pia.pht != null) {
                                this.pia.pht.bKM();
                            }
                            Object aq = aVar.aq(obj);
                            if (this.pia.pht != null) {
                                this.pia.pht.bq(aq);
                            }
                        }
                    };
                    if (-1 < 0) {
                        PN.d(anonymousClass1, -1);
                    } else if (z || g.bKQ() != PN) {
                        PN.g(anonymousClass1);
                    } else {
                        anonymousClass1.run();
                    }
                } else if (this.pht != null) {
                    this.pht.interrupt();
                }
            }
        }
        PN = dVar;
        if (PN == null) {
            anonymousClass1 = /* anonymous class already generated */;
            if (-1 < 0) {
                PN.d(anonymousClass1, -1);
            } else {
                if (z) {
                }
                PN.g(anonymousClass1);
            }
        } else if (this.pht != null) {
            this.pht.interrupt();
        }
    }

    public final void a(com.tencent.mm.vending.c.a aVar, Object obj, boolean z) {
        a(aVar, obj, -1, z);
    }
}
