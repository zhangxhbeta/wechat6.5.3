package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mm.bd.a;

public class CardTagTextView extends TextView {
    private int eGN = 3;
    private RectF eNw = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
    private Paint eNx = new Paint();
    private int eNy = 9;
    private int eNz = 0;
    public int fillColor = 0;

    public CardTagTextView(Context context) {
        super(context);
        init();
    }

    public CardTagTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public CardTagTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.eGN = Math.round(a.getDensity(getContext()) * 0.5f);
        this.eNy = a.fromDPToPix(getContext(), 3);
        this.eNz = getCurrentTextColor();
    }

    public void setTextColor(int i) {
        this.eNz = i;
        super.setTextColor(i);
    }

    protected void onDraw(Canvas canvas) {
        this.eNw.left = (float) this.eNy;
        this.eNw.top = (float) this.eGN;
        this.eNw.right = (float) (getWidth() - this.eNy);
        this.eNw.bottom = (float) (getHeight() - this.eGN);
        if (this.fillColor != 0) {
            this.eNx.setColor(this.fillColor);
            this.eNx.setStyle(Style.FILL);
            canvas.drawRoundRect(this.eNw, (float) ((getHeight() / 2) - this.eGN), (float) ((getHeight() / 2) - this.eGN), this.eNx);
        }
        this.eNx.setColor(this.eNz);
        this.eNx.setStrokeWidth((float) this.eGN);
        this.eNx.setStyle(Style.STROKE);
        canvas.drawRoundRect(this.eNw, (float) ((getHeight() / 2) - this.eGN), (float) ((getHeight() / 2) - this.eGN), this.eNx);
        super.onDraw(canvas);
    }
}
