package com.tencent.mm.plugin.aa;

import android.widget.Toast;
import com.tencent.mm.bg.g.c;
import com.tencent.mm.e.a.bb;
import com.tencent.mm.e.a.bc;
import com.tencent.mm.e.a.kn;
import com.tencent.mm.e.a.ko;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.aa.a.a;
import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.plugin.aa.a.j;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vending.g.g;
import java.util.HashMap;

public final class b implements ag {
    private static HashMap<Integer, c> bXq;
    private com.tencent.mm.sdk.c.c<ko> drr = new com.tencent.mm.sdk.c.c<ko>(this) {
        final /* synthetic */ b drx;

        {
            this.drx = r2;
            this.nhz = ko.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            ko koVar = (ko) bVar;
            String str = "MicroMsg.SubCoreAA";
            String str2 = "receiveAANewXmlEventListener, content==null: %s, type: %s, fromUser: %s, toUser: %s, paymsgid: %s";
            Object[] objArr = new Object[5];
            objArr[0] = Boolean.valueOf(koVar.blR.content == null);
            objArr[1] = Integer.valueOf(koVar.blR.type);
            objArr[2] = koVar.blR.bhM;
            objArr[3] = koVar.blR.toUser;
            objArr[4] = koVar.blR.blS;
            v.i(str, str2, objArr);
            if (koVar.blR.type == a.drX) {
                h.ak(koVar.blR.content, koVar.blR.toUser);
            } else if (koVar.blR.type == a.drY) {
                h.q(koVar.blR.content, koVar.blR.toUser, koVar.blR.blS);
            } else if (koVar.blR.type == a.drZ) {
                String str3 = koVar.blR.content;
                str = koVar.blR.toUser;
                v.i("MicroMsg.AAUtil", "insertUrgePaySysMsg, toUser: %s", new Object[]{str});
                if (!be.kS(str3) && m.dE(str)) {
                    at atVar = new at();
                    atVar.di(0);
                    atVar.cH(str);
                    atVar.dh(3);
                    atVar.setContent(str3);
                    atVar.z(aw.h(str3, System.currentTimeMillis() / 1000));
                    atVar.setType(10000);
                    atVar.dr(atVar.field_flag | 8);
                    atVar.x(aw.e(atVar));
                }
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c<kn> drs = new com.tencent.mm.sdk.c.c<kn>(this) {
        final /* synthetic */ b drx;

        {
            this.drx = r2;
            this.nhz = kn.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            kn knVar = (kn) bVar;
            v.i("MicroMsg.SubCoreAA", "ReceiveAAMsgEvent, localMsgId: %s, msgContent: %s", new Object[]{Long.valueOf(knVar.blP.blQ), be.KW(knVar.blP.blu)});
            h.d(r0, r2);
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c<bb> drt = new com.tencent.mm.sdk.c.c<bb>(this) {
        final /* synthetic */ b drx;

        {
            this.drx = r2;
            this.nhz = bb.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            bb bbVar = (bb) bVar;
            v.i("MicroMsg.SubCoreAA", "closeAAEvent callback, billNo: %s, chatroom: %s", new Object[]{bbVar.aYD.aYE, bbVar.aYD.aYF});
            if (!(be.kS(bbVar.aYD.aYE) || be.kS(bbVar.aYD.aYF))) {
                final j jVar = new j();
                jVar.Nz().init();
                j.a aVar = jVar.dsu;
                String str = bbVar.aYD.aYE;
                int i = a.drW;
                g.a(str, Integer.valueOf(i), bbVar.aYD.aYF, Long.valueOf(bbVar.aYD.aYG)).c(aVar).d(new com.tencent.mm.vending.c.a<Void, Boolean>(this) {
                    final /* synthetic */ AnonymousClass3 drz;

                    public final /* synthetic */ Object aq(Object obj) {
                        v.i("MicroMsg.SubCoreAA", "close aa success: %s", new Object[]{(Boolean) obj});
                        jVar.Nz().Ny();
                        Toast.makeText(aa.getContext(), 2131231940, 0).show();
                        return phb;
                    }
                }).a(new d.a(this) {
                    final /* synthetic */ AnonymousClass3 drz;

                    public final void aA(Object obj) {
                        if (obj instanceof String) {
                            Toast.makeText(aa.getContext(), obj.toString(), 0).show();
                        } else {
                            v.e("MicroMsg.SubCoreAA", "close aa failed: %s", new Object[]{obj});
                            Toast.makeText(aa.getContext(), 2131231942, 1).show();
                        }
                        jVar.Nz().Ny();
                    }
                });
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c<bc> dru = new com.tencent.mm.sdk.c.c<bc>(this) {
        final /* synthetic */ b drx;

        {
            this.drx = r2;
            this.nhz = bc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            final bc bcVar = (bc) bVar;
            if (!(be.kS(bcVar.aYH.aYE) || be.kS(bcVar.aYH.aYF))) {
                new com.tencent.mm.plugin.aa.a.a.c(bcVar.aYH.aYE, bcVar.aYH.aYF).Bt().a(new com.tencent.mm.vending.c.a<Void, com.tencent.mm.v.a.a<com.tencent.mm.protocal.c.c>>(this) {
                    final /* synthetic */ AnonymousClass4 drB;

                    public final /* synthetic */ Object aq(Object obj) {
                        com.tencent.mm.v.a.a aVar = (com.tencent.mm.v.a.a) obj;
                        v.i("MicroMsg.SubCoreAA", "close aa urge notify cgiback, errType: %s, errCode: %s", new Object[]{Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode)});
                        if (aVar.errType == 0 && aVar.errCode == 0) {
                            v.i("MicroMsg.SubCoreAA", "close aa urge notify success");
                            if (((com.tencent.mm.protocal.c.c) aVar.bra).hKq > 0 && !be.kS(((com.tencent.mm.protocal.c.c) aVar.bra).hKr)) {
                                Toast.makeText(aa.getContext(), ((com.tencent.mm.protocal.c.c) aVar.bra).hKr, 0).show();
                                com.tencent.mm.plugin.report.service.g.iuh.a(407, 29, 1, false);
                            } else if (((com.tencent.mm.protocal.c.c) aVar.bra).hKq == 0) {
                                Toast.makeText(aa.getContext(), 2131231940, 0).show();
                                com.tencent.mm.plugin.report.service.g.iuh.a(407, 27, 1, false);
                                if (!be.kS(((com.tencent.mm.protocal.c.c) aVar.bra).lYy)) {
                                    h.e(bcVar.aYH.aYG, ((com.tencent.mm.protocal.c.c) aVar.bra).lYy);
                                }
                            } else {
                                v.i("MicroMsg.SubCoreAA", "illegal resp");
                                com.tencent.mm.plugin.report.service.g.iuh.a(407, 29, 1, false);
                            }
                        } else {
                            v.i("MicroMsg.SubCoreAA", "close aa urge notify failed");
                            Toast.makeText(aa.getContext(), 2131231939, 1).show();
                            com.tencent.mm.plugin.report.service.g.iuh.a(407, 28, 1, false);
                        }
                        return phb;
                    }
                });
            }
            return false;
        }
    };
    private com.tencent.mm.plugin.aa.a.b.d drv;
    private com.tencent.mm.plugin.aa.a.b.b drw;

    private static b Nn() {
        b bVar = (b) ak.yP().fY("plugin.aa");
        if (bVar != null) {
            return bVar;
        }
        bVar = new b();
        ak.yP().a("plugin.aa", bVar);
        return bVar;
    }

    static {
        HashMap hashMap = new HashMap();
        bXq = hashMap;
        hashMap.put(Integer.valueOf("AARecord".hashCode()), new c() {
            public final String[] pS() {
                return com.tencent.mm.plugin.aa.a.b.d.cic;
            }
        });
        bXq.put(Integer.valueOf("AAPayRecord".hashCode()), new c() {
            public final String[] pS() {
                return com.tencent.mm.plugin.aa.a.b.b.cic;
            }
        });
    }

    public final HashMap<Integer, c> ti() {
        return bXq;
    }

    public static com.tencent.mm.plugin.aa.a.b.d No() {
        if (Nn().drv == null) {
            b Nn = Nn();
            ak.yW();
            Nn.drv = new com.tencent.mm.plugin.aa.a.b.d(com.tencent.mm.model.c.wE());
        }
        return Nn().drv;
    }

    public static com.tencent.mm.plugin.aa.a.b.b Np() {
        if (Nn().drw == null) {
            b Nn = Nn();
            ak.yW();
            Nn.drw = new com.tencent.mm.plugin.aa.a.b.b(com.tencent.mm.model.c.wE());
        }
        return Nn().drw;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        com.tencent.mm.sdk.c.a.nhr.e(this.drr);
        com.tencent.mm.sdk.c.a.nhr.e(this.drs);
        com.tencent.mm.sdk.c.a.nhr.e(this.drt);
        com.tencent.mm.sdk.c.a.nhr.e(this.dru);
    }

    public final void aH(boolean z) {
    }

    public final void th() {
        com.tencent.mm.sdk.c.a.nhr.f(this.drr);
        com.tencent.mm.sdk.c.a.nhr.f(this.drs);
        com.tencent.mm.sdk.c.a.nhr.f(this.drt);
        com.tencent.mm.sdk.c.a.nhr.f(this.dru);
    }
}
