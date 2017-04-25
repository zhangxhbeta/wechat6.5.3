package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.KeyboardLinearLayout;

public class WebViewKeyboardLinearLayout extends KeyboardLinearLayout {
    private int QW;
    private boolean gvW = false;
    private boolean ljj;
    private int ljk;
    public int ljl;
    private int ljm;

    public WebViewKeyboardLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WebViewKeyboardLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    protected final void sY(int i) {
        v.d("MicroMsg.WebViewKeyboardLinearLayout", "onLayout : b: " + i + " mHasInit: " + this.gvW + " mHasKeyboard: " + this.ljj);
        Rect rect = new Rect();
        getWindowVisibleDisplayFrame(rect);
        int height = getRootView().getHeight();
        if (!this.gvW) {
            this.gvW = true;
            this.QW = i;
            v.i("MicroMsg.WebViewKeyboardLinearLayout", "init height:%d", new Object[]{Integer.valueOf(this.QW)});
            mC(-1);
            this.ljm = height - rect.bottom;
        }
        v.d("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, current rect = %s", new Object[]{rect.toString()});
        height = rect.height();
        this.QW = height;
        v.d("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, usableHeightNow = %d, previousUsableHeight = %d", new Object[]{Integer.valueOf(height), Integer.valueOf(this.ljk)});
        if (this.ljk != height) {
            int height2 = (getRootView().getHeight() - this.ljm) - rect.top;
            int i2 = height2 - height;
            if (i2 > height2 / 4) {
                this.ljj = true;
                this.ljl = i2;
                mC(-3);
                v.w("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, show keyboard!! mHeight: " + this.QW + " b: " + i + " mKBHeight: " + this.ljl);
            } else {
                this.ljj = false;
                mC(-2);
                v.w("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, hide keyboard!! mHeight: " + this.QW + " b: " + i);
            }
            this.ljk = height;
        }
    }
}
