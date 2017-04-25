package com.tencent.mm.svg.b;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.TypedValue;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.lang.reflect.Field;
import java.util.Map;

public final class e {
    private static boolean nyB = false;
    private static a nyC;
    private static LongSparseArray<ConstantState>[] nyD;
    private static LongSparseArray<ConstantState> nyE;
    private static c<ConstantState> nyF;
    private static c<ConstantState> nyG;
    protected static Application nyH;
    protected static Class<d> nyI;
    private static Class<?> nyJ = null;

    public static class a {
        Resources BE;
        Application nyK;
        TypedValue nyi = new TypedValue();
        Map<Integer, com.tencent.mm.svg.c> nyn;

        public a(Map<Integer, com.tencent.mm.svg.c> map, Application application) {
            this.nyn = map;
            this.nyK = application;
            this.BE = application.getResources();
        }

        public final void a(Integer num, com.tencent.mm.svg.c cVar) {
            this.nyn.put(num, cVar);
            e.a(this.nyK, this.BE, num.intValue(), this.nyi);
        }
    }

    protected static class b extends ConstantState {
        private Resources BE;
        private int koH = 0;

        public b(int i, Resources resources) {
            if (i == 0) {
                com.tencent.mm.svg.c.c.e("MicroMsg.SVGResourceLoader", "SVGConstantState Why this id is %d. TypedValue %s", Integer.valueOf(i));
                com.tencent.mm.svg.c.c.i("MicroMsg.SVGResourceLoader", Log.getStackTraceString(new Throwable()), new Object[0]);
            }
            this.koH = i;
            this.BE = resources;
        }

        public final Drawable newDrawable() {
            return a.c(this.BE, this.koH);
        }

        public final int getChangingConfigurations() {
            return 0;
        }
    }

    @TargetApi(16)
    public static class c<T> extends LongSparseArray<T> {
        public static boolean nyL = false;
        LongSparseArray<T> nyE = null;

        public final T get(long j, T t) {
            if (this.nyE.indexOfKey(j) < 0) {
                return super.get(j, t);
            }
            if (!e.nyB) {
                e.byg();
            }
            return this.nyE.get(j, t);
        }

        public final void delete(long j) {
            super.delete(j);
            com.tencent.mm.svg.c.c.e("MicroMsg.SVGLongSparseArray", "Found u! delete key %s", Long.valueOf(j));
        }

        public final void remove(long j) {
            super.remove(j);
            com.tencent.mm.svg.c.c.e("MicroMsg.SVGLongSparseArray", "Found u! remove key %s", Long.valueOf(j));
        }

        public final void clear() {
            super.clear();
            com.tencent.mm.svg.c.c.e("MicroMsg.SVGLongSparseArray", "Found u! clear.", new Object[0]);
        }
    }

    static /* synthetic */ void a(Application application, Resources resources, int i, TypedValue typedValue) {
        if (i == 0) {
            com.tencent.mm.svg.c.c.e("MicroMsg.SVGResourceLoader", "preloadDrawable Why this id is %d. TypedValue %s", Integer.valueOf(i), typedValue);
            com.tencent.mm.svg.c.c.i("MicroMsg.SVGResourceLoader", Log.getStackTraceString(new Throwable()), new Object[0]);
        }
        resources.getValue(i, typedValue, true);
        nyE.put((((long) typedValue.assetCookie) << 32) | ((long) typedValue.data), new b(i, application.getResources()));
    }

    static /* synthetic */ void byg() {
        try {
            com.tencent.mm.svg.c.c.e("MicroMsg.SVGResourceLoader", "Reach here, why?", new Object[0]);
            if (nyI == null) {
                g(nyH);
            } else {
                a(nyH, nyI);
            }
        } catch (Throwable e) {
            com.tencent.mm.svg.c.c.a("MicroMsg.SVGResourceLoader", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        } catch (Throwable e2) {
            com.tencent.mm.svg.c.c.a("MicroMsg.SVGResourceLoader", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
        } catch (Throwable e22) {
            com.tencent.mm.svg.c.c.a("MicroMsg.SVGResourceLoader", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    public static void p(Class<?> cls) {
        nyJ = cls;
    }

    public static void a(com.tencent.mm.svg.c.c.a aVar) {
        com.tencent.mm.svg.c.c.b(aVar);
    }

    public static void e(Application application) {
        long nanoTime;
        int i;
        Throwable th;
        int i2;
        String packageName = application.getPackageName();
        a.GT(packageName);
        com.tencent.mm.svg.c.b.GT(packageName);
        String str = packageName + ".svg.SVGPreload";
        nyH = application;
        try {
            com.tencent.mm.svg.c.c.i("MicroMsg.SVGResourceLoader", "try to load SVGPreload", new Object[0]);
            Class cls = Class.forName(str);
            nanoTime = System.nanoTime();
            ei(application);
            a(application, cls);
            try {
                com.tencent.mm.svg.c.c.i("MicroMsg.SVGResourceLoader", "load SVGPreload spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
            } catch (ClassNotFoundException e) {
                i = 1;
            } catch (InstantiationException e2) {
                i = 1;
                com.tencent.mm.svg.c.c.e("MicroMsg.SVGResourceLoader", "InstantiationException %s", str);
                if (i == 0) {
                    com.tencent.mm.svg.c.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                    nanoTime = System.nanoTime();
                    ei(application);
                    try {
                        g(application);
                    } catch (ClassNotFoundException e3) {
                    }
                    com.tencent.mm.svg.c.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
                }
            } catch (IllegalAccessException e4) {
                i = 1;
                com.tencent.mm.svg.c.c.e("MicroMsg.SVGResourceLoader", "IllegalAccessException %s", str);
                if (i == 0) {
                    com.tencent.mm.svg.c.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                    nanoTime = System.nanoTime();
                    ei(application);
                    try {
                        g(application);
                    } catch (ClassNotFoundException e5) {
                    }
                    com.tencent.mm.svg.c.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
                }
            } catch (Throwable th2) {
                th = th2;
                i2 = 1;
                if (i2 == 0) {
                    com.tencent.mm.svg.c.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                    nanoTime = System.nanoTime();
                    ei(application);
                    try {
                        g(application);
                    } catch (ClassNotFoundException e6) {
                    }
                    com.tencent.mm.svg.c.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
                }
                throw th;
            }
        } catch (ClassNotFoundException e7) {
            i = 0;
            try {
                com.tencent.mm.svg.c.c.e("MicroMsg.SVGResourceLoader", "ClassNotFoundException %s. Go fallback logic.", str);
                if (i == 0) {
                    com.tencent.mm.svg.c.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                    nanoTime = System.nanoTime();
                    ei(application);
                    try {
                        g(application);
                    } catch (ClassNotFoundException e8) {
                    }
                    com.tencent.mm.svg.c.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                i2 = i;
                th = th4;
                if (i2 == 0) {
                    com.tencent.mm.svg.c.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                    nanoTime = System.nanoTime();
                    ei(application);
                    g(application);
                    com.tencent.mm.svg.c.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
                }
                throw th;
            }
        } catch (InstantiationException e9) {
            i = 0;
            com.tencent.mm.svg.c.c.e("MicroMsg.SVGResourceLoader", "InstantiationException %s", str);
            if (i == 0) {
                com.tencent.mm.svg.c.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                nanoTime = System.nanoTime();
                ei(application);
                g(application);
                com.tencent.mm.svg.c.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
            }
        } catch (IllegalAccessException e10) {
            i = 0;
            com.tencent.mm.svg.c.c.e("MicroMsg.SVGResourceLoader", "IllegalAccessException %s", str);
            if (i == 0) {
                com.tencent.mm.svg.c.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                nanoTime = System.nanoTime();
                ei(application);
                g(application);
                com.tencent.mm.svg.c.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
            }
        } catch (Throwable th5) {
            th = th5;
            i2 = 0;
            if (i2 == 0) {
                com.tencent.mm.svg.c.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                nanoTime = System.nanoTime();
                ei(application);
                g(application);
                com.tencent.mm.svg.c.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
            }
            throw th;
        }
    }

    private static a f(Application application) {
        if (nyC == null) {
            nyC = new a(a.byb(), application);
        }
        return nyC;
    }

    @TargetApi(16)
    private static void ei(Context context) {
        int i = 1;
        if (nyF == null) {
            try {
                Object obj;
                nyE = new LongSparseArray();
                c cVar = new c();
                nyF = cVar;
                cVar.nyE = nyE;
                cVar = new c();
                nyG = cVar;
                cVar.nyE = nyE;
                if (VERSION.SDK_INT >= 23) {
                    com.tencent.mm.svg.c.a aVar = new com.tencent.mm.svg.c.a(context.getResources(), "mResourcesImpl");
                    aVar.prepare();
                    if (aVar.cfC == null) {
                        i = 0;
                    }
                    if (i != 0) {
                        obj = aVar.get();
                    } else {
                        obj = context.getResources();
                    }
                } else {
                    obj = context.getResources();
                }
                a(context, obj);
                com.tencent.mm.svg.c.c.i("MicroMsg.SVGResourceLoader", "SVG this resources %s", context.getResources());
            } catch (Throwable e) {
                com.tencent.mm.svg.c.c.a("MicroMsg.SVGResourceLoader", e, "Call reflectPreloadCache failed. Reason : NoSuchFieldException.", new Object[0]);
            } catch (Throwable e2) {
                com.tencent.mm.svg.c.c.a("MicroMsg.SVGResourceLoader", e2, "Call reflectPreloadCache failed. Reason : IllegalAccessException.", new Object[0]);
            } catch (Throwable e22) {
                com.tencent.mm.svg.c.c.a("MicroMsg.SVGResourceLoader", e22, "Call reflectPreloadCache failed. Reason : IllegalArgumentException.", new Object[0]);
            }
        }
    }

    @TargetApi(16)
    private static void a(Context context, Object obj) {
        Object obj2 = new com.tencent.mm.svg.c.a(obj, "sPreloadedDrawables").get();
        if (obj2 == null) {
            com.tencent.mm.svg.c.c.e("MicroMsg.SVGResourceLoader", "mResourcePreloadDrawable is null!! OMG!!!", new Object[0]);
        } else if (obj2 instanceof LongSparseArray[]) {
            int i;
            long keyAt;
            nyD = (LongSparseArray[]) obj2;
            com.tencent.mm.svg.c.c.d("MicroMsg.SVGResourceLoader", "sPreloadDrawable content: %s ", nyD[0]);
            for (i = 0; i < nyD[0].size(); i++) {
                keyAt = nyD[0].keyAt(i);
                nyF.put(keyAt, nyD[0].get(keyAt));
            }
            for (i = 0; i < nyD[1].size(); i++) {
                keyAt = nyD[1].keyAt(i);
                nyG.put(keyAt, nyD[1].get(keyAt));
            }
            nyD[0] = nyF;
            nyD[1] = nyG;
        } else if (obj2 instanceof LongSparseArray) {
            com.tencent.mm.svg.c.a aVar = new com.tencent.mm.svg.c.a(context.getResources(), "sPreloadedDrawables");
            LongSparseArray longSparseArray = (LongSparseArray) aVar.get();
            for (int i2 = 0; i2 < longSparseArray.size(); i2++) {
                long keyAt2 = longSparseArray.keyAt(i2);
                nyF.put(keyAt2, longSparseArray.get(keyAt2));
            }
            c cVar = nyF;
            aVar.prepare();
            if (aVar.cfC == null) {
                throw new NoSuchFieldException();
            }
            aVar.cfC.set(aVar.obj, cVar);
            if (aVar.get() == null) {
                com.tencent.mm.svg.c.c.e("MicroMsg.SVGResourceLoader", "resourcePreloadDrawable is null!! OMG!!", new Object[0]);
            }
        } else {
            com.tencent.mm.svg.c.c.e("MicroMsg.SVGResourceLoader", "mResourcePreloadDrawable is others!! OMG!", new Object[0]);
        }
    }

    private static void a(Application application, Class<d> cls) {
        nyH = application;
        nyI = cls;
        try {
            if (nyI != null) {
                ((d) cls.newInstance()).load(f(application));
                com.tencent.mm.svg.c.c.i("MicroMsg.SVGResourceLoader", "SVGCode wrapper size %s", Integer.valueOf(f(application).nyn.size()));
                nyB = true;
            }
        } catch (Throwable e) {
            com.tencent.mm.svg.c.c.a("MicroMsg.SVGResourceLoader", e, "We found one NotFoundException.", new Object[0]);
            nyB = false;
        }
    }

    private static Class<?> byf() {
        if (nyJ != null) {
            return nyJ;
        }
        Class<?> cls;
        try {
            cls = Class.forName(nyH.getPackageName() + ".R$raw");
            if (cls != null) {
                return cls;
            }
        } catch (ClassNotFoundException e) {
        }
        cls = com.tencent.mm.svg.c.b.byj();
        return cls == null ? null : cls;
    }

    private static void g(Application application) {
        Class byf = byf();
        if (byf == null) {
            com.tencent.mm.svg.c.c.e("MicroMsg.SVGResourceLoader", "Raw class is null!", new Object[0]);
            return;
        }
        Field[] declaredFields = byf.getDeclaredFields();
        a f = f(application);
        try {
            a aVar = new a();
            for (Field field : declaredFields) {
                int i = field.getInt(null);
                if (aVar.d(application.getResources(), i)) {
                    a(f.nyK, f.BE, i, f.nyi);
                }
            }
            nyB = true;
        } catch (IllegalAccessException e) {
            nyB = false;
        } catch (IllegalArgumentException e2) {
            nyB = false;
        }
    }
}
