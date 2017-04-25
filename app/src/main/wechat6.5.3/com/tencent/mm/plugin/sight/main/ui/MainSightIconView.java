package com.tencent.mm.plugin.sight.main.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;

public class MainSightIconView extends View {
    private int QW;
    private int Zx;
    private Paint ft = new Paint();
    private Rect fu;
    private Canvas jam = new Canvas();
    private Bitmap jan;
    private int jao;
    public int jap;
    public int jaq;
    private int jar;
    private Bitmap jas;
    private final float jat = 0.4f;
    public int jau;
    public int jav;
    public Animation jaw;

    public MainSightIconView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MainSightIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void kO(int i) {
        if (this.jan == null || this.jan.isRecycled()) {
            this.jan = d.uU(2131165609);
        }
        LayoutParams layoutParams = (LayoutParams) getLayoutParams();
        if (!(layoutParams == null || this.jan == null)) {
            layoutParams.width = this.jan.getWidth();
            layoutParams.height = this.jan.getHeight();
        }
        if (this.jan != null) {
            this.Zx = this.jan.getWidth();
            this.QW = this.jan.getHeight();
            this.jap = this.jan.getWidth() / 2;
        }
        this.fu = new Rect(0, 0, this.Zx, this.QW);
        this.jao = i;
        layoutParams.topMargin = this.jao - (this.QW / 2);
        v.i("MicroMsg.MainSightIconView", "params topMargin %s", new Object[]{Integer.valueOf(layoutParams.topMargin)});
        setLayoutParams(layoutParams);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void draw(Canvas canvas) {
        this.ft.reset();
        this.ft.setAntiAlias(true);
        if (this.jan == null || this.jan.isRecycled()) {
            v.e("MicroMsg.MainSightIconView", "MainSightIconView error, mEysBmp is null or recycled");
        } else if (this.jaq == 0) {
            canvas.drawARGB(0, 0, 0, 0);
        } else if (this.jaq == this.jap) {
            canvas.drawBitmap(this.jan, this.fu, this.fu, this.ft);
        } else if (this.jaq != this.jar || this.jas == null || this.jas.isRecycled()) {
            if (this.jas == null || this.jas.isRecycled()) {
                this.jas = Bitmap.createBitmap(this.Zx, this.QW, Config.ARGB_4444);
            } else {
                this.jas.eraseColor(0);
            }
            this.jam.setBitmap(this.jas);
            this.jam.drawCircle((float) (this.Zx / 2), (float) (this.QW / 2), (float) this.jaq, this.ft);
            this.ft.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
            this.jam.drawBitmap(this.jan, this.fu, this.fu, this.ft);
            this.ft.setXfermode(null);
            canvas.drawBitmap(this.jas, this.fu, this.fu, this.ft);
        } else {
            canvas.drawBitmap(this.jas, this.fu, this.fu, this.ft);
        }
    }
}
