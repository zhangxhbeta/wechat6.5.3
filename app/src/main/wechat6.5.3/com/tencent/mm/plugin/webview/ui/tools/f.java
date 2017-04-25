package com.tencent.mm.plugin.webview.ui.tools;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.plugin.webview.ui.tools.LogoWebViewWrapper.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class f implements b {
    boolean dCD = false;
    private boolean ljA = false;
    private boolean ljB = false;
    private int ljC = 0;
    private float ljD = 0.0f;
    private ValueAnimator ljE;
    ViewPropertyAnimator ljF;
    private float ljG;
    View ljH;
    public View ljI;
    TextView ljJ;
    boolean ljK;
    boolean ljL = false;
    a ljw;
    ImageView ljx;
    LogoWebViewWrapper ljy;
    int ljz = 0;

    public interface a {
        void bjV();
    }

    public final void bjU() {
        this.dCD = false;
        stopLoading();
        if (this.ljK && this.ljI != null && !this.ljL) {
            hx(false);
            this.ljy.liv = 0;
            this.ljI.setVisibility(0);
        }
    }

    public final void startLoading() {
        if (!this.ljA && this.ljx != null && this.ljy != null) {
            this.ljA = true;
            this.ljy.hx(true);
            this.ljx.clearAnimation();
            if (this.ljE != null) {
                this.ljE.cancel();
            }
            this.ljE = ObjectAnimator.ofFloat(this, "startLoadingStep", new float[]{this.ljD + 0.0f, this.ljD + 354.0f});
            this.ljE.setDuration(960);
            this.ljE.setRepeatMode(1);
            this.ljE.setRepeatCount(-1);
            this.ljE.setInterpolator(new LinearInterpolator());
            this.ljE.start();
            if (this.ljw != null) {
                this.ljw.bjV();
            }
        }
    }

    public final void stopLoading() {
        if (this.ljA) {
            v.d("MicroMsg.WebViewPullDownLogoDelegate", "stopLoading()");
            this.ljB = true;
            this.ljA = false;
            if (this.ljy != null && this.dCD) {
                this.ljy.hx(false);
            }
            if (this.ljE != null) {
                this.ljE.cancel();
            }
            if (this.ljy != null) {
                this.ljy.y(0, 250);
            }
            if (this.ljx != null) {
                v.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage, alpha to 0f");
                this.ljx.animate().alpha(0.0f).setDuration(500).start();
            }
        }
    }

    public final void release() {
        if (this.ljy != null) {
            LogoWebViewWrapper logoWebViewWrapper = this.ljy;
            if (logoWebViewWrapper.lin != null) {
                logoWebViewWrapper.lin.removeView(logoWebViewWrapper.eQN);
                logoWebViewWrapper.eQN = null;
            }
            logoWebViewWrapper = this.ljy;
            logoWebViewWrapper.lix = null;
            logoWebViewWrapper.liw = null;
        }
        if (this.ljH != null) {
            ((ViewGroup) this.ljH).removeAllViews();
        }
        this.ljy = null;
        this.ljx = null;
        this.ljC = 0;
        if (this.ljE != null) {
            this.ljE.cancel();
            this.ljE = null;
        }
    }

    public final void sZ(int i) {
        if (this.ljH != null) {
            this.ljH.setBackgroundColor(i);
        }
    }

    public final void P(int i, boolean z) {
        String str = "MicroMsg.WebViewPullDownLogoDelegate";
        String str2 = "onOverScrollOffset, offset = %d, pointerDown = %b, refreshImage.visibility = %s, refreshImage.drawable = %s, refreshImage.alpha = %s";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = this.ljx == null ? "null" : String.valueOf(this.ljx.getVisibility());
        objArr[3] = this.ljx == null ? "null" : this.ljx.getDrawable().toString();
        objArr[4] = this.ljx == null ? "null" : String.valueOf(this.ljx.getAlpha());
        v.v(str, str2, objArr);
        if (this.dCD) {
            if (i == 0) {
                this.ljB = false;
            }
            if (this.ljx != null) {
                if (z) {
                    if (Math.abs(i) >= this.ljz) {
                        if (this.ljy != null) {
                            this.ljy.liv = this.ljz;
                        }
                    } else if (this.ljy != null) {
                        this.ljy.liv = 0;
                    }
                } else if (Math.abs(i) > this.ljz && !this.ljA) {
                    v.d("MicroMsg.WebViewPullDownLogoDelegate", "startLoading()");
                    startLoading();
                    return;
                } else if (this.ljA) {
                    return;
                }
                if (this.ljx != null && this.ljx.getAlpha() < 1.0f && this.ljF == null && z) {
                    v.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage alpha to 1.0f");
                    this.ljF = this.ljx.animate().alpha(1.0f).setDuration(500);
                    this.ljF.setListener(new AnimatorListenerAdapter(this) {
                        final /* synthetic */ f ljM;

                        {
                            this.ljM = r1;
                        }

                        public final void onAnimationCancel(Animator animator) {
                            super.onAnimationCancel(animator);
                            this.ljM.ljF = null;
                        }

                        public final void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            this.ljM.ljF = null;
                        }
                    });
                    this.ljF.start();
                }
                if (!this.ljB) {
                    int i2 = (-i) - this.ljC;
                    if (Math.abs(i) >= this.ljz) {
                        i2 *= 5;
                    } else {
                        i2 *= 2;
                    }
                    this.ljC = -i;
                    float height = (float) (this.ljx.getHeight() / 2);
                    float width = (float) (this.ljx.getWidth() / 2);
                    this.ljD -= (float) i2;
                    this.ljx.setScaleType(ScaleType.MATRIX);
                    Matrix imageMatrix = this.ljx.getImageMatrix();
                    imageMatrix.postRotate((float) (-i2), width, height);
                    this.ljx.setImageMatrix(imageMatrix);
                    this.ljx.setImageResource(2130839545);
                }
                this.ljx.invalidate();
            }
        }
    }

    public final float getStartLoadingStep() {
        return this.ljG;
    }

    public final void setStartLoadingStep(float f) {
        float f2 = 0.0f;
        this.ljG = f;
        this.ljx.setScaleType(ScaleType.MATRIX);
        Matrix imageMatrix = this.ljx.getImageMatrix();
        float width = this.ljx == null ? 0.0f : ((float) this.ljx.getWidth()) / 2.0f;
        if (this.ljx != null) {
            f2 = ((float) this.ljx.getHeight()) / 2.0f;
        }
        imageMatrix.setRotate(f, width, f2);
        this.ljD = f;
        this.ljx.invalidate();
    }

    public final void hx(boolean z) {
        if (this.ljy != null && this.ljy.lit != z) {
            this.ljy.hx(z);
            if (this.ljI != null) {
                this.ljI.setVisibility(8);
            }
            this.ljL = z;
        }
    }

    public final void Fb(String str) {
        if (!this.ljK || this.ljL) {
            hx(true);
            if (this.ljI != null && this.ljI.getVisibility() == 0) {
                this.ljI.setVisibility(8);
            }
        } else if (this.ljJ != null) {
            if (!be.kS(str)) {
                if (!be.kS(Uri.parse(str).getHost())) {
                    CharSequence string = this.ljJ.getContext().getString(2131236611, new Object[]{r0});
                    this.ljJ.setVisibility(0);
                    this.ljJ.setText(string);
                    hx(false);
                    return;
                }
            }
            this.ljJ.setVisibility(8);
        }
    }
}
