package com.tencent.mm.sdk.c;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.vending.b.b;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class c<T extends b> {
    private b<c> nhA;
    public int nhz;
    final int priority;

    public abstract boolean a(T t);

    public c() {
        this(0);
    }

    public c(int i) {
        this.nhz = 0;
        this.priority = i;
    }

    final int bsK() {
        if (this.nhz == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            Type genericSuperclass = getClass().getGenericSuperclass();
            if (!(genericSuperclass instanceof ParameterizedType)) {
                genericSuperclass = getClass().getSuperclass().getGenericSuperclass();
            }
            this.nhz = ((Class) ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]).getName().hashCode();
            v.v("IListener", "genEventID, %s<%s>, useTime:%d", getClass().getName(), r1, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        return this.nhz;
    }

    public final synchronized b<c> bsL() {
        if (this.nhA == null) {
            this.nhA = a.nhr.d(this);
        }
        return this.nhA;
    }
}
