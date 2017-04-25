package com.tencent.mm.plugin.nearlife.ui;

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
    private ImageView bgv = ((ImageView) findViewById(2131757695));
    private Context context;
    protected LinearLayout eGb;

    public LoadingMoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        View inflate = LayoutInflater.from(this.context).inflate(2130903857, this, true);
        this.eGb = (LinearLayout) inflate.findViewById(2131755940);
        this.eGb.setVisibility(0);
        Animation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(1000);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        this.bgv.startAnimation(rotateAnimation);
    }
}
