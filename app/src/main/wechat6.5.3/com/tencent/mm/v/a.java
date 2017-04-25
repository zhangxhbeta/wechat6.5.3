package com.tencent.mm.v;

import com.tencent.mm.av.d;
import com.tencent.mm.network.e;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aqx;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.vending.g.g;
import junit.framework.Assert;

public class a<_Resp extends aqx> {
    public b cif;
    b<_Resp> czb = new b(this);
    private d<a<_Resp>> czc;

    public static class a<T extends aqx> {
        public k aZJ;
        public String biS;
        public T bra;
        public int errCode;
        public int errType;

        public static <T extends aqx> a<T> a(int i, int i2, String str, T t, k kVar) {
            a<T> aVar = new a();
            aVar.errType = i;
            aVar.errCode = i2;
            aVar.biS = str;
            aVar.bra = t;
            aVar.aZJ = kVar;
            return aVar;
        }
    }

    private static class b<_Resp extends aqx> extends k {
        e cxf = null;
        final k cze = this;
        b czf;
        com.tencent.mm.vending.g.b czg;
        private a czh;
        private j czi = new j(this) {
            final /* synthetic */ b czj;

            {
                this.czj = r1;
            }

            public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
                g.a(this.czj.czg, new Object[]{a.a(i2, i3, str, (aqx) this.czj.czf.czl.czs, this.czj)});
                this.czj.cxf.a(i2, i3, str, this.czj.cze);
                v.i("MicroMsg.Cgi", "onGYNetEnd:%d func:%d time:%d [%d,%d,%s]", new Object[]{Integer.valueOf(this.czj.cze.hashCode()), Integer.valueOf(this.czj.getType()), Long.valueOf(be.Ni() - this.czj.mStartTime), Integer.valueOf(i2), Integer.valueOf(i3), str});
            }
        };
        final long mStartTime = be.Ni();

        public b(a aVar) {
            this.czh = aVar;
        }

        protected final int ul() {
            return 1;
        }

        public final int getType() {
            return this.czf.czm;
        }

        public final int a(e eVar, e eVar2) {
            this.cxf = eVar2;
            int a = a(eVar, this.czf, this.czi);
            v.i("MicroMsg.Cgi", "Start doScene:%d func:%d netid:%d time:%d", new Object[]{Integer.valueOf(this.cze.hashCode()), Integer.valueOf(this.czf.czm), Integer.valueOf(a), Long.valueOf(be.Ni() - this.mStartTime)});
            if (a < 0) {
                g.a(this.czg, new Object[]{a.a(3, -1, "", (aqx) this.czf.czl.czs, this)});
            }
            return a;
        }
    }

    public final synchronized d<a<_Resp>> Bt() {
        Assert.assertNotNull("You should set a CommReqResp!", this.cif);
        Assert.assertTrue("RunCgi NetSceneQueue not ready!", u.Cp());
        if (this.czc == null) {
            this.czc = new d().a(new com.tencent.mm.vending.g.c.a<a<_Resp>>(this) {
                final /* synthetic */ a czd;

                {
                    this.czd = r1;
                }

                public final /* synthetic */ Object call() {
                    com.tencent.mm.vending.g.b bKP = g.bKP();
                    this.czd.czb.czg = bKP;
                    this.czd.czb.czf = this.czd.cif;
                    if (!u.cAQ.uU().a(this.czd.czb, 0)) {
                        v.e("MicroMsg.Cgi", "RunCgi doScene failed!");
                        g.a(bKP, new Object[0]);
                    }
                    return null;
                }
            });
        }
        return this.czc;
    }
}
