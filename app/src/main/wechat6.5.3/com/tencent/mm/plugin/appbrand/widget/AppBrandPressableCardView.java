package com.tencent.mm.plugin.appbrand.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.a.a;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;

public final class AppBrandPressableCardView extends CardView {
    private float ir = 0.0f;

    public AppBrandPressableCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public AppBrandPressableCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    @a
    public final void setCardElevation(float f) {
        super.setCardElevation(f);
        this.ir = f;
    }

    @a
    public final float getCardElevation() {
        return super.getCardElevation();
    }

    private void init() {
        CardView.UI.a(this, -1);
        this.ir = getCardElevation();
        setClickable(true);
        setLongClickable(true);
        if (VERSION.SDK_INT >= 21) {
            StateListAnimator stateListAnimator = new StateListAnimator();
            int[] iArr = new int[]{16842919, 16842910};
            stateListAnimator.addState(iArr, ObjectAnimator.ofFloat(this, "cardElevation", new float[]{0.0f}).setDuration(0));
            Animator duration = ObjectAnimator.ofFloat(this, "cardElevation", new float[]{this.ir}).setDuration(0);
            stateListAnimator.addState(new int[]{16842910}, duration);
            iArr = new int[0];
            stateListAnimator.addState(iArr, ObjectAnimator.ofFloat(this, "cardElevation", new float[]{0.0f}).setDuration(0));
            setStateListAnimator(stateListAnimator);
        }
    }
}
