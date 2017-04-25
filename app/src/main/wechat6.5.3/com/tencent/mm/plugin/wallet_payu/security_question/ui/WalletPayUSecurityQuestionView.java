package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.tools.CustomFitTextView;

public class WalletPayUSecurityQuestionView extends LinearLayout {
    private TextView iYk;
    private CustomFitTextView laN;
    String laO;
    private Context mContext;

    public WalletPayUSecurityQuestionView(Context context, AttributeSet attributeSet, int i) {
        boolean z;
        CharSequence charSequence;
        super(context, attributeSet);
        this.mContext = context;
        String str = "";
        String str2 = "";
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, R.b.aPd, -1, 0);
            int resourceId = obtainStyledAttributes.getResourceId(7, 0);
            if (resourceId != 0) {
                str = this.mContext.getString(resourceId);
            }
            resourceId = obtainStyledAttributes.getResourceId(6, 0);
            if (resourceId != 0) {
                str2 = this.mContext.getString(resourceId);
            }
            boolean z2 = obtainStyledAttributes.getBoolean(2, false);
            obtainStyledAttributes.recycle();
            z = z2;
            charSequence = str;
        } else {
            z = false;
            Object obj = str;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(2130904159, this, true);
        this.iYk = (TextView) inflate.findViewById(2131755314);
        this.laN = (CustomFitTextView) inflate.findViewById(2131756627);
        this.iYk.setText(charSequence);
        CustomFitTextView customFitTextView = this.laN;
        customFitTextView.a(str2, customFitTextView.maxLines, customFitTextView.oSc, customFitTextView.oSa, customFitTextView.getResources().getColor(2131689792));
        if (z) {
            this.laN.setEnabled(false);
            this.laN.setTextColor(getResources().getColor(2131690181));
            this.laN.setFocusable(false);
            this.laN.setClickable(false);
            this.laN.setBackgroundResource(2130839576);
            setBackgroundResource(2130838046);
            return;
        }
        this.laN.setEnabled(false);
        this.laN.setFocusable(false);
        this.laN.setClickable(false);
        this.laN.setBackgroundResource(2130839576);
        setBackgroundResource(2130838468);
    }

    public WalletPayUSecurityQuestionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public final void DF(String str) {
        this.laO = str;
        KeyListener keyListener = this.laN.getKeyListener();
        this.laN.setInputType(1);
        this.laN.setKeyListener(null);
        this.laN.c(str, 3, false, -1);
        this.laN.setKeyListener(keyListener);
    }
}
