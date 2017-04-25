package com.tencent.mm.plugin.sight.encode.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.bd.a;
import com.tencent.smtt.sdk.WebView;

public class CameraFrontSightView extends View {
    public int QW;
    public int Zx;
    private int dVS;
    private Paint ft = new Paint();
    private boolean iXr = false;
    private boolean iXs = false;
    private boolean iXt = false;
    private boolean iXu = false;
    private long iXv = 0;
    private int iXw;
    private int iXx;
    private LayoutParams iXy;

    public CameraFrontSightView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public CameraFrontSightView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void cp(int i, int i2) {
        this.iXy = getLayoutParams();
        if (this.iXy != null) {
            this.iXy.width = i;
            this.iXy.height = i2;
        }
        this.Zx = i;
        this.QW = i2;
        this.iXw = this.Zx / 2;
        this.iXx = this.QW / 2;
        this.dVS = a.fromDPToPix(getContext(), 1);
        this.ft.setColor(-12206054);
        this.ft.setStrokeWidth((float) this.dVS);
    }

    public final void aPX() {
        setVisibility(0);
        this.iXr = true;
        this.iXs = false;
        this.iXt = false;
        this.iXu = false;
        this.iXv = System.currentTimeMillis();
        invalidate();
    }

    public void draw(Canvas canvas) {
        canvas.translate((float) (this.iXw / 2), (float) (this.iXx / 2));
        long currentTimeMillis = System.currentTimeMillis() - this.iXv;
        if (currentTimeMillis > 200) {
            this.iXr = false;
            this.iXs = true;
        }
        if (currentTimeMillis > 800) {
            this.iXs = false;
            this.iXt = true;
        }
        if (currentTimeMillis > 1100) {
            this.iXt = false;
            this.iXu = true;
        }
        if (currentTimeMillis > 1300) {
            this.iXu = false;
            setVisibility(8);
            return;
        }
        if (this.iXr) {
            float f = (((float) (200 - currentTimeMillis)) / 200.0f) + 1.0f;
            canvas.scale(f, f, (float) (this.iXw / 2), (float) (this.iXx / 2));
            this.ft.setAlpha((int) ((2.0f - f) * 255.0f));
        } else {
            canvas.scale(1.0f, 1.0f);
        }
        if (this.iXs) {
            f = (((float) ((currentTimeMillis - 200) % 200)) / 200.0f) * 2.0f;
            this.ft.setAlpha((int) (((f > 1.0f ? f - 1.0f : 1.0f - f) * 128.0f) + 127.0f));
        } else {
            this.ft.setAlpha(WebView.NORMAL_MODE_ALPHA);
        }
        if (this.iXu) {
            this.ft.setAlpha((int) ((1.0f - (((float) (currentTimeMillis - 1100)) / 200.0f)) * 255.0f));
        }
        canvas.drawLine(0.0f, 0.0f, (float) this.iXw, 0.0f, this.ft);
        canvas.drawLine(0.0f, 0.0f, 0.0f, (float) this.iXx, this.ft);
        canvas.drawLine((float) this.iXw, 0.0f, (float) this.iXw, (float) this.iXx, this.ft);
        canvas.drawLine(0.0f, (float) this.iXx, (float) this.iXw, (float) this.iXx, this.ft);
        canvas.drawLine(0.0f, (float) (this.iXx / 2), (float) (this.iXw / 10), (float) (this.iXx / 2), this.ft);
        canvas.drawLine((float) this.iXw, (float) (this.iXx / 2), (float) ((this.iXw * 9) / 10), (float) (this.iXx / 2), this.ft);
        canvas.drawLine((float) (this.iXw / 2), 0.0f, (float) (this.iXw / 2), (float) (this.iXx / 10), this.ft);
        canvas.drawLine((float) (this.iXw / 2), (float) this.iXx, (float) (this.iXw / 2), (float) ((this.iXx * 9) / 10), this.ft);
        invalidate();
    }
}
