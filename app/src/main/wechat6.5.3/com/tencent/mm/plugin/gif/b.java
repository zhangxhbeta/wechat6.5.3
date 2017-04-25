package com.tencent.mm.plugin.gif;

import com.tencent.mm.a.f;
import com.tencent.mm.ac.a;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;

public class b {
    private static b gCO;
    public f<String, WeakReference<c>> gCP = new f(10);
    f<String, WeakReference<a>> gCQ = new f(10, new com.tencent.mm.a.f.b<String, WeakReference<a>>(this) {
        final /* synthetic */ b gCR;

        {
            this.gCR = r1;
        }

        public final /* synthetic */ void l(Object obj, Object obj2) {
            WeakReference weakReference = (WeakReference) obj2;
            if (weakReference != null) {
                a aVar = (a) weakReference.get();
                if (aVar != null) {
                    v.i("MicroMsg.GIF.MMGIFDrawableCacheMgr", "recycle bitmap:%s", aVar.toString());
                    aVar.recycle();
                }
            }
        }
    });

    public static synchronized b atw() {
        b bVar;
        synchronized (b.class) {
            if (gCO == null) {
                synchronized (b.class) {
                    if (gCO == null) {
                        gCO = new b();
                    }
                }
            }
            bVar = gCO;
        }
        return bVar;
    }

    public final a ux(String str) {
        if (this.gCQ.get(str) != null) {
            return (a) ((WeakReference) this.gCQ.get(str)).get();
        }
        return null;
    }

    public final a bL(String str, String str2) {
        a aVar = null;
        if (this.gCQ.get(str) != null) {
            aVar = (a) ((WeakReference) this.gCQ.get(str)).get();
        }
        if (aVar != null) {
            return aVar;
        }
        long currentTimeMillis = System.currentTimeMillis();
        aVar = new a(str2);
        v.d("MicroMsg.GIF.MMGIFDrawableCacheMgr", "new MMGIFDrawable use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        this.gCQ.put(str, new WeakReference(aVar));
        return aVar;
    }

    public final a o(String str, byte[] bArr) {
        a aVar = null;
        if (bArr != null) {
            if (this.gCQ.get(str) != null) {
                aVar = (a) ((WeakReference) this.gCQ.get(str)).get();
            }
            if (aVar == null) {
                aVar = new a(bArr);
                this.gCQ.put(str, new WeakReference(aVar));
            }
            if (!aVar.isRunning()) {
                aVar.gCn = false;
                aVar.gCm = true;
                a.a(aVar.gCK, 300);
            }
        }
        return aVar;
    }
}
