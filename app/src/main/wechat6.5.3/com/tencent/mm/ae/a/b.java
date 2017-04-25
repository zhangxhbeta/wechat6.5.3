package com.tencent.mm.ae.a;

import android.graphics.Bitmap;
import com.tencent.mm.ae.a.c.h;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public final class b {
    public com.tencent.mm.ae.a.a.b cOM;
    h cON;
    Executor cOO;
    public final Map<Integer, String> cOP = Collections.synchronizedMap(new HashMap());
    public HashMap<Integer, com.tencent.mm.ae.a.f.b> cOQ = new HashMap();

    public b(com.tencent.mm.ae.a.a.b bVar) {
        this.cOM = bVar;
        this.cON = bVar.cPn;
        this.cOO = bVar.cPo;
        this.cOM.cPh.a(this.cOM.cPj);
    }

    public final Bitmap jh(String str) {
        if (this.cOM != null) {
            return this.cOM.cPg.gu(str);
        }
        return null;
    }

    public final void a(c cVar) {
        this.cOP.remove(Integer.valueOf(cVar.GS()));
        v.d("MicroMsg.imageloader.ImageLoaderManager", "[cpan] remove image weak holder size:%d viewcode:%s", Integer.valueOf(this.cOP.size()), Integer.valueOf(cVar.GS()));
    }
}
