package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mm.bd.a;
import com.tencent.mm.sdk.platformtools.ac;

public class ExdeviceConnectedRouterStateView extends ImageView {
    private int bottom;
    private ac cnC;
    int fBq;
    private int fBr;
    private Runnable fBs;
    private Paint ft;
    private int left;
    private Context mContext;
    private int right;
    private int state;
    private int top;

    public ExdeviceConnectedRouterStateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ExdeviceConnectedRouterStateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fBq = 2;
        this.left = -1;
        this.top = -1;
        this.right = -1;
        this.bottom = -1;
        this.fBr = -1;
        this.fBs = new Runnable(this) {
            final /* synthetic */ ExdeviceConnectedRouterStateView fBt;

            {
                this.fBt = r1;
            }

            public final void run() {
                this.fBt.invalidate();
            }
        };
        this.mContext = context;
        this.ft = new Paint();
        this.ft.setAntiAlias(true);
        this.ft.setStyle(Style.STROKE);
        this.left = a.fromDPToPix(this.mContext, 2);
        this.top = this.left;
        this.fBr = a.fromDPToPix(this.mContext, 3);
        this.cnC = new ac(Looper.getMainLooper());
    }

    public final void setState(int i) {
        this.state = i;
        kv(10);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.state == 1) {
            int width = getWidth() / 2;
            this.ft.setARGB(255, 103, 209, 79);
            this.ft.setStrokeWidth((float) this.fBr);
            if (this.right == -1) {
                this.right = (width * 2) - this.left;
            }
            if (this.bottom == -1) {
                this.bottom = this.right;
            }
            canvas.drawArc(new RectF((float) this.left, (float) this.top, (float) this.right, (float) this.bottom), 270.0f, (float) this.fBq, false, this.ft);
            this.fBq += 5;
            if (this.fBq > 365) {
                this.fBq = 0;
            }
            kv(100);
        }
    }

    private void kv(int i) {
        this.cnC.removeCallbacks(this.fBs);
        this.cnC.postDelayed(this.fBs, (long) i);
    }
}
