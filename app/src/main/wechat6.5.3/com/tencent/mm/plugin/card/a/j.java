package com.tencent.mm.plugin.card.a;

import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.card.model.q;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class j implements e {
    public float bYf = -1000.0f;
    public float bYg = -1000.0f;
    private long eBD = 0;

    public final void m(float f, float f2) {
        this.bYf = f;
        this.bYg = f2;
        this.eBD = System.currentTimeMillis() / 1000;
    }

    public final void l(String str, String str2, int i) {
        if ((System.currentTimeMillis() / 1000) - this.eBD > 1800) {
            this.bYf = -1000.0f;
            this.bYg = -1000.0f;
            v.i("MicroMsg.CardReportLBSManager", "checkDataValid time is out");
        }
        if (this.bYf == -1000.0f) {
            v.i("MicroMsg.CardReportLBSManager", "checkDataValid lbsLatitude ==  LocationGeo.INVALID_LAT");
        }
        if (this.bYg == -1000.0f) {
            v.i("MicroMsg.CardReportLBSManager", "checkDataValid lbsLongitude ==  LocationGeo.INVALID_LNG");
        }
        ak.vy().a(1253, this);
        ak.vy().a(new q(this.bYf, this.bYg, str, str2, i), 0);
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.CardReportLBSManager", "rplbs onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        ak.vy().b(1253, this);
    }
}
