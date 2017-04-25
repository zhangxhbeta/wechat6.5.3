package com.tencent.mm.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;

public class d implements OnClickListener {
    private OnClickListener iqU;
    private long jhq = 0;

    public void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.jhq >= 500) {
            this.iqU.onClick(view);
            this.jhq = currentTimeMillis;
        }
    }
}
