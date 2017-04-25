package com.tencent.mm.svg.c;

public final class c {
    private static a nyO = null;

    public interface a {
        void a(String str, Throwable th, String str2, Object... objArr);

        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);
    }

    public static void b(a aVar) {
        nyO = aVar;
    }

    public static void e(String str, String str2, Object... objArr) {
        if (nyO != null) {
            nyO.e(str, str2, objArr);
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        if (nyO != null) {
            nyO.i(str, str2, objArr);
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        if (nyO != null) {
            nyO.d(str, str2, objArr);
        }
    }

    public static void a(String str, Throwable th, String str2, Object... objArr) {
        if (nyO != null) {
            nyO.a(str, th, str2, objArr);
        }
    }
}
