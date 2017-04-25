package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class nr extends c {
    private final int height = 120;
    private final int width = 120;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 120;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix d = c.d(looper);
                float[] c = c.c(looper);
                Paint g = c.g(looper);
                g.setFlags(385);
                g.setStyle(Style.FILL);
                Paint g2 = c.g(looper);
                g2.setFlags(385);
                g2.setStyle(Style.STROKE);
                g.setColor(WebView.NIGHT_MODE_COLOR);
                g2.setStrokeWidth(1.0f);
                g2.setStrokeCap(Cap.BUTT);
                g2.setStrokeJoin(Join.MITER);
                g2.setStrokeMiter(4.0f);
                g2.setPathEffect(null);
                c.a(g2, looper).setStrokeWidth(1.0f);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, -3787.0f, 0.0f, 1.0f, -1426.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 3716.0f, 0.0f, 1.0f, 1222.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 71.0f, 0.0f, 1.0f, 204.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-564640);
                Path h = c.h(looper);
                h.moveTo(120.0f, 60.69974f);
                h.cubicTo(120.0f, 26.989773f, 93.13778f, 0.26119402f, 59.25926f, 0.26119402f);
                h.cubicTo(26.862223f, 0.26119402f, 0.0f, 26.989773f, 0.0f, 60.69974f);
                h.cubicTo(0.0f, 92.9356f, 26.862223f, 119.66418f, 59.25926f, 119.66418f);
                h.cubicTo(93.13778f, 119.66418f, 120.0f, 92.9356f, 120.0f, 60.69974f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                a = c.a(g, looper);
                a.setColor(-1);
                h = c.h(looper);
                h.moveTo(60.0f, 30.697248f);
                h.cubicTo(56.751266f, 30.697248f, 54.240303f, 33.333435f, 54.391315f, 36.579117f);
                h.lineTo(55.892197f, 68.836845f);
                h.cubicTo(55.995052f, 71.04744f, 57.877804f, 72.83948f, 60.06893f, 72.83948f);
                h.lineTo(59.93107f, 72.83948f);
                h.cubicTo(62.13496f, 72.83948f, 64.00457f, 71.055595f, 64.1078f, 68.836845f);
                h.lineTo(65.60868f, 36.579117f);
                h.cubicTo(65.75983f, 33.33065f, 63.242123f, 30.697248f, 60.0f, 30.697248f);
                h.close();
                h.moveTo(60.0f, 91.56936f);
                h.cubicTo(63.248734f, 91.56936f, 65.882355f, 88.948845f, 65.882355f, 85.71627f);
                h.cubicTo(65.882355f, 82.4837f, 63.248734f, 79.86318f, 60.0f, 79.86318f);
                h.cubicTo(56.751266f, 79.86318f, 54.117645f, 82.4837f, 54.117645f, 85.71627f);
                h.cubicTo(54.117645f, 88.948845f, 56.751266f, 91.56936f, 60.0f, 91.56936f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
