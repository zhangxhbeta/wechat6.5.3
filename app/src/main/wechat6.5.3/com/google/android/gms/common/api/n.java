package com.google.android.gms.common.api;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.k.a;
import java.util.Collections;

public final class n implements p {
    private final o alr;

    public n(o oVar) {
        this.alr = oVar;
    }

    public final <A extends b, R extends g, T extends a<R, A>> T a(T t) {
        this.alr.amb.add(t);
        return t;
    }

    public final void a(ConnectionResult connectionResult, a<?> aVar, int i) {
    }

    public final void bH(int i) {
    }

    public final void begin() {
        for (b disconnect : this.alr.amh.values()) {
            disconnect.disconnect();
        }
        this.alr.amj = Collections.emptySet();
    }

    public final void connect() {
        o oVar = this.alr;
        oVar.alt.lock();
        try {
            oVar.amk = new m(oVar, oVar.alI, oVar.alJ, oVar.akQ, oVar.akR, oVar.alt, oVar.mContext);
            oVar.amk.begin();
            oVar.alZ.signalAll();
        } finally {
            oVar.alt.unlock();
        }
    }

    public final void disconnect() {
        for (e cancel : this.alr.amb) {
            cancel.cancel();
        }
        this.alr.amb.clear();
        this.alr.ami.clear();
        this.alr.jB();
    }

    public final void g(Bundle bundle) {
    }

    public final String getName() {
        return "DISCONNECTED";
    }
}
