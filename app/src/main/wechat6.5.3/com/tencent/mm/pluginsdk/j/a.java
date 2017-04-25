package com.tencent.mm.pluginsdk.j;

import android.app.Activity;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;

public final class a {
    private l lCA;
    private h lCB;
    private i lCC;
    private g lCD;
    private j lCy;
    private k lCz;

    public final boolean a(Activity activity, p pVar) {
        if (pVar.type == 0 || pVar.action == 0) {
            return false;
        }
        if (this.lCD == null) {
            this.lCD = new g(activity);
        }
        if (this.lCD.a(pVar)) {
            return true;
        }
        switch (pVar.type) {
            case 1:
                if (this.lCy == null) {
                    this.lCy = new j(activity);
                }
                this.lCy.a(pVar);
                return false;
            case 2:
                if (this.lCz == null) {
                    this.lCz = new k(activity);
                }
                this.lCz.a(pVar);
                return false;
            case 3:
                if (this.lCA == null) {
                    this.lCA = new l(activity);
                }
                this.lCA.a(pVar);
                return false;
            case 4:
                if (this.lCB == null) {
                    this.lCB = new h(activity);
                }
                this.lCB.a(pVar);
                return false;
            case 5:
                if (this.lCC == null) {
                    this.lCC = new i(activity);
                }
                this.lCC.a(pVar);
                return false;
            case 6:
                if (this.lCD == null) {
                    this.lCD = new g(activity);
                }
                this.lCD.a(pVar);
                return false;
            default:
                v.e("MicroMsg.BaseErrorHelper", "Unkown error type");
                return false;
        }
    }

    private static void a(b bVar) {
        if (bVar != null) {
            for (Integer intValue : bVar.lCE) {
                ak.vy().b(intValue.intValue(), (e) bVar);
            }
            bVar.aXH = null;
        }
    }

    public final void close() {
        a(this.lCy);
        a(this.lCz);
        a(this.lCA);
        a(this.lCB);
        a(this.lCC);
        a(this.lCD);
    }
}
