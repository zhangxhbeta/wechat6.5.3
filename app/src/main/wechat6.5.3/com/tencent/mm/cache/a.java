package com.tencent.mm.cache;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Map;

public interface a {

    public static class a {
        private static Map<String, a> caB = new HashMap();

        public static void a(String str, a aVar) {
            caB.put(str, aVar);
        }

        private static a do(String str) {
            return (a) caB.get(str);
        }

        public static <T> T x(String str, String str2) {
            return a(do(str), str2, null);
        }

        public static <T> void a(String str, String str2, T t) {
            a aVar = do(str);
            if (aVar == null) {
                v.e("MicroMsg.ICacheService.Factory", "null service");
            } else {
                aVar.m(str2, t);
            }
        }

        public static <T> void y(String str, String str2) {
            a(do(str), str2);
        }

        private static <T> T a(a aVar, String str, T t) {
            T t2 = null;
            if (aVar == null) {
                v.e("MicroMsg.ICacheService.Factory", "null service");
            } else {
                try {
                    t2 = aVar.get(str);
                } catch (Throwable e) {
                    v.e("MicroMsg.ICacheService.Factory", "cast failed, different type ?");
                    v.e("MicroMsg.ICacheService.Factory", "exception:%s", be.e(e));
                }
            }
            return t2;
        }

        private static <T> T a(a aVar, String str) {
            T t = null;
            if (aVar == null) {
                v.e("MicroMsg.ICacheService.Factory", "null service");
            } else {
                try {
                    t = aVar.remove(str);
                } catch (Throwable e) {
                    v.e("MicroMsg.ICacheService.Factory", "cast failed, different type ?");
                    v.e("MicroMsg.ICacheService.Factory", "exception:%s", be.e(e));
                }
            }
            return t;
        }
    }

    Object get(Object obj);

    void m(Object obj, Object obj2);

    Object remove(Object obj);
}
