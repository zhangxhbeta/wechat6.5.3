package com.tencent.mm.plugin.favorite.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ScrollView;
import com.tencent.mm.sdk.platformtools.v;

public class FavTagPanelScrollView extends ScrollView {
    private Runnable fQk = new Runnable(this) {
        final /* synthetic */ FavTagPanelScrollView fQn;

        {
            this.fQn = r1;
        }

        public final void run() {
            this.fQn.fullScroll(130);
        }
    };
    private a fQl = new a();
    private int fQm = 0;

    private static class a implements Runnable {
        public FavTagPanel fQo;

        private a() {
        }

        public final void run() {
            if (this.fQo != null) {
                this.fQo.bCz();
            }
            this.fQo = null;
        }
    }

    public FavTagPanelScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public FavTagPanelScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getChildCount() > 0 && (getChildAt(0) instanceof FavTagPanel)) {
            FavTagPanel favTagPanel = (FavTagPanel) getChildAt(0);
            boolean bCy = favTagPanel.bCy();
            if (favTagPanel.nSD.size() == 2) {
                this.fQm = favTagPanel.getMeasuredHeight() + getResources().getDimensionPixelOffset(2131493201);
            }
            if (favTagPanel.nSD.size() >= 2) {
                int size = MeasureSpec.getSize(i);
                v.d("MicroMsg.FavTagPanelScrollView", "height %d", new Object[]{Integer.valueOf(Math.max(favTagPanel.wc(2), this.fQm))});
                setMeasuredDimension(size, r3);
                removeCallbacks(this.fQk);
                post(this.fQk);
                if (bCy) {
                    this.fQl.fQo = favTagPanel;
                    removeCallbacks(this.fQl);
                    post(this.fQl);
                }
            }
        }
    }
}
