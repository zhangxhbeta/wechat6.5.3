package com.tencent.mm.ap;

import com.tencent.mm.model.aq;
import com.tencent.mm.model.aq.a;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.acg;
import com.tencent.mm.protocal.c.ajs;
import com.tencent.mm.protocal.c.hu;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mm.v.k.b;
import com.tencent.mm.v.l;

public final class d extends l implements j {
    private final p cAt = new a();
    String cZU = "";
    private e cii;

    public d(String str, String str2, String str3) {
        a aVar = (a) this.cAt.Bx();
        aVar.csW.mAM = str;
        aVar.csW.mAN = str2;
        aVar.csW.gln = str3;
        aVar.csW.maG = 261;
        v.i("MicroMsg.NetSceneGetSoterFingerprintTicketRsa", "get soter ticket sceneType %d", new Object[]{Integer.valueOf(aVar.csW.maG)});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cAt, this);
    }

    protected final int ul() {
        return 3;
    }

    protected final int a(p pVar) {
        return b.czU;
    }

    protected final void a(k.a aVar) {
    }

    public final int getType() {
        return 261;
    }

    public final void a(int i, int i2, String str, p pVar) {
        this.cZU = ((aq.b) pVar.ze()).csX.mpB;
        v.d("MicroMsg.NetSceneGetSoterFingerprintTicketRsa", "onGYNetEndDelegated  errType:" + i + " errCode:" + i2 + " mTicket: " + this.cZU);
        if (this.cii != null) {
            this.cii.a(i, i2, str, this);
        }
    }

    public final hu c(p pVar) {
        if (pVar != null) {
            try {
                return ((aq.b) pVar.ze()).csX.mgK;
            } catch (Exception e) {
                v.a("MicroMsg.NetSceneGetSoterFingerprintTicketRsa", null, "retrieve ip list exception: %s", new Object[]{e.getMessage()});
            }
        }
        return null;
    }

    public final ajs d(p pVar) {
        if (pVar != null) {
            try {
                return ((aq.b) pVar.ze()).csX.mgL;
            } catch (Exception e) {
                v.a("MicroMsg.NetSceneGetSoterFingerprintTicketRsa", null, "retrieve network control exception: %s", new Object[]{e.getMessage()});
            }
        }
        return null;
    }

    public final acg e(p pVar) {
        if (pVar != null) {
            try {
                return ((aq.b) pVar.ze()).csX.mgJ;
            } catch (Exception e) {
                v.a("MicroMsg.NetSceneGetSoterFingerprintTicketRsa", null, "retrieve host list exception: %s", new Object[]{e.getMessage()});
            }
        }
        return null;
    }

    public final void BG() {
        if (this.cii != null) {
            this.cii.a(3, -1, "", this);
        }
    }

    public final e BH() {
        return this.cii;
    }
}
