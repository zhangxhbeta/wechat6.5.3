package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.v;

public class MaskLayout extends RelativeLayout {
    private ImageView fSE;
    private Drawable nZJ;
    public View view;

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] nZK = new int[a.bCN().length];

        static {
            try {
                nZK[a.nZN - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                nZK[a.nZO - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                nZK[a.nZM - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                nZK[a.nZL - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public enum a {
        ;

        public static int[] bCN() {
            return (int[]) nZQ.clone();
        }

        static {
            nZL = 1;
            nZM = 2;
            nZN = 3;
            nZO = 4;
            nZP = 5;
            nZQ = new int[]{nZL, nZM, nZN, nZO, nZP};
        }
    }

    public MaskLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaskLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.b.aPu, i, 0);
        this.nZJ = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.view = findViewById(2131755329);
        if (this.view == null) {
            v.d("MicroMsg.MaskLayout", "%s", "not found view by id, new one");
            this.view = new View(getContext());
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.view.setLayoutParams(layoutParams);
            addView(this.view);
        }
        this.fSE = new ImageView(getContext());
        this.fSE.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.fSE.setImageDrawable(this.nZJ);
        addView(this.fSE);
    }

    public final void bCL() {
        wB(a.nZP);
        this.fSE.setImageBitmap(null);
    }

    public final void bCM() {
        wB(a.nZP);
        this.fSE.setImageDrawable(null);
    }

    public final void d(Bitmap bitmap, int i) {
        wB(i);
        this.fSE.setImageBitmap(bitmap);
    }

    private void wB(int i) {
        removeView(this.fSE);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        switch (AnonymousClass1.nZK[i - 1]) {
            case 1:
                layoutParams.addRule(12);
                layoutParams.addRule(11);
                break;
            case 2:
                layoutParams.addRule(12);
                layoutParams.addRule(9);
                break;
            case 3:
                break;
            case 4:
                layoutParams.addRule(11);
                break;
            default:
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                break;
        }
        addView(this.fSE, layoutParams);
    }
}
