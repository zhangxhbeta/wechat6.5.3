package com.tencent.mm.plugin.extaccessories;

import com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy;
import com.tencent.mm.bg.g;
import com.tencent.mm.e.a.lc;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.util.HashMap;

public final class b implements ag {
    String cka;
    private a fIu;

    public static class a extends c<lc> {
        public a() {
            this.nhz = lc.class.getName().hashCode();
        }

        private boolean a(lc lcVar) {
            if (lcVar instanceof lc) {
                v.d("MicroMsg.extaccessories.SubCoreExtAccessories", "RegistSpenBuddyEvent");
                if (!(lcVar.bmw == null || lcVar.bmw.bmy == null || lcVar.bmw.bmx == null)) {
                    try {
                        new SlookWritingBuddy(lcVar.bmw.bmy).setImageWritingListener(new SubCoreExtAccessories$RegistSpenBuddyEventListener$1(this, lcVar));
                    } catch (Exception e) {
                        v.e("MicroMsg.extaccessories.SubCoreExtAccessories", "exception in writingBuddy %s", new Object[]{e.getMessage()});
                    }
                }
                return true;
            }
            v.f("MicroMsg.extaccessories.SubCoreExtAccessories", "mismatched event");
            return false;
        }
    }

    public final HashMap<Integer, g.c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aH(boolean z) {
        ak.yW();
        this.cka = com.tencent.mm.model.c.xq();
        File file = new File(this.cka);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(this.cka + "image/spen/");
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public final void aG(boolean z) {
        v.d("MicroMsg.extaccessories.SubCoreExtAccessories", "SubCoreExtAccessories reset");
        if (this.fIu == null) {
            this.fIu = new a();
        }
        com.tencent.mm.sdk.c.a.nhr.e(this.fIu);
        ak.vA().f(new Runnable(this) {
            final /* synthetic */ b fIv;

            {
                this.fIv = r1;
            }

            public final void run() {
                if (ak.uz() && !be.kS(this.fIv.cka)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    be.f(this.fIv.cka + "image/spen/", "spen_", 259200000);
                    v.d("MicroMsg.extaccessories.SubCoreExtAccessories", "deleteOutOfDateFile cost %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                }
            }
        }, 5000);
    }

    public final void th() {
        v.d("MicroMsg.extaccessories.SubCoreExtAccessories", "SubCoreExtAccessories release");
        if (this.fIu != null) {
            com.tencent.mm.sdk.c.a.nhr.f(this.fIu);
        }
    }
}
