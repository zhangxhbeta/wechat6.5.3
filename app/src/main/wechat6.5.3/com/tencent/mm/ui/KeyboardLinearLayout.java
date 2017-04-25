package com.tencent.mm.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;

public class KeyboardLinearLayout extends OnLayoutChangedLinearLayout {
    private int QW;
    public String TAG;
    private boolean gvW;
    private boolean jGq;
    public a nBa;

    public interface a {
        void mC(int i);
    }

    public KeyboardLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = "MicroMsg.KeyboardLinearLayout";
        this.gvW = false;
        this.gvW = false;
        this.QW = 0;
        this.jGq = false;
        this.TAG += getId();
    }

    public KeyboardLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = "MicroMsg.KeyboardLinearLayout";
        this.gvW = false;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        sY(i4);
    }

    public void sY(int i) {
        if (this.gvW) {
            this.QW = this.QW < i ? i : this.QW;
        } else {
            this.gvW = true;
            this.QW = i;
            v.i(this.TAG, "init height:%d", new Object[]{Integer.valueOf(this.QW)});
            if (this.nBa != null) {
                this.nBa.mC(-1);
            }
        }
        if (this.gvW && !this.jGq && this.QW > i) {
            this.jGq = true;
            mC(-3);
            v.w(this.TAG, "show keyboard!! mHeight: " + this.QW + " b: " + i);
        }
        if (this.gvW && this.jGq && this.QW - i <= 100) {
            this.jGq = false;
            mC(-2);
            v.w(this.TAG, "hide keyboard!! mHeight: " + this.QW + " b: " + i);
        }
    }

    public void mC(int i) {
        if (this.nBa != null) {
            this.nBa.mC(i);
        }
    }
}
