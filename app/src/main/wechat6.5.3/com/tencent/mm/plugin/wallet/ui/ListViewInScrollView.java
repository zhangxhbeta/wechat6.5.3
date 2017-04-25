package com.tencent.mm.plugin.wallet.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ListView;

public class ListViewInScrollView extends ListView {
    public ListViewInScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ListViewInScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }
}
