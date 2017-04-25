package com.tencent.mm.plugin.emoji.c;

import android.graphics.Bitmap;
import com.tencent.mm.ae.a.c.l;
import com.tencent.mm.ae.a.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.br;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Map;
import java.util.Map.Entry;

public final class b implements l {
    private a<String, Bitmap> cPV = new a(br.CTRL_INDEX);

    public final Bitmap gu(String str) {
        if (be.kS(str)) {
            return null;
        }
        return (Bitmap) this.cPV.get(str);
    }

    public final void b(String str, Bitmap bitmap) {
        if (be.kS(str)) {
            v.w("MicroMsg.emoji.EmojiLoaderMemoryCache", "[cpan] put failed. key is null.");
        } else if (bitmap == null) {
            v.w("MicroMsg.emoji.EmojiLoaderMemoryCache", "[cpan] put failed.value is null.");
        } else {
            this.cPV.put(str, bitmap);
        }
    }

    public final void clear() {
        synchronized (this) {
            if (this.cPV != null) {
                Map snapshot = this.cPV.snapshot();
                if (!snapshot.isEmpty() && snapshot.size() > 0) {
                    for (Entry value : snapshot.entrySet()) {
                        Bitmap bitmap = (Bitmap) value.getValue();
                        if (!(bitmap == null || bitmap.isRecycled())) {
                            v.i("MicroMsg.emoji.EmojiLoaderMemoryCache", "recycle bitmap:%s, not need", new Object[]{bitmap.toString()});
                        }
                    }
                }
                this.cPV.clear();
            }
        }
    }
}
