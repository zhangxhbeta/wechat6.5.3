package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.view.View;
import com.tencent.mm.bd.a;

public final class e extends View {
    public int ff;
    private Paint ft = new Paint();
    public int kAE;
    public int kAF;
    public int kAG;
    private RectF kAH;
    private Matrix mMatrix;

    public e(Context context) {
        super(context);
        this.ft.setStyle(Style.STROKE);
        this.ft.setColor(-65536);
        this.ft.setStrokeWidth((float) a.fromDPToPix(getContext(), 3));
        this.mMatrix = new Matrix();
    }

    protected final void onDraw(Canvas canvas) {
        if (this.kAH != null) {
            canvas.save();
            canvas.rotate(0.0f);
            canvas.drawRect(this.kAH, this.ft);
            canvas.restore();
        }
    }
}
