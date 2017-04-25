package com.tencent.mm.ae.a.f;

import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.mm.ae.a.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class c implements Runnable {
    private String apU;
    private Bitmap bitmap;
    private b cPZ;
    private com.tencent.mm.ae.a.c cQb;
    private String url;

    public c(String str, com.tencent.mm.ae.a.c cVar, Bitmap bitmap, b bVar, String str2) {
        this.url = str;
        this.cQb = cVar;
        this.bitmap = bitmap;
        this.cPZ = bVar;
        this.apU = str2;
    }

    public final void run() {
        if (be.kS(this.url) || this.cQb == null || this.bitmap == null || this.bitmap.isRecycled() || this.cPZ == null) {
            v.w("MicroMsg.imageloader.ImageShowTask", "[cpan] run something is null.");
            return;
        }
        if (this.url.equals((String) this.cPZ.cOP.get(Integer.valueOf(this.cQb.GS())))) {
            com.tencent.mm.ae.a.c cVar = this.cQb;
            Bitmap bitmap = this.bitmap;
            if (Looper.myLooper() == Looper.getMainLooper() && cVar.cOR != null) {
                ImageView imageView = (ImageView) cVar.cOR.get();
                if (imageView != null) {
                    imageView.setImageBitmap(bitmap);
                }
            }
            this.cPZ.a(this.cQb);
            return;
        }
        v.w("MicroMsg.imageloader.ImageShowTask", "[cpan] url is not equals view url.");
    }
}
