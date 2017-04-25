package com.tencent.mm.modelbiz;

import com.tencent.mm.bg.g.c;
import com.tencent.mm.e.b.af;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bo;
import com.tencent.mm.model.e;
import com.tencent.mm.modelbiz.a.b;
import com.tencent.mm.modelbiz.a.d;
import com.tencent.mm.modelbiz.a.g;
import com.tencent.mm.modelbiz.a.h;
import com.tencent.mm.modelbiz.a.i;
import com.tencent.mm.modelbiz.a.k;
import com.tencent.mm.modelbiz.j.a;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.t;
import java.util.HashMap;
import java.util.Map;

public class u implements ag {
    private static HashMap<Integer, c> bXq;
    private static long cDh = 0;
    private d cDi;
    private a cDj = null;
    private i cDk = null;
    private h cDl;
    private g cDm = null;
    private d cDn = null;
    private b cDo = null;
    private k cDp = null;
    private g cDq = null;
    private i cDr = null;
    private h cDs = null;
    private c cDt = null;
    private a cDu;
    private bo.b cDv = new bo.b(this) {
        final /* synthetic */ u cDy;

        {
            this.cDy = r1;
        }

        public final void a(com.tencent.mm.v.d.a aVar) {
            bm bmVar = aVar.czu;
            if (bmVar == null) {
                v.e("MicroMsg.SubCoreBiz", "AddMsg is null.");
                return;
            }
            String a = m.a(bmVar.mbW);
            if (be.kS(a)) {
                v.e("MicroMsg.SubCoreBiz", "msg content is null");
                return;
            }
            Map q = bf.q(a, "sysmsg");
            if (q == null || q.size() <= 0) {
                v.e("MicroMsg.SubCoreBiz", "receiveMessage, no sysmsg");
                return;
            }
            if ("mmbizattrappsvr_BizAttrSync".equalsIgnoreCase((String) q.get(".sysmsg.$type"))) {
                v.i("MicroMsg.SubCoreBiz", "BizAttrSync openFlag : %d.", Integer.valueOf(be.getInt((String) q.get(".sysmsg.mmbizattrappsvr_BizAttrSync.openflag"), 0)));
                ak.yW();
                com.tencent.mm.model.c.vf().a(t.a.USERINFO_BIZ_ATTR_SYNC_OPEN_FLAG_INT, Integer.valueOf(r0));
                ak.yW();
                com.tencent.mm.model.c.vf().iB(true);
                return;
            }
            v.e("MicroMsg.SubCoreBiz", "receiveMessage, type not BizAttrSync.");
        }
    };
    private ac.b cDw = new ac.b(this) {
        final /* synthetic */ u cDy;

        {
            this.cDy = r1;
        }

        public final void a(ab abVar, ac acVar) {
            if (abVar != null && !be.kS(abVar.field_username)) {
                String str = abVar.field_username;
                ak.yW();
                com.tencent.mm.storage.u LX = com.tencent.mm.model.c.wH().LX(str);
                if (LX != null && LX.bvm() && !com.tencent.mm.model.m.eP(str)) {
                    BizInfo ho = u.Dy().ho(str);
                    if (ho.nmb == -1) {
                        v.i("MicroMsg.SubCoreBiz", "onMsgChangeNotify: no bizInfo");
                    } else if (ho.CA()) {
                        if (ho.aX(false) == null) {
                            abVar.cw(null);
                            v.e("MicroMsg.SubCoreBiz", "getExtInfo() == null");
                        } else if (ho.aX(false).CZ() == null) {
                            abVar.cw(null);
                            v.e("MicroMsg.SubCoreBiz", "enterpriseBizInfo == null");
                        } else if (ho.CB()) {
                            abVar.cw(null);
                        } else {
                            abVar.cw(be.ma(ho.CF()));
                            if (be.kS(ho.CF())) {
                                v.w("MicroMsg.SubCoreBiz", "Enterprise belong is null:%s", abVar.field_username);
                            }
                        }
                    } else if (ho.Cw() || ho.Cz() || com.tencent.mm.model.m.fl(str)) {
                        abVar.cw(null);
                    } else {
                        abVar.cw("officialaccounts");
                    }
                }
            }
        }
    };
    private d.a cDx = new d.a(this) {
        final /* synthetic */ u cDy;

        {
            this.cDy = r1;
        }

        public final void a(d.a.b bVar) {
            if ((bVar.cCL == d.a.a.cCH || bVar.cCL == d.a.a.cCJ) && bVar.cCM != null) {
                ak.yW();
                com.tencent.mm.e.b.ab LX = com.tencent.mm.model.c.wH().LX(bVar.cBj);
                if (LX == null) {
                    return;
                }
                if (!LX.bvm()) {
                    u.h(bVar.cCM);
                } else if (!com.tencent.mm.model.m.eP(LX.field_username)) {
                    ak.yW();
                    ab Mh = com.tencent.mm.model.c.wK().Mh(bVar.cBj);
                    v.v("MicroMsg.SubCoreBiz", "hakon onEvent bizName = %s", bVar.cBj);
                    if (!(!bVar.cCM.CA() || bVar.cCM.aX(false) == null || bVar.cCM.aX(false).CZ() == null || be.kS(bVar.cCM.CF()) || !be.kS(bVar.cCM.field_enterpriseFather))) {
                        bVar.cCM.field_enterpriseFather = bVar.cCM.CF();
                        u.Dy().e(bVar.cCM);
                        v.i("MicroMsg.SubCoreBiz", "hakon bizStgExt, %s set enterpriseFather %s", bVar.cBj, bVar.cCM.field_enterpriseFather);
                    }
                    if (Mh != null) {
                        String str;
                        boolean z;
                        if (bVar.cCM.CA()) {
                            if (bVar.cCM.aX(false) == null) {
                                v.e("MicroMsg.SubCoreBiz", "getExtInfo() == null");
                                return;
                            } else if (bVar.cCM.aX(false).CZ() == null) {
                                v.e("MicroMsg.SubCoreBiz", "enterpriseBizInfo == null");
                                return;
                            } else {
                                str = Mh.field_parentRef;
                                if (bVar.cCM.CB()) {
                                    Mh.cw(null);
                                } else {
                                    v.i("MicroMsg.SubCoreBiz", "Enterprise belong %s, userName: %s", bVar.cCM.CF(), bVar.cBj);
                                    Mh.cw(be.ma(bVar.cCM.CF()));
                                }
                                if (str != null && Mh.field_parentRef != null && !str.equals(Mh.field_parentRef)) {
                                    z = true;
                                } else if (str == null && Mh.field_parentRef != null) {
                                    z = true;
                                } else if (str == null || Mh.field_parentRef != null) {
                                    z = false;
                                } else {
                                    z = true;
                                }
                                v.v("MicroMsg.SubCoreBiz", "hakon isEnterpriseChildType, %s, %s", bVar.cBj, Mh.field_parentRef);
                            }
                        } else if (bVar.cCM.Cz()) {
                            v.v("MicroMsg.SubCoreBiz", "hakon isEnterpriseFatherType, %s", bVar.cBj);
                            z = true;
                        } else if (!bVar.cCM.Cw() && !com.tencent.mm.model.m.fl(LX.field_username) && !"officialaccounts".equals(Mh.field_parentRef)) {
                            Mh.cw("officialaccounts");
                            z = true;
                        } else if (!bVar.cCM.Cw() || Mh.field_parentRef == null) {
                            z = false;
                        } else {
                            Mh.cw(null);
                            z = true;
                        }
                        if (z) {
                            ak.yW();
                            com.tencent.mm.model.c.wK().a(Mh, Mh.field_username, true);
                            if (!be.kS(Mh.field_parentRef)) {
                                af Mh2;
                                at MI;
                                if ("officialaccounts".equals(Mh.field_parentRef)) {
                                    ak.yW();
                                    Mh2 = com.tencent.mm.model.c.wK().Mh("officialaccounts");
                                    if (Mh2 == null) {
                                        Mh2 = new ab("officialaccounts");
                                        Mh2.bvG();
                                        ak.yW();
                                        com.tencent.mm.model.c.wK().d(Mh2);
                                    }
                                    if (be.kS(Mh2.field_content)) {
                                        v.i("MicroMsg.SubCoreBiz", "conv content is null");
                                        ak.yW();
                                        str = com.tencent.mm.model.c.wK().bvM();
                                        if (be.kS(str)) {
                                            v.w("MicroMsg.SubCoreBiz", "last convBiz is null");
                                            return;
                                        }
                                        ak.yW();
                                        MI = com.tencent.mm.model.c.wJ().MI(str);
                                        if (MI == null || MI.field_msgId == 0) {
                                            v.w("MicroMsg.SubCoreBiz", "last biz msg is error");
                                            return;
                                        }
                                        ak.yW();
                                        com.tencent.mm.model.c.wJ().a(MI.field_msgId, MI);
                                        return;
                                    }
                                    return;
                                }
                                v.i("MicroMsg.SubCoreBiz", "hakon username = %s, parentRef = %s", bVar.cBj, Mh.field_parentRef);
                                ak.yW();
                                Mh2 = com.tencent.mm.model.c.wK().Mh(Mh.field_parentRef);
                                if (Mh2 != null && be.kS(Mh2.field_content)) {
                                    v.i("MicroMsg.SubCoreBiz", "conv content is null");
                                    ak.yW();
                                    str = com.tencent.mm.model.c.wK().Mr(Mh.field_parentRef);
                                    if (be.kS(str)) {
                                        v.w("MicroMsg.SubCoreBiz", "last enterprise convBiz is null");
                                        return;
                                    }
                                    ak.yW();
                                    MI = com.tencent.mm.model.c.wJ().MI(str);
                                    if (MI == null || MI.field_msgId == 0) {
                                        v.w("MicroMsg.SubCoreBiz", "last enterprise biz msg is error");
                                        return;
                                    }
                                    ak.yW();
                                    com.tencent.mm.model.c.wJ().a(MI.field_msgId, MI);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private e csE = new e();

    static /* synthetic */ void h(BizInfo bizInfo) {
        if (bizInfo.CA() && !bizInfo.CB() && bizInfo.aX(false) != null && bizInfo.aX(false).CZ() != null && !be.kS(bizInfo.CF())) {
            ak.yW();
            if (com.tencent.mm.model.c.wK().Mh(bizInfo.CF()) == null) {
                v.d("MicroMsg.SubCoreBiz", "father conv is null");
            }
            ak.yW();
            if (com.tencent.mm.model.c.wK().Mh(bizInfo.field_username) == null) {
                v.v("MicroMsg.SubCoreBiz", "add empty conv for enterprise child %s", bizInfo.field_username);
                ab abVar = new ab(bizInfo.field_username);
                if (!bizInfo.CB()) {
                    v.i("MicroMsg.SubCoreBiz", "Enterprise belong %s, userName: %s", bizInfo.CF(), bizInfo.field_username);
                    abVar.cw(be.ma(bizInfo.CF()));
                    abVar.bvG();
                    ak.yW();
                    com.tencent.mm.model.c.wK().d(abVar);
                }
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        bXq = hashMap;
        hashMap.put(Integer.valueOf("BIZINFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return d.cic;
            }
        });
        bXq.put(Integer.valueOf("BIZKF_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return h.cic;
            }
        });
        bXq.put(Integer.valueOf("BIZCHAT_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return d.cic;
            }
        });
        bXq.put(Integer.valueOf("BIZCHATUSER_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return k.cic;
            }
        });
        bXq.put(Integer.valueOf("BIZCONVERSATION_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return b.cic;
            }
        });
        bXq.put(Integer.valueOf("BIZCHAMYUSERINFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return g.cic;
            }
        });
        bXq.put(Integer.valueOf("BIZENTERPRISE_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return c.cic;
            }
        });
    }

    private static u Dw() {
        u uVar = (u) ak.yP().fY(u.class.getName());
        if (uVar != null) {
            return uVar;
        }
        Object uVar2 = new u();
        ak.yP().a(u.class.getName(), uVar2);
        return uVar2;
    }

    public static h Dx() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (Dw().cDl == null) {
            u Dw = Dw();
            ak.yW();
            Dw.cDl = new h(com.tencent.mm.model.c.wE());
        }
        return Dw().cDl;
    }

    public static d Dy() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (Dw().cDi == null) {
            u Dw = Dw();
            ak.yW();
            Dw.cDi = new d(com.tencent.mm.model.c.wE());
        }
        return Dw().cDi;
    }

    public static g Dz() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (Dw().cDm == null) {
            Dw().cDm = new g();
            com.tencent.mm.v.e eVar = Dw().cDm;
            ak.vy().a(675, eVar);
            ak.vy().a(672, eVar);
            ak.vy().a(674, eVar);
            synchronized (eVar.cCN) {
                eVar.cCP.clear();
            }
        }
        return Dw().cDm;
    }

    public static d DA() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (Dw().cDn == null) {
            u Dw = Dw();
            ak.yW();
            Dw.cDn = new d(com.tencent.mm.model.c.wE());
        }
        return Dw().cDn;
    }

    public static b DB() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (Dw().cDo == null) {
            u Dw = Dw();
            ak.yW();
            Dw.cDo = new b(com.tencent.mm.model.c.wE());
        }
        return Dw().cDo;
    }

    public static k DC() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (Dw().cDp == null) {
            u Dw = Dw();
            ak.yW();
            Dw.cDp = new k(com.tencent.mm.model.c.wE());
        }
        return Dw().cDp;
    }

    public static g DD() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (Dw().cDq == null) {
            u Dw = Dw();
            ak.yW();
            Dw.cDq = new g(com.tencent.mm.model.c.wE());
        }
        return Dw().cDq;
    }

    public static h DE() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (Dw().cDs == null) {
            Dw().cDs = new h();
        }
        return Dw().cDs;
    }

    public static c DF() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (Dw().cDt == null) {
            u Dw = Dw();
            ak.yW();
            Dw.cDt = new c(com.tencent.mm.model.c.wE());
        }
        return Dw().cDt;
    }

    public static a DG() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (Dw().cDj == null) {
            Dw().cDj = new a();
        }
        return Dw().cDj;
    }

    public static i DH() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (Dw().cDk == null) {
            Dw().cDk = new i();
        }
        return Dw().cDk;
    }

    public static a DI() {
        if (Dw().cDu == null) {
            Dw().cDu = new a();
        }
        return Dw().cDu;
    }

    public static i DJ() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (Dw().cDr == null) {
            Dw().cDr = new i();
        }
        return Dw().cDr;
    }

    public static long DK() {
        if (cDh == 0) {
            ak.yW();
            Object obj = com.tencent.mm.model.c.vf().get(t.a.USERINFO_NEED_TO_UPDATE_CONVERSATION_TIME_DIVIDER_LONG, null);
            if (obj != null && (obj instanceof Long)) {
                cDh = ((Long) obj).longValue();
                v.i("MicroMsg.SubCoreBiz", "temp session needUpdateTime : %d.(get from ConfigStorage)", Long.valueOf(cDh));
            }
        }
        if (cDh == 0) {
            cDh = System.currentTimeMillis();
            ak.yW();
            com.tencent.mm.model.c.vf().a(t.a.USERINFO_NEED_TO_UPDATE_CONVERSATION_TIME_DIVIDER_LONG, Long.valueOf(cDh));
            v.i("MicroMsg.SubCoreBiz", "temp session needUpdateTime is 0, so get current time : %d.", Long.valueOf(cDh));
        }
        return cDh;
    }

    public final HashMap<Integer, c> ti() {
        return bXq;
    }

    public final void ed(int i) {
    }

    public static void DL() {
        Dw();
        v.i("MicroMsg.SubCoreBiz", "resetResContextImp");
    }

    public final void aG(boolean z) {
        com.tencent.mm.v.d.c.a(Integer.valueOf(55), this.csE);
        com.tencent.mm.v.d.c.a(Integer.valueOf(57), this.csE);
        ak.yW();
        com.tencent.mm.model.c.wK().a(this.cDw);
        Dy().a(this.cDx);
        ak.yU().a("mmbizattrappsvr_BizAttrSync", this.cDv, true);
    }

    public final void th() {
        com.tencent.mm.v.d.c.aw(Integer.valueOf(55));
        com.tencent.mm.v.d.c.aw(Integer.valueOf(57));
        if (Dw().cDm != null) {
            com.tencent.mm.v.e eVar = Dw().cDm;
            ak.vy().b(675, eVar);
            ak.vy().b(672, eVar);
            ak.vy().b(674, eVar);
            synchronized (eVar.cCN) {
                eVar.cCP.clear();
            }
            eVar.cCO.clear();
        }
        if (ak.uz()) {
            ak.yW();
            com.tencent.mm.model.c.wK().b(this.cDw);
            Dy().b(this.cDx);
        }
        ak.yU().b("mmbizattrappsvr_BizAttrSync", this.cDv, true);
    }

    public final void aH(boolean z) {
    }
}
