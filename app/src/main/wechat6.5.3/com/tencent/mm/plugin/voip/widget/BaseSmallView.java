package com.tencent.mm.plugin.voip.widget;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;

public abstract class BaseSmallView extends FrameLayout {
    private WindowManager fjE;
    protected ac fnw;
    private Point kCA;
    private Runnable kCB = new Runnable(this) {
        final /* synthetic */ BaseSmallView kCC;

        {
            this.kCC = r1;
        }

        public final void run() {
            float currentTimeMillis = (((float) (System.currentTimeMillis() - this.kCC.mStartTime)) * 1.0f) / 200.0f;
            if (currentTimeMillis <= 1.0f) {
                this.kCC.fnw.postDelayed(this.kCC.kCB, 5);
                this.kCC.cH(this.kCC.kCy.x + ((int) (((((float) this.kCC.kCz.x) * 1.0f) - ((float) this.kCC.kCy.x)) * currentTimeMillis)), ((int) (currentTimeMillis * ((((float) this.kCC.kCz.y) * 1.0f) - ((float) this.kCC.kCy.y)))) + this.kCC.kCy.y);
                return;
            }
            this.kCC.cH(this.kCC.kCz.x, this.kCC.kCz.y);
            this.kCC.onAnimationEnd();
        }
    };
    private PointF kCw = new PointF();
    private Point kCx = new Point();
    private Point kCy = new Point();
    private Point kCz = new Point();
    CaptureView ktM;
    protected long ktX;
    private OnClickListener mOnClickListener;
    private long mStartTime;

    public abstract void a(CaptureView captureView);

    public abstract void bds();

    public abstract void bdt();

    public abstract void onAnimationEnd();

    public void a(int i, int i2, int[] iArr) {
    }

    public void bck() {
    }

    public void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5) {
    }

    public void cG(int i, int i2) {
    }

    public void uninit() {
        this.fnw.removeCallbacks(this.kCB);
        this.fjE = null;
        if (this.ktM != null) {
            removeView(this.ktM);
            this.ktM = null;
            v.d("MicroMsg.Voip.BaseSmallView", "CaptureView removed");
        }
    }

    public BaseSmallView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fjE = (WindowManager) context.getSystemService("window");
        this.fnw = new ac();
        this.kCA = new Point(this.fjE.getDefaultDisplay().getWidth(), this.fjE.getDefaultDisplay().getHeight());
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.kCw.x = motionEvent.getRawX();
                this.kCw.y = motionEvent.getRawY();
                LayoutParams layoutParams = (LayoutParams) getLayoutParams();
                this.kCx.x = layoutParams.x;
                this.kCx.y = layoutParams.y;
                break;
            case 1:
                if (Math.abs(motionEvent.getRawX() - this.kCw.x) < ((float) b.a(getContext(), 3.0f)) && Math.abs(motionEvent.getRawY() - this.kCw.y) < ((float) b.a(getContext(), 3.0f)) && this.mOnClickListener != null) {
                    this.mOnClickListener.onClick(this);
                }
                bds();
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                this.kCy.x = (int) Math.max(Math.min((rawX + ((float) this.kCx.x)) - this.kCw.x, (float) this.kCA.x), 0.0f);
                this.kCy.y = (int) Math.max(Math.min((rawY + ((float) this.kCx.y)) - this.kCw.y, (float) this.kCA.y), 0.0f);
                int a = b.a(getContext(), 5.0f);
                if (this.kCy.x + (getWidth() / 2) <= this.kCA.x / 2) {
                    this.kCz.x = a;
                } else {
                    this.kCz.x = (this.kCA.x - getWidth()) - a;
                }
                this.kCz.y = this.kCy.y;
                this.mStartTime = System.currentTimeMillis();
                this.fnw.postDelayed(this.kCB, 5);
                bdt();
                break;
            case 2:
                cH((int) Math.max(Math.min((((float) this.kCx.x) + motionEvent.getRawX()) - this.kCw.x, (float) this.kCA.x), 0.0f), (int) Math.max(Math.min((((float) this.kCx.y) + motionEvent.getRawY()) - this.kCw.y, (float) this.kCA.y), 0.0f));
                break;
        }
        return true;
    }

    private void cH(int i, int i2) {
        if (this.fjE != null) {
            LayoutParams layoutParams = (LayoutParams) getLayoutParams();
            layoutParams.x = i;
            layoutParams.y = i2;
            v.d("MicroMsg.Voip.BaseSmallView", "updateWindowPosition, x: %d, y: %d", new Object[]{Integer.valueOf(layoutParams.x), Integer.valueOf(layoutParams.y)});
            try {
                this.fjE.updateViewLayout(this, layoutParams);
            } catch (Throwable th) {
                v.a("MicroMsg.Voip.BaseSmallView", th, "", new Object[0]);
            }
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public final void dr(long j) {
        this.ktX = j;
    }
}
