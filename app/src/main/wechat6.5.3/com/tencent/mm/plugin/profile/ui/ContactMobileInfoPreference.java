package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactMobileInfoPreference extends Preference {
    private TextView eXB;
    private TextView hUl;
    private String hUm;
    private String mTitle;

    public ContactMobileInfoPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public ContactMobileInfoPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(2130903996);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131755329);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(2130904021, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        this.eXB = (TextView) view.findViewById(2131755226);
        this.hUl = (TextView) view.findViewById(2131755155);
        if (this.eXB != null) {
            this.eXB.setText(this.mTitle);
        }
        if (this.hUl != null) {
            this.hUl.setText(this.hUm);
        }
        super.onBindView(view);
    }
}
