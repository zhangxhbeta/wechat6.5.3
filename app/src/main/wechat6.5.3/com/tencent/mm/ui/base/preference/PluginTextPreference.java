package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;

public final class PluginTextPreference extends Preference {
    private TextView eRp;
    private ImageView hWm;
    public int odt;
    private String text;
    private int textColor;
    public int visibility;

    public PluginTextPreference(Context context) {
        this(context, null);
    }

    public PluginTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PluginTextPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hWm = null;
        this.eRp = null;
        setLayoutResource(2130904026);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.b.aPw);
        this.odt = obtainStyledAttributes.getResourceId(0, 0);
        this.text = obtainStyledAttributes.getString(1);
        this.textColor = obtainStyledAttributes.getColor(2, -7039852);
        obtainStyledAttributes.recycle();
    }

    public final void wP(int i) {
        this.text = this.mContext.getString(i);
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.hWm = (ImageView) view.findViewById(2131756901);
        this.hWm.setImageResource(this.odt);
        this.hWm.setVisibility(this.visibility);
        this.eRp = (TextView) view.findViewById(2131755460);
        this.eRp.setText(this.text);
        this.eRp.setTextColor(this.textColor);
    }
}
