package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

public class ForceInvalidateImageView extends ImageView {
    public ForceInvalidateImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ForceInvalidateImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @TargetApi(8)
    protected void onVisibilityChanged(View view, int i) {
        if (i == 0) {
            invalidate();
        }
        super.onVisibilityChanged(view, i);
    }
}
