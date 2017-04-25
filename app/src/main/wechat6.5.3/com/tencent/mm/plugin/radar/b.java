package com.tencent.mm.plugin.radar;

import android.graphics.Bitmap;
import com.tencent.mm.a.f;
import com.tencent.mm.bg.g.c;
import com.tencent.mm.model.ag;
import com.tencent.mm.plugin.radar.ui.b.a;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.n;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class b implements ag {
    public final HashMap<Integer, c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aH(boolean z) {
    }

    public final void aG(boolean z) {
        a.hXG = new h.a(this) {
            private Bitmap aQs = null;
            private f<String, WeakReference<Bitmap>> hXH;
            private Bitmap ihI = null;
            final /* synthetic */ b ihJ;

            {
                this.ihJ = r6;
                try {
                    this.aQs = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(aa.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bd.a.getDensity(null), 0, 0);
                    this.ihI = d.a(this.aQs, false, (float) (this.aQs.getWidth() / 2));
                } catch (Throwable e) {
                    v.a("MicroMsg.SubCoreRadar", e, "", new Object[0]);
                }
                this.hXH = new f(15);
            }

            public final void a(h hVar) {
                if (hVar instanceof com.tencent.mm.u.d.a) {
                    n.AX().a((com.tencent.mm.u.d.a) hVar);
                }
            }

            public final Bitmap bg(String str) {
                WeakReference weakReference = (WeakReference) this.hXH.get(str);
                if (weakReference != null && weakReference.get() != null && !((Bitmap) weakReference.get()).isRecycled() && weakReference.get() == this.aQs) {
                    return (Bitmap) weakReference.get();
                }
                Bitmap a = com.tencent.mm.u.b.a(str, false, -1);
                if (a == null || a.isRecycled()) {
                    return this.ihI;
                }
                a = d.a(a, false, (float) (a.getWidth() / 2));
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

    public final void th() {
    }
}
