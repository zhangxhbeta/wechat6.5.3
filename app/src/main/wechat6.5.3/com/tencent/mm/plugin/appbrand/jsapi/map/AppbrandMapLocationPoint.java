package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class AppbrandMapLocationPoint extends LinearLayout {
    ImageView dKk;
    double dKl = -1.0d;
    double dKm = -1.0d;
    double dKn = -1.0d;
    double dKo = -1.0d;
    private Context mContext;

    public AppbrandMapLocationPoint(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    public AppbrandMapLocationPoint(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        this.dKk = (ImageView) View.inflate(this.mContext, 2130903106, this).findViewById(2131755379);
        this.dKk.requestFocus();
    }
}
