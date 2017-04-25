package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.ui.base.preference.Preference;

public final class h extends Preference {
    boolean hPP = false;
    boolean hPQ = false;
    boolean hPR = true;
    private View mView = null;

    public h(Context context) {
        super(context);
        setLayoutResource(2130903937);
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
        View findViewById = view.findViewById(2131758081);
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
