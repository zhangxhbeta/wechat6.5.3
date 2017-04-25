package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.platformtools.a.a;

public class BorderNumView extends View {
    private static int nzA = 100;
    private static int nzy = 22;
    private static int nzz = 105;
    private Context context = null;
    private Paint ft;
    private int nzx = 100;

    public BorderNumView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    public BorderNumView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        init();
    }

    private void init() {
        this.ft = new Paint();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.nzx < 100) {
            nzy += 15;
        }
        if (this.nzx >= 1000) {
            nzA -= 20;
        }
        float a = (float) a.a(this.context, (float) nzy);
        float a2 = (float) a.a(this.context, (float) nzz);
        String str = this.nzx;
        this.ft.setAntiAlias(true);
        this.ft.setTextSize((float) nzA);
        this.ft.setColor(-11491572);
        this.ft.setStyle(Style.STROKE);
        this.ft.setStrokeWidth(8.0f);
        canvas.drawText(str, a, a2, this.ft);
        this.ft.setTextSize((float) nzA);
        this.ft.setColor(-1770573);
        this.ft.setStyle(Style.FILL);
        this.ft.setStrokeWidth(8.0f);
        canvas.drawText(str, a, a2, this.ft);
    }
}
