package com.tencent.mm.plugin.bottle.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

@SuppressLint({"HandlerLeak"})
public class ThrowBottleAnimUI extends FrameLayout {
    int VD;
    int VE;
    BottleBeachUI evl;
    boolean ewA;
    private ac ewB = new ac(this) {
        final /* synthetic */ ThrowBottleAnimUI ewC;

        {
            this.ewC = r1;
        }

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.ewC.ewq == null && this.ewC.evl != null) {
                this.ewC.ewq = (SprayLayout) this.ewC.evl.findViewById(2131755657);
            }
            if (this.ewC.ewq != null) {
                this.ewC.ewq.stop();
            }
            if (this.ewC.ewz != null) {
                this.ewC.ewz.XX();
            }
        }
    };
    private SprayLayout ewq;
    private BottleImageView ewr;
    private TextView ews;
    private AnimationSet ewt;
    private int ewu;
    private int ewv;
    private int eww;
    private int ewx;
    int ewy;
    a ewz;

    public interface a {
        void XX();
    }

    static /* synthetic */ void f(ThrowBottleAnimUI throwBottleAnimUI) {
        float f;
        int i;
        throwBottleAnimUI.ews.setVisibility(0);
        if (throwBottleAnimUI.ewA) {
            throwBottleAnimUI.ews.setBackgroundDrawable(com.tencent.mm.bd.a.a(throwBottleAnimUI.evl, 2130838977));
            throwBottleAnimUI.ews.setWidth(throwBottleAnimUI.ewy);
            f = 1.0f;
            i = 120;
        } else {
            throwBottleAnimUI.ews.setBackgroundDrawable(com.tencent.mm.bd.a.a(throwBottleAnimUI.evl, 2130837770));
            f = 0.5f;
            i = 25;
        }
        throwBottleAnimUI.ewt = new AnimationSet(true);
        throwBottleAnimUI.ewt.setInterpolator(throwBottleAnimUI.evl, 17432582);
        Animation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.0f, 1, 0.0f);
        scaleAnimation.setDuration(700);
        Animation rotateAnimation = new RotateAnimation(0.0f, (float) i, 1, f, 1, 1.0f);
        rotateAnimation.setDuration(700);
        int intrinsicWidth = throwBottleAnimUI.ewr.getBackground().getIntrinsicWidth() / 2;
        int intrinsicHeight = throwBottleAnimUI.ewr.getBackground().getIntrinsicHeight() / 2;
        int a = b.a(throwBottleAnimUI.evl, 40.0f);
        v.v("MicroMsg.ThrowBottleAnimView", "tran from (" + throwBottleAnimUI.VD + "," + throwBottleAnimUI.VE + ") to (" + ((throwBottleAnimUI.XY() - a) - intrinsicWidth) + " , " + ((throwBottleAnimUI.XZ() - a) - intrinsicHeight));
        Animation translateAnimation = new TranslateAnimation((float) throwBottleAnimUI.VD, (float) ((throwBottleAnimUI.XY() - a) - intrinsicWidth), (float) throwBottleAnimUI.VE, (float) ((throwBottleAnimUI.XZ() - a) - intrinsicHeight));
        translateAnimation.setDuration(700);
        throwBottleAnimUI.ewt.addAnimation(rotateAnimation);
        throwBottleAnimUI.ewt.addAnimation(scaleAnimation);
        throwBottleAnimUI.ewt.addAnimation(translateAnimation);
        throwBottleAnimUI.ewt.setAnimationListener(new AnimationListener(throwBottleAnimUI) {
            final /* synthetic */ ThrowBottleAnimUI ewC;

            {
                this.ewC = r1;
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                this.ewC.ews.setVisibility(8);
                this.ewC.Yb();
            }
        });
    }

    public ThrowBottleAnimUI(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.evl = (BottleBeachUI) context;
        NI();
    }

    public ThrowBottleAnimUI(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.evl = (BottleBeachUI) context;
        NI();
    }

    public final void release() {
        this.evl = null;
        this.ewt = null;
        this.ewq = null;
        if (this.ewr != null) {
            BottleImageView bottleImageView = this.ewr;
            bottleImageView.context = null;
            bottleImageView.euC = null;
        }
        this.ewr = null;
        this.ewz = null;
    }

    public boolean isInEditMode() {
        return false;
    }

    private void NI() {
        inflate(this.evl, 2130903191, this);
        this.ewr = (BottleImageView) findViewById(2131755689);
        this.ews = (TextView) findViewById(2131755690);
        DisplayMetrics displayMetrics = this.evl.getResources().getDisplayMetrics();
        this.eww = displayMetrics.widthPixels;
        this.ewx = displayMetrics.heightPixels;
    }

    private int XY() {
        int abs = Math.abs(getWidth());
        if (abs <= 0) {
            return this.eww;
        }
        return abs;
    }

    private int XZ() {
        int abs = Math.abs(getHeight());
        if (abs <= 0) {
            return this.ewx;
        }
        return abs;
    }

    final void Ya() {
        this.ewr.setImageDrawable(null);
        int intrinsicWidth = this.ewr.getBackground().getIntrinsicWidth();
        int intrinsicHeight = this.ewr.getBackground().getIntrinsicHeight();
        this.ewr.setVisibility(0);
        int a = b.a(this.evl, 40.0f);
        this.ewr.setLayoutParams(new LayoutParams(-2, -2, XY() - (intrinsicWidth + a), XZ() - (intrinsicHeight + a)));
    }

    final void Yb() {
        int intrinsicWidth = this.ewr.getBackground().getIntrinsicWidth();
        int intrinsicHeight = this.ewr.getBackground().getIntrinsicHeight();
        this.ewr.setVisibility(0);
        int a = b.a(this.evl, 40.0f);
        setBackgroundDrawable(com.tencent.mm.bd.a.a(this.evl, be.bui() ? 2130837741 : 2130837742));
        if (this.ewA) {
            this.ewr.setImageDrawable(com.tencent.mm.bd.a.a(this.evl, 2130837776));
        } else {
            this.ewr.setImageDrawable(com.tencent.mm.bd.a.a(this.evl, 2130837775));
        }
        this.ewr.setLayoutParams(new LayoutParams(-2, -2, 0, 0));
        BottleImageView bottleImageView = this.ewr;
        int XY = XY() - (intrinsicWidth + a);
        intrinsicWidth = this.ewu - (intrinsicWidth / 2);
        a = XZ() - (a + intrinsicHeight);
        intrinsicHeight = this.ewv - (intrinsicHeight / 2);
        AnimationListener anonymousClass3 = new AnimationListener(this) {
            final /* synthetic */ ThrowBottleAnimUI ewC;

            {
                this.ewC = r1;
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                this.ewC.ewr.setVisibility(8);
                if (this.ewC.ewq == null) {
                    this.ewC.ewq = (SprayLayout) this.ewC.evl.findViewById(2131755657);
                }
                this.ewC.ewq.x(1, this.ewC.ewu, this.ewC.ewv);
                this.ewC.ewB.sendEmptyMessageDelayed(0, 2000);
            }
        };
        bottleImageView.VD = XY;
        bottleImageView.VF = intrinsicWidth;
        bottleImageView.VE = a;
        bottleImageView.VG = intrinsicHeight;
        bottleImageView.euC.setAnimationListener(anonymousClass3);
        bottleImageView.euC.setDuration(2000);
        bottleImageView.euC.setRepeatCount(0);
        bottleImageView.euC.setStartOffset(500);
        bottleImageView.euC.setInterpolator(bottleImageView.context, 17432582);
        bottleImageView.startAnimation(bottleImageView.euC);
    }

    final void Yc() {
        this.ewu = XY() / 2;
        this.ewv = (XZ() * 460) / 800;
        v.v("MicroMsg.ThrowBottleAnimView", "to (" + this.ewu + "," + this.ewv + ")  bottle (" + this.ewr.getDrawable().getIntrinsicWidth() + "," + this.ewr.getDrawable().getIntrinsicHeight() + ")");
    }
}
