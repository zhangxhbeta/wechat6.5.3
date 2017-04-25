package com.tencent.mm.ui.tools;

import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.v;

public final class o implements Runnable {
    public ListView hOQ;
    public int mMode;
    public long oUg = System.currentTimeMillis();
    public int oUh;
    public int oUi;
    public int oUj;
    private final int oUk;
    public int oUl;

    public o(ListView listView) {
        this.hOQ = listView;
        this.oUk = ViewConfiguration.get(this.hOQ.getContext()).getScaledFadingEdgeLength();
        v.d("ScrollerRunnable", "mExtraScroll: %d", Integer.valueOf(this.oUk));
    }

    public final void run() {
        if (System.currentTimeMillis() - this.oUg <= 10000) {
            int height = this.hOQ.getHeight();
            int firstVisiblePosition = this.hOQ.getFirstVisiblePosition();
            int childCount;
            switch (this.mMode) {
                case 1:
                    childCount = this.hOQ.getChildCount() - 1;
                    firstVisiblePosition += childCount;
                    if (childCount >= 0) {
                        if (firstVisiblePosition == this.oUi) {
                            if (this.oUl > 20) {
                                this.hOQ.setSelection(this.oUh);
                                v.d("ScrollerRunnable", "dz:try scroll at same item more than 10, direct seletion");
                            } else {
                                this.hOQ.post(this);
                                this.oUl++;
                                v.d("ScrollerRunnable", "dz:try scroll lastpos = %d", Integer.valueOf(firstVisiblePosition));
                                return;
                            }
                        }
                        this.oUl = 0;
                        View childAt = this.hOQ.getChildAt(childCount);
                        int height2 = childAt.getHeight();
                        childCount = height - childAt.getTop();
                        if (firstVisiblePosition < this.hOQ.getCount() - 1) {
                            height = this.oUk;
                        } else {
                            height = this.hOQ.getPaddingBottom();
                        }
                        this.hOQ.smoothScrollBy(height + (height2 - childCount), this.oUj);
                        this.oUi = firstVisiblePosition;
                        if (firstVisiblePosition < this.oUh) {
                            this.hOQ.post(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (firstVisiblePosition == this.oUi) {
                        if (this.oUl > 20) {
                            this.hOQ.setSelection(this.oUh);
                            v.d("ScrollerRunnable", "dz:try scroll at same item more than 10, direct seletion");
                        } else {
                            this.hOQ.post(this);
                            this.oUl++;
                            v.d("ScrollerRunnable", "dz:try scroll firstPos = %d", Integer.valueOf(firstVisiblePosition));
                            return;
                        }
                    }
                    this.oUl = 0;
                    View childAt2 = this.hOQ.getChildAt(0);
                    if (childAt2 != null) {
                        childCount = childAt2.getTop();
                        if (firstVisiblePosition > 0) {
                            height = this.oUk;
                        } else {
                            height = this.hOQ.getPaddingTop();
                        }
                        this.hOQ.smoothScrollBy(childCount - height, this.oUj);
                        this.oUi = firstVisiblePosition;
                        if (firstVisiblePosition > this.oUh) {
                            this.hOQ.post(this);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
