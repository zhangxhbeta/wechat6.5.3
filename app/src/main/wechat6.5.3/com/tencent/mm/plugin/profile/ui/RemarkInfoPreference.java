package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class RemarkInfoPreference extends Preference {
    private MMActivity aWn;
    private TextView dtB;
    private String gmB;
    private ImageView hEP;
    private TextView hWl;
    private boolean hXu = false;
    private String title;

    public final /* synthetic */ CharSequence getSummary() {
        return this.hWl.getText().toString();
    }

    public RemarkInfoPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aWn = (MMActivity) context;
    }

    public RemarkInfoPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(2130903996);
        setWidgetLayoutResource(2130904064);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131755329);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(2130904029, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        this.dtB = (TextView) view.findViewById(2131755226);
        this.hWl = (TextView) view.findViewById(2131756108);
        this.hEP = (ImageView) view.findViewById(2131756901);
        if (this.hXu) {
            this.hEP.setVisibility(0);
        } else {
            this.hEP.setVisibility(8);
        }
        if (this.dtB != null) {
            this.dtB.setText(this.title);
        }
        if (this.hWl != null) {
            this.hWl.setText(this.gmB);
        }
        super.onBindView(view);
    }
}
