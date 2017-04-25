package com.tencent.mm.plugin.shake.b;

import android.content.Context;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.shake.b.j.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.List;

public final class c extends b implements e {
    float bYf = -1000.0f;
    float bYg = -1000.0f;
    private a bYl = new a(this) {
        final /* synthetic */ c iOf;

        {
            this.iOf = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2) {
            com.tencent.mm.modelstat.e.JZ().a(2002, i != 0, this.iOf.cCR == null ? false : this.iOf.cCR.cJA, f, f2, (int) d2);
            v.i("MicroMsg.ShakeFriendService", "getlocaion lat %f lng %f hasGetLbsInfo " + this.iOf.iBP, new Object[]{Float.valueOf(f2), Float.valueOf(f)});
            if (!z) {
                return true;
            }
            if (this.iOf.iNZ && this.iOf.bYf == -1000.0f && this.iOf.bYg == -1000.0f) {
                this.iOf.iNZ = false;
                this.iOf.bYf = f2;
                this.iOf.bYg = f;
                this.iOf.iBM = (int) d2;
                this.iOf.iBL = i;
                this.iOf.iBP = true;
            }
            return false;
        }
    };
    com.tencent.mm.modelgeo.c cCR;
    private Context context;
    int iBL = 1;
    int iBM = DownloadResult.CODE_UNDEFINED;
    boolean iBP = false;
    boolean iNZ = true;
    b iOa;
    a iOb;
    private int iOc = 0;
    ac iOd = new ac();
    Runnable iOe = new Runnable(this) {
        final /* synthetic */ c iOf;

        {
            this.iOf = r1;
        }

        public final void run() {
            if (!(this.iOf.iOd == null || this.iOf.iOe == null)) {
                this.iOf.iOd.removeCallbacks(this.iOf.iOe);
            }
            if (this.iOf.iOb != null) {
                ak.vy().c(this.iOf.iOb);
            }
            if (!(this.iOf.iOa == null || this.iOf.iOa.brw == null)) {
                this.iOf.iOb = new a(this.iOf.iOa.brw);
            }
            if (this.iOf.iOb != null) {
                ak.vy().a(this.iOf.iOb, 0);
            }
        }
    };

    public c(Context context, j.a aVar) {
        super(aVar);
        this.context = context;
    }

    public final void init() {
        ak.vy().a(161, this);
        ak.vy().a(162, this);
        ak.vy().a(1251, this);
        aNA();
    }

    public final void start() {
        reset();
        init();
        this.iOa = new b(this.bYg, this.bYf, this.iBM, this.iBL, "", "");
        ak.vy().a(this.iOa, 0);
        if (!this.iBP) {
            if (this.cCR == null) {
                aNA();
            }
            this.cCR.a(this.bYl);
        }
        if (this.iOc <= 0) {
            this.iOc++;
        } else if (this.iOc <= 0 || this.iOc > 10) {
            this.iOc = 0;
        } else {
            this.iOc++;
            return;
        }
        v.i("MicroMsg.ShakeFriendService", "do doGetLbsCard");
        ak.vy().a(new com.tencent.mm.plugin.shake.c.a.b(this.bYg, this.bYf), 0);
    }

    private void aNA() {
        this.cCR = com.tencent.mm.modelgeo.c.FY();
        this.iNZ = true;
        this.cCR.a(this.bYl, true);
    }

    public final void reset() {
        if (this.iOa != null) {
            ak.vy().c(this.iOa);
        }
        if (this.iOb != null) {
            ak.vy().c(this.iOb);
        }
        if (this.iOd != null && this.iOe != null) {
            this.iOd.removeCallbacks(this.iOe);
        }
    }

    public final void pause() {
        if (this.cCR != null) {
            this.cCR.c(this.bYl);
        }
    }

    public final void resume() {
        if (this.cCR != null) {
            this.cCR.a(this.bYl, true);
        }
    }

    public final void aNB() {
        super.aNB();
        ak.vy().b(161, this);
        ak.vy().b(162, this);
        ak.vy().b(1251, this);
        if (this.cCR != null) {
            this.cCR.c(this.bYl);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        switch (kVar.getType()) {
            case 161:
                b bVar = (b) kVar;
                if (bVar.aNz() == 3 || bVar.aNz() == 4) {
                    v.v("MicroMsg.ShakeFriendService", "onSceneEnd ignore location report response");
                    return;
                } else if (i2 == 0 && i == 0 && bVar.ret == 0) {
                    this.iOd.postDelayed(this.iOe, 3000);
                    return;
                } else {
                    v.e("MicroMsg.ShakeFriendService", "onSceneEnd reprot failed");
                    this.iOn.d(null, 3);
                    return;
                }
            case 162:
                a aVar = (a) kVar;
                if (i2 == 0 && i == 0 && aVar.ret == 0) {
                    List list = aVar.iNX;
                    if (list.size() == 0) {
                        v.i("MicroMsg.ShakeFriendService", "empty shake get list");
                        this.iOn.d(null, 3);
                        return;
                    }
                    this.iOn.d(list, 1);
                    return;
                }
                this.iOn.d(null, 3);
                return;
            case 1251:
                com.tencent.mm.plugin.shake.c.a.b bVar2 = (com.tencent.mm.plugin.shake.c.a.b) kVar;
                if (i2 == 0 && i == 0) {
                    if (this.iOn != null) {
                        this.iOn.a(1251, bVar2.iOG, 1);
                        return;
                    }
                    return;
                } else if (this.iOn != null) {
                    this.iOn.a(1251, null, 2);
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }
}
