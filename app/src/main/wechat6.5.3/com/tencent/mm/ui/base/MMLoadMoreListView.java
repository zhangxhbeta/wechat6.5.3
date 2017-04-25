package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.v;

public class MMLoadMoreListView extends ListView {
    public View fgW = null;
    public a nWA = null;
    private boolean nWB = false;
    public TextView nWC;
    public boolean nWD = false;

    public interface a {
        void adB();
    }

    public MMLoadMoreListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MMLoadMoreListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public final void bCh() {
        this.fgW = View.inflate(getContext(), 2130903984, null);
        this.nWC = (TextView) this.fgW.findViewById(2131758224);
        this.fgW.setVisibility(8);
    }

    private void init() {
        if (this.fgW == null) {
            bCh();
            addFooterView(this.fgW);
            this.fgW.setVisibility(8);
        }
    }

    public final void bCi() {
        this.nWB = true;
        setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ MMLoadMoreListView nWE;

            {
                this.nWE = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (absListView.getLastVisiblePosition() == absListView.getCount() - 1 && this.nWE.nWA != null) {
                    this.nWE.nWA.adB();
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (i == 0 && this.nWE.getChildAt(0) != null && this.nWE.getChildAt(0).getTop() == this.nWE.getPaddingTop()) {
                    this.nWE.nWD = true;
                } else {
                    this.nWE.nWD = false;
                }
                v.d("MMLoadMoreListView", "newpoi scroll2Top %s", new Object[]{this.nWE.nWD});
            }
        });
    }

    public final void bCj() {
        if (this.fgW != null) {
            this.nWC.setVisibility(8);
            this.fgW.setVisibility(8);
        }
    }

    public final void bCk() {
        this.nWC.setVisibility(0);
        this.fgW.setVisibility(0);
    }
}
