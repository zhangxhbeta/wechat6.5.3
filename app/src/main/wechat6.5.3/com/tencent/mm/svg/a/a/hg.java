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

public final class hg extends c {
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
                Paint a = c.a(g, looper);
                a.setColor(-1);
                c = c.a(c, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 5.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(11.71f, 0.65f);
                h.cubicTo(13.16f, -0.49f, 15.54f, 0.4f, 15.97f, 2.18f);
                h.cubicTo(16.66f, 4.08f, 14.73f, 5.41f, 13.74f, 6.74f);
                h.cubicTo(7.06f, 13.89f, 4.53f, 24.79f, 7.91f, 34.05f);
                h.cubicTo(9.17f, 38.24f, 11.95f, 41.66f, 14.49f, 45.11f);
                h.cubicTo(15.89f, 47.78f, 11.79f, 50.5f, 9.92f, 48.17f);
                h.cubicTo(5.54f, 42.99f, 2.1f, 36.8f, 1.12f, 30.01f);
                h.cubicTo(-0.61f, 19.28f, 3.6f, 7.83f, 11.71f, 0.65f);
                h.lineTo(11.71f, 0.65f);
                h.lineTo(11.71f, 0.65f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(21.54f, 8.56f);
                h.cubicTo(23.03f, 7.48f, 25.01f, 8.49f, 25.71f, 10.02f);
                h.cubicTo(26.07f, 11.88f, 24.53f, 13.18f, 23.6f, 14.56f);
                h.cubicTo(19.87f, 19.22f, 18.8f, 25.83f, 20.84f, 31.44f);
                h.cubicTo(21.6f, 33.87f, 23.29f, 35.83f, 24.47f, 38.05f);
                h.cubicTo(25.03f, 39.94f, 23.0f, 41.56f, 21.24f, 40.92f);
                h.cubicTo(12.08f, 32.68f, 12.35f, 16.7f, 21.54f, 8.56f);
                h.lineTo(21.54f, 8.56f);
                h.lineTo(21.54f, 8.56f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(30.63f, 15.39f);
                h.cubicTo(32.52f, 13.6f, 36.11f, 15.44f, 35.66f, 18.01f);
                h.cubicTo(35.07f, 20.61f, 32.21f, 22.23f, 32.25f, 25.08f);
                h.cubicTo(31.82f, 27.77f, 34.27f, 29.5f, 34.98f, 31.86f);
                h.cubicTo(35.37f, 34.54f, 31.58f, 36.31f, 29.8f, 34.27f);
                h.cubicTo(25.33f, 28.87f, 26.03f, 20.48f, 30.63f, 15.39f);
                h.lineTo(30.63f, 15.39f);
                h.lineTo(30.63f, 15.39f);
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
