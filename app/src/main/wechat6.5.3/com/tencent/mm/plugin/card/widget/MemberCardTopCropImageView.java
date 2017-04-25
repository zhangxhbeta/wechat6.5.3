package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.bd.a;
import com.tencent.mm.sdk.platformtools.aa;

public class MemberCardTopCropImageView extends ImageView {
    protected int eLQ = -1;
    protected int eOr = -1;
    private float eOs;
    protected int itemPadding = -1;

    public MemberCardTopCropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MemberCardTopCropImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setScaleType(ScaleType.MATRIX);
        this.eLQ = a.N(aa.getContext(), 2131493355);
        this.itemPadding = a.N(aa.getContext(), 2131493152) * 2;
    }

    protected boolean setFrame(int i, int i2, int i3, int i4) {
        if (getDrawable() == null) {
            return super.setFrame(i, i2, i3, i4);
        }
        Matrix imageMatrix = getImageMatrix();
        int intrinsicWidth = getDrawable().getIntrinsicWidth();
        int intrinsicHeight = getDrawable().getIntrinsicHeight();
        this.eOr = getContext().getResources().getDisplayMetrics().widthPixels - this.itemPadding;
        int i5 = this.eOr;
        int i6 = this.eLQ;
        if (intrinsicWidth * i6 > intrinsicHeight * i5) {
            this.eOs = ((float) i6) / ((float) intrinsicHeight);
        } else {
            this.eOs = ((float) i5) / ((float) intrinsicWidth);
        }
        imageMatrix.setScale(this.eOs, this.eOs);
        setImageMatrix(imageMatrix);
        return super.setFrame(i, i2, i3, i4);
    }
}
