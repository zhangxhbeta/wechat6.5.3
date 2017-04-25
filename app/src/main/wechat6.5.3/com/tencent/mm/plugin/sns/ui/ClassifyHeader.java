package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ClassifyHeader extends LinearLayout {
    private TextView emb;
    private ImageView hiF;
    private Context mContext;

    @TargetApi(11)
    public ClassifyHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public ClassifyHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = View.inflate(this.mContext, 2130903376, this);
        this.hiF = (ImageView) inflate.findViewById(2131756325);
        this.emb = (TextView) inflate.findViewById(2131756326);
    }
}
