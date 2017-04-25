package com.tencent.mm.modelbiz;

import android.os.Looper;
import com.tencent.mm.model.ak;
import com.tencent.mm.protocal.c.atq;
import com.tencent.mm.protocal.c.hc;
import com.tencent.mm.protocal.c.tm;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.h.h;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class c extends f<b> implements e {
    public static final String[] cic = new String[]{f.a(b.chq, "BizEnterprise")};
    private final h<a, a> cBg = new h<a, a>(this) {
        final /* synthetic */ c cBh;

        {
            this.cBh = r1;
        }

        protected final /* synthetic */ void o(Object obj, Object obj2) {
            ((a) obj).a((a) obj2);
        }
    };
    private d cie;

    public interface a {

        public static class a {
            public int cBi;
            public String cBj;
            public b cBk;
        }

        public enum b {
            ;

            static {
                cBl = 1;
                cBm = 2;
                cBn = 3;
                cBo = new int[]{cBl, cBm, cBn};
            }
        }

        void a(a aVar);
    }

    public c(d dVar) {
        super(dVar, b.chq, "BizEnterprise", null);
        this.cie = dVar;
        dVar.dF("BizEnterprise", "CREATE INDEX IF NOT EXISTS BizEnterpriseUserNameIndex ON BizEnterprise ( userName )");
        ak.vy().a(1343, (e) this);
        ak.vy().a(1228, (e) this);
    }

    public final void a(a aVar, Looper looper) {
        this.cBg.a(aVar, looper);
    }

    public final void a(a aVar) {
        if (this.cBg != null) {
            this.cBg.remove(aVar);
        }
    }

    public final b gZ(String str) {
        if (be.kS(str)) {
            return null;
        }
        com.tencent.mm.sdk.h.c bVar = new b();
        bVar.field_userName = str;
        if (super.b(bVar, new String[0])) {
            return bVar;
        }
        a(str, null);
        return null;
    }

    private b ha(String str) {
        b gZ = gZ(str);
        if (gZ != null) {
            return gZ;
        }
        gZ = new b();
        gZ.field_userName = str;
        gZ.field_qyUin = 0;
        gZ.field_userUin = 0;
        gZ.field_userFlag = 0;
        return gZ;
    }

    public final int hb(String str) {
        b gZ = gZ(str);
        if (gZ == null) {
            return 0;
        }
        return gZ.field_qyUin;
    }

    public final boolean hc(String str) {
        boolean z = false;
        if (!be.kS(str)) {
            com.tencent.mm.sdk.h.c bVar = new b();
            bVar.field_userName = str;
            z = super.c(bVar, "userName");
            if (z) {
                a aVar = new a();
                aVar.cBj = str;
                aVar.cBi = b.cBm;
                aVar.cBk = bVar;
                this.cBg.bg(aVar);
                this.cBg.Ls();
            }
        }
        return z;
    }

    private boolean a(b bVar) {
        if (bVar == null) {
            return false;
        }
        boolean z;
        int i;
        boolean b = super.b(bVar);
        int i2 = b.cBl;
        if (b) {
            int i3 = i2;
            z = b;
            i = i3;
        } else {
            b = super.a((com.tencent.mm.sdk.h.c) bVar);
            z = b;
            i = b.cBn;
        }
        if (!z) {
            return z;
        }
        a aVar = new a();
        aVar.cBj = bVar.field_userName;
        aVar.cBi = i;
        aVar.cBk = bVar;
        this.cBg.bg(aVar);
        this.cBg.Ls();
        return z;
    }

    private boolean a(hc hcVar) {
        b ha = ha(hcVar.mhJ);
        ha.field_userName = hcVar.mhJ;
        ha.field_qyUin = hcVar.mhT;
        ha.field_userUin = hcVar.mhU;
        hcVar.mhV &= -9;
        ha.field_userFlag = hcVar.mhV | (ha.field_userFlag & 8);
        return a(ha);
    }

    public static boolean a(String str, e eVar) {
        if (be.kS(str)) {
            return false;
        }
        int i;
        if (e.hB(str)) {
            i = 1;
        } else if (!e.hA(str)) {
            return false;
        } else {
            i = 2;
        }
        return ak.vy().a(new o(str, i, eVar), 0);
    }

    public static t a(String str, boolean z, e eVar) {
        hc hcVar = new hc();
        hcVar.mhJ = str;
        hcVar.mhV = z ? 1 : 0;
        hcVar.mhT = 0;
        k tVar = new t(hcVar, eVar);
        return ak.vy().a(tVar, 0) ? tVar : null;
    }

    public final void hd(String str) {
        b ha = ha(str);
        if ((ha.field_userFlag & 8) == 0) {
            ha.field_userFlag |= 8;
            a(ha);
        }
    }

    public static void a(t tVar) {
        ak.vy().c((k) tVar);
        tVar.data = null;
    }

    public final boolean he(String str) {
        b gZ = gZ(str);
        return (gZ == null || (gZ.field_userFlag & 1) == 0) ? false : true;
    }

    public final boolean hf(String str) {
        if (be.kS(str)) {
            return false;
        }
        b gZ = gZ(str);
        if (gZ == null || (gZ.field_userFlag & 2) == 0) {
            return false;
        }
        return true;
    }

    public final boolean hg(String str) {
        if (be.kS(str)) {
            return false;
        }
        b gZ = gZ(str);
        if (gZ == null || (gZ.field_userFlag & 4) == 0 || (gZ.field_userFlag & 8) != 0) {
            return false;
        }
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        int i3 = -1;
        if (i == 0 && i2 == 0) {
            e eVar;
            if (kVar instanceof o) {
                o oVar = (o) kVar;
                tm tmVar = (oVar.cif == null || oVar.cif.czl.czs == null) ? null : (tm) oVar.cif.czl.czs;
                if (tmVar != null && tmVar.mhP != null && tmVar.mhP.ret == 0 && tmVar.mwH != null) {
                    if (!a(tmVar.mwH)) {
                        i2 = -1;
                    }
                    eVar = (e) oVar.data;
                    if (eVar != null) {
                        eVar.a(i, i2, str, kVar);
                    }
                } else {
                    return;
                }
            }
            if (kVar instanceof t) {
                t tVar = (t) kVar;
                atq com_tencent_mm_protocal_c_atq = (tVar.cif == null || tVar.cif.czl.czs == null) ? null : (atq) tVar.cif.czl.czs;
                if (com_tencent_mm_protocal_c_atq != null && com_tencent_mm_protocal_c_atq.mhP != null && com_tencent_mm_protocal_c_atq.mhP.ret == 0 && com_tencent_mm_protocal_c_atq.mwH != null) {
                    if (a(com_tencent_mm_protocal_c_atq.mwH)) {
                        i3 = i2;
                    }
                    eVar = (e) tVar.data;
                    if (eVar != null) {
                        eVar.a(i, i3, str, kVar);
                    }
                }
            }
        }
    }
}
