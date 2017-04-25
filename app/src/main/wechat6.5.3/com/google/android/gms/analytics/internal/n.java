package com.google.android.gms.analytics.internal;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.w;

public class n {
    public final q afY;

    public n(q qVar) {
        w.Z(qVar);
        this.afY = qVar;
    }

    private static String U(Object obj) {
        return obj == null ? "" : obj instanceof String ? (String) obj : obj instanceof Boolean ? obj == Boolean.TRUE ? "true" : "false" : obj instanceof Throwable ? ((Throwable) obj).toString() : obj.toString();
    }

    protected static String a(String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            Object obj4 = "";
        }
        Object U = U(obj);
        Object U2 = U(obj2);
        Object U3 = U(obj3);
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "";
        if (!TextUtils.isEmpty(obj4)) {
            stringBuilder.append(obj4);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(U)) {
            stringBuilder.append(str2);
            stringBuilder.append(U);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(U2)) {
            stringBuilder.append(str2);
            stringBuilder.append(U2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(U3)) {
            stringBuilder.append(str2);
            stringBuilder.append(U3);
        }
        return stringBuilder.toString();
    }

    protected static void hT() {
        if (f.aob) {
            throw new IllegalStateException("Call only supported on the client side");
        }
    }

    public static boolean hW() {
        return Log.isLoggable((String) aj.aie.get(), 2);
    }

    public final void C(String str) {
        a(2, str, null, null, null);
    }

    public final void D(String str) {
        a(3, str, null, null, null);
    }

    public final void E(String str) {
        a(4, str, null, null, null);
    }

    public final void F(String str) {
        a(5, str, null, null, null);
    }

    public final void G(String str) {
        a(6, str, null, null, null);
    }

    public void a(int i, String str, Object obj, Object obj2, Object obj3) {
        f fVar = null;
        if (this.afY != null) {
            fVar = this.afY.agH;
        }
        if (fVar != null) {
            fVar.a(i, str, obj, obj2, obj3);
            return;
        }
        String str2 = (String) aj.aie.get();
        if (Log.isLoggable(str2, i)) {
            Log.println(i, str2, a(str, obj, obj2, obj3));
        }
    }

    public final void a(String str, Object obj, Object obj2) {
        a(2, str, obj, obj2, null);
    }

    public final void b(String str, Object obj, Object obj2) {
        a(3, str, obj, obj2, null);
    }

    public final void c(String str, Object obj, Object obj2) {
        a(5, str, obj, obj2, null);
    }

    public final void d(String str, Object obj) {
        a(2, str, obj, null, null);
    }

    public final void d(String str, Object obj, Object obj2) {
        a(6, str, obj, obj2, null);
    }

    public final void e(String str, Object obj) {
        a(3, str, obj, null, null);
    }

    public final void f(String str, Object obj) {
        a(5, str, obj, null, null);
    }

    public final void g(String str, Object obj) {
        a(6, str, obj, null, null);
    }

    protected final ag hU() {
        q qVar = this.afY;
        q.a(qVar.agK);
        return qVar.agK;
    }

    protected final i hV() {
        q qVar = this.afY;
        q.a(qVar.agM);
        return qVar.agM;
    }
}
