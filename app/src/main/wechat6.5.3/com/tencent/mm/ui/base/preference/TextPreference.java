package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TextPreference extends Preference {
    private Context context;
    private String dVK;
    private TextView kG;
    private int tD;

    public TextPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        setLayoutResource(2130904048);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        return super.onCreateView(viewGroup);
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.kG = (TextView) view.findViewById(16908310);
        if (this.kG != null) {
            this.kG.setText(this.dVK);
            this.kG.setGravity(this.tD);
        }
    }
}
