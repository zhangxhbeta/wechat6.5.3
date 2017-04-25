package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.plugin.game.c.e;
import com.tencent.mm.ui.base.preference.Preference;

public class GameRegionPreference extends Preference {
    a gwW;

    public static class a {
        public String bCq;
        public String gwX;
        public String gwY;
        public String gwZ;
        public boolean gxa;
        public boolean isDefault;
    }

    public GameRegionPreference(Context context) {
        this(context, null);
    }

    public GameRegionPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GameRegionPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(2130903996);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131755329);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(2130903755, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(2131757371);
        CheckBox checkBox = (CheckBox) view.findViewById(2131757372);
        if (textView != null && checkBox != null && this.gwW != null) {
            textView.setText(e.a(this.gwW));
            checkBox.setChecked(this.gwW.gxa);
        }
    }
}
