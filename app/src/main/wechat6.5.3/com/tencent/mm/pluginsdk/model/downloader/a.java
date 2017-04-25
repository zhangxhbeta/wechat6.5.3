package com.tencent.mm.pluginsdk.model.downloader;

import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;
import java.util.Vector;

public final class a {
    private static Vector<l> lBM = new Vector();
    private static l lBN;

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ String dhf;
        final /* synthetic */ long jmO;
        final /* synthetic */ a lBO;

        AnonymousClass2(a aVar, long j, String str) {
            this.lBO = aVar;
            this.jmO = j;
            this.dhf = str;
        }

        public final void run() {
            if (a.lBM != null) {
                Iterator it = a.lBM.iterator();
                while (it.hasNext()) {
                    ((l) it.next()).bW(this.jmO);
                }
            }
            if (a.lBN != null) {
                a.lBN.bW(this.jmO);
            }
        }
    }

    a() {
    }

    public static void a(l lVar) {
        if (lVar != null && !lBM.contains(lVar)) {
            lBM.add(lVar);
        }
    }

    public static void b(l lVar) {
        if (lBM != null && lVar != null) {
            lBM.remove(lVar);
        }
    }

    public static void c(l lVar) {
        lBN = lVar;
    }

    public static void bnH() {
        lBN = null;
    }

    public final void q(final long j, final String str) {
        v.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskStarted: %d, %s", Long.valueOf(j), str);
        ad.o(new Runnable(this) {
            final /* synthetic */ a lBO;

            public final void run() {
                if (a.lBM != null) {
                    Iterator it = a.lBM.iterator();
                    while (it.hasNext()) {
                        ((l) it.next()).onTaskStarted(j, str);
                    }
                }
                if (a.lBN != null) {
                    a.lBN.onTaskStarted(j, str);
                }
            }
        });
    }

    public final void dD(final long j) {
        v.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskRemoved: %d", Long.valueOf(j));
        ad.o(new Runnable(this) {
            final /* synthetic */ a lBO;

            public final void run() {
                if (a.lBM != null) {
                    Iterator it = a.lBM.iterator();
                    while (it.hasNext()) {
                        ((l) it.next()).onTaskRemoved(j);
                    }
                }
                if (a.lBN != null) {
                    a.lBN.onTaskRemoved(j);
                }
            }
        });
    }

    public final void r(final long j, final String str) {
        v.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskFinished: %d", Long.valueOf(j));
        ad.o(new Runnable(this) {
            final /* synthetic */ a lBO;

            public final void run() {
                if (a.lBM != null) {
                    Iterator it = a.lBM.iterator();
                    while (it.hasNext()) {
                        ((l) it.next()).g(j, str);
                    }
                }
                if (a.lBN != null) {
                    a.lBN.g(j, str);
                }
            }
        });
    }

    public final void v(final long j, final int i) {
        v.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskFailed: %d", Long.valueOf(j));
        ad.o(new Runnable(this) {
            final /* synthetic */ a lBO;

            public final void run() {
                if (a.lBM != null) {
                    Iterator it = a.lBM.iterator();
                    while (it.hasNext()) {
                        ((l) it.next()).q(j, i);
                    }
                }
                if (a.lBN != null) {
                    a.lBN.q(j, i);
                }
            }
        });
    }

    public final void dE(final long j) {
        v.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskPaused: %d", Long.valueOf(j));
        ad.o(new Runnable(this) {
            final /* synthetic */ a lBO;

            public final void run() {
                if (a.lBM != null) {
                    Iterator it = a.lBM.iterator();
                    while (it.hasNext()) {
                        ((l) it.next()).onTaskPaused(j);
                    }
                }
                if (a.lBN != null) {
                    a.lBN.onTaskPaused(j);
                }
            }
        });
    }

    public final void dF(final long j) {
        ad.o(new Runnable(this) {
            final /* synthetic */ a lBO;

            public final void run() {
                if (a.lBM != null) {
                    Iterator it = a.lBM.iterator();
                    while (it.hasNext()) {
                        ((l) it.next()).bV(j);
                    }
                }
            }
        });
    }
}
