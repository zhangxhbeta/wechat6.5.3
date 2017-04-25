package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.ui.base.preference.Preference;

public class DividerPreference extends Preference {
    private boolean hPP;
    private boolean hPQ;
    private boolean hPR;
    private View mView;

    public DividerPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mView = null;
        this.hPP = false;
        this.hPQ = false;
        this.hPR = true;
        setLayoutResource(2130903467);
    }

    public DividerPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        return this.mView;
    }

    protected final void onBindView(View view) {
        int i;
        super.onBindView(view);
        View findViewById = view.findViewById(2131756615);
        LayoutParams layoutParams = (LayoutParams) findViewById.getLayoutParams();
        int a = b.a(this.mContext, 10.0f);
        if (this.hPP) {
            i = a;
        } else {
            i = 0;
        }
        if (!this.hPQ) {
            a = 0;
        }
        layoutParams.setMargins(0, i, 0, a);
        findViewById.setLayoutParams(layoutParams);
        if (this.hPR) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(4);
        }
    }
}
