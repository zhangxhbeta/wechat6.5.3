package com.tencent.mm.pluginsdk.d;

import com.tencent.mm.e.a.il;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.HashMap;
import java.util.Map.Entry;

public abstract class c<T extends b> extends com.tencent.mm.sdk.c.c<T> implements e {
    private static HashMap<b, c<? extends b>> cJv = new HashMap();
    private static HashMap<k, b> lyJ = new HashMap();
    private int lyI = 0;

    public abstract b a(int i, k kVar, T t);

    public abstract int acY();

    public abstract k b(T t);

    public final void a(int i, int i2, String str, k kVar) {
        if (acY() == kVar.getType()) {
            b bVar = (b) lyJ.remove(kVar);
            if (bVar != null) {
                il ilVar = new il();
                ilVar.biR.biT = a(i2, kVar, bVar);
                ilVar.biR.errType = i;
                ilVar.biR.errCode = i2;
                ilVar.biR.biS = str;
                a.nhr.z(ilVar);
            }
        }
    }

    public static void x(b bVar) {
        k kVar;
        for (Entry entry : lyJ.entrySet()) {
            if (entry.getValue() == bVar) {
                kVar = (k) entry.getKey();
                break;
            }
        }
        kVar = null;
        if (kVar != null) {
            ak.vy().c(kVar);
            lyJ.remove(kVar);
        }
    }

    public final void bmG() {
        if (this.lyI == 0) {
            ak.vy().a(acY(), this);
        }
        this.lyI++;
    }

    public final void avH() {
        if (this.lyI != 0) {
            this.lyI--;
            if (this.lyI == 0) {
                ak.vy().b(acY(), this);
            }
        }
    }

    public final void y(T t) {
        k b = b(t);
        ak.vy().a(b, 0);
        lyJ.put(b, t);
    }
}
