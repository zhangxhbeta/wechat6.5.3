package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.c.n;
import com.tencent.mm.sdk.platformtools.be;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class LuckyMoneyNumInputView extends LinearLayout implements b {
    private TextWatcher abU = new TextWatcher(this) {
        final /* synthetic */ LuckyMoneyNumInputView hgI;

        {
            this.hgI = r1;
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            if (this.hgI.hfv != null) {
                f a = this.hgI.hfv;
                this.hgI.getId();
                a.axR();
            }
        }
    };
    private TextView eXB;
    public f hfv;
    private TenpaySecureEditText hgD;
    private TextView hgE;
    private int hgF = 1;
    private int hgG = Integer.MAX_VALUE;
    public int hgH = 1;

    public LuckyMoneyNumInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = LayoutInflater.from(context).inflate(2130903898, this, true);
        this.eXB = (TextView) inflate.findViewById(2131757899);
        this.hgD = (TenpaySecureEditText) inflate.findViewById(2131757849);
        this.hgE = (TextView) inflate.findViewById(2131757900);
        this.hgD.setText(this.hgF);
        this.hgD.addTextChangedListener(this.abU);
    }

    public final void mG(int i) {
        int i2 = 3;
        this.hgG = i;
        int i3 = 0;
        while (i > 0) {
            i3++;
            i /= 10;
        }
        if (i3 > 3) {
            i2 = i3;
        }
        this.hgD.setFilters(new InputFilter[]{new LengthFilter(i2)});
    }

    public final int ayu() {
        return be.getInt(this.hgD.getText().toString(), 0);
    }

    public final void wh(String str) {
        this.hgD.setText(str);
        this.hgD.setSelection(this.hgD.getText().length());
        this.hgF = be.getInt(str, 0);
    }

    public final int ayn() {
        if (be.kS(this.hgD.getText().toString())) {
            return 0;
        }
        int i = be.getInt(this.hgD.getText().toString(), -1);
        if (i < 0) {
            return 3;
        }
        if (i > this.hgG && this.hgG > 0) {
            return 1;
        }
        if (i >= this.hgH || this.hgH <= 0) {
            return 0;
        }
        return 2;
    }

    public final void restore() {
        this.eXB.setTextColor(-16777216);
        this.hgD.setTextColor(-16777216);
        this.hgE.setTextColor(-16777216);
    }

    public final void onError() {
        this.eXB.setTextColor(n.cf(getContext()));
        this.hgD.setTextColor(n.cf(getContext()));
        this.hgE.setTextColor(n.cf(getContext()));
    }

    public final String mE(int i) {
        if (i == 1) {
            return getContext().getString(2131233636, new Object[]{Integer.valueOf(this.hgG)});
        } else if (i != 2) {
            return null;
        } else {
            return getContext().getString(2131233635, new Object[]{Integer.valueOf(this.hgH)});
        }
    }
}
