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

public final class yn extends c {
    private final int height = 210;
    private final int width = 210;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 210;
            case 1:
                return 210;
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
                c = c.a(c, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 5.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-263173);
                float[] a2 = c.a(c, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f);
                d.reset();
                d.setValues(a2);
                canvas.concat(d);
                canvas.save();
                a = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(24.7f, 33.63f);
                h.cubicTo(40.27f, 15.91f, 62.45f, 4.14f, 85.88f, 1.28f);
                h.cubicTo(108.44f, -1.63f, 131.96f, 3.59f, 151.09f, 15.93f);
                h.cubicTo(172.67f, 29.61f, 188.49f, 52.03f, 194.03f, 76.98f);
                h.cubicTo(200.74f, 105.79f, 193.44f, 137.4f, 174.77f, 160.34f);
                h.cubicTo(173.15f, 160.22f, 171.53f, 160.1f, 169.92f, 159.98f);
                h.cubicTo(183.87f, 143.67f, 192.18f, 122.51f, 192.44f, 100.99f);
                h.cubicTo(193.16f, 79.56f, 185.98f, 58.09f, 172.86f, 41.17f);
                h.cubicTo(159.56f, 23.77f, 139.95f, 11.4f, 118.6f, 6.64f);
                h.cubicTo(99.24f, 2.59f, 78.5f, 4.25f, 60.39f, 12.4f);
                h.cubicTo(38.52f, 21.96f, 20.59f, 40.16f, 11.33f, 62.16f);
                h.cubicTo(-0.62f, 90.04f, 2.12f, 123.71f, 18.58f, 149.22f);
                h.cubicTo(17.56f, 149.45f, 15.51f, 149.9f, 14.49f, 150.13f);
                h.cubicTo(3.87f, 132.83f, -1.21f, 112.21f, 0.26f, 91.96f);
                h.cubicTo(1.63f, 70.52f, 10.41f, 49.66f, 24.7f, 33.63f);
                h.lineTo(24.7f, 33.63f);
                h.lineTo(24.7f, 33.63f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                canvas.save();
                float[] a3 = c.a(a2, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f);
                d.reset();
                d.setValues(a3);
                canvas.concat(d);
                canvas.save();
                Paint a4 = c.a(g, looper);
                h = c.h(looper);
                h.moveTo(99.0f, 198.0f);
                h.cubicTo(153.6762f, 198.0f, 198.0f, 153.6762f, 198.0f, 99.0f);
                h.cubicTo(198.0f, 44.32381f, 153.6762f, 0.0f, 99.0f, 0.0f);
                h.cubicTo(44.32381f, 0.0f, 0.0f, 44.32381f, 0.0f, 99.0f);
                h.cubicTo(0.0f, 153.6762f, 44.32381f, 198.0f, 99.0f, 198.0f);
                h.lineTo(99.0f, 198.0f);
                h.close();
                h.moveTo(99.0f, 193.0f);
                h.cubicTo(150.91476f, 193.0f, 193.0f, 150.91476f, 193.0f, 99.0f);
                h.cubicTo(193.0f, 47.08523f, 150.91476f, 5.0f, 99.0f, 5.0f);
                h.cubicTo(47.08523f, 5.0f, 5.0f, 47.08523f, 5.0f, 99.0f);
                h.cubicTo(5.0f, 150.91476f, 47.08523f, 193.0f, 99.0f, 193.0f);
                h.lineTo(99.0f, 193.0f);
                h.close();
                g2 = c.g(looper);
                g2.setFlags(385);
                g2.setStyle(Style.FILL);
                Paint g3 = c.g(looper);
                g3.setFlags(385);
                g3.setStyle(Style.STROKE);
                g2.setColor(WebView.NIGHT_MODE_COLOR);
                g3.setStrokeWidth(1.0f);
                g3.setStrokeCap(Cap.BUTT);
                g3.setStrokeJoin(Join.MITER);
                g3.setStrokeMiter(4.0f);
                g3.setPathEffect(null);
                float[] a5 = c.a(a3, 198.0f, 0.0f, 0.0f, 0.0f, 198.0f, 0.0f);
                d.reset();
                d.setValues(a5);
                WeChatSVGRenderC2Java.setLinearGradient(a4, 0.5f, 0.0f, 0.5f, 1.0f, new int[]{-1, -1184275}, new float[]{0.0f, 1.0f}, d, 0);
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
