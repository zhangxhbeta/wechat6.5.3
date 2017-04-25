package com.tencent.mm.plugin.shake.b;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.ar.l;
import com.tencent.mm.bg.g.c;
import com.tencent.mm.e.a.ic;
import com.tencent.mm.e.a.lg;
import com.tencent.mm.e.a.na;
import com.tencent.mm.e.a.ow;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bo;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.c.a.f;
import com.tencent.mm.plugin.shake.d.a.i;
import com.tencent.mm.plugin.shake.d.a.o;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ac.b;
import com.tencent.mm.storage.u;
import com.tencent.mm.v.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class k implements ag {
    private static HashMap<Integer, c> bXq;
    private b csL = new b(this) {
        final /* synthetic */ k iOD;

        {
            this.iOD = r1;
        }

        public final void a(ab abVar, ac acVar) {
            if (abVar != null && m.fh(abVar.field_username)) {
                abVar.setUsername("");
            }
        }
    };
    private com.tencent.mm.sdk.c.c eOy = new com.tencent.mm.sdk.c.c<ow>(this) {
        final /* synthetic */ k iOD;

        {
            this.iOD = r2;
            this.nhz = ow.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            ow owVar = (ow) bVar;
            if (owVar.bqh.bqi.equals(na.class.getName())) {
                if (owVar.bqh.bdf == 1) {
                    this.iOD.iOy.bmH();
                } else {
                    this.iOD.iOy.unregister();
                }
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c hDj = new com.tencent.mm.sdk.c.c<ic>(this) {
        final /* synthetic */ k iOD;

        {
            this.iOD = r2;
            this.nhz = ic.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            ic icVar = (ic) bVar;
            if (icVar instanceof ic) {
                switch (icVar.bhZ.action) {
                    case -4:
                        Cursor aND = k.aNO().aND();
                        icVar.bia.bed = new ArrayList();
                        while (aND != null && aND.moveToNext()) {
                            d dVar = new d();
                            dVar.b(aND);
                            icVar.bia.bed.add(i.a(dVar.field_lvbuffer, 0));
                        }
                        if (aND != null) {
                            aND.close();
                            break;
                        }
                        break;
                }
            }
            return false;
        }
    };
    private a hEM = new a(this) {
        final /* synthetic */ k iOD;

        {
            this.iOD = r1;
        }

        public final void a(aa aaVar, u uVar) {
            if (aaVar != null && uVar != null && uVar.tK()) {
                k.aNO().zp(uVar.field_username);
            }
        }
    };
    private com.tencent.mm.sdk.c.c iOA = new com.tencent.mm.sdk.c.c<lg>(this) {
        final /* synthetic */ k iOD;

        {
            this.iOD = r2;
            this.nhz = lg.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            if (((lg) bVar) instanceof lg) {
                g.iuh.h(10221, new Object[]{Integer.valueOf(r6.bmC.scene)});
            } else {
                v.e("MicroMsg.SubCoreShake", "mismatch event listener for ReportClickFindFriendShakeEvent");
            }
            return false;
        }
    };
    private bo.b iOB = new bo.b(this) {
        final /* synthetic */ k iOD;

        {
            this.iOD = r1;
        }

        public final void a(final d.a aVar) {
            final String a = com.tencent.mm.platformtools.m.a(aVar.czu.mbW);
            if (a == null || a.length() == 0) {
                v.e("MicroMsg.SubCoreShake", "onReceiveMsg, ShakeCardEntranceMsg msgContent is null");
            } else {
                this.iOD.mHandler.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass3 iOE;

                    public final void run() {
                        k.aNT().e(a, aVar.czu.mcb, 0);
                    }
                });
            }
        }
    };
    private bo.b iOC = new bo.b(this) {
        final /* synthetic */ k iOD;

        {
            this.iOD = r1;
        }

        public final void a(final d.a aVar) {
            final String a = com.tencent.mm.platformtools.m.a(aVar.czu.mbW);
            if (a == null || a.length() == 0) {
                v.e("MicroMsg.SubCoreShake", "onReceiveMsg, ShakeCardRedDotMsg msgContent is null");
            } else {
                this.iOD.mHandler.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass4 iOF;

                    public final void run() {
                        k.aNT().e(a, aVar.czu.mcb, 1);
                    }
                });
            }
        }
    };
    private e iOs;
    private g iOt;
    private f iOu;
    private com.tencent.mm.plugin.shake.c.a.d iOv;
    private o iOw;
    private l iOx = new l();
    com.tencent.mm.pluginsdk.d.d iOy = new com.tencent.mm.pluginsdk.d.d(this) {
        final /* synthetic */ k iOD;

        {
            this.iOD = r1;
        }

        public final com.tencent.mm.sdk.c.b um(String str) {
            na naVar = new na();
            naVar.boo.aXv = str;
            return naVar;
        }

        public final com.tencent.mm.sdk.h.g asj() {
            return k.aNP();
        }
    };
    private bo.b iOz = new bo.b(this) {
        final /* synthetic */ k iOD;

        {
            this.iOD = r1;
        }

        public final void a(d.a aVar) {
            k.aNN();
            if (k.aNS() != 0) {
                k.aNN();
                k.aNS();
                String a = com.tencent.mm.platformtools.m.a(aVar.czu.mbW);
                v.v("MicroMsg.ShakeMsgMgr", "func[onResvMsg] content:" + a);
                if (be.kS(a)) {
                    v.d("MicroMsg.ShakeMsgMgr", "func[onResvMsg] Msg content empty");
                    return;
                }
                Map q = bf.q(a, "sysmsg");
                int i = be.getInt((String) q.get(".sysmsg.shake.$type"), 0);
                switch (i) {
                    case 1:
                        f fVar = new f();
                        i = be.getInt((String) q.get(".sysmsg.shake.shaketv.msgtype"), 0);
                        if (i == 0) {
                            fVar.field_type = 1;
                            fVar.field_subtype = i;
                            fVar.field_svrid = aVar.czu.mcb;
                            fVar.field_createtime = be.Nh();
                            fVar.field_tag = (String) q.get(".sysmsg.shake.shaketv.jumpurl");
                            fVar.field_status = 0;
                            fVar.field_title = (String) q.get(".sysmsg.shake.shaketv.title");
                            fVar.field_thumburl = (String) q.get(".sysmsg.shake.shaketv.iconurl");
                            fVar.field_desc = (String) q.get(".sysmsg.shake.shaketv.desc");
                            fVar.field_reserved1 = be.ma((String) q.get(".sysmsg.shake.shaketv.pid"));
                            k.aNP().a(fVar);
                            return;
                        }
                        v.w("MicroMsg.ShakeMsgMgr", "Unknown subType:" + i);
                        return;
                    default:
                        v.d("MicroMsg.ShakeMsgMgr", "Unrecognized type :" + i);
                        return;
                }
            }
            v.w("MicroMsg.SubCoreShake", "func[onRecieveMsg] getShakeMsgMgr null");
        }
    };
    private com.tencent.mm.sdk.platformtools.ac mHandler = new com.tencent.mm.sdk.platformtools.ac(Looper.getMainLooper());

    private static k aNN() {
        k kVar = (k) ak.yP().fY("plugin.shake");
        if (kVar != null) {
            return kVar;
        }
        kVar = new k();
        ak.yP().a("plugin.shake", kVar);
        return kVar;
    }

    public static e aNO() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aNN().iOs == null) {
            k aNN = aNN();
            ak.yW();
            aNN.iOs = new e(com.tencent.mm.model.c.wE());
        }
        return aNN().iOs;
    }

    public static g aNP() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aNN().iOt == null) {
            k aNN = aNN();
            ak.yW();
            aNN.iOt = new g(com.tencent.mm.model.c.wE());
        }
        return aNN().iOt;
    }

    public static o aNQ() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aNN().iOw == null) {
            k aNN = aNN();
            ak.yW();
            aNN.iOw = new o(com.tencent.mm.model.c.wE());
        }
        return aNN().iOw;
    }

    public final void th() {
        ak.yW();
        com.tencent.mm.model.c.wK().b(this.csL);
        com.tencent.mm.sdk.c.a.nhr.f(this.eOy);
        com.tencent.mm.sdk.c.a.nhr.f(this.iOA);
        com.tencent.mm.sdk.c.a.nhr.f(this.iOx);
        com.tencent.mm.sdk.c.a.nhr.f(this.hDj);
        ak.yW();
        com.tencent.mm.model.c.wH().b(this.hEM);
        ak.yU().b("shake", this.iOz, true);
        ak.yU().b("ShakeCardEntrance", this.iOB, true);
        ak.yU().b("ShakeCardRedDot", this.iOC, true);
        j.a.lxL = null;
    }

    static {
        HashMap hashMap = new HashMap();
        bXq = hashMap;
        hashMap.put(Integer.valueOf("SHAKEITEM_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return e.cic;
            }
        });
        bXq.put(Integer.valueOf("SHAKEMSG_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return g.cic;
            }
        });
        bXq.put(Integer.valueOf("SHAKETVHISTORY_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return o.cic;
            }
        });
    }

    public final HashMap<Integer, c> ti() {
        return bXq;
    }

    public final void ed(int i) {
        if ((i & 256) != 0) {
            aNR();
        }
    }

    public static void aNR() {
        aNO().aNF();
        l.KF().Kz();
    }

    public final void aG(boolean z) {
        j.a.lxL = new h();
        ak.yW();
        com.tencent.mm.model.c.wK().a(this.csL);
        com.tencent.mm.sdk.c.a.nhr.e(this.eOy);
        com.tencent.mm.sdk.c.a.nhr.e(this.iOA);
        com.tencent.mm.sdk.c.a.nhr.e(this.iOx);
        com.tencent.mm.sdk.c.a.nhr.e(this.hDj);
        ak.yW();
        com.tencent.mm.model.c.wH().a(this.hEM);
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ k iOD;

            {
                this.iOD = r1;
            }

            public final void run() {
                if (ak.uz()) {
                    ak.yW();
                    be.f(com.tencent.mm.model.c.xa(), "Sk", 604800000);
                }
            }

            public final String toString() {
                return super.toString() + "|onAccountPostReset";
            }
        });
        ak.yU().a("shake", this.iOz, true);
        ak.yU().a("ShakeCardEntrance", this.iOB, true);
        ak.yU().a("ShakeCardRedDot", this.iOC, true);
        this.iOu = null;
        this.iOv = null;
    }

    public final void aH(boolean z) {
    }

    public static int aNS() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() != 0) {
            return i.iOh;
        }
        throw new com.tencent.mm.model.b();
    }

    public static String jc(String str) {
        if (!ak.uz()) {
            return "";
        }
        r1 = new Object[2];
        ak.yW();
        r1[0] = com.tencent.mm.model.c.xa();
        r1[1] = com.tencent.mm.a.g.m(str.getBytes());
        return String.format("%s/Sk_%s", r1);
    }

    public static String cr(String str, String str2) {
        if (!ak.uz() || be.kS(str)) {
            return "";
        }
        r1 = new Object[3];
        ak.yW();
        r1[0] = com.tencent.mm.model.c.xa();
        r1[1] = str2;
        r1[2] = com.tencent.mm.a.g.m(str.getBytes());
        return String.format("%s/Sk%s_%s", r1);
    }

    public static f aNT() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aNN().iOu == null) {
            aNN().iOu = new f();
        }
        return aNN().iOu;
    }

    public static com.tencent.mm.plugin.shake.c.a.d aNU() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aNN().iOv == null) {
            aNN().iOv = new com.tencent.mm.plugin.shake.c.a.d();
        }
        return aNN().iOv;
    }
}
