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

public final class kz extends c {
    private final int height = 96;
    private final int width = 96;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                Paint a = c.a(g2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                float[] a2 = c.a(c, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 6.0f);
                d.reset();
                d.setValues(a2);
                canvas.concat(d);
                canvas.save();
                a = c.a(a, looper);
                a.setColor(-7368817);
                a.setStrokeWidth(4.0f);
                Path h = c.h(looper);
                h.moveTo(7.6666665f, 65.166664f);
                h.cubicTo(2.8610327f, 58.913887f, 0.0f, 50.84655f, 0.0f, 42.166668f);
                h.cubicTo(0.0f, 18.87866f, 20.594902f, 0.0f, 46.0f, 0.0f);
                h.cubicTo(71.4051f, 0.0f, 92.0f, 18.87866f, 92.0f, 42.166668f);
                h.cubicTo(92.0f, 65.45467f, 71.4051f, 84.333336f, 46.0f, 84.333336f);
                h.cubicTo(38.253445f, 84.333336f, 30.954128f, 82.57806f, 24.277779f, 79.22222f);
                h.cubicTo(23.092f, 78.76975f, 21.344f, 78.67605f, 19.166666f, 79.22222f);
                h.cubicTo(15.825363f, 80.18592f, 7.6666665f, 81.77778f, 7.6666665f, 81.77778f);
                h.cubicTo(6.6412625f, 81.77778f, 6.388889f, 81.77778f, 6.388889f, 80.5f);
                h.cubicTo(6.388889f, 80.5f, 8.269495f, 74.6702f, 8.944445f, 71.55556f);
                h.cubicTo(9.706f, 69.07142f, 8.924f, 67.19734f, 7.6666665f, 65.166664f);
                h.close();
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-7368817);
                c = c.a(a2, 1.0f, 0.0f, 20.6789f, 0.0f, 1.0f, 36.715595f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a3 = c.a(g, looper);
                h = c.h(looper);
                h.moveTo(5.06422f, 0.0f);
                h.cubicTo(7.8611116f, 0.0f, 10.12844f, 2.2673283f, 10.12844f, 5.06422f);
                h.cubicTo(10.12844f, 7.8611116f, 7.8611116f, 10.12844f, 5.06422f, 10.12844f);
                h.cubicTo(2.2673283f, 10.12844f, 0.0f, 7.8611116f, 0.0f, 5.06422f);
                h.cubicTo(0.0f, 2.2673283f, 2.2673283f, 0.0f, 5.06422f, 0.0f);
                h.close();
                canvas.drawPath(h, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(g, looper);
                h = c.h(looper);
                h.moveTo(25.04361f, 0.0f);
                h.cubicTo(27.840502f, 0.0f, 30.10783f, 2.2673283f, 30.10783f, 5.06422f);
                h.cubicTo(30.10783f, 7.8611116f, 27.840502f, 10.12844f, 25.04361f, 10.12844f);
                h.cubicTo(22.246717f, 10.12844f, 19.97939f, 7.8611116f, 19.97939f, 5.06422f);
                h.cubicTo(19.97939f, 2.2673283f, 22.246717f, 0.0f, 25.04361f, 0.0f);
                h.close();
                canvas.drawPath(h, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(g, looper);
                h = c.h(looper);
                h.moveTo(45.023f, 0.0f);
                h.cubicTo(47.81989f, 0.0f, 50.08722f, 2.2673283f, 50.08722f, 5.06422f);
                h.cubicTo(50.08722f, 7.8611116f, 47.81989f, 10.12844f, 45.023f, 10.12844f);
                h.cubicTo(42.22611f, 10.12844f, 39.95878f, 7.8611116f, 39.95878f, 5.06422f);
                h.cubicTo(39.95878f, 2.2673283f, 42.22611f, 0.0f, 45.023f, 0.0f);
                h.close();
                canvas.drawPath(h, a3);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
