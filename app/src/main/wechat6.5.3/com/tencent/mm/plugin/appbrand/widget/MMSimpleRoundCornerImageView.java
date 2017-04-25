package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.b.a.i;
import android.support.v4.b.a.k;
import android.util.AttributeSet;
import android.widget.ImageView;

public class MMSimpleRoundCornerImageView extends ImageView {
    private float dWy;

    public MMSimpleRoundCornerImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MMSimpleRoundCornerImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setImageBitmap(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() < 0 || bitmap.getHeight() < 0) {
            super.setImageBitmap(bitmap);
        } else if (this.dWy <= 0.0f) {
            super.setImageBitmap(bitmap);
        } else {
            i a = k.a(getResources(), bitmap);
            float min = Math.min(((float) bitmap.getWidth()) * this.dWy, ((float) bitmap.getHeight()) * this.dWy);
            if (a.iV != min) {
                a.tJ = false;
                if (i.n(min)) {
                    a.ft.setShader(a.tE);
                } else {
                    a.ft.setShader(null);
                }
                a.iV = min;
                a.invalidateSelf();
            }
            super.setImageDrawable(a);
        }
    }
}
