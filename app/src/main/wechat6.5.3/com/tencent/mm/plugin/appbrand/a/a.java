package com.tencent.mm.plugin.appbrand.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.bg.g;
import com.tencent.mm.e.a.hr;
import com.tencent.mm.e.a.ia;
import com.tencent.mm.e.a.ji;
import com.tencent.mm.e.a.ka;
import com.tencent.mm.e.a.kf;
import com.tencent.mm.e.a.kp;
import com.tencent.mm.e.a.m;
import com.tencent.mm.e.a.n;
import com.tencent.mm.e.a.o;
import com.tencent.mm.e.a.p;
import com.tencent.mm.e.a.pz;
import com.tencent.mm.e.a.rd;
import com.tencent.mm.e.a.re;
import com.tencent.mm.e.a.rf;
import com.tencent.mm.e.a.rg;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bo;
import com.tencent.mm.plugin.appbrand.appcache.i;
import com.tencent.mm.plugin.appbrand.appcache.l;
import com.tencent.mm.plugin.appbrand.appstorage.b;
import com.tencent.mm.plugin.appbrand.b.c;
import com.tencent.mm.plugin.appbrand.config.e;
import com.tencent.mm.plugin.appbrand.config.j;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.h.f;
import com.tencent.mm.plugin.appbrand.ipc.d;
import com.tencent.mm.plugin.appbrand.task.AppBrandTaskManager;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import com.tencent.mm.t.h;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public final class a implements ag {
    public static volatile b dzM;
    private static volatile j dzN;
    public static volatile e dzO;
    public static volatile l dzP;
    public static volatile com.tencent.mm.plugin.appbrand.contact.b dzQ;
    public static volatile f dzR;
    public static volatile c dzS;
    private static volatile com.tencent.mm.platformtools.g.a dzT;
    private static com.tencent.mm.plugin.appbrand.jsapi.map.a dzU;
    private final com.tencent.mm.sdk.c.c<p> dAa = new com.tencent.mm.sdk.c.c<p>(this) {
        final /* synthetic */ a dAk;

        {
            this.dAk = r2;
            this.nhz = p.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            final p pVar = (p) bVar;
            if (!be.kS(pVar.aWX.aWH)) {
                k.a(pVar.aWX.aWH, (com.tencent.mm.plugin.appbrand.config.k.a) com.tencent.mm.plugin.appbrand.k.a.aC(new com.tencent.mm.plugin.appbrand.config.k.a(this) {
                    final /* synthetic */ AnonymousClass4 dYT;

                    /* JADX WARNING: inconsistent code. */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void a(com.tencent.mm.plugin.appbrand.config.k.a.a r7, com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig r8) {
                        /*
                        r6 = this;
                        r5 = 1;
                        r4 = 0;
                        r0 = r4;
                        r0 = r0.aWX;
                        r0 = r0.aWY;
                        if (r0 == 0) goto L_0x003f;
                    L_0x000a:
                        r1 = com.tencent.mm.plugin.appbrand.a.a.OO();
                        r0 = r4;
                        r0 = r0.aWX;
                        r2 = r0.aWH;
                        r0 = com.tencent.mm.sdk.platformtools.be.kS(r2);
                        if (r0 != 0) goto L_0x0040;
                    L_0x001a:
                        r0 = new com.tencent.mm.t.h;
                        r0.<init>();
                        r0.field_brandId = r2;
                        r1 = r1.dDN;
                        r2 = new java.lang.String[r5];
                        r3 = "brandId";
                        r2[r4] = r3;
                        r1 = r1.b(r0, r2);
                        if (r1 == 0) goto L_0x0040;
                    L_0x0030:
                        r1 = r4;
                        r1 = r1.aWX;
                        r1 = r1.aWY;
                        r2 = r4;
                        r3 = new java.lang.Object[r5];
                        r3[r4] = r0;
                        r1.a(r2, r3);
                    L_0x003f:
                        return;
                    L_0x0040:
                        r0 = 0;
                        goto L_0x0030;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.a.a.4.1.a(com.tencent.mm.plugin.appbrand.config.k$a$a, com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig):void");
                    }
                }));
            }
            return false;
        }
    };
    private final com.tencent.mm.sdk.c.c<ia> dAb = new com.tencent.mm.sdk.c.c<ia>(this) {
        final /* synthetic */ a dAk;

        {
            this.dAk = r2;
            this.nhz = ia.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            u uVar = ((ia) bVar).bhU.bhV;
            if (u.dW(uVar.field_username)) {
                uVar.setType(0);
                com.tencent.mm.sdk.c.a.nhr.z(new p());
            }
            return false;
        }
    };
    private final com.tencent.mm.sdk.c.c<kp> dAc = new com.tencent.mm.sdk.c.c<kp>(this) {
        final /* synthetic */ a dAk;

        {
            this.dAk = r2;
            this.nhz = kp.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            at atVar = ((kp) bVar).blT.aXd;
            if (atVar != null) {
                String str = atVar.field_talker;
                if (u.dW(str)) {
                    a.dzO.aF(str + "_unreadCount", String.valueOf(be.getInt(a.dzO.get(str + "_unreadCount", "0"), 0) + 1));
                    ak.yW();
                    ab Mh = com.tencent.mm.model.c.wK().Mh(str);
                    d.Z(a.OO().nd(str), Mh != null ? Mh.field_unReadCount : 0);
                }
            }
            return false;
        }
    };
    private final com.tencent.mm.sdk.c.c<com.tencent.mm.e.a.l> dAd = new com.tencent.mm.sdk.c.c<com.tencent.mm.e.a.l>(this) {
        final /* synthetic */ a dAk;

        {
            this.dAk = r2;
            this.nhz = com.tencent.mm.e.a.l.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            com.tencent.mm.e.a.l lVar = (com.tencent.mm.e.a.l) bVar;
            if (!be.kS(lVar.aWF.aWH)) {
                lVar.aWG.aWI = be.getInt(a.dzO.get(lVar.aWF.aWH + "_unreadCount", "0"), 0);
            }
            return false;
        }
    };
    private final com.tencent.mm.sdk.c.c<m> dAe = new com.tencent.mm.sdk.c.c<m>(this) {
        final /* synthetic */ a dAk;

        {
            this.dAk = r2;
            this.nhz = m.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            m mVar = (m) bVar;
            if (be.kS(mVar.aWJ.aWH)) {
                mVar.aWK.aWL = false;
            } else {
                h c = a.OO().c(mVar.aWJ.aWH, new String[]{"BigHeadImgUrl", "roundedSquareIcon", "appName", "appIcon", "AppOpt", "appId"});
                if (c == null) {
                    mVar.aWK.aWL = false;
                } else {
                    mVar.aWK.appId = c.field_appId;
                    mVar.aWK.appName = c.field_appName;
                    mVar.aWK.aWM = c.field_appIcon;
                    mVar.aWK.aWN = c.field_AppOpt;
                    mVar.aWK.dHg = c.field_roundedSquareIcon;
                    mVar.aWK.cxh = c.field_BigHeadImgUrl;
                    mVar.aWK.aWL = true;
                }
            }
            return false;
        }
    };
    private final com.tencent.mm.sdk.c.c<ka> dAf = new com.tencent.mm.sdk.c.c<ka>(this) {
        final /* synthetic */ a dAk;

        {
            this.dAk = r2;
            this.nhz = ka.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return false;
        }
    };
    private final com.tencent.mm.sdk.c.c<com.tencent.mm.e.a.k> dAg = new com.tencent.mm.sdk.c.c<com.tencent.mm.e.a.k>(this) {
        final /* synthetic */ a dAk;

        {
            this.dAk = r2;
            this.nhz = com.tencent.mm.e.a.k.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            if (!((com.tencent.mm.e.a.k) bVar).aWD.aWE) {
                com.tencent.mm.plugin.appbrand.appcache.m.bu(false);
                com.tencent.mm.plugin.appbrand.b.d.ha(2);
            }
            return false;
        }
    };
    private final com.tencent.mm.sdk.c.c<n> dAh = new com.tencent.mm.sdk.c.c<n>(this) {
        final /* synthetic */ a dAk;

        {
            this.dAk = r2;
            this.nhz = n.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            n nVar = (n) bVar;
            com.tencent.mm.plugin.appbrand.report.a.a(nVar.aWO.aWH, nVar.aWO.appId, nVar.aWO.scene, nVar.aWO.aWP, nVar.aWO.aWQ, nVar.aWO.action, nVar.aWO.aWR, nVar.aWO.aWS, nVar.aWO.aWT, nVar.aWO.aWU);
            return true;
        }
    };
    private final com.tencent.mm.sdk.c.c<kf> dAi = new com.tencent.mm.sdk.c.c<kf>(this) {
        final /* synthetic */ a dAk;

        {
            this.dAk = r2;
            this.nhz = kf.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            kf kfVar = (kf) bVar;
            kfVar.bli.blj = AppBrandTaskManager.oo(kfVar.blh.appId);
            return true;
        }
    };
    private final bo.b dAj = new com.tencent.mm.plugin.appbrand.appcache.k();
    private final com.tencent.mm.sdk.c.c<rd> dLj = new com.tencent.mm.sdk.c.c<rd>(this) {
        final /* synthetic */ a dAk;

        {
            this.dAk = r2;
            this.nhz = rd.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            k.J(((rd) bVar).dDS.username, false);
            return true;
        }
    };
    private final com.tencent.mm.sdk.c.c<re> dLk = new com.tencent.mm.sdk.c.c<re>(this) {
        final /* synthetic */ a dAk;

        {
            this.dAk = r2;
            this.nhz = re.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            re reVar = (re) bVar;
            if (!be.kS(reVar.dDT.appId)) {
                reVar.dDU.version = a.dzP.om(reVar.dDT.appId);
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.h.g.a dWX;
    private ac.b dzV = new com.tencent.mm.plugin.appbrand.j.a();
    private final Set<com.tencent.mm.sdk.c.c> dzW = new HashSet();
    private final com.tencent.mm.sdk.c.c<hr> dzX = new com.tencent.mm.sdk.c.c<hr>(this) {
        final /* synthetic */ a dAk;

        {
            this.dAk = r2;
            this.nhz = hr.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            switch (((hr) bVar).bhA.bhB) {
                case 1:
                case 3:
                    AppBrandTaskManager.hb(1);
                    break;
                default:
                    AppBrandTaskManager.hb(0);
                    break;
            }
            return true;
        }
    };
    private final com.tencent.mm.sdk.c.c<o> dzY = new com.tencent.mm.sdk.c.c<o>(this) {
        final /* synthetic */ a dAk;

        {
            this.dAk = r2;
            this.nhz = o.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            boolean z = false;
            o oVar = (o) bVar;
            if (oVar.aWV.aWW.startsWith("//appbrandtest")) {
                oVar.aWV.aWW = oVar.aWV.aWW.substring(14).trim();
                if (oVar.aWV.aWW.startsWith("deletebetalibrary")) {
                    l lVar = a.dzP;
                    i iVar = new i();
                    iVar.field_appId = "@LibraryAppId";
                    iVar.field_debugType = 999;
                    iVar.field_version = 1;
                    lVar.dBg.c(iVar, i.dAV);
                }
                if (oVar.aWV.aWW.startsWith("prunepkg")) {
                    com.tencent.mm.plugin.appbrand.appcache.j.Pj();
                }
                if (oVar.aWV.aWW.startsWith("assert")) {
                    AppBrandTaskManager.hn(be.getInt(oVar.aWV.aWW.replace("assert ", ""), 0));
                }
                if (oVar.aWV.aWW.startsWith("deletecontact")) {
                    String trim = oVar.aWV.aWW.replaceFirst("deletecontact", "").trim();
                    j OO = a.OO();
                    if (!be.kS(trim)) {
                        OO.dBf.delete("AppBrandWxaAppInfo", String.format(Locale.US, "%s=?", new Object[]{"brandId"}), new String[]{trim});
                    }
                }
                if (oVar.aWV.aWW.startsWith("showhistorycount")) {
                    if (be.getInt(oVar.aWV.aWW.replaceFirst("showhistorycount", "").trim(), 0) > 0) {
                        z = true;
                    }
                    ak.yW();
                    com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.fVM, Boolean.valueOf(z));
                }
                if (oVar.aWV.aWW.startsWith("resetattrsync")) {
                    a.OO().wT(oVar.aWV.aWW.replaceFirst("resetattrsync", "").trim());
                }
            }
            return true;
        }
    };
    private final com.tencent.mm.sdk.c.c<pz> dzZ = new com.tencent.mm.sdk.c.c<pz>(this) {
        final /* synthetic */ a dAk;

        {
            this.dAk = r2;
            this.nhz = pz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            pz pzVar = (pz) bVar;
            if (!be.kS(pzVar.brl.aWH)) {
                int i;
                boolean z;
                j OO = a.OO();
                String str = pzVar.brl.aWH;
                int i2 = pzVar.brl.brn;
                if (pzVar.brl.action == 1) {
                    i = 1;
                } else {
                    boolean z2 = false;
                }
                if (be.kS(str)) {
                    z = false;
                } else {
                    Cursor query = OO.dBf.query("AppBrandWxaAppInfo", new String[]{"AppOpt"}, String.format("%s=?", new Object[]{"brandId"}), new String[]{str}, null, null, null);
                    if (query == null) {
                        z = false;
                    } else if (query.getCount() <= 0) {
                        query.close();
                        z = false;
                    } else {
                        query.moveToFirst();
                        int i3 = query.getInt(0);
                        query.close();
                        int i4 = i == 0 ? (i2 ^ -1) & i3 : i3 | i2;
                        ContentValues contentValues = new ContentValues(1);
                        contentValues.put("AppOpt", Integer.valueOf(i4));
                        boolean z3 = OO.dBf.update("AppBrandWxaAppInfo", contentValues, String.format("%s=?", new Object[]{"brandId"}), new String[]{str}) > 0;
                        if (z3) {
                            ji jiVar = new ji();
                            jiVar.bjM.aWH = str;
                            jiVar.bjM.bjN = i4;
                            com.tencent.mm.sdk.c.a.nhr.z(jiVar);
                            OO.PC();
                        }
                        z = z3;
                    }
                }
                pzVar.brm.bro = z;
            }
            return false;
        }
    };
    private final com.tencent.mm.sdk.c.c<rg> lIH = new com.tencent.mm.sdk.c.c<rg>(this) {
        final /* synthetic */ a dAk;

        {
            this.dAk = r2;
            this.nhz = rg.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            rg rgVar = (rg) bVar;
            if (!be.kS(rgVar.dRK.aWH)) {
                String str = rgVar.dRK.aWH;
                a.dzO.aF(str + "_unreadCount", rgVar.dRK.aWI);
                d.Z(a.OO().nd(str), rgVar.dRK.aWI);
            }
            return false;
        }
    };
    private final com.tencent.mm.sdk.c.c<rf> nnN = new com.tencent.mm.sdk.c.c<rf>(this) {
        final /* synthetic */ a dAk;

        {
            this.dAk = r2;
            this.nhz = rf.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            boolean dF = a.dzO.dBY.dF("AppBrandCommonKVData", "update AppBrandCommonKVData set value = '0' where key like '%_unreadCount'");
            v.i("MicroMsg.AppBrandCommonKVDataStorage", "sql:%s, updateRet : %b", new Object[]{"update AppBrandCommonKVData set value = '0' where key like '%_unreadCount'", Boolean.valueOf(dF)});
            return true;
        }
    };

    public static a SY() {
        return (a) ak.yP().fY("plugin.appbrand");
    }

    public final com.tencent.mm.platformtools.g.a ON() {
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        String stringBuilder2 = stringBuilder.append(com.tencent.mm.model.c.xp()).append("AppBrandComm.db").toString();
        if (dzT != null && stringBuilder2.equals(dzT.getPath())) {
            return dzT;
        }
        int hashCode = hashCode();
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf("AppPermissionDBCreate".hashCode()), new g.c(this) {
            final /* synthetic */ a dAk;

            {
                this.dAk = r1;
            }

            public final String[] pS() {
                return com.tencent.mm.plugin.appbrand.h.d.dBe;
            }
        });
        hashMap.put(Integer.valueOf("AppKVStorageDBCreate".hashCode()), new g.c(this) {
            final /* synthetic */ a dAk;

            {
                this.dAk = r1;
            }

            public final String[] pS() {
                return b.cic;
            }
        });
        hashMap.put(Integer.valueOf("AppSystemConfigStorageDBCreate".hashCode()), new g.c(this) {
            final /* synthetic */ a dAk;

            {
                this.dAk = r1;
            }

            public final String[] pS() {
                return j.dDM;
            }
        });
        hashMap.put(Integer.valueOf("AppBrandWxaPkgStorageDBCreate".hashCode()), new g.c(this) {
            final /* synthetic */ a dAk;

            {
                this.dAk = r1;
            }

            public final String[] pS() {
                return l.dBe;
            }
        });
        hashMap.put(Integer.valueOf("WxAppContactStorageCreate".hashCode()), new g.c(this) {
            final /* synthetic */ a dAk;

            {
                this.dAk = r1;
            }

            public final String[] pS() {
                return com.tencent.mm.plugin.appbrand.contact.b.dBH;
            }
        });
        hashMap.put(Integer.valueOf("AppBrandCommonConfigStorageCreate".hashCode()), new g.c(this) {
            final /* synthetic */ a dAk;

            {
                this.dAk = r1;
            }

            public final String[] pS() {
                return e.dBH;
            }
        });
        hashMap.put(Integer.valueOf("AppBrandLayoutStorageCreate".hashCode()), new g.c(this) {
            final /* synthetic */ a dAk;

            {
                this.dAk = r1;
            }

            public final String[] pS() {
                return c.dBH;
            }
        });
        com.tencent.mm.platformtools.g.a a = com.tencent.mm.platformtools.g.a(hashCode, stringBuilder2, hashMap, true);
        dzT = a;
        return a;
    }

    public final HashMap<Integer, g.c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        for (com.tencent.mm.sdk.c.c e : this.dzW) {
            com.tencent.mm.sdk.c.a.nhr.e(e);
        }
        ak.yU().a("AppBrandNotify", this.dAj, true);
        ak.yU().a("AppPublicLibraryNotify", this.dAj, true);
        ak.yU().a("mmbizwxaconfig", this.dAj, true);
        ak.yW();
        com.tencent.mm.model.c.wK().a(this.dzV);
        ON();
        OO();
        dzM = new b(dzT);
        dzO = new e(dzT);
        dzP = new l(dzT);
        dzQ = new com.tencent.mm.plugin.appbrand.contact.b(dzT);
        dzR = new f(dzT);
        dzS = new c(dzT);
        dzN.c(this.dWX);
        com.tencent.mm.plugin.appbrand.e.setup();
        com.tencent.mm.plugin.appbrand.b.d.ha(1);
        com.tencent.mm.plugin.appbrand.i.b.RL().prepare();
        com.tencent.mm.plugin.appbrand.appcache.m.bu(true);
        com.tencent.mm.plugin.appbrand.m.d dVar = new com.tencent.mm.plugin.appbrand.m.d();
        com.tencent.mm.modelsearch.p.a(dVar);
        dVar.create();
        com.tencent.mm.plugin.appbrand.m.g gVar = new com.tencent.mm.plugin.appbrand.m.g();
        com.tencent.mm.modelsearch.p.a(7, gVar);
        gVar.create();
        com.tencent.mm.ui.f.e.a(new com.tencent.mm.plugin.appbrand.m.e());
        com.tencent.mm.ui.f.e.a(new com.tencent.mm.plugin.appbrand.m.b());
    }

    public final void aH(boolean z) {
    }

    public final void th() {
        for (com.tencent.mm.sdk.c.c f : this.dzW) {
            com.tencent.mm.sdk.c.a.nhr.f(f);
        }
        com.tencent.mm.plugin.appbrand.e.release();
        ak.yU().b("AppBrandNotify", this.dAj, true);
        ak.yU().b("AppPublicLibraryNotify", this.dAj, true);
        ak.yU().b("mmbizwxaconfig", this.dAj, true);
        ak.yW();
        com.tencent.mm.model.c.wK().b(this.dzV);
        com.tencent.mm.plugin.appbrand.launching.c.QB();
        if (dzN != null) {
            dzN.d(this.dWX);
        }
        dzM = null;
        dzN = null;
        dzO = null;
        dzP = null;
        dzQ = null;
        dzR = null;
        dzS = null;
        if (dzT != null) {
            dzT.gG(hashCode());
            dzT = null;
        }
        com.tencent.mm.plugin.appbrand.i.b RL = com.tencent.mm.plugin.appbrand.i.b.RL();
        v.d("MicroMsg.WxaFTSSearchCore", "reset");
        com.tencent.mm.sdk.c.a.nhr.f(RL.dPX);
        com.tencent.mm.sdk.c.a.nhr.f(RL.dPY);
        com.tencent.mm.sdk.c.a.nhr.f(RL.owi);
        com.tencent.mm.plugin.appbrand.k.a.Sn();
        com.tencent.mm.modelsearch.p.gc(512);
        com.tencent.mm.modelsearch.p.gb(7);
        com.tencent.mm.ui.f.e.xZ(com.tencent.mm.plugin.appbrand.jsapi.map.f.CTRL_INDEX);
        com.tencent.mm.ui.f.e.xZ(4208);
    }

    public a() {
        this.dzW.add(this.dAg);
        this.dzW.add(new com.tencent.mm.plugin.appbrand.launching.a());
        this.dzW.add(new com.tencent.mm.plugin.appbrand.launching.b());
        this.dzW.add(this.dAh);
        this.dzW.add(this.dAf);
        this.dzW.add(this.dAe);
        this.dzW.add(this.dAa);
        this.dzW.add(this.dAb);
        this.dzW.add(this.dAc);
        this.dzW.add(this.dzZ);
        this.dzW.add(new com.tencent.mm.plugin.appbrand.config.f());
        this.dzW.add(this.dzY);
        this.dzW.add(new com.tencent.mm.plugin.appbrand.appcache.a());
        this.dzW.add(this.dzX);
        this.dzW.add(this.dAi);
        this.dzW.add(com.tencent.mm.plugin.appbrand.b.a.dBB);
        this.dzW.add(this.dAd);
        this.dzW.add(this.lIH);
        this.dzW.add(this.nnN);
        this.dzW.add(this.dLj);
        this.dzW.add(this.dLk);
        this.dWX = new com.tencent.mm.sdk.h.g.a(this) {
            final /* synthetic */ a dAk;

            {
                this.dAk = r1;
            }

            public final void a(String str, com.tencent.mm.sdk.h.i iVar) {
                if (a.dzS == null) {
                    v.w("MicroMsg.SubCoreAppBrand", "onNotifyChange by SysConfigStorage, but sLayoutStorage is null.");
                    return;
                }
                List linkedList;
                switch (iVar.nmq) {
                    case 2:
                    case 3:
                        linkedList = new LinkedList();
                        if (!"batch".equals(str)) {
                            linkedList.addAll(a.dzS.tq(iVar.obj.toString()));
                        } else if (iVar.obj != null && (iVar.obj instanceof List)) {
                            for (String tq : (List) iVar.obj) {
                                linkedList.addAll(a.dzS.tq(tq));
                            }
                        } else {
                            return;
                        }
                        if (!linkedList.isEmpty()) {
                            a.dzS.a("batch", 3, linkedList);
                            return;
                        }
                        return;
                    case 5:
                        linkedList = new LinkedList();
                        if (!"batch".equals(str)) {
                            linkedList.addAll(a.dzS.tq(iVar.obj.toString()));
                        } else if (iVar.obj != null && (iVar.obj instanceof List)) {
                            for (String tq2 : (List) iVar.obj) {
                                linkedList.addAll(a.dzS.tq(tq2));
                            }
                        } else {
                            return;
                        }
                        if (!linkedList.isEmpty()) {
                            a.dzS.a("batch", 5, linkedList);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public static j OO() {
        if (!((dzN != null && dzN.PB()) || dzT == null || dzT.buA())) {
            dzN = new j(dzT);
        }
        return dzN;
    }

    public static com.tencent.mm.plugin.appbrand.jsapi.map.a OP() {
        if (dzU == null) {
            dzU = new com.tencent.mm.plugin.appbrand.jsapi.map.a();
        }
        return dzU;
    }
}
