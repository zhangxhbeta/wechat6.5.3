package com.tencent.mm.pluginsdk.model;

import android.os.Bundle;
import com.tencent.mm.h.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.be;

public final class t {
    private static volatile t lzU = null;

    public static class a {
        public int lzV;
        public int lzW;
        public String lzX;
        public int lzY;
        public String lzZ;
    }

    private t() {
    }

    public static t bmX() {
        if (lzU == null) {
            synchronized (t.class) {
                if (lzU == null) {
                    lzU = new t();
                }
            }
        }
        return lzU;
    }

    public static s o(int i, Bundle bundle) {
        switch (i) {
            case 1:
                return new w();
            case 2:
                return new a(bundle);
            default:
                return new p();
        }
    }

    public static int ty(int i) {
        switch (i) {
            case 0:
                return be.getInt(j.sV().z("QQBroswer", "RecommendCount"), 5);
            case 1:
                return Integer.MAX_VALUE;
            default:
                return 5;
        }
    }

    public static void tz(int i) {
        switch (i) {
            case 0:
                g.iuh.h(10998, Integer.valueOf(0));
                return;
            case 1:
                g.iuh.h(11091, Integer.valueOf(0));
                return;
            default:
                return;
        }
    }

    public static void tA(int i) {
        switch (i) {
            case 0:
                g.iuh.h(10998, Integer.valueOf(1));
                return;
            case 1:
                g.iuh.h(11091, Integer.valueOf(1));
                return;
            default:
                return;
        }
    }

    public static void tB(int i) {
        switch (i) {
            case 0:
                g.iuh.h(10998, Integer.valueOf(3));
                return;
            case 1:
                g.iuh.h(11091, Integer.valueOf(3));
                return;
            default:
                return;
        }
    }

    public static void tC(int i) {
        switch (i) {
            case 0:
                g.iuh.h(10998, Integer.valueOf(2));
                return;
            case 1:
                g.iuh.h(11091, Integer.valueOf(2));
                return;
            default:
                return;
        }
    }
}
