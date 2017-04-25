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

public final class aby extends c {
    private final int height = 80;
    private final int width = 80;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 80;
            case 1:
                return 80;
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
                g.setColor(-11316397);
                canvas.saveLayerAlpha(null, 192, 4);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(37.22f, 0.0f);
                h.lineTo(41.24f, 0.0f);
                h.cubicTo(51.3f, 0.4f, 61.21f, 4.53f, 68.29f, 11.75f);
                h.cubicTo(75.07f, 18.41f, 79.06f, 27.57f, 80.0f, 36.98f);
                h.lineTo(80.0f, 42.08f);
                h.cubicTo(79.34f, 53.27f, 73.92f, 64.13f, 65.09f, 71.1f);
                h.cubicTo(58.82f, 76.35f, 50.85f, 79.17f, 42.77f, 80.0f);
                h.lineTo(37.53f, 80.0f);
                h.cubicTo(29.35f, 79.27f, 21.28f, 76.41f, 14.93f, 71.12f);
                h.cubicTo(5.92f, 64.01f, 0.41f, 52.84f, 0.0f, 41.39f);
                h.lineTo(0.0f, 37.28f);
                h.cubicTo(0.83f, 27.74f, 4.89f, 18.45f, 11.75f, 11.72f);
                h.cubicTo(18.45f, 4.85f, 27.73f, 0.92f, 37.22f, 0.0f);
                h.lineTo(37.22f, 0.0f);
                h.lineTo(37.22f, 0.0f);
                h.close();
                h.moveTo(22.36f, 21.51f);
                h.cubicTo(17.63f, 23.88f, 17.96f, 32.09f, 23.09f, 33.78f);
                h.cubicTo(27.53f, 35.16f, 30.98f, 29.87f, 29.83f, 25.92f);
                h.cubicTo(29.37f, 22.59f, 25.58f, 19.78f, 22.36f, 21.51f);
                h.lineTo(22.36f, 21.51f);
                h.lineTo(22.36f, 21.51f);
                h.close();
                h.moveTo(53.42f, 21.49f);
                h.cubicTo(48.62f, 23.81f, 48.94f, 32.09f, 54.09f, 33.78f);
                h.cubicTo(58.54f, 35.16f, 61.99f, 29.86f, 60.82f, 25.91f);
                h.cubicTo(60.36f, 22.61f, 56.63f, 19.81f, 53.42f, 21.49f);
                h.lineTo(53.42f, 21.49f);
                h.lineTo(53.42f, 21.49f);
                h.close();
                h.moveTo(11.95f, 42.99f);
                h.cubicTo(12.95f, 52.73f, 19.22f, 62.19f, 28.79f, 65.26f);
                h.cubicTo(37.5f, 67.98f, 47.39f, 67.67f, 55.7f, 63.77f);
                h.cubicTo(63.52f, 60.07f, 68.0f, 51.44f, 68.08f, 42.99f);
                h.cubicTo(49.6f, 39.13f, 30.42f, 39.11f, 11.95f, 42.99f);
                h.lineTo(11.95f, 42.99f);
                h.lineTo(11.95f, 42.99f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
