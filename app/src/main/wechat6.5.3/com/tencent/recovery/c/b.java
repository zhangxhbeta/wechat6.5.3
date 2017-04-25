package com.tencent.recovery.c;

import java.util.ArrayList;

public final class b {
    private static a puj = new a();

    public interface a {
        void a(String str, Throwable th, String str2, Object... objArr);

        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void v(String str, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    public static void i(String str, String str2, Object... objArr) {
        if (puj != null) {
            puj.i(str, str2, objArr);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (puj != null) {
            puj.w(str, str2, objArr);
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        if (puj != null) {
            puj.e(str, str2, objArr);
        }
    }

    public static void a(String str, Throwable th, String str2, Object... objArr) {
        if (puj != null) {
            puj.a(str, th, str2, objArr);
        }
    }

    public static void a(a aVar) {
        if (puj instanceof a) {
            a aVar2 = (a) puj;
            int size = aVar2.pue.size();
            for (int i = 0; i < size; i++) {
                a aVar3 = (a) aVar2.pue.get(i);
                switch (aVar3.level) {
                    case 1:
                        aVar.v(aVar3.tag, aVar3.puf, aVar3.pug);
                        break;
                    case 2:
                        aVar.d(aVar3.tag, aVar3.puf, aVar3.pug);
                        break;
                    case 3:
                        aVar.i(aVar3.tag, aVar3.puf, aVar3.pug);
                        break;
                    case 4:
                        aVar.w(aVar3.tag, aVar3.puf, aVar3.pug);
                        break;
                    case 5:
                        if (aVar3.puh == null) {
                            aVar.e(aVar3.tag, aVar3.puf, aVar3.pug);
                            break;
                        } else {
                            aVar.a(aVar3.tag, aVar3.puh, aVar3.puf, aVar3.pug);
                            break;
                        }
                    default:
                        break;
                }
            }
            aVar2.pue = new ArrayList();
        }
        puj = aVar;
    }
}
