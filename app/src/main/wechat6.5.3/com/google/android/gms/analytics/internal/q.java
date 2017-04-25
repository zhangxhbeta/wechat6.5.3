package com.google.android.gms.analytics.internal;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.analytics.a;
import com.google.android.gms.analytics.b;
import com.google.android.gms.analytics.c;
import com.google.android.gms.c.ah;
import com.google.android.gms.c.v;
import com.google.android.gms.c.w;
import com.google.android.gms.common.internal.f;
import java.lang.Thread.UncaughtExceptionHandler;

public class q {
    private static q agE;
    final Context agF;
    final ac agG = r.b(this);
    final f agH;
    private final ah agI;
    private final m agJ;
    final ag agK;
    private final l agL;
    final i agM;
    private final a agN;
    private final y agO;
    public final a agP;
    public final v agQ;
    public final af agR;
    public final v agn = w.kQ();
    final Context mContext;

    private q(r rVar) {
        Context context = rVar.agT;
        com.google.android.gms.common.internal.w.h(context, "Application context can't be null");
        com.google.android.gms.common.internal.w.b(context instanceof Application, "getApplicationContext didn't return the application");
        Context context2 = rVar.agU;
        com.google.android.gms.common.internal.w.Z(context2);
        this.mContext = context;
        this.agF = context2;
        f fVar = new f(this);
        fVar.hY();
        this.agH = fVar;
        if (f.aob) {
            hZ().E("Google Analytics " + p.VERSION + " is starting up.");
        } else {
            hZ().E("Google Analytics " + p.VERSION + " is starting up. To enable debug logging on a device run:\n  adb shell setprop log.tag.GAv4 DEBUG\n  adb logcat -s GAv4");
        }
        i f = r.f(this);
        f.hY();
        this.agM = f;
        l lVar = new l(this);
        lVar.hY();
        this.agL = lVar;
        m mVar = new m(this, rVar);
        y a = r.a(this);
        a aVar = new a(this);
        v vVar = new v(this);
        af afVar = new af(this);
        ah L = ah.L(context);
        L.azb = new UncaughtExceptionHandler(this) {
            final /* synthetic */ q agS;

            {
                this.agS = r1;
            }

            public final void uncaughtException(Thread thread, Throwable th) {
                f fVar = this.agS.agH;
                if (fVar != null) {
                    fVar.g("Job execution failed", th);
                }
            }
        };
        this.agI = L;
        c aVar2 = new a(this);
        a.hY();
        this.agO = a;
        aVar.hY();
        this.agP = aVar;
        vVar.hY();
        this.agQ = vVar;
        afVar.hY();
        this.agR = afVar;
        ag e = r.e(this);
        e.hY();
        this.agK = e;
        mVar.hY();
        this.agJ = mVar;
        if (f.aob) {
            hZ().e("Device AnalyticsService version", p.VERSION);
        }
        l id = aVar2.ahP.id();
        if (id.hL()) {
            e.ht().setLogLevel(id.getLogLevel());
        }
        if (id.hO()) {
            aVar2.afv = id.hP();
        }
        if (id.hL()) {
            b ht = e.ht();
            if (ht != null) {
                ht.setLogLevel(id.getLogLevel());
            }
        }
        aVar2.afs = true;
        this.agN = aVar2;
        mVar.agu.start();
    }

    public static void a(o oVar) {
        com.google.android.gms.common.internal.w.h(oVar, "Analytics service not created/initialized");
        com.google.android.gms.common.internal.w.b(oVar.isInitialized(), "Analytics service not initialized");
    }

    public static void if() {
        ah.if();
    }

    public static q t(Context context) {
        com.google.android.gms.common.internal.w.Z(context);
        if (agE == null) {
            synchronized (q.class) {
                if (agE == null) {
                    v kQ = w.kQ();
                    long elapsedRealtime = kQ.elapsedRealtime();
                    q qVar = new q(new r(context.getApplicationContext()));
                    agE = qVar;
                    a.hl();
                    elapsedRealtime = kQ.elapsedRealtime() - elapsedRealtime;
                    long longValue = ((Long) aj.aiS.get()).longValue();
                    if (elapsedRealtime > longValue) {
                        qVar.hZ().c("Slow initialization (ms)", Long.valueOf(elapsedRealtime), Long.valueOf(longValue));
                    }
                }
            }
        }
        return agE;
    }

    public final f hZ() {
        a(this.agH);
        return this.agH;
    }

    public final ah ia() {
        com.google.android.gms.common.internal.w.Z(this.agI);
        return this.agI;
    }

    public final m ib() {
        a(this.agJ);
        return this.agJ;
    }

    public final a ic() {
        com.google.android.gms.common.internal.w.Z(this.agN);
        a aVar = this.agN;
        boolean z = aVar.afs && !aVar.aft;
        com.google.android.gms.common.internal.w.b(z, "Analytics instance not initialized");
        return this.agN;
    }

    public final l id() {
        a(this.agL);
        return this.agL;
    }

    public final y ie() {
        a(this.agO);
        return this.agO;
    }
}
