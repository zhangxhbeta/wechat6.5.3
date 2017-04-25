package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.v;

public class MMTextView extends TextView {
    private boolean pdB = false;
    public a pdC = null;
    private GestureDetector pdD = null;

    public interface a {
        boolean c(View view, MotionEvent motionEvent);
    }

    public MMTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MMTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.pdD = new GestureDetector(getContext(), new SimpleOnGestureListener(this) {
            final /* synthetic */ MMTextView pdE;

            {
                this.pdE = r1;
            }

            public final boolean onDoubleTap(MotionEvent motionEvent) {
                if (this.pdE.pdC == null) {
                    return false;
                }
                return this.pdE.pdC.c(this.pdE, motionEvent);
            }
        });
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z = action == 1 && this.pdB;
        if (z) {
            v.d("MicroMsg.MMTextView", "ignore Action Up Event this time");
            return true;
        }
        boolean z2;
        if (action == 0) {
            this.pdB = false;
        }
        if (this.pdC == null || this.pdD == null) {
            z2 = false;
        } else {
            z2 = this.pdD.onTouchEvent(motionEvent);
        }
        if (z2) {
            return z2;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void cancelLongPress() {
        v.d("MicroMsg.MMTextView", "cancelLongPress , should ignore Action Up Event next time");
        this.pdB = true;
        super.cancelLongPress();
    }

    public boolean performLongClick() {
        v.d("MicroMsg.MMTextView", "performLongClick , should ignore Action Up Event next time");
        this.pdB = true;
        return super.performLongClick();
    }
}
