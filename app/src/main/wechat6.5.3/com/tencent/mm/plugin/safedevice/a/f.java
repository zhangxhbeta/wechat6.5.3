package com.tencent.mm.plugin.safedevice.a;

import com.tencent.mm.bg.g.c;
import com.tencent.mm.e.a.gn;
import com.tencent.mm.e.a.go;
import com.tencent.mm.e.a.pt;
import com.tencent.mm.e.a.pu;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.protocal.c.aqx;
import com.tencent.mm.protocal.c.gf;
import com.tencent.mm.protocal.c.gh;
import com.tencent.mm.protocal.c.yg;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;

public class f implements ag {
    private static HashMap<Integer, c> gkf;
    private com.tencent.mm.sdk.c.c iuA = new com.tencent.mm.sdk.c.c<gn>(this) {
        final /* synthetic */ f iuC;

        {
            this.iuC = r2;
            this.nhz = gn.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            gn gnVar = (gn) bVar;
            gnVar.bga.bgb = e.cr(gnVar.bfZ.context);
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c iuB = new com.tencent.mm.sdk.c.c<go>(this) {
        final /* synthetic */ f iuC;

        {
            this.iuC = r2;
            this.nhz = go.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ((go) bVar).bgc.bgd = e.aKH();
            return false;
        }
    };
    private d iux;
    private com.tencent.mm.sdk.c.c iuy = new com.tencent.mm.sdk.c.c<pt>(this) {
        final /* synthetic */ f iuC;

        {
            this.iuC = r2;
            this.nhz = pt.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            aqx com_tencent_mm_protocal_c_aqx = ((pt) bVar).bqZ.bra;
            if (com_tencent_mm_protocal_c_aqx == null) {
                v.e("MicroMsg.SafeDeviceStorageLogic", "null resp");
            } else if (com_tencent_mm_protocal_c_aqx instanceof gf) {
                gf gfVar = (gf) com_tencent_mm_protocal_c_aqx;
                if (gfVar != null) {
                    e.a(gfVar.mgO);
                }
            } else if (com_tencent_mm_protocal_c_aqx instanceof gh) {
                gh ghVar = (gh) com_tencent_mm_protocal_c_aqx;
                if (ghVar != null) {
                    e.a(ghVar.mgO);
                }
            } else if (com_tencent_mm_protocal_c_aqx instanceof yg) {
                yg ygVar = (yg) com_tencent_mm_protocal_c_aqx;
                if (!(ygVar == null || ygVar.mAe == null)) {
                    e.a(ygVar.mAe.mgO);
                }
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c iuz = new com.tencent.mm.sdk.c.c<pu>(this) {
        final /* synthetic */ f iuC;

        {
            this.iuC = r2;
            this.nhz = pu.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            pu puVar = (pu) bVar;
            e.o(puVar.brb.brc, puVar.brb.brd);
            return false;
        }
    };

    private static f aKI() {
        f fVar = (f) ak.yP().fY(f.class.getName());
        if (fVar != null) {
            return fVar;
        }
        fVar = new f();
        ak.yP().a(f.class.getName(), fVar);
        return fVar;
    }

    public static d aKJ() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aKI().iux == null) {
            f aKI = aKI();
            ak.yW();
            aKI.iux = new d(com.tencent.mm.model.c.wE());
        }
        return aKI().iux;
    }

    static {
        HashMap hashMap = new HashMap();
        gkf = hashMap;
        hashMap.put(Integer.valueOf("SAFE_DEVICE_INFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return d.cic;
            }
        });
    }

    public final HashMap<Integer, c> ti() {
        return gkf;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        a.nhr.e(this.iuy);
        a.nhr.e(this.iuz);
        a.nhr.e(this.iuA);
        a.nhr.e(this.iuB);
    }

    public final void aH(boolean z) {
    }

    public final void th() {
        a.nhr.f(this.iuy);
        a.nhr.f(this.iuz);
        a.nhr.f(this.iuA);
        a.nhr.f(this.iuB);
    }
}
