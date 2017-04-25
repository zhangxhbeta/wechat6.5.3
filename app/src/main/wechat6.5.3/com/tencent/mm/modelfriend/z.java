package com.tencent.mm.modelfriend;

import com.tencent.mm.model.ak;
import com.tencent.mm.modelsimple.m;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.u.b;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.i;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class z extends k implements j {
    public final p cAt = new a();
    e cii = null;

    public static class a extends i {
        private final com.tencent.mm.protocal.u.a cIj = new com.tencent.mm.protocal.u.a();
        private final b cIk = new b();

        protected final c zd() {
            return this.cIj;
        }

        public final d ze() {
            return this.cIk;
        }

        public final int getType() {
            return 429;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/getsuggestalias";
        }

        public final int Bu() {
            return 1;
        }
    }

    public z(String str, String str2, int i, String str3, String str4, String str5, String str6) {
        com.tencent.mm.protocal.u.a aVar = (com.tencent.mm.protocal.u.a) this.cAt.Bx();
        aVar.lXn.mAO = str;
        aVar.lXn.mAP = str2;
        aVar.lXn.efy = str3;
        aVar.lXn.mAQ = str4;
        aVar.lXn.mAR = str5;
        aVar.lXn.mAS = str6;
        aVar.lXn.mAT = i;
        aVar.lXn.fvz = u.bsY();
        aVar.lXn.mep = ak.uR();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cAt, this);
    }

    public final int getType() {
        return 429;
    }

    protected final int ul() {
        return 3;
    }

    protected final int a(p pVar) {
        return b.czU;
    }

    protected final void a(a aVar) {
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (i2 == 4 && i3 == -102) {
            final int i4 = pVar.Bx().lWS.ver;
            v.d("MicroMsg.NetSceneGetSuggestAlias", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", Integer.valueOf(i4));
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ z cIh;

                public final void run() {
                    new m().a(this.cIh.czE, new e(this) {
                        final /* synthetic */ AnonymousClass1 cIi;

                        {
                            this.cIi = r1;
                        }

                        public final void a(int i, int i2, String str, k kVar) {
                            v.d("MicroMsg.NetSceneGetSuggestAlias", "summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
                            if (i == 0 && i2 == 0) {
                                this.cIi.cIh.a(this.cIi.cIh.czE, this.cIi.cIh.cii);
                            } else {
                                this.cIi.cIh.cii.a(i, i2, SQLiteDatabase.KeyEmpty, this.cIi.cIh);
                            }
                        }
                    });
                }
            });
            return;
        }
        this.cii.a(i2, i3, str, this);
    }

    public final byte[] Fv() {
        return com.tencent.mm.platformtools.m.a(((b) this.cAt.ze()).lXo.mAU, new byte[0]);
    }

    public final String Fw() {
        return ((b) this.cAt.ze()).lXo.mAR;
    }
}
