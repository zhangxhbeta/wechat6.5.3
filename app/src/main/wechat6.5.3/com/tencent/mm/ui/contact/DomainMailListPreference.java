package com.tencent.mm.ui.contact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.preference.Preference;

public class DomainMailListPreference extends Preference {
    private TextView dtB;
    private boolean fyL;
    private String oGl;
    private TextView oGm;
    private TextView oGn;
    private TextView oGo;
    private String title;

    public DomainMailListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public DomainMailListPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.fyL = false;
        this.title = "";
        this.oGl = "";
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131755329);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(2130904012, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        this.dtB = (TextView) view.findViewById(2131755226);
        this.oGm = (TextView) view.findViewById(2131758249);
        this.oGn = (TextView) view.findViewById(2131758250);
        this.oGo = (TextView) view.findViewById(2131758251);
        this.fyL = true;
        if (this.fyL) {
            this.dtB.setText(t.ma(this.title));
            String[] split = this.oGl.split(";");
            if (t.ma(this.oGl).length() <= 0) {
                this.oGm.setVisibility(8);
                this.oGn.setVisibility(8);
            } else {
                if (split.length > 0) {
                    this.oGm.setVisibility(0);
                    this.oGm.setText(t.ma(split[0]));
                } else {
                    this.oGm.setVisibility(8);
                }
                if (split.length > 1) {
                    this.oGn.setVisibility(0);
                    this.oGn.setText(t.ma(split[1]));
                } else {
                    this.oGn.setVisibility(8);
                }
                if (split.length > 2) {
                    this.oGo.setVisibility(0);
                    this.oGo.setText(t.ma(split[2]));
                }
            }
            this.oGo.setVisibility(8);
        } else {
            v.e("MicroMsg.DomainMailPreference", "initView : unbind view");
        }
        super.onBindView(view);
    }
}
