package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

public final class g extends LinearLayout {
    private Context context;
    private int etb = 0;
    public int jEl = 6;
    private LinearLayout jEm;

    public g(Context context) {
        super(context);
        this.context = context;
        setOrientation(1);
    }

    public final void addView(View view) {
        if (this.etb % this.jEl == 0) {
            this.jEm = new LinearLayout(this.context);
            this.jEm.setOrientation(0);
            this.jEm.addView(view);
            super.addView(this.jEm);
        } else {
            this.jEm.addView(view);
        }
        this.etb++;
    }
}
