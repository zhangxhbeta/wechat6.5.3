package com.tencent.mm.ae.a.a;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mm.ae.a.b.c;
import com.tencent.mm.ae.a.b.d;
import com.tencent.mm.ae.a.c.e;
import com.tencent.mm.ae.a.c.f;
import com.tencent.mm.ae.a.c.h;
import com.tencent.mm.ae.a.c.j;
import com.tencent.mm.ae.a.c.k;
import com.tencent.mm.ae.a.c.l;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class b {
    public static final int cPb = Runtime.getRuntime().availableProcessors();
    public final Resources cPc;
    public final int cPd;
    public final int cPe;
    public final c cPf;
    public final l cPg;
    public final com.tencent.mm.ae.a.c.a cPh;
    public final com.tencent.mm.ae.a.c.b cPi;
    public final f cPj;
    public final j cPk;
    public final k cPl;
    public final e cPm;
    public final h cPn;
    public final Executor cPo;
    public final String packageName;

    public static class a {
        int cPd = b.cPb;
        int cPe = 5;
        c cPf = null;
        public l cPg = null;
        com.tencent.mm.ae.a.c.a cPh = null;
        public com.tencent.mm.ae.a.c.b cPi = null;
        f cPj = null;
        j cPk = null;
        e cPm = null;
        h cPn = null;
        Executor cPo;
        k cPp = null;
        Context context;

        public a(Context context) {
            this.context = context.getApplicationContext();
        }

        public final b GT() {
            if (this.cPf == null) {
                this.cPf = new com.tencent.mm.ae.a.a.c.a().GU();
            }
            if (this.cPg == null) {
                this.cPg = new com.tencent.mm.ae.a.b.f();
            }
            if (this.cPh == null) {
                this.cPh = new com.tencent.mm.ae.a.b.a();
            }
            if (this.cPi == null) {
                this.cPi = new com.tencent.mm.ae.a.b.b();
            }
            if (this.cPj == null) {
                this.cPj = new d();
            }
            if (this.cPk == null) {
                this.cPk = new com.tencent.mm.ae.a.b.h();
            }
            if (this.cPn == null) {
                this.cPn = a.aH(this.cPd, this.cPe);
            }
            if (this.cPo == null) {
                this.cPo = Executors.newSingleThreadExecutor();
            }
            if (this.cPp == null) {
                this.cPp = new com.tencent.mm.ae.a.b.e();
            }
            if (this.cPm == null) {
                this.cPm = new c();
            }
            return new b(this);
        }
    }

    public b(a aVar) {
        this.packageName = aVar.context.getPackageName();
        this.cPc = aVar.context.getResources();
        this.cPd = aVar.cPd;
        this.cPe = aVar.cPe;
        this.cPf = aVar.cPf;
        this.cPg = aVar.cPg;
        this.cPh = aVar.cPh;
        this.cPi = aVar.cPi;
        this.cPj = aVar.cPj;
        this.cPk = aVar.cPk;
        this.cPn = aVar.cPn;
        this.cPo = aVar.cPo;
        this.cPl = aVar.cPp;
        this.cPm = aVar.cPm;
    }

    public static b aR(Context context) {
        return new a(context).GT();
    }
}
