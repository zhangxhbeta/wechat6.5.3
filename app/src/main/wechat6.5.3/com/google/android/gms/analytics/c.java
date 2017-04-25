package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.internal.a;
import com.google.android.gms.analytics.internal.q;
import com.google.android.gms.c.ae;
import com.google.android.gms.c.ag;
import com.google.android.gms.c.h;

public class c extends ag<c> {
    public final q ahP;
    public boolean aiX;

    public c(q qVar) {
        super(qVar.ia(), qVar.agn);
        this.ahP = qVar;
    }

    protected final void a(ae aeVar) {
        h hVar = (h) aeVar.b(h.class);
        if (TextUtils.isEmpty(hVar.agW)) {
            hVar.agW = this.ahP.ie().ix();
        }
        if (this.aiX && TextUtils.isEmpty(hVar.axb)) {
            q qVar = this.ahP;
            q.a(qVar.agP);
            a aVar = qVar.agP;
            hVar.axb = aVar.ho();
            hVar.axc = aVar.hn();
        }
    }

    public final ae iR() {
        ae kW = kX().kW();
        q qVar = this.ahP;
        q.a(qVar.agQ);
        kW.b(qVar.agQ.io());
        kW.b(this.ahP.agR.iO());
        kZ();
        return kW;
    }
}
