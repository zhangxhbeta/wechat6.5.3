package com.tencent.mm.vending.g;

import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.b;
import com.tencent.mm.vending.j.c;
import com.tencent.mm.vending.j.d;
import com.tencent.mm.vending.j.e;

public final class g {
    private static final a phV = new a();

    public static final c<Void> bKO() {
        return new e().g(new Object[0]);
    }

    public static final <Var1> c<Var1> br(Var1 var1) {
        return new e().g(var1);
    }

    public static final <Var1, Var2> c<c<Var1, Var2>> s(Var1 var1, Var2 var2) {
        return new e().g(var1, var2);
    }

    public static final <Var1, Var2, Var3> c<d<Var1, Var2, Var3>> a(Var1 var1, Var2 var2, Var3 var3) {
        return new e().g(var1, var2, var3);
    }

    public static final <Var1, Var2, Var3, Var4> c<e<Var1, Var2, Var3, Var4>> a(Var1 var1, Var2 var2, Var3 var3, Var4 var4) {
        return new e().g(var1, var2, var3, var4);
    }

    public static <$1> b<$1> bs($1 $1) {
        b bVar = new b();
        return a.bt($1);
    }

    public static final b bKJ() {
        c cVar = (c) f.bKN().phU.get();
        return cVar != null ? cVar.bKJ() : phV;
    }

    public static final b bKP() {
        b bKJ = bKJ();
        if (bKJ != null) {
            bKJ.bKI();
        } else {
            com.tencent.mm.vending.f.a.w("Vending.QuickAccess", "dummy mario", new Object[0]);
        }
        return bKJ;
    }

    public static final void a(b bVar, Object... objArr) {
        if (bVar == null) {
            com.tencent.mm.vending.f.a.w("Vending.QuickAccess", "dummy mario", new Object[0]);
        } else if (objArr.length > 0) {
            bVar.r(objArr);
        } else {
            bVar.resume();
        }
    }

    public static final <_Var> void a(d<_Var> dVar) {
        final b bKP = bKP();
        dVar.a(new d.b<_Var>() {
            public final void ap(_Var _Var) {
                g.a(bKP, _Var);
            }
        }).a(new d.a() {
            public final void aA(Object obj) {
                bKP.bo(obj);
            }
        });
    }
}
