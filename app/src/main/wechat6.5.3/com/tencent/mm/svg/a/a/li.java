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

public final class li extends c {
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
                a.setColor(-10526881);
                c = c.a(c, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 11.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(35.23f, 1.25f);
                h.cubicTo(37.08f, 0.35f, 38.8f, 1.79f, 40.01f, 3.04f);
                h.cubicTo(46.31f, 9.38f, 52.63f, 15.7f, 58.97f, 22.0f);
                h.cubicTo(60.26f, 23.23f, 61.63f, 24.95f, 60.74f, 26.83f);
                h.cubicTo(59.31f, 28.98f, 57.27f, 30.63f, 55.48f, 32.47f);
                h.cubicTo(46.81f, 41.15f, 38.11f, 49.79f, 29.48f, 58.5f);
                h.cubicTo(28.24f, 59.68f, 26.96f, 61.22f, 25.05f, 60.97f);
                h.cubicTo(18.33f, 61.03f, 11.6f, 61.04f, 4.88f, 60.97f);
                h.cubicTo(2.66f, 61.25f, 0.75f, 59.24f, 1.03f, 57.05f);
                h.cubicTo(1.13f, 49.75f, 0.64f, 42.39f, 1.29f, 35.13f);
                h.cubicTo(9.14f, 26.42f, 17.85f, 18.46f, 26.03f, 10.03f);
                h.cubicTo(29.15f, 7.16f, 31.77f, 3.72f, 35.23f, 1.25f);
                h.lineTo(35.23f, 1.25f);
                h.close();
                h.moveTo(16.24f, 38.27f);
                h.cubicTo(12.02f, 39.37f, 10.54f, 45.33f, 13.78f, 48.25f);
                h.cubicTo(16.71f, 51.46f, 22.67f, 49.96f, 23.73f, 45.74f);
                h.cubicTo(25.3f, 41.39f, 20.58f, 36.69f, 16.24f, 38.27f);
                h.lineTo(16.24f, 38.27f);
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
