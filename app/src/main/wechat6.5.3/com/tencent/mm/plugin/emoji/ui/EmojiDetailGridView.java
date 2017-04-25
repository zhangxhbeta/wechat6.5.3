package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.tencent.mm.plugin.emoji.ui.smiley.SmileySubGrid;

public class EmojiDetailGridView extends SmileySubGrid {
    String fdU;
    EmojiDetailScrollView fhI;
    private volatile boolean fhJ = true;

    public EmojiDetailGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    protected final void cw(boolean z) {
        if (this.fhI != null) {
            this.fhI.fhK = z;
        }
    }

    protected final int agQ() {
        return 200;
    }
}
