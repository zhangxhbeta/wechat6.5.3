package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.ap.a;
import com.tencent.mm.modelsimple.m;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mm.v.k.b;

public final class g extends k implements j {
    private final p cAt = new a();
    e cii;
    String koo = "";
    int kop = 0;
    private String koq = "";

    public g(String str) {
        a aVar = (a) this.cAt.Bx();
        v.i("MicroMsg.NetSceneRsaGetVoicePrintResource", "sceneType %d %s", new Object[]{Integer.valueOf(73), str});
        aVar.csU.mBP = 73;
        aVar.csU.mBQ = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cAt, this);
    }

    public final int getType() {
        return 616;
    }

    protected final int ul() {
        return 3;
    }

    protected final int a(p pVar) {
        return b.czU;
    }

    protected final void a(k.a aVar) {
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        ap.b bVar = (ap.b) pVar.ze();
        if (i2 == 4 && i3 == -102) {
            final int i4 = pVar.Bx().lWS.ver;
            v.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[]{Integer.valueOf(i4)});
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ g koA;

                public final void run() {
                    new m().a(this.koA.czE, new e(this) {
                        final /* synthetic */ AnonymousClass1 koB;

                        {
                            this.koB = r1;
                        }

                        public final void a(int i, int i2, String str, k kVar) {
                            v.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
                            if (i == 0 && i2 == 0) {
                                this.koB.koA.a(this.koB.koA.czE, this.koB.koA.cii);
                            } else {
                                this.koB.koA.cii.a(i, i2, "", this.koB.koA);
                            }
                        }
                    });
                }
            });
        } else if (i2 == 0 || i3 == 0) {
            if (bVar.csV.mBR != null) {
                this.koo = new String(bVar.csV.mBR.mQb.mQw.lVU);
                this.kop = bVar.csV.mBR.mPA;
                v.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "resid %d mVertifyKey %s mtext %s", new Object[]{Integer.valueOf(this.kop), this.koq, this.koo});
            } else {
                v.e("MicroMsg.NetSceneRsaGetVoicePrintResource", "resp ResourceData null ");
            }
            this.cii.a(i2, i3, str, this);
        } else {
            this.cii.a(i2, i3, str, this);
        }
    }
}
