package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

public final class g extends ClickableSpan {
    private int hPX = -1;
    public a kTx = null;
    private Context mContext = null;
    int sc = -1;

    public interface a {
        void onClick(View view);
    }

    public g(Context context) {
        this.mContext = context;
        this.sc = this.mContext.getResources().getColor(2131690102);
        this.hPX = this.mContext.getResources().getColor(2131690078);
    }

    public final void onClick(View view) {
        if (this.kTx != null) {
            this.kTx.onClick(view);
        }
    }

    public final void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setFakeBoldText(false);
        textPaint.setColor(this.sc);
        textPaint.setUnderlineText(false);
        textPaint.bgColor = this.hPX;
    }
}
