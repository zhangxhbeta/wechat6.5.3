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

public final class kr extends c {
    private final int height = 224;
    private final int width = 224;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 224;
            case 1:
                return 224;
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
                float[] a = c.a(c, 1.0f, 0.0f, 25.0f, 0.0f, 1.0f, 60.0f);
                d.reset();
                d.setValues(a);
                canvas.concat(d);
                Paint a2 = c.a(g, looper);
                a2.setColor(-1749411);
                canvas.save();
                Paint a3 = c.a(a2, looper);
                Path h = c.h(looper);
                h.moveTo(78.05f, 2.08f);
                h.cubicTo(92.32f, -2.34f, 108.61f, 0.42f, 120.54f, 9.45f);
                h.cubicTo(131.03f, 17.08f, 138.02f, 29.15f, 139.66f, 42.01f);
                h.cubicTo(150.08f, 40.99f, 160.9f, 45.34f, 167.32f, 53.67f);
                h.cubicTo(174.74f, 62.81f, 176.09f, 76.3f, 170.66f, 86.74f);
                h.cubicTo(165.6f, 96.97f, 154.51f, 103.83f, 143.08f, 103.73f);
                h.cubicTo(107.72f, 103.72f, 72.35f, 103.76f, 36.99f, 103.71f);
                h.cubicTo(21.48f, 103.54f, 6.85f, 92.76f, 2.02f, 78.03f);
                h.cubicTo(-2.32f, 65.62f, 0.47f, 51.06f, 9.16f, 41.18f);
                h.cubicTo(18.37f, 30.18f, 33.97f, 25.52f, 47.79f, 29.14f);
                h.cubicTo(53.35f, 16.31f, 64.62f, 6.08f, 78.05f, 2.08f);
                h.lineTo(78.05f, 2.08f);
                h.close();
                h.moveTo(88.29f, 34.29f);
                h.cubicTo(86.16f, 35.27f, 85.9f, 37.85f, 86.04f, 39.91f);
                h.cubicTo(86.45f, 50.3f, 86.59f, 60.7f, 87.07f, 71.08f);
                h.cubicTo(87.03f, 73.46f, 90.38f, 74.74f, 92.01f, 73.03f);
                h.cubicTo(93.22f, 72.07f, 92.9f, 70.4f, 93.07f, 69.06f);
                h.cubicTo(93.32f, 58.68f, 93.77f, 48.31f, 93.96f, 37.93f);
                h.cubicTo(94.28f, 34.98f, 90.81f, 32.98f, 88.29f, 34.29f);
                h.lineTo(88.29f, 34.29f);
                h.close();
                h.moveTo(88.38f, 80.23f);
                h.cubicTo(85.15f, 82.09f, 88.2f, 87.31f, 91.36f, 85.43f);
                h.cubicTo(95.05f, 83.76f, 91.72f, 77.96f, 88.38f, 80.23f);
                h.lineTo(88.38f, 80.23f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a3);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-1);
                c = c.a(a, 1.0f, 0.0f, 86.0f, 0.0f, 1.0f, 33.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a4 = c.a(g, looper);
                h = c.h(looper);
                h.moveTo(2.29f, 1.29f);
                h.cubicTo(4.81f, -0.02f, 8.28f, 1.98f, 7.96f, 4.93f);
                h.cubicTo(7.77f, 15.31f, 7.32f, 25.68f, 7.07f, 36.06f);
                h.cubicTo(6.9f, 37.4f, 7.22f, 39.07f, 6.01f, 40.03f);
                h.cubicTo(4.38f, 41.74f, 1.03f, 40.46f, 1.07f, 38.08f);
                h.cubicTo(0.59f, 27.7f, 0.45f, 17.3f, 0.04f, 6.91f);
                h.cubicTo(-0.1f, 4.85f, 0.16f, 2.27f, 2.29f, 1.29f);
                h.lineTo(2.29f, 1.29f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a4);
                canvas.restore();
                canvas.save();
                a4 = c.a(g, looper);
                h = c.h(looper);
                h.moveTo(2.38f, 47.23f);
                h.cubicTo(5.72f, 44.96f, 9.05f, 50.76f, 5.36f, 52.43f);
                h.cubicTo(2.2f, 54.31f, -0.85f, 49.09f, 2.38f, 47.23f);
                h.lineTo(2.38f, 47.23f);
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
