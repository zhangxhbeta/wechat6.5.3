package com.tencent.mm.plugin.search.a;

import android.database.Cursor;
import android.os.Process;
import android.util.Pair;
import com.tencent.mm.modelsearch.j;
import com.tencent.mm.modelsearch.r;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDiskIOException;
import com.tencent.mmdb.database.SQLiteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;

public final class d implements r {
    b iFw = new b(this);

    static class a extends com.tencent.mm.modelsearch.r.a {
        private ArrayList<Long> iFA = null;
        private int[] iFi;
        private com.tencent.mm.modelsearch.b iFx;
        private int[] iFy;
        private ArrayList<Pair<Integer, Integer>> iFz = null;

        public a(com.tencent.mm.modelsearch.b bVar, int[] iArr, int[] iArr2) {
            this.iFx = bVar;
            this.iFi = iArr;
            this.iFy = iArr2;
        }

        public final boolean execute() {
            int i;
            int i2;
            if (this.iFA == null) {
                this.iFz = new ArrayList();
                for (i = 0; i < this.iFi.length; i++) {
                    if (this.iFx.aP(this.iFi[i], this.iFy[i])) {
                        this.iFz.add(Pair.create(Integer.valueOf(this.iFi[i]), Integer.valueOf(this.iFy[i])));
                    }
                }
                if (!this.iFz.isEmpty()) {
                    v.i("MicroMsg.FTS.SearchDaemon", "need to update types size=%d", new Object[]{Integer.valueOf(this.iFz.size())});
                    aMg();
                    this.iFA = new ArrayList(2048);
                    int[] iArr = new int[this.iFz.size()];
                    for (i2 = 0; i2 < this.iFz.size(); i2++) {
                        iArr[i2] = ((Integer) ((Pair) this.iFz.get(i2)).first).intValue();
                    }
                    Cursor a = this.iFx.a(iArr, true, false, false, false, false);
                    while (a.moveToNext()) {
                        this.iFA.add(Long.valueOf(a.getLong(0)));
                    }
                    a.close();
                }
                return true;
            }
            i2 = this.iFA.size();
            int i3 = 50;
            while (i2 > 0) {
                if (Thread.interrupted()) {
                    this.iFx.commit();
                    throw new InterruptedException();
                }
                long longValue = ((Long) this.iFA.get(i2 - 1)).longValue();
                if (i3 >= 50) {
                    this.iFx.commit();
                    this.iFx.beginTransaction();
                    i = 0;
                } else {
                    i = i3;
                }
                this.iFx.c(Long.valueOf(longValue));
                i3 = i + 1;
                i = i2 - 1;
                this.iFA.remove(i);
                i2 = i;
            }
            this.iFx.commit();
            Iterator it = this.iFz.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                this.iFx.f((long) ((Integer) pair.first).intValue(), (long) ((Integer) pair.second).intValue());
            }
            return true;
        }

        protected void aMg() {
        }

        public String toString() {
            return "CheckIndexUpdateTask(" + h.i(this.iFi) + ", " + h.i(this.iFy) + ")";
        }
    }

    private class b extends Thread {
        private int iFB = 0;
        int iFC = Integer.MAX_VALUE;
        PriorityBlockingQueue<com.tencent.mm.modelsearch.r.a> iFD = new PriorityBlockingQueue();
        volatile boolean iFE = false;
        com.tencent.mm.modelsearch.r.a iFF;
        private boolean iFG;
        Runnable iFH;
        final /* synthetic */ d iFI;

        public b(d dVar) {
            this.iFI = dVar;
            super("SearchDaemon");
        }

        final synchronized void pd(int i) {
            if (this.iFC != i && isAlive()) {
                if (i < 0) {
                    if (this.iFC >= 0) {
                        Process.setThreadPriority(this.iFB, -8);
                        this.iFC = i;
                    }
                }
                if (i >= 0) {
                    if (this.iFC < 0) {
                        Process.setThreadPriority(this.iFB, this.iFG ? 10 : 0);
                    }
                }
                this.iFC = i;
            }
        }

        public final synchronized void quit() {
            this.iFE = true;
            interrupt();
        }

        public final synchronized void fl(boolean z) {
            int i = 0;
            synchronized (this) {
                if (this.iFG != z) {
                    this.iFG = z;
                    if (this.iFC >= 0 && isAlive() && this.iFB != 0) {
                        if (this.iFG) {
                            i = 10;
                        }
                        try {
                            Process.setThreadPriority(this.iFB, i);
                            v.i("MicroMsg.FTS.SearchDaemon", "*** Switch priority: " + (this.iFG ? "foreground" : "background"));
                        } catch (Throwable e) {
                            v.a("MicroMsg.FTS.SearchDaemon", e, "setLowPriorityMode failed, tid=%d, p=%d", new Object[]{Integer.valueOf(this.iFB), Integer.valueOf(i)});
                        }
                    }
                }
            }
        }

        public final void run() {
            com.tencent.mm.modelsearch.r.a aVar;
            String str;
            Throwable th;
            Throwable th2;
            Object obj;
            this.iFB = Process.myTid();
            while (true) {
                String str2 = " ";
                try {
                    Thread.interrupted();
                    if (this.iFE) {
                        this.iFB = 0;
                        return;
                    }
                    this.iFF = null;
                    com.tencent.mm.modelsearch.r.a aVar2 = (com.tencent.mm.modelsearch.r.a) this.iFD.take();
                    if (aVar2 != null) {
                        try {
                            this.iFF = aVar2;
                            pd(aVar2.mPriority);
                            long currentTimeMillis = System.currentTimeMillis();
                            if (this.iFC < 0) {
                                str2 = "!";
                            }
                            aVar2.execute();
                            currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                            j.fW(1);
                            j.m(aVar2.getId(), currentTimeMillis);
                            v.i("MicroMsg.FTS.SearchDaemon", "%s[%s] done, %dms", new Object[]{str2, aVar2, Long.valueOf(currentTimeMillis)});
                        } catch (InterruptedException e) {
                            String str3 = str2;
                            aVar = aVar2;
                            str = str3;
                            if (aVar == null) {
                                if (!aVar.ik) {
                                    this.iFD.put(aVar);
                                }
                                if (-1 > 0) {
                                    v.i("MicroMsg.FTS.SearchDaemon", str + "[" + aVar + (aVar.ik ? "] interruputed, " : "] cancelled, ") + (System.currentTimeMillis() - -1) + " ms.");
                                }
                            }
                        } catch (Throwable e2) {
                            th = e2;
                            aVar = aVar2;
                            th2 = th;
                            v.a("MicroMsg.FTS.SearchDaemon", th2, "[" + obj + "] failed with exception.\n", new Object[0]);
                            j.fW(6);
                        } catch (SQLiteDiskIOException e3) {
                            SQLiteDiskIOException sQLiteDiskIOException = e3;
                            aVar = aVar2;
                            th2 = sQLiteDiskIOException;
                            v.a("MicroMsg.FTS.SearchDaemon", th2, "[" + obj + "] failed with exception.\n", new Object[0]);
                            j.fW(7);
                        } catch (Throwable e22) {
                            th = e22;
                            aVar = aVar2;
                            th2 = th;
                            if (th2 instanceof NullPointerException) {
                                j.fW(3);
                            } else if (th2 instanceof SQLiteException) {
                                j.fW(4);
                            } else {
                                j.fW(5);
                            }
                            v.a("MicroMsg.FTS.SearchDaemon", th2, "[" + obj + "] failed with exception.\n", new Object[0]);
                            if (this.iFH != null) {
                                this.iFH.run();
                            }
                        }
                    }
                } catch (InterruptedException e4) {
                    str = str2;
                    aVar = null;
                    if (aVar == null) {
                        if (aVar.ik) {
                            this.iFD.put(aVar);
                        }
                        if (-1 > 0) {
                            if (aVar.ik) {
                            }
                            v.i("MicroMsg.FTS.SearchDaemon", str + "[" + aVar + (aVar.ik ? "] interruputed, " : "] cancelled, ") + (System.currentTimeMillis() - -1) + " ms.");
                        }
                    }
                } catch (com.tencent.mm.plugin.search.a.a.a e5) {
                    th2 = e5;
                    obj = null;
                    v.a("MicroMsg.FTS.SearchDaemon", th2, "[" + obj + "] failed with exception.\n", new Object[0]);
                    j.fW(6);
                } catch (SQLiteDiskIOException e6) {
                    th2 = e6;
                    obj = null;
                    v.a("MicroMsg.FTS.SearchDaemon", th2, "[" + obj + "] failed with exception.\n", new Object[0]);
                    j.fW(7);
                } catch (Exception e7) {
                    th2 = e7;
                    obj = null;
                    if (th2 instanceof NullPointerException) {
                        j.fW(3);
                    } else if (th2 instanceof SQLiteException) {
                        j.fW(4);
                    } else {
                        j.fW(5);
                    }
                    v.a("MicroMsg.FTS.SearchDaemon", th2, "[" + obj + "] failed with exception.\n", new Object[0]);
                    if (this.iFH != null) {
                        this.iFH.run();
                    }
                }
            }
        }
    }

    public final void start() {
        this.iFw.start();
        v.i("MicroMsg.FTS.SearchDaemon", "***** Search daemon started with TID: " + this.iFw.getId());
    }

    public final boolean Iz() {
        return this.iFw != null && this.iFw.isAlive();
    }

    public final com.tencent.mm.modelsearch.r.a a(int i, com.tencent.mm.modelsearch.r.a aVar) {
        if (this.iFw == null) {
            return null;
        }
        aVar.mPriority = i;
        b bVar = this.iFw;
        if (bVar.iFE) {
            return aVar;
        }
        int i2 = aVar.mPriority;
        bVar.iFD.put(aVar);
        if (bVar.iFF == null) {
            bVar.pd(i2);
            return aVar;
        } else if (i2 >= bVar.iFC) {
            return aVar;
        } else {
            bVar.interrupt();
            bVar.pd(i2);
            return aVar;
        }
    }

    public final void a(com.tencent.mm.modelsearch.r.a aVar) {
        if (this.iFw != null) {
            b bVar = this.iFw;
            aVar.ik = true;
            bVar.iFD.remove(aVar);
            if (bVar.iFF == aVar) {
                bVar.interrupt();
            }
        }
    }
}
