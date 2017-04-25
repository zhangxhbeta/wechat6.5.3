package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.List;

public final class v {

    public static final class a {
        private final List<String> apw;
        private final Object apx;

        private a(Object obj) {
            this.apx = w.Z(obj);
            this.apw = new ArrayList();
        }

        public final a h(String str, Object obj) {
            this.apw.add(((String) w.Z(str)) + "=" + String.valueOf(obj));
            return this;
        }

        public final String toString() {
            StringBuilder append = new StringBuilder(100).append(this.apx.getClass().getSimpleName()).append('{');
            int size = this.apw.size();
            for (int i = 0; i < size; i++) {
                append.append((String) this.apw.get(i));
                if (i < size - 1) {
                    append.append(", ");
                }
            }
            return append.append('}').toString();
        }
    }

    public static a Y(Object obj) {
        return new a(obj);
    }

    public static boolean d(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
