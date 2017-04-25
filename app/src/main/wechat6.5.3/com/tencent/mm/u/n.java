package com.tencent.mm.u;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mm.a.g;
import com.tencent.mm.bg.g.c;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.b;
import com.tencent.mm.model.k;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.SFSContext.Builder;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import java.util.HashMap;

public class n implements ag {
    private static HashMap<Integer, c> bXq;
    private i cyU;
    private d cyV;
    private c cyW;
    private g cyX;
    private String cyY;
    private ah cyZ = new ah(ak.vA().htb.getLooper(), new a(this) {
        final /* synthetic */ n cza;

        {
            this.cza = r1;
        }

        public final boolean oU() {
            if (!ak.uz() || n.AX() == null) {
                v.w("MicroMsg.SubCoreAvatar", "upAssetsHandler onTimerExpired acc:%b astg:%s ", Boolean.valueOf(ak.uz()), n.AX());
            } else {
                ak.yW();
                if (((Boolean) com.tencent.mm.model.c.vf().get(90113, Boolean.valueOf(false))).booleanValue()) {
                    n.Bs();
                    n.Br();
                }
                ak.yW();
                com.tencent.mm.model.c.vf().set(90113, Boolean.valueOf(false));
            }
            return false;
        }

        public final String toString() {
            return super.toString() + "|upAssetsHandler";
        }
    }, false);

    static /* synthetic */ void Bs() {
        try {
            Context context = aa.getContext();
            for (String str : d.cyd.keySet()) {
                int intValue = d.cyd.containsKey(str) ? ((Integer) d.cyd.get(str)).intValue() : 0;
                if (intValue != 0) {
                    v.d("MicroMsg.SubCoreAvatar", "updateAssetsAvatar user:%s ", str);
                    AX().d(str, com.tencent.mm.compatible.f.a.decodeResource(context.getResources(), intValue));
                }
            }
        } catch (Throwable e) {
            v.e("MicroMsg.SubCoreAvatar", "exception:%s", be.e(e));
        }
    }

    public static n Bn() {
        n nVar = (n) ak.yP().fY(n.class.getName());
        if (nVar != null) {
            return nVar;
        }
        Object nVar2 = new n();
        ak.yP().a(n.class.getName(), nVar2);
        return nVar2;
    }

    public static i Bo() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new b();
        }
        if (Bn().cyU == null) {
            n Bn = Bn();
            ak.yW();
            Bn.cyU = new i(com.tencent.mm.model.c.wE());
        }
        return Bn().cyU;
    }

    public static d AX() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new b();
        }
        if (Bn().cyV == null) {
            Bn().cyV = new d();
        }
        return Bn().cyV;
    }

    public static g Bp() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new b();
        }
        if (Bn().cyX == null) {
            n Bn = Bn();
            ak.yW();
            Bn.cyX = new g(com.tencent.mm.model.c.wE());
        }
        return Bn().cyX;
    }

    public static c Bq() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new b();
        }
        if (Bn().cyW == null) {
            Bn().cyW = new c();
        }
        return Bn().cyW;
    }

    public final void th() {
        this.cyZ.QI();
        if (Bn().cyV != null) {
            d.reset();
        }
        e eVar = Bn().cyW;
        if (eVar != null) {
            ak.vy().b(123, eVar);
        }
        i iVar = Bn().cyU;
        if (iVar != null) {
            iVar.cyG.clear();
        }
        if (this.cyY != null) {
            FileOp.jJ(this.cyY);
            this.cyY = null;
        }
    }

    public final void ed(int i) {
    }

    static {
        HashMap hashMap = new HashMap();
        bXq = hashMap;
        hashMap.put(Integer.valueOf("IMG_FLAG_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return i.cic;
            }
        });
        bXq.put(Integer.valueOf("HDHEADIMGINFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return g.cic;
            }
        });
    }

    public final HashMap<Integer, c> ti() {
        return bXq;
    }

    public final void aG(boolean z) {
        ak.yW();
        FileOp.jS(com.tencent.mm.model.c.xq() + "sfs");
        this.cyY = com.tencent.mm.model.c.wR();
        FileOp.a(this.cyY, null, new Builder().setDBDirectory(com.tencent.mm.model.c.xp() + "sfs").setStoragePath(com.tencent.mm.model.c.xj()).setName("avatar"));
        if (z) {
            v.d("MicroMsg.SubCoreAvatar", "update all plugin avatars");
            ak.yW();
            com.tencent.mm.model.c.vf().set(90113, Boolean.valueOf(true));
        }
        this.cyZ.ea(10000);
    }

    static Context getContext() {
        return aa.getContext();
    }

    public final void aH(boolean z) {
        if (this.cyY != null) {
            FileOp.jJ(this.cyY);
            ak.yW();
            this.cyY = com.tencent.mm.model.c.wR();
            FileOp.a(this.cyY, null, new Builder().setDBDirectory(com.tencent.mm.model.c.xp() + "sfs").setStoragePath(com.tencent.mm.model.c.xj()).setName("avatar"));
        }
    }

    public static boolean Br() {
        ak.yW();
        if (be.a((Boolean) com.tencent.mm.model.c.vf().get(59, null), false)) {
            return true;
        }
        boolean z;
        AX();
        String s = d.s(k.xF(), false);
        if (FileOp.aR(s) || FileOp.aR(s + ".bm")) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return true;
        }
        s = k.xF();
        if (be.kS(s)) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        Bitmap gO = d.b.gO(stringBuilder.append(com.tencent.mm.model.c.wP()).append("user_").append(g.m(s.getBytes())).append(".png").toString());
        if (gO == null || gO.isRecycled()) {
            return false;
        }
        return AX().d(s, gO);
    }
}
