package com.tencent.mm.booter;

import com.tencent.mm.al.k;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.v.e;

public final class o {
    private static long bYq = 86400000;

    public static void run() {
        boolean z;
        ak.yW();
        if (t.ax(Long.valueOf(t.d((Long) c.vf().get(81944, null))).longValue()) * 1000 > bYq) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            e JM = com.tencent.mm.aq.c.JM();
            com.tencent.mm.aq.c.JN();
            if (!JM.cwY) {
                ak.yW();
                if (c.isSDCardAvailable()) {
                    JM.release();
                    JM.cwY = true;
                    ak.vy().a(159, JM);
                    ak.vy().a(new k(9), 0);
                }
            }
        }
    }
}
