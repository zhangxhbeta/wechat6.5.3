package com.tencent.mm.plugin.luckymoney.b;

import android.app.Activity;
import com.tencent.mm.sdk.c.c;

public abstract class a extends c<com.tencent.mm.n.a.a.a> {
    private int fqZ;
    protected Activity gZX;

    public abstract boolean a(b bVar);

    public a() {
        super(0);
        this.fqZ = d.haa.hab.getAndIncrement();
        this.nhz = com.tencent.mm.n.a.a.a.class.getName().hashCode();
    }

    public void x(Activity activity) {
        c cVar = c.gZZ;
        c.a(this);
        this.gZX = activity;
        d.haa.hac.put(Integer.valueOf(this.fqZ), this);
    }

    public void axD() {
        c cVar = c.gZZ;
        c.b((c) this);
        d.haa.hac.remove(Integer.valueOf(this.fqZ));
    }

    public static void vX(String str) {
        e.had.a(str, false, null);
    }

    public static void ca(String str, String str2) {
        e.had.a(str, true, str2);
    }
}
