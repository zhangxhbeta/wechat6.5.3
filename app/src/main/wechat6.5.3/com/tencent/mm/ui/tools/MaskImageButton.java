package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import com.tencent.mm.sdk.platformtools.ac;
import junit.framework.Assert;

public class MaskImageButton extends ImageButton {
    private int a = 90;
    private int b = 0;
    private int g = 0;
    private ac jDU = new ac(Looper.getMainLooper());
    private Runnable jDV = new Runnable(this) {
        final /* synthetic */ MaskImageButton oTQ;

        {
            this.oTQ = r1;
        }

        public final void run() {
            this.oTQ.setPressed(false);
            this.oTQ.invalidate();
        }
    };
    public Object oTP;
    private int r = 0;

    public MaskImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ MaskImageButton oTQ;

            {
                this.oTQ = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        view.setPressed(true);
                        view.invalidate();
                        this.oTQ.jDU.removeCallbacks(this.oTQ.jDV);
                        break;
                    case 1:
                    case 3:
                        this.oTQ.jDU.post(this.oTQ.jDV);
                        break;
                }
                if (this.oTQ.isClickable() || this.oTQ.isLongClickable()) {
                    return false;
                }
                return true;
            }
        });
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isPressed()) {
            canvas.drawARGB(this.a, this.r, this.g, this.b);
        }
    }

    @Deprecated
    public void setOnTouchListener(OnTouchListener onTouchListener) {
        Assert.assertTrue(false);
    }
}
