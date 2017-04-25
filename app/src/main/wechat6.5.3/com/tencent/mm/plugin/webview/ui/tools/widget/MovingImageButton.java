package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.mm.bd.a;
import com.tencent.mm.ui.w;

public class MovingImageButton extends ImageView {
    public int Wj;
    private int dOx;
    private int dOy;
    private int eww;
    private int ewx;
    private int gpY;
    private int lrJ;
    private int lrK;
    public int lrL = 0;
    public int lrM = 0;
    private MarginLayoutParams lrN;
    private final int lrO = 100;
    private int lrP;
    private boolean lrQ = false;
    private Context mContext;
    private int x;
    private int y;

    public MovingImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public MovingImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.lrP = a.fromDPToPix(this.mContext, 100);
        this.eww = a.dv(this.mContext);
        this.ewx = a.dw(this.mContext);
        this.gpY = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.lrL == 0 || this.lrM == 0) {
            Rect rect = new Rect();
            getWindowVisibleDisplayFrame(rect);
            w.en(this.mContext);
            if (this.Wj == 0) {
                this.lrL = rect.right - rect.left;
                this.lrM = rect.bottom - rect.top;
            } else {
                this.lrL = rect.bottom - rect.top;
                this.lrM = rect.right - rect.left;
            }
        }
        this.x = (int) motionEvent.getRawX();
        this.y = (int) motionEvent.getRawY();
        switch (motionEvent.getAction()) {
            case 0:
                this.lrJ = this.x;
                this.lrK = this.y;
                break;
            case 1:
                if (Math.abs(this.lrJ - this.x) + Math.abs(this.lrK - this.y) <= this.gpY) {
                    performClick();
                    break;
                }
                if (this.y < this.lrP) {
                    this.lrN.topMargin = 0;
                } else if (this.y > this.lrM - this.lrP) {
                    this.lrN.topMargin = this.lrM - getHeight();
                } else if (this.x > this.lrL / 2) {
                    this.lrN.rightMargin = 0;
                } else {
                    this.lrN.rightMargin = this.lrL - getWidth();
                }
                requestLayout();
                break;
            case 2:
                int i = this.x - this.dOx;
                int i2 = this.y - this.dOy;
                if (!(i == 0 && i2 == 0)) {
                    this.lrN = (MarginLayoutParams) getLayoutParams();
                    MarginLayoutParams marginLayoutParams = this.lrN;
                    marginLayoutParams.rightMargin = (-i) + marginLayoutParams.rightMargin;
                    marginLayoutParams = this.lrN;
                    marginLayoutParams.topMargin += i2;
                    if (this.lrN.rightMargin < 0) {
                        this.lrN.rightMargin = 0;
                    } else if (this.lrN.rightMargin > this.lrL - getWidth()) {
                        this.lrN.rightMargin = this.lrL - getWidth();
                    }
                    if (this.lrN.topMargin < 0) {
                        this.lrN.topMargin = 0;
                    } else if (this.lrN.topMargin > this.lrM - getHeight()) {
                        this.lrN.topMargin = this.lrM - getHeight();
                    }
                    requestLayout();
                    break;
                }
        }
        this.dOx = this.x;
        this.dOy = this.y;
        return true;
    }
}
