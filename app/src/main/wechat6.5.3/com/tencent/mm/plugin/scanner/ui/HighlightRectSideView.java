package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.v;

public class HighlightRectSideView extends View {
    private ah dwn = new ah(new a(this) {
        final /* synthetic */ HighlightRectSideView iyO;

        {
            this.iyO = r1;
        }

        public final boolean oU() {
            this.iyO.iyN = this.iyO.iyN + 1;
            this.iyO.invalidate();
            return true;
        }
    }, true);
    private boolean[] iyI;
    private Rect iyJ;
    private int iyK;
    private int iyL;
    private int iyM;
    private int iyN = 0;
    private Paint mY;

    public HighlightRectSideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Bitmap decodeResource = com.tencent.mm.compatible.f.a.decodeResource(getResources(), 2130839077);
        this.iyK = decodeResource.getWidth();
        this.iyL = decodeResource.getHeight();
        if (this.iyL != this.iyK) {
            v.e("MicroMsg.HighlightRectSideView", "width is not same as height");
        }
        this.iyM = (this.iyK * 6) / 24;
        this.iyI = new boolean[4];
        this.mY = new Paint();
        this.mY.setColor(6676738);
        this.mY.setAlpha(255);
        this.mY.setStrokeWidth((float) this.iyM);
        this.mY.setStyle(Style.STROKE);
        this.dwn.ea(300);
    }

    public final void h(Rect rect) {
        this.iyJ = rect;
        v.d("MicroMsg.HighlightRectSideView", "rect:%s", new Object[]{rect});
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.dwn != null) {
            this.dwn.QI();
            this.dwn = null;
        }
    }

    protected void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        for (int i2 = 0; i2 < 4; i2++) {
            if (!this.iyI[i2]) {
                i = 0;
                break;
            }
        }
        i = 1;
        int i3 = this.iyM / 2;
        if (this.iyI[0] && (1 == i || this.iyN % 2 == 0)) {
            canvas.drawLine((float) (this.iyJ.left + i3), (float) (this.iyJ.top + this.iyL), (float) (this.iyJ.left + i3), (float) (this.iyJ.bottom - this.iyL), this.mY);
        }
        if (this.iyI[1] && (1 == i || this.iyN % 2 == 0)) {
            canvas.drawLine((float) (this.iyJ.right - i3), (float) (this.iyJ.top + this.iyL), (float) (this.iyJ.right - i3), (float) (this.iyJ.bottom - this.iyL), this.mY);
        }
        if (this.iyI[2] && (1 == i || this.iyN % 3 == 0)) {
            canvas.drawLine((float) (this.iyJ.left + this.iyK), (float) (this.iyJ.top + i3), (float) (this.iyJ.right - this.iyK), (float) (this.iyJ.top + i3), this.mY);
        }
        if (!this.iyI[3]) {
            return;
        }
        if (1 == i || this.iyN % 3 == 0) {
            canvas.drawLine((float) (this.iyJ.left + this.iyK), (float) (this.iyJ.bottom - i3), (float) (this.iyJ.right - this.iyK), (float) (this.iyJ.bottom - i3), this.mY);
        }
    }

    public final void a(boolean[] zArr) {
        int i = 0;
        if (zArr != null && 4 == zArr.length) {
            v.d("MicroMsg.HighlightRectSideView", "%s, %s, %s, %s", new Object[]{Boolean.valueOf(zArr[0]), Boolean.valueOf(zArr[1]), Boolean.valueOf(zArr[2]), Boolean.valueOf(zArr[3])});
            while (i < 4) {
                this.iyI[i] = zArr[i];
                i++;
            }
            invalidate();
        }
    }
}
