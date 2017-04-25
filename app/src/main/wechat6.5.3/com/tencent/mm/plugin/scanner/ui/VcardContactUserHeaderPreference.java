package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.preference.Preference;

public class VcardContactUserHeaderPreference extends Preference {
    String aGX;
    private final Context context;
    private TextView gwz;
    private ImageView iCF;
    private TextView iCG;
    private TextView iCH;
    private TextView iCI;
    String iCJ;
    String iwP;
    String title;

    public VcardContactUserHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    public VcardContactUserHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        v.e("MicroMsg.scanner.VcardContactUserHeaderPreference", "onbindview");
        this.iCF = (ImageView) view.findViewById(2131759602);
        this.gwz = (TextView) view.findViewById(2131759603);
        if (this.iCJ != null) {
            this.gwz.setText(this.iCJ);
        }
        this.iCG = (TextView) view.findViewById(2131759604);
        if (this.aGX != null) {
            this.iCG.setText(this.context.getString(2131235756, new Object[]{this.aGX}));
            this.iCG.setVisibility(0);
        }
        this.iCH = (TextView) view.findViewById(2131759606);
        if (this.iwP != null) {
            this.iCH.setText(this.context.getString(2131235761, new Object[]{this.iwP}));
            this.iCH.setVisibility(0);
        }
        this.iCI = (TextView) view.findViewById(2131759605);
        if (this.title != null) {
            this.iCI.setText(this.context.getString(2131235762, new Object[]{this.title}));
            this.iCI.setVisibility(0);
        }
    }
}
