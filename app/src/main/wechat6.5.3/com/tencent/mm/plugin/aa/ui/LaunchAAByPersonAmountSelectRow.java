package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ui.q;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class LaunchAAByPersonAmountSelectRow extends LinearLayout {
    private ImageView dtz;
    private View duA;
    private TextWatcher duB = null;
    private TextView duy;
    private WalletFormView duz;

    public LaunchAAByPersonAmountSelectRow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public LaunchAAByPersonAmountSelectRow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        q.em(context).inflate(2130903845, this, true);
        this.dtz = (ImageView) findViewById(2131756854);
        this.duy = (TextView) findViewById(2131755499);
        this.duz = (WalletFormView) findViewById(2131757654);
        this.duA = findViewById(2131755264);
    }
}
