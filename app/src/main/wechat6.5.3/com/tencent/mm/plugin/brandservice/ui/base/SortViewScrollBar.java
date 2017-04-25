package com.tencent.mm.plugin.brandservice.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.ui.base.AlphabetScrollBar;

public class SortViewScrollBar extends AlphabetScrollBar {
    public SortViewScrollBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected final void YK() {
        this.gLa = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};
        this.gKY = 1.45f;
        this.gKZ = 79;
    }
}
