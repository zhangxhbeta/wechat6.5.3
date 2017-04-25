package com.tencent.mm.plugin.pwdgroup;

import android.graphics.Bitmap;
import com.tencent.mm.a.f;
import com.tencent.mm.model.ag;
import com.tencent.mm.plugin.pwdgroup.b.a;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.d;
import com.tencent.mm.u.n;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class c implements ag {
    public final HashMap<Integer, com.tencent.mm.bg.g.c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        a.hXG = new h.a(this) {
            private Bitmap aQs = null;
            private f<String, WeakReference<Bitmap>> hXH;
            final /* synthetic */ c hXI;

            {
                this.hXI = r6;
                try {
                    this.aQs = b.a(aa.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bd.a.getDensity(null), 0, 0);
                } catch (Throwable e) {
                    v.a("MicroMsg.Facing.SubCorePwdGroup", e, "", new Object[0]);
                }
                this.hXH = new f(15);
            }

            public final void a(h hVar) {
                if (hVar instanceof d.a) {
                    n.AX().a((d.a) hVar);
                }
            }

            public final Bitmap bg(String str) {
                WeakReference weakReference = (WeakReference) this.hXH.get(str);
                if (weakReference != null && weakReference.get() != null && !((Bitmap) weakReference.get()).isRecycled() && weakReference.get() == this.aQs) {
                    return (Bitmap) weakReference.get();
                }
                Bitmap a = com.tencent.mm.u.b.a(str, false, -1);
                if (a == null || a.isRecycled()) {
                    return this.aQs;
                }
                this.hXH.k(str, new WeakReference(a));
                return a;
            }

            public final Bitmap od() {
                return this.aQs;
            }

            public final Bitmap bh(String str) {
                return null;
            }

            public final Bitmap a(String str, int i, int i2, int i3) {
                return null;
            }
        };
    }

    public final void aH(boolean z) {
    }

    public final void th() {
    }
}
