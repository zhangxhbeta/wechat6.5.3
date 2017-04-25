package com.tencent.mm.plugin.appbrand.widget.input;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.ui.f;
import com.tencent.mm.plugin.appbrand.widget.a.a;
import com.tencent.mm.plugin.appbrand.widget.a.b;

@SuppressLint({"ViewConstructor"})
public final class d extends FrameLayout {
    private final OnGlobalLayoutListener SV = new OnGlobalLayoutListener(this) {
        final /* synthetic */ d dXN;

        {
            this.dXN = r1;
        }

        public final void onGlobalLayout() {
        }
    };
    private View dXB;
    private View dXC;
    private View dXD;
    int dXE = -1;
    private boolean dXF;
    private final int[] dXG = new int[2];
    public b dXH;
    public a dXI;
    private final Runnable dXJ = new Runnable(this) {
        final /* synthetic */ d dXN;

        {
            this.dXN = r1;
        }

        public final void run() {
            int i = 0;
            int[] a = this.dXN.dXK;
            this.dXN.dXK[1] = 0;
            a[0] = 0;
            if (this.dXN.dXB != null) {
                this.dXN.dXB.getLocationOnScreen(this.dXN.dXK);
                int i2 = this.dXN.dXK[1];
                int i3 = this.dXN.dXK[0];
                if (!(i3 == this.dXN.dXL && i2 == this.dXN.dXM)) {
                    i = 1;
                }
                if (i != 0 && this.dXN.dXH != null) {
                    this.dXN.dXH.hE(i2);
                    this.dXN.dXL = i3;
                    this.dXN.dXM = i2;
                }
            }
        }
    };
    private final int[] dXK = new int[2];
    private int dXL = 0;
    private int dXM = 0;

    public static d bF(View view) {
        return (d) view.getRootView().findViewById(2131755019);
    }

    public d(Context context, View view, View view2) {
        super(context);
        super.setId(2131755019);
        this.dXB = view;
        this.dXD = view2;
        super.addView(view2);
    }

    protected final void onMeasure(int i, int i2) {
        if (this.dXE > 0) {
            i2 = MeasureSpec.makeMeasureSpec(this.dXE, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 1 || this.dXC == null || !this.dXC.isShown()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.dXC.setVisibility(8);
        return true;
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.dXF && this.dXC != null && this.dXC.isShown() && motionEvent.getAction() == 0) {
            float rawY = motionEvent.getRawY();
            this.dXC.getLocationOnScreen(this.dXG);
            float f = (float) this.dXG[1];
            float height = ((float) this.dXC.getHeight()) + f;
            if (rawY < f || rawY > height) {
                this.dXC.setVisibility(8);
                return true;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void setId(int i) {
    }

    public final void addView(View view) {
        if (view == this.dXD || view == this.dXC) {
            super.addView(view);
        }
    }

    public final void addView(View view, int i) {
        if (view == this.dXD || view == this.dXC) {
            super.addView(view, i);
        }
    }

    public final void addView(View view, int i, int i2) {
        if (view == this.dXD || view == this.dXC) {
            super.addView(view, i, i2);
        }
    }

    public final void addView(View view, LayoutParams layoutParams) {
        if (view == this.dXD || view == this.dXC) {
            super.addView(view, layoutParams);
        }
    }

    public final void addView(View view, int i, LayoutParams layoutParams) {
        if (view == this.dXD || view == this.dXC) {
            super.addView(view, i, layoutParams);
        }
    }

    protected final boolean addViewInLayout(View view, int i, LayoutParams layoutParams) {
        return false;
    }

    protected final boolean addViewInLayout(View view, int i, LayoutParams layoutParams, boolean z) {
        return false;
    }

    public final void g(View view, boolean z) {
        if (this.dXC != null) {
            this.dXC.setVisibility(8);
            this.dXC = null;
        }
        this.dXC = view;
        this.dXF = z;
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        super.addView(view, layoutParams);
    }

    public final void bG(View view) {
        g(view, false);
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.dXI != null) {
            this.dXI.bH(this);
        }
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getViewTreeObserver() != null) {
            getViewTreeObserver().addOnGlobalLayoutListener(this.SV);
        }
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (getViewTreeObserver() != null) {
            f.a((View) this, this.SV);
        }
    }
}
