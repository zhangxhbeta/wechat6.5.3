package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.v;

public class MMVisiblePasswordEditText extends EditText {
    public String dXe = "";
    final Drawable nZF = getResources().getDrawable(2131165649);
    final Drawable nZG = getResources().getDrawable(2131165650);
    private boolean nZH = false;

    public MMVisiblePasswordEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bqy();
    }

    public MMVisiblePasswordEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bqy();
    }

    private void bqy() {
        this.nZF.setBounds(0, 0, this.nZF.getIntrinsicWidth(), this.nZF.getIntrinsicHeight());
        this.nZG.setBounds(0, 0, this.nZG.getIntrinsicWidth(), this.nZG.getIntrinsicHeight());
        v.d("MicroMsg.MMVisiblePasswordEditText", "closeEye width %d height %d", new Object[]{Integer.valueOf(this.nZF.getIntrinsicWidth()), Integer.valueOf(this.nZF.getIntrinsicHeight())});
        bCK();
        setHeight(this.nZF.getIntrinsicHeight() + (getResources().getDimensionPixelSize(2131493170) * 5));
        setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ MMVisiblePasswordEditText nZI;

            {
                this.nZI = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z = true;
                MMVisiblePasswordEditText mMVisiblePasswordEditText = this.nZI;
                if (mMVisiblePasswordEditText.getCompoundDrawables()[2] != null && motionEvent.getAction() == 1 && motionEvent.getX() > ((float) ((mMVisiblePasswordEditText.getWidth() - mMVisiblePasswordEditText.getPaddingRight()) - this.nZI.nZF.getIntrinsicWidth()))) {
                    mMVisiblePasswordEditText = this.nZI;
                    if (this.nZI.nZH) {
                        z = false;
                    }
                    mMVisiblePasswordEditText.nZH = z;
                    this.nZI.bCK();
                }
                return false;
            }
        });
    }

    private void bCK() {
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        if (this.nZH) {
            setInputType(1);
            setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.nZG, getCompoundDrawables()[3]);
        } else {
            setInputType(129);
            setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.nZF, getCompoundDrawables()[3]);
        }
        setSelection(selectionStart, selectionEnd);
    }
}
