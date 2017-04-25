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

public final class aar extends c {
    private final int height = 168;
    private final int width = 168;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 168;
            case 1:
                return 168;
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
                g2 = c.a(g, looper);
                g2.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.saveLayerAlpha(null, 12, 4);
                canvas.save();
                Paint a = c.a(g2, looper);
                Path h = c.h(looper);
                h.moveTo(75.64f, 0.0f);
                h.lineTo(92.35f, 0.0f);
                h.cubicTo(108.49f, 2.54f, 124.47f, 8.31f, 137.1f, 18.92f);
                h.cubicTo(146.41f, 26.74f, 154.4f, 36.29f, 159.53f, 47.36f);
                h.cubicTo(163.95f, 56.22f, 166.21f, 65.93f, 168.0f, 75.6f);
                h.lineTo(168.0f, 92.35f);
                h.cubicTo(165.12f, 111.53f, 157.1f, 130.37f, 142.86f, 143.85f);
                h.cubicTo(129.5f, 157.55f, 111.09f, 165.1f, 92.41f, 168.0f);
                h.lineTo(75.58f, 168.0f);
                h.cubicTo(56.68f, 165.11f, 38.04f, 157.37f, 24.68f, 143.35f);
                h.cubicTo(10.65f, 129.97f, 2.92f, 111.3f, 0.0f, 92.39f);
                h.lineTo(0.0f, 75.59f);
                h.cubicTo(2.9f, 56.92f, 10.4f, 38.45f, 24.17f, 25.14f);
                h.cubicTo(37.62f, 10.85f, 56.48f, 2.9f, 75.64f, 0.0f);
                h.lineTo(75.64f, 0.0f);
                h.close();
                h.moveTo(46.5f, 68.45f);
                h.cubicTo(45.36f, 76.59f, 46.25f, 84.82f, 46.0f, 92.99f);
                h.cubicTo(46.26f, 100.47f, 45.34f, 108.01f, 46.54f, 115.43f);
                h.cubicTo(51.87f, 117.08f, 57.48f, 117.16f, 62.98f, 117.82f);
                h.cubicTo(76.25f, 119.33f, 89.51f, 120.92f, 102.79f, 122.36f);
                h.cubicTo(108.34f, 122.9f, 113.87f, 124.28f, 119.47f, 123.62f);
                h.cubicTo(120.66f, 115.13f, 119.69f, 106.53f, 120.0f, 97.99f);
                h.cubicTo(119.79f, 90.86f, 120.64f, 83.67f, 119.48f, 76.59f);
                h.cubicTo(113.5f, 74.71f, 107.17f, 74.8f, 101.01f, 73.98f);
                h.cubicTo(88.41f, 72.47f, 75.8f, 71.0f, 63.18f, 69.65f);
                h.cubicTo(57.63f, 69.15f, 52.09f, 67.55f, 46.5f, 68.45f);
                h.lineTo(46.5f, 68.45f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a = c.a(g, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                float[] a2 = c.a(c, 1.0f, 0.0f, 45.0f, 0.0f, 1.0f, 68.0f);
                d.reset();
                d.setValues(a2);
                canvas.concat(d);
                canvas.saveLayerAlpha(null, 25, 4);
                canvas.save();
                Paint a3 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(1.5f, 0.45f);
                h.cubicTo(7.09f, -0.45f, 12.63f, 1.15f, 18.18f, 1.65f);
                h.cubicTo(30.8f, 3.0f, 43.41f, 4.47f, 56.01f, 5.98f);
                h.cubicTo(62.17f, 6.8f, 68.5f, 6.71f, 74.48f, 8.59f);
                h.cubicTo(75.64f, 15.67f, 74.79f, 22.86f, 75.0f, 29.99f);
                h.cubicTo(74.69f, 38.53f, 75.66f, 47.13f, 74.47f, 55.62f);
                h.cubicTo(68.87f, 56.28f, 63.34f, 54.9f, 57.79f, 54.36f);
                h.cubicTo(44.51f, 52.92f, 31.25f, 51.33f, 17.98f, 49.82f);
                h.cubicTo(12.48f, 49.16f, 6.87f, 49.08f, 1.54f, 47.43f);
                h.cubicTo(0.34f, 40.01f, 1.26f, 32.47f, 1.0f, 24.99f);
                h.cubicTo(1.25f, 16.82f, 0.36f, 8.59f, 1.5f, 0.45f);
                h.lineTo(1.5f, 0.45f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a3);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.save();
                a3 = c.a(g, looper);
                a3.setColor(-1644826);
                h = c.h(looper);
                h.moveTo(50.35764f, 63.368923f);
                h.lineTo(113.62674f, 55.344185f);
                h.cubicTo(113.62674f, 55.344185f, 118.90408f, 54.899307f, 118.90408f, 59.134113f);
                h.cubicTo(118.904076f, 63.368923f, 118.90408f, 70.766945f, 118.90408f, 70.766945f);
                h.lineTo(50.35764f, 63.368923f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a3);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
