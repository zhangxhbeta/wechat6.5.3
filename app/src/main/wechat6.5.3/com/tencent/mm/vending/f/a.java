package com.tencent.mm.vending.f;

public final class a {
    private static a phg = null;

    public interface a {
        void a(String str, Throwable th, String str2, Object... objArr);

        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    public static void a(a aVar) {
        phg = aVar;
    }

    public static void e(String str, String str2, Object... objArr) {
        if (phg != null) {
            phg.e(str, str2, objArr);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (phg != null) {
            phg.w(str, str2, objArr);
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        if (phg != null) {
            phg.i(str, str2, objArr);
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        if (phg != null) {
            phg.d(str, str2, objArr);
        }
    }

    public static void a(String str, Throwable th, String str2, Object... objArr) {
        if (phg != null) {
            phg.a(str, th, str2, objArr);
        }
    }
}
