package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;

public class SightRangeWidget extends RangeWidget {
    public SightRangeWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SightRangeWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected final int getLayoutResource() {
        return 2130904405;
    }

    protected final int aWk() {
        return 10;
    }

    public final boolean a(int i, int i2, Intent intent, AtContactWidget atContactWidget) {
        super.a(i, i2, intent, atContactWidget);
        if (atContactWidget != null) {
            if (this.jJq == 1) {
                atContactWidget.setVisibility(4);
                atContactWidget.aVq();
            } else {
                atContactWidget.setVisibility(0);
            }
        }
        return true;
    }
}
