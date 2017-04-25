package com.tencent.mm.performance.a;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.performance.d.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Set;

public final class a extends com.tencent.mm.performance.d.a {
    public static String TYPE = "ActivityMonitorController";
    private boolean dnt = false;
    public Set<a> dnu = null;
    private Object dnv = null;
    private Instrumentation dnw = null;

    public static abstract class a {
        public void a(Activity activity, Bundle bundle) {
        }

        public void b(Activity activity, Bundle bundle) {
        }

        public void g(Activity activity) {
        }

        public void h(Activity activity) {
        }

        public void i(Activity activity) {
        }

        public void j(Activity activity) {
        }

        public void k(Activity activity) {
        }

        public void l(Activity activity) {
        }

        public void c(Activity activity, Intent intent) {
        }

        public void d(Activity activity, Intent intent) {
        }

        public void m(Activity activity) {
        }

        public void n(Activity activity) {
        }

        public void o(Activity activity) {
        }

        public void p(Activity activity) {
        }
    }

    private class b extends Instrumentation {
        final /* synthetic */ a dnx;

        private b(a aVar) {
            this.dnx = aVar;
        }

        public void callActivityOnCreate(Activity activity, Bundle bundle) {
            this.dnx.a(activity, bundle, true);
            this.dnx.dnw.callActivityOnCreate(activity, bundle);
            this.dnx.a(activity, bundle, false);
        }

        public void callActivityOnResume(Activity activity) {
            this.dnx.a(activity, true);
            this.dnx.dnw.callActivityOnResume(activity);
            this.dnx.a(activity, false);
        }

        public void callActivityOnPause(Activity activity) {
            this.dnx.b(activity, true);
            this.dnx.dnw.callActivityOnPause(activity);
            this.dnx.b(activity, false);
        }

        public void callActivityOnStart(Activity activity) {
            this.dnx.c(activity, true);
            this.dnx.dnw.callActivityOnStart(activity);
            this.dnx.c(activity, false);
        }

        public void callActivityOnRestart(Activity activity) {
            this.dnx.MG();
            this.dnx.dnw.callActivityOnRestart(activity);
            this.dnx.MG();
        }

        public void callActivityOnNewIntent(Activity activity, Intent intent) {
            this.dnx.a(activity, intent, true);
            this.dnx.dnw.callActivityOnNewIntent(activity, intent);
            this.dnx.a(activity, intent, false);
        }

        public void callActivityOnSaveInstanceState(Activity activity, Bundle bundle) {
            this.dnx.MH();
            this.dnx.dnw.callActivityOnSaveInstanceState(activity, bundle);
            this.dnx.MH();
        }

        public void callActivityOnRestoreInstanceState(Activity activity, Bundle bundle) {
            this.dnx.MI();
            this.dnx.dnw.callActivityOnRestoreInstanceState(activity, bundle);
            this.dnx.MI();
        }

        public void callActivityOnStop(Activity activity) {
            this.dnx.d(activity, true);
            this.dnx.dnw.callActivityOnStop(activity);
            this.dnx.d(activity, false);
        }

        public void callActivityOnDestroy(Activity activity) {
            this.dnx.e(activity, true);
            this.dnx.dnw.callActivityOnDestroy(activity);
            this.dnx.e(activity, false);
        }
    }

    public final synchronized void a(a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("callback is null");
        } else if (this.dnt) {
            this.dnu.add(aVar);
        }
    }

    private synchronized void a(Activity activity, Bundle bundle, boolean z) {
        for (a aVar : this.dnu) {
            if (z) {
                aVar.a(activity, bundle);
            } else {
                aVar.b(activity, bundle);
            }
        }
    }

    private synchronized void a(Activity activity, boolean z) {
        for (a aVar : this.dnu) {
            if (z) {
                aVar.g(activity);
            } else {
                aVar.h(activity);
            }
        }
    }

    private synchronized void b(Activity activity, boolean z) {
        for (a aVar : this.dnu) {
            if (z) {
                aVar.i(activity);
            } else {
                aVar.j(activity);
            }
        }
    }

    private synchronized void c(Activity activity, boolean z) {
        for (a aVar : this.dnu) {
            if (z) {
                aVar.k(activity);
            } else {
                aVar.l(activity);
            }
        }
    }

    private synchronized void MG() {
        Iterator it = this.dnu.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private synchronized void a(Activity activity, Intent intent, boolean z) {
        for (a aVar : this.dnu) {
            if (z) {
                aVar.c(activity, intent);
            } else {
                aVar.d(activity, intent);
            }
        }
    }

    private synchronized void MH() {
        Iterator it = this.dnu.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private synchronized void MI() {
        Iterator it = this.dnu.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private synchronized void d(Activity activity, boolean z) {
        for (a aVar : this.dnu) {
            if (z) {
                aVar.m(activity);
            } else {
                aVar.n(activity);
            }
        }
    }

    private synchronized void e(Activity activity, boolean z) {
        for (a aVar : this.dnu) {
            if (z) {
                aVar.o(activity);
            } else {
                aVar.p(activity);
            }
        }
    }

    public final boolean MJ() {
        boolean z;
        try {
            this.dnv = c.ag("android.app.ActivityThread", "currentActivityThread");
            if (this.dnv == null) {
                throw new IllegalStateException("Failed to get CurrentActivityThread.");
            }
            this.dnw = (Instrumentation) c.a(this.dnv.getClass(), "mInstrumentation", this.dnv);
            if (this.dnw == null) {
                throw new IllegalStateException("Failed to get Instrumentation instance.");
            } else if (this.dnw.getClass().equals(b.class)) {
                return true;
            } else {
                if (this.dnw.getClass().equals(Instrumentation.class) || this.dnw.getClass().getName().startsWith(aa.getPackageName())) {
                    Class cls = this.dnv.getClass();
                    String str = "mInstrumentation";
                    b bVar = new b();
                    Object obj = this.dnv;
                    try {
                        Field declaredField = cls.getDeclaredField(str);
                        declaredField.setAccessible(true);
                        declaredField.set(obj, bVar);
                        z = true;
                    } catch (Throwable e) {
                        v.a("MicroMsg.ReflectHelper", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                        z = true;
                    }
                    this.dnt = z;
                    return z;
                }
                throw new IllegalStateException("Not original Instrumentation instance, give up monitoring.");
            }
        } catch (Exception e2) {
            z = false;
        }
    }

    public final String MK() {
        return TYPE;
    }

    public final void ML() {
    }
}
