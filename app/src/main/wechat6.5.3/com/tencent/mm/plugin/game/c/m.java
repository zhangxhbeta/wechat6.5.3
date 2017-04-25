package com.tencent.mm.plugin.game.c;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.c.ary;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;

public final class m implements e {
    private static boolean aHp = false;
    private static int ghZ = 20;
    private static LinkedList<g> gia = new LinkedList();
    private int offset = 0;

    static /* synthetic */ int a(m mVar, int i) {
        int i2 = mVar.offset + i;
        mVar.offset = i2;
        return i2;
    }

    public static void update() {
        ak.yW();
        if (!(System.currentTimeMillis() - ((Long) c.vf().get(a.noB, Long.valueOf(0))).longValue() > 86400000)) {
            v.i("MicroMsg.GameListUpdater", "No need to update");
        } else if (aHp) {
            v.e("MicroMsg.GameListUpdater", "Already running");
        } else {
            gia.clear();
            m mVar = new m();
            ak.vy().a(1215, mVar);
            ak.vy().a(new ar(mVar.offset, ghZ), 0);
            aHp = true;
        }
    }

    public final void a(int i, int i2, String str, final k kVar) {
        if (i == 0 && i2 == 0) {
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ m gib;

                public final void run() {
                    String str;
                    m.a(this.gib, m.ghZ);
                    ary com_tencent_mm_protocal_c_ary = (ary) ((ar) kVar).fut.czl.czs;
                    if (com_tencent_mm_protocal_c_ary == null) {
                        v.e("MicroMsg.NetSceneSearchGameList", "resp == null");
                        str = null;
                    } else {
                        str = com_tencent_mm_protocal_c_ary.muZ;
                    }
                    f gVar = new g(str);
                    gVar.arj();
                    m.gia.add(gVar);
                    v.i("MicroMsg.GameListUpdater", "remainingCount: %d", new Object[]{Integer.valueOf(gVar.ghN.optInt("remainingCount"))});
                    if (gVar.ghN.optInt("remainingCount") > 0) {
                        ak.vy().a(new ar(this.gib.offset, m.ghZ), 0);
                        return;
                    }
                    this.gib.aro();
                    ak.yW();
                    c.vf().a(a.noB, Long.valueOf(System.currentTimeMillis()));
                    Object YB = m.gia;
                    if (!be.bP(YB)) {
                        ak.vA().x(new com.tencent.mm.plugin.game.c.g.AnonymousClass1(YB));
                    }
                }
            });
        } else {
            aro();
        }
    }

    private void aro() {
        aHp = false;
        ak.vy().b(1215, this);
    }
}
