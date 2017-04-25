package com.tencent.mm.plugin.emoji.ui.smiley;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.v;

public class SmileyPanelScrollView extends View {
    private static boolean DEBUG = false;
    private int QW;
    private int STATE_NONE = 0;
    private int Zx;
    private int aaL;
    private int aaM;
    f fks;
    private int flA;
    private int flB;
    private int flC;
    private int flD;
    private int flE;
    private boolean flF = false;
    private boolean flG = false;
    int flH = -1;
    int flI = -1;
    float flJ;
    boolean flK = false;
    private int flL = 1;
    private a flM = new a(this);
    b flq;
    private Drawable flr;
    private Drawable fls;
    private Drawable flt;
    int flu;
    int flv;
    private int flw;
    private Paint flx;
    private int fly;
    private int flz;
    private Context mContext;
    int mState = this.STATE_NONE;

    public class a implements Runnable {
        long flN;
        final /* synthetic */ SmileyPanelScrollView flO;
        long mStartTime;

        public a(SmileyPanelScrollView smileyPanelScrollView) {
            this.flO = smileyPanelScrollView;
        }

        final void ahC() {
            this.flN = 300;
            this.mStartTime = SystemClock.uptimeMillis();
            g.iuh.h(13361, new Object[]{Integer.valueOf(0)});
        }

        public final void run() {
            ahC();
        }
    }

    public interface b {
        void jU(int i);
    }

    public SmileyPanelScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public SmileyPanelScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.fls = this.mContext.getResources().getDrawable(2130839197);
        this.flr = this.mContext.getResources().getDrawable(2130839196);
        this.flt = this.mContext.getResources().getDrawable(2130839199);
        this.fly = com.tencent.mm.bd.a.fromDPToPix(this.mContext, 12);
        this.flz = this.flr.getIntrinsicHeight();
        this.flA = this.flr.getIntrinsicWidth();
        this.flB = this.flt.getIntrinsicHeight();
        this.flD = this.fls.getIntrinsicHeight();
        this.flE = this.fls.getIntrinsicWidth();
        v.d("MicroMsg.SmileyPanelScrollView", "init mDotPadding:%d mDotHeight:%d mDotWidth:%d", new Object[]{Integer.valueOf(this.fly), Integer.valueOf(this.flz), Integer.valueOf(this.flA)});
        this.flx = new Paint();
        this.flx.setColor(-65536);
        this.flx.setAntiAlias(true);
        this.flx.setTextAlign(Align.CENTER);
        this.Zx = getMeasuredWidth();
        this.QW = getMeasuredHeight();
        this.flw = this.flC / (this.flA + this.fly);
        v.d("MicroMsg.SmileyPanelScrollView", "init mWidth:%d mHeight:%d mTrackWidth:%d mMaxDot:%d", new Object[]{Integer.valueOf(this.Zx), Integer.valueOf(this.QW), Integer.valueOf(this.flC), Integer.valueOf(this.flw)});
    }

    public void draw(Canvas canvas) {
        int i;
        int i2;
        super.draw(canvas);
        a aVar = this.flM;
        if (aVar.flO.mState != aVar.flO.flL) {
            i = 102;
        } else {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (uptimeMillis > aVar.mStartTime + aVar.flN) {
                i2 = 255;
            } else {
                i2 = ((int) (((uptimeMillis - aVar.mStartTime) * 153) / aVar.flN)) + 102;
                if (i2 < 102) {
                    i2 = 102;
                }
            }
            i = i2;
        }
        int i3;
        int i4;
        int i5;
        if (this.flu > this.flw) {
            this.flF = true;
            i3 = (this.QW - this.flB) / 2;
            i4 = (this.Zx - this.flC) / 2;
            this.aaL = i4 - (this.flE / 2);
            this.aaM = (this.aaL + this.flC) + this.flE;
            if (DEBUG) {
                canvas.drawLine((float) this.aaL, 0.0f, (float) this.aaL, (float) this.QW, this.flx);
                canvas.drawLine((float) this.aaM, 0.0f, (float) this.aaM, (float) this.QW, this.flx);
            }
            this.flt.setBounds(i4, i3, this.flC + i4, this.flB + i3);
            this.flt.setAlpha(i);
            this.flt.draw(canvas);
            i5 = (this.QW - this.flD) / 2;
            if (this.flG || this.flK) {
                i2 = (((this.flC / (this.flu - 1)) * this.flv) + i4) - (this.flE / 2);
            } else if (this.flI == this.flH) {
                i2 = ((((this.flC / (this.flu - 1)) * this.flH) + i4) - (this.flE / 2)) + ((int) (((float) (this.flC / (this.flu - 1))) * this.flJ));
            } else {
                i2 = ((((this.flC / (this.flu - 1)) * this.flH) + i4) - (this.flE / 2)) - ((int) (((float) (this.flC / (this.flu - 1))) * (1.0f - this.flJ)));
            }
            this.fls.setBounds(i2, i5, this.flE + i2, this.flD + i5);
            this.fls.draw(canvas);
        } else {
            this.flF = false;
            i3 = (this.QW - this.flz) / 2;
            i4 = (this.Zx - (((this.fly + this.flA) * (this.flu - 1)) + this.flA)) / 2;
            this.aaL = i4 - ((this.flE - this.flA) / 2);
            this.aaM = ((this.aaL + (this.flA * this.flu)) + (this.fly * (this.flu - 1))) + (this.flE - this.flA);
            if (DEBUG) {
                canvas.drawLine((float) this.aaL, 0.0f, (float) this.aaL, (float) this.QW, this.flx);
                canvas.drawLine((float) this.aaM, 0.0f, (float) this.aaM, (float) this.QW, this.flx);
            }
            this.flr.setBounds(i4, i3, this.flA + i4, this.flz + i3);
            i5 = (this.QW - this.flD) / 2;
            if (this.flG || this.flK) {
                i2 = i4 - ((this.flE - this.flA) / 2);
            } else if (this.flI == this.flH) {
                i2 = (i4 - ((this.flE - this.flA) / 2)) + ((int) (((float) (this.flA + this.fly)) * this.flJ));
            } else {
                i2 = (i4 - ((this.flE - this.flA) / 2)) - ((int) (((float) (this.flA + this.fly)) * (1.0f - this.flJ)));
            }
            this.fls.setBounds(i2, i5, this.flE + i2, this.flD + i5);
            for (i5 = 0; i5 < this.flu; i5++) {
                canvas.save();
                if (i5 > 0) {
                    canvas.translate((float) ((this.flA + this.fly) * i5), 0.0f);
                }
                this.flr.setAlpha(i);
                this.flr.draw(canvas);
                canvas.restore();
            }
            if (this.flH > this.flu - 1) {
                this.flH = this.flu - 1;
            }
            i5 = (this.flA + this.fly) * this.flH;
            if (i2 + i5 > this.aaM) {
                i2 = 0;
                v.i("MicroMsg.SmileyPanelScrollView", "over right.");
            } else {
                i2 = i5;
            }
            canvas.save();
            canvas.translate((float) i2, 0.0f);
            this.fls.draw(canvas);
            canvas.restore();
        }
        if (this.mState == this.flL && i < 255) {
            invalidate();
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != this.Zx) {
            this.Zx = getMeasuredWidth();
            this.QW = getMeasuredHeight();
            this.flC = (this.Zx - (this.fks.getColumnWidth() - this.fks.flV)) - (com.tencent.mm.bd.a.N(this.mContext, 2131493201) * 2);
            this.flw = this.flC / (this.flA + this.fly);
            v.d("MicroMsg.SmileyPanelScrollView", "onSizeChanged mWidth:%d mHeight:%d mTrackWidth:%d mMaxDot:%d", new Object[]{Integer.valueOf(this.Zx), Integer.valueOf(this.QW), Integer.valueOf(this.flC), Integer.valueOf(this.flw)});
            if (this.QW == 0) {
                v.i("MicroMsg.SmileyPanelScrollView", "user default height");
                this.QW = com.tencent.mm.bd.a.fromDPToPix(this.mContext, 16);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        if (x < this.aaL - this.fly || x > this.aaM + this.fly) {
            v.d("MicroMsg.SmileyPanelScrollView", "over x :%d mLeft:%d mRight:%d ", new Object[]{Integer.valueOf(x), Integer.valueOf(this.aaL), Integer.valueOf(this.aaM)});
            if (action == 0) {
                return super.onTouchEvent(motionEvent);
            }
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            if (x < this.aaL) {
                x = this.aaL;
            }
            if (x > this.aaM) {
                x = this.aaM;
            }
            if (this.flF) {
                x = (x - this.aaL) / (this.flC / (this.flu - 1));
            } else {
                x = ((x - this.aaL) + this.fly) / (this.flA + this.fly);
            }
            if (x > this.flu - 1) {
                x = this.flu - 1;
            }
            this.flq.jU(x);
            this.flH = x;
            this.flI = x;
        }
        switch (action) {
            case 0:
                if (!z) {
                    this.flG = true;
                    this.flK = true;
                    this.mState = this.flL;
                    this.flM.ahC();
                    invalidate();
                    break;
                }
                break;
            case 1:
            case 3:
                this.mState = this.STATE_NONE;
                this.flG = false;
                invalidate();
                break;
            case 2:
                if (!(z || this.mState == this.flL)) {
                    this.mState = this.flL;
                    this.flM.ahC();
                    invalidate();
                    break;
                }
        }
        return true;
    }
}
