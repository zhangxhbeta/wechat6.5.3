package com.tencent.mm.plugin.appbrand.task;

import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.smtt.sdk.QbSdk;
import java.util.HashSet;
import java.util.Iterator;

public final class a {
    private static boolean dQg = false;
    private static boolean dQh = false;
    private static HashSet<a> dQi = new HashSet();

    public interface a {
        void onReady();
    }

    public static synchronized void a(a aVar) {
        synchronized (a.class) {
            if (dQg) {
                if (aVar != null) {
                    dQi.add(aVar);
                }
            } else if (!dQh) {
                dQg = true;
                if (aVar != null) {
                    dQi.add(aVar);
                }
                com.tencent.mm.plugin.appbrand.k.a.vA().x(new Runnable() {
                    public final void run() {
                        if (QbSdk.isTbsCoreInited()) {
                            a.done();
                        } else {
                            QbSdk.preInit(aa.getContext(), new com.tencent.smtt.sdk.QbSdk.a(this) {
                                private boolean dQj = false;
                                private boolean dQk = false;
                                final /* synthetic */ AnonymousClass1 dQl;

                                {
                                    this.dQl = r2;
                                }

                                public final void RT() {
                                    this.dQj = true;
                                    if (this.dQj && this.dQk) {
                                        a.done();
                                    }
                                }

                                public final void by(boolean z) {
                                    this.dQk = true;
                                    if (this.dQj && this.dQk) {
                                        a.done();
                                    }
                                }
                            });
                        }
                    }
                });
            } else if (aVar != null) {
                aVar.onReady();
            }
        }
    }

    private static synchronized void done() {
        synchronized (a.class) {
            dQh = true;
            dQg = false;
            Iterator it = dQi.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar != null) {
                    aVar.onReady();
                }
            }
            dQi.clear();
        }
    }
}
