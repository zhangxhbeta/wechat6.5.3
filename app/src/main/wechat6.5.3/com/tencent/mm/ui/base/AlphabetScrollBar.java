package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;

public class AlphabetScrollBar extends VerticalScrollBar {
    public void YK() {
        this.gLa = new String[]{"↑", "☆", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};
        this.gKY = 1.3f;
        this.gKZ = 79;
    }

    public AlphabetScrollBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected final int ave() {
        return 2130904387;
    }
}
