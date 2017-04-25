package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ah;

public class MMProgressBar extends LinearLayout {
    private ah hJZ = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ MMProgressBar nWS;

        {
            this.nWS = r1;
        }

        public final boolean oU() {
            int a = this.nWS.nWP - this.nWS.nWO;
            if (a > 0) {
                int i = (int) (((double) a) * 0.6d);
                MMProgressBar mMProgressBar = this.nWS;
                if (i <= 0) {
                    i = 1;
                }
                MMProgressBar.a(mMProgressBar, i);
                MMProgressBar.b(this.nWS, this.nWS.nWO);
                this.nWS.hJZ.ea((long) (((this.nWS.max - a) * 40) / this.nWS.max));
            }
            return false;
        }
    }, false);
    private TextView iVo;
    private int max = 100;
    private int nWO = 0;
    private int nWP = 0;
    private TextView nWQ;
    public a nWR;

    public interface a {
        void rw(int i);
    }

    static /* synthetic */ int a(MMProgressBar mMProgressBar, int i) {
        int i2 = mMProgressBar.nWO + i;
        mMProgressBar.nWO = i2;
        return i2;
    }

    static /* synthetic */ void b(MMProgressBar mMProgressBar, int i) {
        TextView textView = mMProgressBar.nWQ;
        int width = (mMProgressBar.getWidth() * mMProgressBar.nWO) / mMProgressBar.max;
        if (width < b.a(mMProgressBar.getContext(), 20.0f)) {
            width = b.a(mMProgressBar.getContext(), 20.0f);
        }
        textView.setWidth(width);
        if (mMProgressBar.nWR != null) {
            mMProgressBar.nWR.rw(i);
        }
    }

    public MMProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        inflate(getContext(), 2130904071, this);
        this.nWQ = (TextView) findViewById(2131758297);
        this.iVo = (TextView) findViewById(2131758296);
    }

    public final void setProgress(int i) {
        if (i > this.max) {
            i = this.max;
        }
        this.nWP = i;
        if (this.hJZ.btC()) {
            jn(true);
        }
    }

    public final void jn(boolean z) {
        if (z) {
            this.hJZ.ea(40);
        } else {
            this.hJZ.QI();
        }
    }
}
