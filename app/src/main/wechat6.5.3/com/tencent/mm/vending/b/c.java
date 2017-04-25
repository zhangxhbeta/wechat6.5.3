package com.tencent.mm.vending.b;

import com.tencent.mm.vending.h.d;
import com.tencent.mm.vending.j.a;
import java.util.Iterator;

public abstract class c<_Callback> extends a<_Callback> {
    public abstract void a(_Callback _Callback, a aVar);

    public c(d dVar) {
        super(dVar);
    }

    public final synchronized void bKG() {
        a(null);
    }

    public final synchronized void a(final a aVar) {
        Iterator it = bKF().iterator();
        while (it.hasNext()) {
            final b bVar = (b) it.next();
            if (bVar != null) {
                if (bVar.aQW != null) {
                    this.pgV.c(bVar.aQW);
                } else {
                    this.pgV.c(d.bKQ());
                }
                this.pgV.a(new com.tencent.mm.vending.c.a<Void, Void>(this) {
                    final /* synthetic */ c pha;

                    public final /* synthetic */ Object aq(Object obj) {
                        Void voidR = (Void) obj;
                        this.pha.a(bVar.pgX, aVar);
                        return voidR;
                    }
                }, com.tencent.mm.vending.c.a.phb, true);
            }
        }
    }

    public final b<_Callback> ay(_Callback _Callback) {
        return a(new b(_Callback, this));
    }
}
