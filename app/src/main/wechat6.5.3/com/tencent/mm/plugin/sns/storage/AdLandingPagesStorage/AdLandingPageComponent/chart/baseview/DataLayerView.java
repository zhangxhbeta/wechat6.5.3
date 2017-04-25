package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.baseview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;

public abstract class DataLayerView extends View {
    public abstract int aTB();

    public abstract int aTC();

    public DataLayerView(Context context) {
        super(context);
    }

    public DataLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DataLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onMeasure(int i, int i2) {
        MeasureSpec.getMode(i);
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        switch (mode) {
            case Integer.MIN_VALUE:
                size = getSuggestedMinimumWidth();
                break;
            case 0:
                size = aTC();
                break;
        }
        int mode2 = MeasureSpec.getMode(i2);
        mode = MeasureSpec.getSize(i2);
        switch (mode2) {
            case Integer.MIN_VALUE:
                mode = getSuggestedMinimumHeight();
                break;
            case 0:
                mode = aTB();
                break;
        }
        setMeasuredDimension(size, mode);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }
}
