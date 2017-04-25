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

public final class lj extends c {
    private final int height = 84;
    private final int width = 84;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 84;
            case 1:
                return 84;
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
                Paint a = c.a(g, looper);
                a.setColor(-12632257);
                c = c.a(c, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 11.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(35.22f, 1.24f);
                h.cubicTo(37.07f, 0.38f, 38.78f, 1.74f, 39.99f, 3.02f);
                h.cubicTo(46.3f, 9.37f, 52.64f, 15.71f, 59.0f, 22.03f);
                h.cubicTo(60.28f, 23.24f, 61.63f, 24.96f, 60.75f, 26.81f);
                h.cubicTo(59.45f, 28.82f, 57.57f, 30.34f, 55.92f, 32.03f);
                h.cubicTo(46.93f, 41.02f, 37.93f, 50.0f, 28.97f, 59.01f);
                h.cubicTo(27.92f, 60.06f, 26.73f, 61.17f, 25.11f, 60.97f);
                h.cubicTo(18.37f, 61.03f, 11.64f, 61.03f, 4.91f, 60.97f);
                h.cubicTo(2.69f, 61.26f, 0.76f, 59.27f, 1.03f, 57.08f);
                h.cubicTo(0.97f, 50.36f, 0.97f, 43.63f, 1.03f, 36.91f);
                h.cubicTo(0.83f, 35.27f, 1.97f, 34.09f, 3.01f, 33.02f);
                h.cubicTo(12.02f, 24.05f, 21.0f, 15.05f, 29.99f, 6.06f);
                h.cubicTo(31.69f, 4.41f, 33.2f, 2.52f, 35.22f, 1.24f);
                h.lineTo(35.22f, 1.24f);
                h.close();
                h.moveTo(16.19f, 38.29f);
                h.cubicTo(12.01f, 39.42f, 10.56f, 45.34f, 13.77f, 48.25f);
                h.cubicTo(16.68f, 51.44f, 22.61f, 49.99f, 23.71f, 45.81f);
                h.cubicTo(25.36f, 41.43f, 20.56f, 36.65f, 16.19f, 38.29f);
                h.lineTo(16.19f, 38.29f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
