package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.bd.a;

public class PaddingImageView extends FrameLayout {
    ImageView fqF;
    ImageView fqG;
    private int fqH;

    public PaddingImageView(Context context) {
        super(context);
        init(context);
    }

    public PaddingImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public PaddingImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.fqH = a.N(getContext(), 2131493168);
        this.fqF = new ImageView(context);
        this.fqF.setPadding(this.fqH, this.fqH, this.fqH, this.fqH);
        this.fqG = new ImageView(context);
    }
}
