package com.tencent.mm.pluginsdk.model.app;

import android.database.Cursor;
import android.graphics.Bitmap;
import com.tencent.mm.a.e;
import com.tencent.mm.bg.g.c;
import com.tencent.mm.e.a.bt;
import com.tencent.mm.e.a.ca;
import com.tencent.mm.e.a.gb;
import com.tencent.mm.e.a.gf;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.k.a.c.q;
import com.tencent.mm.pluginsdk.k.a.c.t;
import com.tencent.mm.pluginsdk.model.app.al.a;
import com.tencent.mm.pluginsdk.model.b;
import com.tencent.mm.pluginsdk.model.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.d;
import com.tencent.mmdb.FileUtils;
import java.util.HashMap;
import java.util.LinkedList;

public class am implements ag {
    private static HashMap<Integer, c> bXq;
    private i ekk;
    private c ekl;
    private e lBm;
    private h lBn;
    private k lBo;
    private o lBp;
    private a lBq = null;
    private j lBr = new j();
    private b lBs = new b();
    private m lBt;
    private d lBu;
    private final t lBv;
    private com.tencent.mm.sdk.c.c lBw = new com.tencent.mm.sdk.c.c<gb>(this) {
        final /* synthetic */ am lBz;

        {
            this.lBz = r2;
            this.nhz = gb.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            am.bnF().Ez(((gb) bVar).bfD.appId);
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c lBx = new com.tencent.mm.sdk.c.c<gf>(this) {
        final /* synthetic */ am lBz;

        {
            this.lBz = r2;
            this.nhz = gf.class.getName().hashCode();
        }

        private static boolean a(gf gfVar) {
            int i;
            try {
                if (j.sU() == null) {
                    i = 0;
                } else {
                    i = be.getInt(j.sU().getValue("AndroidUseUnicodeEmoji"), 0);
                }
            } catch (Exception e) {
                i = 0;
            }
            gfVar.bfJ.aZB = i;
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c lBy = new com.tencent.mm.sdk.c.c<bt>(this) {
        final /* synthetic */ am lBz;

        {
            this.lBz = r2;
            this.nhz = bt.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            int i = be.getInt(j.sU().getValue("AndroidUseUnicodeEmoji"), 0);
            com.tencent.mm.sdk.c.b caVar = new ca();
            caVar.aZA.aZB = i;
            com.tencent.mm.sdk.c.a.nhr.z(caVar);
            return false;
        }
    };

    public am() {
        com.tencent.mm.pluginsdk.j.a.lxJ = new com.tencent.mm.pluginsdk.j.t(this) {
            final /* synthetic */ am lBz;

            {
                this.lBz = r1;
            }

            public final f Gh(String str) {
                return am.bnB().Gz(str);
            }

            public final Cursor tq(int i) {
                Cursor rawQuery = am.bnB().rawQuery("select * from AppInfo where status = 5" + " order by modifyTime asc", new String[0]);
                if (rawQuery != null) {
                    return rawQuery;
                }
                v.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
                return null;
            }

            public final Cursor o(int[] iArr) {
                i bnB = am.bnB();
                String str = "select * from AppInfo where ";
                for (int i = 0; i <= 0; i++) {
                    str = str + " status = " + iArr[0];
                }
                Cursor rawQuery = bnB.rawQuery(str + " order by status desc, modifyTime asc", new String[0]);
                if (rawQuery != null) {
                    return rawQuery;
                }
                v.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
                return null;
            }

            public final Bitmap a(String str, int i, float f) {
                am.bnB();
                if (str == null || str.length() == 0) {
                    v.e("MicroMsg.AppInfoStorage", "getIcon : invalid argument");
                    return null;
                }
                String bB = i.bB(str, i);
                if (e.aR(bB)) {
                    return BackwardSupportUtil.b.c(bB, f);
                }
                v.e("MicroMsg.AppInfoStorage", "icon does not exist, iconPath = " + bB + ", iconType = " + i);
                return null;
            }

            public final void bv(String str, int i) {
                am.bnz().bz(str, i);
            }

            public final void Gi(String str) {
                am.bnA().Gx(str);
            }

            public final void f(f fVar) {
                am.bnB().n(fVar);
            }

            public final void g(f fVar) {
                am.bnB().o(fVar);
            }

            public final void e(f fVar) {
                am.bnB().a(fVar, new String[0]);
            }

            public final i bmv() {
                return am.bnB();
            }

            public final void ae(LinkedList<String> linkedList) {
                am.bnA().af(linkedList);
            }

            public final Cursor cQ(int i, int i2) {
                return am.bnB().cQ(i, i2);
            }

            public final Cursor bmw() {
                i bnB = am.bnB();
                StringBuilder stringBuilder = new StringBuilder(FileUtils.S_IRUSR);
                stringBuilder.append("select * from AppInfo");
                stringBuilder.append(" where ");
                stringBuilder.append("serviceAppType > 0");
                Cursor rawQuery = bnB.rawQuery(stringBuilder.toString(), new String[0]);
                if (rawQuery == null) {
                    v.e("MicroMsg.AppInfoStorage", "getAllServices : cursor is null");
                    return null;
                }
                v.d("MicroMsg.AppInfoStorage", "getAllServices count = %d", Integer.valueOf(rawQuery.getCount()));
                return rawQuery;
            }
        };
        this.lBv = new t();
    }

    private static am bnx() {
        am amVar = (am) ak.yP().fY(am.class.getName());
        if (amVar == null) {
            return new am();
        }
        return amVar;
    }

    public static j bny() {
        return bnx().lBr;
    }

    public static c Wf() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (bnx().ekl == null) {
            am bnx = bnx();
            ak.yW();
            bnx.ekl = new c(com.tencent.mm.model.c.wE());
        }
        return bnx().ekl;
    }

    public static e bnz() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (bnx().lBm == null) {
            bnx().lBm = new e();
        }
        return bnx().lBm;
    }

    public static h bnA() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (bnx().lBn == null) {
            bnx().lBn = new h();
        }
        return bnx().lBn;
    }

    public static i bnB() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (bnx().ekk == null) {
            am bnx = bnx();
            ak.yW();
            bnx.ekk = new i(com.tencent.mm.model.c.wE());
        }
        return bnx().ekk;
    }

    public static k bnC() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (bnx().lBo == null) {
            am bnx = bnx();
            ak.yW();
            bnx.lBo = new k(com.tencent.mm.model.c.wE());
        }
        return bnx().lBo;
    }

    public static o bnD() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (bnx().lBp == null) {
            am bnx = bnx();
            ak.yW();
            bnx.lBp = new o(com.tencent.mm.model.c.wE());
        }
        return bnx().lBp;
    }

    public static a bnE() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (bnx().lBq == null) {
            bnx().lBq = new a();
        }
        return bnx().lBq;
    }

    public static m bnF() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (bnx().lBt == null) {
            bnx().lBt = new m();
        }
        return bnx().lBt;
    }

    public static d ash() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (bnx().lBu == null) {
            bnx().lBu = new d();
        }
        return bnx().lBu;
    }

    public final void th() {
        a aVar = bnx().lBq;
        if (aVar != null) {
            aVar.aVw = 0;
        }
        com.tencent.mm.v.e eVar = bnx().lBn;
        if (eVar != null) {
            ak.vy().b(231, eVar);
            ash().b(7, eVar);
        }
        e eVar2 = bnx().lBm;
        if (eVar2 != null) {
            eVar2.lAi.clear();
            eVar2.iMS.clear();
            eVar2.lAj.clear();
        }
        s sVar = bnx().lBt;
        if (sVar != null) {
            v.d("MicroMsg.AppSettingService", "stop service");
            sVar.lAA.clear();
            ash().b(1, sVar);
        }
        if (this.lBu != null) {
            eVar = this.lBu;
            ak.vy().b(452, eVar);
            eVar.cAd.clear();
        }
        if (bnx().ekk != null) {
            bnx().ekk.lAu.clear();
        }
        d.c.aw(Integer.valueOf(47));
        d.c.aw(Integer.valueOf(49));
        com.tencent.mm.sdk.c.a.nhr.f(this.lBw);
        com.tencent.mm.sdk.c.a.nhr.f(this.lBx);
        com.tencent.mm.sdk.c.a.nhr.f(this.lBy);
        h.bmT();
        t tVar = this.lBv;
        ak.b(tVar.lEJ);
        com.tencent.mm.sdk.c.a.nhr.f(tVar.lDp);
        for (com.tencent.mm.pluginsdk.k.a.c.h th : q.boh()) {
            th.th();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        bXq = hashMap;
        hashMap.put(Integer.valueOf("APPATTACHINFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return c.cic;
            }
        });
        bXq.put(Integer.valueOf("APPINFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return i.cic;
            }
        });
        bXq.put(Integer.valueOf("APPMESSAGE_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return k.cic;
            }
        });
        bXq.put(Integer.valueOf("APPSORT_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return o.cic;
            }
        });
    }

    public final HashMap<Integer, c> ti() {
        return bXq;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        ab.a.csc = bnA();
        d.c.a(Integer.valueOf(47), this.lBs);
        d.c.a(Integer.valueOf(49), this.lBr);
        com.tencent.mm.sdk.c.a.nhr.e(this.lBw);
        com.tencent.mm.sdk.c.a.nhr.e(this.lBx);
        com.tencent.mm.sdk.c.a.nhr.e(this.lBy);
        SightVideoJNI.registerALL();
        t tVar = this.lBv;
        for (com.tencent.mm.pluginsdk.k.a.c.h biS : q.boh()) {
            biS.biS();
        }
        ak.a(tVar.lEJ);
        com.tencent.mm.sdk.c.a.nhr.e(tVar.lDp);
    }

    public final void aH(boolean z) {
    }
}
