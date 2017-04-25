package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class TrackPointAnimAvatar extends RelativeLayout {
    private ImageView cHH;
    private LinearLayout gZF;
    private Animation gZG;
    private Animation gZH;
    private Context mContext;

    public TrackPointAnimAvatar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    public TrackPointAnimAvatar(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        View inflate = View.inflate(this.mContext, 2130904552, this);
        this.gZF = (LinearLayout) inflate.findViewById(2131759582);
        this.cHH = (ImageView) inflate.findViewById(2131759583);
        this.gZG = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -0.5f);
        this.gZG.setDuration(500);
        this.gZG.setFillAfter(true);
        this.gZH = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -0.5f, 1, 0.0f);
        this.gZH.setDuration(500);
        this.gZH.setFillAfter(true);
        this.gZG.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ TrackPointAnimAvatar gZI;

            {
                this.gZI = r1;
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                this.gZI.bringToFront();
                this.gZI.gZF.startAnimation(this.gZI.gZH);
            }
        });
        this.gZH.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ TrackPointAnimAvatar gZI;

            {
                this.gZI = r1;
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                this.gZI.bringToFront();
                this.gZI.gZF.startAnimation(this.gZI.gZG);
            }
        });
    }
}
