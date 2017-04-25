package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.ui.tools.r;

public class IconSwitchKeyValuePreference extends IconPreference {
    private TextView hWl;
    private int status;

    public IconSwitchKeyValuePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconSwitchKeyValuePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.status = 0;
    }

    public final void onBindView(View view) {
        super.onBindView(view);
        this.hWl = (TextView) view.findViewById(16908304);
        av();
    }

    public final void wN(int i) {
        this.status = i;
        av();
    }

    private void av() {
        if (this.hWl != null) {
            int a = b.a(this.mContext, 2.0f);
            this.hWl.setTextColor(r.eM(this.mContext));
            if (this.status == 0) {
                this.hWl.setCompoundDrawablesWithIntrinsicBounds(2131165961, 0, 0, 0);
                this.hWl.setCompoundDrawablePadding(a);
            } else if (this.status == 1) {
                this.hWl.setCompoundDrawablesWithIntrinsicBounds(2131165959, 0, 0, 0);
                this.hWl.setCompoundDrawablePadding(a);
            } else if (this.status == 2) {
                this.hWl.setCompoundDrawablesWithIntrinsicBounds(2131165960, 0, 0, 0);
                this.hWl.setCompoundDrawablePadding(a);
            } else {
                this.hWl.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        }
    }
}
