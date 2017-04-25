package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

public class ChattingEmojiView extends MMEmojiView {
    private int lOO;
    private float lOP = 1.5f;

    public ChattingEmojiView(Context context) {
        super(context);
        init(context);
    }

    public ChattingEmojiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ChattingEmojiView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.lOO = context.getResources().getDimensionPixelSize(2131493447);
        this.mDensity = this.lOP;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int intrinsicWidth = getIntrinsicWidth();
        int intrinsicHeight = getIntrinsicHeight();
        if (intrinsicWidth > this.lOO || intrinsicHeight > this.lOO) {
            float f;
            if (intrinsicWidth > intrinsicHeight) {
                f = ((float) this.lOO) / ((float) intrinsicWidth);
                intrinsicWidth = this.lOO;
                intrinsicHeight = (int) (((float) intrinsicHeight) * f);
            } else if (intrinsicHeight > intrinsicWidth) {
                f = ((float) this.lOO) / ((float) intrinsicHeight);
                intrinsicHeight = this.lOO;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f);
            } else {
                intrinsicWidth = this.lOO;
                intrinsicHeight = this.lOO;
            }
        }
        setMeasuredDimension(intrinsicWidth, intrinsicHeight);
    }
}
