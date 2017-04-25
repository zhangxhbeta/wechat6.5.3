package com.tencent.mm.ui.applet;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.ui.base.VerticalScrollBar;

public class StrokeScrollBar extends VerticalScrollBar {
    protected final void YK() {
        this.gLa = new String[18];
        for (int i = 0; i < this.gLa.length; i++) {
            this.gLa[i] = Integer.toString(i + 3) + "劃";
        }
        this.gKY = 2.0f;
        this.gKZ = 79;
    }

    public StrokeScrollBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected final int ave() {
        return 2130904388;
    }
}
