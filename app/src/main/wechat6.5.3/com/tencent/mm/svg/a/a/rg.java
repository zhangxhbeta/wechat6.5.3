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

public final class rg extends c {
    private final int height = 159;
    private final int width = 159;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 159;
            case 1:
                return 159;
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
                g.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.saveLayerAlpha(null, 23, 4);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(69.69f, 0.0f);
                h.lineTo(89.35f, 0.0f);
                h.cubicTo(106.27f, 2.71f, 122.64f, 9.98f, 134.93f, 22.1f);
                h.cubicTo(148.15f, 34.62f, 156.22f, 51.83f, 159.0f, 69.7f);
                h.lineTo(159.0f, 89.29f);
                h.cubicTo(156.38f, 106.0f, 149.23f, 122.14f, 137.43f, 134.4f);
                h.cubicTo(124.86f, 147.9f, 107.45f, 156.17f, 89.34f, 159.0f);
                h.lineTo(69.67f, 159.0f);
                h.cubicTo(54.38f, 156.5f, 39.5f, 150.47f, 27.73f, 140.23f);
                h.cubicTo(12.48f, 127.48f, 2.96f, 108.82f, 0.0f, 89.29f);
                h.lineTo(0.0f, 69.66f);
                h.cubicTo(2.74f, 52.26f, 10.43f, 35.46f, 23.1f, 23.05f);
                h.cubicTo(35.51f, 10.39f, 52.3f, 2.75f, 69.69f, 0.0f);
                h.lineTo(69.69f, 0.0f);
                h.close();
                h.moveTo(72.39f, 1.64f);
                h.cubicTo(50.03f, 3.41f, 29.01f, 15.72f, 16.0f, 33.9f);
                h.cubicTo(5.98f, 47.41f, 1.2f, 64.29f, 1.1f, 80.99f);
                h.cubicTo(1.79f, 91.02f, 3.49f, 101.11f, 7.59f, 110.36f);
                h.cubicTo(16.56f, 131.17f, 34.91f, 147.82f, 56.67f, 154.32f);
                h.cubicTo(67.11f, 157.23f, 78.17f, 158.89f, 88.95f, 157.08f);
                h.cubicTo(109.53f, 154.89f, 128.7f, 143.65f, 141.32f, 127.36f);
                h.cubicTo(157.73f, 106.72f, 162.16f, 77.57f, 153.09f, 52.87f);
                h.cubicTo(144.96f, 30.37f, 125.99f, 12.03f, 103.11f, 4.91f);
                h.cubicTo(93.2f, 2.07f, 82.69f, 0.28f, 72.39f, 1.64f);
                h.lineTo(72.39f, 1.64f);
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
