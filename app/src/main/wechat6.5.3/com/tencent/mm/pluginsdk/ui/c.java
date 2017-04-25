package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import com.tencent.mm.pluginsdk.ui.a.b;

public final class c extends h implements com.tencent.mm.u.d.a {
    a lGa;
    int lGb;

    private static class a implements com.tencent.mm.pluginsdk.ui.h.a {
        Bitmap eAm = null;
        private com.tencent.mm.pluginsdk.ui.h.a hXG;

        public a(com.tencent.mm.pluginsdk.ui.h.a aVar) {
            this.hXG = aVar;
        }

        public final Bitmap a(String str, int i, int i2, int i3) {
            if (this.hXG != null) {
                return this.hXG.a(str, i, i2, i3);
            }
            return null;
        }

        public final Bitmap bg(String str) {
            if (this.hXG != null) {
                return this.hXG.bg(str);
            }
            return null;
        }

        public final Bitmap bh(String str) {
            if (this.hXG != null) {
                return this.hXG.bh(str);
            }
            return null;
        }

        public final Bitmap od() {
            if (this.eAm != null && !this.eAm.isRecycled()) {
                return this.eAm;
            }
            if (this.hXG != null) {
                return this.hXG.od();
            }
            return null;
        }

        public final void a(h hVar) {
            if (this.hXG != null) {
                this.hXG.a(hVar);
            }
        }
    }

    public c(String str) {
        this(str, (byte) 0);
    }

    private c(String str, byte b) {
        super(new a(b.box()), str, false);
        this.lGa = (a) this.hXG;
    }
}
