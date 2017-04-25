package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.AnalyticsReceiver;
import com.google.android.gms.analytics.AnalyticsService;
import com.google.android.gms.c.ah;
import com.google.android.gms.common.internal.w;

public final class m extends o {
    final w agu;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ boolean agv;
        final /* synthetic */ m agw;

        AnonymousClass1(m mVar, boolean z) {
            this.agw = mVar;
            this.agv = z;
        }

        public final void run() {
            this.agw.agu.is();
        }
    }

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ m agw;
        final /* synthetic */ String agx;
        final /* synthetic */ Runnable agy;

        public AnonymousClass2(m mVar, String str, Runnable runnable) {
            this.agw = mVar;
            this.agx = str;
            this.agy = runnable;
        }

        public final void run() {
            this.agw.agu.L(this.agx);
            if (this.agy != null) {
                this.agy.run();
            }
        }
    }

    public m(q qVar, r rVar) {
        super(qVar);
        w.Z(rVar);
        this.agu = rVar.c(qVar);
    }

    public final long a(s sVar) {
        hX();
        w.Z(sVar);
        q.if();
        long d = this.agu.d(sVar);
        if (d == 0) {
            this.agu.c(sVar);
        }
        return d;
    }

    public final void a(final ah ahVar) {
        hX();
        this.afY.ia().c(new Runnable(this) {
            final /* synthetic */ m agw;

            public final void run() {
                this.agw.agu.b(ahVar);
            }
        });
    }

    public final void c(final c cVar) {
        w.Z(cVar);
        hX();
        e("Hit delivery requested", cVar);
        this.afY.ia().c(new Runnable(this) {
            final /* synthetic */ m agw;

            public final void run() {
                this.agw.agu.c(cVar);
            }
        });
    }

    public final void hQ() {
        hX();
        Context context = this.afY.mContext;
        if (AnalyticsReceiver.r(context) && AnalyticsService.s(context)) {
            Intent intent = new Intent(context, AnalyticsService.class);
            intent.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            context.startService(intent);
            return;
        }
        a(null);
    }

    public final void hR() {
        hX();
        ah.if();
        this.agu.hR();
    }

    final void hS() {
        q.if();
        this.agu.hS();
    }

    protected final void hm() {
        this.agu.hY();
    }

    final void onServiceConnected() {
        q.if();
        this.agu.onServiceConnected();
    }
}
