package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.ui.base.MMSingelLinePanel;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;

public class ContactLabelPreference extends Preference {
    private TextView dtB;
    private MMSingelLinePanel hUj;
    private ArrayList<String> hUk;
    private String title;

    public ContactLabelPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public ContactLabelPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hUk = new ArrayList();
        setLayoutResource(2130903996);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131755329);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(2130904019, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        this.dtB = (TextView) view.findViewById(2131755226);
        this.hUj = (MMSingelLinePanel) view.findViewById(2131755212);
        this.hUj.bCo();
        this.hUj.nYe = false;
        this.hUj.ju(false);
        if (this.dtB != null) {
            this.dtB.setText(this.title);
        }
        if (!(this.hUj == null || this.hUk == null || this.hUk.size() <= 0)) {
            this.hUj.a(this.hUk, this.hUk);
        }
        super.onBindView(view);
    }
}
