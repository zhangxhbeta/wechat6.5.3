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
import com.tencent.mm.plugin.luckymoney.a.a;
import com.tencent.mm.plugin.luckymoney.c.c;
import com.tencent.mm.plugin.luckymoney.c.n;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.wallet_core.ui.e;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class LuckyMoneyMoneyInputView extends LinearLayout implements b {
    private TextWatcher abU = new TextWatcher(this) {
        final /* synthetic */ LuckyMoneyMoneyInputView hfy;

        {
            this.hfy = r1;
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            if (this.hfy.hfv != null) {
                f a = this.hfy.hfv;
                this.hfy.getId();
                a.axR();
            }
        }
    };
    private TextView eXB;
    private c hat;
    private TenpaySecureEditText hfs;
    private TextView hft;
    private TextView hfu;
    public f hfv;
    public double hfw;
    public double hfx;
    public int mType;

    public LuckyMoneyMoneyInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a.axz();
        this.hat = a.axA().axE();
        View inflate = LayoutInflater.from(context).inflate(2130903891, this, true);
        this.hfs = (TenpaySecureEditText) inflate.findViewById(2131757849);
        this.hfs.addTextChangedListener(this.abU);
        this.eXB = (TextView) inflate.findViewById(2131757847);
        this.hfu = (TextView) inflate.findViewById(2131757848);
        this.hft = (TextView) inflate.findViewById(2131757850);
    }

    public final double ayo() {
        return be.getDouble(this.hfs.getText().toString(), 0.0d);
    }

    public final void setTitle(String str) {
        this.eXB.setText(str);
    }

    public final void ed(boolean z) {
        if (z) {
            this.hfu.setVisibility(0);
        } else {
            this.hfu.setVisibility(8);
        }
    }

    public final void ayp() {
        this.hfs.setFilters(new InputFilter[]{new LengthFilter(12)});
    }

    public final void wg(String str) {
        this.hfs.setText(str);
    }

    public final int ayn() {
        if (be.kS(this.hfs.getText().toString())) {
            return 0;
        }
        double d = be.getDouble(this.hfs.getText().toString(), -1.0d);
        if (d < 0.0d) {
            return 3;
        }
        if (d > this.hfw && this.hfw > 0.0d) {
            return 1;
        }
        if (d >= this.hfx || d <= 0.0d) {
            return 0;
        }
        return 2;
    }

    public final void restore() {
        this.eXB.setTextColor(-16777216);
        this.hfs.setTextColor(-16777216);
        this.hft.setTextColor(-16777216);
    }

    public final void onError() {
        this.eXB.setTextColor(n.cf(getContext()));
        this.hfs.setTextColor(n.cf(getContext()));
        this.hft.setTextColor(n.cf(getContext()));
    }

    public final String mE(int i) {
        a.axz();
        this.hat = a.axA().axE();
        if (i == 1) {
            if (this.mType == 1) {
                return getContext().getString(2131233672, new Object[]{Math.round(this.hfw), be.ah(this.hat.has, "")});
            }
            return getContext().getString(2131233599, new Object[]{Math.round(this.hfw), be.ah(this.hat.has, "")});
        } else if (i != 2) {
            return null;
        } else {
            return getContext().getString(2131233600, new Object[]{e.m(this.hfx), be.ah(this.hat.has, "")});
        }
    }
}
