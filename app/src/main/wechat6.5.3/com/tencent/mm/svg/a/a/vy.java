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

public final class vy extends c {
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
                a.setColor(-1);
                c = c.a(c, 1.0f, 0.0f, 16.0f, 0.0f, 1.0f, 16.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(24.45f, 1.72f);
                h.cubicTo(40.07f, -2.09f, 57.26f, 8.51f, 60.97f, 24.12f);
                h.cubicTo(65.19f, 38.86f, 56.54f, 55.72f, 42.15f, 60.92f);
                h.cubicTo(28.52f, 66.5f, 11.52f, 60.56f, 4.31f, 47.73f);
                h.cubicTo(-2.87f, 36.0f, -0.8f, 19.65f, 9.09f, 10.08f);
                h.cubicTo(13.27f, 5.9f, 18.67f, 2.96f, 24.45f, 1.72f);
                h.lineTo(24.45f, 1.72f);
                h.close();
                h.moveTo(17.17f, 17.07f);
                h.cubicTo(13.49f, 18.92f, 13.95f, 25.17f, 17.95f, 26.36f);
                h.cubicTo(21.46f, 27.53f, 24.61f, 23.5f, 23.56f, 20.23f);
                h.cubicTo(23.05f, 17.48f, 19.71f, 15.55f, 17.17f, 17.07f);
                h.lineTo(17.17f, 17.07f);
                h.close();
                h.moveTo(41.36f, 17.28f);
                h.cubicTo(38.2f, 19.32f, 38.58f, 24.76f, 42.09f, 26.21f);
                h.cubicTo(45.34f, 27.7f, 48.8f, 24.25f, 48.24f, 20.98f);
                h.cubicTo(48.14f, 17.74f, 44.14f, 15.22f, 41.36f, 17.28f);
                h.lineTo(41.36f, 17.28f);
                h.close();
                h.moveTo(10.9f, 36.58f);
                h.cubicTo(12.04f, 40.99f, 14.08f, 45.33f, 17.62f, 48.33f);
                h.cubicTo(23.73f, 53.55f, 32.94f, 54.15f, 40.17f, 51.04f);
                h.cubicTo(46.02f, 48.47f, 49.67f, 42.62f, 51.09f, 36.57f);
                h.cubicTo(44.43f, 35.73f, 37.76f, 34.82f, 31.03f, 34.74f);
                h.cubicTo(24.29f, 34.82f, 17.59f, 35.73f, 10.9f, 36.58f);
                h.lineTo(10.9f, 36.58f);
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
