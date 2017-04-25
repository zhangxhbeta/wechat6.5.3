package com.tencent.mm.plugin.nearby.a;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.aw.a;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.u;

public final class b {
    public static final int hEE = 1;
    private static final /* synthetic */ int[] hEF = new int[]{hEE};

    public static boolean ck(String str, String str2) {
        u uVar = new u();
        uVar.bS(str2);
        uVar.setUsername(str);
        ak.yW();
        aa wH = c.wH();
        v.d("MicroMsg.LbsroomLogic", "Save lbsroom contact name:" + uVar.field_username);
        if (!wH.LZ(uVar.field_username)) {
            wH.N(uVar);
        }
        ak.yW();
        c.vf().set(143873, str);
        ak.yW();
        c.vf().set(143874, Long.valueOf(be.Nh()));
        return true;
    }

    public static void aI(String str, int i) {
        ak.yW();
        ak.vy().a(new e(str, (int) be.ax(be.d((Long) c.vf().get(143874, Long.valueOf(0)))), i), 0);
    }

    public static void cJ(int i) {
        ak.yW();
        String ma = be.ma((String) c.vf().get(143873, ""));
        if (!ma.equals("")) {
            ak.yW();
            if (be.ax(be.d((Long) c.vf().get(143874, Long.valueOf(0)))) < 7200) {
                aI(ma, i);
            } else {
                xf(ma);
            }
        }
    }

    public static boolean aDv() {
        ak.yW();
        return be.f((Integer) c.vf().get(143875, Integer.valueOf(0))) == 1;
    }

    public static void aDw() {
        ak.yW();
        c.vf().set(143875, Integer.valueOf(1));
    }

    public static void aDx() {
        ak.yW();
        c.vf().set(143875, Integer.valueOf(0));
    }

    public static void xf(String str) {
        ak.yW();
        aa wH = c.wH();
        if (wH.LZ(str)) {
            wH.Mc(str);
        }
        aw.a(str, new a() {
            public final boolean zp() {
                return false;
            }

            public final void zo() {
            }
        });
        ak.yW();
        c.vf().set(143873, "");
        ak.yW();
        c.vf().set(143874, Long.valueOf(0));
        aDx();
    }
}
