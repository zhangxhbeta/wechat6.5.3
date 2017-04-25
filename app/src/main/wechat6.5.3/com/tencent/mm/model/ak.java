package com.tencent.mm.model;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.a.o;
import com.tencent.mm.compatible.b.d;
import com.tencent.mm.e.a.i;
import com.tencent.mm.e.a.w;
import com.tencent.mm.e.b.af;
import com.tencent.mm.kernel.api.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.zero.a.h;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.c.ku;
import com.tencent.mm.protocal.c.on;
import com.tencent.mm.protocal.c.uy;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.q;
import com.tencent.mm.protocal.t;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ac.b;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.u;
import com.tencent.mm.v.c;
import com.tencent.mm.v.n;
import com.tencent.mm.v.r;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.utils.TbsLog;
import junit.framework.Assert;

public final class ak {
    private static ak csx = null;
    private final c crW;
    private final int csA = 1;
    private c csB;
    private bp csC = new bp();
    private bi csD = new bi();
    private e csE = new e();
    private bo csF = new bo();
    private br csG = new br();
    private p csH = new p();
    private com.tencent.mm.model.a.c csI = new com.tencent.mm.model.a.c();
    private a csJ = new a(this) {
        final /* synthetic */ ak csM;

        {
            this.csM = r1;
        }

        public final void a(aa aaVar, u uVar) {
            String str = uVar.field_username;
            if (u.ew(uVar.field_username)) {
                uVar.setUsername(u.LM(uVar.field_username));
            }
            if (be.kS(uVar.pE())) {
                uVar.bT(com.tencent.mm.platformtools.c.lU(uVar.field_nickname));
            }
            if (be.kS(uVar.pF())) {
                uVar.bU(com.tencent.mm.platformtools.c.lT(uVar.field_nickname));
            }
            if (be.kS(uVar.field_conRemarkPYShort)) {
                uVar.bX(com.tencent.mm.platformtools.c.lU(uVar.field_conRemark));
            }
            if (be.kS(uVar.field_conRemarkPYFull)) {
                uVar.bW(com.tencent.mm.platformtools.c.lT(uVar.field_conRemark));
            }
            if (m.d(uVar)) {
                uVar.cP(43);
                uVar.bT(com.tencent.mm.platformtools.c.lU(uVar.tT()));
                uVar.bU(com.tencent.mm.platformtools.c.lT(uVar.tT()));
                uVar.bW(com.tencent.mm.platformtools.c.lT(uVar.tU()));
                uVar.bX(uVar.tU());
                return;
            }
            if (m.fn(str)) {
                u uVar2;
                uVar.tp();
                uVar.cU(4);
                uVar.cP(33);
                if (uVar == null) {
                    uVar2 = new u();
                } else {
                    uVar2 = uVar;
                }
                uVar2.setUsername(str);
                uVar2.tp();
                s.v(uVar2);
                uVar2.tw();
            }
            if (uVar.tL()) {
                uVar.cP(uVar.tm());
            }
            if (m.fc(str)) {
                v.i("MicroMsg.MMCore", "update official account helper showhead %d", Integer.valueOf(31));
                uVar.cP(31);
            }
            if (uVar.tK()) {
                ak.yW();
                c.wK().c(new String[]{str}, "@blacklist");
            }
            v.d("MicroMsg.MMCore", "onPreInsertContact2: %s, %s", uVar.field_username, uVar.pE());
        }
    };
    private b csK = new b(this) {
        final /* synthetic */ ak csM;

        {
            this.csM = r1;
        }

        public final void a(ab abVar, ac acVar) {
            if (abVar != null) {
                if (!u.LH(abVar.field_username) && !u.LJ(abVar.field_username) && !u.ew(abVar.field_username) && !m.eD(abVar.field_username)) {
                    return;
                }
                at ap;
                ac.c cVar;
                PString pString;
                PString pString2;
                PInt pInt;
                if (u.ew(abVar.field_username)) {
                    ab abVar2;
                    Object obj;
                    ab Mh = acVar.Mh("floatbottle");
                    if (Mh == null) {
                        abVar2 = new ab("floatbottle");
                        obj = 1;
                    } else {
                        abVar2 = Mh;
                        obj = null;
                    }
                    abVar2.dg(1);
                    abVar2.df(g.xD());
                    ak.yW();
                    ap = c.wJ().ap(8, " and not ( type = 10000 and isSend != 2 ) ");
                    if (ap == null || ap.field_msgId <= 0) {
                        abVar2.bvG();
                    } else {
                        abVar2.M(ap);
                        abVar2.setContent(u.LM(ap.field_talker) + ":" + ap.field_content);
                        abVar2.ct(Integer.toString(ap.field_type));
                        cVar = acVar.nuA;
                        if (cVar != null) {
                            pString = new PString();
                            pString2 = new PString();
                            pInt = new PInt();
                            ap.cH("floatbottle");
                            ap.setContent(abVar2.field_content);
                            cVar.a(ap, pString, pString2, pInt, false);
                            abVar2.cu(pString.value);
                            abVar2.cv(pString2.value);
                            abVar2.dj(pInt.value);
                        }
                    }
                    if (obj != null) {
                        acVar.d(abVar2);
                    } else {
                        acVar.a(abVar2, abVar2.field_username, true);
                    }
                } else if (!u.LH(abVar.field_username) && !u.LJ(abVar.field_username)) {
                    if (m.eD(abVar.field_username) && !be.kS(abVar.field_parentRef)) {
                        Object obj2;
                        ab Mh2 = acVar.Mh(abVar.field_parentRef);
                        v.v("MicroMsg.MMCore", "postConvExt, username = %s, parentRef = %s", abVar.field_username, abVar.field_parentRef);
                        if (abVar.field_parentRef.equals("officialaccounts")) {
                            obj2 = null;
                        } else {
                            obj2 = 1;
                        }
                        if (Mh2 == null) {
                            r1 = new ab(abVar.field_parentRef);
                            if (obj2 != null) {
                                r1.ek(2097152);
                            }
                            r6 = 1;
                            r7 = r1;
                        } else {
                            r6 = null;
                            r7 = Mh2;
                        }
                        v.i("MicroMsg.MMCore", "enterprise cvs count is %d", Integer.valueOf(r7.field_unReadCount));
                        ak.yW();
                        String Mr = c.wK().Mr(abVar.field_parentRef);
                        ak.yW();
                        ap = c.wJ().MI(Mr);
                        if (ap == null || ap.field_msgId <= 0) {
                            r7.bvG();
                        } else {
                            r7.M(ap);
                            r7.setContent(ap.field_talker + ":" + ap.field_content);
                            r7.ct(Integer.toString(ap.field_type));
                            cVar = acVar.nuA;
                            if (cVar != null) {
                                pString = new PString();
                                pString2 = new PString();
                                pInt = new PInt();
                                ap.cH(abVar.field_parentRef);
                                ap.setContent(r7.field_content);
                                cVar.a(ap, pString, pString2, pInt, true);
                                r7.cu(pString.value);
                                r7.cv(pString2.value);
                                r7.dj(pInt.value);
                            }
                        }
                        Object obj3 = null;
                        if (obj2 != null) {
                            ak.yW();
                            if (c.wK().Mq(r7.field_username) <= 0) {
                                obj3 = 1;
                            }
                        }
                        if (obj3 != null) {
                            acVar.Mf(r7.field_username);
                        } else if (r6 != null) {
                            acVar.d(r7);
                        } else {
                            acVar.a(r7, r7.field_username, true);
                        }
                    }
                    if ("@blacklist".equals(abVar.field_parentRef)) {
                        ak.yW();
                        com.tencent.mm.e.b.ab LX = c.wH().LX(abVar.field_username);
                        if (LX != null && !be.kS(LX.field_username) && !LX.tK()) {
                            ak.yW();
                            c.wK().c(new String[]{abVar.field_username}, SQLiteDatabase.KeyEmpty);
                        }
                    }
                } else if (!u.LH(abVar.field_username)) {
                    ap = null;
                    if (u.LJ(abVar.field_username)) {
                        af abVar3;
                        Object obj4;
                        r1 = acVar.Mh("qmessage");
                        if (r1 == null) {
                            abVar3 = new ab("qmessage");
                            obj4 = 1;
                        } else {
                            abVar3 = r1;
                            obj4 = null;
                        }
                        ak.yW();
                        au wJ = c.wJ();
                        g.vx();
                        Long l = (Long) g.vw().vf().get(12295, null);
                        abVar3.df(wJ.el(l == null ? 0 : l.longValue()));
                        ak.yW();
                        r6 = obj4;
                        r7 = abVar3;
                        ap = c.wJ().ap(2, " and not ( type = 10000 and isSend != 2 ) ");
                    } else {
                        r6 = null;
                        af afVar = null;
                    }
                    if (ap == null || ap.field_msgId <= 0) {
                        r7.bvG();
                    } else {
                        r7.M(ap);
                        r7.setContent(ap.field_talker + ":" + ap.field_content);
                        r7.ct(Integer.toString(ap.field_type));
                        cVar = acVar.nuA;
                        if (cVar != null) {
                            pString = new PString();
                            pString2 = new PString();
                            pInt = new PInt();
                            ap.cH("qmessage");
                            ap.setContent(r7.field_content);
                            cVar.a(ap, pString, pString2, pInt, false);
                            r7.cu(pString.value);
                            r7.cv(pString2.value);
                            r7.dj(pInt.value);
                        }
                    }
                    if (r6 != null) {
                        acVar.d(r7);
                    } else {
                        acVar.a(r7, r7.field_username, true);
                    }
                }
            }
        }
    };
    private b csL = new b(this) {
        final /* synthetic */ ak csM;

        {
            this.csM = r1;
        }

        public final void a(ab abVar, ac acVar) {
            if (abVar != null) {
            }
        }
    };
    private final z csw;
    private d csy = null;
    private bm csz = null;

    static /* synthetic */ void a(ak akVar) {
        com.tencent.mm.v.d.c.aw(Integer.valueOf(9999));
        com.tencent.mm.v.d.c.aw(Integer.valueOf(41));
        com.tencent.mm.v.d.c.aw(Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE));
        com.tencent.mm.v.d.c.aw(Integer.valueOf(CdnLogic.MediaType_FAVORITE_VIDEO));
        com.tencent.mm.v.d.c.aw(Integer.valueOf(21));
        com.tencent.mm.v.d.c.aw(Integer.valueOf(35));
        com.tencent.mm.v.d.c.aw(Integer.valueOf(-1879048175));
        com.tencent.mm.v.d.c.aw(Integer.valueOf(-1879048174));
        com.tencent.mm.v.d.c.aw(Integer.valueOf(-1879048184));
    }

    static /* synthetic */ void c(ak akVar) {
        c.wH().a(akVar.csJ);
        c.wK().a(akVar.csL);
        c.wK().a(akVar.csK, null);
        com.tencent.mm.v.d.c.a(Integer.valueOf(9999), akVar.csC);
        com.tencent.mm.v.d.c.a(Integer.valueOf(41), akVar.csD);
        com.tencent.mm.v.d.c.a(Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE), akVar.csF);
        com.tencent.mm.v.d.c.a(Integer.valueOf(CdnLogic.MediaType_FAVORITE_VIDEO), akVar.csF);
        com.tencent.mm.v.d.c.a(Integer.valueOf(21), akVar.csE);
        com.tencent.mm.v.d.c.a(Integer.valueOf(35), akVar.csE);
        com.tencent.mm.v.d.c.a(Integer.valueOf(-1879048175), akVar.csG);
        com.tencent.mm.v.d.c.a(Integer.valueOf(-1879048174), akVar.csH);
        com.tencent.mm.v.d.c.a(Integer.valueOf(-1879048184), akVar.csI);
    }

    public static boolean yN() {
        return csx == null;
    }

    public static c yO() {
        return yR().csB;
    }

    public static void a(c cVar) {
        yR().csB = cVar;
    }

    public static void a(m mVar) {
        g.vx();
        g.vv().cjD.add(mVar);
    }

    public static void b(m mVar) {
        g.vx();
        g.vv().cjD.remove(mVar);
    }

    public static void a(y yVar) {
        g.a(yVar);
    }

    public static void dQ(String str) {
        com.tencent.mm.kernel.a.dQ(str);
    }

    public static bm yP() {
        return yR().csz;
    }

    public static bq vz() {
        yR();
        return g.vz();
    }

    public static void a(x xVar) {
        e vw = g.vw();
        synchronized (vw.cjY) {
            vw.cjY.add(xVar);
        }
    }

    public static boolean uE() {
        return com.tencent.mm.kernel.a.uE();
    }

    public static void yQ() {
        com.tencent.mm.kernel.a.aK(false);
    }

    public static boolean uF() {
        return com.tencent.mm.kernel.a.uF();
    }

    public static void aL(boolean z) {
        com.tencent.mm.kernel.a.aL(z);
    }

    public static byte[] uT() {
        try {
            g.vx();
            return g.vv().uT();
        } catch (Throwable e) {
            v.w("MicroMsg.MMCore", "get session key error, %s", e.getMessage());
            v.e("MicroMsg.MMCore", "exception:%s", be.e(e));
            return null;
        }
    }

    public static void a(z zVar, n.a aVar) {
        csx = new ak(zVar, aVar);
        com.tencent.mm.modelstat.n.bh(com.tencent.mm.sdk.platformtools.aa.getContext());
    }

    public static aa oH() {
        return yR().csw.oH();
    }

    public static u oJ() {
        return yR().csw.oJ();
    }

    private ak(z zVar, n.a aVar) {
        this.csw = zVar;
        this.csz = new bm();
        final c.a anonymousClass1 = new c.a(this) {
            final /* synthetic */ ak csM;

            {
                this.csM = r1;
            }

            public final void xC() {
                ak.a(this.csM);
                this.csM.csz.zT();
            }

            public final void a(c cVar, boolean z) {
                ak.c(this.csM);
                this.csM.csz.aG(z);
                ak.yW();
                long er = c.wE().er(Thread.currentThread().getId());
                v.d("MicroMsg.MMCore", "dkwt set forceManual :%b", Boolean.valueOf(z));
                if (z) {
                    c.wH().Mc("readerapp");
                    c.vf().set(FileUtils.S_IRUSR, Boolean.valueOf(true));
                    for (u uVar : m.yu()) {
                        if (!(uVar == null || ((int) uVar.chr) == 0 || uVar.field_showHead != 32)) {
                            uVar.cP(uVar.tm());
                            v.d("MicroMsg.HardCodeUpdateTask", "contact to updatefavour " + uVar.field_username);
                            ak.yW();
                            c.wH().a(uVar.field_username, uVar);
                        }
                    }
                    for (String str : m.crG) {
                        com.tencent.mm.e.b.ab LX = c.wH().LX(str);
                        if (LX != null && (((int) LX.chr) != 0 || com.tencent.mm.i.a.ei(LX.field_type))) {
                            LX.tw();
                            c.wH().a(str, LX);
                        }
                    }
                    t.yA();
                    t.yz();
                    ax.fR("ver" + com.tencent.mm.protocal.d.lWh);
                }
                s sVar = new s(this.csM.crW);
                if (z) {
                    s.u(c.wH().LX("filehelper"));
                    String xF = k.xF();
                    if (!be.kS(xF)) {
                        com.tencent.mm.e.b.ab LX2 = c.wH().LX(xF);
                        if (((int) LX2.chr) == 0) {
                            LX2.setUsername(xF);
                            LX2.tp();
                            ak.yW();
                            c.wH().N(LX2);
                        } else if (!com.tencent.mm.i.a.ei(LX2.field_type)) {
                            LX2.tp();
                            ak.yW();
                            c.wH().a(xF, LX2);
                        }
                    }
                    s.a(z, "qqmail", false);
                    if (1 == s.a(z, "qqsync", false)) {
                        c.vf().set(65792, Boolean.valueOf(true));
                        c.vf().set(65794, Long.valueOf(be.Nh() - 1123200));
                    }
                    s.a(z, "floatbottle", false);
                    s.a(z, "shakeapp", false);
                    s.a(z, "lbsapp", false);
                    s.a(z, "medianote", false);
                    s.a(z, "newsapp", true);
                    c.wK().Mf("blogapp");
                    c.wJ().MO("blogapp");
                    c.wH().Mc("blogapp");
                    s.a(z, "facebookapp", true);
                    s.a(z, "qqfriend", false);
                    s.a(z, "masssendapp", true);
                    s.a(z, "feedsapp", true);
                    c.wK().Mf("tmessage");
                    c.wH().Mc("tmessage");
                    s.a(z, "qmessage", false);
                    com.tencent.mm.i.a LX3 = c.wH().LX("voip");
                    com.tencent.mm.i.a LX4 = c.wH().LX("voipapp");
                    if (LX4 == null) {
                        LX4 = new u();
                    }
                    if (!(LX3 == null || ((int) LX3.chr) == 0)) {
                        c.wH().Mc("voip");
                    }
                    if (((int) LX4.chr) == 0) {
                        LX4.setUsername("voipapp");
                        LX4.tp();
                        s.v(LX4);
                        LX4.cU(4);
                        LX4.tw();
                        c.wH().O(LX4);
                    } else if (z) {
                        LX4.tw();
                        c.wH().a("voipapp", LX4);
                    }
                    LX4 = c.wH().LX("officialaccounts");
                    if (LX4 == null) {
                        LX4 = new u();
                    }
                    v.i("MicroMsg.HardCodeHelper", "hardcodeOfficialAccounts:update[%B], contactID[%d]", Boolean.valueOf(z), Integer.valueOf((int) LX4.chr));
                    if (((int) LX4.chr) == 0) {
                        LX4.setUsername("officialaccounts");
                        LX4.tq();
                        s.v(LX4);
                        LX4.cU(3);
                        c.wH().O(LX4);
                    } else if (z) {
                        v.i("MicroMsg.HardCodeHelper", "do update hardcode official accounts");
                        LX4.tq();
                        c.wH().a("officialaccounts", LX4);
                    }
                    LX3 = c.wH().LX("voipaudio");
                    LX4 = c.wH().LX("voicevoipapp");
                    if (LX4 == null) {
                        LX4 = new u();
                    }
                    if (!(LX3 == null || ((int) LX3.chr) == 0)) {
                        c.wH().Mc("voipaudio");
                    }
                    if (((int) LX4.chr) == 0) {
                        LX4.setUsername("voicevoipapp");
                        LX4.tp();
                        s.v(LX4);
                        LX4.cU(4);
                        LX4.tw();
                        c.wH().O(LX4);
                    } else if (z) {
                        LX4.tw();
                        c.wH().a("voicevoipapp", LX4);
                    }
                    s.a(z, "voiceinputapp", false);
                    s.a(z, "googlecontact", false);
                    s.a(z, "linkedinplugin", false);
                    LX4 = c.wH().LX("notifymessage");
                    if (LX4 == null) {
                        LX4 = new u();
                    }
                    v.i("MicroMsg.HardCodeHelper", "hardcodeOfficialAccounts:update[%B], contactID[%d]", Boolean.valueOf(z), Integer.valueOf((int) LX4.chr));
                    if (((int) LX4.chr) == 0) {
                        LX4.setUsername("notifymessage");
                        LX4.tq();
                        s.v(LX4);
                        LX4.cU(3);
                        c.wH().O(LX4);
                    } else if (z) {
                        v.i("MicroMsg.HardCodeHelper", "do update hardcode official accounts");
                        LX4.tq();
                        c.wH().a("notifymessage", LX4);
                    }
                    LX4 = c.wH().LX("appbrandcustomerservicemsg");
                    if (LX4 == null) {
                        LX4 = new u();
                    }
                    v.i("MicroMsg.HardCodeHelper", "hardcodeAppBrandServiceMessage:update[%B], contactID[%d]", Boolean.valueOf(z), Integer.valueOf((int) LX4.chr));
                    if (((int) LX4.chr) == 0) {
                        LX4.setUsername("appbrandcustomerservicemsg");
                        LX4.tq();
                        s.v(LX4);
                        LX4.setType(0);
                        LX4.cU(3);
                        c.wH().O(LX4);
                    } else if (z) {
                        v.i("MicroMsg.HardCodeHelper", "do update app brand service message accunt");
                        LX4.tq();
                        c.wH().a("appbrandcustomerservicemsg", LX4);
                    }
                    if (z) {
                        ak.yW();
                        c.wK().Mf("Weixin");
                        ak.yW();
                        c.wH().Mc("Weixin");
                    }
                }
                ak.yW();
                c.wE().es(er);
                c.wK().nuA = ak.yR().csw.oI();
                com.tencent.mm.sdk.c.a.nhr.z(new i());
            }

            public final void aH(boolean z) {
                this.csM.csz.aH(z);
            }
        };
        g.vx().ckK.ay(new f(this) {
            final /* synthetic */ ak csM;

            public final void a(com.tencent.mm.kernel.a aVar) {
                anonymousClass1.xC();
            }

            public final void a(com.tencent.mm.kernel.a aVar, boolean z) {
                anonymousClass1.a(this.csM.crW, z);
                anonymousClass1.aH(com.tencent.mm.compatible.util.f.sj());
            }
        });
        g.vx().ckM.ay(aVar);
        g vx = g.vx();
        if (!vx.ckI) {
            vx.ckI = true;
        }
        this.crW = new c();
        com.tencent.mm.plugin.report.service.g.iuh.a(99, 142, 1, false);
        r.a(new h(this) {
            final /* synthetic */ ak csM;

            {
                this.csM = r1;
            }

            public final boolean a(PBool pBool, PByteArray pByteArray, r rVar, int i, byte[] bArr, byte[] bArr2, boolean z) {
                long j;
                l.c cVar = rVar.czA;
                l.a aVar = (l.a) cVar;
                long j2 = (long) cVar.lWM;
                if (com.tencent.mm.sdk.b.b.bsI() && j2 == 0) {
                    j = com.tencent.mm.protocal.d.lWg;
                } else {
                    j = j2;
                }
                ad adVar = cVar.lWS;
                if (i == 1000) {
                    byte[] Cb = rVar.Cb();
                    v.d("MicroMsg.MMCore", "BakMove key:" + Cb);
                    if (!adVar.brJ()) {
                        Cb = new byte[0];
                    }
                    if (be.bl(Cb)) {
                        v.e("MicroMsg.MMCore", "dksession jType %d session should not null", Integer.valueOf(i));
                        pBool.value = false;
                        return true;
                    }
                    if (MMProtocalJni.pack(aVar.zf(), pByteArray, Cb, bArr, cVar.lWP, (int) j, aVar.zg(), adVar.ver, adVar.lXA.getBytes(), adVar.lXB.getBytes(), bArr2, z)) {
                        pBool.value = true;
                        v.d("MicroMsg.MMCore", "reqToBuf using protobuf ok, len:%d", Integer.valueOf(pByteArray.value.length));
                    }
                    return true;
                } else if (i != 722) {
                    return false;
                } else {
                    v.e("MicroMsg.MMCore", "MMEncryptCheckResUpdate reqToBuf rsaReqData");
                    on onVar = ((com.tencent.mm.protocal.r.a) cVar).lXi;
                    byte[][] a = r.a(j, onVar.mqP, onVar.mqQ);
                    if (a == null) {
                        pBool.value = false;
                        return true;
                    }
                    byte[] bArr3 = a[0];
                    byte[] bArr4 = a[1];
                    if (MMProtocalJni.packHybrid(pByteArray, bArr, cVar.lWP, (int) j, aVar.zg(), adVar.ver, bArr3, bArr4, adVar.lXA.getBytes(), adVar.lXB.getBytes(), rVar.Cb(), z)) {
                        v.d("MicroMsg.MMCore", "IRemoteReqDelegate reqToBuf packHybrid using protobuf ok, len:%d", Integer.valueOf(pByteArray.value.length));
                        pBool.value = true;
                    }
                    return true;
                }
            }

            public final byte[] a(l.c cVar, int i) {
                switch (i) {
                    case MMGIFException.D_GIF_ERR_WRONG_RECORD /*107*/:
                        return ((com.tencent.mm.protocal.v.a) cVar).lXp.mgD.mQw.toByteArray();
                    case 145:
                        return ((com.tencent.mm.protocal.n.a) cVar).lWY.mgD.mQw.toByteArray();
                    case 261:
                        return ((aq.a) cVar).csW.mgD.mQw.toByteArray();
                    case 429:
                        return ((com.tencent.mm.protocal.u.a) cVar).lXn.mgD.mQw.toByteArray();
                    case 481:
                        return ((q.a) cVar).lXg.mgD.mQw.toByteArray();
                    case 499:
                        return ((com.tencent.mm.plugin.report.b.b.a) cVar).itt.mgD.mQw.toByteArray();
                    case 572:
                        return ((t.a) cVar).lXm.mgD.mQw.toByteArray();
                    case 616:
                        return ((ap.a) cVar).csU.mgD.mQw.toByteArray();
                    case 617:
                        return ((at.a) cVar).ctc.mgD.mQw.toByteArray();
                    case 618:
                        return ((ar.a) cVar).csY.mgD.mQw.toByteArray();
                    case 627:
                        return ((as.a) cVar).cta.mgD.mQw.toByteArray();
                    case 694:
                        return ((com.tencent.mm.plugin.report.b.a.a) cVar).itt.mgD.mQw.toByteArray();
                    case 722:
                        return ((com.tencent.mm.protocal.r.a) cVar).lXi.mqP.mgD.mQw.toByteArray();
                    case 987:
                    case TbsLog.TBSLOG_CODE_SDK_INVOKE_ERROR /*997*/:
                        return ((ku) ((com.tencent.mm.v.b.b) cVar).czs).mnp.toByteArray();
                    case 989:
                        return ((uy) ((com.tencent.mm.v.b.b) cVar).czs).mnp.toByteArray();
                    case 1000:
                        return ((k.a) cVar).lWK;
                    default:
                        return null;
                }
            }
        });
        g.vx();
        com.tencent.mm.kernel.b vv = g.vv();
        vv.cjB.ay(new com.tencent.mm.kernel.api.c(this) {
            final /* synthetic */ ak csM;

            {
                this.csM = r1;
            }

            public final void b(com.tencent.mm.network.e eVar) {
                p.e(eVar);
                p.f(eVar);
            }
        });
    }

    private static ak yR() {
        Assert.assertNotNull("MMCore not initialized by MMApplication", csx);
        return csx;
    }

    public static com.tencent.mm.v.v yS() {
        g.vx();
        return g.vu().cjh;
    }

    public static com.tencent.mm.storage.q yT() {
        g.vx();
        return g.vw().cjT;
    }

    public static com.tencent.mm.sdk.platformtools.ad vA() {
        return g.vA();
    }

    public static bo yU() {
        return yR().csF;
    }

    public static String uR() {
        return com.tencent.mm.kernel.a.uR();
    }

    public static void uS() {
        com.tencent.mm.kernel.a.uS();
    }

    public static int dR(String str) {
        return com.tencent.mm.kernel.a.dR(str);
    }

    public static void vi() {
        g.vx();
        g.vw().vi();
    }

    public static void yV() {
        com.tencent.mm.sdk.c.a.nhr.z(new w());
    }

    public static c yW() {
        c cVar = yR().crW;
        Assert.assertTrue("MMCore has not been initialize ?", cVar != null);
        return cVar;
    }

    public static n vy() {
        g.vx();
        return g.vv().cjC;
    }

    public static d yX() {
        if (yR().csy == null) {
            yR().csy = new d(com.tencent.mm.sdk.platformtools.aa.getContext());
        }
        return yR().csy;
    }

    public static void release() {
        g.vx().releaseAll();
    }

    public static void fH(String str) {
        g vx = g.vx();
        v.w("MicroMsg.MMKernel", "logoutAccount uin:%s info:%s stack:%s", o.getString(vx.ckC.uin), str, be.bur());
        com.tencent.mm.kernel.a.dQ(be.bur().toString() + str);
        vx.ckC.cjh.S((long) vx.ckC.uin);
        vx.releaseAll();
        com.tencent.mm.kernel.a.uC();
        com.tencent.mm.kernel.a.aJ(false);
        com.tencent.mm.kernel.a.aK(false);
        com.tencent.mm.kernel.a.aL(false);
    }

    public static boolean uM() {
        return com.tencent.mm.kernel.a.uM();
    }

    public static int uQ() {
        return com.tencent.mm.kernel.a.uQ();
    }

    public static boolean uN() {
        return com.tencent.mm.kernel.a.uN();
    }

    public static boolean uz() {
        return g.uz();
    }

    public static boolean yY() {
        return com.tencent.mm.kernel.a.uO();
    }

    public static boolean yZ() {
        g.vx();
        return g.vu().cjo;
    }

    public static boolean uP() {
        return com.tencent.mm.kernel.a.uP();
    }

    public static boolean uG() {
        return com.tencent.mm.kernel.a.uG();
    }

    public static void hold() {
        com.tencent.mm.kernel.a.hold();
    }

    public static void unhold() {
        com.tencent.mm.kernel.a.unhold();
    }

    public static String uA() {
        g.vx();
        g.vu();
        return com.tencent.mm.kernel.a.uA();
    }
}
