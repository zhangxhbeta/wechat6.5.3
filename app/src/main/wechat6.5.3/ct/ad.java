package ct;

import ct.t.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class ad {
    private static String d = "bott";
    public s a;
    public String b;
    public List c = new ArrayList();

    public ad(z zVar) {
        if (zVar.o == 0 || !zVar.b) {
            this.c.add(a(zVar));
        } else if (bc.d) {
            this.c.add(a(zVar));
        } else {
            a a = h.a();
            if (a != null) {
                a a2 = a.a(zVar.c);
                if (a2 != null) {
                    this.a = a2.d;
                    Collection collection = a2.c;
                    this.b = a2.b;
                    if (collection != null && collection.size() > zVar.o) {
                        collection = collection.subList(0, zVar.o);
                    }
                    boolean a3 = a(collection, this.a);
                    if (this.b == null || this.b.contains(d)) {
                        if (!(this.a == null || a3)) {
                            this.c.add(this.a);
                        }
                        this.c.add(a(zVar));
                        this.c.addAll(collection);
                        return;
                    }
                    this.c.addAll(collection);
                    if (!(this.a == null || a3)) {
                        this.c.add(this.a);
                    }
                    this.c.add(a(zVar));
                    return;
                }
                this.c.add(a(zVar));
                return;
            }
            this.c.add(a(zVar));
        }
    }

    private static s a(z zVar) {
        return zVar.e != null ? new s(zVar.c, zVar.e[0]) : new s(zVar.c, -1);
    }

    private static boolean a(List list, s sVar) {
        for (s a : list) {
            if (a.a(sVar)) {
                return true;
            }
        }
        return false;
    }
}
