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

public final class ach extends c {
    private final int height = 60;
    private final int width = 60;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                a.setColor(-12206054);
                c = c.a(c, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 6.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(18.37f, 1.52f);
                h.cubicTo(23.08f, 0.55f, 28.2f, 0.64f, 32.69f, 2.53f);
                h.cubicTo(41.17f, 5.91f, 47.42f, 14.72f, 47.03f, 23.96f);
                h.cubicTo(47.65f, 36.29f, 36.31f, 47.64f, 23.98f, 47.03f);
                h.cubicTo(10.46f, 47.71f, -1.15f, 34.21f, 1.07f, 20.93f);
                h.cubicTo(2.04f, 11.65f, 9.54f, 3.93f, 18.37f, 1.52f);
                h.lineTo(18.37f, 1.52f);
                h.close();
                h.moveTo(5.04f, 17.36f);
                h.cubicTo(7.12f, 19.25f, 7.11f, 22.21f, 7.98f, 24.7f);
                h.cubicTo(10.56f, 25.78f, 13.04f, 27.06f, 15.5f, 28.38f);
                h.cubicTo(15.2f, 27.12f, 14.76f, 25.91f, 14.18f, 24.77f);
                h.cubicTo(13.02f, 23.83f, 11.45f, 24.49f, 10.12f, 24.44f);
                h.cubicTo(10.26f, 22.87f, 9.41f, 20.87f, 10.68f, 19.61f);
                h.cubicTo(11.97f, 18.33f, 13.92f, 18.68f, 15.56f, 18.44f);
                h.cubicTo(16.27f, 19.32f, 16.97f, 20.19f, 17.68f, 21.06f);
                h.cubicTo(17.86f, 18.91f, 17.17f, 16.47f, 18.57f, 14.6f);
                h.cubicTo(20.53f, 11.73f, 22.95f, 9.18f, 24.96f, 6.33f);
                h.lineTo(18.93f, 6.33f);
                h.cubicTo(19.0f, 7.24f, 19.16f, 9.05f, 19.23f, 9.96f);
                h.lineTo(20.48f, 10.29f);
                h.cubicTo(17.86f, 11.08f, 17.12f, 7.21f, 15.92f, 5.62f);
                h.cubicTo(10.94f, 7.98f, 7.02f, 12.21f, 5.04f, 17.36f);
                h.lineTo(5.04f, 17.36f);
                h.close();
                h.moveTo(17.15f, 27.13f);
                h.cubicTo(17.83f, 28.03f, 18.53f, 28.93f, 19.11f, 29.91f);
                h.cubicTo(19.58f, 32.28f, 17.17f, 34.5f, 18.31f, 36.83f);
                h.cubicTo(19.38f, 39.03f, 22.16f, 38.94f, 24.2f, 39.46f);
                h.cubicTo(24.1f, 41.01f, 23.94f, 42.56f, 23.79f, 44.12f);
                h.cubicTo(26.84f, 43.83f, 30.18f, 43.63f, 32.47f, 41.31f);
                h.cubicTo(34.92f, 39.12f, 38.83f, 37.01f, 38.16f, 33.14f);
                h.cubicTo(38.13f, 31.02f, 35.31f, 32.11f, 34.01f, 31.85f);
                h.cubicTo(31.97f, 29.6f, 30.48f, 25.84f, 27.01f, 25.72f);
                h.cubicTo(23.74f, 26.33f, 20.54f, 27.89f, 17.15f, 27.13f);
                h.lineTo(17.15f, 27.13f);
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
