package com.tencent.mm.plugin.f.a;

import com.tencent.mm.ak.j;
import com.tencent.mm.ak.r;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.kernel.api.bucket.g;
import com.tencent.mm.kernel.plugin.ProcessProfile;
import com.tencent.mm.kernel.plugin.b;
import com.tencent.mm.modelmulti.n;
import com.tencent.mm.plugin.f.a.a.h;
import com.tencent.mm.plugin.f.a.a.i;
import com.tencent.mm.plugin.zero.a.f;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bb;
import java.util.HashMap;

public class e extends b implements a, d, g {
    private com.tencent.mm.model.e csE = new com.tencent.mm.model.e();
    private d hkX;

    public void dependency() {
        dependsOn(com.tencent.mm.plugin.zero.b.class);
    }

    public void configure(ProcessProfile processProfile) {
        v.i("MicroMsg.TAG", "init thread pool: " + com.tencent.mm.sdk.i.e.buF() + " current tid=" + Thread.currentThread() + "|priority=" + Thread.currentThread().getPriority());
        c.k(f.class);
        i aVar = new a();
        i.a.a(2, aVar);
        i.a.a(17, aVar);
        i.a.a(4, aVar);
        i.a.a(7, new b());
        aVar = new c();
        i.a.a(5, aVar);
        i.a.a(8, aVar);
        i.a.a(9, aVar);
        i.a.a(1, new g());
        com.tencent.mm.kernel.g.vs().a(h.class, new n());
        com.tencent.mm.kernel.a.e g = com.tencent.mm.kernel.g.g(f.class);
        if (com.tencent.mm.kernel.d.b(processProfile) || com.tencent.mm.kernel.d.a(processProfile, ":push")) {
            new com.tencent.mm.plugin.zero.tasks.c().after(g).before(this);
        }
        if (com.tencent.mm.kernel.d.b(processProfile)) {
            new com.tencent.mm.plugin.zero.tasks.b().after(g).before(this);
        }
    }

    public void execute(ProcessProfile processProfile) {
        if (com.tencent.mm.kernel.d.b(processProfile)) {
            this.hkX = new d();
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.f.a.a.d.class, this.hkX);
        }
    }

    public String toString() {
        return "plugin-messenger-foundation";
    }

    public final void aM(boolean z) {
    }

    public final void a(com.tencent.mm.bg.g gVar, com.tencent.mm.bg.g gVar2) {
        d dVar = this.hkX;
        dVar.hkV = new r(new j(gVar));
        dVar.ejZ = new aa(gVar);
        dVar.hkU = new bb(gVar);
        dVar.ekb = new ac(gVar);
        dVar.eka = new au(gVar, dVar.ejZ, dVar.ekb);
        dVar.eka.a(dVar.ekb, null);
        dVar.eke = new ay(gVar);
        dVar.hkW = new af(gVar);
    }

    public final void vo() {
    }

    public final void dU(String str) {
    }

    public final HashMap<Integer, com.tencent.mm.bg.g.c> vD() {
        HashMap<Integer, com.tencent.mm.bg.g.c> hashMap = new HashMap();
        hashMap.put(Integer.valueOf("MESSAGE_TABLE".hashCode()), new com.tencent.mm.bg.g.c(this) {
            final /* synthetic */ e hkY;

            {
                this.hkY = r1;
            }

            public final String[] pS() {
                return au.cic;
            }
        });
        hashMap.put(Integer.valueOf("CONTACT_TABLE".hashCode()), new com.tencent.mm.bg.g.c(this) {
            final /* synthetic */ e hkY;

            {
                this.hkY = r1;
            }

            public final String[] pS() {
                return aa.cic;
            }
        });
        hashMap.put(Integer.valueOf("OPLOG_TABLE".hashCode()), new com.tencent.mm.bg.g.c(this) {
            final /* synthetic */ e hkY;

            {
                this.hkY = r1;
            }

            public final String[] pS() {
                return j.cic;
            }
        });
        hashMap.put(Integer.valueOf("CONVERSATION_TABLE".hashCode()), new com.tencent.mm.bg.g.c(this) {
            final /* synthetic */ e hkY;

            {
                this.hkY = r1;
            }

            public final String[] pS() {
                return ac.cic;
            }
        });
        hashMap.put(Integer.valueOf("ROLEINFO_TABLE".hashCode()), new com.tencent.mm.bg.g.c(this) {
            final /* synthetic */ e hkY;

            {
                this.hkY = r1;
            }

            public final String[] pS() {
                return ay.cic;
            }
        });
        hashMap.put(Integer.valueOf("STRANGER_TABLE".hashCode()), new com.tencent.mm.bg.g.c(this) {
            final /* synthetic */ e hkY;

            {
                this.hkY = r1;
            }

            public final String[] pS() {
                return bb.cic;
            }
        });
        hashMap.put(Integer.valueOf("DeletedConversationInfo".hashCode()), new com.tencent.mm.bg.g.c(this) {
            final /* synthetic */ e hkY;

            {
                this.hkY = r1;
            }

            public final String[] pS() {
                return af.cic;
            }
        });
        return hashMap;
    }

    public final void a(com.tencent.mm.kernel.a aVar) {
        com.tencent.mm.v.d.c.aw(Integer.valueOf(10000));
        com.tencent.mm.v.d.c.aw(Integer.valueOf(1));
    }

    public final void a(com.tencent.mm.kernel.a aVar, boolean z) {
        com.tencent.mm.v.d.c.a(Integer.valueOf(10000), this.csE);
        com.tencent.mm.v.d.c.a(Integer.valueOf(1), this.csE);
    }
}
