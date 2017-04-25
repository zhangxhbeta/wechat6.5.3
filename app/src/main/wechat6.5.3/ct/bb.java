package ct;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public final class bb implements aw {
    private static AtomicInteger k = new AtomicInteger(0);
    public bi a;
    public int b = 0;
    public String c;
    public int d;
    public int e;
    public int f;
    public int g;
    public s h;
    public long i;
    public int j;
    private bi l;
    private byte[] m;
    private int n = 0;

    public bb(bi biVar) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = null;
        this.i = 0;
        this.j = 20;
        this.l = biVar;
        this.n = k.getAndIncrement();
        this.l.a(this.n);
    }

    public final bi a() {
        return this.a;
    }

    public final void b() {
        ba.a().a(this);
    }

    public final int c() {
        return this.b;
    }

    public final String d() {
        return this.c;
    }

    public final s e() {
        return this.h;
    }

    public final int f() {
        return this.d;
    }

    public final int g() {
        return this.g;
    }

    public final int h() {
        return this.e;
    }

    public final int i() {
        return this.f;
    }

    public final void j() {
        this.m = this.l.a();
    }

    public final int k() {
        return this.n;
    }

    public final byte[] l() {
        return this.m;
    }
}
