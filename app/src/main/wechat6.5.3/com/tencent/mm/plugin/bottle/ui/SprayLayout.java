package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Random;

public class SprayLayout extends FrameLayout {
    private ImageView evX;
    private ImageView evY;
    private ImageView evZ;
    Animation ewa;
    Animation ewb;
    Animation ewc;
    Animation ewd;
    Animation ewe;
    AnimationSet ewf;
    AnimationSet ewg;
    AnimationSet ewh;
    private int ewi;
    private int ewj;
    private int ewk;
    private int ewl;
    private int ewm;
    private int ewn;
    private Runnable ewo;
    private ac handler;
    private int repeatCount;

    static /* synthetic */ void d(SprayLayout sprayLayout) {
        int i = -1;
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) sprayLayout.getLayoutParams();
        FrameLayout frameLayout = (FrameLayout) sprayLayout.getParent();
        if (marginLayoutParams != null && frameLayout != null) {
            if (sprayLayout.ewk == -1 && sprayLayout.ewl == -1) {
                Random random = new Random();
                int nextInt = (random.nextBoolean() ? 1 : -1) * random.nextInt(sprayLayout.ewm);
                int sqrt = (int) Math.sqrt((double) (((((sprayLayout.ewm * sprayLayout.ewm) - (nextInt * nextInt)) * sprayLayout.ewn) * sprayLayout.ewn) / (sprayLayout.ewm * sprayLayout.ewm)));
                if (random.nextBoolean()) {
                    i = 1;
                }
                marginLayoutParams.setMargins(nextInt, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, ((frameLayout.getHeight() * 300) / 800) + (random.nextInt(Math.max(sqrt, 1)) * i));
            } else {
                marginLayoutParams.setMargins(sprayLayout.ewk - (frameLayout.getWidth() / 2), marginLayoutParams.topMargin, marginLayoutParams.rightMargin, frameLayout.getHeight() - sprayLayout.ewl);
            }
            sprayLayout.setLayoutParams(marginLayoutParams);
        }
    }

    static /* synthetic */ int k(SprayLayout sprayLayout) {
        int i = sprayLayout.ewi + 1;
        sprayLayout.ewi = i;
        return i;
    }

    public SprayLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SprayLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ewa = new ScaleAnimation(0.6f, 0.8f, 0.6f, 0.8f, 1, 0.5f, 1, 1.0f);
        this.ewb = new AlphaAnimation(0.2f, 1.0f);
        this.ewc = new ScaleAnimation(0.8f, 1.27f, 0.8f, 1.27f, 1, 0.5f, 1, 1.0f);
        this.ewd = new AlphaAnimation(1.0f, 0.5f);
        this.ewe = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 1.0f);
        this.ewf = new AnimationSet(true);
        this.ewg = new AnimationSet(true);
        this.ewh = new AnimationSet(true);
        this.ewa.setDuration(280);
        this.ewb.setDuration(280);
        this.ewc.setDuration(280);
        this.ewd.setDuration(280);
        this.ewf.addAnimation(this.ewa);
        this.ewf.addAnimation(this.ewb);
        this.ewf.setRepeatCount(1);
        this.ewf.setDuration(280);
        this.ewg.addAnimation(this.ewc);
        this.ewg.setRepeatCount(1);
        this.ewg.setDuration(280);
        this.ewh.addAnimation(this.ewe);
        this.ewh.setRepeatCount(1);
        this.ewh.setDuration(280);
        this.ewi = 0;
        this.repeatCount = 1;
        this.ewk = -1;
        this.ewl = -1;
        this.handler = new ac();
        this.ewo = new Runnable(this) {
            final /* synthetic */ SprayLayout ewp;

            {
                this.ewp = r1;
            }

            public final void run() {
                if (this.ewp.ewi == 0) {
                    this.ewp.ewj = this.ewp.ewj + 1;
                    this.ewp.evZ.clearAnimation();
                    this.ewp.evZ.setVisibility(8);
                    SprayLayout.d(this.ewp);
                } else if (this.ewp.ewi == 1) {
                    this.ewp.evX.startAnimation(this.ewp.ewf);
                    this.ewp.evX.setVisibility(0);
                    this.ewp.evY.setVisibility(8);
                    this.ewp.evZ.setVisibility(8);
                } else if (this.ewp.ewi == 2) {
                    this.ewp.evX.startAnimation(this.ewp.ewg);
                    this.ewp.evY.startAnimation(this.ewp.ewf);
                    this.ewp.evY.setVisibility(0);
                } else if (this.ewp.ewi == 3) {
                    this.ewp.evX.clearAnimation();
                    this.ewp.evX.setVisibility(8);
                    this.ewp.evY.startAnimation(this.ewp.ewg);
                    this.ewp.evZ.startAnimation(this.ewp.ewf);
                    this.ewp.evZ.setVisibility(0);
                } else if (this.ewp.ewi == 4) {
                    this.ewp.evZ.startAnimation(this.ewp.ewh);
                    this.ewp.evY.clearAnimation();
                    this.ewp.evY.setVisibility(8);
                }
                if (this.ewp.ewj > this.ewp.repeatCount) {
                    this.ewp.stop();
                    return;
                }
                this.ewp.handler.postDelayed(this.ewp.ewo, 280);
                this.ewp.ewi = SprayLayout.k(this.ewp) % 5;
            }
        };
    }

    public final void x(int i, int i2, int i3) {
        this.ewi = 0;
        this.repeatCount = i;
        this.ewj = 0;
        this.ewk = i2;
        this.ewl = i3;
        if (this.evX == null) {
            this.evX = (ImageView) findViewById(2131755660);
            this.evY = (ImageView) findViewById(2131755659);
            this.evZ = (ImageView) findViewById(2131755658);
            DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
            this.ewm = (displayMetrics.widthPixels * 35) / 96;
            this.ewn = displayMetrics.heightPixels / 16;
        }
        this.evX.setVisibility(8);
        this.evY.setVisibility(8);
        this.evZ.setVisibility(8);
        setVisibility(0);
        this.handler.removeCallbacks(this.ewo);
        this.handler.postDelayed(this.ewo, 0);
    }

    public final void stop() {
        this.handler.removeCallbacks(this.ewo);
        setVisibility(8);
    }
}
