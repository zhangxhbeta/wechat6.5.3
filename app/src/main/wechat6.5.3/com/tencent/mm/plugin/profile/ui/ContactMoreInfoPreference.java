package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bd.a;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactMoreInfoPreference extends Preference {
    private TextView eJL;
    private ImageView hUn;
    private ImageView hUo;
    private ImageView hUp;
    private ImageView hUq;
    private ImageView hUr;
    private ImageView hUs;
    private int hUt = 8;
    private int hUu = 8;
    private int hUv = 8;
    private int hUw = 8;
    private int hUx = 8;
    private int hUy = 8;

    public ContactMoreInfoPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ContactMoreInfoPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(2130903996);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131755329);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(2130904022, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        this.hUn = (ImageView) view.findViewById(2131758262);
        this.hUo = (ImageView) view.findViewById(2131758263);
        this.hUp = (ImageView) view.findViewById(2131758264);
        this.hUq = (ImageView) view.findViewById(2131758265);
        this.hUr = (ImageView) view.findViewById(2131758266);
        this.hUs = (ImageView) view.findViewById(2131758267);
        this.eJL = (TextView) view.findViewById(2131755226);
        av();
        super.onBindView(view);
    }

    public final void oj(int i) {
        this.hUu = i;
        av();
    }

    public final void ok(int i) {
        this.hUv = i;
        av();
    }

    public final void ol(int i) {
        this.hUx = i;
        av();
    }

    public final void om(int i) {
        this.hUy = i;
        av();
    }

    private void av() {
        if (this.hUn != null) {
            this.hUn.setVisibility(this.hUt);
        }
        if (this.hUo != null) {
            this.hUo.setVisibility(this.hUu);
        }
        if (this.hUp != null) {
            this.hUp.setVisibility(this.hUv);
        }
        if (this.hUq != null) {
            this.hUq.setVisibility(this.hUw);
        }
        if (this.hUr != null) {
            this.hUr.setVisibility(this.hUx);
        }
        if (this.eJL != null) {
            LayoutParams layoutParams = this.eJL.getLayoutParams();
            layoutParams.width = a.N(this.mContext, 2131493077);
            this.eJL.setLayoutParams(layoutParams);
        }
        if (this.hUs != null) {
            this.hUs.setVisibility(this.hUy);
        }
    }
}
