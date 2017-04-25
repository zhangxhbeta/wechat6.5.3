package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.text.Selection;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStructure;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.lang.reflect.Field;

public class SysTextView extends TextView implements a {
    private static boolean cmF = false;
    private static Field cmG = null;
    public g cmr = new g(this, new a());

    public SysTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SysTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        super.setText(" ", BufferType.SPANNABLE);
        this.cmr.cmt = new a();
        this.cmr.cmt.textColor = super.getTextColors().getDefaultColor();
        this.cmr.cmt.cmf = super.getEllipsize();
        this.cmr.cmt.gravity = super.getGravity();
        this.cmr.cmt.cmK = super.getTextSize();
        if (!cmF) {
            try {
                if (cmG == null) {
                    Field declaredField = TextView.class.getDeclaredField("mSingleLine");
                    cmG = declaredField;
                    declaredField.setAccessible(true);
                }
                if (cmG.getBoolean(this)) {
                    this.cmr.cmt.maxLines = 1;
                }
            } catch (Exception e) {
                v.e("MicroMsg.SysPLTextView", "initSingleLine error: %s", e.getMessage());
                cmF = true;
            }
        }
    }

    protected final f vR() {
        if (this.cmr == null) {
            return null;
        }
        return this.cmr.vR();
    }

    public final a vN() {
        if (this.cmr == null) {
            return null;
        }
        return this.cmr.cmt;
    }

    public void setSingleLine(boolean z) {
        if (this.cmr != null) {
            this.cmr.setSingleLine(z);
        }
    }

    public void setLines(int i) {
        if (this.cmr != null) {
            this.cmr.setLines(i);
        }
    }

    public boolean onPreDraw() {
        return true;
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        q(charSequence);
    }

    public final void q(CharSequence charSequence) {
        if (this.cmr == null) {
            super.setText(SQLiteDatabase.KeyEmpty);
        } else {
            this.cmr.setText(charSequence, false);
        }
    }

    public void setTextSize(float f) {
        setTextSize(0, f);
    }

    public void setTextSize(int i, float f) {
        if (this.cmr != null) {
            this.cmr.setTextSize(i, f);
        }
    }

    public void setTextColor(int i) {
        if (this.cmr != null) {
            this.cmr.setTextColor(i);
        }
    }

    public void setGravity(int i) {
        if (this.cmr != null) {
            this.cmr.setGravity(i);
        }
    }

    public void setMaxLines(int i) {
        if (this.cmr != null) {
            this.cmr.setMaxLines(i);
        }
    }

    public void setMinLines(int i) {
        if (this.cmr != null) {
            g gVar = this.cmr;
            if (gVar.cmt.minLines != i) {
                gVar.cmt.minLines = i;
                gVar.vS();
                gVar.cmC.requestLayout();
                gVar.cmC.invalidate();
            }
        }
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

    public CharSequence getText() {
        if (this.cmr == null) {
            return null;
        }
        return this.cmr.getText();
    }

    public float getTextSize() {
        if (this.cmr == null) {
            return 0.0f;
        }
        return this.cmr.getTextSize();
    }

    public int getLineCount() {
        if (this.cmr == null) {
            return 0;
        }
        return this.cmr.getLineCount();
    }

    public int getLineHeight() {
        if (this.cmr == null) {
            return 0;
        }
        return this.cmr.getLineHeight();
    }

    public int getSelectionStart() {
        if (getText() == null) {
            return -1;
        }
        return Selection.getSelectionStart(getText());
    }

    public int getSelectionEnd() {
        if (getText() == null) {
            return -1;
        }
        return Selection.getSelectionEnd(getText());
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

    protected void onMeasure(int i, int i2) {
        Point aB = this.cmr.aB(i, i2);
        if (aB != null) {
            setMeasuredDimension(aB.x, aB.y);
            return;
        }
        try {
            super.onMeasure(i, i2);
        } catch (Throwable e) {
            v.a("MicroMsg.SysPLTextView", e, "onMeasure error: %s", e.getMessage());
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

    public void onHoverChanged(boolean z) {
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        return false;
    }

    public void onProvideStructure(ViewStructure viewStructure) {
        try {
            super.onProvideStructure(viewStructure);
        } catch (Throwable e) {
            v.a("MicroMsg.SysPLTextView", e, "onProvideStructure error: %s", e.getMessage());
        }
    }

    public void dispatchProvideStructure(ViewStructure viewStructure) {
    }
}
