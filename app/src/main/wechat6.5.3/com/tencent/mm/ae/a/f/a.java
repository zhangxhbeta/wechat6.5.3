package com.tencent.mm.ae.a.f;

import com.tencent.mm.ae.a.a.b;
import com.tencent.mm.ae.a.a.c;
import com.tencent.mm.sdk.platformtools.d;

public final class a implements Runnable {
    private final b cOM = this.cPZ.cOM;
    private final com.tencent.mm.ae.a.b cPZ;
    private final c cPf;
    private final com.tencent.mm.ae.a.c.a cPh;
    private final com.tencent.mm.ae.a.c.b cPi;
    private final com.tencent.mm.ae.a.c.c cQa;
    private final String url;

    public a(String str, c cVar, com.tencent.mm.ae.a.b bVar, com.tencent.mm.ae.a.c.c cVar2) {
        this.url = str;
        this.cPZ = bVar;
        if (cVar == null) {
            this.cPf = this.cOM.cPf;
        } else {
            this.cPf = cVar;
        }
        this.cQa = cVar2;
        if (this.cPf.cPi != null) {
            this.cPi = this.cPf.cPi;
        } else {
            this.cPi = this.cOM.cPi;
        }
        this.cPh = this.cOM.cPh;
    }

    public final void run() {
        com.tencent.mm.ae.a.d.b bVar = new com.tencent.mm.ae.a.d.b();
        bVar = this.cPi.ji(this.url);
        if (bVar == null) {
            this.cQa.a(false, this.cPf.cPT);
        } else if (!(d.decodeByteArray(bVar.data, 10, 10) == null && this.cPf.cPS) && this.cPh.a(this.url, bVar.data, this.cPf)) {
            if (this.cQa != null) {
                this.cQa.a(true, this.cPf.cPT);
            }
        } else if (this.cQa != null) {
            this.cQa.a(false, this.cPf.cPT);
        }
    }
}
