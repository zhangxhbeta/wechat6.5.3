package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CleanLocationHeaderView extends LinearLayout {
    private TextView hEO;
    private ImageView hEP;

    public CleanLocationHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bF(context);
    }

    public CleanLocationHeaderView(Context context) {
        super(context);
        bF(context);
    }

    private void bF(Context context) {
        View inflate = View.inflate(context, 2130904113, this);
        this.hEO = (TextView) inflate.findViewById(2131758405);
        this.hEO.setSingleLine(false);
        this.hEP = (ImageView) inflate.findViewById(2131758404);
        this.hEO.setText(2131231931);
        this.hEP.setImageResource(2131165827);
    }
}
