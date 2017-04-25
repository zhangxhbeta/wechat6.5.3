package com.tencent.mm.plugin.wallet.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;

public class WalletItemView extends LinearLayout {
    private TextView eXB;
    private String hPI;
    private TextView hRE;
    private int hSm;
    private Object mData;
    private String mTitle;
    private int mType;

    public WalletItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.hSm = 1;
        this.mType = 0;
        this.mData = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.b.aPE, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(2, 0);
        if (resourceId != 0) {
            this.mTitle = context.getString(resourceId);
        }
        if (obtainStyledAttributes.getResourceId(3, 0) != 0) {
            this.hPI = context.getString(resourceId);
        }
        this.hSm = obtainStyledAttributes.getInt(0, 1);
        obtainStyledAttributes.recycle();
        View inflate = LayoutInflater.from(context).inflate(2130904650, this, true);
        this.eXB = (TextView) inflate.findViewById(2131755456);
        this.hRE = (TextView) inflate.findViewById(2131758608);
        if (this.eXB != null) {
            this.eXB.setText(this.mTitle);
        }
        if (this.hRE != null) {
            this.hRE.setText(this.hPI);
            this.hRE.setLines(this.hSm);
        }
    }

    public WalletItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
