package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

public class InitCallBackImageView extends ImageView {
    private boolean hasDrawed;
    private eg oxO;

    public InitCallBackImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InitCallBackImageView(Context context, eg egVar) {
        super(context);
        this.oxO = egVar;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.hasDrawed) {
            this.hasDrawed = true;
            if (this.oxO != null) {
                this.oxO.oo();
            }
        }
    }
}
