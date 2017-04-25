package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.a;

public class BallonImageView extends ImageView {
    private Animation ett = new Animation(this) {
        private float etA = 1.0f;
        private float etB = AnonymousClass1.k(0.7f, 1.0f);
        private float etC;
        private float etD;
        private float etE;
        private float etF;
        final /* synthetic */ BallonImageView etG;
        private int etu;
        private int etv;
        private float etw = 0.1f;
        private float etx = AnonymousClass1.k(0.1f, 0.8f);
        private float ety = 0.1f;
        private float etz = AnonymousClass1.k(0.1f, 0.3f);

        {
            this.etG = r4;
        }

        protected final void applyTransformation(float f, Transformation transformation) {
            float f2 = this.etC;
            float f3 = this.etE;
            if (this.etC != this.etD) {
                f2 = this.etC + ((this.etD - this.etC) * f);
            }
            if (this.etE != this.etF) {
                f3 = this.etE + ((this.etF - this.etE) * f);
            }
            transformation.getMatrix().setTranslate(f2, f3);
            f2 = this.etA + ((this.etB - this.etA) * f);
            transformation.getMatrix().postScale(f2, f2);
            if (f == 1.0f) {
                this.etw = this.etx;
                this.ety = this.etz;
                this.etx = AnonymousClass1.k(0.1f, 0.8f);
                this.etz = AnonymousClass1.k(0.1f, 0.3f);
                this.etA = this.etB;
                this.etB = AnonymousClass1.k(0.7f, 1.0f);
                XI();
            }
        }

        public final void initialize(int i, int i2, int i3, int i4) {
            super.initialize(i, i2, i3, i4);
            this.etu = i3;
            this.etv = i4;
            XI();
        }

        private void XI() {
            this.etC = this.etw * ((float) this.etu);
            this.etD = this.etx * ((float) this.etu);
            this.etE = this.ety * ((float) this.etv);
            this.etF = this.etz * ((float) this.etv);
        }

        private static float k(float f, float f2) {
            return (((float) Math.random()) * (f2 - f)) + f;
        }
    };

    public BallonImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ett.setRepeatCount(-1);
        this.ett.setDuration(15000);
        this.ett.setFillAfter(true);
    }

    public BallonImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ett.setRepeatCount(-1);
        this.ett.setDuration(15000);
        this.ett.setFillAfter(true);
    }

    public void setVisibility(int i) {
        if (i == 0) {
            setAnimation(this.ett);
        } else {
            a.c(this, this.ett);
        }
        super.setVisibility(i);
    }
}
