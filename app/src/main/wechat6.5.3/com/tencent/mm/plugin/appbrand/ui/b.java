package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.tencent.mm.ui.MMActivity;

abstract class b extends MMActivity {
    private int dZc = 0;
    private FrameLayout lqA = null;

    b() {
    }

    static /* synthetic */ boolean a(b bVar, WindowInsets windowInsets) {
        if (windowInsets == null || bVar.lqA == null) {
            return false;
        }
        int systemWindowInsetTop = windowInsets.getSystemWindowInsetTop();
        if (systemWindowInsetTop <= 0) {
            return false;
        }
        View childAt = bVar.lqA.getChildAt(1);
        if (childAt.getLayoutParams() == null || !(childAt.getLayoutParams() instanceof MarginLayoutParams)) {
            return false;
        }
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) childAt.getLayoutParams();
        if (marginLayoutParams.topMargin != systemWindowInsetTop) {
            marginLayoutParams.topMargin = systemWindowInsetTop;
            childAt.setLayoutParams(marginLayoutParams);
        }
        View childAt2 = bVar.lqA.getChildAt(0);
        LayoutParams layoutParams = childAt2.getLayoutParams();
        if (layoutParams == null) {
            return false;
        }
        if (layoutParams.height != systemWindowInsetTop) {
            layoutParams.height = systemWindowInsetTop;
            childAt2.setLayoutParams(layoutParams);
        }
        int statusBarColor = bVar.getStatusBarColor();
        if (statusBarColor != bVar.dZc) {
            bVar.getWindow().setStatusBarColor(0);
            bVar.lqA.getChildAt(0).setBackgroundColor(statusBarColor);
            bVar.dZc = statusBarColor;
        }
        return true;
    }

    protected void PK() {
        super.PK();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (VERSION.SDK_INT < 21 || this.lqA == null) {
            getWindow().getDecorView().setFitsSystemWindows(true);
        } else {
            ((ViewGroup) getWindow().getDecorView()).getChildAt(0).setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener(this) {
                final /* synthetic */ b dQz;

                {
                    this.dQz = r1;
                }

                @TargetApi(20)
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    b.a(this.dQz, windowInsets);
                    return windowInsets.consumeSystemWindowInsets();
                }
            });
        }
    }

    protected final void bRC() {
        super.bRC();
        if (this.nFw != null && this.nFw.getChildCount() > 0) {
            View childAt = this.nFw.getChildAt(0);
            this.nFw.removeView(childAt);
            View view = new View(this);
            this.lqA = new FrameLayout(this);
            this.lqA.addView(view, new FrameLayout.LayoutParams(-1, 0));
            this.lqA.addView(childAt, new FrameLayout.LayoutParams(-1, -1));
            this.nFw.addView(this.lqA);
            this.nFw.Hq = this.lqA;
        }
    }

    protected int getStatusBarColor() {
        return getResources().getColor(2131690051);
    }
}
