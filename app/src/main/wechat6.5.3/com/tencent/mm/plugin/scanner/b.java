package com.tencent.mm.plugin.scanner;

import android.annotation.SuppressLint;
import com.tencent.mm.bg.g.c;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.platformtools.g;
import com.tencent.mm.platformtools.g.a;
import com.tencent.mm.plugin.scanner.a.j;
import com.tencent.mm.plugin.scanner.a.m;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.util.HashMap;

public final class b implements ag {
    private static HashMap<Integer, c> bXq;
    @SuppressLint({"UseSparseArrays"})
    private static HashMap<Integer, c> ius = new HashMap();
    public String cka;
    private a iut;
    public com.tencent.mm.plugin.g.a.b ivv = new com.tencent.mm.plugin.g.a.b();
    private j ivw = new j();
    private m ivx = new m();
    private com.tencent.mm.plugin.scanner.history.a.b ivy;
    private com.tencent.mm.plugin.scanner.a.b ivz = new com.tencent.mm.plugin.scanner.a.b();

    static {
        HashMap hashMap = new HashMap();
        bXq = hashMap;
        hashMap.put(Integer.valueOf("SCANHISTORY_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return com.tencent.mm.plugin.scanner.history.a.b.cic;
            }
        });
    }

    public static b aKP() {
        b bVar = (b) ak.yP().fY("plugin.scanner");
        if (bVar != null) {
            return bVar;
        }
        bVar = new b();
        ak.yP().a("plugin.scanner", bVar);
        return bVar;
    }

    public final void th() {
        com.tencent.mm.sdk.c.a.nhr.f(this.ivw);
        com.tencent.mm.sdk.c.a.nhr.f(this.ivx.iww);
        com.tencent.mm.sdk.c.a.nhr.f(this.ivx.iwx);
        com.tencent.mm.plugin.scanner.a.b bVar = this.ivz;
        com.tencent.mm.sdk.c.a.nhr.f(bVar.ivX);
        com.tencent.mm.sdk.c.a.nhr.f(bVar.ivY);
        bVar.aKR();
        com.tencent.mm.plugin.g.a.b bVar2 = this.ivv;
        bVar2.cOD.clear();
        bVar2.ihu.clear();
        if (this.iut != null) {
            this.iut.gG(hashCode());
            this.iut = null;
        }
        this.cka = "";
    }

    public final HashMap<Integer, c> ti() {
        return bXq;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        this.iut = g.a(hashCode(), stringBuilder.append(com.tencent.mm.model.c.xp()).append("CommonOneMicroMsg.db").toString(), ius, false);
        com.tencent.mm.plugin.scanner.a.b bVar = this.ivz;
        com.tencent.mm.sdk.c.a.nhr.e(bVar.ivX);
        com.tencent.mm.sdk.c.a.nhr.e(bVar.ivY);
        com.tencent.mm.sdk.c.a.nhr.e(this.ivw);
        com.tencent.mm.sdk.c.a.nhr.e(this.ivx.iww);
        com.tencent.mm.sdk.c.a.nhr.e(this.ivx.iwx);
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ b ivA;

            {
                this.ivA = r1;
            }

            public final void run() {
                if (!ak.uz()) {
                    return;
                }
                if (be.kS(this.ivA.cka)) {
                    v.e("MicroMsg.scanner.SubCoreScanner", "accPath == null in onAccountPostReset");
                } else {
                    be.f(this.ivA.cka + "image/scan/img", "scanbook", 604800000);
                }
            }

            public final String toString() {
                return super.toString() + "|onAccountPostReset";
            }
        });
    }

    public final void aH(boolean z) {
        StringBuilder stringBuilder = new StringBuilder("onSdcardMount ");
        ak.yW();
        v.d("MicroMsg.scanner.SubCoreScanner", stringBuilder.append(com.tencent.mm.model.c.xq()).toString());
        b aKP = aKP();
        ak.yW();
        String xq = com.tencent.mm.model.c.xq();
        v.d("MicroMsg.scanner.SubCoreScanner", "resetAccPath on accPath : " + xq);
        aKP.cka = xq;
        File file = new File(xq);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(xq + "image/scan/img");
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(xq + "image/scan/music");
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static String xq() {
        return aKP().cka;
    }

    public final String cr(String str, String str2) {
        if (!ak.uz() || be.kS(str)) {
            return "";
        }
        return String.format("%s/scanbook%s_%s", new Object[]{this.cka + "image/scan/img", str2, com.tencent.mm.a.g.m(str.getBytes())});
    }

    public static com.tencent.mm.plugin.scanner.history.a.b aKQ() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aKP().ivy == null) {
            b aKP = aKP();
            ak.yW();
            aKP.ivy = new com.tencent.mm.plugin.scanner.history.a.b(com.tencent.mm.model.c.wE());
        }
        return aKP().ivy;
    }
}
