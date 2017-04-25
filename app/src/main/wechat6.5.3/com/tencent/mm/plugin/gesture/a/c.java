package com.tencent.mm.plugin.gesture.a;

import java.lang.reflect.Array;

public final class c {
    private static c[][] gAR = ((c[][]) Array.newInstance(c.class, new int[]{3, 3}));
    public int fkQ = 0;
    public int fkR = 0;

    static {
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                gAR[i][i2] = new c(i, i2);
            }
        }
    }

    private c(int i, int i2) {
        this.fkQ = i;
        this.fkR = i2;
    }

    public static synchronized c bJ(int i, int i2) {
        c cVar;
        synchronized (c.class) {
            if (i < 0 || i > 2) {
                throw new IllegalArgumentException("row id should be in range [0..2]");
            } else if (i2 < 0 || i2 > 2) {
                throw new IllegalArgumentException("col id should be in range [0..2]");
            } else {
                cVar = gAR[i][i2];
            }
        }
        return cVar;
    }

    public final String toString() {
        return String.format("{row: %d, col: %d}", new Object[]{Integer.valueOf(this.fkQ), Integer.valueOf(this.fkR)});
    }
}
