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

public final class yb extends c {
    private final int height = 76;
    private final int width = 76;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 76;
            case 1:
                return 76;
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
                a.setColor(-789517);
                Path h = c.h(looper);
                h.moveTo(0.0f, 4.0f);
                h.cubicTo(0.0f, 1.7908609f, 1.7908609f, 0.0f, 4.0f, 0.0f);
                h.lineTo(72.0f, 0.0f);
                h.cubicTo(74.20914f, 0.0f, 76.0f, 1.7908609f, 76.0f, 4.0f);
                h.lineTo(76.0f, 72.0f);
                h.cubicTo(76.0f, 74.20914f, 74.20914f, 76.0f, 72.0f, 76.0f);
                h.lineTo(4.0f, 76.0f);
                h.cubicTo(1.7908609f, 76.0f, 0.0f, 74.20914f, 0.0f, 72.0f);
                h.lineTo(0.0f, 4.0f);
                h.close();
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-5658199);
                float[] a2 = c.a(c, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 16.0f);
                d.reset();
                d.setValues(a2);
                canvas.concat(d);
                canvas.save();
                Paint a3 = c.a(g, looper);
                h = c.h(looper);
                h.moveTo(3.48f, 15.58f);
                h.cubicTo(0.27f, 9.35f, 5.54f, 1.93f, 12.02f, 1.02f);
                h.cubicTo(19.31f, 0.03f, 26.72f, 0.53f, 34.05f, 0.82f);
                h.cubicTo(31.62f, 2.59f, 28.84f, 3.78f, 26.06f, 4.88f);
                h.cubicTo(27.11f, 7.45f, 28.81f, 10.09f, 28.19f, 12.99f);
                h.cubicTo(27.4f, 16.84f, 23.67f, 19.21f, 22.68f, 22.96f);
                h.cubicTo(24.4f, 28.11f, 31.25f, 30.9f, 30.73f, 37.03f);
                h.cubicTo(30.28f, 45.11f, 21.25f, 49.65f, 13.94f, 49.09f);
                h.cubicTo(7.06f, 49.13f, -1.04f, 43.72f, 0.23f, 36.06f);
                h.cubicTo(1.82f, 28.82f, 9.89f, 26.16f, 16.44f, 25.72f);
                h.cubicTo(16.46f, 24.71f, 16.49f, 23.69f, 16.52f, 22.68f);
                h.cubicTo(11.51f, 22.11f, 5.72f, 20.65f, 3.48f, 15.58f);
                h.lineTo(3.48f, 15.58f);
                h.close();
                h.moveTo(13.2f, 4.24f);
                h.cubicTo(8.59f, 5.84f, 8.82f, 12.22f, 11.58f, 15.43f);
                h.cubicTo(13.94f, 18.89f, 19.98f, 20.67f, 22.69f, 16.69f);
                h.cubicTo(26.26f, 10.87f, 19.77f, 2.34f, 13.2f, 4.24f);
                h.lineTo(13.2f, 4.24f);
                h.close();
                h.moveTo(13.31f, 30.24f);
                h.cubicTo(10.57f, 31.12f, 7.7f, 32.69f, 6.5f, 35.46f);
                h.cubicTo(5.37f, 38.41f, 7.39f, 41.77f, 10.27f, 42.73f);
                h.cubicTo(14.73f, 44.28f, 19.99f, 43.53f, 23.85f, 40.82f);
                h.cubicTo(25.12f, 39.87f, 26.66f, 38.07f, 25.41f, 36.51f);
                h.cubicTo(22.73f, 32.79f, 18.37f, 28.18f, 13.31f, 30.24f);
                h.lineTo(13.31f, 30.24f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(g, looper);
                h = c.h(looper);
                h.moveTo(40.61f, 12.53f);
                h.lineTo(45.05f, 12.53f);
                h.cubicTo(45.05f, 15.02f, 45.05f, 17.5f, 45.06f, 19.99f);
                h.cubicTo(47.58f, 20.0f, 50.09f, 20.01f, 52.61f, 20.02f);
                h.cubicTo(52.6f, 21.52f, 52.59f, 23.02f, 52.58f, 24.52f);
                h.cubicTo(50.08f, 24.52f, 47.57f, 24.53f, 45.06f, 24.54f);
                h.cubicTo(45.05f, 27.02f, 45.05f, 29.51f, 45.05f, 31.99f);
                h.cubicTo(43.57f, 32.0f, 42.08f, 32.0f, 40.6f, 32.0f);
                h.cubicTo(40.6f, 29.51f, 40.59f, 27.03f, 40.58f, 24.54f);
                h.cubicTo(38.07f, 24.53f, 35.56f, 24.52f, 33.05f, 24.52f);
                h.lineTo(33.05f, 20.01f);
                h.cubicTo(35.56f, 20.0f, 38.08f, 19.99f, 40.59f, 19.99f);
                h.cubicTo(40.6f, 17.5f, 40.6f, 15.02f, 40.61f, 12.53f);
                h.lineTo(40.61f, 12.53f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a3);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
