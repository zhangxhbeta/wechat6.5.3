package com.tencent.mm.kiss.a;

import android.app.Activity;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewStub;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class b {
    private static b clp;
    public LayoutInflater CE;
    private ConcurrentHashMap<String, c> clo = new ConcurrentHashMap();
    public Looper clq;
    public ac clr;
    public boolean cls = false;
    public boolean clt = false;
    public b clu;
    public int mMode = 2;

    private static final class a implements OnAttachStateChangeListener {
        private String clw;
        private b clx;
        private c cly = null;

        public a(String str, b bVar, c cVar) {
            this.clw = str;
            this.clx = bVar;
        }

        public final void onViewAttachedToWindow(View view) {
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onViewDetachedFromWindow(android.view.View r5) {
            /*
            r4 = this;
            r0 = r4.clx;
            r0 = r0.clo;
            r1 = r4.clw;
            r0 = r0.get(r1);
            r0 = (com.tencent.mm.kiss.a.c) r0;
            r1 = r4.clx;
            r1 = r1.mMode;
            r2 = 1;
            if (r1 != r2) goto L_0x003c;
        L_0x0017:
            if (r0 == 0) goto L_0x0029;
        L_0x0019:
            monitor-enter(r0);
            r1 = r0.clH;	 Catch:{ all -> 0x0039 }
            r1.remove(r5);	 Catch:{ all -> 0x0039 }
            r1 = r0.clG;	 Catch:{ all -> 0x0039 }
            r1.add(r5);	 Catch:{ all -> 0x0039 }
            monitor-exit(r0);	 Catch:{ all -> 0x0039 }
            r0 = r4.cly;
            if (r0 == 0) goto L_0x0029;
        L_0x0029:
            r5.removeOnAttachStateChangeListener(r4);
            r0 = r4.clx;
            r0 = r0.clu;
            r1 = r0.init();	 Catch:{ Throwable -> 0x0051 }
            if (r1 != 0) goto L_0x0042;
        L_0x0038:
            return;
        L_0x0039:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0039 }
            throw r1;
        L_0x003c:
            r1 = r4.clx;
            com.tencent.mm.kiss.a.b.a(r1, r0);
            goto L_0x0029;
        L_0x0042:
            r1 = r0.mHandler;
            r2 = 0;
            r1.removeCallbacksAndMessages(r2);
            r0 = r0.mHandler;
            r1 = 0;
            r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
            r0.sendEmptyMessageDelayed(r1, r2);
            goto L_0x0038;
        L_0x0051:
            r0 = move-exception;
            goto L_0x0038;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.kiss.a.b.a.onViewDetachedFromWindow(android.view.View):void");
        }
    }

    private static final class b {
        Field clA;
        Class clB;
        Field clC = null;
        private boolean clD = false;
        private boolean clE = false;
        Class clz;
        ac mHandler;

        public b(Looper looper) {
            this.mHandler = new ac(this, looper) {
                final /* synthetic */ b clF;

                public final void handleMessage(Message message) {
                    long nanoTime;
                    try {
                        nanoTime = System.nanoTime();
                        b bVar = this.clF;
                        ThreadLocal threadLocal = (ThreadLocal) bVar.clA.get(null);
                        if (threadLocal != null) {
                            Object obj = threadLocal.get();
                            if (obj != null) {
                                try {
                                    obj = bVar.clC.get(obj);
                                    if (obj != null) {
                                        if (obj instanceof List) {
                                            ((List) obj).clear();
                                        }
                                    }
                                } catch (Throwable e) {
                                    v.a("KISS.InflateRecycler", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                                }
                            }
                        }
                    } catch (Throwable e2) {
                        v.a("KISS.InflateRecycler", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                    } catch (Throwable th) {
                        return;
                    }
                    long nanoTime2 = System.nanoTime() - nanoTime;
                    v.i("KISS.InflateRecycler", "durtion %s", Long.valueOf(nanoTime2));
                }
            };
        }

        final boolean init() {
            if (this.clD) {
                return this.clE;
            }
            this.clD = true;
            try {
                this.clz = Class.forName("android.view.ViewRootImpl");
                try {
                    this.clA = this.clz.getDeclaredField("sRunQueues");
                    this.clA.setAccessible(true);
                    try {
                        this.clB = Class.forName("android.view.ViewRootImpl$RunQueue");
                        try {
                            this.clC = this.clB.getDeclaredField("mActions");
                            this.clC.setAccessible(true);
                            this.clE = true;
                            return true;
                        } catch (Throwable e) {
                            v.a("KISS.InflateRecycler", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                            return false;
                        }
                    } catch (Throwable e2) {
                        v.a("KISS.InflateRecycler", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                        return false;
                    }
                } catch (Throwable e22) {
                    v.a("KISS.InflateRecycler", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
                    return false;
                }
            } catch (Throwable e222) {
                v.a("KISS.InflateRecycler", e222, SQLiteDatabase.KeyEmpty, new Object[0]);
                return false;
            }
        }
    }

    public interface c {
    }

    class AnonymousClass1 extends ac {
        final /* synthetic */ b clv;

        public AnonymousClass1(b bVar, Looper looper) {
            this.clv = bVar;
            super(looper);
        }

        public final void handleMessage(Message message) {
            v.i("KISS.InflateRecycler", "InflateViewRecycler start %s", Long.valueOf(System.currentTimeMillis()));
            c cVar = (c) message.obj;
            int size = cVar.clI - cVar.clG.size();
            int i = cVar.CC;
            for (int i2 = 0; i2 < size; i2++) {
                View inflate = this.clv.CE.inflate(i, null);
                synchronized (cVar) {
                    cVar.clG.add(inflate);
                }
                if (!(cVar.clJ == null || cVar.clJ.length == 0)) {
                    for (int i3 = 0; i3 < cVar.clJ.length; i3 += 2) {
                        View findViewById = inflate.findViewById(cVar.clJ[i3]);
                        if (findViewById != null && (findViewById instanceof ViewStub)) {
                            int i4 = cVar.clJ[i3 + 1];
                            if (i4 != 0) {
                                ((ViewStub) findViewById).setLayoutResource(i4);
                            }
                            ((ViewStub) findViewById).inflate();
                        }
                    }
                }
            }
            v.i("KISS.InflateRecycler", "InflateViewRecycler end %s", Long.valueOf(System.currentTimeMillis()));
            v.i("KISS.InflateRecycler", "preload done");
        }
    }

    static /* synthetic */ void a(b bVar, c cVar) {
        if (bVar.cls && !bVar.clt && cVar.clI > cVar.clG.size()) {
            bVar.clr.sendMessage(bVar.clr.obtainMessage(0, cVar));
        }
    }

    static {
        clp = null;
        clp = new b();
    }

    public static b vH() {
        return clp;
    }

    public final View a(Activity activity, String str, int i) {
        if (this.clt) {
            v.i("KISS.InflateRecycler", "not support application inflate");
            return activity.getLayoutInflater().inflate(i, null);
        }
        c cVar = (c) this.clo.get(str);
        if (cVar != null) {
            View view;
            synchronized (cVar) {
                view = (View) cVar.clG.poll();
                if (this.mMode == 1) {
                    cVar.clH.add(view);
                }
            }
            if (view != null) {
                v.i("KISS.InflateRecycler", "cache reach");
                view.addOnAttachStateChangeListener(new a(str, this, null));
                return view;
            }
        }
        v.i("KISS.InflateRecycler", "no cache reach");
        return this.CE.inflate(i, null);
    }

    public final boolean a(String str, int i, int... iArr) {
        if (!this.cls) {
            return false;
        }
        if (this.clt) {
            v.i("KISS.InflateRecycler", "not support application inflate");
            return false;
        } else if (((c) this.clo.get(str)) != null) {
            return false;
        } else {
            c cVar = new c();
            this.clo.put(str, cVar);
            cVar.clI = 6;
            cVar.clw = str;
            cVar.CC = i;
            cVar.clJ = iArr;
            this.clr.sendMessage(this.clr.obtainMessage(0, cVar));
            return true;
        }
    }
}
