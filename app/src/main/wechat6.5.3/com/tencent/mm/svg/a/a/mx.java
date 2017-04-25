package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class mx extends c {
    private final int height = 135;
    private final int width = 135;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 135;
            case 1:
                return 135;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.d(looper);
                c.c(looper);
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
                Paint a = c.a(g, looper);
                a.setColor(-10589839);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(64.01f, 0.0f);
                h.lineTo(70.7f, 0.0f);
                h.cubicTo(86.61f, 0.87f, 102.17f, 7.34f, 113.73f, 18.34f);
                h.cubicTo(126.38f, 30.07f, 133.97f, 46.81f, 135.0f, 63.99f);
                h.lineTo(135.0f, 70.74f);
                h.cubicTo(134.07f, 88.04f, 126.42f, 104.91f, 113.68f, 116.71f);
                h.cubicTo(102.21f, 127.63f, 86.78f, 134.04f, 71.01f, 135.0f);
                h.lineTo(64.24f, 135.0f);
                h.cubicTo(48.16f, 134.11f, 32.42f, 127.48f, 20.83f, 116.25f);
                h.cubicTo(8.42f, 104.55f, 1.02f, 87.98f, 0.0f, 71.0f);
                h.lineTo(0.0f, 64.29f);
                h.cubicTo(0.93f, 46.98f, 8.57f, 30.09f, 21.32f, 18.3f);
                h.cubicTo(32.8f, 7.38f, 48.23f, 0.96f, 64.01f, 0.0f);
                h.lineTo(64.01f, 0.0f);
                h.close();
                h.moveTo(57.54f, 3.77f);
                h.cubicTo(42.29f, 6.1f, 28.02f, 14.16f, 18.14f, 26.0f);
                h.cubicTo(8.29f, 37.61f, 2.83f, 52.81f, 3.01f, 68.03f);
                h.cubicTo(3.07f, 82.86f, 8.49f, 97.59f, 18.07f, 108.92f);
                h.cubicTo(28.45f, 121.4f, 43.71f, 129.71f, 59.86f, 131.54f);
                h.cubicTo(73.7f, 133.21f, 88.08f, 130.27f, 100.09f, 123.16f);
                h.cubicTo(112.84f, 115.72f, 122.91f, 103.76f, 127.99f, 89.89f);
                h.cubicTo(133.52f, 75.08f, 133.31f, 58.23f, 127.4f, 43.57f);
                h.cubicTo(121.37f, 28.32f, 109.24f, 15.61f, 94.31f, 8.83f);
                h.cubicTo(82.91f, 3.57f, 69.94f, 1.85f, 57.54f, 3.77f);
                h.lineTo(57.54f, 3.77f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(31.05f, 68.1f);
                h.cubicTo(30.3f, 60.46f, 36.39f, 53.09f, 43.97f, 52.18f);
                h.cubicTo(49.99f, 51.77f, 56.04f, 52.11f, 62.07f, 51.99f);
                h.cubicTo(72.02f, 52.05f, 79.69f, 63.4f, 75.56f, 72.62f);
                h.cubicTo(73.67f, 73.73f, 71.31f, 72.55f, 69.52f, 71.66f);
                h.cubicTo(71.15f, 67.92f, 70.84f, 63.13f, 67.59f, 60.37f);
                h.cubicTo(63.89f, 56.95f, 58.53f, 58.22f, 53.99f, 58.0f);
                h.cubicTo(49.01f, 58.21f, 42.79f, 56.78f, 39.21f, 61.25f);
                h.cubicTo(35.06f, 65.77f, 37.43f, 73.88f, 43.31f, 75.52f);
                h.cubicTo(48.01f, 76.54f, 52.9f, 75.75f, 57.67f, 76.01f);
                h.cubicTo(59.24f, 78.32f, 61.16f, 80.34f, 63.38f, 82.02f);
                h.cubicTo(57.21f, 81.9f, 51.04f, 82.15f, 44.87f, 81.91f);
                h.cubicTo(37.71f, 81.5f, 31.45f, 75.27f, 31.05f, 68.1f);
                h.lineTo(31.05f, 68.1f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(71.78f, 51.99f);
                h.cubicTo(77.89f, 52.05f, 84.01f, 51.94f, 90.13f, 52.02f);
                h.cubicTo(98.38f, 52.58f, 105.3f, 60.83f, 103.84f, 69.11f);
                h.cubicTo(102.87f, 77.07f, 94.81f, 82.98f, 86.94f, 82.02f);
                h.cubicTo(79.39f, 81.39f, 70.7f, 83.89f, 64.22f, 78.81f);
                h.cubicTo(58.78f, 74.83f, 57.16f, 67.31f, 59.35f, 61.12f);
                h.cubicTo(61.38f, 60.93f, 63.5f, 61.01f, 65.25f, 62.19f);
                h.cubicTo(65.22f, 64.45f, 63.93f, 66.69f, 64.71f, 68.98f);
                h.cubicTo(65.53f, 73.18f, 69.7f, 76.18f, 73.91f, 75.98f);
                h.cubicTo(79.3f, 75.96f, 84.7f, 76.15f, 90.09f, 75.88f);
                h.cubicTo(96.55f, 75.34f, 100.28f, 66.93f, 96.22f, 61.81f);
                h.cubicTo(91.84f, 55.82f, 83.59f, 58.66f, 77.33f, 57.99f);
                h.cubicTo(75.78f, 55.72f, 73.88f, 53.74f, 71.78f, 51.99f);
                h.lineTo(71.78f, 51.99f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
