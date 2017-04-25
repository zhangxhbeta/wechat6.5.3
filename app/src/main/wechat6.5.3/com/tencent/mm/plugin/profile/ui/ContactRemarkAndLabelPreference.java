package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.bd.a;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactRemarkAndLabelPreference extends Preference {
    private TextView eXB;
    private TextView hUN;
    private TextView hUO;
    private boolean hUP = false;
    private String hUQ;
    private String hUR;
    private String hUS;
    private Context mContext;

    public ContactRemarkAndLabelPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public ContactRemarkAndLabelPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        setLayoutResource(2130903996);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131755329);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(2130904028, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        int i;
        this.eXB = (TextView) view.findViewById(2131755226);
        this.hUN = (TextView) view.findViewById(2131758270);
        this.hUO = (TextView) view.findViewById(2131758271);
        if (!(this.eXB == null || be.kS(this.hUQ))) {
            this.eXB.setVisibility(0);
            this.eXB.setText(this.hUQ);
            LayoutParams layoutParams = (LayoutParams) this.eXB.getLayoutParams();
            layoutParams.width = a.N(this.mContext, 2131493077);
            this.eXB.setLayoutParams(layoutParams);
        }
        if (this.hUN != null) {
            if (this.hUP) {
                this.hUN.setVisibility(0);
                this.hUN.setCompoundDrawablesWithIntrinsicBounds(2131165368, 0, 0, 0);
                i = 1;
            } else {
                this.hUN.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                i = 0;
            }
            if (!be.kS(this.hUR)) {
                this.hUN.setVisibility(0);
                this.hUN.setText(e.a(this.mContext, be.ma(this.hUR), this.hUN.getTextSize()));
                i = 1;
            }
        } else {
            i = 0;
        }
        if (!(this.hUO == null || be.kS(this.hUS))) {
            i |= 2;
            this.hUO.setVisibility(0);
            this.hUO.setText(this.hUS);
        }
        int i2 = i;
        if (i2 == 1) {
            ((LayoutParams) this.hUN.getLayoutParams()).addRule(15);
        }
        if (i2 == 2) {
            layoutParams = (LayoutParams) this.hUO.getLayoutParams();
            layoutParams.addRule(3, 0);
            layoutParams.addRule(15);
        }
        super.onBindView(view);
    }
}
