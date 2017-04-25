package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.bd.a;
import com.tencent.mm.ui.base.preference.KeyValuePreference;

public class VcardContactLinkPreference extends KeyValuePreference {
    public VcardContactLinkPreference(Context context) {
        super(context);
    }

    public VcardContactLinkPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VcardContactLinkPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        return super.onCreateView(viewGroup);
    }

    public final void onBindView(View view) {
        super.onBindView(view);
        ((TextView) view.findViewById(16908304)).setTextColor(a.b(this.mContext, 2131689638));
    }
}
