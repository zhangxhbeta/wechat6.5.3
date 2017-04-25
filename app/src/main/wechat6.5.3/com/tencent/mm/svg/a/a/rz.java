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

public final class rz extends c {
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
                a.setColor(-6710887);
                c = c.a(c, 1.0f, 0.0f, 14.0f, 0.0f, 1.0f, 12.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(32.15f, 1.21f);
                h.cubicTo(35.31f, 0.04f, 39.4f, 2.29f, 38.97f, 5.93f);
                h.cubicTo(38.98f, 15.62f, 39.11f, 25.32f, 38.91f, 35.01f);
                h.cubicTo(38.66f, 40.35f, 29.36f, 40.37f, 29.1f, 35.03f);
                h.cubicTo(28.84f, 25.66f, 29.08f, 16.28f, 28.99f, 6.91f);
                h.cubicTo(28.75f, 4.59f, 29.67f, 1.89f, 32.15f, 1.21f);
                h.lineTo(32.15f, 1.21f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(10.5f, 14.5f);
                h.cubicTo(13.31f, 12.04f, 18.2f, 14.27f, 18.4f, 17.95f);
                h.cubicTo(18.76f, 20.52f, 16.55f, 22.3f, 15.2f, 24.19f);
                h.cubicTo(10.43f, 29.93f, 8.89f, 38.04f, 10.82f, 45.2f);
                h.cubicTo(12.8f, 52.84f, 18.84f, 59.26f, 26.33f, 61.74f);
                h.cubicTo(34.52f, 64.55f, 44.17f, 62.52f, 50.42f, 56.49f);
                h.cubicTo(56.65f, 50.76f, 59.37f, 41.62f, 57.34f, 33.41f);
                h.cubicTo(56.41f, 29.04f, 53.92f, 25.26f, 50.99f, 21.97f);
                h.cubicTo(49.54f, 20.48f, 48.99f, 18.13f, 50.02f, 16.26f);
                h.cubicTo(51.35f, 13.27f, 55.79f, 12.49f, 57.98f, 14.96f);
                h.cubicTo(66.34f, 23.07f, 69.85f, 35.71f, 67.04f, 47.0f);
                h.cubicTo(63.74f, 61.51f, 49.98f, 72.8f, 35.06f, 72.95f);
                h.cubicTo(20.81f, 73.68f, 6.93f, 64.23f, 2.13f, 50.83f);
                h.cubicTo(-2.61f, 38.49f, 0.77f, 23.49f, 10.5f, 14.5f);
                h.lineTo(10.5f, 14.5f);
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
