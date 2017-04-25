package com.tencent.mm.plugin.sight.encode.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.sight.encode.ui.MainContentImageView.a;
import com.tencent.mm.sdk.platformtools.v;

public class MainSightContainerBottomView extends FrameLayout implements AnimationListener, a {
    private static final boolean iXZ = d.dY(10);
    private int Ad = 0;
    private final String TAG = "MicroMsg.MainSightContainerBottomView";
    private boolean fAj = false;
    public MainContentImageView iXU;
    private float iXV;
    private Animation iXW;
    private int iXX;
    public MainSightContainerView iXY;
    private int iYa;
    private boolean iYb = false;
    private float xX;

    public MainSightContainerBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MainSightContainerBottomView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        v.d("MicroMsg.MainSightContainerBottomView", "ontouch: %s, x: %f y: %f", Integer.valueOf(motionEvent.getAction()), Float.valueOf(motionEvent.getRawX()), Float.valueOf(motionEvent.getRawY()));
        if (this.iXU == null) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.xX = motionEvent.getRawY();
                this.fAj = false;
                this.iYb = false;
                this.iXV = 0.0f;
                this.iXU.iXS = false;
                break;
            case 1:
                v.d("MicroMsg.MainSightContainerBottomView", "mDeltaY: %d, isScrollUp: %B, ACTION_UP", Integer.valueOf(this.Ad), Boolean.valueOf(this.iYb));
                if (this.iYb && this.Ad < -200) {
                    this.iXY.q(true, true);
                } else if (this.iXU.getVisibility() == 0) {
                    aQi();
                }
                this.fAj = false;
                this.iXV = 0.0f;
                this.iXU.iXS = false;
                break;
            case 2:
                float rawY = motionEvent.getRawY();
                if (this.xX == 0.0f) {
                    this.xX = rawY;
                }
                int i = (int) (this.xX - rawY);
                this.iYb = i >= 3;
                if (this.iYb || (i <= -5 && this.fAj && this.iXU.getTop() != 0)) {
                    if (!this.fAj) {
                        this.fAj = true;
                        this.iXV = rawY;
                    }
                    int i2 = (int) (((float) ((int) (rawY - this.iXV))) / 2.0f);
                    int i3 = this.iXX + i2;
                    i = (getBottom() + i2) + this.iXX;
                    this.Ad = i2;
                    v.d("MicroMsg.MainSightContainerBottomView", "mDeltaY: %d, top: %d, bottom: %d", Integer.valueOf(this.Ad), Integer.valueOf(i3), Integer.valueOf(i));
                    this.iYa = i3;
                    this.iXU.layout(this.iXU.getLeft(), i3, this.iXU.getRight(), i);
                }
                this.xX = motionEvent.getRawY();
                break;
            case 3:
                v.d("MicroMsg.MainSightContainerBottomView", "mDeltaY: %d, isScrollUp: %B, ACTION_CANCEL", Integer.valueOf(this.Ad), Boolean.valueOf(this.iYb));
                if (this.iXU.getVisibility() == 0) {
                    aQi();
                }
                this.fAj = false;
                this.iXV = 0.0f;
                this.iXU.iXS = false;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void aQi() {
        this.iXW = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) this.iYa);
        this.iXW.setDuration(300);
        this.iXW.setAnimationListener(this);
        this.iXU.startAnimation(this.iXW);
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        this.iXU.setVisibility(4);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public final void pF(final int i) {
        v.d("MicroMsg.MainSightContainerBottomView", "top : %d", Integer.valueOf(i));
        if (this.fAj && i != 0 && this.iXU.getVisibility() != 0) {
            postDelayed(new Runnable(this) {
                final /* synthetic */ MainSightContainerBottomView iYc;

                public final void run() {
                    if (this.iYc.fAj && i != 0 && this.iYc.iXU.getVisibility() != 0) {
                        v.d("MicroMsg.MainSightContainerBottomView", "change layout");
                        this.iYc.iXU.iXS = true;
                        this.iYc.iXU.setVisibility(0);
                    }
                }
            }, 50);
        }
    }
}
