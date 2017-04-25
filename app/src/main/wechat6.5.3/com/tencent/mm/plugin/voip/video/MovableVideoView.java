package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.bd.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.s;

public class MovableVideoView extends OpenGlView {
    int Zx;
    int kAQ;
    private float kAR;
    private float kAS;
    private int kAT;
    private int kAU;
    private long kAV;
    private OnClickListener mOnClickListener;
    private int mScreenHeight;
    private int mScreenWidth;

    public MovableVideoView(Context context) {
        this(context, null);
    }

    public MovableVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Zx = 320;
        this.kAQ = 240;
        this.kAT = 800;
        this.kAU = 480;
        this.mScreenWidth = 0;
        this.mScreenHeight = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        v.d("MicroMsg.MovableVideoView", "event: " + motionEvent.getAction());
        switch (motionEvent.getAction()) {
            case 0:
                this.kAR = motionEvent.getRawX();
                this.kAS = motionEvent.getRawY();
                this.kAV = System.currentTimeMillis();
                break;
            case 1:
                long currentTimeMillis = System.currentTimeMillis();
                if (this.kAV != 0 && currentTimeMillis - this.kAV < 300 && currentTimeMillis - this.kAV >= 0 && this.mOnClickListener != null) {
                    this.mOnClickListener.onClick(this);
                }
                g.iuh.h(11079, new Object[]{Integer.valueOf(2)});
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.kAR;
                float rawY = motionEvent.getRawY() - this.kAS;
                if (Math.abs(rawX) > 1.0f || Math.abs(rawY) > 1.0f) {
                    LayoutParams layoutParams = (LayoutParams) getLayoutParams();
                    int i2 = (int) (rawX + ((float) layoutParams.leftMargin));
                    int i3 = (int) (rawY + ((float) layoutParams.topMargin));
                    if (i2 < 0) {
                        i2 = 0;
                    } else if (i2 > this.kAU) {
                        i2 = this.kAU;
                    }
                    layoutParams.leftMargin = i2;
                    if (i3 >= 0) {
                        i = i3 > this.kAT ? this.kAT : i3;
                    }
                    layoutParams.topMargin = i;
                    setLayoutParams(layoutParams);
                    this.kAR = motionEvent.getRawX();
                    this.kAS = motionEvent.getRawY();
                    break;
                }
        }
        return true;
    }

    public final void cD(int i, int i2) {
        this.Zx = i;
        this.kAQ = i2;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        if (this.mScreenWidth == 0) {
            this.mScreenWidth = windowManager.getDefaultDisplay().getWidth();
            this.mScreenHeight = windowManager.getDefaultDisplay().getHeight();
        }
        ViewGroup.LayoutParams layoutParams = new LayoutParams(i, i2);
        layoutParams.topMargin = a.fromDPToPix(getContext(), 12) + s.eA(getContext());
        layoutParams.leftMargin = ((this.mScreenWidth - this.Zx) - layoutParams.topMargin) + s.eA(getContext());
        setLayoutParams(layoutParams);
        this.kAT = this.mScreenHeight - this.kAQ;
        this.kAU = this.mScreenWidth - this.Zx;
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
    }

    public final void cE(int i, int i2) {
        cD(i, i2);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public final void cF(int i, int i2) {
        LayoutParams layoutParams = (LayoutParams) getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = new LayoutParams(i, i2);
        layoutParams2.leftMargin = layoutParams.leftMargin;
        layoutParams2.topMargin = layoutParams.topMargin;
        this.Zx = i;
        this.kAQ = i2;
        setLayoutParams(layoutParams2);
    }
}
