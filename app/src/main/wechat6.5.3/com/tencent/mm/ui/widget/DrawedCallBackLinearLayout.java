package com.tencent.mm.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class DrawedCallBackLinearLayout extends LinearLayout {
    public final boolean DEBUG = true;
    public final String TAG = "MicroMsg.TestTimeForChatting";
    public a pbn;

    public interface a {
        void oo();
    }

    public DrawedCallBackLinearLayout(Context context) {
        super(context);
    }

    public DrawedCallBackLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @TargetApi(11)
    public DrawedCallBackLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.pbn != null) {
            this.pbn.oo();
            this.pbn = null;
        }
    }
}
