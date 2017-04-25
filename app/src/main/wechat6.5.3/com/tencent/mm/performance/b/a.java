package com.tencent.mm.performance.b;

import com.tencent.mm.sdk.platformtools.v;
import java.util.HashSet;
import java.util.Iterator;

public final class a extends com.tencent.mm.performance.d.a {
    public static String TYPE = "MemoryAlarmController";
    public long dnA;
    public long dnB;
    public boolean dnC;
    public HashSet<a> dnD;
    public long dny;
    public long dnz;

    public interface a {
        void a(long j, long j2, long j3);

        void b(long j, long j2, long j3);

        void c(long j, long j2, long j3);
    }

    public a() {
        this.dny = -1;
        this.dnz = -1;
        this.dnA = -1;
        this.dnB = -1;
        this.dnC = false;
        this.dny = Runtime.getRuntime().maxMemory();
    }

    private void a(int i, long j, long j2, long j3) {
        synchronized (this.dnD) {
            Iterator it = this.dnD.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                switch (i) {
                    case 0:
                        aVar.a(j, j2, j3);
                        break;
                    case 1:
                        aVar.b(j, j2, j3);
                        break;
                    case 2:
                        aVar.c(j, j2, j3);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public final String MK() {
        return TYPE;
    }

    public final void ML() {
        if (this.dnC) {
            long totalMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            long j = totalMemory / this.dny;
            v.d("MicroMsg.WxPerformace", "memoryalarm memory use %d, total %d", Long.valueOf(totalMemory), Long.valueOf(this.dny));
            if (j >= this.dnB) {
                a(2, j, this.dny, totalMemory);
            } else if (j >= this.dnA) {
                a(1, j, this.dny, totalMemory);
            } else if (j >= this.dnz) {
                a(0, j, this.dny, totalMemory);
            }
        }
    }
}
