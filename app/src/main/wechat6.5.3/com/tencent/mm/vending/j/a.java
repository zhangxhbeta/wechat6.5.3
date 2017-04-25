package com.tencent.mm.vending.j;

public class a {
    public Object[] pik;

    public final <T> T get(int i) {
        if (this.pik.length <= i) {
            return null;
        }
        return this.pik[i];
    }

    public final int size() {
        if (this.pik == null) {
            return 0;
        }
        return this.pik.length;
    }

    public static <$1> b<$1> bt($1 $1) {
        a bVar = new b();
        bVar.pik = new Object[]{$1};
        return (b) bVar;
    }

    public static <$1, $2> c<$1, $2> t($1 $1, $2 $2) {
        a cVar = new c();
        cVar.pik = new Object[]{$1, $2};
        return (c) cVar;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (Object obj2 : this.pik) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append(",");
            }
            stringBuilder.append(obj2);
        }
        return stringBuilder.toString();
    }
}
