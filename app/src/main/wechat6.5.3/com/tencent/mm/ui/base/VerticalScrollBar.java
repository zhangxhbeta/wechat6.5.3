package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;

public abstract class VerticalScrollBar extends View {
    private float cmK;
    private Paint evR;
    public float gKY;
    public int gKZ;
    public String[] gLa;
    private int gLb;
    private float gLc = 0.0f;
    private float gLd;
    private o gLe;
    private TextView gLf;
    private int gLg;
    public a obP;

    public interface a {
        void pC(String str);
    }

    public abstract void YK();

    public abstract int ave();

    public VerticalScrollBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        YK();
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.gLg = b.a(context, 3.0f);
        View inflate = inflate(context, ave(), null);
        int a = b.a(context, (float) this.gKZ);
        this.gLe = new o(inflate, a, a);
        this.gLf = (TextView) inflate.findViewById(2131759195);
        this.evR = new Paint();
        this.evR.setAntiAlias(true);
        this.evR.setColor(-11119018);
        this.evR.setTextAlign(Align.CENTER);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        final int measuredHeight = getMeasuredHeight();
        final int measuredWidth = getMeasuredWidth();
        this.cmK = ((float) measuredHeight) / (((float) this.gLa.length) * this.gKY);
        this.evR.setTextSize(this.cmK);
        if (this.gLc != this.cmK) {
            this.gLc = this.cmK;
            post(new Runnable(this) {
                final /* synthetic */ VerticalScrollBar obQ;

                public final void run() {
                    if (this.obQ.gLa.length > 0) {
                        int measureText = ((int) this.obQ.evR.measureText(this.obQ.gLa[this.obQ.gLa.length - 1])) + com.tencent.mm.bd.a.fromDPToPix(this.obQ.getContext(), 8);
                        if (measureText > measuredWidth) {
                            LayoutParams layoutParams = this.obQ.getLayoutParams();
                            layoutParams.width = measureText;
                            layoutParams.height = measuredHeight;
                            this.obQ.setLayoutParams(layoutParams);
                        }
                    }
                }
            });
        }
        for (measuredHeight = 0; measuredHeight < this.gLa.length; measuredHeight++) {
            canvas.drawText(this.gLa[measuredHeight], ((float) measuredWidth) / 2.0f, this.cmK + ((((float) measuredHeight) * this.cmK) * this.gKY), this.evR);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
            this.gLd = motionEvent.getY();
            if (this.gLd < 0.0f) {
                this.gLd = 0.0f;
            }
            if (this.gLd > ((float) getMeasuredHeight())) {
                this.gLd = (float) getMeasuredHeight();
            }
            setBackgroundDrawable(com.tencent.mm.bd.a.a(getContext(), 2130839081));
            int i = (int) (this.gLd / (this.cmK * this.gKY));
            if (i >= this.gLa.length) {
                i = this.gLa.length - 1;
            }
            this.gLb = i;
            if (this.gLb == -1) {
                this.gLf.setText(2131234799);
            } else {
                this.gLf.setText(this.gLa[this.gLb]);
            }
            this.gLe.showAtLocation(this, 17, 0, 0);
            if (this.obP != null) {
                if (this.gLb == -1) {
                    this.obP.pC(com.tencent.mm.bd.a.O(getContext(), 2131234799));
                } else {
                    this.obP.pC(this.gLa[this.gLb]);
                }
            }
            invalidate();
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            setBackgroundResource(0);
            this.gLe.dismiss();
        }
        return true;
    }
}
