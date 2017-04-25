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

public final class nc extends c {
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
                g = c.a(g, looper);
                g.setColor(-9207928);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(63.99f, 0.0f);
                h.lineTo(70.69f, 0.0f);
                h.cubicTo(86.82f, 0.87f, 102.6f, 7.52f, 114.2f, 18.79f);
                h.cubicTo(126.58f, 30.49f, 133.98f, 47.03f, 135.0f, 63.99f);
                h.lineTo(135.0f, 70.31f);
                h.cubicTo(134.21f, 87.99f, 126.31f, 105.25f, 113.19f, 117.17f);
                h.cubicTo(101.77f, 127.81f, 86.56f, 134.04f, 71.02f, 135.0f);
                h.lineTo(64.24f, 135.0f);
                h.cubicTo(48.36f, 134.12f, 32.82f, 127.66f, 21.28f, 116.67f);
                h.cubicTo(8.47f, 104.8f, 0.8f, 87.76f, 0.0f, 70.34f);
                h.lineTo(0.0f, 64.32f);
                h.cubicTo(0.92f, 47.02f, 8.54f, 30.13f, 21.28f, 18.33f);
                h.cubicTo(32.76f, 7.39f, 48.2f, 0.97f, 63.99f, 0.0f);
                h.lineTo(63.99f, 0.0f);
                h.close();
                h.moveTo(71.49f, 36.65f);
                h.cubicTo(68.92f, 37.77f, 68.74f, 41.46f, 70.85f, 43.14f);
                h.cubicTo(77.99f, 50.46f, 82.01f, 60.92f, 80.79f, 71.16f);
                h.cubicTo(79.99f, 79.17f, 75.99f, 86.56f, 70.51f, 92.35f);
                h.cubicTo(67.88f, 95.4f, 72.51f, 100.2f, 75.63f, 97.54f);
                h.cubicTo(84.15f, 89.54f, 88.9f, 77.7f, 88.47f, 66.03f);
                h.cubicTo(88.12f, 55.26f, 83.3f, 44.81f, 75.62f, 37.32f);
                h.cubicTo(74.59f, 36.21f, 72.83f, 35.99f, 71.49f, 36.65f);
                h.lineTo(71.49f, 36.65f);
                h.close();
                h.moveTo(59.31f, 46.29f);
                h.cubicTo(56.61f, 47.98f, 57.55f, 51.65f, 59.81f, 53.25f);
                h.cubicTo(67.48f, 60.25f, 68.05f, 73.25f, 60.75f, 80.72f);
                h.cubicTo(58.94f, 82.47f, 56.3f, 84.97f, 58.29f, 87.62f);
                h.cubicTo(59.72f, 89.79f, 63.0f, 89.59f, 64.51f, 87.62f);
                h.cubicTo(70.09f, 82.35f, 73.71f, 74.82f, 73.47f, 67.07f);
                h.cubicTo(73.45f, 59.15f, 69.42f, 51.65f, 63.57f, 46.48f);
                h.cubicTo(62.43f, 45.43f, 60.57f, 45.5f, 59.31f, 46.29f);
                h.lineTo(59.31f, 46.29f);
                h.close();
                h.moveTo(46.47f, 61.53f);
                h.cubicTo(48.7f, 62.97f, 51.32f, 65.05f, 50.98f, 68.04f);
                h.cubicTo(50.69f, 70.67f, 48.28f, 72.17f, 46.36f, 73.61f);
                h.cubicTo(45.64f, 77.0f, 49.16f, 79.97f, 52.29f, 78.28f);
                h.cubicTo(57.89f, 75.01f, 60.42f, 67.0f, 56.77f, 61.38f);
                h.cubicTo(55.09f, 58.85f, 52.6f, 55.46f, 49.12f, 56.41f);
                h.cubicTo(46.82f, 56.97f, 46.19f, 59.46f, 46.47f, 61.53f);
                h.lineTo(46.47f, 61.53f);
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
