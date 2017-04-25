package com.tencent.mm.plugin.fps_lighter.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.view.Choreographer;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.fps_lighter.a.a;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Random;

@TargetApi(16)
public final class c {
    private static b fUK;
    private static a fVm;
    private static com.tencent.mm.plugin.fps_lighter.a.c.a fVn = new com.tencent.mm.plugin.fps_lighter.a.c.a() {
        public final void r(Activity activity) {
            d dVar;
            v.i("MicroMsg.FPSFinder", "[onBecameForeground]:%s", new Object[]{activity.getClass().getName()});
            c.fVm.di(false);
            b aoc = c.fUK;
            if (aoc.fVl != 0) {
                if (aoc.fVl == 100) {
                    b.fVh = true;
                } else if (1 == new Random().nextInt(100 / aoc.fVl)) {
                    b.fVh = true;
                }
                if (b.fVh) {
                    v.i("MicroMsg.FPSConfig", "you are so lucky! rand:%s", new Object[]{Integer.valueOf(aoc.fVl)});
                }
                if (b.fVh) {
                    c.fVm.setEnabled(false);
                } else {
                    c.fVm.setEnabled(true);
                    Choreographer.getInstance().postFrameCallback(c.fVm);
                }
                c.fUK;
                if (b.fVg) {
                    dVar = e.aof().fVD;
                    if (!dVar.bhY) {
                        if (!GMTrace.isInit()) {
                            GMTrace.init();
                        }
                        GMTrace.startTrace();
                        dVar.fVx = GMTrace.getMainThreadIndex();
                        v.i("MicroMsg.GMTracer", "[startTrace] start:%s", new Object[]{Integer.valueOf(dVar.fVx)});
                        dVar.bhY = true;
                    }
                }
            }
            b.fVh = false;
            if (b.fVh) {
                v.i("MicroMsg.FPSConfig", "you are so lucky! rand:%s", new Object[]{Integer.valueOf(aoc.fVl)});
            }
            if (b.fVh) {
                c.fVm.setEnabled(false);
            } else {
                c.fVm.setEnabled(true);
                Choreographer.getInstance().postFrameCallback(c.fVm);
            }
            c.fUK;
            if (b.fVg) {
                dVar = e.aof().fVD;
                if (!dVar.bhY) {
                    if (GMTrace.isInit()) {
                        GMTrace.init();
                    }
                    GMTrace.startTrace();
                    dVar.fVx = GMTrace.getMainThreadIndex();
                    v.i("MicroMsg.GMTracer", "[startTrace] start:%s", new Object[]{Integer.valueOf(dVar.fVx)});
                    dVar.bhY = true;
                }
            }
        }

        public final void s(Activity activity) {
            v.i("MicroMsg.FPSFinder", "[onBecameBackground]:%s", new Object[]{activity.getClass().getName()});
            c.fVm.di(true);
            Choreographer.getInstance().removeFrameCallback(c.fVm);
            c.fUK;
            if (b.fVg) {
                d dVar = e.aof().fVD;
                if (dVar.bhY) {
                    GMTrace.stopTrace();
                    dVar.fVy = GMTrace.getMainThreadIndex();
                    v.i("MicroMsg.GMTracer", "[stopTrace] start:%s end:%s", new Object[]{Integer.valueOf(dVar.fVx), Integer.valueOf(dVar.fVy)});
                    dVar.bhY = false;
                }
            }
        }

        public final void t(Activity activity) {
            v.i("MicroMsg.FPSFinder", "[onBegin]:%s", new Object[]{activity.getClass().getName()});
            c.fVm.setActivity(activity);
            c.fVm.anX();
        }

        public final void u(Activity activity) {
            v.i("MicroMsg.FPSFinder", "[onChangeActivity] now Activity:%s", new Object[]{activity.getClass().getName()});
            c.fVm.setActivity(activity);
        }
    };
    private static long fVo = System.currentTimeMillis();

    public static void kP(int i) {
        if (fUK != null) {
            fUK.bdy = i;
            fVm.anX();
        }
    }
}
