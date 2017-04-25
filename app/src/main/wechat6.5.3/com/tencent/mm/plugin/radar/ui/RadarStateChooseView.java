package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.tencent.mm.plugin.radar.a.e.a;

public class RadarStateChooseView extends RelativeLayout {
    boolean ijB = false;
    Animation ijC = null;
    Animation ijD = null;
    boolean ijE = true;
    public a ijF = a.UnSelected;

    public RadarStateChooseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RadarStateChooseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    final void init() {
        if (this.ijC == null) {
            this.ijC = AnimationUtils.loadAnimation(getContext(), 2130968650);
            this.ijC.setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ RadarStateChooseView ijG;

                {
                    this.ijG = r1;
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
        }
        if (this.ijD == null) {
            this.ijD = AnimationUtils.loadAnimation(getContext(), 2130968649);
            this.ijD.setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ RadarStateChooseView ijG;

                {
                    this.ijG = r1;
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    this.ijG.ijB = false;
                    this.ijG.setVisibility(8);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    final void aIT() {
        switch (this.ijF) {
            case UnSelected:
                setVisibility(4);
                return;
            case Selected:
                setBackgroundResource(2131165863);
                setVisibility(0);
                return;
            default:
                setVisibility(4);
                return;
        }
    }
}
