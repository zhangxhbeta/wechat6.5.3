package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mmdb.FileUtils;

public class TabIconView extends ImageView {
    private Paint evR;
    private Bitmap nHo;
    private Bitmap nHp;
    private Bitmap nHq;
    private Rect nHr;
    private Rect nHs;
    private Rect nHt;
    private int nHu = 0;

    public TabIconView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public TabIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void g(int i, int i2, int i3, boolean z) {
        if (z) {
            this.nHo = d.uV(i);
            this.nHp = d.uV(i3);
            this.nHq = d.uV(i2);
        } else {
            this.nHo = d.uU(i);
            this.nHp = d.uU(i3);
            this.nHq = d.uU(i2);
        }
        this.nHr = new Rect(0, 0, this.nHo.getWidth(), this.nHo.getHeight());
        this.nHs = new Rect(0, 0, this.nHp.getWidth(), this.nHp.getHeight());
        this.nHt = new Rect(0, 0, this.nHq.getWidth(), this.nHq.getHeight());
        this.evR = new Paint(1);
    }

    public final void vR(int i) {
        this.nHu = i;
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.evR != null) {
            if (this.nHu < FileUtils.S_IWUSR) {
                this.evR.setAlpha(255 - (this.nHu * 2));
                canvas.drawBitmap(this.nHp, null, this.nHs, this.evR);
                this.evR.setAlpha(this.nHu * 2);
                canvas.drawBitmap(this.nHq, null, this.nHt, this.evR);
                return;
            }
            this.evR.setAlpha(255 - (this.nHu * 2));
            canvas.drawBitmap(this.nHq, null, this.nHt, this.evR);
            this.evR.setAlpha(this.nHu * 2);
            canvas.drawBitmap(this.nHo, null, this.nHr, this.evR);
        }
    }
}
