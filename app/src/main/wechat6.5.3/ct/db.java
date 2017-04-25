package ct;

import java.lang.reflect.Method;

public final class db {
    public final Class<?> a;
    public final Method b;
    public final Object c;

    public db(Class<?> cls, Method method, Object obj) {
        this.a = cls;
        this.b = method;
        this.c = obj;
    }
}
