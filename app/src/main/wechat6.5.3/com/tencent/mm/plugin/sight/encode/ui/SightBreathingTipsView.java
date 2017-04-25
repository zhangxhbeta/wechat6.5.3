package com.tencent.mm.plugin.sight.encode.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class SightBreathingTipsView extends View {
    private Animation mAnimation;

    public SightBreathingTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SightBreathingTipsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.mAnimation = AnimationUtils.loadAnimation(getContext(), 2130968669);
        setBackgroundResource(2130839160);
    }
}
