package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;

public class VolumeMeter extends ImageView implements Runnable {
    private Paint evR;
    public boolean gWB = false;
    public boolean gWC = false;
    View gWD;
    private int gWE = -1;
    private int gWF = -1;
    public ac gWG = null;
    float gWH;
    float gWI;
    private float gWJ;
    private float gWK;
    private int gWL = -6751336;
    private int gWM = 70;
    private float gWN = 0.5f;
    private float gWO = 0.001f;
    private int gWP = 20;
    private float gWQ;
    private float gWR;
    private float gWS = 0.0f;
    private float gWT = 40.0f;
    private float gWU = 30.0f;
    private Context mContext;

    public final void axa() {
        if (this.gWG == null) {
            new ac().postDelayed(new Runnable(this) {
                final /* synthetic */ VolumeMeter gWV;

                {
                    this.gWV = r1;
                }

                public final void run() {
                    this.gWV.gWG = new ac();
                    this.gWV.axa();
                }
            }, 100);
        } else {
            this.gWG.post(this);
        }
    }

    public void run() {
        if (this.gWB) {
            float f;
            float f2 = this.gWJ;
            if (this.gWI > this.gWH) {
                f = (this.gWI - this.gWH) / this.gWU;
                if (f > this.gWN) {
                    f = this.gWN;
                } else if (f < this.gWO) {
                    f = this.gWO;
                }
                f += f2;
            } else if (this.gWI <= this.gWH) {
                f = (this.gWH - this.gWI) / this.gWT;
                if (f > this.gWN) {
                    f = this.gWN;
                } else if (f < this.gWO) {
                    f = this.gWO;
                }
                f = f2 - f;
            } else {
                f = f2;
            }
            this.gWJ = f;
            this.gWK = this.gWJ;
            this.gWS = ((float) ((260.0d * Math.sqrt((double) this.gWJ)) - ((double) (130.0f * this.gWJ)))) / 1.5f;
            postInvalidate();
            this.gWG.postDelayed(this, (long) this.gWP);
        }
    }

    public VolumeMeter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init();
    }

    public VolumeMeter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    private void init() {
        this.evR = new Paint();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        getWidth();
        getHeight();
        if (this.gWD != null) {
            int[] iArr = new int[2];
            this.gWD.getLocationInWindow(iArr);
            if (!(iArr[0] == 0 || iArr[1] == 0)) {
                int width = this.gWD.getWidth();
                int height = this.gWD.getHeight();
                if (!(width == 0 || height == 0)) {
                    int a = b.a(this.mContext, 50.0f);
                    this.gWE = iArr[0] + (width / 2);
                    this.gWF = (iArr[1] + (height / 2)) - (a / 2);
                    this.gWR = (float) (width / 2);
                    this.gWQ = ((float) (width / 2)) * 2.0f;
                }
            }
        }
        if (this.gWE >= 0 && this.gWF >= 0) {
            this.evR.setColor(this.gWL);
            this.evR.setAlpha(this.gWM);
            float a2 = (float) b.a(this.mContext, this.gWS);
            if (a2 > this.gWQ) {
                a2 = this.gWQ;
            }
            if (a2 < this.gWR) {
                a2 = this.gWR;
            }
            canvas.drawCircle((float) this.gWE, (float) this.gWF, a2, this.evR);
        }
    }

    public final void reset() {
        this.gWS = 0.0f;
        this.gWH = 0.0f;
        this.gWI = 0.0f;
        this.gWJ = 0.0f;
        this.gWK = 0.0f;
        postInvalidate();
    }
}
