package com.tencent.mm.plugin.appbrand.widget.input;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.page.l;
import com.tencent.mm.sdk.platformtools.v;

@SuppressLint({"ViewConstructor"})
public final class b extends FrameLayout implements com.tencent.mm.plugin.appbrand.page.j.b, com.tencent.mm.plugin.appbrand.page.l.b {
    AbsoluteLayout dWA;

    public interface a {
        boolean SK();
    }

    public b(Context context, l lVar) {
        super(context);
        if (lVar != null) {
            lVar.dOP = this;
        }
        this.dWA = new AbsoluteLayout(context);
        addView(this.dWA);
    }

    public final boolean a(l lVar, View view, int i, int i2, int i3, int i4) {
        if (lVar == null || lVar.getView() == null || view == null) {
            return false;
        }
        j(lVar);
        if ((view instanceof a) && ((a) view).SK()) {
            LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i2);
            layoutParams.leftMargin = i3 - lVar.getScrollX();
            layoutParams.topMargin = i4 - lVar.getScrollY();
            layoutParams.bottomMargin = 0;
            layoutParams.rightMargin = 0;
            addView(view, layoutParams);
            return true;
        }
        this.dWA.addView(view, new AbsoluteLayout.LayoutParams(i, i2, i3, i4));
        return true;
    }

    final void j(l lVar) {
        AbsoluteLayout absoluteLayout = (AbsoluteLayout) lVar.getView();
        if (!(this.dWA.getWidth() == absoluteLayout.getWidth() && this.dWA.getHeight() == absoluteLayout.getHeight())) {
            LayoutParams layoutParams = this.dWA.getLayoutParams();
            layoutParams.width = absoluteLayout.getWidth();
            layoutParams.height = absoluteLayout.getHeight();
            this.dWA.setLayoutParams(layoutParams);
        }
        if (this.dWA.getScrollX() != absoluteLayout.getScrollX() || this.dWA.getScrollY() != absoluteLayout.getScrollY()) {
            this.dWA.scrollTo(absoluteLayout.getScrollX(), absoluteLayout.getScrollY());
        }
    }

    final boolean bC(View view) {
        for (int i = 1; i < getChildCount(); i++) {
            if (view == getChildAt(i)) {
                return true;
            }
        }
        return false;
    }

    public final void bD(View view) {
        if (view != null) {
            view.setVisibility(8);
            this.dWA.removeView(view);
        }
    }

    public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
        v.v("MicroMsg.AppBrandInputContainer", "onScrollChanged, left = %d, top = %d, oldLeft = %d, oldTop = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        if (this.dWA != null) {
            LayoutParams layoutParams = this.dWA.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LayoutParams(view.getWidth(), view.getHeight());
                this.dWA.setLayoutParams(layoutParams);
            }
            if (!(view.getWidth() == layoutParams.width && view.getHeight() == layoutParams.height)) {
                layoutParams.width = view.getWidth();
                layoutParams.height = view.getHeight();
                this.dWA.setLayoutParams(layoutParams);
            }
            this.dWA.scrollTo(i, i2);
        }
    }

    public final void hl(int i) {
        setTranslationY((float) i);
    }
}
