package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import junit.framework.Assert;

public class TouchImageView extends ImageView {
    private int a = 90;
    private boolean aZw = true;
    private int b = 0;
    private int g = 0;
    ac jDU;
    Runnable jDV;
    private Rect jZw = new Rect();
    private Paint jZx = new Paint();
    private int r = 0;

    public TouchImageView(Context context) {
        super(context);
        init();
    }

    public TouchImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.jDU = new ac();
        this.jDV = new Runnable(this) {
            final /* synthetic */ TouchImageView jZy;

            {
                this.jZy = r1;
            }

            public final void run() {
                this.jZy.setPressed(false);
                this.jZy.invalidate();
            }
        };
        super.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ TouchImageView jZy;

            {
                this.jZy = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (!this.jZy.aZw) {
                    return false;
                }
                TouchImageView touchImageView = this.jZy;
                switch (motionEvent.getAction()) {
                    case 0:
                        view.setPressed(true);
                        view.invalidate();
                        touchImageView.jDU.removeCallbacks(touchImageView.jDV);
                        break;
                    case 1:
                    case 3:
                        touchImageView.jDU.post(touchImageView.jDV);
                        break;
                }
                if (touchImageView.isClickable() || touchImageView.isLongClickable()) {
                    return false;
                }
                return true;
            }
        });
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isPressed()) {
            this.jZw.left = getPaddingLeft();
            this.jZw.top = getPaddingTop();
            this.jZw.right = getWidth() - getPaddingRight();
            this.jZw.bottom = getHeight() - getPaddingBottom();
            this.jZx.setARGB(this.a, this.r, this.g, this.b);
            canvas.drawRect(this.jZw, this.jZx);
        }
    }

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
