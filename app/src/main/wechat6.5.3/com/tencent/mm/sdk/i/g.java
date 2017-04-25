package com.tencent.mm.sdk.i;

import android.os.Debug;
import com.tencent.mm.sdk.i.e.b;
import junit.framework.Assert;

final class g implements Comparable<g>, Runnable {
    private static final String ddc;
    private static int nmP = 1000;
    long cwH;
    final Runnable nje;
    final String njf;
    long nji;
    long njk;
    final boolean nmQ;
    b nmR;
    final int priority;
    boolean started = false;

    public final /* synthetic */ int compareTo(Object obj) {
        g gVar = (g) obj;
        int abs = (int) (Math.abs(System.currentTimeMillis() - this.nji) / ((long) nmP));
        int i = this.priority;
        if (abs > 0) {
            i += abs;
        }
        return gVar.priority - i;
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("taskName = %s");
        stringBuilder.append("|priority = %d");
        stringBuilder.append("|pooled = %b");
        stringBuilder.append("|addTime = %d");
        stringBuilder.append("|usedTime = %d");
        stringBuilder.append("|cpuTime = %d");
        stringBuilder.append("|started = %b");
        ddc = stringBuilder.toString();
    }

    g(Runnable runnable, String str, int i, boolean z, b bVar) {
        Assert.assertNotNull("ThreadTask arg task is null!", runnable);
        Assert.assertNotNull("ThreadTask arg name is null!", str);
        this.nje = runnable;
        this.njf = str;
        this.priority = i;
        this.nmQ = z;
        this.nji = System.currentTimeMillis();
        this.nmR = bVar;
    }

    public final void run() {
        this.cwH = System.currentTimeMillis();
        this.njk = Debug.threadCpuTimeNanos();
        this.started = true;
        this.nje.run();
        this.cwH = System.currentTimeMillis() - this.cwH;
        this.njk = Debug.threadCpuTimeNanos() - this.njk;
    }

    public final String toString() {
        return String.format(ddc, new Object[]{this.njf, Integer.valueOf(this.priority), Boolean.valueOf(this.nmQ), Long.valueOf(this.nji), Long.valueOf(this.cwH), Long.valueOf(this.njk), Boolean.valueOf(this.started)});
    }
}
