package com.tencent.mm.plugin.readerapp.b;

import com.tencent.mm.bg.g.c;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bd;
import com.tencent.mm.o.h;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.v.d;
import java.io.File;
import java.util.HashMap;
import java.util.List;

public final class g implements ag {
    private static HashMap<Integer, c> bXq;
    private bd ild;
    private c ile = new c();
    private a ilf = new a();
    private d ilg = new d();
    private f ilh = new f();

    public interface a {
        void aJd();
    }

    private static g aJf() {
        g gVar = (g) ak.yP().fY("plugin.readerapp");
        if (gVar != null) {
            return gVar;
        }
        gVar = new g();
        ak.yP().a("plugin.readerapp", gVar);
        return gVar;
    }

    public static bd aJg() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new b();
        }
        if (aJf().ild == null) {
            g aJf = aJf();
            ak.yW();
            aJf.ild = new bd(com.tencent.mm.model.c.wE());
        }
        return aJf().ild;
    }

    public final void th() {
        d.c.aw(Integer.valueOf(12399999));
        com.tencent.mm.sdk.c.a.nhr.f(this.ilf);
        com.tencent.mm.sdk.c.a.nhr.f(this.ilg);
        com.tencent.mm.sdk.c.a.nhr.f(this.ilh);
        h.a(e.ilc);
    }

    static {
        HashMap hashMap = new HashMap();
        bXq = hashMap;
        hashMap.put(Integer.valueOf("READERAPPINFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return bd.cic;
            }
        });
    }

    public final HashMap<Integer, c> ti() {
        return bXq;
    }

    public final void ed(int i) {
        if ((524288 & i) != 0) {
            a(null);
        }
        if ((262144 & i) != 0) {
            b(null);
        }
    }

    public static void a(a aVar) {
        aJg().eR(20);
        ak.yW();
        com.tencent.mm.model.c.wK().Mf("newsapp");
        a(20, aVar);
    }

    public static void b(a aVar) {
        aJg().eR(11);
        ak.yW();
        com.tencent.mm.model.c.wK().Mf("blogapp");
        a(11, aVar);
    }

    public static void cr(long j) {
        e(aJg().b(j, 20), 20);
    }

    public static void r(long j, int i) {
        e(aJg().c(j, i), i);
    }

    private static void e(List<bc> list, int i) {
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (i2 == 0) {
                    be.deleteFile(r.o(((bc) list.get(i2)).zK(), i, "@T"));
                } else {
                    be.deleteFile(r.o(((bc) list.get(i2)).zK(), i, "@S"));
                }
            }
        }
    }

    private static void c(final a aVar) {
        ad.o(new Runnable() {
            public final void run() {
                if (aVar != null) {
                    aVar.aJd();
                }
            }
        });
    }

    private static void a(final int i, final a aVar) {
        if (ak.uz()) {
            ak.vA().x(new Runnable() {
                public final void run() {
                    int i = 0;
                    ak.yW();
                    File file = new File(com.tencent.mm.model.c.wP());
                    if (file.exists() && file.isDirectory()) {
                        File[] listFiles = file.listFiles();
                        if (listFiles == null || listFiles.length <= 0) {
                            g.c(aVar);
                            return;
                        }
                        String format = String.format("reader_%d_", new Object[]{Integer.valueOf(i)});
                        String format2 = String.format("ReaderApp_%d", new Object[]{Integer.valueOf(i)});
                        while (i < listFiles.length) {
                            if (listFiles[i].getName().startsWith(format)) {
                                listFiles[i].delete();
                            }
                            if (listFiles[i].getName().startsWith(format2)) {
                                listFiles[i].delete();
                            }
                            i++;
                        }
                        g.c(aVar);
                        return;
                    }
                    g.c(aVar);
                }

                public final String toString() {
                    return super.toString() + "|deleteAllPic";
                }
            });
        } else {
            c(aVar);
        }
    }

    public final void aG(boolean z) {
        d.c.a(Integer.valueOf(12399999), this.ile);
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ g ilj;

            {
                this.ilj = r1;
            }

            public final void run() {
                if (ak.uz()) {
                    ak.yW();
                    be.f(com.tencent.mm.model.c.wP(), "ReaderApp_", 604800000);
                }
            }

            public final String toString() {
                return super.toString() + "|onAccountPostReset";
            }
        });
        com.tencent.mm.sdk.c.a.nhr.e(this.ilf);
        com.tencent.mm.sdk.c.a.nhr.e(this.ilg);
        com.tencent.mm.sdk.c.a.nhr.e(this.ilh);
        h.b(e.ilc);
    }

    public final void aH(boolean z) {
    }
}
