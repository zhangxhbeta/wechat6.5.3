package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.mm.bd.a;

public class LineLinearLayout extends LinearLayout {
    private int eOq;
    private Paint ft;
    private Rect fu;

    public LineLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LineLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setWillNotDraw(false);
        this.fu = new Rect();
        this.ft = new Paint();
        this.ft.setStyle(Style.STROKE);
        this.ft.setColor(-571543826);
        this.ft.setStrokeWidth((float) Math.round(a.getDensity(getContext()) * 0.5f));
        this.eOq = a.fromDPToPix(context, 44);
    }

    protected void onDraw(Canvas canvas) {
        int measuredHeight = getMeasuredHeight();
        Paint paint = this.ft;
        for (int i = 1; this.eOq * i < measuredHeight; i++) {
            canvas.drawLine(0.0f, (float) (this.eOq * i), (float) getMeasuredWidth(), (float) (this.eOq * i), paint);
        }
        super.onDraw(canvas);
    }
}
