package com.tencent.mm.plugin.sns.e;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.widget.ImageView;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.memory.n;

public final class ab extends b {
    private n jls = null;

    public static void a(Resources resources, n nVar, ImageView imageView) {
        imageView.setImageDrawable(new ab(resources, nVar));
        imageView.postInvalidate();
    }

    private ab(Resources resources, n nVar) {
        super(resources, nVar);
        this.jls = nVar;
    }

    public final void draw(Canvas canvas) {
        if (this.jls == null || this.jls.isRecycled()) {
            canvas.drawColor(-1118482);
        } else {
            super.draw(canvas);
        }
    }
}
