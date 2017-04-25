package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.compatible.util.d;

public class DialNumberButton extends RelativeLayout {
    TextView gIN;
    TextView gIO;
    private boolean gIP = false;

    public DialNumberButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(2130903463, this);
        this.gIN = (TextView) findViewById(2131756587);
        this.gIO = (TextView) findViewById(2131756588);
        if (d.dW(16)) {
            this.gIN.setTypeface(Typeface.create("sans-serif-light", 0));
            this.gIO.setTypeface(Typeface.create("sans-serif-normal", 0));
        }
        setClipChildren(false);
        setClipToPadding(false);
    }

    public final String auX() {
        return this.gIN.getText().toString();
    }

    public final String auY() {
        return this.gIO.getText().toString();
    }

    public final void dL(boolean z) {
        this.gIP = z;
        if (this.gIP) {
            if ("#".equals(this.gIN.getText()) || "*".equals(this.gIN.getText())) {
                this.gIN.setTextColor(getContext().getResources().getColor(2131689666));
            } else {
                this.gIN.setTextColor(getContext().getResources().getColor(2131689668));
            }
            this.gIO.setTextColor(getContext().getResources().getColor(2131689666));
            setBackgroundDrawable(getResources().getDrawable(2130838103));
            return;
        }
        if ("#".equals(this.gIN.getText()) || "*".equals(this.gIN.getText())) {
            this.gIN.setTextColor(getContext().getResources().getColor(2131689666));
        } else {
            this.gIN.setTextColor(getContext().getResources().getColor(2131689667));
        }
        this.gIO.setTextColor(getContext().getResources().getColor(2131689666));
        setBackgroundDrawable(getResources().getDrawable(2130838104));
    }
}
