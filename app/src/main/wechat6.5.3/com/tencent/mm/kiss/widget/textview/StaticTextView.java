package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Point;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.kiss.widget.textview.a.a;

public class StaticTextView extends View implements a {
    protected g cmr = new g(this, vO());

    public StaticTextView(Context context) {
        super(context);
        this.cmr.init();
    }

    public StaticTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cmr.init();
    }

    public StaticTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cmr.init();
    }

    public final a vN() {
        if (this.cmr == null) {
            return null;
        }
        return this.cmr.cmt;
    }

    public a vO() {
        return new a();
    }

    public final void b(a aVar) {
        this.cmr.cmt = aVar;
    }

    public final void G(float f) {
        this.cmr.setTextSize(1, f);
    }

    public final void b(f fVar) {
        this.cmr.b(fVar);
    }

    public final void setTextColor(int i) {
        this.cmr.setTextColor(i);
    }

    public final void vP() {
        this.cmr.setGravity(16);
    }

    public void setMaxLines(int i) {
        this.cmr.setMaxLines(i);
    }

    public final void setText(CharSequence charSequence, boolean z) {
        this.cmr.setText(charSequence, z);
    }

    public void setText(CharSequence charSequence) {
        setText(charSequence, true);
    }

    public void setLayoutParams(LayoutParams layoutParams) {
        if (this.cmr != null) {
            this.cmr.vS();
        }
        super.setLayoutParams(layoutParams);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (this.cmr != null) {
            this.cmr.vS();
        }
        super.setPadding(i, i2, i3, i4);
    }

    public final CharSequence getText() {
        return this.cmr.getText();
    }

    public final float getTextSize() {
        return this.cmr.getTextSize();
    }

    public final Layout vQ() {
        return this.cmr.vQ();
    }

    public final f vR() {
        if (this.cmr == null) {
            return null;
        }
        return this.cmr.vR();
    }

    public final int getLineCount() {
        return this.cmr.getLineCount();
    }

    public final int getLineHeight() {
        return this.cmr.getLineHeight();
    }

    public void setClickable(boolean z) {
        super.setClickable(z);
        if (this.cmr != null) {
            this.cmr.cmz = z;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.cmr.vQ() == null) {
            return false;
        }
        boolean n = this.cmr.n(motionEvent);
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (n) {
            return true;
        }
        return onTouchEvent;
    }

    public boolean performClick() {
        if (this.cmr != null && this.cmr.performClick()) {
            return super.performClick();
        }
        return false;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.cmr != null) {
            this.cmr.onDraw(canvas);
        }
    }

    public final int vI() {
        if (this.cmr == null) {
            return 0;
        }
        return this.cmr.cmw;
    }

    public final int vJ() {
        if (this.cmr == null) {
            return 0;
        }
        return this.cmr.cmx;
    }

    public void onMeasure(int i, int i2) {
        if (this.cmr == null) {
            super.onMeasure(i, i2);
            return;
        }
        Point aB = this.cmr.aB(i, i2);
        if (aB != null) {
            setMeasuredDimension(aB.x, aB.y);
        } else {
            super.onMeasure(i, i2);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }
}
