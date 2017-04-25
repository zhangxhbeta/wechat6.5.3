package com.tencent.mm.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class ay extends k implements j {
    private e cii;
    private final a ctI;
    private final String ctJ;
    private long ctK;

    public interface a {
        void a(com.tencent.mm.network.e eVar);
    }

    public ay(a aVar) {
        this(aVar, null);
    }

    public ay(a aVar, String str) {
        v.i("MicroMsg.NetSceneLocalProxy", "init LocalProxy task:%s [%s] ", str, be.bur());
        this.ctI = aVar;
        this.ctJ = str;
    }

    public final int getType() {
        return 0;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        c(eVar);
        this.cii = eVar2;
        this.ctK = be.Nj();
        g.vA().x(new Runnable(this) {
            final /* synthetic */ ay ctL;

            {
                this.ctL = r1;
            }

            public final void run() {
                this.ctL.a(0, 0, 0, null, null, null);
            }

            public final String toString() {
                return super.toString() + "|doScene";
            }
        });
        return 0;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (this.ctI != null) {
            v.d("MicroMsg.NetSceneLocalProxy", "local proxy [%s] end, cost=%d", this.ctJ, Long.valueOf(be.az(this.ctK)));
            this.ctI.a(this.czE);
        }
        this.cii.a(0, 0, null, this);
    }
}
