package com.tencent.mm.plugin.gallery.model;

import android.graphics.Bitmap;
import com.tencent.mm.a.f;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.h.h;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.util.Vector;

public final class b {
    h<b, String> cye = new h<b, String>(this) {
        final /* synthetic */ b gdF;

        {
            this.gdF = r1;
        }

        protected final /* synthetic */ void o(Object obj, Object obj2) {
            ((b) obj).tV((String) obj2);
        }
    };
    public Vector<b> cyf = new Vector();
    f<String, a> gdC = new f(100, new com.tencent.mm.a.f.b<String, a>(this) {
        final /* synthetic */ b gdF;

        {
            this.gdF = r1;
        }

        public final /* synthetic */ void l(Object obj, Object obj2) {
            String str = (String) obj;
            a aVar = (a) obj2;
            if (aVar == null) {
                v.d("MicroMsg.GalleryCache", "weakReference is null");
            } else if (aVar.bitmap == null) {
                v.d("MicroMsg.GalleryCache", "weakReference getbitmap is null");
            } else {
                aVar.bitmap.recycle();
                v.d("MicroMsg.GalleryCache", "gallery remove ", new Object[]{str});
            }
        }
    });
    d gdD;
    private final b gdE = new b(this) {
        final /* synthetic */ b gdF;

        {
            this.gdF = r1;
        }

        public final void tV(String str) {
            v.i("MicroMsg.GalleryCache", "now listener size : " + this.gdF.cyf.size());
            for (int size = this.gdF.cyf.size() - 1; size >= 0; size--) {
                b bVar;
                try {
                    bVar = (b) this.gdF.cyf.get(size);
                } catch (Exception e) {
                    v.e("MicroMsg.GalleryCache", "get wathcer failed:[%s]", new Object[]{e.toString()});
                    bVar = null;
                }
                if (bVar == null) {
                    v.d("MicroMsg.GalleryCache", "get listener is null");
                } else {
                    bVar.tV(str);
                }
            }
        }
    };

    private class a {
        Bitmap bitmap;
        final /* synthetic */ b gdF;
        private int type;

        public a(b bVar, Bitmap bitmap, int i) {
            this.gdF = bVar;
            this.bitmap = bitmap;
            this.type = i;
        }
    }

    public interface b {
        void tV(String str);
    }

    public b() {
        d dVar = new d(new File(e.cnj + "/diskcache"));
        dVar.gdP = aa.getContext().getSharedPreferences(aa.bti(), 0).getInt("com.tencent.mm.gallery.cache.suffix", 0);
        dVar.aqt();
        dVar.lc(-1);
        this.gdD = dVar;
        this.cye.a(this.gdE, null);
    }

    public final Bitmap getBitmap(String str) {
        if (be.kS(str)) {
            v.e("MicroMsg.GalleryCache", "null filepath");
            return null;
        } else if (this.gdC == null) {
            v.w("MicroMsg.GalleryCache", "want to get bitmap, but gallery cache is null");
            return null;
        } else {
            if (this.gdC.aI(str)) {
                a aVar = (a) this.gdC.get(str);
                if (aVar == null) {
                    v.d("MicroMsg.GalleryCache", "weakreference is null");
                    this.gdC.remove(str);
                    return null;
                }
                Bitmap bitmap = aVar.bitmap;
                if (bitmap == null) {
                    this.gdC.remove(str);
                    v.i("MicroMsg.GalleryCache", "get bitmap is null");
                } else if (bitmap.isRecycled()) {
                    v.i("MicroMsg.GalleryCache", "cahce bitmap has recycled");
                    this.gdC.remove(str);
                    return null;
                } else {
                    v.i("MicroMsg.GalleryCache", "get cached bitmap:" + str);
                    return bitmap;
                }
            }
            return null;
        }
    }
}
