package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.base.preference.Preference;

public class LicencePreference extends Preference {
    private CheckBox lPH;
    private Button lPI;
    private String lPJ;
    private boolean lPK;
    private OnClickListener lPL;

    public LicencePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LicencePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lPK = false;
        setLayoutResource(2130904054);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        this.lPH = (CheckBox) onCreateView.findViewById(2131758285);
        this.lPI = (Button) onCreateView.findViewById(2131758286);
        this.lPI.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LicencePreference lPM;

            {
                this.lPM = r1;
            }

            public final void onClick(View view) {
                if (this.lPM.lPL != null) {
                    this.lPM.lPL.onClick(view);
                }
            }
        });
        if (!be.kS(this.lPJ)) {
            this.lPI.setText(this.lPJ);
        }
        this.lPH.setChecked(this.lPK);
        return onCreateView;
    }

    public final void onBindView(View view) {
        super.onBindView(view);
    }
}
