package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ScrollView;
import com.tencent.mm.sdk.platformtools.v;

public class MMTagPanelScrollView extends ScrollView {
    private Runnable fQk = new Runnable(this) {
        final /* synthetic */ MMTagPanelScrollView nYJ;

        {
            this.nYJ = r1;
        }

        public final void run() {
            this.nYJ.scrollTo(0, this.nYJ.getBottom());
        }
    };
    private int fQm = 0;
    private a nYH = new a();
    public int nYI = 2;

    private static class a implements Runnable {
        public MMTagPanel nYK;

        private a() {
        }

        public final void run() {
            if (this.nYK != null) {
                this.nYK.bCz();
            }
            this.nYK = null;
        }
    }

    public MMTagPanelScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MMTagPanelScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getChildCount() > 0 && (getChildAt(0) instanceof MMTagPanel)) {
            MMTagPanel mMTagPanel = (MMTagPanel) getChildAt(0);
            boolean bCy = mMTagPanel.bCy();
            if (mMTagPanel.nSD.size() == this.nYI) {
                this.fQm = mMTagPanel.getMeasuredHeight() + getResources().getDimensionPixelOffset(2131493201);
            }
            if (mMTagPanel.nSD.size() >= this.nYI) {
                int size = MeasureSpec.getSize(i);
                v.d("MicroMsg.FavTagPanelScrollView", "height %d", Integer.valueOf(Math.max(mMTagPanel.wc(this.nYI), this.fQm)));
                setMeasuredDimension(size, r3);
                if (bCy) {
                    this.nYH.nYK = mMTagPanel;
                    removeCallbacks(this.nYH);
                    post(this.nYH);
                }
            }
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        scrollBy(0, i4);
    }
}
