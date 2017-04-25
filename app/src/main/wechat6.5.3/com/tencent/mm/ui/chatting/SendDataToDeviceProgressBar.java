package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.ac;

class SendDataToDeviceProgressBar extends ImageView {
    private int bottom;
    private ac cnC;
    private int fBq;
    private int fBr;
    private Runnable fBs;
    private Paint ft;
    private int guz;
    private int left;
    private Context mContext;
    private int right;
    private int top;

    public SendDataToDeviceProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SendDataToDeviceProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fBq = 2;
        this.left = -1;
        this.top = -1;
        this.right = -1;
        this.bottom = -1;
        this.fBr = -1;
        this.guz = 10;
        this.fBs = new Runnable(this) {
            final /* synthetic */ SendDataToDeviceProgressBar oyX;

            {
                this.oyX = r1;
            }

            public final void run() {
                this.oyX.invalidate();
            }
        };
        setImageResource(2130839575);
        this.mContext = context;
        this.ft = new Paint();
        this.ft.setAntiAlias(true);
        this.ft.setStyle(Style.STROKE);
        this.left = this.mContext.getResources().getDimensionPixelSize(2131493558);
        this.top = this.left;
        this.fBr = this.mContext.getResources().getDimensionPixelSize(2131493559);
        this.cnC = new ac(Looper.getMainLooper());
    }

    public final void setProgress(int i) {
        if (i >= 100) {
            i = 100;
        }
        this.fBq = (int) ((((float) i) / 100.0f) * 360.0f);
        this.cnC.removeCallbacks(this.fBs);
        this.cnC.postDelayed(this.fBs, 0);
    }

    public final int getProgress() {
        return (int) ((((float) this.fBq) / 360.0f) * 100.0f);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth() / 2;
        this.ft.setColor(this.mContext.getResources().getColor(2131689935));
        this.ft.setStrokeWidth((float) this.fBr);
        if (this.right == -1) {
            this.right = (width * 2) - this.left;
        }
        if (this.bottom == -1) {
            this.bottom = this.right;
        }
        RectF rectF = new RectF((float) this.left, (float) this.top, (float) this.right, (float) this.bottom);
        canvas.drawArc(rectF, 270.0f, (float) this.fBq, false, this.ft);
        width = this.fBq + 270;
        if (width > 360) {
            width -= 360;
        }
        this.ft.setColor(this.mContext.getResources().getColor(2131689933));
        canvas.drawArc(rectF, (float) width, (float) (360 - this.fBq), false, this.ft);
    }
}
