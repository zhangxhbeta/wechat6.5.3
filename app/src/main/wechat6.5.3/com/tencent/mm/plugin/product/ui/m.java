package com.tencent.mm.plugin.product.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.product.b.n;
import com.tencent.mm.sdk.platformtools.be;

public final class m implements a {
    public TextView dtB;
    public ImageView hEP;
    public n.a hSX;

    public final void k(String str, final Bitmap bitmap) {
        if (this.hSX != null && !be.kS(this.hSX.iconUrl) && str.equals(this.hSX.iconUrl)) {
            this.hEP.post(new Runnable(this) {
                final /* synthetic */ m hSY;

                public final void run() {
                    this.hSY.hEP.setImageBitmap(bitmap);
                }
            });
        }
    }
}
