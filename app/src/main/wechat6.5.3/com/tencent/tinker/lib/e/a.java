package com.tencent.tinker.lib.e;

import android.util.Log;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class a {
    private static a pGi;
    private static a pGj;

    public interface a {
        void a(String str, Throwable th, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    static {
        a anonymousClass1 = new a() {
            public final void i(String str, String str2, Object... objArr) {
                if (objArr != null) {
                    String.format(str2, objArr);
                }
            }

            public final void w(String str, String str2, Object... objArr) {
                if (objArr != null) {
                    String.format(str2, objArr);
                }
            }

            public final void e(String str, String str2, Object... objArr) {
                if (objArr != null) {
                    String.format(str2, objArr);
                }
            }

            public final void a(String str, Throwable th, String str2, Object... objArr) {
                String format = objArr == null ? str2 : String.format(str2, objArr);
                if (format == null) {
                    format = SQLiteDatabase.KeyEmpty;
                }
                new StringBuilder().append(format).append("  ").append(Log.getStackTraceString(th));
            }
        };
        pGi = anonymousClass1;
        pGj = anonymousClass1;
    }

    public static void a(a aVar) {
        pGj = aVar;
    }

    public static void e(String str, String str2, Object... objArr) {
        if (pGj != null) {
            pGj.e(str, str2, objArr);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (pGj != null) {
            pGj.w(str, str2, objArr);
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        if (pGj != null) {
            pGj.i(str, str2, objArr);
        }
    }

    public static void a(String str, Throwable th, String str2, Object... objArr) {
        if (pGj != null) {
            pGj.a(str, th, str2, objArr);
        }
    }
}
