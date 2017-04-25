package com.tencent.mm.pluginsdk.ui.wallet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class WalletIconImageView extends ImageView {
    private int lO;
    private int lVw;
    private OnClickListener lVx;

    public WalletIconImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.lVw = -1;
        this.lO = 4;
        this.lVx = null;
    }

    public WalletIconImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void setImageResource(int i) {
        this.lVw = i;
        super.setImageResource(i);
    }

    public void setVisibility(int i) {
        this.lO = i;
        super.setVisibility(i);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.lVx = onClickListener;
    }

    public final void h(OnClickListener onClickListener) {
        super.setVisibility(0);
        super.setImageResource(2130838465);
        super.setContentDescription(getContext().getString(2131231938));
        super.setOnClickListener(onClickListener);
    }

    public final void brg() {
        super.setVisibility(this.lO);
        super.setImageResource(this.lVw);
        super.setOnClickListener(this.lVx);
    }
}
