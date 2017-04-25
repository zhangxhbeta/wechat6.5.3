package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import com.tencent.mm.bi.a.f;
import com.tencent.mmdb.database.SQLiteDebug;
import com.tencent.smtt.sdk.WebView;

public class MMSwitchBtn extends View {
    private int gpY;
    private Paint hCd = new Paint(1);
    private int maxHeight;
    private int maxWidth;
    private float pda;
    private float pdb;
    private long pdc;
    private int pdd;
    private int pde;
    private int pdf;
    private boolean pdg = false;
    private boolean pdh = false;
    private int pdi;
    private int pdj = 80;
    private int pdk = SQLiteDebug.MAIN_THREAD_SLOW_QUERY_THRESHOLD;
    private float pdl;
    private float pdm;
    private int pdn;
    private int pdo;
    private int pdp;
    public boolean pdq = false;
    private RectF pdr = new RectF();
    private RectF pds = new RectF();
    private b pdt = new b(this);
    public a pdu;

    public interface a {
        void gB(boolean z);
    }

    private class b extends Animation {
        int direction = 0;
        float pdv = 0.0f;
        long pdw = 0;
        final /* synthetic */ MMSwitchBtn pdx;

        public b(final MMSwitchBtn mMSwitchBtn) {
            this.pdx = mMSwitchBtn;
            setInterpolator(new AccelerateDecelerateInterpolator());
            setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ b pdz;

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    boolean z = true;
                    if (this.pdz.pdx.pdq != (this.pdz.direction == 1)) {
                        MMSwitchBtn mMSwitchBtn = this.pdz.pdx;
                        if (this.pdz.direction != 1) {
                            z = false;
                        }
                        mMSwitchBtn.pdq = z;
                        this.pdz.pdx.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 pdA;

                            {
                                this.pdA = r1;
                            }

                            public final void run() {
                                if (this.pdA.pdz.pdx.pdu != null) {
                                    this.pdA.pdz.pdx.pdu.gB(this.pdA.pdz.pdx.pdq);
                                }
                            }
                        });
                    }
                    this.pdz.pdx.pdg = false;
                }
            });
        }

        protected final void applyTransformation(float f, Transformation transformation) {
            if (this.direction == 0) {
                this.pdx.pds.left = this.pdv - (((float) this.pdw) * f);
            } else {
                this.pdx.pds.left = this.pdv + (((float) this.pdw) * f);
            }
            this.pdx.bKl();
            this.pdx.invalidate();
        }
    }

    public MMSwitchBtn(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public MMSwitchBtn(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.pdi = getResources().getDimensionPixelSize(com.tencent.mm.bi.a.b.peR);
        this.pdl = (float) getResources().getDimensionPixelSize(com.tencent.mm.bi.a.b.peV);
        this.pdm = (float) getResources().getDimensionPixelSize(com.tencent.mm.bi.a.b.peU);
        this.pdn = getResources().getColor(com.tencent.mm.bi.a.a.white);
        this.pdo = getResources().getColor(com.tencent.mm.bi.a.a.peN);
        this.pdp = getResources().getColor(com.tencent.mm.bi.a.a.peO);
        this.gpY = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public final void kq(boolean z) {
        if (this.pdq != z) {
            clearAnimation();
            this.pdq = z;
            bKk();
            this.pdg = false;
            invalidate();
        }
        setContentDescription(z ? getContext().getString(f.pfp) : getContext().getString(f.pfq));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.maxWidth = i3 - i;
        this.maxHeight = i4 - i2;
        this.pde = (this.maxWidth - ((int) (this.pdm * 2.0f))) - (this.pdi * 2);
        this.pdd = this.pde / 2;
        this.pdf = getResources().getDimensionPixelSize(com.tencent.mm.bi.a.b.peT);
        if (this.pdf < this.maxHeight) {
            this.pdr.top = (float) ((this.maxHeight - this.pdf) / 2);
            this.pdr.bottom = this.pdr.top + ((float) this.pdf);
        } else {
            this.pdr.top = 0.0f;
            this.pdr.bottom = (float) this.maxHeight;
        }
        this.pdr.left = 0.0f;
        this.pdr.right = (float) this.maxWidth;
        bKk();
        this.hCd.setStyle(Style.FILL);
        this.hCd.setColor(this.pdo);
    }

    private void bKk() {
        if (this.pdf < this.maxHeight) {
            this.pds.top = (float) (((this.maxHeight - this.pdf) / 2) + this.pdi);
            this.pds.bottom = (this.pds.top + ((float) this.pdf)) - ((float) (this.pdi * 2));
        } else {
            this.pds.top = (float) this.pdi;
            this.pds.bottom = (float) (this.maxHeight - this.pdi);
        }
        if (this.pdq) {
            this.pds.left = (float) (this.pde + this.pdi);
            this.pds.right = (float) (this.maxWidth - this.pdi);
            return;
        }
        this.pds.left = (float) this.pdi;
        this.pds.right = (float) (((int) (this.pdm * 2.0f)) + this.pdi);
    }

    private void bKl() {
        if (this.pds.left < ((float) this.pdi)) {
            this.pds.left = (float) this.pdi;
        }
        if (this.pds.left > ((float) (this.pde + this.pdi))) {
            this.pds.left = (float) (this.pde + this.pdi);
        }
        this.pds.right = this.pds.left + ((float) ((int) (this.pdm * 2.0f)));
    }

    private void kr(boolean z) {
        this.pdg = true;
        this.pdt.reset();
        if (z) {
            this.pdt.pdw = (((long) this.pde) - ((long) this.pds.left)) + ((long) this.pdi);
            this.pdt.direction = 1;
        } else {
            this.pdt.pdw = (long) this.pds.left;
            this.pdt.direction = 0;
        }
        this.pdt.pdv = this.pds.left;
        this.pdt.setDuration((((long) this.pdj) * this.pdt.pdw) / ((long) this.pde));
        startAnimation(this.pdt);
    }

    private void cy(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private void bJy() {
        if (this.pds.left > ((float) this.pdd)) {
            kr(true);
        } else {
            kr(false);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.pdg) {
            switch (motionEvent.getAction()) {
                case 0:
                    clearAnimation();
                    this.pda = motionEvent.getX();
                    this.pdb = motionEvent.getY();
                    this.pdc = SystemClock.elapsedRealtime();
                    this.pdh = false;
                    break;
                case 1:
                    if (SystemClock.elapsedRealtime() - this.pdc < ((long) this.pdk)) {
                        kr(!this.pdq);
                    } else {
                        bJy();
                    }
                    cy(false);
                    this.pdh = false;
                    break;
                case 2:
                    float x;
                    if (this.pdh) {
                        cy(true);
                        x = motionEvent.getX() - this.pda;
                        RectF rectF = this.pds;
                        rectF.left = x + rectF.left;
                        bKl();
                    } else {
                        float x2 = motionEvent.getX() - this.pda;
                        x = motionEvent.getY() - this.pdb;
                        if (Math.abs(x2) >= ((float) this.gpY) / 10.0f) {
                            if (x == 0.0f) {
                                x = 1.0f;
                            }
                            if (Math.abs(x2 / x) > 3.0f) {
                                z = true;
                            }
                        }
                        if (z) {
                            this.pdh = true;
                            cy(true);
                        }
                    }
                    this.pda = motionEvent.getX();
                    this.pdb = motionEvent.getY();
                    break;
                case 3:
                    if (this.pdh) {
                        bJy();
                    }
                    cy(false);
                    this.pdh = false;
                    break;
            }
            if (this.pdh) {
                invalidate();
            }
        }
        return true;
    }

    protected void onDraw(Canvas canvas) {
        this.hCd.setColor(this.pdo);
        this.hCd.setAlpha(WebView.NORMAL_MODE_ALPHA);
        canvas.drawRoundRect(this.pdr, this.pdl, this.pdl, this.hCd);
        this.hCd.setColor(this.pdp);
        this.hCd.setAlpha(Math.min(WebView.NORMAL_MODE_ALPHA, (int) (255.0f * ((this.pds.left - ((float) this.pdi)) / ((float) this.pde)))));
        canvas.drawRoundRect(this.pdr, this.pdl, this.pdl, this.hCd);
        this.hCd.setColor(this.pdn);
        canvas.drawRoundRect(this.pds, this.pdm, this.pdm, this.hCd);
    }
}
