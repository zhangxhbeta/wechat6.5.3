package com.tencent.mm.av;

import com.tencent.mm.vending.b.b;
import com.tencent.mm.vending.h.d;
import java.util.Iterator;

public class a<_Callback> extends com.tencent.mm.vending.b.a<_Callback> {

    public interface a<_Callback> {
        void an(_Callback _Callback);
    }

    public a() {
        super(new c());
    }

    public a(d dVar) {
        super(dVar);
    }

    public final void a(final a<_Callback> aVar) {
        if (aVar != null) {
            Iterator it = bKF().iterator();
            while (it.hasNext()) {
                final b bVar = (b) it.next();
                if (bVar != null) {
                    if (bVar.aQW != null) {
                        this.pgV.c(bVar.aQW);
                        this.pgV.a(new com.tencent.mm.vending.c.a<Void, Void>(this) {
                            final /* synthetic */ a doK;

                            public final /* synthetic */ Object aq(Object obj) {
                                Void voidR = (Void) obj;
                                aVar.an(bVar.pgX);
                                return voidR;
                            }
                        }, com.tencent.mm.vending.c.a.phb, true);
                    } else {
                        aVar.an(bVar.pgX);
                    }
                }
            }
        }
    }

    public final b<_Callback> ay(_Callback _Callback) {
        return super.a(new b(_Callback, this));
    }

    public final void remove(_Callback _Callback) {
        super.b(new b(_Callback, this));
    }
}
