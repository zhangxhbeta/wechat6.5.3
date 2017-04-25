package com.tencent.mm.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;

public abstract class BasePanelKeybordLayout extends KeyboardLinearLayout {
    private int lNB = -1;
    private a nzw = null;

    public interface a {
    }

    public abstract View ayB();

    public BasePanelKeybordLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BasePanelKeybordLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        v.d("MicroMsg.BasePanelKeybordLayout", "onMeasure, width: %d, height: %d", new Object[]{Integer.valueOf(size), Integer.valueOf(size2)});
        if (size2 >= 0) {
            if (this.lNB < 0) {
                this.lNB = size2;
            } else {
                int i3 = this.lNB - size2;
                this.lNB = size2;
                if (i3 != 0) {
                    View ayB = ayB();
                    if (ayB != null) {
                        LayoutParams layoutParams = (LayoutParams) ayB.getLayoutParams();
                        if (layoutParams != null) {
                            int i4 = layoutParams.height < 0 ? 0 : layoutParams.height - i3;
                            if (i4 < 0) {
                                i4 = 0;
                            }
                            int aA = j.aA(aa.getContext());
                            int aD = j.aD(getContext());
                            if (j.sp() > 0 && size2 >= j.sp()) {
                                i4 = aD;
                            }
                            if (i4 > 0 && i4 < aA && ayB.getVisibility() != 0) {
                                i4 = 0;
                            }
                            if (i4 > aD) {
                                i4 = aD;
                            }
                            if (i4 > 0 && i4 < aD) {
                                i4 = aD;
                            }
                            v.d("MicroMsg.BasePanelKeybordLayout", "oldHeight: %d, offset: %d newHeight: %d, validPanelHeight: %d", new Object[]{Integer.valueOf(layoutParams.height), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(aD)});
                            layoutParams.height = i4;
                            ayB.setLayoutParams(layoutParams);
                        }
                    }
                }
            }
        }
        super.onMeasure(i, i2);
    }
}
