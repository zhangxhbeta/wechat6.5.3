package com.tencent.mmdb.support;

public class Log {
    public static final int LOGGER_DEFAULT = 1;
    public static final int LOGGER_NONE = 0;
    private static LogCallback mCallback = null;

    public interface LogCallback {
        void println(int i, String str, String str2);
    }

    private static native void nativePrintLn(int i, String str, String str2);

    private static native void nativeSetLogger(int i, LogCallback logCallback);

    public static void setLogger(int i) {
        mCallback = null;
        nativeSetLogger(i, null);
    }

    public static void setLogger(LogCallback logCallback) {
        mCallback = logCallback;
        nativeSetLogger(-1, logCallback);
    }

    public static void println(int i, String str, String str2) {
        if (mCallback != null) {
            mCallback.println(i, str, str2);
        } else {
            nativePrintLn(i, str, str2);
        }
    }

    public static void f(String str, String str2) {
        println(7, str, str2);
    }

    public static void e(String str, String str2) {
        println(6, str, str2);
    }

    public static void w(String str, String str2) {
        println(5, str, str2);
    }

    public static void i(String str, String str2) {
        println(4, str, str2);
    }

    public static void d(String str, String str2) {
        println(3, str, str2);
    }

    public static void v(String str, String str2) {
        println(2, str, str2);
    }

    public static void f(String str, String str2, Object... objArr) {
        println(7, str, String.format(str2, objArr));
    }

    public static void e(String str, String str2, Object... objArr) {
        println(6, str, String.format(str2, objArr));
    }

    public static void w(String str, String str2, Object... objArr) {
        println(5, str, String.format(str2, objArr));
    }

    public static void i(String str, String str2, Object... objArr) {
        println(4, str, String.format(str2, objArr));
    }

    public static void d(String str, String str2, Object... objArr) {
        println(3, str, String.format(str2, objArr));
    }

    public static void v(String str, String str2, Object... objArr) {
        println(2, str, String.format(str2, objArr));
    }
}
