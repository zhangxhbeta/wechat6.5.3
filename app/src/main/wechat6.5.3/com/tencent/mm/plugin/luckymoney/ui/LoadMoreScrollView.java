package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.tencent.mm.sdk.platformtools.v;

public class LoadMoreScrollView extends ScrollView {
    public LoadMoreScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public LoadMoreScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        v.v("MicroMsg.LoadMoreScrollView", i + ", " + i2 + ", " + z + ", " + z2 + ", " + getScrollY());
        super.onOverScrolled(i, i2, z, z2);
    }
}
