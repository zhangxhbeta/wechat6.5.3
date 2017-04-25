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

public final class mb extends c {
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
                a.setColor(-10526881);
                c = c.a(c, 1.0f, 0.0f, 8.0f, 0.0f, 1.0f, 12.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(46.01f, 0.01f);
                h.cubicTo(53.34f, 6.17f, 60.67f, 12.34f, 68.0f, 18.5f);
                h.cubicTo(60.71f, 24.71f, 53.32f, 30.81f, 46.01f, 36.99f);
                h.cubicTo(45.99f, 33.32f, 46.0f, 29.65f, 46.0f, 25.98f);
                h.cubicTo(38.87f, 26.16f, 30.95f, 26.38f, 25.17f, 31.13f);
                h.cubicTo(21.73f, 33.95f, 19.85f, 38.09f, 17.96f, 42.0f);
                h.cubicTo(18.18f, 31.95f, 21.11f, 20.87f, 29.62f, 14.66f);
                h.cubicTo(34.26f, 11.04f, 40.36f, 10.72f, 45.99f, 11.02f);
                h.cubicTo(46.0f, 7.35f, 46.0f, 3.68f, 46.01f, 0.01f);
                h.lineTo(46.01f, 0.01f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(1.01f, 14.82f);
                h.cubicTo(0.72f, 13.08f, 1.91f, 10.96f, 3.85f, 11.06f);
                h.cubicTo(9.89f, 10.89f, 15.94f, 11.07f, 21.98f, 10.99f);
                h.cubicTo(20.17f, 13.11f, 18.65f, 15.46f, 17.46f, 17.99f);
                h.cubicTo(14.31f, 18.0f, 11.15f, 18.0f, 8.0f, 18.0f);
                h.lineTo(8.0f, 52.0f);
                h.lineTo(54.0f, 52.0f);
                h.lineTo(54.0f, 40.15f);
                h.cubicTo(56.32f, 38.16f, 58.66f, 36.19f, 60.99f, 34.23f);
                h.cubicTo(60.96f, 41.53f, 61.09f, 48.83f, 60.94f, 56.13f);
                h.cubicTo(61.0f, 58.1f, 58.89f, 59.32f, 57.1f, 59.0f);
                h.cubicTo(39.37f, 58.97f, 21.63f, 59.07f, 3.9f, 58.95f);
                h.cubicTo(1.9f, 59.06f, 0.69f, 56.9f, 1.01f, 55.11f);
                h.cubicTo(1.0f, 41.68f, 0.99f, 28.25f, 1.01f, 14.82f);
                h.lineTo(1.01f, 14.82f);
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
