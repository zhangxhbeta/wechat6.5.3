package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;

public class BottleImageView extends ImageView {
    int VD;
    int VE;
    int VF;
    int VG;
    Context context;
    private int euA;
    private int euB;
    Animation euC = new Animation(this) {
        private float etA = 1.0f;
        private float etB = 0.1f;
        private float etw = -1.0f;
        private float etx = -1.0f;
        private float ety = -1.0f;
        private float etz = -1.0f;
        private float euD;
        private float euE;
        private float euF;
        private float euG;
        private float euH;
        private boolean euI = false;
        private float euJ = 0.0f;
        private float euK = -850.0f;
        private float euL = 1.0f;
        private float euM = 0.3f;
        final /* synthetic */ BottleImageView euN;

        {
            this.euN = r4;
        }

        protected final void applyTransformation(float f, Transformation transformation) {
            if (this.etw == -1.0f) {
                this.etw = (float) this.euN.VD;
                this.etx = (float) this.euN.VF;
                this.ety = (float) this.euN.VE;
                this.etz = (float) this.euN.VG;
                this.euD = this.etw + ((this.etx - this.etw) / 5.0f);
                this.euE = this.etw + (((this.etx - this.etw) * 3.0f) / 5.0f);
                this.euF = ((((this.euD - this.etw) / (this.etx - this.etw)) * (this.etz - this.ety)) + this.ety) - ((float) b.a(this.euN.context, 67.0f));
                this.euG = ((((this.euE - this.etw) / (this.etx - this.etw)) * (this.etz - this.ety)) + this.ety) - ((float) b.a(this.euN.context, 53.0f));
            }
            transformation.setAlpha(this.euL + ((this.euM - this.euL) * f));
            float f2 = this.etA + ((this.etB - this.etA) * f);
            transformation.getMatrix().setScale(f2, f2, (float) (this.euN.euA / 2), (float) (this.euN.euB / 2));
            transformation.getMatrix().postRotate(this.euJ + ((this.euK - this.euJ) * f), (float) (this.euN.euA / 2), (float) (this.euN.euB / 2));
            float f3 = ((this.etx - this.etw) * f) + this.etw;
            if (f3 >= this.euD) {
                f2 = (((f3 - this.etw) / (this.euD - this.etw)) * (this.euF - this.ety)) + this.ety;
            } else if (f3 >= this.euE) {
                if (!this.euI) {
                    this.euI = true;
                    this.euF = this.euH;
                }
                f2 = (((f3 - this.euD) / (this.euE - this.euD)) * (this.euG - this.euF)) + this.euF;
            } else {
                f2 = (((f3 - this.euE) / (this.etx - this.euE)) * (this.etz - this.euG)) + this.euG;
            }
            this.euH = f2;
            transformation.getMatrix().postTranslate(f3, f2);
            if (f == 1.0f) {
                this.etw = -1.0f;
                this.etx = -1.0f;
                this.ety = -1.0f;
                this.etz = -1.0f;
                this.euI = false;
            }
        }
    };

    public BottleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        XL();
    }

    public BottleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        XL();
    }

    private void XL() {
        Drawable background = getBackground();
        if (background != null) {
            this.euA = background.getIntrinsicWidth();
            this.euB = background.getIntrinsicHeight();
        }
    }
}
