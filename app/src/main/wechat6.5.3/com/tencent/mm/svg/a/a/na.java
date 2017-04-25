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

public final class na extends c {
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
                h.moveTo(64.31f, 0.0f);
                h.lineTo(70.36f, 0.0f);
                h.cubicTo(86.13f, 0.75f, 101.58f, 7.05f, 113.16f, 17.81f);
                h.cubicTo(126.28f, 29.71f, 134.19f, 46.96f, 135.0f, 64.63f);
                h.lineTo(135.0f, 70.06f);
                h.cubicTo(134.29f, 87.85f, 126.34f, 105.24f, 113.14f, 117.21f);
                h.cubicTo(101.65f, 127.9f, 86.33f, 134.15f, 70.7f, 135.0f);
                h.lineTo(64.61f, 135.0f);
                h.cubicTo(48.84f, 134.24f, 33.37f, 127.94f, 21.8f, 117.16f);
                h.cubicTo(8.65f, 105.22f, 0.75f, 87.89f, 0.0f, 70.17f);
                h.lineTo(0.0f, 64.67f);
                h.cubicTo(0.8f, 47.0f, 8.69f, 29.74f, 21.81f, 17.84f);
                h.cubicTo(33.31f, 7.13f, 48.65f, 0.86f, 64.31f, 0.0f);
                h.lineTo(64.31f, 0.0f);
                h.close();
                h.moveTo(39.37f, 50.47f);
                h.cubicTo(37.77f, 51.38f, 38.02f, 53.4f, 37.98f, 54.96f);
                h.cubicTo(38.05f, 64.0f, 37.92f, 73.04f, 38.04f, 82.08f);
                h.cubicTo(37.95f, 83.58f, 39.36f, 85.08f, 40.89f, 84.96f);
                h.cubicTo(53.29f, 85.03f, 65.69f, 85.03f, 78.09f, 84.96f);
                h.cubicTo(79.61f, 85.08f, 81.04f, 83.62f, 80.96f, 82.12f);
                h.cubicTo(81.06f, 72.7f, 80.98f, 63.29f, 81.0f, 53.87f);
                h.cubicTo(81.29f, 52.11f, 80.14f, 49.93f, 78.14f, 50.05f);
                h.cubicTo(66.77f, 49.91f, 55.39f, 50.07f, 44.02f, 49.98f);
                h.cubicTo(42.49f, 50.13f, 40.76f, 49.67f, 39.37f, 50.47f);
                h.lineTo(39.37f, 50.47f);
                h.close();
                h.moveTo(84.01f, 64.47f);
                h.cubicTo(84.0f, 66.98f, 83.99f, 69.48f, 84.0f, 71.99f);
                h.cubicTo(89.66f, 76.01f, 95.34f, 80.0f, 101.01f, 84.01f);
                h.cubicTo(100.99f, 73.01f, 101.01f, 62.01f, 101.0f, 51.01f);
                h.cubicTo(95.32f, 55.47f, 89.7f, 60.01f, 84.01f, 64.47f);
                h.lineTo(84.01f, 64.47f);
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
