package com.tencent.mm.plugin.appbrand.page;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.smtt.sdk.WebView;

public class i extends FrameLayout {
    View Hq;
    private ObjectAnimator dOA = null;
    View dOq;
    FrameLayout dOr;
    FrameLayout dOs;
    private boolean dOt = true;
    boolean dOu = false;
    private boolean dOv = false;
    private boolean dOw = false;
    private int dOx;
    private int dOy;
    private int dOz;
    private int iD;

    public i(Context context) {
        super(context);
        setLayoutParams(new LayoutParams(-1, -1));
        this.iD = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public void setEnabled(boolean z) {
        this.dOt = !z;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.dOt) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            return false;
        }
        if (this.dOw) {
            return true;
        }
        switch (action) {
            case 0:
                if (!Rw()) {
                    return false;
                }
                this.dOx = (int) motionEvent.getX();
                this.dOy = (int) motionEvent.getY();
                this.dOz = (int) motionEvent.getY();
                return false;
            case 2:
                if (!Rw()) {
                    return false;
                }
                action = ((int) motionEvent.getX()) - this.dOx;
                int y = ((int) motionEvent.getY()) - this.dOy;
                if (Math.abs(y) <= this.iD || Math.abs(y) <= Math.abs(action) || y <= 0) {
                    return false;
                }
                this.dOw = true;
                return true;
            default:
                return false;
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.dOt) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.dOz = (int) motionEvent.getY();
                return true;
            case 1:
            case 3:
                if (this.dOs.getTranslationY() <= ((float) this.dOq.getHeight()) || !this.dOu) {
                    Rt();
                } else {
                    hk(Rx());
                    if (!this.dOv) {
                        Ru();
                    }
                    this.dOv = true;
                }
                return true;
            case 2:
                int y = (((int) motionEvent.getY()) - this.dOz) >> 1;
                int height = getHeight();
                if (y <= height) {
                    height = y;
                }
                if (this.dOv) {
                    height += Rx();
                }
                height = Math.max(height, 0);
                v.d("MicroMsg.AppBrandPullDownView", "real diff: %d, calc diff: %d", new Object[]{Integer.valueOf(r4), Integer.valueOf(height)});
                this.dOs.setTranslationY((float) Math.min(getHeight(), height));
                hj(height);
                return true;
            default:
                return false;
        }
    }

    protected final void Rt() {
        hk(0);
        if (this.dOv) {
            Rv();
        }
        this.dOw = false;
        this.dOv = false;
    }

    protected void Ru() {
    }

    protected void Rv() {
    }

    protected void hj(int i) {
    }

    private boolean Rw() {
        if (!(this.Hq instanceof WebView)) {
            return this.Hq.getScrollY() == 0;
        } else {
            if (((WebView) this.Hq).getView().getScrollY() == 0) {
                return true;
            }
            return false;
        }
    }

    protected int Rx() {
        return this.dOq.getHeight();
    }

    private void hk(int i) {
        int translationY = (int) this.dOs.getTranslationY();
        if (translationY != i) {
            v.i("MicroMsg.AppBrandPullDownView", "fastScrollTo from = %s, to = %s", new Object[]{Integer.valueOf(translationY), Integer.valueOf(i)});
            if (this.dOA != null) {
                this.dOA.cancel();
            }
            long abs = (long) ((((float) Math.abs(translationY - i)) / ((float) Rx())) * 250.0f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dOs, "translationY", new float[]{(float) translationY, (float) i});
            ofFloat.setDuration(Math.min(abs, 250));
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.start();
            ofFloat.addUpdateListener(new AnimatorUpdateListener(this) {
                final /* synthetic */ i dOB;

                {
                    this.dOB = r1;
                }

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.dOB.hj((int) ((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            this.dOA = ofFloat;
        }
    }
}
