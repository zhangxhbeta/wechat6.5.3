package com.tencent.mm.plugin.mmsight.segment;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public final class l extends View {
    a hrF;
    private boolean hrG;
    boolean hrH;
    private int hrI;
    private int hrJ;
    private Drawable hrK;
    private Drawable hrL;
    private int hrM;
    private float hrN;
    private int hrO;
    private float hrP;
    private int hrQ;
    private Paint hrR;
    private Paint hrS;
    private int hrT;
    private float hrU;
    private Paint hrV;
    private Paint hrW;
    private int hrX;
    private float hrY;
    private float hrZ;
    private float hsa;
    private int hsb;
    private OnTouchListener hsc;
    private int padding;

    public interface a {
        void aAR();

        void aAS();

        void el(boolean z);
    }

    private class b extends Drawable {
        final /* synthetic */ l hsg;
        boolean hsl = false;
        private Drawable hsm;
        private Drawable hsn;

        public b(l lVar, Drawable drawable, Drawable drawable2) {
            this.hsg = lVar;
            this.hsm = drawable;
            this.hsn = drawable2;
            this.hsl = false;
        }

        public final void draw(Canvas canvas) {
            Drawable drawable;
            if (this.hsl) {
                drawable = this.hsm;
            } else {
                drawable = this.hsn;
            }
            if (!getBounds().equals(drawable.getBounds())) {
                drawable.setBounds(getBounds());
            }
            drawable.draw(canvas);
        }

        public final void setAlpha(int i) {
            this.hsm.setAlpha(i);
            this.hsn.setAlpha(i);
        }

        public final void setColorFilter(ColorFilter colorFilter) {
            this.hsm.setColorFilter(colorFilter);
            this.hsn.setColorFilter(colorFilter);
        }

        public final int getOpacity() {
            return -3;
        }
    }

    static /* synthetic */ void a(l lVar, boolean z, float f) {
        if (lVar.hrG && lVar.hrK != null && lVar.hrL != null && lVar.hrK.getBounds().width() > 0 && lVar.hrL.getBounds().width() > 0) {
            float f2;
            float max;
            if (z) {
                f2 = lVar.hrN + ((float) (lVar.hrL.getBounds().right - lVar.hrJ));
                max = Math.max(((float) lVar.padding) + lVar.hrN, ((float) (lVar.hrL.getBounds().right - lVar.hrI)) + lVar.hrN);
            } else {
                max = ((float) (lVar.hrK.getBounds().left + lVar.hrJ)) - lVar.hrN;
                f2 = Math.min(((float) (lVar.getWidth() - lVar.padding)) - lVar.hrN, ((float) (lVar.hrK.getBounds().left + lVar.hrI)) - lVar.hrN);
            }
            max = Math.max(max, Math.min(f, f2));
            Rect bounds;
            if (z) {
                bounds = lVar.hrK.getBounds();
                bounds.offsetTo((int) Math.ceil((double) (max - lVar.hrN)), 0);
                lVar.hrK.setBounds(bounds);
            } else {
                bounds = lVar.hrL.getBounds();
                bounds.offsetTo((int) Math.floor((double) (max - lVar.hrN)), 0);
                lVar.hrL.setBounds(bounds);
            }
            lVar.postInvalidate();
        }
    }

    static /* synthetic */ void a(l lVar, boolean z, boolean z2) {
        if (lVar.hrG && lVar.hrK != null && lVar.hrL != null && lVar.hrK.getBounds().width() > 0 && lVar.hrL.getBounds().width() > 0) {
            b bVar = z ? (b) lVar.hrK : (b) lVar.hrL;
            if (bVar.hsl != z2) {
                bVar.hsl = z2;
                bVar.hsg.invalidate();
            }
            lVar.postInvalidate();
        }
    }

    static /* synthetic */ boolean a(l lVar, Drawable drawable, float f, float f2) {
        if (!lVar.hrG || drawable == null) {
            return false;
        }
        Rect bounds = drawable.getBounds();
        return f2 <= ((float) (bounds.bottom + lVar.hsb)) && f2 >= ((float) (bounds.top - lVar.hsb)) && f >= ((float) (bounds.left - lVar.hsb)) && f <= ((float) (bounds.right + lVar.hsb));
    }

    public l(Context context) {
        super(context);
        this.hrG = false;
        this.hrH = false;
        this.hrP = -1.0f;
        this.hrZ = -1.0f;
        this.hsa = -1.0f;
        this.padding = 0;
        this.hsc = new OnTouchListener(this) {
            float evM;
            float evN;
            final /* synthetic */ l hsg;
            int hsh = -1;
            int hsi = -1;
            int hsj;
            int hsk;

            {
                this.hsg = r2;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (!this.hsg.hrG) {
                    return false;
                }
                switch (motionEvent.getActionMasked()) {
                    case 0:
                    case 5:
                        this.hsk = motionEvent.getActionIndex();
                        this.hsj = motionEvent.getPointerId(this.hsk);
                        this.evM = motionEvent.getX(this.hsk);
                        this.evN = motionEvent.getY(this.hsk);
                        if (l.a(this.hsg, this.hsg.hrK, this.evM, this.evN)) {
                            if (this.hsg.em(true)) {
                                return false;
                            }
                            if (this.hsg.hrF != null) {
                                this.hsg.hrF.aAR();
                            }
                            this.hsh = this.hsj;
                            this.hsg.hrZ = (float) this.hsg.hrK.getBounds().left;
                            l.a(this.hsg, true, true);
                            return true;
                        } else if (!l.a(this.hsg, this.hsg.hrL, this.evM, this.evN) || this.hsg.em(false)) {
                            return false;
                        } else {
                            if (this.hsg.hrF != null) {
                                this.hsg.hrF.aAR();
                            }
                            this.hsi = this.hsj;
                            this.hsg.hsa = (float) this.hsg.hrL.getBounds().right;
                            l.a(this.hsg, false, true);
                            return true;
                        }
                    case 1:
                    case 3:
                    case 6:
                        this.hsj = motionEvent.getPointerId(motionEvent.getActionIndex());
                        if (this.hsj != this.hsh && this.hsj != this.hsi) {
                            return false;
                        }
                        if (this.hsg.hrF != null) {
                            this.hsg.hrF.aAS();
                        }
                        l.a(this.hsg, this.hsj == this.hsh, false);
                        if (this.hsj == this.hsh) {
                            this.hsh = -1;
                        } else {
                            this.hsi = -1;
                        }
                        return true;
                    case 2:
                        if (!this.hsg.em(true) && !this.hsg.em(false)) {
                            return false;
                        }
                        if (this.hsg.hrH) {
                            return true;
                        }
                        this.hsk = 0;
                        boolean z = false;
                        while (this.hsk < motionEvent.getPointerCount()) {
                            this.hsj = motionEvent.getPointerId(this.hsk);
                            if (this.hsj == this.hsh || this.hsj == this.hsi) {
                                l lVar = this.hsg;
                                if (this.hsj == this.hsh) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                l.a(lVar, z, motionEvent.getX(this.hsk));
                                if (this.hsg.hrF != null) {
                                    a h = this.hsg.hrF;
                                    if (this.hsj == this.hsh) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    h.el(z);
                                }
                                z = true;
                            }
                            this.hsk++;
                        }
                        return z;
                    default:
                        return false;
                }
            }
        };
        this.hrM = com.tencent.mm.bd.a.fromDPToPix(getContext(), 8);
        this.hrN = ((float) this.hrM) * 0.5f;
        this.hsb = com.tencent.mm.bd.a.fromDPToPix(getContext(), 8);
        this.hrK = new b(this, com.tencent.mm.bd.a.a(getContext(), 2131165998), com.tencent.mm.bd.a.a(getContext(), 2131165997));
        this.hrL = new b(this, com.tencent.mm.bd.a.a(getContext(), 2131165998), com.tencent.mm.bd.a.a(getContext(), 2131165997));
        this.hrO = com.tencent.mm.bd.a.fromDPToPix(getContext(), 1);
        this.hrQ = com.tencent.mm.bd.a.N(getContext(), 2131493589);
        this.hrP = -1.0f;
        this.hrR = new Paint();
        this.hrR.setColor(com.tencent.mm.bd.a.b(getContext(), 2131690127));
        this.hrR.setAlpha(102);
        this.hrV = new Paint();
        this.hrV.setColor(com.tencent.mm.bd.a.b(getContext(), 2131689547));
        this.hrV.setAlpha(102);
        this.hrS = new Paint();
        this.hrS.setColor(com.tencent.mm.bd.a.b(getContext(), 2131690127));
        this.hrS.setStyle(Style.STROKE);
        this.hrT = ci(getContext());
        this.hrS.setStrokeWidth((float) this.hrT);
        this.hrU = ((float) this.hrT) * 0.5f;
        this.hrW = new Paint();
        this.hrW.setColor(com.tencent.mm.bd.a.b(getContext(), 2131690127));
        this.hrW.setStyle(Style.STROKE);
        this.hrX = ci(getContext());
        this.hrY = ((float) this.hrX) * 0.5f;
        this.hrW.setStrokeWidth((float) this.hrX);
        this.hrW.setAlpha(178);
        setOnTouchListener(this.hsc);
    }

    private static int ci(Context context) {
        return Math.round(TypedValue.applyDimension(1, 1.5f, context.getResources().getDisplayMetrics()));
    }

    protected final void onDraw(Canvas canvas) {
        if (this.hrP > 0.0f) {
            float width = ((float) getWidth()) * this.hrP;
            canvas.drawRect(width - (((float) this.hrO) * 0.5f), 0.0f, (((float) this.hrO) * 0.5f) + width, (float) this.hrQ, this.hrR);
        }
        if (this.hrG) {
            int centerX = this.hrK.getBounds().centerX();
            int centerX2 = this.hrL.getBounds().centerX();
            if (em(true) || em(false)) {
                canvas.drawRect(((float) this.padding) + this.hrY, this.hrY, ((float) (getWidth() - this.padding)) - this.hrY, ((float) getBottom()) - this.hrY, this.hrW);
            }
            if (this.hrK.getBounds().left > 0) {
                canvas.drawRect(0.0f, 0.0f, (float) centerX, (float) getHeight(), this.hrV);
            }
            if (this.hrL.getBounds().right < getWidth()) {
                canvas.drawRect((float) centerX2, 0.0f, (float) getWidth(), (float) getHeight(), this.hrV);
            }
            canvas.drawLine((float) centerX, this.hrU, (float) centerX2, this.hrU, this.hrS);
            canvas.drawLine((float) centerX, ((float) getHeight()) - this.hrU, (float) centerX2, ((float) getHeight()) - this.hrU, this.hrS);
            this.hrK.draw(canvas);
            this.hrL.draw(canvas);
        }
    }

    public final void Q(float f) {
        if (this.hrG) {
            this.hrP = f;
            invalidate();
        }
    }

    public final void E(final int i, final int i2, final int i3) {
        post(new Runnable(this) {
            final /* synthetic */ l hsg;

            public final void run() {
                if (i <= this.hsg.hrM * 2) {
                    throw new IllegalStateException("MaxExtent can not less than sliderWidth * 2");
                }
                this.hsg.hrG = true;
                this.hsg.padding = i3;
                this.hsg.hrI = Math.min(i, this.hsg.getWidth() - (i3 * 2));
                this.hsg.hrJ = Math.max(i2, this.hsg.hrM * 2);
                this.hsg.hrK.setBounds(i3, 0, i3 + this.hsg.hrM, this.hsg.getHeight());
                this.hsg.hrL.setBounds((i3 + this.hsg.hrI) - this.hsg.hrM, 0, this.hsg.hrI + i3, this.hsg.getHeight());
                this.hsg.invalidate();
            }
        });
    }

    private boolean em(boolean z) {
        if (z) {
            return ((b) this.hrK).hsl;
        }
        return ((b) this.hrL).hsl;
    }

    public final int aAT() {
        return this.hrK.getBounds().left;
    }

    public final int aAU() {
        return this.hrL.getBounds().right;
    }
}
