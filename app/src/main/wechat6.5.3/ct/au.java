package ct;

import java.io.Serializable;
import java.util.Map;

public final class au implements Serializable {
    private long a;
    private String b;
    private Map c;
    private String d;
    private String e;
    private boolean f = true;

    public static long b() {
        return 0;
    }

    public static long c() {
        return 0;
    }

    public final void a(long j) {
        this.a = j;
    }

    public final void a(String str) {
        this.e = str;
    }

    public final synchronized void a(Map map) {
        this.c = map;
    }

    public final boolean a() {
        return this.f;
    }

    public final void b(String str) {
        this.d = str;
    }

    public final synchronized void c(String str) {
        this.b = str;
    }

    public final String d() {
        return this.e;
    }

    public final String e() {
        return this.d;
    }

    public final long f() {
        return this.a;
    }

    public final synchronized String g() {
        return this.b;
    }

    public final synchronized Map h() {
        return this.c;
    }
}
