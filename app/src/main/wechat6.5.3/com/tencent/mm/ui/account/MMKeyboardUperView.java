package com.tencent.mm.ui.account;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

public class MMKeyboardUperView extends ScrollView {
    int defaultHeight = -1;
    View nKa;
    Runnable nKb = new Runnable(this) {
        final /* synthetic */ MMKeyboardUperView nKd;

        {
            this.nKd = r1;
        }

        public final void run() {
            this.nKd.fullScroll(130);
            this.nKd.nKa.setVisibility(4);
        }
    };
    Runnable nKc = new Runnable(this) {
        final /* synthetic */ MMKeyboardUperView nKd;

        {
            this.nKd = r1;
        }

        public final void run() {
            this.nKd.nKa.setVisibility(0);
        }
    };

    public MMKeyboardUperView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MMKeyboardUperView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
