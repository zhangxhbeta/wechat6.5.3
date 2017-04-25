package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;

public class SightLocationWidget extends LocationWidget {
    public SightLocationWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SightLocationWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected final int aVL() {
        return 2131165922;
    }

    protected final int aVM() {
        return 2131165923;
    }

    protected final int getLayoutResource() {
        return 2130904402;
    }
}
