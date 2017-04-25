package com.tencent.mm.plugin.ipcall.ui;

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
import com.tencent.mm.ui.base.o;

public class IPCallCountryCodeScrollbar extends View {
    public static final String[] gKX = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private float cmK;
    private Paint evR;
    protected float gKY = 1.3f;
    protected int gKZ = 79;
    protected String[] gLa = new String[]{"↑"};
    private int gLb;
    private float gLc = 0.0f;
    private float gLd;
    private o gLe;
    private TextView gLf;
    private int gLg;
    a gLh;

    public interface a {
        void pC(String str);
    }

    public final void uY(String str) {
        int i = 0;
        int i2 = 0;
        for (String equals : gKX) {
            if (equals.equals(str)) {
                i2 = 1;
            }
        }
        if (i2 == 0) {
            str = "#";
        }
        int length = this.gLa.length + 1;
        String[] strArr = new String[length];
        String[] strArr2 = this.gLa;
        int length2 = strArr2.length;
        i2 = 0;
        while (i2 < length2) {
            String str2 = strArr2[i2];
            if (!str2.equals(str)) {
                strArr[i] = str2;
                i++;
                i2++;
            } else {
                return;
            }
        }
        strArr[length - 1] = str;
        this.gLa = strArr;
    }

    public IPCallCountryCodeScrollbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.gLg = b.a(context, 3.0f);
        View inflate = inflate(context, 2130904387, null);
        int a = b.a(context, (float) this.gKZ);
        this.gLe = new o(inflate, a, a);
        this.gLf = (TextView) inflate.findViewById(2131759195);
        this.evR = new Paint();
        this.evR.setAntiAlias(true);
        this.evR.setColor(-11119018);
        this.evR.setTextAlign(Align.CENTER);
    }

    protected void onDraw(Canvas canvas) {
        int i = 0;
        super.onDraw(canvas);
        final int measuredHeight = getMeasuredHeight();
        final int measuredWidth = getMeasuredWidth();
        this.cmK = ((float) measuredHeight) / (((float) this.gLa.length) * this.gKY);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131493169);
        if (this.cmK > ((float) dimensionPixelSize)) {
            this.cmK = (float) dimensionPixelSize;
        }
        this.evR.setTextSize(this.cmK);
        if (this.gLc != this.cmK) {
            this.gLc = this.cmK;
            post(new Runnable(this) {
                final /* synthetic */ IPCallCountryCodeScrollbar gLk;

                public final void run() {
                    if (this.gLk.gLa.length > 0) {
                        int measureText = ((int) this.gLk.evR.measureText(this.gLk.gLa[this.gLk.gLa.length - 1])) + com.tencent.mm.bd.a.fromDPToPix(this.gLk.getContext(), 8);
                        if (measureText > measuredWidth) {
                            LayoutParams layoutParams = this.gLk.getLayoutParams();
                            layoutParams.width = measureText;
                            layoutParams.height = measuredHeight;
                            this.gLk.setLayoutParams(layoutParams);
                        }
                    }
                }
            });
        }
        if (this.cmK == ((float) dimensionPixelSize)) {
            float length = (((float) measuredHeight) - ((((float) this.gLa.length) * this.cmK) * this.gKY)) / 2.0f;
            while (i < this.gLa.length) {
                canvas.drawText(this.gLa[i], ((float) measuredWidth) / 2.0f, (this.cmK + length) + ((((float) i) * this.cmK) * this.gKY), this.evR);
                i++;
            }
            return;
        }
        while (i < this.gLa.length) {
            canvas.drawText(this.gLa[i], ((float) measuredWidth) / 2.0f, this.cmK + ((((float) i) * this.cmK) * this.gKY), this.evR);
            i++;
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
            float f = this.cmK * this.gKY;
            int measuredHeight = (int) ((this.gLd - ((((float) getMeasuredHeight()) - (((float) this.gLa.length) * f)) / 2.0f)) / f);
            if (measuredHeight < 0) {
                measuredHeight = 0;
            }
            if (measuredHeight >= this.gLa.length) {
                measuredHeight = this.gLa.length - 1;
            }
            this.gLb = measuredHeight;
            if (this.gLb == -1) {
                this.gLf.setText(2131234799);
            } else {
                this.gLf.setText(this.gLa[this.gLb]);
            }
            this.gLe.showAtLocation(this, 17, 0, 0);
            if (this.gLh != null) {
                if (this.gLb == -1) {
                    this.gLh.pC(com.tencent.mm.bd.a.O(getContext(), 2131234799));
                } else {
                    this.gLh.pC(this.gLa[this.gLb]);
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
