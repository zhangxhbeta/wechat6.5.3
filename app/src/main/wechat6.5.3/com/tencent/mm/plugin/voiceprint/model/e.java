package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.al;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.modelsimple.m;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.k;
import com.tencent.mm.v.k.b;

public final class e extends k implements j {
    private final p cAt = new b();
    String cZU = "";
    com.tencent.mm.v.e cii;
    private int czX = 2;

    public e(String str) {
        a aVar = (a) this.cAt.Bx();
        aVar.csY.gln = str;
        aVar.csY.mBS = 1;
        v.i("MicroMsg.NetSceneGetVoiceprintTicketRsa", "sceneType %d %s", new Object[]{Integer.valueOf(1), str});
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.v.e eVar2) {
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
        return 618;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        ar.b bVar = (ar.b) pVar.ze();
        this.cZU = bVar.csZ.mBT;
        v.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " mTicket: " + this.cZU);
        if (i2 == 4 && i3 == -301) {
            al.a(true, bVar.csZ.mgK, bVar.csZ.mgL, bVar.csZ.mgJ);
            this.czX--;
            if (this.czX <= 0) {
                v.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "reach redirect limit, invoke callback");
                this.cii.a(3, -1, "", this);
                return;
            }
            v.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "redirect IDC");
            a(this.czE, this.cii);
        } else if (i2 == 4 && i3 == -102) {
            final int i4 = pVar.Bx().lWS.ver;
            v.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[]{Integer.valueOf(i4)});
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ e kor;

                public final void run() {
                    new m().a(this.kor.czE, new com.tencent.mm.v.e(this) {
                        final /* synthetic */ AnonymousClass1 kos;

                        {
                            this.kos = r1;
                        }

                        public final void a(int i, int i2, String str, k kVar) {
                            v.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
                            if (i == 0 && i2 == 0) {
                                this.kos.kor.a(this.kos.kor.czE, this.kos.kor.cii);
                            } else {
                                this.kos.kor.cii.a(i, i2, "", this.kos.kor);
                            }
                        }
                    });
                }
            });
        } else if (i2 == 0 || i3 == 0) {
            this.cii.a(i2, i3, str, this);
        } else {
            this.cii.a(i2, i3, str, this);
        }
    }
}
