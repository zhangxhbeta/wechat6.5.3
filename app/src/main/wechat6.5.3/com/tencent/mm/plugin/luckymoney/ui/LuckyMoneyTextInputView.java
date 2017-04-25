package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ui.widget.MMEditText;

public class LuckyMoneyTextInputView extends LinearLayout implements b {
    private TextView eXB;
    public f hfv;
    private MMEditText hhA;

    public LuckyMoneyTextInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = LayoutInflater.from(context).inflate(2130903902, this, true);
        this.hhA = (MMEditText) inflate.findViewById(2131757939);
        this.eXB = (TextView) inflate.findViewById(2131757938);
        this.hhA.setOnFocusChangeListener(new OnFocusChangeListener(this) {
            final /* synthetic */ LuckyMoneyTextInputView hhB;

            {
                this.hhB = r1;
            }

            public final void onFocusChange(View view, boolean z) {
                if (this.hhB.hfv != null) {
                    f a = this.hhB.hfv;
                    this.hhB.getId();
                    a.axR();
                }
            }
        });
    }

    public final String getInput() {
        return this.hhA.getText().toString();
    }

    public final void wi(String str) {
        this.hhA.setHint(str);
    }

    public final int ayn() {
        return 0;
    }

    public final void restore() {
    }

    public final void onError() {
    }

    public final String mE(int i) {
        return null;
    }
}
