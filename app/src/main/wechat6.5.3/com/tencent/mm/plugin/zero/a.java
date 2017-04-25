package com.tencent.mm.plugin.zero;

import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bn;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.plugin.zero.a.d;
import com.tencent.mm.sdk.platformtools.v;

public final class a implements b, d {
    private bn lxe;
    private p lxf;

    public final p Ho() {
        g.vx();
        g.vu().uH();
        if (this.lxf == null) {
            this.lxf = new p();
        }
        return this.lxf;
    }

    public final bn bmm() {
        g.vx();
        g.vu().uH();
        if (this.lxe == null) {
            this.lxe = new bn(new com.tencent.mm.model.bn.a(this) {
                final /* synthetic */ a lxg;

                {
                    this.lxg = r1;
                }

                public final boolean Ad() {
                    return this.lxg.Ho().cSr == null;
                }
            });
        }
        return this.lxe;
    }

    public final void th() {
        if (this.lxf != null) {
            p pVar = this.lxf;
            v.i("MicroMsg.SyncService", "clear synclist:%s notify:%s running:%s", Integer.valueOf(pVar.cSo.size()), Integer.valueOf(pVar.cSp.size()), pVar.cSr);
            pVar.cSo.clear();
            pVar.cSp.clear();
        }
        if (this.lxe != null) {
            this.lxe.zY();
        }
    }
}
