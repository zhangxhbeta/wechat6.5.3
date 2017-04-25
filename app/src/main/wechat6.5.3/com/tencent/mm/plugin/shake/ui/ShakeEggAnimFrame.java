package com.tencent.mm.plugin.shake.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.bf.c;
import com.tencent.mm.bf.g;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public class ShakeEggAnimFrame extends FrameLayout {
    List<View> iQI = new ArrayList();
    int iQJ = 0;
    int size = 0;

    abstract class a extends Animation {
        protected int duration = 100;
        final /* synthetic */ ShakeEggAnimFrame iQK;
        View targetView;

        a(ShakeEggAnimFrame shakeEggAnimFrame) {
            this.iQK = shakeEggAnimFrame;
        }
    }

    class b extends a {
        private int etu;
        private int etv;
        final /* synthetic */ ShakeEggAnimFrame iQK;
        private float iQM;
        private float iQN;
        private float iQO;
        private float iQP;
        private float iQQ = 0.01f;
        private float iQR = 0.02f;
        private float iQS;
        private float iQT;
        private float iQU;
        private float iQV;

        public b(ShakeEggAnimFrame shakeEggAnimFrame, int i, int i2) {
            this.iQK = shakeEggAnimFrame;
            super(shakeEggAnimFrame);
            this.etu = i;
            this.etv = i2;
            this.iQM = ShakeEggAnimFrame.k(0.1f, 0.9f);
            this.iQN = this.iQM;
            this.iQP = ShakeEggAnimFrame.k(-0.3f, -0.1f);
            restart();
        }

        protected final void applyTransformation(float f, Transformation transformation) {
            float f2 = this.iQS;
            float f3 = this.iQU;
            if (this.iQS != this.iQT) {
                f2 = this.iQS + ((this.iQT - this.iQS) * f);
            }
            if (this.iQU != this.iQV) {
                f3 = this.iQU + ((this.iQV - this.iQU) * f);
            }
            transformation.getMatrix().setTranslate(f2, f3);
            if (f == 1.0f) {
                restart();
            }
        }

        private void restart() {
            if (this.iQP > 0.0f) {
                this.iQR += this.iQQ;
            }
            this.iQO = this.iQP;
            this.iQP += this.iQR;
            if (this.iQO > 1.1f) {
                Assert.assertTrue(this.targetView != null);
                this.targetView.post(new Runnable(this) {
                    final /* synthetic */ a iQL;

                    {
                        this.iQL = r1;
                    }

                    public final void run() {
                        if (this.iQL.targetView != null) {
                            this.iQL.targetView.clearAnimation();
                            ShakeEggAnimFrame shakeEggAnimFrame = this.iQL.iQK;
                            View view = this.iQL.targetView;
                            shakeEggAnimFrame.iQI.remove(view);
                            shakeEggAnimFrame.removeView(view);
                        }
                    }
                });
            }
            this.iQS = this.iQM * ((float) this.etu);
            this.iQT = this.iQN * ((float) this.etu);
            this.iQU = this.iQO * ((float) this.etv);
            this.iQV = this.iQP * ((float) this.etv);
        }

        public final void initialize(int i, int i2, int i3, int i4) {
            super.initialize(i, i2, i3, i4);
            setRepeatCount(-1);
            setDuration((long) this.duration);
        }
    }

    public ShakeEggAnimFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void K(Activity activity) {
        for (View view : this.iQI) {
            view.clearAnimation();
            removeView(view);
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        setVisibility(0);
        for (int i = 0; i < 30; i++) {
            Animation bVar = new b(this, displayMetrics.widthPixels, displayMetrics.heightPixels);
            g.buU();
            com.tencent.mm.bf.b buL = com.tencent.mm.bf.b.buL();
            Drawable a = buL.a((c) buL.nnf.get(107));
            a.setBounds(0, 0, getSize(), getSize());
            ImageSpan imageSpan = new ImageSpan(a, 1);
            CharSequence spannableString = new SpannableString("  ");
            spannableString.setSpan(imageSpan, 0, 1, 33);
            View textView = new TextView(getContext());
            textView.setSingleLine();
            textView.setText(spannableString);
            textView.setAnimation(bVar);
            textView.setTag(bVar);
            addView(textView);
            ((a) bVar).targetView = textView;
            this.iQI.add(textView);
        }
    }

    static float k(float f, float f2) {
        return (((float) Math.random()) * (f2 - f)) + f;
    }

    private int getSize() {
        if (this.size == 0) {
            return (int) (((double) new TextView(getContext()).getTextSize()) * 1.2d);
        }
        return this.size;
    }
}
