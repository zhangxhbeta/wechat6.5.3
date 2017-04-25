package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

final class r extends p {
    r() {
    }

    public final void eJ() {
        af.aaJ = new a(this) {
            final /* synthetic */ r UQ;

            {
                this.UQ = r1;
            }

            public final void a(Canvas canvas, RectF rectF, float f, Paint paint) {
                canvas.drawRoundRect(rectF, f, f, paint);
            }
        };
    }
}
