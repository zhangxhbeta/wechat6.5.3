package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;

public class PreferenceCategory extends Preference {
    public PreferenceCategory(Context context) {
        this(context, null);
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(2130903999);
    }
}
