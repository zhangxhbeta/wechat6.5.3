package com.tencent.mm.modelcdntran;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.bg.g.c;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.b;
import com.tencent.mm.protocal.c.ih;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import java.io.File;
import java.util.HashMap;

public class g implements ag {
    private static g cFK;
    private b cFL = null;
    private c cFM = null;
    private f cFN = null;

    public static g DW() {
        g gVar = (g) ak.yP().fY(g.class.getName());
        cFK = gVar;
        if (gVar == null) {
            cFK = new g();
            ak.yP().a(g.class.getName(), cFK);
        }
        return cFK;
    }

    public final HashMap<Integer, c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public static String DX() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new b();
        }
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        return stringBuilder.append(com.tencent.mm.model.c.xp()).append("cdndnsinfo/").toString();
    }

    public final void aH(boolean z) {
    }

    public final void aG(boolean z) {
        if (DW().cFM == null) {
            DW().cFM = new c();
        }
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new b();
        }
        File file = new File(DX());
        if (!file.exists()) {
            file.mkdir();
        }
        ak.a(new com.tencent.mm.v.c(this) {
            final /* synthetic */ g cFO;

            {
                this.cFO = r1;
            }

            public final void b(ih ihVar, ih ihVar2, ih ihVar3) {
                v.d("MicroMsg.SubCoreCdnTransport", "cdntra infoUpdate dns info " + ihVar.toString() + " getCore().engine:" + g.Ea());
                if (g.Ea() != null) {
                    g.Ea().a(ihVar, ihVar2, ihVar3, null, null, null);
                    ak.vA().x(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 cFP;

                        {
                            this.cFP = r1;
                        }

                        public final void run() {
                            if (g.DZ() != null) {
                                g.DZ().aY(false);
                            }
                        }

                        public final String toString() {
                            return super.toString() + "|infoUpdate";
                        }
                    });
                }
            }
        });
    }

    public static f DY() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new b();
        }
        if (DW().cFN == null) {
            DW().cFN = new f();
        }
        return DW().cFN;
    }

    public static c DZ() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() != 0) {
            return DW().cFM;
        }
        throw new b();
    }

    public static b Ea() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new b();
        }
        if (DW().cFL == null) {
            g DW = DW();
            ak.yW();
            DW.cFL = new b(com.tencent.mm.model.c.xp(), DZ(), DY());
        }
        return DW().cFL;
    }

    public final void th() {
        ak.a(null);
        if (this.cFL != null) {
            b bVar = this.cFL;
            CdnLogic.setCallBack(null);
            bVar.cES = null;
            this.cFL = null;
        }
        if (this.cFM != null) {
            e eVar = this.cFM;
            if (ak.uz()) {
                ak.yW();
                com.tencent.mm.model.c.vf().b(eVar);
            }
            ak.b(eVar.cEZ);
            ak.vy().b(379, eVar);
            this.cFM = null;
        }
    }
}
