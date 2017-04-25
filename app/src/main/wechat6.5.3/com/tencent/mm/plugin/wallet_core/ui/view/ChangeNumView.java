package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class ChangeNumView extends TextView {
    private int kWA = 0;
    private boolean kWB = false;
    private final int kWC = 100;
    private int kWz = 0;
    private int kif = -1;
    private int max = 0;

    public ChangeNumView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChangeNumView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
