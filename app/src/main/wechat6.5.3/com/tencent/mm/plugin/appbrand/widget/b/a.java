package com.tencent.mm.plugin.appbrand.widget.b;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mm.plugin.appbrand.ui.f;

public final class a extends e {
    private int dZc = -16777216;

    public static a bK(View view) {
        return (a) view.getRootView().findViewById(2131755017);
    }

    public a(Context context) {
        super(context);
        super.setId(2131755017);
        setBackgroundResource(2131689781);
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ a dZd;

            {
                this.dZd = r1;
            }

            public final void onClick(View view) {
                this.dZd.hide();
            }
        });
    }

    protected final void onMeasure(int i, int i2) {
        if (isShown()) {
            int i3;
            if (getParent() == null || !(getParent() instanceof ViewGroup)) {
                i3 = 0;
            } else {
                i3 = ((ViewGroup) getParent()).getMeasuredHeight();
            }
            if (i3 > 0) {
                bi(i, MeasureSpec.makeMeasureSpec(i3, 1073741824));
                return;
            }
        }
        super.onMeasure(i, i2);
    }

    public final void setId(int i) {
    }

    public final void show() {
        if (VERSION.SDK_INT >= 21 && (getContext() instanceof Activity)) {
            this.dZc = ((Activity) getContext()).getWindow().getStatusBarColor();
            ((Activity) getContext()).getWindow().setStatusBarColor(f.e(this.dZc, 0.5f));
        }
        super.show();
    }

    public final void hide() {
        if (VERSION.SDK_INT >= 21 && (getContext() instanceof Activity)) {
            ((Activity) getContext()).getWindow().setStatusBarColor(this.dZc);
        }
        super.hide();
    }
}
