package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;

public class MallProductItemView extends LinearLayout {
    private TextView eXB;
    private String hPI;
    private TextView hRE;
    private ImageView hRF;
    private int hSm;
    private Object mData;
    private String mTitle;
    private int mType;

    public MallProductItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.hSm = 1;
        this.mType = 0;
        this.mData = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.b.aPt, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(2, 0);
        if (resourceId != 0) {
            this.mTitle = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(3, 0);
        if (resourceId != 0) {
            this.hPI = context.getString(resourceId);
        }
        this.hSm = obtainStyledAttributes.getInt(0, 1);
        obtainStyledAttributes.recycle();
        View inflate = LayoutInflater.from(context).inflate(2130904184, this, true);
        this.eXB = (TextView) inflate.findViewById(2131755456);
        this.hRE = (TextView) inflate.findViewById(2131758608);
        this.hRF = (ImageView) inflate.findViewById(2131758609);
        this.eXB.setText(this.mTitle);
        this.hRE.setText(this.hPI);
        this.hRE.setLines(this.hSm);
    }

    public MallProductItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void xL(String str) {
        this.hPI = str;
        this.hRE.setText(this.hPI);
    }
}
