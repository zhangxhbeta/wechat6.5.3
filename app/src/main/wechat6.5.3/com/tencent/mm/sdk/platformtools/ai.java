package com.tencent.mm.sdk.platformtools;

import android.os.Debug;
import android.os.Handler;
import android.os.Process;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class ai implements Runnable {
    private static final String njo;
    private static final String njp;
    long cwH;
    long endTime;
    long fVR;
    final Handler handler;
    String niH;
    final Runnable nje;
    final String njf;
    final Object njg;
    final a njh;
    long nji;
    long njj;
    long njk;
    long njl;
    long njm;
    float njn = -1.0f;
    int priority;
    boolean started = false;
    final Thread thread;

    public interface a {
        void a(Runnable runnable, ai aiVar);

        void a(Runnable runnable, Thread thread, long j, long j2, float f);
    }

    ai(Thread thread, Handler handler, Runnable runnable, Object obj, a aVar) {
        this.thread = thread;
        if (thread != null) {
            this.niH = thread.getName();
            this.fVR = thread.getId();
            this.priority = thread.getPriority();
        }
        this.handler = handler;
        this.nje = runnable;
        String name = runnable.getClass().getName();
        String obj2 = runnable.toString();
        if (!be.kS(obj2)) {
            int indexOf = obj2.indexOf(124);
            if (indexOf > 0) {
                name = name + "_" + obj2.substring(indexOf + 1);
            }
        }
        this.njf = name;
        this.njg = obj;
        this.njh = aVar;
        this.nji = System.currentTimeMillis();
    }

    public final void run() {
        new StringBuilder("/proc/self/task/").append(Process.myTid()).append("/stat");
        this.cwH = System.currentTimeMillis();
        this.njk = Debug.threadCpuTimeNanos();
        this.njl = -1;
        this.njm = -1;
        this.started = true;
        this.nje.run();
        this.njl = -1 - this.njl;
        this.njm = -1 - this.njm;
        this.endTime = System.currentTimeMillis();
        this.cwH = this.endTime - this.cwH;
        this.njk = (Debug.threadCpuTimeNanos() - this.njk) / 1000000;
        if (this.njm != 0) {
            this.njn = ((float) (100 * this.njl)) / ((float) this.njm);
        }
        if (this.njh != null) {
            this.njh.a(this.nje, this);
            this.njh.a(this, this.thread, this.cwH, this.njk, this.njn);
        }
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("taskName = %s");
        stringBuilder.append("|token = %s");
        stringBuilder.append("|handler = %s");
        stringBuilder.append("|threadName = %s");
        stringBuilder.append("|threadId = %d");
        stringBuilder.append("|priority = %d");
        stringBuilder.append("|addTime = %d");
        stringBuilder.append("|delayTime = %d");
        stringBuilder.append("|usedTime = %d");
        stringBuilder.append("|cpuTime = %d");
        stringBuilder.append("|started = %b");
        njo = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append("taskName = %s");
        stringBuilder.append(" | addTime = %s");
        stringBuilder.append(" | endTime = %s");
        stringBuilder.append(" | usedTime = %d");
        stringBuilder.append(" | cpuTime = %d");
        stringBuilder.append(" | threadCpuTime = %d");
        stringBuilder.append(" | totalCpuTime = %d");
        stringBuilder.append(" | threadCpuRate = %.1f");
        njp = stringBuilder.toString();
    }

    public final String dump(boolean z) {
        if (z) {
            return String.format(njo, new Object[]{this.njf, this.njg, this.handler, this.niH, Long.valueOf(this.fVR), Integer.valueOf(this.priority), Long.valueOf(this.nji), Long.valueOf(this.njj), Long.valueOf(this.cwH), Long.valueOf(this.njk), Boolean.valueOf(this.started)});
        }
        return String.format(njp, new Object[]{this.njf, new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.nji)), new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.endTime)), Long.valueOf(this.cwH), Long.valueOf(this.njk), Long.valueOf(this.njl), Long.valueOf(this.njm), Float.valueOf(this.njn)});
    }
}
