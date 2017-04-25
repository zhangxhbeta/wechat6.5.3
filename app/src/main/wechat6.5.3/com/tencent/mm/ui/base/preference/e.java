package com.tencent.mm.ui.base.preference;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.bd.a;

public final class e {
    Bitmap bitmap = null;
    int kCd = -1;

    public final void d(ImageView imageView) {
        if (imageView != null) {
            if (this.kCd != -1) {
                imageView.setImageDrawable(a.a(imageView.getContext(), this.kCd));
            }
            if (this.bitmap != null) {
                imageView.setImageBitmap(this.bitmap);
            }
        }
    }
}
