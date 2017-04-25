package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.AbsListView.LayoutParams;
import android.widget.ListView;

public class EnterpriseFullHeightListView extends ListView {
    private int eLQ = 0;
    public boolean oLR = true;
    private View oLS;

    public EnterpriseFullHeightListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EnterpriseFullHeightListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void bIo() {
        if (!this.oLR) {
            try {
                getWidth();
                xW(getHeight());
            } catch (Exception e) {
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (!this.oLR) {
            try {
                xW(i2);
            } catch (Exception e) {
            }
        }
    }

    public final void bIp() {
        if (!this.oLR) {
            this.oLS = new View(getContext());
            this.oLS.setLayoutParams(new LayoutParams(-1, 0));
            addFooterView(this.oLS, null, false);
        }
    }

    private void xW(int i) {
        if (!this.oLR) {
            int i2;
            int headerViewsCount = getHeaderViewsCount();
            int count = getAdapter().getCount();
            if (this.oLS != null) {
                i2 = headerViewsCount;
                headerViewsCount = count - 1;
                count = 0;
            } else {
                i2 = headerViewsCount;
                headerViewsCount = count;
                count = 0;
            }
            while (i2 < headerViewsCount) {
                if (this.eLQ <= 0) {
                    try {
                        View view = getAdapter().getView(i2, null, this);
                        view.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                        this.eLQ = view.getMeasuredHeight();
                    } catch (Exception e) {
                    }
                }
                count += this.eLQ;
                if (count <= i) {
                    i2++;
                } else if (this.oLS != null) {
                    removeFooterView(this.oLS);
                    this.oLS = null;
                    return;
                } else {
                    return;
                }
            }
            if (count < i) {
                if (this.oLS == null) {
                    this.oLS = new View(getContext());
                }
                removeFooterView(this.oLS);
                this.oLS.setLayoutParams(new LayoutParams(-1, i - count));
                addFooterView(this.oLS, null, false);
            }
        }
    }
}
