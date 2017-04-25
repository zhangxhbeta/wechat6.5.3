package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.ui.base.preference.Preference;

public final class e extends Preference {
    public String hPB;
    public OnClickListener mOnClickListener = null;
    private View mView = null;

    public e(Context context) {
        super(context);
        setLayoutResource(2130903933);
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
        TextView textView = (TextView) view.findViewById(2131758062);
        textView.setText(this.hPB);
        textView.setOnClickListener(this.mOnClickListener);
    }
}
