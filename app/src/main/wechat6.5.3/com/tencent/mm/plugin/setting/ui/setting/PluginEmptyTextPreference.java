package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.ui.base.preference.Preference;

public final class PluginEmptyTextPreference extends Preference {
    private Context context;
    private TextView eRp;
    private String text;

    public PluginEmptyTextPreference(Context context) {
        this(context, null, 0);
        this.text = context.getString(2131235096);
    }

    public PluginEmptyTextPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eRp = null;
        this.context = context;
        setLayoutResource(2130904161);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        View.inflate(this.context, 2130904161, null);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.eRp = (TextView) view.findViewById(2131755442);
        this.eRp.setText(this.text);
    }
}
