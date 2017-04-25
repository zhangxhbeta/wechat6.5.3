package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.k.b;
import com.tencent.mm.plugin.appbrand.k.b.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.LinkedList;
import java.util.List;

public class bx {
    private static long dJn = 200;
    private static long dJo = 20;
    private static bx dJp;
    private b dGg;
    private List<e> dJq = new LinkedList();
    private Runnable dJr;

    public static bx Qn() {
        if (dJp == null) {
            synchronized (bx.class) {
                if (dJp == null) {
                    dJp = new bx();
                }
            }
        }
        return dJp;
    }

    public static int Qo() {
        return MMWebView.getTbsCoreVersion(aa.getContext()) >= 36867 ? 5 : 20;
    }

    private bx() {
        dJn = (long) (MMWebView.getTbsCoreVersion(aa.getContext()) >= 36867 ? 20 : 200);
        this.dJr = new Runnable(this) {
            final /* synthetic */ bx dJs;

            {
                this.dJs = r1;
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                r5 = this;
                r4 = 0;
                r0 = r5.dJs;
                r0 = r0.dJq;
                r0 = r0.isEmpty();
                if (r0 == 0) goto L_0x000e;
            L_0x000d:
                return;
            L_0x000e:
                r0 = r5.dJs;
                r1 = r0.dJq;
                monitor-enter(r1);
                r0 = r5.dJs;	 Catch:{ all -> 0x0023 }
                r0 = r0.dJq;	 Catch:{ all -> 0x0023 }
                r0 = r0.isEmpty();	 Catch:{ all -> 0x0023 }
                if (r0 == 0) goto L_0x0026;
            L_0x0021:
                monitor-exit(r1);	 Catch:{ all -> 0x0023 }
                goto L_0x000d;
            L_0x0023:
                r0 = move-exception;
                monitor-exit(r1);	 Catch:{ all -> 0x0023 }
                throw r0;
            L_0x0026:
                r0 = r5.dJs;	 Catch:{ all -> 0x0023 }
                r0 = r0.dJq;	 Catch:{ all -> 0x0023 }
                r2 = 0;
                r0 = r0.remove(r2);	 Catch:{ all -> 0x0023 }
                r0 = (com.tencent.mm.plugin.appbrand.jsapi.e) r0;	 Catch:{ all -> 0x0023 }
                monitor-exit(r1);	 Catch:{ all -> 0x0023 }
                r0.PX();
                r1 = "MicroMsg.SensorJsEventPublisher";
                r2 = "publish next event(event : %s), list size is : %d.";
                r3 = 2;
                r3 = new java.lang.Object[r3];
                r0 = r0.getName();
                r3[r4] = r0;
                r0 = 1;
                r4 = r5.dJs;
                r4 = r4.dJq;
                r4 = r4.size();
                r4 = java.lang.Integer.valueOf(r4);
                r3[r0] = r4;
                com.tencent.mm.sdk.platformtools.v.v(r1, r2, r3);
                r0 = r5.dJs;
                r0 = r0.dJq;
                r0 = r0.isEmpty();
                if (r0 != 0) goto L_0x000d;
            L_0x0066:
                r0 = com.tencent.mm.plugin.appbrand.k.a.vA();
                r2 = com.tencent.mm.plugin.appbrand.jsapi.bx.dJn;
                r0.f(r5, r2);
                goto L_0x000d;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.bx.1.run():void");
            }
        };
        this.dGg = new b(dJn, new a(this) {
            final /* synthetic */ bx dJs;

            {
                this.dJs = r1;
            }

            public final boolean h(Object... objArr) {
                if (this.dJs.dJq.isEmpty()) {
                    return false;
                }
                this.dJs.dJr.run();
                return true;
            }
        });
    }

    public final boolean a(e eVar) {
        if (eVar == null) {
            return false;
        }
        if (!com.tencent.mm.plugin.appbrand.h.b.b(eVar.dzg, eVar)) {
            return false;
        }
        synchronized (this.dJq) {
            boolean isEmpty = this.dJq.isEmpty();
            if (this.dJq.isEmpty()) {
                this.dJq.add(eVar);
            } else if (((e) this.dJq.get(0)).equals(eVar)) {
                this.dJq.add(0, eVar);
                this.dJq.remove(1);
            } else {
                this.dJq.remove(eVar);
                this.dJq.add(eVar);
            }
        }
        if (isEmpty && !this.dGg.i(new Object[0])) {
            v.v("MicroMsg.SensorJsEventPublisher", "post delay publish event(event : %s).", new Object[]{eVar.getName()});
            com.tencent.mm.plugin.appbrand.k.a.vA().f(this.dJr, dJn);
        }
        return true;
    }
}
