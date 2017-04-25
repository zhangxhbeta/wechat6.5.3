package com.tencent.mm.plugin.b;

import com.tencent.mm.kernel.plugin.ProcessProfile;
import com.tencent.mm.kernel.plugin.b;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.al;
import com.tencent.mm.plugin.f.a.e;
import com.tencent.mm.protocal.j.f;
import com.tencent.mm.protocal.j.g;

public class a extends b {
    public void dependency() {
        dependsOn(e.class);
    }

    public void configure(ProcessProfile processProfile) {
        al.a(new com.tencent.mm.model.al.a(this) {
            final /* synthetic */ a dZX;

            {
                this.dZX = r1;
            }

            public final void b(f fVar, g gVar) {
                aj.a(fVar, gVar.lWG, true);
                aj.a(fVar, gVar);
            }
        });
    }

    public void execute(ProcessProfile processProfile) {
    }

    public String toString() {
        return "plugin-auth";
    }
}
