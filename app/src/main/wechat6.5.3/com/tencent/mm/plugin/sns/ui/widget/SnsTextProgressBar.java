package com.tencent.mm.plugin.sns.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.mm.R;
import com.tencent.mm.bd.a;

public class SnsTextProgressBar extends ProgressBar {
    private String dVK;
    private Paint ft;
    private int gAu;
    private Context mContext;
    private int rT;

    public SnsTextProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.b.aPB, 0, 0);
        try {
            this.gAu = a.fromDPToPix(this.mContext, obtainStyledAttributes.getInteger(0, 18));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void setProgress(int i) {
        this.rT = i;
        this.dVK = String.valueOf(i) + "%";
        super.setProgress(i);
    }

    @SuppressLint({"DrawAllocation"})
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.ft = new Paint();
        this.ft.setAntiAlias(true);
        this.ft.setColor(this.mContext.getResources().getColor(2131690130));
        this.ft.setTextSize((float) this.gAu);
        Rect rect = new Rect();
        this.ft.getTextBounds(this.dVK, 0, this.dVK.length(), rect);
        canvas.drawText(this.dVK, (float) ((getWidth() / 2) - rect.centerX()), (float) ((getHeight() / 2) - rect.centerY()), this.ft);
    }
}
