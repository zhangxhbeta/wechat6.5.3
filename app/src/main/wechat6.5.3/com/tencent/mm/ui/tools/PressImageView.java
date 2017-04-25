package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.ac;
import junit.framework.Assert;

public class PressImageView extends ImageView {
    private int a = 90;
    private int b = 0;
    private int g = 0;
    private ac jDU = new ac();
    private Runnable jDV = new Runnable(this) {
        final /* synthetic */ PressImageView oUf;

        {
            this.oUf = r1;
        }

        public final void run() {
            this.oUf.setPressed(false);
            this.oUf.invalidate();
        }
    };
    private int r = 0;

    public PressImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ PressImageView oUf;

            {
                this.oUf = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        view.setPressed(true);
                        view.invalidate();
                        this.oUf.jDU.removeCallbacks(this.oUf.jDV);
                        break;
                    case 1:
                    case 3:
                        this.oUf.jDU.post(this.oUf.jDV);
                        break;
                }
                if (this.oUf.isClickable() || this.oUf.isLongClickable()) {
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
