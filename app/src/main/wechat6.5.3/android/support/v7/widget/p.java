package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

class p implements q {
    final RectF UO = new RectF();

    p() {
    }

    public void eJ() {
        af.aaJ = new a(this) {
            final /* synthetic */ p UP;

            {
                this.UP = r1;
            }

            public final void a(Canvas canvas, RectF rectF, float f, Paint paint) {
                float f2 = 2.0f * f;
                float width = (rectF.width() - f2) - 1.0f;
                float height = (rectF.height() - f2) - 1.0f;
                if (f >= 1.0f) {
                    float f3 = f + 0.5f;
                    this.UP.UO.set(-f3, -f3, f3, f3);
                    int save = canvas.save();
                    canvas.translate(rectF.left + f3, rectF.top + f3);
                    canvas.drawArc(this.UP.UO, 180.0f, 90.0f, true, paint);
                    canvas.translate(width, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(this.UP.UO, 180.0f, 90.0f, true, paint);
                    canvas.translate(height, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(this.UP.UO, 180.0f, 90.0f, true, paint);
                    canvas.translate(width, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(this.UP.UO, 180.0f, 90.0f, true, paint);
                    canvas.restoreToCount(save);
                    canvas.drawRect((rectF.left + f3) - 1.0f, rectF.top, 1.0f + (rectF.right - f3), rectF.top + f3, paint);
                    canvas.drawRect((rectF.left + f3) - 1.0f, 1.0f + (rectF.bottom - f3), 1.0f + (rectF.right - f3), rectF.bottom, paint);
                }
                canvas.drawRect(rectF.left, Math.max(0.0f, f - 1.0f) + rectF.top, rectF.right, 1.0f + (rectF.bottom - f), paint);
            }
        };
    }

    public final void a(o oVar, Context context, int i, float f, float f2, float f3) {
        Drawable afVar = new af(context.getResources(), i, f, f2, f3);
        afVar.jf = oVar.eI();
        afVar.invalidateSelf();
        oVar.setBackgroundDrawable(afVar);
        Rect rect = new Rect();
        e(oVar).getPadding(rect);
        oVar.x((int) Math.ceil((double) a(oVar)), (int) Math.ceil((double) b(oVar)));
        oVar.c(rect.left, rect.top, rect.right, rect.bottom);
    }

    public final void a(o oVar, int i) {
        af e = e(oVar);
        e.ft.setColor(-1);
        e.invalidateSelf();
    }

    public final void a(o oVar, float f) {
        af e = e(oVar);
        e.d(f, e.iY);
    }

    public final float d(o oVar) {
        return e(oVar).ja;
    }

    public final float a(o oVar) {
        af e = e(oVar);
        return ((((float) e.aaI) + e.iY) * 2.0f) + (Math.max(e.iY, (e.iV + ((float) e.aaI)) + (e.iY / 2.0f)) * 2.0f);
    }

    public final float b(o oVar) {
        af e = e(oVar);
        return ((((float) e.aaI) + (e.iY * DownloadHelper.SAVE_FATOR)) * 2.0f) + (Math.max(e.iY, (e.iV + ((float) e.aaI)) + ((e.iY * DownloadHelper.SAVE_FATOR) / 2.0f)) * 2.0f);
    }

    private static af e(o oVar) {
        return (af) oVar.getBackground();
    }
}
