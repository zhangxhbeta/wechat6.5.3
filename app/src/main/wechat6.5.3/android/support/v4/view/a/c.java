package android.support.v4.view.a;

import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.List;

public final class c {
    private static final a zr;
    public final Object zt;

    interface a {
        Object a(c cVar);
    }

    static class d implements a {
        d() {
        }

        public Object a(c cVar) {
            return null;
        }
    }

    static class b extends d {
        b() {
        }

        public final Object a(final c cVar) {
            return new android.support.v4.view.a.d.AnonymousClass1(new a(this) {
                final /* synthetic */ b zv;

                public final boolean cg() {
                    return c.cg();
                }

                public final List<Object> ch() {
                    List list = null;
                    c.ch();
                    List<Object> arrayList = new ArrayList();
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        arrayList.add(((b) list.get(i)).yT);
                    }
                    return arrayList;
                }

                public final Object cj() {
                    c.cf();
                    return null;
                }
            });
        }
    }

    static class c extends d {
        c() {
        }

        public final Object a(final c cVar) {
            return new android.support.v4.view.a.e.AnonymousClass1(new a(this) {
                final /* synthetic */ c zw;

                public final boolean cg() {
                    return c.cg();
                }

                public final List<Object> ch() {
                    List list = null;
                    c.ch();
                    List<Object> arrayList = new ArrayList();
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        arrayList.add(((b) list.get(i)).yT);
                    }
                    return arrayList;
                }

                public final Object cj() {
                    c.cf();
                    return null;
                }

                public final Object ck() {
                    c.ci();
                    return null;
                }
            });
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            zr = new c();
        } else if (VERSION.SDK_INT >= 16) {
            zr = new b();
        } else {
            zr = new d();
        }
    }

    public c() {
        this.zt = zr.a(this);
    }

    public c(Object obj) {
        this.zt = obj;
    }

    public static b cf() {
        return null;
    }

    public static boolean cg() {
        return false;
    }

    public static List<b> ch() {
        return null;
    }

    public static b ci() {
        return null;
    }
}
