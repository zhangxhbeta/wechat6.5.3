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

public final class acb extends c {
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
                float[] a = c.a(c, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 4.0f);
                d.reset();
                d.setValues(a);
                canvas.concat(d);
                Paint a2 = c.a(g, looper);
                a2.setColor(-11962667);
                canvas.save();
                Paint a3 = c.a(a2, looper);
                Path h = c.h(looper);
                h.moveTo(0.04f, 6.94f);
                h.cubicTo(8.881784E-16f, 2.86f, 4.0f, -0.44f, 7.99f, 0.0f);
                h.cubicTo(20.37f, 0.04f, 32.75f, -0.07f, 45.12f, 0.05f);
                h.cubicTo(48.71f, 0.04f, 51.97f, 3.27f, 51.94f, 6.87f);
                h.cubicTo(52.12f, 18.57f, 51.89f, 30.28f, 52.04f, 41.99f);
                h.cubicTo(46.03f, 42.0f, 40.01f, 42.01f, 34.0f, 41.99f);
                h.lineTo(34.0f, 36.0f);
                h.cubicTo(36.66f, 36.01f, 39.33f, 35.99f, 42.0f, 36.0f);
                h.lineTo(42.0f, 26.0f);
                h.cubicTo(39.33f, 26.01f, 36.65f, 25.99f, 33.98f, 26.0f);
                h.cubicTo(33.98f, 23.98f, 33.91f, 21.94f, 34.17f, 19.93f);
                h.cubicTo(35.74f, 17.24f, 39.43f, 18.28f, 42.0f, 17.94f);
                h.lineTo(42.0f, 8.01f);
                h.cubicTo(36.9f, 8.27f, 30.84f, 6.82f, 26.7f, 10.63f);
                h.cubicTo(22.53f, 14.63f, 24.4f, 20.89f, 24.01f, 26.0f);
                h.lineTo(18.0f, 26.0f);
                h.lineTo(18.0f, 36.0f);
                h.lineTo(24.0f, 36.0f);
                h.cubicTo(24.0f, 38.0f, 23.99f, 39.99f, 24.0f, 41.99f);
                h.cubicTo(15.99f, 42.0f, 7.97f, 42.0f, -0.04f, 41.99f);
                h.cubicTo(0.09f, 30.31f, -0.1f, 18.62f, 0.04f, 6.94f);
                h.lineTo(0.04f, 6.94f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a3);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-9398565);
                c = c.a(a, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 42.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a4 = c.a(g, looper);
                h = c.h(looper);
                h.moveTo(-0.04f, -0.01f);
                h.cubicTo(7.97f, 0.0f, 15.99f, 0.0f, 24.0f, -0.01f);
                h.lineTo(24.0f, 10.0f);
                h.cubicTo(17.69f, 9.83f, 11.35f, 10.34f, 5.07f, 9.75f);
                h.cubicTo(0.85f, 8.58f, -0.57f, 3.92f, -0.04f, -0.01f);
                h.lineTo(-0.04f, -0.01f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a4);
                canvas.restore();
                canvas.save();
                a4 = c.a(g, looper);
                h = c.h(looper);
                h.moveTo(34.0f, -0.01f);
                h.cubicTo(40.01f, 0.01f, 46.03f, 0.0f, 52.04f, -0.01f);
                h.cubicTo(52.55f, 3.89f, 51.21f, 8.51f, 47.03f, 9.72f);
                h.cubicTo(42.72f, 10.34f, 38.34f, 9.85f, 34.0f, 10.0f);
                h.lineTo(34.0f, -0.01f);
                h.lineTo(34.0f, -0.01f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
