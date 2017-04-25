package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Path;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mm.R;

public class MMVerticalTextView extends View {
    private String dVK;
    private int direction;
    private TextPaint gl = new TextPaint();
    Rect nYQ = new Rect();

    public MMVerticalTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gl.setAntiAlias(true);
        this.gl.setTextSize(15.0f);
        this.gl.setColor(-16777216);
        this.gl.setTextAlign(Align.CENTER);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.b.aPG);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            this.dVK = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getDimensionPixelOffset(2, 15);
        if (resourceId > 0) {
            this.gl.setTextSize((float) resourceId);
        }
        this.gl.setColor(obtainStyledAttributes.getColor(1, -16777216));
        this.direction = obtainStyledAttributes.getInt(3, 0);
        obtainStyledAttributes.recycle();
        requestLayout();
        invalidate();
    }

    public final void setText(String str) {
        this.dVK = str;
        requestLayout();
        invalidate();
    }

    protected void onMeasure(int i, int i2) {
        int height;
        this.gl.getTextBounds(this.dVK, 0, this.dVK.length(), this.nYQ);
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            height = this.nYQ.height();
            size = mode == Integer.MIN_VALUE ? Math.min(height, size) : height;
        }
        int mode2 = MeasureSpec.getMode(i2);
        height = MeasureSpec.getSize(i2);
        if (mode2 != 1073741824) {
            mode = this.nYQ.width();
            height = mode2 == Integer.MIN_VALUE ? Math.min(mode, height) : mode;
        }
        setMeasuredDimension(size, height);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        Path path = new Path();
        int width;
        if (this.direction == 0) {
            width = (getWidth() >> 1) - (this.nYQ.height() >> 1);
            path.moveTo((float) width, 0.0f);
            path.lineTo((float) width, (float) height);
        } else {
            width = (getWidth() >> 1) + (this.nYQ.height() >> 1);
            path.moveTo((float) width, (float) height);
            path.lineTo((float) width, 0.0f);
        }
        canvas.drawTextOnPath(this.dVK, path, 0.0f, 0.0f, this.gl);
    }
}
