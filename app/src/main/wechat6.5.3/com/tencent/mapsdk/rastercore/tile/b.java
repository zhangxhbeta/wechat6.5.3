package com.tencent.mapsdk.rastercore.tile;

import android.graphics.Bitmap;
import com.tencent.mapsdk.rastercore.d.e;
import com.tencent.mapsdk.rastercore.tile.d.a;
import com.tencent.tencentmap.mapsdk.map.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class b implements a {
    private static final TimeUnit a = TimeUnit.SECONDS;
    private static final int b = Runtime.getRuntime().availableProcessors();
    private e c;
    private Map<String, List<a>> d = new HashMap();
    private Map<String, List<a>> e = new HashMap();
    private final BlockingQueue<Runnable> f = new LinkedBlockingQueue();
    private final BlockingQueue<Runnable> g = new LinkedBlockingQueue();
    private ExecutorService h;
    private ExecutorService i;
    private ThreadFactory j = new ThreadFactory(this) {
        private int a = 0;

        public final Thread newThread(Runnable runnable) {
            StringBuilder stringBuilder = new StringBuilder("TileFetchThread#");
            int i = this.a;
            this.a = i + 1;
            Thread thread = new Thread(runnable, stringBuilder.append(i).toString());
            thread.setPriority(10);
            return thread;
        }
    };

    public b(e eVar) {
        int i;
        int i2 = 3;
        this.c = eVar;
        if (b < 4) {
            i = 3;
        } else {
            i2 = 4;
            i = 4;
        }
        this.i = new ThreadPoolExecutor(i, i2, 30, TimeUnit.SECONDS, this.g, this.j);
        this.h = new ThreadPoolExecutor(1, 1, 30, a, this.f);
    }

    static /* synthetic */ void a(b bVar, a aVar) {
        String aVar2 = aVar.toString();
        synchronized (bVar.d) {
            List list = (List) bVar.d.get(aVar2);
            if (list != null) {
                list.add(aVar);
            } else {
                list = new ArrayList();
                list.add(aVar);
                bVar.d.put(aVar2, list);
                try {
                    Callable dVar = new d(bVar, aVar);
                    if (!bVar.i.isShutdown()) {
                        bVar.i.submit(dVar);
                    }
                } catch (Exception e) {
                    new StringBuilder("Submit get error:").append(e.getMessage());
                }
            }
        }
    }

    public final void a() {
        if (this.f != null) {
            this.f.clear();
        }
        if (this.g != null) {
            this.g.clear();
        }
        if (this.h != null) {
            this.h.shutdownNow();
            this.h = null;
        }
        if (this.i != null) {
            this.i.shutdown();
            this.i = null;
        }
    }

    public final void a(d dVar) {
        if (dVar != null) {
            List<a> list;
            String b = dVar.b();
            Bitmap a = dVar.a();
            synchronized (this.d) {
                list = (List) this.e.remove(b);
                this.d.remove(b);
            }
            if (!(list == null || a == null || a.isRecycled())) {
                for (a aVar : list) {
                    if (!aVar.i()) {
                        aVar.a(a.copy(a.getConfig(), false));
                    }
                }
            }
            dVar.c();
        }
        this.c.c().postInvalidate();
    }

    public final void a(final ArrayList<MapTile> arrayList) {
        if (!com.tencent.mapsdk.rastercore.f.a.a((Collection) arrayList)) {
            this.f.clear();
            Runnable anonymousClass2 = new Runnable(this) {
                private /* synthetic */ b b;

                public final void run() {
                    this.b.g.clear();
                    synchronized (this.b.d) {
                        this.b.d.clear();
                        this.b.d.putAll(this.b.e);
                    }
                    for (int i = 0; i < arrayList.size(); i++) {
                        for (a aVar : ((MapTile) arrayList.get(i)).b()) {
                            Bitmap a;
                            StringBuilder stringBuilder = new StringBuilder();
                            try {
                                a = com.tencent.mapsdk.rastercore.tile.a.a.a().a(aVar, stringBuilder);
                            } catch (Throwable th) {
                                if (g.pAe != null) {
                                    g.pAe.collectErrorInfo("TileEngineManager getTiles Runnable call CacheManager Get occured Exception,tileInfo:x=" + aVar.b() + ",y=" + aVar.c() + ",z=" + aVar.d() + ";Get execute path:" + stringBuilder.toString() + ";Exception Info:" + th.toString());
                                }
                                a = null;
                            }
                            if (a != null) {
                                aVar.a(a);
                            } else {
                                b.a(this.b, aVar);
                            }
                        }
                        this.b.c.c().postInvalidate();
                    }
                }
            };
            try {
                if (!this.h.isShutdown()) {
                    this.h.execute(anonymousClass2);
                }
            } catch (Exception e) {
                new StringBuilder("getTiles get error:").append(e.getMessage());
            }
        }
    }

    public final void b(d dVar) {
        if (dVar != null) {
            String b = dVar.b();
            synchronized (this.d) {
                this.e.put(b, (List) this.d.remove(b));
            }
        }
    }
}
