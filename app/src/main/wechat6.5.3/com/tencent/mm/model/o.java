package com.tencent.mm.model;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class o {
    private static o crI;
    private Map<String, c> crJ = new a();

    private static class a<K, V> extends ConcurrentHashMap<K, V> {
        private a() {
        }

        public final V get(Object obj) {
            return obj == null ? null : super.get(obj);
        }

        public final V put(K k, V v) {
            if (k == null) {
                return null;
            }
            if (v == null) {
                return super.remove(k);
            }
            return super.put(k, v);
        }

        public final V remove(Object obj) {
            return obj == null ? null : super.remove(obj);
        }

        public final boolean containsValue(Object obj) {
            return obj == null ? false : super.containsValue(obj);
        }
    }

    public static class b {
        private Map<String, Object> crK = new a();

        public final boolean containsKey(String str) {
            return this.crK.containsKey(str);
        }

        public final b l(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                this.crK.put(str, obj);
            }
            return this;
        }

        public final b o(String str, boolean z) {
            if (!TextUtils.isEmpty(str)) {
                this.crK.put(str, Boolean.valueOf(z));
            }
            return this;
        }

        public final b G(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                this.crK.put(str, str2);
            }
            return this;
        }

        public final boolean fA(String str) {
            if (!TextUtils.isEmpty(str)) {
                Object obj = this.crK.get(str);
                if (obj instanceof Boolean) {
                    return ((Boolean) obj).booleanValue();
                }
            }
            return false;
        }

        public final Object get(String str) {
            return this.crK.get(str);
        }

        public final int bf(String str) {
            if (!TextUtils.isEmpty(str)) {
                Object obj = this.crK.get(str);
                if (obj instanceof Integer) {
                    return ((Integer) obj).intValue();
                }
            }
            return 0;
        }

        public final boolean getBoolean(String str, boolean z) {
            if (TextUtils.isEmpty(str)) {
                return z;
            }
            Object obj = this.crK.get(str);
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            return z;
        }

        public final String getString(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return str2;
            }
            Object obj = this.crK.get(str);
            if (obj instanceof String) {
                return (String) obj;
            }
            return str2;
        }

        public final <T> T a(String str, Class<T> cls) {
            T t = get(str);
            if (t != null && cls.isInstance(t)) {
                return t;
            }
            return null;
        }

        public final void recycle() {
            this.crK.clear();
        }
    }

    private static final class c {
        b crL = new b();

        c() {
        }
    }

    public static o yx() {
        if (crI == null) {
            synchronized (o.class) {
                if (crI == null) {
                    crI = new o();
                }
            }
        }
        return crI;
    }

    private o() {
    }

    public final b fx(String str) {
        c cVar = (c) this.crJ.get(str);
        if (cVar != null) {
            return cVar.crL;
        }
        return null;
    }

    public final b n(String str, boolean z) {
        c cVar = (c) this.crJ.get(str);
        if (cVar == null) {
            if (!z) {
                return null;
            }
            cVar = new c();
            this.crJ.put(str, cVar);
        }
        return cVar.crL;
    }

    public final b fy(String str) {
        c cVar = (c) this.crJ.remove(str);
        if (cVar != null) {
            return cVar.crL;
        }
        return null;
    }

    public static String fz(String str) {
        return "SessionId@" + str + "#" + System.currentTimeMillis();
    }
}
