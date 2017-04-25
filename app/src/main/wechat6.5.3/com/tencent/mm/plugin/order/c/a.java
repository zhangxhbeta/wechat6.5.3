package com.tencent.mm.plugin.order.c;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

public final class a extends ClickableSpan {
    public a hPW = null;
    private int hPX = -1;
    private Context mContext = null;
    private int sc = -1;

    public interface a {
        void onClick(View view);
    }

    public a(Context context) {
        this.mContext = context;
        this.sc = this.mContext.getResources().getColor(2131689859);
        this.hPX = -1;
    }

    public final void onClick(View view) {
        if (this.hPW != null) {
            this.hPW.onClick(view);
        }
    }

    public final void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setFakeBoldText(true);
        textPaint.setColor(this.sc);
        textPaint.setUnderlineText(false);
        textPaint.bgColor = this.hPX;
    }
}
