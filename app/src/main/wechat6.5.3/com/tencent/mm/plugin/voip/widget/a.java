package com.tencent.mm.plugin.voip.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.sdk.platformtools.v;

public final class a extends BaseSmallView {
    private boolean Ox;
    private OpenGlRender kCD;
    private OpenGlView kCE;
    private OpenGlRender kCF;
    private OpenGlView kCG;
    private int[] kCH = null;
    private int kCI = 0;
    private float kCJ;
    private Runnable kCK = new Runnable(this) {
        final /* synthetic */ a kCM;

        {
            this.kCM = r1;
        }

        public final void run() {
            this.kCM.kCG.setVisibility(4);
        }
    };
    private Runnable kCL = new Runnable(this) {
        final /* synthetic */ a kCM;

        {
            this.kCM = r1;
        }

        public final void run() {
            this.kCM.kCG.setVisibility(0);
        }
    };

    public a(Context context, float f) {
        super(context, null);
        LayoutInflater.from(context).inflate(2130904600, this);
        this.kCJ = f;
        this.kCE = (OpenGlView) findViewById(2131759755);
        this.kCD = new OpenGlRender(this.kCE, OpenGlRender.kBA);
        this.kCE.a(this.kCD);
        this.kCE.setRenderMode(0);
        this.kCG = (OpenGlView) findViewById(2131759756);
        this.kCF = new OpenGlRender(this.kCG, OpenGlRender.kBz);
        this.kCG.a(this.kCF);
        this.kCG.setRenderMode(0);
        this.kCG.setZOrderMediaOverlay(true);
        this.kCG.setVisibility(4);
        this.fnw.postDelayed(new Runnable(this) {
            final /* synthetic */ a kCM;

            {
                this.kCM = r1;
            }

            public final void run() {
                this.kCM.findViewById(2131759757).setVisibility(8);
            }
        }, 3000);
        this.fnw.postDelayed(this.kCL, 1000);
        this.fnw.postDelayed(this.kCK, 4000);
    }

    public final void cG(int i, int i2) {
        LayoutParams layoutParams = (LayoutParams) this.kCG.getLayoutParams();
        layoutParams.height = i2 / 4;
        layoutParams.width = (int) (this.kCJ * ((float) layoutParams.height));
        this.kCG.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = (WindowManager.LayoutParams) getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new WindowManager.LayoutParams();
        }
        layoutParams2.width = i;
        layoutParams2.height = i2;
        setLayoutParams(layoutParams2);
    }

    private void bdV() {
        if (!this.Ox) {
            this.Ox = true;
            this.kCD.kBg = true;
            this.kCF.kBg = true;
        }
    }

    public final void a(int i, int i2, int[] iArr) {
        bdV();
        if (OpenGlRender.kBL == 1) {
            this.kCD.a(iArr, i, i2, OpenGlRender.kBq + OpenGlRender.kBw);
        } else {
            this.kCD.a(iArr, i, i2, OpenGlRender.kBt + OpenGlRender.kBw);
        }
    }

    public final void bck() {
        if (this.Ox) {
            this.kCF.bdO();
            this.kCD.bdO();
        }
    }

    public final void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5) {
        if (this.kCG.getVisibility() == 0) {
            bdV();
            if (OpenGlRender.kBL == 1) {
                if (this.kCI < i * i2) {
                    this.kCH = null;
                }
                if (this.kCH == null) {
                    this.kCI = i * i2;
                    this.kCH = new int[this.kCI];
                }
                if (d.bbw().a(bArr, (int) j, i3 & 31, i, i2, this.kCH) >= 0 && this.kCH != null) {
                    this.kCF.a(this.kCH, i, i2, (OpenGlRender.kBr + i4) + i5);
                }
            } else if (OpenGlRender.kBL == 2) {
                this.kCF.b(bArr, i, i2, (OpenGlRender.kBv + i4) + i5);
            }
        }
    }

    public final void uninit() {
        super.uninit();
        setVisibility(4);
        if (this.Ox) {
            this.kCD.bdN();
            this.kCF.bdN();
        }
        this.fnw.removeCallbacks(this.kCK);
    }

    public final void a(CaptureView captureView) {
        v.h("MicroMsg.Voip.BaseSmallView", "addCaptureView", new Object[0]);
        if (this.ktM != null) {
            removeView(this.ktM);
            this.ktM = null;
        }
        if (captureView != null) {
            this.ktM = captureView;
            ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(1, 1);
            layoutParams.leftMargin = 20;
            layoutParams.topMargin = 20;
            addView(captureView, layoutParams);
            captureView.setVisibility(0);
            v.d("MicroMsg.Voip.BaseSmallView", "CaptureView added");
        }
    }

    protected final void bds() {
        this.kCG.setVisibility(0);
        this.fnw.removeCallbacks(this.kCK);
        this.fnw.postDelayed(this.kCK, 3000);
    }

    protected final void bdt() {
        this.kCD.bdN();
        this.kCF.bdN();
    }

    protected final void onAnimationEnd() {
        this.kCD.kBg = true;
        this.kCF.kBg = true;
    }
}
