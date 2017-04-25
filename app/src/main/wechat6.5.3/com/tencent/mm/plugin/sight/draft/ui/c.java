package com.tencent.mm.plugin.sight.draft.ui;

import android.graphics.Bitmap;
import com.tencent.mm.a.f;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import java.lang.ref.WeakReference;

public abstract class c {
    f<String, Bitmap> iWu = new f(24);
    Bitmap iWv;

    private static final class a implements Runnable {
        String apU;
        boolean iWw;
        WeakReference<c> iWx;
        String path;

        private a() {
        }

        public final void run() {
            Bitmap JV = d.JV(this.path);
            c cVar = (c) this.iWx.get();
            if (cVar != null) {
                if (!(be.kS(this.apU) || JV == null)) {
                    cVar.iWu.put(this.apU, JV);
                }
                Runnable bVar = new b();
                bVar.apU = this.apU;
                bVar.ggw = JV;
                bVar.iWx = this.iWx;
                if (this.iWw) {
                    ad.o(bVar);
                }
            }
        }
    }

    private static final class b implements Runnable {
        String apU;
        Bitmap ggw;
        WeakReference<c> iWx;

        private b() {
        }

        public final void run() {
            c cVar = (c) this.iWx.get();
            if (cVar != null) {
                cVar.p(this.apU, this.ggw);
            }
        }
    }

    public abstract void p(String str, Bitmap bitmap);

    public final Bitmap l(String str, String str2, boolean z) {
        if (be.kS(str)) {
            return aPL();
        }
        Bitmap bitmap = (Bitmap) this.iWu.get(str);
        if (bitmap != null) {
            return bitmap;
        }
        Object aVar = new a();
        aVar.apU = str;
        aVar.path = str2;
        aVar.iWw = z;
        aVar.iWx = new WeakReference(this);
        if (z) {
            ak.vA().x(aVar);
        } else {
            aVar.run();
            bitmap = (Bitmap) this.iWu.get(str);
            if (bitmap != null) {
                return bitmap;
            }
        }
        return aPL();
    }

    private Bitmap aPL() {
        if (this.iWv == null) {
            this.iWv = d.uU(2131165817);
        }
        return this.iWv;
    }
}
