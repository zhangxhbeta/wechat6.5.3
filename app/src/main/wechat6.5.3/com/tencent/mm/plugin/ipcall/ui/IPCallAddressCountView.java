package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class IPCallAddressCountView extends FrameLayout {
    private View fDt;
    private TextView gKl;

    public IPCallAddressCountView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private IPCallAddressCountView(Context context) {
        super(context);
        init();
    }

    public IPCallAddressCountView(Context context, int i) {
        this(context);
        mb(i);
    }

    private void init() {
        inflate(getContext(), 2130903814, this);
        this.fDt = findViewById(2131756433);
        this.gKl = (TextView) findViewById(2131756434);
    }

    public final void mb(int i) {
        this.gKl.setText(getContext().getResources().getQuantityString(2131361793, i, new Object[]{Integer.valueOf(i)}));
    }
}
