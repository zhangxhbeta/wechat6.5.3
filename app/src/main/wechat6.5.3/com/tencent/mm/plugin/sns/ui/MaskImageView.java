package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.ac;
import junit.framework.Assert;

public class MaskImageView extends TagImageView {
    private int a = 90;
    boolean aZw = true;
    private int b = 0;
    private int g = 0;
    private ac jDU = new ac(Looper.getMainLooper());
    private Runnable jDV = new Runnable(this) {
        final /* synthetic */ MaskImageView jHd;

        {
            this.jHd = r1;
        }

        public final void run() {
            this.jHd.setPressed(false);
            this.jHd.invalidate();
        }
    };
    private int r = 0;

    public MaskImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ MaskImageView jHd;

            {
                this.jHd = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (this.jHd.aZw) {
                    return this.jHd.b(view, motionEvent);
                }
                return false;
            }
        });
        super.setContentDescription(getContext().getResources().getString(2131235432));
    }

    public final boolean b(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                view.setPressed(true);
                view.invalidate();
                this.jDU.removeCallbacks(this.jDV);
                break;
            case 1:
            case 3:
                this.jDU.post(this.jDV);
                break;
        }
        if (isClickable() || isLongClickable()) {
            return false;
        }
        return true;
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

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
