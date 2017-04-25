package com.tencent.mm.plugin.chatroom;

import com.tencent.mm.e.a.if;
import com.tencent.mm.e.a.ig;
import com.tencent.mm.e.a.ih;
import com.tencent.mm.e.a.ii;
import com.tencent.mm.e.a.im;
import com.tencent.mm.e.a.ow;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.chatroom.b.a;
import com.tencent.mm.plugin.chatroom.c.e;
import com.tencent.mm.plugin.chatroom.c.f;
import com.tencent.mm.plugin.chatroom.c.g;
import com.tencent.mm.plugin.chatroom.c.i;
import com.tencent.mm.plugin.chatroom.c.l;
import com.tencent.mm.pluginsdk.d.c;
import com.tencent.mm.v.k;
import java.util.HashMap;

public class b implements ag {
    private static a eOz;
    private c<if> eOt = new c<if>(this) {
        final /* synthetic */ b eOA;

        {
            this.eOA = r1;
        }

        public final /* bridge */ /* synthetic */ com.tencent.mm.sdk.c.b a(int i, k kVar, com.tencent.mm.sdk.c.b bVar) {
            return (if) bVar;
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            if ifVar = (if) bVar;
            if (ifVar.bil.bin) {
                c.x(ifVar);
            } else {
                y(ifVar);
            }
            return false;
        }

        public final /* synthetic */ k b(com.tencent.mm.sdk.c.b bVar) {
            return new e(((if) bVar).bil.bim);
        }

        public final int acY() {
            return 181;
        }
    };
    private c<ii> eOu = new c<ii>(this) {
        final /* synthetic */ b eOA;

        {
            this.eOA = r1;
        }

        public final /* bridge */ /* synthetic */ com.tencent.mm.sdk.c.b a(int i, k kVar, com.tencent.mm.sdk.c.b bVar) {
            return (ii) bVar;
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            ii iiVar = (ii) bVar;
            if (iiVar.biD.bin) {
                c.x(iiVar);
            } else {
                y(iiVar);
            }
            return false;
        }

        public final /* synthetic */ k b(com.tencent.mm.sdk.c.b bVar) {
            ii iiVar = (ii) bVar;
            return new i(iiVar.biD.biB, iiVar.biD.biE);
        }

        public final int acY() {
            return 551;
        }
    };
    private c<ih> eOv = new c<ih>(this) {
        final /* synthetic */ b eOA;

        {
            this.eOA = r1;
        }

        public final /* bridge */ /* synthetic */ com.tencent.mm.sdk.c.b a(int i, k kVar, com.tencent.mm.sdk.c.b bVar) {
            ih ihVar = (ih) bVar;
            ihVar.biA.errCode = i;
            return ihVar;
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            ih ihVar = (ih) bVar;
            if (ihVar.biz.bin) {
                c.x(ihVar);
            } else {
                y(ihVar);
            }
            return false;
        }

        public final /* synthetic */ k b(com.tencent.mm.sdk.c.b bVar) {
            ih ihVar = (ih) bVar;
            return new g(ihVar.biz.biB, ihVar.biz.biC, ihVar.biz.scene);
        }

        public final int acY() {
            return 179;
        }
    };
    private c<im> eOw = new c<im>(this) {
        final /* synthetic */ b eOA;

        {
            this.eOA = r1;
        }

        public final /* bridge */ /* synthetic */ com.tencent.mm.sdk.c.b a(int i, k kVar, com.tencent.mm.sdk.c.b bVar) {
            im imVar = (im) bVar;
            imVar.biV.errCode = i;
            return imVar;
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            im imVar = (im) bVar;
            if (imVar.biU.bin) {
                c.x(imVar);
            } else {
                y(imVar);
            }
            return false;
        }

        public final /* synthetic */ k b(com.tencent.mm.sdk.c.b bVar) {
            im imVar = (im) bVar;
            return new l(imVar.biU.biW, imVar.biU.biB);
        }

        public final int acY() {
            return 700;
        }
    };
    private c<ig> eOx = new c<ig>(this) {
        final /* synthetic */ b eOA;

        {
            this.eOA = r1;
        }

        public final /* bridge */ /* synthetic */ com.tencent.mm.sdk.c.b a(int i, k kVar, com.tencent.mm.sdk.c.b bVar) {
            ig igVar = (ig) bVar;
            f fVar = (f) kVar;
            igVar.bip.bis = fVar.bis;
            igVar.bip.bit = fVar.bit;
            igVar.bip.biu = fVar.biu;
            igVar.bip.biv = fVar.eON;
            igVar.bip.biy = fVar.biy;
            igVar.bip.biw = fVar.biw;
            igVar.bip.bix = fVar.bix;
            return igVar;
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            ig igVar = (ig) bVar;
            if (igVar.bio.bin) {
                c.x(igVar);
            } else {
                y(igVar);
            }
            return false;
        }

        public final /* synthetic */ k b(com.tencent.mm.sdk.c.b bVar) {
            ig igVar = (ig) bVar;
            return new f(igVar.bio.biq, igVar.bio.bir);
        }

        public final int acY() {
            return 119;
        }
    };
    private com.tencent.mm.sdk.c.c eOy = new com.tencent.mm.sdk.c.c<ow>(this) {
        final /* synthetic */ b eOA;

        {
            this.eOA = r2;
            this.nhz = ow.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            ow owVar = (ow) bVar;
            if (owVar.bqh.bqi.equals(if.class.getName())) {
                if (owVar.bqh.bdf == 1) {
                    this.eOA.eOt.bmG();
                } else {
                    this.eOA.eOt.avH();
                }
            } else if (owVar.bqh.bqi.equals(ii.class.getName())) {
                if (owVar.bqh.bdf == 1) {
                    this.eOA.eOu.bmG();
                } else {
                    this.eOA.eOu.avH();
                }
            } else if (owVar.bqh.bqi.equals(ig.class.getName())) {
                if (owVar.bqh.bdf == 1) {
                    this.eOA.eOx.bmG();
                } else {
                    this.eOA.eOx.avH();
                }
            } else if (owVar.bqh.bqi.equals(ih.class.getName())) {
                if (owVar.bqh.bdf == 1) {
                    this.eOA.eOv.bmG();
                } else {
                    this.eOA.eOv.avH();
                }
            } else if (owVar.bqh.bqi.equals(im.class.getName())) {
                if (owVar.bqh.bdf == 1) {
                    this.eOA.eOw.bmG();
                } else {
                    this.eOA.eOw.avH();
                }
            }
            return false;
        }
    };

    private static b acW() {
        b bVar = (b) ak.yP().fY("plugin.chatroom");
        if (bVar == null) {
            synchronized (b.class) {
                if (bVar == null) {
                    bVar = new b();
                    ak.yP().a("plugin.chatroom", bVar);
                }
            }
        }
        return bVar;
    }

    private static a acX() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        acW();
        if (eOz == null) {
            acW();
            eOz = new a();
        }
        acW();
        return eOz;
    }

    public final HashMap<Integer, com.tencent.mm.bg.g.c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        com.tencent.mm.sdk.c.a.nhr.e(this.eOy);
        com.tencent.mm.sdk.c.a.nhr.e(this.eOt);
        com.tencent.mm.sdk.c.a.nhr.e(this.eOx);
        com.tencent.mm.sdk.c.a.nhr.e(this.eOu);
        com.tencent.mm.sdk.c.a.nhr.e(this.eOv);
        com.tencent.mm.sdk.c.a.nhr.e(this.eOw);
        a acX = acX();
        ak.yU().a("NewXmlChatRoomAccessVerifyApplication", acX.eOK, true);
        ak.yU().a("NewXmlChatRoomAccessVerifyApproval", acX.eOK, true);
    }

    public final void aH(boolean z) {
    }

    public final void th() {
        com.tencent.mm.sdk.c.a.nhr.f(this.eOy);
        com.tencent.mm.sdk.c.a.nhr.f(this.eOt);
        com.tencent.mm.sdk.c.a.nhr.f(this.eOx);
        com.tencent.mm.sdk.c.a.nhr.f(this.eOu);
        com.tencent.mm.sdk.c.a.nhr.f(this.eOv);
        com.tencent.mm.sdk.c.a.nhr.f(this.eOw);
        a acX = acX();
        ak.yU().b("NewXmlChatRoomAccessVerifyApplication", acX.eOK, true);
        ak.yU().b("NewXmlChatRoomAccessVerifyApproval", acX.eOK, true);
    }
}
