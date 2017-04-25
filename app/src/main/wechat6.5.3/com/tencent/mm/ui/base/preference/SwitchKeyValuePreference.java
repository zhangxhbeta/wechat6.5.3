package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ui.tools.r;

public class SwitchKeyValuePreference extends Preference {
    public boolean aZw;
    private TextView hWl;

    public SwitchKeyValuePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwitchKeyValuePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aZw = true;
        setLayoutResource(2130903996);
    }

    public final void onBindView(View view) {
        super.onBindView(view);
        this.hWl = (TextView) view.findViewById(16908304);
        av();
    }

    public final void av() {
        if (this.hWl != null) {
            if (this.aZw) {
                this.hWl.setTextColor(r.eL(this.mContext));
            } else {
                this.hWl.setTextColor(r.eM(this.mContext));
            }
        }
    }
}
