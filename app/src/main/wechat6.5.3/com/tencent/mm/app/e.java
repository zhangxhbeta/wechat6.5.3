package com.tencent.mm.app;

import android.content.ComponentName;
import android.os.Process;
import com.tencent.mm.booter.c;
import com.tencent.mm.kernel.a.a;
import com.tencent.mm.kernel.a.b;
import com.tencent.mm.kernel.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.plugin.ProcessProfile;
import com.tencent.mm.plugin.bbom.PluginBigBallOfMud;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class e extends a {
    private static boolean aQB = false;

    public final void oh() {
        super.oh();
        i.bk(g.vt().uZ().getProcessName());
        ProcessProfile uZ = g.vt().uZ();
        b.a("Hello WeChat, DefaultBootStep load debugger...", new Object[0]);
        uZ.setDebugger(c.ao(uZ.application()));
        c debugger = uZ.getDebugger();
        if (d.b(uZ)) {
            debugger.cR("MM");
        } else if (d.a(uZ, ":push")) {
            debugger.cR("PUSH");
        } else if (d.a(uZ, ":tools")) {
            debugger.cR("TOOL");
        } else if (d.a(uZ, ":sandbox")) {
            debugger.cR("SANDBOX");
        } else if (d.a(uZ, ":exdevice")) {
            debugger.cR("EXDEVICE");
        } else if (d.a(uZ, ":patch")) {
            debugger.cR("PATCH");
        } else if (d.a(uZ, ":appbrand")) {
            debugger.cR("APPBRAND");
        }
    }

    public final void oi() {
        g.vx();
        g.vs().d(com.tencent.mm.plugin.zero.b.class);
        g.vx();
        g.vs().d(com.tencent.mm.plugin.f.a.e.class);
        g.vx();
        g.vs().d(com.tencent.mm.plugin.b.a.class);
        g.vx();
        g.vs().d(PluginBigBallOfMud.class);
    }

    public static boolean oj() {
        return aQB;
    }

    public final void a(ProcessProfile processProfile, com.tencent.mm.vending.h.d dVar, com.tencent.mm.vending.g.d.b<Void> bVar) {
        aQB = false;
        if (d.b(processProfile)) {
            ComponentName eb = be.eb(aa.getContext());
            if (eb != null && eb.getPackageName().equals(aa.getPackageName()) && eb.getClassName().equals(aa.btg())) {
                aQB = true;
            }
        }
        if (aQB) {
            if (h.aQU == null) {
                h.aQU = new h("initThread");
            }
            final h hVar = h.aQU;
            if (hVar.aQV == null || !hVar.aQV.isAlive()) {
                v.e("MicroMsg.InitThreadController", "setHighPriority failed thread is dead");
            } else {
                int threadId = hVar.aQV.getThreadId();
                try {
                    if (-8 == Process.getThreadPriority(threadId)) {
                        v.w("MicroMsg.InitThreadController", "setHighPriority No Need.");
                    } else {
                        Process.setThreadPriority(threadId, -8);
                        v.i("MicroMsg.InitThreadController", "InitThreadController:%d setHighPriority to %d", Integer.valueOf(threadId), Integer.valueOf(Process.getThreadPriority(threadId)));
                    }
                } catch (Throwable e) {
                    v.w("MicroMsg.InitThreadController", "thread:%d setHighPriority failed", Integer.valueOf(threadId));
                    v.a("MicroMsg.InitThreadController", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
            }
            g.vx().a(new com.tencent.mm.kernel.api.e(this) {
                final /* synthetic */ e aQD;

                public final void ok() {
                    hVar.aQV.quit();
                    g.vx().b((com.tencent.mm.kernel.api.e) this);
                }

                public final void ah(boolean z) {
                }
            });
            dVar = hVar.aQW;
        }
        super.a(processProfile, dVar, bVar);
    }
}
