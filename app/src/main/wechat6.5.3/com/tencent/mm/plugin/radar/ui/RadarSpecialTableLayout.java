package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TableLayout;

public class RadarSpecialTableLayout extends TableLayout {
    private boolean ijA = false;

    public RadarSpecialTableLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RadarSpecialTableLayout(Context context) {
        super(context);
    }

    public final void k(int i, int i2, int i3, int i4) {
        this.ijA = true;
        super.layout(i, i2, i3, i4);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        int i5;
        int i6;
        if (this.ijA || i2 >= 0) {
            z2 = false;
            i5 = i4;
            i6 = i2;
        } else {
            z2 = true;
            i5 = i4 - i2;
            i6 = 0;
        }
        this.ijA = false;
        if (z2) {
            layout(i, 0, i3, i5);
        } else {
            super.onLayout(z, i, i6, i3, i5);
        }
    }
}
