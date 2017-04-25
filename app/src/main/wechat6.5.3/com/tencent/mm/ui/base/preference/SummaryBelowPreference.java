package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;

public class SummaryBelowPreference extends Preference {
    public SummaryBelowPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SummaryBelowPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(2130904066);
    }
}
