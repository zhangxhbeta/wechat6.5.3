package com.google.android.gms.common.api;

import android.content.IntentFilter;
import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.k.a;
import com.google.android.gms.common.internal.w;

public final class l implements p {
    private final o alr;

    public l(o oVar) {
        this.alr = oVar;
    }

    private <A extends b> void a(e<A> eVar) {
        o oVar = this.alr;
        oVar.amn.add(eVar);
        eVar.a(oVar.amo);
        oVar = this.alr;
        b bVar = (b) oVar.amh.get(eVar.jb());
        w.h(bVar, "Appropriate Api was not requested.");
        if (bVar.isConnected() || !this.alr.ami.containsKey(eVar.jb())) {
            eVar.a(bVar);
        } else {
            eVar.c(new Status(17));
        }
    }

    private <A extends b, T extends a<? extends g, A>> T b(T t) {
        try {
            a((e) t);
        } catch (DeadObjectException e) {
            this.alr.a(new b(this, this) {
                final /* synthetic */ l als;

                public final void js() {
                    this.als.bH(1);
                }
            });
        }
        return t;
    }

    public final <A extends b, R extends g, T extends a<R, A>> T a(T t) {
        return b(t);
    }

    public final void a(ConnectionResult connectionResult, a<?> aVar, int i) {
    }

    public final void bH(int i) {
        if (i == 1) {
            o oVar = this.alr;
            if (!oVar.amc) {
                oVar.amc = true;
                if (oVar.amg == null) {
                    oVar.amg = new c(oVar);
                    IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
                    intentFilter.addDataScheme("package");
                    oVar.mContext.getApplicationContext().registerReceiver(oVar.amg, intentFilter);
                }
                oVar.amf.sendMessageDelayed(oVar.amf.obtainMessage(1), oVar.amd);
                oVar.amf.sendMessageDelayed(oVar.amf.obtainMessage(2), oVar.ame);
            }
        }
        for (e a : this.alr.amn) {
            a.a(new Status(8, "The connection to Google Play services was lost"));
        }
        this.alr.f(null);
        this.alr.ama.bN(i);
        this.alr.ama.jX();
        if (i == 2) {
            this.alr.connect();
        }
    }

    public final void begin() {
        while (!this.alr.amb.isEmpty()) {
            try {
                a((e) this.alr.amb.remove());
            } catch (DeadObjectException e) {
            }
        }
    }

    public final void connect() {
    }

    public final void disconnect() {
        this.alr.ami.clear();
        this.alr.jB();
        this.alr.f(null);
        this.alr.ama.jX();
    }

    public final void g(Bundle bundle) {
    }

    public final String getName() {
        return "CONNECTED";
    }
}
