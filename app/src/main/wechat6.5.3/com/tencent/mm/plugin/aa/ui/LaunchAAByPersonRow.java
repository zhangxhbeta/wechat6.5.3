package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class LaunchAAByPersonRow extends LinearLayout {
    private ImageView duZ;
    private TextView dva;
    private TextView dvb;
    private WalletFormView dvc;
    private TextView dvd;

    public LaunchAAByPersonRow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public LaunchAAByPersonRow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        inflate(getContext(), 2130903848, this);
        this.duZ = (ImageView) findViewById(2131757662);
        this.dva = (TextView) findViewById(2131757663);
        this.dvc = (WalletFormView) findViewById(2131757665);
        this.dvb = (TextView) findViewById(2131757655);
        this.dvd = (TextView) findViewById(2131757664);
    }
}
