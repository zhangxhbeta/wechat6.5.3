package com.tencent.mm.plugin.soter.a;

import android.os.Build.VERSION;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t.a;

public final class c {
    public static boolean aYB() {
        return VERSION.SDK_INT >= 23;
    }

    static int aYC() {
        ak.yW();
        Integer num = (Integer) com.tencent.mm.model.c.vf().get(a.nst, null);
        if (num == null) {
            num = Integer.valueOf(0);
        }
        v.i("MicroMsg.SoterAntiBruteForceStrategy", "hy: current retry time: %d", new Object[]{num});
        return num.intValue();
    }

    static void rk(int i) {
        v.i("MicroMsg.SoterAntiBruteForceStrategy", "hy: setting to time: %d", new Object[]{Integer.valueOf(i)});
        if (i < 0) {
            v.w("MicroMsg.SoterAntiBruteForceStrategy", "hy: illegal fail time");
            return;
        }
        ak.yW();
        com.tencent.mm.model.c.vf().a(a.nst, Integer.valueOf(i));
    }

    private static void dl(long j) {
        v.i("MicroMsg.SoterAntiBruteForceStrategy", "hy: setting last freeze time: %d", new Object[]{Long.valueOf(j)});
        if (j < -1) {
            v.w("MicroMsg.SoterAntiBruteForceStrategy", "hy: illegal setLastFreezeTime");
            return;
        }
        ak.yW();
        com.tencent.mm.model.c.vf().a(a.nsu, Long.valueOf(j));
    }

    static void aYD() {
        rk(6);
        dl(System.currentTimeMillis());
    }

    static void aYE() {
        dl(-1);
        rk(0);
    }

    public static boolean aYF() {
        long currentTimeMillis = System.currentTimeMillis();
        ak.yW();
        Long l = (Long) com.tencent.mm.model.c.vf().get(a.nsu, null);
        if (l == null) {
            l = Long.valueOf(-1);
        }
        v.i("MicroMsg.SoterAntiBruteForceStrategy", "hy: current last freeze time: %d", new Object[]{l});
        v.i("MicroMsg.SoterAntiBruteForceStrategy", "hy: tween sec after last freeze: %d", new Object[]{Integer.valueOf((int) ((currentTimeMillis - l.longValue()) / 1000))});
        if (((int) ((currentTimeMillis - l.longValue()) / 1000)) <= 30) {
            return false;
        }
        v.d("MicroMsg.SoterAntiBruteForceStrategy", "hy: after last freeze");
        return true;
    }

    public static boolean aYG() {
        if (aYC() > 5) {
            return false;
        }
        v.i("MicroMsg.SoterAntiBruteForceStrategy", "hy: fail time available");
        return true;
    }
}
