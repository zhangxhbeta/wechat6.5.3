package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class LoadingMoreView extends LinearLayout {
    private ImageView bgv;
    private Context context;
    protected LinearLayout eGb;
    protected LinearLayout eGc;
    protected LinearLayout jGO;

    public LoadingMoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    public LoadingMoreView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    private void init() {
        View inflate = LayoutInflater.from(this.context).inflate(2130904480, this, true);
        this.bgv = (ImageView) findViewById(2131755941);
        this.eGb = (LinearLayout) inflate.findViewById(2131755940);
        this.eGc = (LinearLayout) inflate.findViewById(2131755942);
        this.jGO = (LinearLayout) inflate.findViewById(2131759428);
        this.eGb.setVisibility(0);
        this.eGc.setVisibility(8);
        this.jGO.setVisibility(8);
        Animation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(1000);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        this.bgv.startAnimation(rotateAnimation);
    }

    public final void go(boolean z) {
        this.eGb.setVisibility(8);
        if (z) {
            this.jGO.setVisibility(0);
            this.eGc.setVisibility(8);
            return;
        }
        this.eGc.setVisibility(0);
        this.jGO.setVisibility(8);
    }
}
