package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.ui.base.preference.Preference;

public final class i extends Preference {
    private int hPS = Integer.MAX_VALUE;
    String hPT;
    private View mView = null;

    public i(Context context) {
        super(context);
        setLayoutResource(2130903938);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        return this.mView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(2131758083);
        ((TextView) view.findViewById(2131758082)).setText(getTitle());
        textView.setText(this.hPT);
        if (this.hPS != Integer.MAX_VALUE) {
            textView.setTextColor(this.hPS);
        }
    }

    public final void xG(String str) {
        try {
            this.hPS = Color.parseColor(str);
        } catch (Exception e) {
            this.hPS = -1;
        }
    }
}
