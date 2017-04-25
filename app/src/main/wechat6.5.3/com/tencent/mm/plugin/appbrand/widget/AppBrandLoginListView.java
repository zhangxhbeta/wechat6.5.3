package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ListView;

public class AppBrandLoginListView extends ListView {
    public int Tr;

    public AppBrandLoginListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public AppBrandLoginListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        if (this.Tr <= 5) {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        } else {
            super.onMeasure(i, i2);
        }
    }
}
