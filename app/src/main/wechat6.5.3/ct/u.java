package ct;

import android.text.TextUtils;
import ct.t.a;
import java.util.Map;
import java.util.Set;

public final class u {
    private static u b;
    public v a = w.a();
    private t c;

    private u() {
        a(false);
    }

    public static synchronized u a() {
        u uVar;
        synchronized (u.class) {
            if (b == null) {
                b = new u();
            }
            uVar = b;
        }
        return uVar;
    }

    public final synchronized a a(String str) {
        a aVar;
        a(false);
        aVar = (this.c == null || !this.c.a.equals(bc.a())) ? null : (a) this.c.b.get(str);
        return aVar;
    }

    public final synchronized void a(t tVar) {
        bd.b();
        if (tVar == null) {
            bd.c();
        } else {
            this.c = tVar;
            this.a.a(tVar);
        }
    }

    public final synchronized void a(boolean z) {
        String a = bc.a();
        bd.a();
        if (TextUtils.isEmpty(a) || a.equals("unknown")) {
            bd.c();
        } else if (this.c == null || !this.c.a.equals(a) || z) {
            this.c = this.a.a(a);
            if (this.c != null) {
                bd.a();
            } else {
                bd.c();
            }
        } else {
            bd.b();
        }
    }

    public final synchronized boolean a(Set set) {
        boolean z;
        bd.b();
        a(false);
        if (this.c == null) {
            bd.b();
            z = true;
        } else {
            Map map = this.c.b;
            if (map == null) {
                bd.b();
                z = true;
            } else if (map.size() < set.size()) {
                new StringBuilder("DomainAccessInfo map not enough, need schedule...map.size:").append(map.size());
                bd.b();
                z = true;
            } else {
                for (String str : set) {
                    a aVar = (a) map.get(str);
                    if (aVar != null) {
                        if (aVar.b()) {
                        }
                    }
                    new StringBuilder("domainInfo for domain:").append(str).append(" is null or expired. need schedule...");
                    bd.b();
                    z = true;
                }
                z = false;
            }
        }
        return z;
    }
}
