package com.tencent.mm.ui.tools;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDebug;

public final class g {
    int QW = 0;
    int Zx = 0;
    private int aaL = 0;
    private final Context context;
    private int jCA = 0;
    private int jCB = 0;
    private float jCC = 0.0f;
    private float jCD = 0.0f;
    float jCE = 0.0f;
    float jCF = 1.0f;
    public int jCG = 0;
    public int jCH = 0;
    public int jCI = 0;
    public int jCJ = 0;
    public int jCK = 0;
    public int jCL = SQLiteDebug.MAIN_THREAD_SLOW_QUERY_THRESHOLD;
    int jCM = 0;
    int jCN = 1;
    int jCO = 2;
    int jCP = 3;
    int jCQ = 4;
    int jCR = this.jCM;
    private int jCx = 0;
    int jCy = 0;
    int jCz = 0;
    private ac mHandler = new ac();
    float oSI = 0.0f;
    public float oSJ = 1.0f;
    public float oSK = 1.0f;
    private int oSL = 0;
    int oSM = 0;
    private int oSN = 10;

    @TargetApi(18)
    public interface a {
        void n(int i, int i2, int i3, int i4);
    }

    public interface b {
        void onAnimationEnd();

        void onAnimationStart();
    }

    public interface c {
    }

    public g(Context context) {
        this.context = context;
    }

    public final void m(int i, int i2, int i3, int i4) {
        this.aaL = i;
        this.jCx = i2;
        this.Zx = i3;
        this.QW = i4;
    }

    public final void du(int i, int i2) {
        this.jCy = i;
        this.jCz = i2;
    }

    public final void dv(int i, int i2) {
        this.oSL = i;
        this.oSM = i2;
    }

    private void j(View view, boolean z) {
        int i;
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        if (this.aaL == 0 && this.jCx == 0) {
            this.aaL = view.getWidth() / 2;
            this.jCx = view.getHeight() / 2;
        }
        this.jCA = this.aaL - iArr[0];
        this.jCB = this.jCx - iArr[1];
        int width = view.getWidth();
        int height = view.getHeight();
        if (width == 0 || height == 0) {
            width = this.jCy;
            i = this.jCz;
            height = width;
        } else {
            i = height;
            height = width;
        }
        if (!(height == 0 || i == 0)) {
            this.jCC = ((float) this.Zx) / ((float) height);
            this.jCD = ((float) this.QW) / ((float) i);
        }
        float f = this.oSJ;
        if (!(this.jCH == 0 && this.jCI == 0 && this.jCJ == 0 && this.jCK == 0)) {
            f = 1.1f;
        }
        if (z) {
            if (!(this.jCy == 0 || this.jCz == 0)) {
                this.jCC = ((float) this.Zx) / ((float) this.jCy);
                this.jCD = ((float) this.QW) / ((float) this.jCz);
            }
            f = 1.0f;
        }
        if (((double) this.oSK) != 1.0d) {
            this.jCA += iArr[0];
            this.jCB += iArr[1];
            this.jCE = this.jCC * this.oSK;
            this.oSI = this.jCE;
            this.jCB = (int) (((float) this.jCB) - (((float) this.oSM) * this.jCE));
            this.jCA = (int) (((float) this.jCA) - (((float) this.oSL) * this.jCE));
            return;
        }
        if (this.jCC > this.jCD) {
            this.jCE = this.jCC * f;
            this.jCB = (int) (((float) this.jCB) - (((((float) i) * this.jCE) - (((float) this.QW) * f)) / 2.0f));
        } else {
            this.jCE = this.jCD * f;
            this.jCA = (int) (((float) this.jCA) - (((((float) height) * this.jCE) - (((float) this.Zx) * f)) / 2.0f));
            if (this.jCz != 0 && this.jCz < i) {
                this.jCB = (int) (((float) this.jCB) - (((((float) i) * this.jCE) - (((float) this.QW) * f)) / 2.0f));
            }
        }
        this.jCB = (int) ((((float) this.jCB) - ((((float) this.QW) * (f - 1.0f)) / 2.0f)) - ((((float) this.jCG) * this.jCE) / 2.0f));
        this.jCA = (int) (((float) this.jCA) - ((((float) this.Zx) * (f - 1.0f)) / 2.0f));
        if (this.jCz != 0 && this.jCx < (i - this.jCz) / 2) {
            this.jCB = (int) ((((f - 1.0f) * ((float) this.QW)) / 2.0f) + ((float) this.jCB));
        } else if (this.jCz != 0 && this.jCx + this.QW > (this.jCz + i) / 2) {
            this.jCB = (int) (((float) this.jCB) - (((f - 1.0f) * ((float) this.QW)) / 2.0f));
        }
        if (this.Zx == 0 && this.QW == 0) {
            this.jCE = 0.5f;
            this.jCF = 0.0f;
            this.jCA = (int) (((float) this.jCA) - ((((float) height) * this.jCE) / 2.0f));
            this.jCB = (int) ((((float) this.jCB) - ((((float) i) * this.jCE) / 2.0f)) - ((((float) this.jCG) * this.jCE) / 2.0f));
        }
    }

    @TargetApi(16)
    public final void a(final View view, View view2, final b bVar) {
        if (VERSION.SDK_INT >= 12 && view != null && this.jCR != this.jCO && this.jCR != this.jCQ && this.jCR != this.jCP) {
            j(view, false);
            view.setPivotX(0.0f);
            view.setPivotY(0.0f);
            view.setScaleX(this.jCE);
            view.setScaleY(this.jCE);
            view.setTranslationX((float) this.jCA);
            view.setTranslationY((float) this.jCB);
            if (view2 != null) {
                view2.setAlpha(0.0f);
                view2.animate().setDuration((long) this.jCL).setInterpolator(new DecelerateInterpolator(1.2f)).alpha(1.0f);
            }
            view.animate().setDuration((long) this.jCL).setInterpolator(new DecelerateInterpolator(1.2f)).scaleX(1.0f).scaleY(1.0f).translationX(0.0f).translationY(0.0f).setListener(new AnimatorListener(this) {
                final /* synthetic */ g oSP;

                public final void onAnimationStart(Animator animator) {
                    if (bVar != null) {
                        bVar.onAnimationStart();
                    }
                    this.oSP.jCR = this.oSP.jCO;
                }

                public final void onAnimationEnd(Animator animator) {
                    if (bVar != null) {
                        bVar.onAnimationEnd();
                    }
                    this.oSP.jCR = this.oSP.jCP;
                }

                public final void onAnimationCancel(Animator animator) {
                    this.oSP.jCR = this.oSP.jCP;
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            });
            this.mHandler.postDelayed(new Runnable(this) {
                final /* synthetic */ g oSP;

                public final void run() {
                    if (this.oSP.jCR == this.oSP.jCM) {
                        v.i("MicroMsg.ImagePreviewAnimation", "dancy enter Animation not Start!");
                        view.requestLayout();
                    }
                }
            }, (long) this.oSN);
        }
    }

    @TargetApi(16)
    public final void a(View view, View view2, final b bVar, a aVar) {
        if (VERSION.SDK_INT >= 12 && view != null && this.jCR != this.jCO && this.jCR != this.jCQ && this.jCR != this.jCN) {
            j(view, true);
            if (view2 != null) {
                view2.animate().setDuration(200).setInterpolator(new DecelerateInterpolator(1.2f)).alpha(0.0f);
            }
            Animation animationSet = new AnimationSet(true);
            final View view3 = view;
            final a aVar2 = aVar;
            Animation anonymousClass3 = new ScaleAnimation(this, this.jCE, this.jCE) {
                final /* synthetic */ g oSP;

                protected final void applyTransformation(float f, Transformation transformation) {
                    if (!(this.oSP.jCy == 0 || this.oSP.jCz == 0 || this.oSP.oSK != 1.0f)) {
                        Rect rect = new Rect();
                        view3.getGlobalVisibleRect(rect);
                        int i = (rect.right - rect.left) / 2;
                        int i2 = ((rect.bottom - rect.top) + this.oSP.jCG) / 2;
                        int i3 = (int) (((((float) (this.oSP.jCy - this.oSP.Zx)) * (1.0f - f)) + ((float) this.oSP.Zx)) / (1.0f - ((1.0f - this.oSP.jCE) * f)));
                        int i4 = (int) (((((float) (this.oSP.jCz - this.oSP.QW)) * (1.0f - f)) + ((float) this.oSP.QW)) / (1.0f - ((1.0f - this.oSP.jCE) * f)));
                        if (this.oSP.oSK != 1.0f) {
                            this.oSP.jCE = this.oSP.oSI / this.oSP.oSK;
                            i4 = rect.right;
                            i4 = rect.left;
                            i = (rect.right + rect.left) / 2;
                            i2 = (this.oSP.oSM - rect.top) + ((int) (((float) this.oSP.jCz) / 2.0f));
                            i3 = (int) (((((float) (this.oSP.jCy - this.oSP.Zx)) * (1.0f - f)) + ((float) this.oSP.Zx)) / (1.0f - ((1.0f - this.oSP.jCE) * f)));
                            i4 = (int) (((((float) (this.oSP.jCz - this.oSP.QW)) * (1.0f - f)) + ((float) this.oSP.QW)) / (1.0f - ((1.0f - this.oSP.jCE) * f)));
                        }
                        int i5 = (int) (((float) (i - (i3 / 2))) + ((((float) this.oSP.jCH) * f) / (1.0f - ((1.0f - this.oSP.jCE) * f))));
                        int i6 = (int) ((((float) (i2 - (i4 / 2))) - ((((float) this.oSP.jCG) * (1.0f - f)) / 2.0f)) + ((((float) this.oSP.jCJ) * f) / (1.0f - ((1.0f - this.oSP.jCE) * f))));
                        i3 = (int) (((float) ((i3 / 2) + i)) - ((((float) this.oSP.jCI) * f) / (1.0f - ((1.0f - this.oSP.jCE) * f))));
                        i4 = (int) (((float) ((i4 / 2) + i2)) - ((((float) this.oSP.jCK) * f) / (1.0f - ((1.0f - this.oSP.jCE) * f))));
                        if (VERSION.SDK_INT >= 21) {
                            view3.setClipBounds(new Rect(i5, i6, i3, i4));
                        } else if (VERSION.SDK_INT >= 18) {
                            if (aVar2 != null) {
                                aVar2.n(i5, i6, i3, i4);
                            } else {
                                view3.setClipBounds(new Rect(i5 + view3.getScrollX(), i6, i3 + view3.getScrollX(), i4));
                            }
                        }
                    }
                    super.applyTransformation(f, transformation);
                }
            };
            anonymousClass3.setDuration(200);
            anonymousClass3.setInterpolator(new DecelerateInterpolator(1.2f));
            animationSet.addAnimation(anonymousClass3);
            anonymousClass3 = new TranslateAnimation(0.0f, (float) this.jCA, 0.0f, (float) this.jCB);
            anonymousClass3.setDuration(200);
            anonymousClass3.setInterpolator(new DecelerateInterpolator(1.2f));
            animationSet.addAnimation(anonymousClass3);
            anonymousClass3 = new AlphaAnimation(1.0f, this.jCF);
            anonymousClass3.setDuration(200);
            anonymousClass3.setInterpolator(new DecelerateInterpolator(1.2f));
            animationSet.addAnimation(anonymousClass3);
            animationSet.setFillAfter(true);
            animationSet.setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ g oSP;

                public final void onAnimationStart(Animation animation) {
                    if (bVar != null) {
                        bVar.onAnimationStart();
                    }
                    this.oSP.jCR = this.oSP.jCQ;
                }

                public final void onAnimationEnd(Animation animation) {
                    if (bVar != null) {
                        bVar.onAnimationEnd();
                    }
                    this.oSP.jCR = this.oSP.jCN;
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            view.startAnimation(animationSet);
        }
    }
}
