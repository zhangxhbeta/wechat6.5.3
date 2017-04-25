package com.tencent.mm.plugin.wallet.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;

public class CheckBoxWithTipIconPreference extends CheckBoxPreference {
    private TextView kLc;
    private int kLd;
    private String kLe;
    private int kLf;

    public CheckBoxWithTipIconPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CheckBoxWithTipIconPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kLd = -1;
        this.kLe = "";
        this.kLf = 8;
        setLayoutResource(2130904068);
    }

    public final void onBindView(View view) {
        super.onBindView(view);
        this.kLc = (TextView) view.findViewById(2131758294);
        bh(this.kLe, this.kLd);
        sl(this.kLf);
    }

    public final void bh(String str, int i) {
        this.kLd = i;
        this.kLe = str;
        if (this.kLc != null) {
            if (this.kLd > 0) {
                this.kLc.setBackgroundResource(this.kLd);
            }
            if (!TextUtils.isEmpty(this.kLe)) {
                this.kLc.setText(this.kLe);
            }
        }
    }

    public final void sl(int i) {
        this.kLf = i;
        if (this.kLc != null) {
            this.kLc.setVisibility(i);
        }
    }
}
