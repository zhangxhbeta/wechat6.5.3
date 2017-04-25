package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import junit.framework.Assert;

public class AsyncMaskImageView extends ImageView {
    private int a = 90;
    private boolean aZw = true;
    private int b = 0;
    private int g = 0;
    ac jDU = new ac();
    Runnable jDV = new Runnable(this) {
        final /* synthetic */ AsyncMaskImageView jDW;

        {
            this.jDW = r1;
        }

        public final void run() {
            this.jDW.setPressed(false);
            this.jDW.invalidate();
        }
    };
    private int r = 0;

    public AsyncMaskImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ AsyncMaskImageView jDW;

            {
                this.jDW = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (!this.jDW.aZw) {
                    return false;
                }
                AsyncMaskImageView asyncMaskImageView = this.jDW;
                switch (motionEvent.getAction()) {
                    case 0:
                        view.setPressed(true);
                        view.invalidate();
                        asyncMaskImageView.jDU.removeCallbacks(asyncMaskImageView.jDV);
                        break;
                    case 1:
                    case 3:
                        asyncMaskImageView.jDU.post(asyncMaskImageView.jDV);
                        break;
                }
                if (asyncMaskImageView.isClickable() || asyncMaskImageView.isLongClickable()) {
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

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        v.d("MicroMsg.MaskImageView", "onAttachedToWindow");
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        v.d("MicroMsg.MaskImageView", "onDetachedFromWindow");
    }
}
