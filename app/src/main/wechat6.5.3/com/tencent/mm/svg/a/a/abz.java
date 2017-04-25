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

public final class abz extends c {
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
                g.setColor(-7960954);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(37.78f, 0.0f);
                h.lineTo(41.06f, 0.0f);
                h.cubicTo(50.72f, 0.32f, 60.25f, 4.09f, 67.28f, 10.76f);
                h.cubicTo(74.82f, 17.7f, 79.36f, 27.62f, 80.0f, 37.82f);
                h.lineTo(80.0f, 41.96f);
                h.cubicTo(79.4f, 53.2f, 73.96f, 64.11f, 65.11f, 71.1f);
                h.cubicTo(58.68f, 76.45f, 50.49f, 79.36f, 42.2f, 80.0f);
                h.lineTo(38.02f, 80.0f);
                h.cubicTo(29.65f, 79.43f, 21.38f, 76.49f, 14.9f, 71.1f);
                h.cubicTo(5.88f, 63.97f, 0.36f, 52.77f, 0.0f, 41.29f);
                h.lineTo(0.0f, 38.03f);
                h.cubicTo(0.57f, 27.75f, 5.14f, 17.73f, 12.73f, 10.75f);
                h.cubicTo(19.48f, 4.33f, 28.54f, 0.68f, 37.78f, 0.0f);
                h.lineTo(37.78f, 0.0f);
                h.close();
                h.moveTo(22.35f, 21.53f);
                h.cubicTo(17.6f, 23.92f, 17.99f, 32.16f, 23.16f, 33.8f);
                h.cubicTo(27.59f, 35.1f, 30.99f, 29.79f, 29.81f, 25.87f);
                h.cubicTo(29.31f, 22.58f, 25.55f, 19.78f, 22.35f, 21.53f);
                h.lineTo(22.35f, 21.53f);
                h.close();
                h.moveTo(53.4f, 21.51f);
                h.cubicTo(48.31f, 23.96f, 49.12f, 33.05f, 54.92f, 33.96f);
                h.cubicTo(59.09f, 34.44f, 61.82f, 29.6f, 60.82f, 25.93f);
                h.cubicTo(60.35f, 22.64f, 56.62f, 19.79f, 53.4f, 21.51f);
                h.lineTo(53.4f, 21.51f);
                h.close();
                h.moveTo(11.94f, 43.0f);
                h.cubicTo(12.98f, 52.49f, 18.9f, 61.77f, 28.15f, 65.02f);
                h.cubicTo(36.8f, 68.0f, 46.7f, 67.7f, 55.11f, 64.05f);
                h.cubicTo(63.24f, 60.48f, 68.0f, 51.67f, 68.07f, 43.0f);
                h.cubicTo(49.59f, 39.13f, 30.42f, 39.11f, 11.94f, 43.0f);
                h.lineTo(11.94f, 43.0f);
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
