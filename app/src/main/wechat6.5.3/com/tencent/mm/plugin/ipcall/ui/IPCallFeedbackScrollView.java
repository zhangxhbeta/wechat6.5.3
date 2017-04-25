package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View.MeasureSpec;
import android.widget.ScrollView;
import com.tencent.mm.sdk.platformtools.v;

public class IPCallFeedbackScrollView extends ScrollView {
    public IPCallFeedbackScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public IPCallFeedbackScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onMeasure(int i, int i2) {
        try {
            Display defaultDisplay = ((Activity) getContext()).getWindowManager().getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            i2 = MeasureSpec.makeMeasureSpec(displayMetrics.heightPixels / 2, Integer.MIN_VALUE);
        } catch (Throwable e) {
            v.a("MicroMsg.IPCallFeedbackScrollView", e, "", new Object[0]);
        }
        super.onMeasure(i, i2);
    }
}
