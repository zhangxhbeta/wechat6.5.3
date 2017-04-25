package com.tencent.mm.plugin.sns.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;
import java.util.LinkedList;

public final class a {
    int QW = 0;
    int Zx = 0;
    private int aaL = 0;
    final Context context;
    int jCA = 0;
    int jCB = 0;
    private float jCC = 0.0f;
    private float jCD = 0.0f;
    float jCE = 0.0f;
    float jCF = 1.0f;
    int jCG = 0;
    int jCH = 0;
    int jCI = 0;
    int jCJ = 0;
    int jCK = 0;
    int jCL = 300;
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

    class AnonymousClass3 extends ScaleAnimation {
        final /* synthetic */ View jCT;
        final /* synthetic */ a jCV;
        final /* synthetic */ a jCX = null;

        AnonymousClass3(a aVar, float f, float f2, View view, a aVar2) {
            this.jCV = aVar;
            this.jCT = view;
            super(1.0f, f, 1.0f, f2);
        }

        protected final void applyTransformation(float f, Transformation transformation) {
            if (!(this.jCV.jCy == 0 || this.jCV.jCz == 0)) {
                Rect rect = new Rect();
                this.jCT.getGlobalVisibleRect(rect);
                int i = (rect.right - rect.left) / 2;
                int i2 = ((rect.bottom - rect.top) + this.jCV.jCG) / 2;
                int i3 = (int) (((((float) (this.jCV.jCy - this.jCV.Zx)) * (1.0f - f)) + ((float) this.jCV.Zx)) / (1.0f - ((1.0f - this.jCV.jCE) * f)));
                int i4 = (int) (((((float) (this.jCV.jCz - this.jCV.QW)) * (1.0f - f)) + ((float) this.jCV.QW)) / (1.0f - ((1.0f - this.jCV.jCE) * f)));
                int i5 = (int) (((float) (i - (i3 / 2))) + ((((float) this.jCV.jCH) * f) / (1.0f - ((1.0f - this.jCV.jCE) * f))));
                int i6 = (int) ((((float) (i2 - (i4 / 2))) - ((((float) this.jCV.jCG) * (1.0f - f)) / 2.0f)) + ((((float) this.jCV.jCJ) * f) / (1.0f - ((1.0f - this.jCV.jCE) * f))));
                i = (int) (((float) (i + (i3 / 2))) - ((((float) this.jCV.jCI) * f) / (1.0f - ((1.0f - this.jCV.jCE) * f))));
                i2 = (int) (((float) (i2 + (i4 / 2))) - ((((float) this.jCV.jCK) * f) / (1.0f - ((1.0f - this.jCV.jCE) * f))));
                if (VERSION.SDK_INT >= 21) {
                    this.jCT.setClipBounds(new Rect(i5, i6, i, i2));
                } else if (VERSION.SDK_INT >= 18 && this.jCX == null) {
                    this.jCT.setClipBounds(new Rect(i5 + this.jCT.getScrollX(), i6, i + this.jCT.getScrollX(), i2));
                }
            }
            super.applyTransformation(f, transformation);
        }
    }

    class AnonymousClass4 implements AnimationListener {
        final /* synthetic */ b jCS;
        final /* synthetic */ a jCV;

        AnonymousClass4(a aVar, b bVar) {
            this.jCV = aVar;
            this.jCS = bVar;
        }

        public final void onAnimationStart(Animation animation) {
            if (this.jCS != null) {
                this.jCS.onAnimationStart();
            }
            this.jCV.jCR = this.jCV.jCQ;
        }

        public final void onAnimationEnd(Animation animation) {
            if (this.jCS != null) {
                this.jCS.onAnimationEnd();
            }
            this.jCV.jCR = this.jCV.jCN;
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    @TargetApi(18)
    public interface a {
    }

    public interface b {
        void onAnimationEnd();

        void onAnimationStart();
    }

    public a(Context context) {
        this.context = context;
    }

    public final void m(int i, int i2, int i3, int i4) {
        this.aaL = i;
        this.jCx = i2;
        this.Zx = i3;
        this.QW = i4;
    }

    final void j(View view, boolean z) {
        int i;
        float f;
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
        if (this.jCH == 0 && this.jCI == 0 && this.jCJ == 0 && this.jCK == 0) {
            f = 1.0f;
        } else {
            f = 1.1f;
        }
        if (z) {
            if (!(this.jCy == 0 || this.jCz == 0)) {
                this.jCC = ((float) this.Zx) / ((float) this.jCy);
                this.jCD = ((float) this.QW) / ((float) this.jCz);
            }
            f = 1.0f;
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
    public final void a(final View view, final LinkedList<View> linkedList, View view2, final b bVar) {
        if (VERSION.SDK_INT >= 12 && view != null && this.jCR != this.jCO && this.jCR != this.jCQ && this.jCR != this.jCP) {
            j(view, false);
            int db = e.db(this.context);
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
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setAlpha(0.0f);
            }
            view.animate().setDuration((long) this.jCL).setInterpolator(new DecelerateInterpolator(1.2f)).scaleX(1.0f).scaleY(1.0f).translationX(0.0f).translationY((float) (-db)).setListener(new AnimatorListener(this) {
                final /* synthetic */ a jCV;

                public final void onAnimationStart(Animator animator) {
                    if (bVar != null) {
                        bVar.onAnimationStart();
                    }
                    this.jCV.jCR = this.jCV.jCO;
                }

                public final void onAnimationEnd(Animator animator) {
                    if (bVar != null) {
                        bVar.onAnimationEnd();
                    }
                    this.jCV.jCR = this.jCV.jCP;
                    ((WindowManager) this.jCV.context.getSystemService("window")).getDefaultDisplay().getHeight();
                    view.setTranslationY(0.0f);
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        View view = (View) it.next();
                        view.setVisibility(0);
                        view.setTranslationY(100.0f);
                        view.setAlpha(0.0f);
                        view.animate().setDuration((long) (this.jCV.jCL / 2)).setInterpolator(new DecelerateInterpolator(1.2f)).translationY(0.0f).alpha(1.0f).setListener(new AnimatorListener(this) {
                            final /* synthetic */ AnonymousClass1 jCW;

                            {
                                this.jCW = r1;
                            }

                            public final void onAnimationStart(Animator animator) {
                                if (bVar != null) {
                                    bVar.onAnimationStart();
                                }
                                this.jCW.jCV.jCR = this.jCW.jCV.jCO;
                            }

                            public final void onAnimationEnd(Animator animator) {
                                if (bVar != null) {
                                    bVar.onAnimationEnd();
                                }
                                this.jCW.jCV.jCR = this.jCW.jCV.jCP;
                            }

                            public final void onAnimationCancel(Animator animator) {
                                this.jCW.jCV.jCR = this.jCW.jCV.jCP;
                            }

                            public final void onAnimationRepeat(Animator animator) {
                            }
                        });
                    }
                }

                public final void onAnimationCancel(Animator animator) {
                    this.jCV.jCR = this.jCV.jCP;
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            });
            this.mHandler.postDelayed(new Runnable(this) {
                final /* synthetic */ a jCV;

                public final void run() {
                    if (this.jCV.jCR == this.jCV.jCM) {
                        v.i("MicroMsg.ImagePreviewAnimation", "dancy enter Animation not Start!");
                        view.requestLayout();
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            ((View) it.next()).requestLayout();
                        }
                    }
                }
            }, (long) this.jCL);
        }
    }
}
