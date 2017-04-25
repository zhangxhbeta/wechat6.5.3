package com.tencent.mm.kernel;

import com.tencent.mm.kernel.api.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.m;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.n;
import com.tencent.mm.v.u;
import java.util.HashSet;
import java.util.Iterator;

public final class b {
    public final a cjB;
    public final n cjC;
    public HashSet<m> cjD = new HashSet();
    public m cjE = new com.tencent.mm.network.m.a(this) {
        final /* synthetic */ b cjF;

        {
            this.cjF = r1;
        }

        public final void cI(int i) {
            Iterator it = this.cjF.cjD.iterator();
            while (it.hasNext()) {
                ((m) it.next()).cI(i);
            }
        }
    };

    static class a extends com.tencent.mm.av.a<c> implements c {
        a() {
        }

        public final void b(final e eVar) {
            a(new com.tencent.mm.av.a.a<c>(this) {
                final /* synthetic */ a cjI;

                public final /* synthetic */ void an(Object obj) {
                    ((c) obj).b(eVar);
                }
            });
        }
    }

    public b(com.tencent.mm.v.n.a aVar, a aVar2) {
        this.cjC = n.a(aVar);
        this.cjC.ckz = g.vA();
        u.cAQ = new com.tencent.mm.v.u.b(this) {
            final /* synthetic */ b cjF;

            {
                this.cjF = r1;
            }

            public final n uU() {
                return this.cjF.cjC;
            }
        };
        this.cjB = aVar2;
    }

    public final byte[] uT() {
        byte[] bArr = null;
        try {
            if (!(this.cjC == null || this.cjC.cAa == null || this.cjC.cAa.BU() == null)) {
                bArr = this.cjC.cAa.BU().uT();
            }
        } catch (Throwable e) {
            v.w("MMKernel.CoreNetwork", "get session key error, %s", e.getMessage());
            v.e("MMKernel.CoreNetwork", "exception:%s", be.e(e));
        }
        return bArr;
    }
}
