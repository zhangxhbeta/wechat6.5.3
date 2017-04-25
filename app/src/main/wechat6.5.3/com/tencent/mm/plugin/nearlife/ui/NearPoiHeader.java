package com.tencent.mm.plugin.nearlife.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NearPoiHeader extends LinearLayout {
    private TextView emb;
    private ImageView hiF;

    @TargetApi(11)
    public NearPoiHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public NearPoiHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        View inflate = View.inflate(context, 2130904108, this);
        this.hiF = (ImageView) inflate.findViewById(2131758386);
        this.emb = (TextView) inflate.findViewById(2131758387);
    }
}
