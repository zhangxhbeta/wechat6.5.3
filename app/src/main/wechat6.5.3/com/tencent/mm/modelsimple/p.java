package com.tencent.mm.modelsimple;

import com.tencent.mm.e.b.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.network.j;
import com.tencent.mm.protocal.c.ako;
import com.tencent.mm.protocal.c.xj;
import com.tencent.mm.protocal.c.xk;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.Iterator;
import java.util.Map;

public final class p extends k implements j {
    public static String cYA;
    public static String cYB;
    public static String cYC;
    public static String cYD;
    public static String cYE;
    public static String cYF;
    public static String cYG;
    public static String cYH;
    public static String cYI;
    private static int cYJ;
    private static int cYK = 0;
    private static int cYL = 22;
    private static int cYM = 0;
    public static String cYz;
    private e cii;

    public static boolean gf(int i) {
        if (cYJ == i) {
            return false;
        }
        return true;
    }

    public static int Ja() {
        return cYK;
    }

    public static boolean Jb() {
        return (cYM & 2) != 0;
    }

    public static boolean Jc() {
        return (cYL & 4) != 0;
    }

    public static void bf(boolean z) {
        if (z) {
            cYL |= 4;
        } else {
            cYL &= -5;
        }
    }

    public static int Jd() {
        return cYJ;
    }

    public static boolean Je() {
        return (cYM & 512) != 0;
    }

    public static boolean Jf() {
        return (cYM & 1024) != 0;
    }

    public p(int i) {
        cYJ = i;
    }

    public final int getType() {
        return 526;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        a aVar = new a();
        com.tencent.mm.ba.a xjVar = new xj();
        xjVar.fvz = u.bsY();
        v.d("MicroMsg.NetSceneGetOnlineInfo", "language %s", xjVar.fvz);
        aVar.czn = xjVar;
        aVar.czo = new xk();
        aVar.uri = "/cgi-bin/micromsg-bin/getonlineinfo";
        aVar.czm = 526;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cii = eVar2;
        return a(eVar, aVar.Bv(), this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneGetOnlineInfo", "ongynetend %d, %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            xk xkVar = (xk) ((b) pVar).czl.czs;
            cYK = xkVar.mzI;
            v.d("MicroMsg.NetSceneGetOnlineInfo", "iconType:%d onlineInfoFlag:%d", Integer.valueOf(cYK), Integer.valueOf(xkVar.mbK));
            Map q = bf.q(xkVar.mzH, "summary");
            int i4 = cYL;
            if (q != null) {
                int i5;
                cYz = (String) q.get(".summary.banner");
                v.d("MicroMsg.NetSceneGetOnlineInfo", "onlineinfo, count:%d, summary:%s", Integer.valueOf(xkVar.mzF), xkVar.mzH);
                xj xjVar = (xj) ((b) pVar).czk.czs;
                Iterator it = xkVar.mzG.iterator();
                while (it.hasNext()) {
                    ako com_tencent_mm_protocal_c_ako = (ako) it.next();
                    if (com_tencent_mm_protocal_c_ako.mfA.brp().hashCode() != xjVar.mPU.mfA.brp().hashCode()) {
                        Map q2 = bf.q(com_tencent_mm_protocal_c_ako.mLw, "wording");
                        v.d("MicroMsg.NetSceneGetOnlineInfo", com_tencent_mm_protocal_c_ako.mLw);
                        if (q2 != null) {
                            cYA = (String) q2.get(".wording.title");
                            cYB = (String) q2.get(".wording.notify");
                            cYC = (String) q2.get(".wording.mute_title");
                            cYD = (String) q2.get(".wording.mute_tips");
                            cYE = (String) q2.get(".wording.exit");
                            cYF = (String) q2.get(".wording.exit_confirm");
                            cYG = (String) q2.get(".wording.lock_title");
                            cYH = (String) q2.get(".wording.mute_lock_title");
                            cYI = (String) q2.get(".wording.exit");
                        }
                        i5 = com_tencent_mm_protocal_c_ako.mLy;
                        cYM = xkVar.mbK;
                        if (i5 != cYL) {
                            cYL = i5;
                            ak.yW();
                            c.uI();
                        }
                    }
                }
                i5 = i4;
                cYM = xkVar.mbK;
                if (i5 != cYL) {
                    cYL = i5;
                    ak.yW();
                    c.uI();
                }
            }
            if ((xkVar.mbK & 64) != 0) {
                ak.yW();
                ab LX = c.wH().LX("filehelper");
                if (LX == null || be.kS(LX.field_username)) {
                    s.u(LX);
                    ak.yW();
                    LX = c.wH().LX("filehelper");
                }
                if (!(LX == null || com.tencent.mm.i.a.ei(LX.field_type))) {
                    LX.tp();
                    ak.yW();
                    c.wH().a(LX.field_username, LX);
                }
                ak.yW();
                com.tencent.mm.storage.ab Mh = c.wK().Mh("filehelper");
                if (Mh == null) {
                    Mh = new com.tencent.mm.storage.ab("filehelper");
                    Mh.s(be.Ni());
                    ak.yW();
                    c.wK().d(Mh);
                } else {
                    Mh.s(be.Ni());
                    ak.yW();
                    c.wK().a(Mh, "filehelper", true);
                }
            }
        }
        this.cii.a(i2, i3, str, this);
    }
}
