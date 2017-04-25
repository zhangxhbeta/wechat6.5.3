package com.tencent.mm.sdk.platformtools;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class v {
    private static final String kzT;
    private static int level = 6;
    private static a nil;
    private static a nim;

    public interface a {
        void appenderClose();

        void appenderFlush(boolean z);

        int getLogLevel();

        void logD(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);

        void logE(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);

        void logF(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);

        void logI(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);

        void logV(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);

        void logW(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);
    }

    static {
        a anonymousClass1 = new a() {
            private Handler handler = new Handler(Looper.getMainLooper());

            public final void logV(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
                v.level;
            }

            public final void logI(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
                v.level;
            }

            public final void logD(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
                v.level;
            }

            public final void logW(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
                v.level;
            }

            public final void logE(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
                v.level;
            }

            public final void logF(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
                if (v.level <= 5) {
                }
            }

            public final int getLogLevel() {
                return v.level;
            }

            public final void appenderClose() {
            }

            public final void appenderFlush(boolean z) {
            }
        };
        nil = anonymousClass1;
        nim = anonymousClass1;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("VERSION.RELEASE:[" + VERSION.RELEASE);
            stringBuilder.append("] VERSION.CODENAME:[" + VERSION.CODENAME);
            stringBuilder.append("] VERSION.INCREMENTAL:[" + VERSION.INCREMENTAL);
            stringBuilder.append("] BOARD:[" + Build.BOARD);
            stringBuilder.append("] DEVICE:[" + Build.DEVICE);
            stringBuilder.append("] DISPLAY:[" + Build.DISPLAY);
            stringBuilder.append("] FINGERPRINT:[" + Build.FINGERPRINT);
            stringBuilder.append("] HOST:[" + Build.HOST);
            stringBuilder.append("] MANUFACTURER:[" + Build.MANUFACTURER);
            stringBuilder.append("] MODEL:[" + Build.MODEL);
            stringBuilder.append("] PRODUCT:[" + Build.PRODUCT);
            stringBuilder.append("] TAGS:[" + Build.TAGS);
            stringBuilder.append("] TYPE:[" + Build.TYPE);
            stringBuilder.append("] USER:[" + Build.USER + "]");
        } catch (Throwable th) {
            a("MicroMsg.SDK.Log", th, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
        kzT = stringBuilder.toString();
    }

    public static void a(a aVar) {
        nim = aVar;
    }

    public static a bsZ() {
        return nim;
    }

    public static void appenderClose() {
        if (nim != null) {
            nim.appenderClose();
        }
    }

    public static void bta() {
        if (nim != null) {
            nim.appenderFlush(false);
        }
    }

    public static void btb() {
        if (nim != null) {
            nim.appenderFlush(true);
        }
    }

    public static int getLogLevel() {
        if (nim != null) {
            return nim.getLogLevel();
        }
        return 6;
    }

    public static void uZ(int i) {
        level = i;
    }

    public static void f(String str, String str2) {
        f(str, str2, null);
    }

    public static void e(String str, String str2) {
        e(str, str2, null);
    }

    public static void w(String str, String str2) {
        w(str, str2, null);
    }

    public static void i(String str, String str2) {
        i(str, str2, null);
    }

    public static void d(String str, String str2) {
        d(str, str2, null);
    }

    public static void v(String str, String str2) {
        v(str, str2, null);
    }

    public static void f(String str, String str2, Object... objArr) {
        if (nim != null && nim.getLogLevel() <= 5) {
            nim.logF(str, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), objArr == null ? str2 : String.format(str2, objArr));
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        if (nim != null && nim.getLogLevel() <= 4) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = SQLiteDatabase.KeyEmpty;
            }
            nim.logE(str, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (nim != null && nim.getLogLevel() <= 3) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = SQLiteDatabase.KeyEmpty;
            }
            nim.logW(str, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        if (nim != null && nim.getLogLevel() <= 2) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = SQLiteDatabase.KeyEmpty;
            }
            nim.logI(str, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        if (nim != null && nim.getLogLevel() <= 1) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = SQLiteDatabase.KeyEmpty;
            }
            nim.logD(str, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
    }

    public static void v(String str, String str2, Object... objArr) {
        if (nim != null && nim.getLogLevel() <= 0) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = SQLiteDatabase.KeyEmpty;
            }
            nim.logV(str, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
    }

    public static void h(String str, String str2, Object... objArr) {
        if (nim != null && nim.getLogLevel() <= 1) {
            String format = String.format(str2, objArr);
            if (format == null) {
                format = SQLiteDatabase.KeyEmpty;
            }
            String str3 = format + "  " + new af();
            nim.logI(str, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str3);
        }
    }

    public static void j(String str, String str2, Object... objArr) {
        if (nim != null && nim.getLogLevel() <= 2) {
            String format = String.format(str2, objArr);
            if (format == null) {
                format = SQLiteDatabase.KeyEmpty;
            }
            String str3 = format + "  " + new af();
            nim.logI(str, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str3);
        }
    }

    public static void a(String str, Throwable th, String str2, Object... objArr) {
        if (nim != null && nim.getLogLevel() <= 4) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = SQLiteDatabase.KeyEmpty;
            }
            nim.logE(str, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format + "  " + Log.getStackTraceString(th));
        }
    }

    public static String btc() {
        return kzT;
    }
}
