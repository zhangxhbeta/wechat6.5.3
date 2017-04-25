package b.a.c;

import b.a.d.e;
import b.a.g.d;
import java.util.Collections;

public final class c implements b {
    public final String a(b.a.d.c cVar) {
        d.c(cVar, "Cannot extract base string from null object");
        if (cVar.pOZ == null || cVar.pOZ.size() <= 0) {
            throw new b.a.b.c(cVar);
        }
        String encode = b.a.g.c.encode(cVar.bRl().name());
        String encode2 = b.a.g.c.encode(cVar.bRq());
        e eVar = new e();
        eVar.a(cVar.bRk());
        eVar.a(cVar.bRp());
        eVar.a(new e(cVar.pOZ));
        e eVar2 = new e(eVar.pPa);
        Collections.sort(eVar2.pPa);
        String encode3 = b.a.g.c.encode(eVar2.bRr());
        return String.format("%s&%s&%s", new Object[]{encode, encode2, encode3});
    }
}
