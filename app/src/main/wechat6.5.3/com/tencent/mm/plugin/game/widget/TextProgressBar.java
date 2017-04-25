package com.tencent.mm.plugin.game.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.mm.bd.a;

public class TextProgressBar extends ProgressBar {
    private String dVK;
    private Paint ft;
    private int gAu;
    private Context mContext;
    private int rT;

    public TextProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public void setProgress(int i) {
        this.rT = i;
        this.dVK = String.valueOf(i) + "%";
        super.setProgress(i);
    }

    @SuppressLint({"DrawAllocation"})
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.ft = new Paint();
        this.ft.setAntiAlias(true);
        this.ft.setColor(Color.rgb(69, 192, 26));
        this.ft.setTextSize((float) this.gAu);
        Rect rect = new Rect();
        this.ft.getTextBounds(this.dVK, 0, this.dVK.length(), rect);
        float width = (float) ((getWidth() / 2) - rect.centerX());
        float height = (float) ((getHeight() / 2) - rect.centerY());
        canvas.drawText(this.dVK, width, height, this.ft);
        float width2 = (((float) this.rT) / 100.0f) * ((float) getWidth());
        if (width2 > width) {
            Paint paint = new Paint();
            paint.setColor(-1);
            paint.setAntiAlias(true);
            paint.setTextSize((float) this.gAu);
            RectF rectF = new RectF(0.0f, 0.0f, width2, (float) getHeight());
            canvas.save();
            canvas.clipRect(rectF);
            canvas.drawText(this.dVK, width, height, paint);
            canvas.restore();
        }
    }

    public final void lI(int i) {
        this.gAu = a.fromDPToPix(this.mContext, i);
    }
}
