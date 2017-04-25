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

public final class mc extends c {
    private final int height = 84;
    private final int width = 84;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 84;
            case 1:
                return 84;
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
                a.setColor(-12632257);
                c = c.a(c, 1.0f, 0.0f, 8.0f, 0.0f, 1.0f, 12.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(46.01f, 0.01f);
                h.cubicTo(53.34f, 6.17f, 60.67f, 12.33f, 68.0f, 18.5f);
                h.cubicTo(60.71f, 24.71f, 53.33f, 30.82f, 46.0f, 36.99f);
                h.lineTo(46.0f, 25.98f);
                h.cubicTo(38.85f, 26.16f, 30.92f, 26.38f, 25.14f, 31.16f);
                h.cubicTo(21.72f, 33.97f, 19.85f, 38.1f, 17.97f, 41.99f);
                h.cubicTo(18.18f, 31.93f, 21.12f, 20.86f, 29.63f, 14.65f);
                h.cubicTo(34.27f, 11.04f, 40.36f, 10.72f, 45.99f, 11.02f);
                h.cubicTo(46.0f, 7.35f, 45.99f, 3.68f, 46.01f, 0.01f);
                h.lineTo(46.01f, 0.01f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(1.0f, 14.89f);
                h.cubicTo(0.71f, 13.12f, 1.88f, 10.94f, 3.88f, 11.06f);
                h.cubicTo(9.91f, 10.89f, 15.95f, 11.07f, 21.98f, 10.99f);
                h.cubicTo(20.16f, 13.11f, 18.66f, 15.48f, 17.45f, 17.99f);
                h.cubicTo(14.3f, 18.0f, 11.15f, 18.0f, 8.0f, 18.0f);
                h.lineTo(8.0f, 52.0f);
                h.lineTo(54.0f, 52.0f);
                h.lineTo(54.0f, 40.15f);
                h.cubicTo(56.31f, 38.17f, 58.64f, 36.2f, 60.99f, 34.26f);
                h.cubicTo(60.97f, 41.54f, 61.08f, 48.82f, 60.94f, 56.1f);
                h.cubicTo(61.02f, 58.07f, 58.92f, 59.33f, 57.12f, 58.99f);
                h.cubicTo(39.71f, 59.0f, 22.31f, 59.0f, 4.91f, 59.0f);
                h.cubicTo(3.11f, 59.32f, 0.93f, 58.1f, 1.05f, 56.09f);
                h.cubicTo(0.93f, 42.36f, 1.03f, 28.62f, 1.0f, 14.89f);
                h.lineTo(1.0f, 14.89f);
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
