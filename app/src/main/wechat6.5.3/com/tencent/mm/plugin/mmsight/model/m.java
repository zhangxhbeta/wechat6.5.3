package com.tencent.mm.plugin.mmsight.model;

import com.tencent.mm.as.k;
import com.tencent.mm.as.t.a;
import com.tencent.mm.bg.g;
import com.tencent.mm.e.a.nz;
import com.tencent.mm.model.ag;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.plugin.mmsight.model.a.h;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import java.util.HashMap;

public final class m implements ag {
    private j hnG = new j();
    private c hnH = new c<nz>(this) {
        final /* synthetic */ m hnI;

        {
            this.hnI = r2;
            this.nhz = nz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            nz nzVar = (nz) bVar;
            if (i.a(nzVar.boW.boY, d.En().Ek(), nzVar.boW.boZ, nzVar.boW.bpb)) {
                nzVar.boW.bpa.run();
                nzVar.boX.bpc = i.b(nzVar.boW.boY, d.En().Ek(), nzVar.boW.boZ, nzVar.boW.bpb);
            } else {
                nzVar.boX.bpc = 1;
            }
            return false;
        }
    };

    public final HashMap<Integer, g.c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        a KY = k.KY();
        j jVar = this.hnG;
        if (!(jVar == null || KY.dir == null)) {
            KY.dir.add(jVar);
        }
        com.tencent.mm.sdk.c.a.nhr.d(this.hnH);
    }

    public final void aH(boolean z) {
    }

    public final void th() {
        a KY = k.KY();
        j jVar = this.hnG;
        if (!(jVar == null || KY.dir == null)) {
            KY.dir.remove(jVar);
        }
        com.tencent.mm.sdk.c.a.nhr.f(this.hnH);
        h.hoF.wc();
    }
}
