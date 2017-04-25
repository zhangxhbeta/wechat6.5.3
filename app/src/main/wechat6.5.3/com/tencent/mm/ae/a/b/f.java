package com.tencent.mm.ae.a.b;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.tencent.mm.ae.a.c.l;
import com.tencent.mm.ae.a.d.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Map;
import java.util.Map.Entry;

public final class f implements l {
    private a<String, Bitmap> cPV = new a(50);
    private a<String, Bitmap> cPW = new a(10);

    public final Bitmap gu(String str) {
        if (be.kS(str)) {
            return null;
        }
        return this.cPV.get(str) == null ? (Bitmap) this.cPW.get(str) : (Bitmap) this.cPV.get(str);
    }

    public final void b(String str, Bitmap bitmap) {
        if (be.kS(str)) {
            v.w("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put failed. key is null.");
        } else if (bitmap == null) {
            v.w("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put failed.value is null.");
        } else {
            long j;
            if (bitmap == null || !(bitmap instanceof Bitmap)) {
                j = 0;
            } else {
                Bitmap bitmap2 = bitmap;
                if (VERSION.SDK_INT >= 12) {
                    j = (long) bitmap2.getByteCount();
                } else {
                    j = (long) (bitmap2.getHeight() * bitmap2.getRowBytes());
                }
            }
            v.d("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put key:%s,bitmap size:%d B newsize:%s", str, Long.valueOf(j), be.aw(j));
            if (j > 524288) {
                this.cPW.put(str, bitmap);
            } else {
                this.cPV.put(str, bitmap);
            }
        }
    }

    public final void clear() {
        synchronized (this) {
            Map snapshot;
            Bitmap bitmap;
            if (this.cPV != null) {
                snapshot = this.cPV.snapshot();
                if (!snapshot.isEmpty() && snapshot.size() > 0) {
                    for (Entry value : snapshot.entrySet()) {
                        bitmap = (Bitmap) value.getValue();
                        if (!(bitmap == null || bitmap.isRecycled())) {
                            v.i("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "recycle bitmap:%s, not need", bitmap.toString());
                        }
                    }
                }
                this.cPV.clear();
            }
            if (this.cPW != null) {
                snapshot = this.cPW.snapshot();
                if (!snapshot.isEmpty() && snapshot.size() > 0) {
                    for (Entry value2 : snapshot.entrySet()) {
                        bitmap = (Bitmap) value2.getValue();
                        if (!(bitmap == null || bitmap.isRecycled())) {
                            v.i("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "recycle bitmap:%s. not need", bitmap.toString());
                        }
                    }
                }
                this.cPW.clear();
            }
        }
    }
}
