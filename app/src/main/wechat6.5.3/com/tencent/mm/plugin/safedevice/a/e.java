package com.tencent.mm.plugin.safedevice.a;

import android.content.Context;
import android.os.Build;
import com.tencent.mm.ak.j.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.protocal.c.arh;
import com.tencent.mm.protocal.c.ari;
import com.tencent.mm.protocal.c.rc;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.f;
import java.util.List;

public final class e {
    public static void o(boolean z, boolean z2) {
        if (ak.uz()) {
            int xL = k.xL();
            if (z) {
                xL |= 16384;
            } else {
                xL &= -16385;
            }
            ak.yW();
            c.vf().set(40, Integer.valueOf(xL));
            if (z2) {
                rc rcVar = new rc();
                rcVar.muR = 28;
                rcVar.muS = z ? 1 : 2;
                ak.yW();
                c.wG().b(new a(23, rcVar));
                com.tencent.mm.plugin.a.a.drq.ow();
            }
        }
    }

    static void a(ari com_tencent_mm_protocal_c_ari) {
        if (com_tencent_mm_protocal_c_ari != null && com_tencent_mm_protocal_c_ari.eeu != null) {
            List<arh> list = com_tencent_mm_protocal_c_ari.eeu;
            if (list != null && list.size() >= 0) {
                f.aKJ().aKG();
                for (arh cVar : list) {
                    f.aKJ().a(new c(cVar));
                }
            }
        }
    }

    public static String cr(Context context) {
        return context == null ? f.nia ? aa.getContext().getString(2131234695) : aa.getContext().getString(2131234694) : f.nia ? context.getString(2131234695) : context.getString(2131234694);
    }

    public static String aKH() {
        return Build.MANUFACTURER + "-" + Build.MODEL;
    }
}
