package com.tencent.mm.plugin.appbrand.l;

import com.tencent.mm.plugin.appbrand.l.d.d;
import com.tencent.mm.plugin.appbrand.l.d.d.a;
import com.tencent.mm.plugin.appbrand.l.e.e;
import com.tencent.mm.plugin.appbrand.l.e.i;
import java.net.InetSocketAddress;

public abstract class b implements d {
    public final i Sr() {
        return new e();
    }

    public void d(d dVar) {
    }

    public final void a(a aVar, d dVar) {
        d eVar = new com.tencent.mm.plugin.appbrand.l.d.e(dVar);
        eVar.a(a.PONG);
        aVar.a(eVar);
    }

    public final String a(a aVar) {
        InetSocketAddress Sq = aVar.Sq();
        if (Sq == null) {
            throw new com.tencent.mm.plugin.appbrand.l.c.d("socket not bound");
        }
        StringBuffer stringBuffer = new StringBuffer(90);
        stringBuffer.append("<cross-domain-policy><allow-access-from domain=\"*\" to-ports=\"");
        stringBuffer.append(Sq.getPort());
        stringBuffer.append("\" /></cross-domain-policy>\u0000");
        return stringBuffer.toString();
    }
}
