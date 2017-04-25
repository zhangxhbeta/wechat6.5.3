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

public final class aau extends c {
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
                c.a(g2, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-12799249);
                c = c.a(c, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 11.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(27.39f, 1.59f);
                h.cubicTo(34.1f, -0.34f, 42.03f, 2.41f, 45.55f, 8.57f);
                h.cubicTo(50.69f, 17.75f, 47.8f, 30.26f, 40.07f, 37.12f);
                h.cubicTo(38.37f, 38.32f, 38.73f, 41.26f, 40.63f, 42.07f);
                h.cubicTo(48.12f, 45.88f, 55.8f, 50.27f, 60.7f, 57.32f);
                h.cubicTo(63.44f, 60.98f, 63.18f, 65.75f, 62.92f, 70.07f);
                h.cubicTo(62.88f, 71.98f, 60.86f, 73.2f, 59.09f, 72.98f);
                h.cubicTo(41.02f, 73.01f, 22.93f, 73.01f, 4.86f, 72.98f);
                h.cubicTo(3.09f, 73.2f, 1.11f, 71.94f, 1.08f, 70.05f);
                h.cubicTo(0.85f, 65.98f, 0.57f, 61.52f, 2.96f, 57.98f);
                h.cubicTo(7.67f, 50.59f, 15.53f, 46.13f, 23.04f, 42.09f);
                h.cubicTo(25.09f, 41.02f, 25.02f, 38.06f, 23.18f, 36.81f);
                h.cubicTo(16.97f, 30.9f, 14.24f, 21.58f, 16.21f, 13.24f);
                h.cubicTo(17.51f, 7.74f, 21.84f, 2.97f, 27.39f, 1.59f);
                h.lineTo(27.39f, 1.59f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(57.39f, 12.35f);
                h.cubicTo(61.78f, 5.69f, 72.63f, 5.2f, 77.63f, 11.4f);
                h.cubicTo(82.95f, 18.02f, 81.57f, 28.16f, 76.57f, 34.55f);
                h.cubicTo(75.23f, 36.15f, 72.17f, 38.3f, 74.42f, 40.47f);
                h.cubicTo(80.64f, 43.86f, 87.25f, 47.44f, 91.24f, 53.54f);
                h.cubicTo(93.55f, 56.87f, 93.11f, 61.13f, 92.88f, 64.96f);
                h.cubicTo(92.77f, 66.27f, 91.38f, 67.11f, 90.15f, 66.98f);
                h.cubicTo(82.44f, 67.05f, 74.73f, 66.97f, 67.02f, 67.0f);
                h.cubicTo(66.74f, 57.77f, 60.71f, 49.78f, 52.66f, 45.67f);
                h.cubicTo(55.44f, 43.69f, 58.58f, 42.3f, 61.36f, 40.34f);
                h.cubicTo(62.61f, 39.12f, 61.92f, 37.31f, 60.74f, 36.34f);
                h.cubicTo(54.71f, 30.25f, 52.54f, 19.75f, 57.39f, 12.35f);
                h.lineTo(57.39f, 12.35f);
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
