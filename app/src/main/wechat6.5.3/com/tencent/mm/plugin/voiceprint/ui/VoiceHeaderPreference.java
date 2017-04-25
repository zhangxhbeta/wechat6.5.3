package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class VoiceHeaderPreference extends Preference {
    private MMActivity aWn;
    private TextView dtB;
    private TextView dxO;
    private ImageView hEP;
    private String hUQ;
    private int iJQ;
    private Button kpL;
    private View kpM;
    private OnClickListener kpN;
    private String kpO;
    private String mTitle;

    public VoiceHeaderPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.aWn = (MMActivity) context;
    }

    public VoiceHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTitle = "";
        this.iJQ = 255;
        this.kpN = null;
        this.hUQ = "";
        this.kpO = "";
        this.aWn = (MMActivity) context;
        setLayoutResource(2130904586);
    }

    public final void cQ(String str, String str2) {
        this.hUQ = str;
        this.kpO = str2;
        if (this.dtB != null) {
            if (be.kS(this.hUQ)) {
                this.dtB.setVisibility(8);
            } else {
                this.dtB.setText(this.hUQ);
                this.dtB.setVisibility(0);
            }
        }
        if (this.dxO == null) {
            return;
        }
        if (be.kS(this.kpO)) {
            this.dxO.setVisibility(8);
            return;
        }
        this.dxO.setText(this.kpO);
        this.dxO.setVisibility(0);
    }

    public final void f(OnClickListener onClickListener) {
        this.kpN = onClickListener;
        if (this.kpL != null && this.kpM != null) {
            if (this.kpL == null || this.kpN == null) {
                this.kpL.setVisibility(8);
                this.kpM.setVisibility(8);
                return;
            }
            this.kpL.setOnClickListener(onClickListener);
            this.kpL.setVisibility(0);
            this.kpM.setVisibility(0);
        }
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.hEP = (ImageView) view.findViewById(2131759654);
        this.dtB = (TextView) view.findViewById(2131759656);
        this.dxO = (TextView) view.findViewById(2131759657);
        this.kpL = (Button) view.findViewById(2131756773);
        this.kpM = view.findViewById(2131759667);
        if (be.kS(this.hUQ)) {
            this.dtB.setVisibility(8);
        } else {
            this.dtB.setText(this.hUQ);
            this.dtB.setVisibility(0);
        }
        if (be.kS(this.kpO)) {
            this.dxO.setVisibility(8);
        } else {
            this.dxO.setText(this.kpO);
            this.dxO.setVisibility(0);
        }
        if (this.kpL == null || this.kpN == null) {
            this.kpL.setVisibility(8);
            this.kpM.setVisibility(8);
            return;
        }
        this.kpL.setOnClickListener(this.kpN);
        this.kpL.setVisibility(0);
        this.kpM.setVisibility(0);
    }
}
