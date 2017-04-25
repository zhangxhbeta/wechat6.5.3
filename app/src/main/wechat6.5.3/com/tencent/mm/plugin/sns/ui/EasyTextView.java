package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;

public class EasyTextView extends View {
    private static final Paint cnN = new Paint();
    private static int textSize = -1;
    private Context context;
    private String text = "";

    static {
        cnN.setAntiAlias(true);
        cnN.setFilterBitmap(true);
        cnN.setColor(737373);
    }

    public EasyTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        if (textSize == -1) {
            textSize = b.a(this.context, 12.0f);
            cnN.setTextSize((float) textSize);
        }
        cnN.setColor(this.context.getResources().getColor(2131689547));
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawText(this.text, 0.0f, (float) (getHeight() / 2), cnN);
    }
}
