package com.tencent.mm.plugin.webview.d;

import android.content.ContentValues;
import com.tencent.mm.bg.g;
import com.tencent.mm.e.b.bt;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.h.c.a;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ar.b;
import com.tencent.mm.sdk.platformtools.ar.c;

public final class d implements c<Integer, Long> {
    public static final String[] cic = new String[]{f.a(ldK, "JsLogBlockList")};
    private static final a ldK = bt.pz();
    public final g cuX;
    public final ar<Integer, Long> ldL = new ar(this, ak.vA().htb.getLooper(), 100, 20, 300000, 1000);
    private long ldM;

    public d(g gVar) {
        this.cuX = gVar;
    }

    public final void bia() {
        this.ldL.iy(true);
    }

    public final boolean Ke() {
        if (this.cuX.inTransaction()) {
            return false;
        }
        this.ldM = this.cuX.er(Thread.currentThread().getId());
        if (this.ldM > 0) {
            return true;
        }
        return false;
    }

    public final void a(ar<Integer, Long> arVar, b<Integer, Long> bVar) {
        switch (bVar.nkN) {
            case 1:
                ContentValues contentValues = new ContentValues(2);
                contentValues.put("logId", (Integer) bVar.lTL);
                contentValues.put("liftTime", (Long) bVar.values);
                this.cuX.replace("JsLogBlockList", "logId", contentValues);
                return;
            case 2:
                this.cuX.delete("JsLogBlockList", "logId=" + bVar.lTL, null);
                return;
            default:
                return;
        }
    }

    public final void Kf() {
        if (this.ldM > 0) {
            this.cuX.es(this.ldM);
        }
    }
}
