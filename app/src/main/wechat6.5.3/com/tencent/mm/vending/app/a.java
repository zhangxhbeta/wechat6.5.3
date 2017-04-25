package com.tencent.mm.vending.app;

import android.content.Context;
import android.os.Looper;
import com.tencent.mm.vending.base.Vending;
import com.tencent.mm.vending.base.Vending.h;
import com.tencent.mm.vending.e.c;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.d;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import junit.framework.Assert;

public abstract class a implements com.tencent.mm.vending.e.b {
    Context mContext;
    private c pfZ = new c();
    public c<Vending> pga = new c();
    Map<Class, a> pgb = new ConcurrentHashMap();
    byte[] pgc = new byte[0];
    com.tencent.mm.vending.base.a<Object> pgd = new com.tencent.mm.vending.base.a<Object>(this) {
        final /* synthetic */ a pgi;

        {
            this.pgi = r1;
        }

        protected final /* synthetic */ Object resolveAsynchronous(Object obj) {
            return v((Class) obj);
        }

        protected final Object v(Class<?> cls) {
            a aVar = (a) this.pgi.pgb.get(cls);
            if (aVar != null) {
                aVar.pgk = true;
                Object NB = aVar.NB();
                aVar.pgk = false;
                if (!aVar.pgj) {
                    return NB;
                }
                aVar.pgl = defer(cls);
            }
            return null;
        }
    };
    private AtomicBoolean pge = new AtomicBoolean(false);
    boolean pgf = false;
    Map<Class, com.tencent.mm.vending.b.c<b>> pgg = new HashMap();
    public com.tencent.mm.vending.d.a pgh;

    public abstract class a<_Struct> {
        final /* synthetic */ a pgi;
        boolean pgj = false;
        boolean pgk = false;
        h pgl;

        public abstract _Struct NB();

        public a(a aVar) {
            this.pgi = aVar;
        }
    }

    public interface b<_Struct> {
        void aB(_Struct _Struct);
    }

    public a() {
        this.pga.a(this.pgd);
        this.pgd.addVendingDataResolvedCallback(new com.tencent.mm.vending.base.a.a(this) {
            final /* synthetic */ a pgi;

            {
                this.pgi = r1;
            }

            public final /* synthetic */ void bm(Object obj) {
                Class cls = (Class) obj;
                com.tencent.mm.vending.b.c cVar = (com.tencent.mm.vending.b.c) this.pgi.pgg.get(cls);
                if (cVar != null) {
                    cVar.a(g.bs(this.pgi.pgd.get(cls)));
                }
            }
        });
    }

    public final void a(com.tencent.mm.vending.e.a aVar) {
        Assert.assertTrue("target must be a ILifeCycle", aVar instanceof com.tencent.mm.vending.e.a);
        this.pfZ.a(aVar);
    }

    public final <_Struct> void a(Class<_Struct> cls, b<_Struct> bVar) {
        com.tencent.mm.vending.b.c cVar = (com.tencent.mm.vending.b.c) this.pgg.get(cls);
        if (cVar == null) {
            cVar = new com.tencent.mm.vending.b.c<b>(this, d.phX) {
                final /* synthetic */ a pgi;

                public final /* synthetic */ void a(Object obj, com.tencent.mm.vending.j.a aVar) {
                    ((b) obj).aB(aVar.get(0));
                }
            };
            this.pgg.put(cls, cVar);
        }
        cVar.ay(bVar);
        Object peek = this.pgd.peek(cls);
        if (peek != null) {
            bVar.aB(peek);
        }
    }

    public final <_Struct> _Struct t(Class<_Struct> cls) {
        bKy();
        if (!this.pgf) {
            synchronized (this.pgc) {
                if (!this.pgf) {
                    try {
                        this.pgc.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
        return this.pgd.get(cls);
    }

    public final void u(Class<?> cls) {
        bKy();
        this.pgd.request(cls);
    }

    public final <_Struct> void a(Class<_Struct> cls, a<_Struct> aVar) {
        bKy();
        this.pgb.put(cls, aVar);
    }

    private void bKy() {
        if (Looper.myLooper() == this.pgd.getLooper() && !this.pge.get()) {
            com.tencent.mm.vending.f.a.e("Vending.Interactor", "This interactor has not call onCreate() yet! Interactor : %s", new Object[]{this});
        }
    }

    public void onCreate() {
        this.pge.set(true);
    }

    public void onDestroy() {
        this.pfZ.dead();
        this.pga.dead();
    }
}
