package com.tencent.mm.plugin.wxcredit.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.ui.base.preference.Preference;

public class WalletWXCreditDetailFooterPreference extends Preference implements OnClickListener {
    private LayoutInflater CE;
    private TextView lwO;
    private TextView lwP;
    OnClickListener lwQ;

    public WalletWXCreditDetailFooterPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WalletWXCreditDetailFooterPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.CE = (LayoutInflater) context.getSystemService("layout_inflater");
        setLayoutResource(2130903996);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131755329);
        viewGroup2.removeAllViews();
        this.CE.inflate(2130904696, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        super.onBindView(view);
        this.lwO = (TextView) view.findViewById(2131760053);
        this.lwP = (TextView) view.findViewById(2131760054);
        this.lwO.setOnClickListener(this);
        this.lwP.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (this.lwQ != null) {
            this.lwQ.onClick(view);
        }
    }
}
