package com.tencent.mm.plugin.readerapp.b;

import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.e.a.z;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.protocal.c.amv;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.v;

final class a extends c<z> {
    a() {
        this.nhz = z.class.getName().hashCode();
    }

    private boolean a(z zVar) {
        if (!(zVar instanceof z)) {
            v.f("MicroMsg.ReaderAppBindQQ.EventListener", "not bind qq event");
        } else if (zVar.aXk.aXm == 0) {
            try {
                int xQ = k.xQ() | 262144;
                ak.yW();
                com.tencent.mm.model.c.vf().set(34, Integer.valueOf(xQ));
                amv com_tencent_mm_protocal_c_amv = new amv();
                com_tencent_mm_protocal_c_amv.mau = 262144;
                com_tencent_mm_protocal_c_amv.mNo = 1;
                ak.yW();
                com.tencent.mm.model.c.wG().b(new com.tencent.mm.ak.j.a(39, com_tencent_mm_protocal_c_amv));
                ak.yW();
                com.tencent.mm.model.c.wG().b(new n("", "", "", "", "", "", "", "", xQ, "", ""));
                g.b(new com.tencent.mm.plugin.readerapp.b.g.a(this) {
                    final /* synthetic */ a ilb;

                    {
                        this.ilb = r1;
                    }

                    public final void aJd() {
                    }
                });
                int xL = k.xL() & -33;
                ak.yW();
                com.tencent.mm.model.c.vf().set(40, Integer.valueOf(xL));
                ak.yW();
                com.tencent.mm.model.c.wG().b(new g(21, 2));
                v.d("MicroMsg.ReaderAppBindQQ.EventListener", "doClearReaderAppWeiboHelper succ ");
            } catch (Throwable e) {
                v.a("MicroMsg.ReaderAppBindQQ.EventListener", e, "", new Object[0]);
            }
        }
        return false;
    }
}
