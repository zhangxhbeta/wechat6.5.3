package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public final class b {

    public interface a {
        void jg(boolean z);
    }

    private static class b implements InvocationHandler {
        public WeakReference<a> nRB;

        private b() {
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) {
            boolean z = false;
            if (this.nRB == null) {
                v.i("MicroMsg.ActivityUtil", "swipe invoke fail, callbackRef NULL!");
            } else {
                a aVar = (a) this.nRB.get();
                if (aVar == null) {
                    v.i("MicroMsg.ActivityUtil", "swipe invoke fail, callback NULL!");
                } else {
                    if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                        z = ((Boolean) objArr[0]).booleanValue();
                    }
                    aVar.jg(z);
                }
            }
            return null;
        }
    }

    public static int On(String str) {
        Class Oo = Oo(str);
        if (Oo != null) {
            return r(Oo);
        }
        return 0;
    }

    public static int r(Class<?> cls) {
        do {
            a aVar = (a) cls.getAnnotation(a.class);
            if (aVar != null) {
                return aVar.value();
            }
            cls = cls.getSuperclass();
        } while (cls != null);
        return 0;
    }

    private static Class<?> Oo(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            v.a("MicroMsg.ActivityUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            v.e("MicroMsg.ActivityUtil", "Class %s not found in dex", str);
            return null;
        }
    }

    public static boolean s(Class<?> cls) {
        return (r(cls) & 1) == 0;
    }

    public static void aa(Activity activity) {
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(activity, new Object[0]);
        } catch (Throwable th) {
            v.a("MicroMsg.ActivityUtil", th, "call convertActivityFromTranslucent Fail: %s", th.getMessage());
        }
    }

    public static void ev(Context context) {
        if (context != null && (context instanceof Activity)) {
            ((Activity) context).overridePendingTransition(2130968641, 2130968589);
        }
    }

    public static void x(Context context, Intent intent) {
        if (intent != null && context != null && (context instanceof Activity) && intent.getBooleanExtra("animation_pop_in", false)) {
            ((Activity) context).overridePendingTransition(2130968641, 2130968589);
        }
    }

    public static void ew(Context context) {
        if (context != null && (context instanceof Activity)) {
            ((Activity) context).overridePendingTransition(2130968589, 2130968642);
        }
    }

    public static void ex(Context context) {
        if (context != null && (context instanceof Activity)) {
            ((Activity) context).overridePendingTransition(2130968589, 2130968589);
        }
    }
}
