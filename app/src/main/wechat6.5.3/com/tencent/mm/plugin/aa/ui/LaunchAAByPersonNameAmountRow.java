package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ui.q;

public class LaunchAAByPersonNameAmountRow extends LinearLayout {
    TextView dtD;
    View duA;
    TextView duy;

    public LaunchAAByPersonNameAmountRow(Context context) {
        super(context);
        init(context);
    }

    public LaunchAAByPersonNameAmountRow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public LaunchAAByPersonNameAmountRow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        q.em(context).inflate(2130903847, this, true);
        this.duy = (TextView) findViewById(2131755499);
        this.dtD = (TextView) findViewById(2131757661);
        this.duA = findViewById(2131755264);
    }
}
