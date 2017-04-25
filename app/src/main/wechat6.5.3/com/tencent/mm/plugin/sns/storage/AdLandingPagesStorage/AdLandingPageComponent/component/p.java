package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;

public final class p extends j {
    FrameLayout jyT;
    MMWebView jyU;

    public p(Context context, q qVar, ViewGroup viewGroup) {
        super(context, qVar, viewGroup);
    }

    protected final void aTS() {
        WindowManager windowManager = (WindowManager) this.context.getSystemService("window");
        int width = windowManager.getDefaultDisplay().getWidth();
        int height = windowManager.getDefaultDisplay().getHeight();
        this.jyU.setVerticalScrollBarEnabled(false);
        this.jyU.setHorizontalScrollBarEnabled(false);
        this.jyU.getSettings().setJavaScriptEnabled(true);
        this.jyU.loadUrl(((q) this.jxU).gxI);
        this.jyU.setLayoutParams(new LayoutParams(-1, -1));
        this.jyU.setVisibility(0);
        this.jyT.setPadding(this.jyT.getPaddingLeft(), (int) ((q) this.jxU).jvI, this.jyT.getPaddingRight(), (int) ((q) this.jxU).jvJ);
        this.jyT.setLayoutParams(new LinearLayout.LayoutParams(width, height));
    }

    public final View aTM() {
        this.jyT = (FrameLayout) this.dtW;
        this.jyU = a.eP(this.context);
        this.jyT.addView(this.jyU);
        return this.jyT;
    }

    protected final int aGY() {
        return Integer.MAX_VALUE;
    }

    protected final View aTT() {
        return new FrameLayout(this.context);
    }
}
