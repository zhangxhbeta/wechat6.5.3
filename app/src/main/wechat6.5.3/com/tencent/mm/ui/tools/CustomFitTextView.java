package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import com.tencent.mm.bd.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;
import java.util.LinkedList;

public class CustomFitTextView extends TextView {
    public int maxLines;
    private Paint oRW;
    private String oRX;
    private Rect oRY = new Rect();
    private LinkedList<String> oRZ = new LinkedList();
    public int oSa;
    private Drawable oSb;
    public boolean oSc;
    private boolean oSd = true;
    private int oSe = 0;

    public CustomFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void c(String str, int i, boolean z, int i2) {
        a(str, i, z, i2, getCurrentTextColor());
    }

    public final void a(String str, int i, boolean z, int i2, int i3) {
        this.maxLines = i;
        this.oRX = str;
        if (this.oRX == null) {
            v.w("MicroMsg.CustomFitTextView", "ori text is null");
            this.oRX = "";
        }
        if (this.maxLines <= 0) {
            v.w("MicroMsg.CustomFitTextView", "maxLines is invalid");
            this.maxLines = 2;
        }
        this.oSe = getResources().getDimensionPixelSize(2131492962);
        this.oSc = z;
        this.oSa = i2;
        if (this.oSc) {
            this.oSb = getResources().getDrawable(this.oSa);
        }
        this.oRW = new Paint();
        this.oRW.set(getPaint());
        this.oRW.setAntiAlias(true);
        this.oRW.setColor(i3);
        cl(this.oRX, getWidth());
        setHeight(Math.max(bJl(), a.fromDPToPix(getContext(), 32)));
    }

    private int bJl() {
        FontMetrics fontMetrics = getPaint().getFontMetrics();
        return ((int) ((((fontMetrics.leading + (fontMetrics.bottom - fontMetrics.top)) * ((float) this.oRZ.size())) + ((float) getPaddingTop())) + ((float) getPaddingBottom()))) + (Math.max(0, this.oRZ.size() - 1) * this.oSe);
    }

    private boolean cl(String str, int i) {
        if (!this.oSd || i <= 0 || str == null || "".equals(str)) {
            return false;
        }
        int ceil;
        this.oRZ.clear();
        int i2 = 0;
        int length = str.length();
        int paddingLeft = (i - getPaddingLeft()) - getPaddingRight();
        int intrinsicWidth = this.oSc ? this.oSb.getIntrinsicWidth() : 0;
        float measureText = ((float) intrinsicWidth) + getPaint().measureText(str, 0, length);
        int i3 = this.maxLines;
        if (Float.compare(measureText, (float) (this.maxLines * paddingLeft)) < 0) {
            ceil = (int) Math.ceil((double) (measureText / ((float) paddingLeft)));
        } else {
            ceil = i3;
        }
        for (int i4 = 0; i4 < ceil; i4++) {
            if (i4 == ceil - 1) {
                PB(str.substring(i2, a(str, i2, length, intrinsicWidth, paddingLeft)).trim());
            } else {
                i3 = a(str, i2, length, 0, paddingLeft);
                PB(str.substring(i2, i3).trim());
                if (i3 >= length) {
                    v.w("MicroMsg.CustomFitTextView", "not match last line, but match text length end");
                    break;
                }
                i2 = i3;
            }
        }
        return true;
    }

    private void PB(String str) {
        if (this.oRZ != null && str != null && !"".equals(str)) {
            this.oRZ.add(str);
        }
    }

    private int a(String str, int i, int i2, int i3, int i4) {
        if (i2 <= i) {
            return i + 1;
        }
        if (getPaint().measureText(str, i, i2) + ((float) i3) < ((float) i4)) {
            return i2;
        }
        int length = str.length();
        while (getPaint().measureText(str, i, i2) + ((float) i3) > ((float) i4)) {
            i2 = (i2 + i) >> 1;
        }
        while (i2 <= length && getPaint().measureText(str, i, i2) + ((float) i3) < ((float) i4)) {
            i2++;
        }
        int min = Math.min(length, i2) - 1;
        length = min;
        while (length >= 0 && be.i(str.charAt(length))) {
            length--;
        }
        if (length < 0 || length == min) {
            return i2 - 1;
        }
        return length + 1;
    }

    protected void onDraw(Canvas canvas) {
        if (this.oSd && this.oRX != null && !"".equals(this.oRX) && this.oRZ.size() != 0) {
            FontMetrics fontMetrics = getPaint().getFontMetrics();
            float f = fontMetrics.descent - fontMetrics.ascent;
            float paddingLeft = (float) getPaddingLeft();
            float paddingTop = (float) getPaddingTop();
            Iterator it = this.oRZ.iterator();
            float f2 = paddingTop;
            while (it.hasNext()) {
                float f3 = (fontMetrics.leading + f) + f2;
                canvas.drawText((String) it.next(), paddingLeft, f3, this.oRW);
                f2 = f3;
            }
            if (this.oSc) {
                getPaint().getTextBounds((String) this.oRZ.getLast(), 0, ((String) this.oRZ.getLast()).length(), this.oRY);
                int paddingLeft2 = getPaddingLeft() + this.oRY.right;
                int i = (int) ((f2 - f) - fontMetrics.leading);
                this.oSb.setBounds(paddingLeft2, i, this.oSb.getIntrinsicWidth() + paddingLeft2, this.oSb.getIntrinsicHeight() + i);
                this.oSb.draw(canvas);
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        boolean z = (i == i3 && i2 == i4) ? false : true;
        this.oSd = z;
        if (this.oSd) {
            cl(this.oRX, i);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = MeasureSpec.getSize(i);
        int fromDPToPix = a.fromDPToPix(getContext(), 32);
        if (cl(this.oRX, size)) {
            fromDPToPix = Math.max(bJl(), fromDPToPix);
        }
        setMeasuredDimension(size, fromDPToPix);
    }
}
