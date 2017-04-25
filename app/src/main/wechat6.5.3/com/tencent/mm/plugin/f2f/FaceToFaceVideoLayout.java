package com.tencent.mm.plugin.f2f;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.v;

public class FaceToFaceVideoLayout extends RelativeLayout {
    private static final int[] fJq = new int[]{2131165502, 2131165503, 2131165501};
    private int count;
    private ah fIX = new ah(Looper.getMainLooper(), new a(this) {
        final /* synthetic */ FaceToFaceVideoLayout fJs;

        {
            this.fJs = r1;
        }

        public final boolean oU() {
            this.fJs.count = this.fJs.count + 1;
            if (this.fJs.count == FaceToFaceVideoLayout.fJq.length) {
                this.fJs.fJr = ObjectAnimator.ofFloat(this.fJs.fJk, "alpha", new float[]{1.0f, 0.0f});
                this.fJs.fJr.setDuration(150);
                this.fJs.fJr.addListener(new AnimatorListener(this) {
                    final /* synthetic */ AnonymousClass2 fJt;

                    {
                        this.fJt = r1;
                    }

                    public final void onAnimationStart(Animator animator) {
                    }

                    public final void onAnimationEnd(Animator animator) {
                        this.fJt.fJs.fJk.setVisibility(8);
                        this.fJt.fJs.fJj.setVisibility(8);
                        this.fJt.fJs.fJi.setVisibility(8);
                        this.fJt.fJs.fJk.setAlpha(1.0f);
                        if (!this.fJt.fJs.fJo && this.fJt.fJs.fIZ) {
                            this.fJt.fJs.fJe.setVisibility(0);
                        }
                    }

                    public final void onAnimationCancel(Animator animator) {
                    }

                    public final void onAnimationRepeat(Animator animator) {
                    }
                });
                this.fJs.fJr.start();
                this.fJs.count = 0;
                return false;
            }
            this.fJs.fJi.setImageResource(FaceToFaceVideoLayout.fJq[this.fJs.count]);
            return true;
        }
    }, true);
    private boolean fIZ = false;
    private FaceToFaceVideoView fJa;
    private DoodleBlackBoard fJb;
    private Button fJc;
    private ImageView fJd;
    private Button fJe;
    private ImageView fJf;
    private TextView fJg;
    private View fJh;
    private ImageView fJi;
    private TextView fJj;
    private ViewGroup fJk;
    private int fJl = 0;
    private boolean fJm;
    private boolean fJn = false;
    private boolean fJo = false;
    private boolean fJp = false;
    private ObjectAnimator fJr;

    public FaceToFaceVideoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d(attributeSet);
    }

    public FaceToFaceVideoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        d(attributeSet);
    }

    private void d(AttributeSet attributeSet) {
        LayoutParams layoutParams;
        inflate(getContext(), 2130903580, this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.b.aPe, 0, 0);
            this.fIZ = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
        this.fJa = (FaceToFaceVideoView) findViewById(2131756879);
        this.fJb = (DoodleBlackBoard) findViewById(2131756880);
        this.fJd = (ImageView) findViewById(2131756878);
        this.fJc = (Button) findViewById(2131756881);
        this.fJe = (Button) findViewById(2131756882);
        this.fJf = (ImageView) findViewById(2131756883);
        this.fJg = (TextView) findViewById(2131756885);
        this.fJh = findViewById(2131756884);
        this.fJi = (ImageView) findViewById(2131756887);
        this.fJj = (TextView) findViewById(2131756888);
        this.fJk = (ViewGroup) findViewById(2131756886);
        this.fJk.setVisibility(8);
        this.fJi.setVisibility(8);
        this.fJj.setVisibility(8);
        if (d.dW(16)) {
            this.fJg.setTypeface(Typeface.create("sans-serif-light", 0));
        }
        if (this.fIZ) {
            this.fJd.setVisibility(0);
            this.fJd.setColorFilter(getResources().getColor(2131689642), Mode.SRC_ATOP);
            this.fJb.setVisibility(8);
        } else {
            this.fJd.setVisibility(8);
            this.fJe.setVisibility(8);
            this.fJc.setVisibility(8);
        }
        if (this.fIZ) {
            layoutParams = this.fJa.getLayoutParams();
            layoutParams.height = (getContext().getResources().getDisplayMetrics().heightPixels / 2) - getContext().getResources().getDimensionPixelSize(2131493450);
            this.fJl = layoutParams.height;
        } else {
            layoutParams = this.fJa.getLayoutParams();
            layoutParams.height = -2;
            this.fJl = layoutParams.height;
        }
        this.fJa.setLayoutParams(layoutParams);
        this.fJa.fIZ = this.fIZ;
        if (!this.fIZ) {
            this.fJa.fJR = new FaceToFaceVideoView.a(this) {
                final /* synthetic */ FaceToFaceVideoLayout fJs;

                {
                    this.fJs = r1;
                }

                public final void bC(int i, int i2) {
                    v.i("MicroMsg.FaceToFaceLocalVideoLayout", "w %d h %d id %d,", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId())});
                    if (this.fJs.fJb != null) {
                        LayoutParams layoutParams = this.fJs.fJb.getLayoutParams();
                        layoutParams.height = i2;
                        layoutParams.width = i;
                        this.fJs.fJb.setLayoutParams(layoutParams);
                    }
                }

                public final void d(int i, int i2, float f) {
                    int i3 = 480;
                    int i4 = 384;
                    if (this.fJs.fJb != null) {
                        DoodleBlackBoard a = this.fJs.fJb;
                        v.i("MicroMsg.DoodleBlackBoard", "setTransformChange " + i + " " + i2 + " " + f);
                        if (f != 0.0f) {
                            float f2 = f / 2.0f;
                            v.v("MicroMsg.DoodleBlackBoard", "after SCALE_FACTOR " + f2);
                            int i5 = i * 2;
                            int i6 = i2 * 2;
                            int i7 = (int) (((float) i5) + (((float) a.fET) / f2));
                            int i8 = (int) ((((float) a.fEU) / f2) + ((float) i6));
                            v.i("MicroMsg.DoodleBlackBoard", "new size " + i5 + " " + i6 + " " + i7 + " " + i8);
                            if (i7 > 480) {
                                v.e("MicroMsg.DoodleBlackBoard", "error > width 480" + " 480");
                            } else {
                                i3 = i7;
                            }
                            if (i8 > 384) {
                                v.e("MicroMsg.DoodleBlackBoard", "error > HEIGHT 384" + " 384");
                            } else {
                                i4 = i8;
                            }
                            a.fIR = new Rect(i5, i6, i3, i4);
                        }
                    }
                }
            };
        }
        setVisibility(8);
        this.fJm = false;
    }
}
