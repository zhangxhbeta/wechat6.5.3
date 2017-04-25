package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TipSayingWidget extends LinearLayout {
    private Context context;
    private TextView eRp;
    private ImageView gWb;
    private Chronometer gWc;
    private int gWd = 0;

    public TipSayingWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        View inflate = View.inflate(this.context, 2130904545, this);
        this.gWb = (ImageView) inflate.findViewById(2131759569);
        this.eRp = (TextView) inflate.findViewById(2131759570);
        this.gWc = (Chronometer) findViewById(2131758471);
    }
}
