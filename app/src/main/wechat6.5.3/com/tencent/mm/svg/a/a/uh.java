package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class uh extends c {
    private final int height = 240;
    private final int width = 180;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 180;
            case 1:
                return 240;
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
                g = c.a(g2, looper);
                g.setStrokeWidth(1.0f);
                Paint a = c.a(g, looper);
                a.setColor(-1);
                a.setStrokeWidth(4.0f);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 44.0f, 0.0f, 1.0f, 63.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(0.0f, 4.9965324f);
                h.cubicTo(0.0f, 3.3415933f, 1.3449905f, 2.0f, 2.9962382f, 2.0f);
                h.lineTo(60.00376f, 2.0f);
                h.cubicTo(61.65854f, 2.0f, 63.0f, 3.3373792f, 63.0f, 4.9965324f);
                h.lineTo(63.0f, 49.003468f);
                h.cubicTo(63.0f, 50.658405f, 61.65501f, 52.0f, 60.00376f, 52.0f);
                h.lineTo(2.9962382f, 52.0f);
                h.cubicTo(1.3414615f, 52.0f, 0.0f, 50.66262f, 0.0f, 49.003468f);
                h.lineTo(0.0f, 4.9965324f);
                h.close();
                h.moveTo(87.5f, 53.797123f);
                h.cubicTo(89.91545f, 54.568535f, 92.0f, 53.05244f, 92.0f, 50.732754f);
                h.lineTo(92.0f, 3.235053f);
                h.cubicTo(92.0f, 0.6385606f, 89.694824f, -0.4511346f, 87.5f, 0.17068519f);
                h.cubicTo(86.19809f, 1.3064651f, 75.559074f, 11.176803f, 68.0f, 18.05712f);
                h.lineTo(68.0f, 35.728115f);
                h.cubicTo(75.74342f, 42.702545f, 86.61983f, 52.864586f, 87.5f, 53.797123f);
                h.close();
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
