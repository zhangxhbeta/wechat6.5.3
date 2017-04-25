package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.text.Layout.Alignment;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mm.bd.a;
import com.tencent.mm.sdk.platformtools.be;

public final class AppBrandTypedTagImageView extends ImageView {
    private static final int dVM = Color.parseColor("#D04557");
    private Spanned dVN = null;
    private StaticLayout dVO = null;
    private TextPaint gl;

    public AppBrandTypedTagImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AppBrandTypedTagImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        if (!(be.D(this.dVN) || (this.dVO != null && this.dVO.getWidth() == measuredWidth && this.dVO.getText().equals(this.dVN)))) {
            if (this.gl == null) {
                this.gl = new TextPaint();
                this.gl.setTextSize((float) a.fromDPToPix(getContext(), 11));
                this.gl.setAntiAlias(true);
            }
            this.dVO = new StaticLayout(this.dVN, this.gl, measuredWidth, Alignment.ALIGN_OPPOSITE, 1.0f, 0.0f, true);
        }
        if (be.D(this.dVN)) {
            this.dVO = null;
        }
    }

    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.dVO != null) {
            canvas.save();
            canvas.translate(0.0f, (float) (canvas.getHeight() - this.dVO.getHeight()));
            this.dVO.draw(canvas);
            canvas.restore();
        }
    }
}
