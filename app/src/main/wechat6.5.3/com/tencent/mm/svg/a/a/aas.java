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

public final class aas extends c {
    private final int height = 222;
    private final int width = 222;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 222;
            case 1:
                return 222;
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
                g2.setColor(-8806);
                canvas.save();
                Paint a = c.a(g2, looper);
                Path h = c.h(looper);
                h.moveTo(108.41f, 0.0f);
                h.lineTo(113.56f, 0.0f);
                h.cubicTo(139.19f, 0.58f, 164.5f, 10.31f, 183.78f, 27.22f);
                h.cubicTo(206.99f, 47.15f, 221.11f, 77.02f, 222.0f, 107.59f);
                h.lineTo(222.0f, 111.72f);
                h.cubicTo(221.92f, 139.4f, 210.98f, 166.83f, 191.95f, 186.92f);
                h.cubicTo(171.7f, 208.74f, 142.35f, 221.7f, 112.58f, 222.0f);
                h.lineTo(107.9f, 222.0f);
                h.cubicTo(79.15f, 221.23f, 50.91f, 208.82f, 31.06f, 187.98f);
                h.cubicTo(12.03f, 168.43f, 0.85f, 141.66f, 0.0f, 114.41f);
                h.lineTo(0.0f, 107.69f);
                h.cubicTo(0.84f, 79.23f, 13.02f, 51.32f, 33.52f, 31.54f);
                h.cubicTo(53.31f, 12.06f, 80.65f, 0.61f, 108.41f, 0.0f);
                h.lineTo(108.41f, 0.0f);
                h.close();
                h.moveTo(166.8f, 67.65f);
                h.cubicTo(141.14f, 93.13f, 115.55f, 118.68f, 89.88f, 144.15f);
                h.cubicTo(78.41f, 132.89f, 67.14f, 121.42f, 55.64f, 110.2f);
                h.cubicTo(53.08f, 107.82f, 50.36f, 110.96f, 48.69f, 112.83f);
                h.cubicTo(47.23f, 114.01f, 46.74f, 116.38f, 48.25f, 117.73f);
                h.cubicTo(61.05f, 130.61f, 73.99f, 143.36f, 86.84f, 156.19f);
                h.cubicTo(88.39f, 158.28f, 91.57f, 158.14f, 93.05f, 156.06f);
                h.cubicTo(120.26f, 128.91f, 147.6f, 101.88f, 174.75f, 74.68f);
                h.cubicTo(177.24f, 72.19f, 174.13f, 69.37f, 172.24f, 67.73f);
                h.cubicTo(170.89f, 65.97f, 168.16f, 65.84f, 166.8f, 67.65f);
                h.lineTo(166.8f, 67.65f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-1940159);
                float[] a2 = c.a(c, 1.0f, 0.0f, 47.0f, 0.0f, 1.0f, 66.0f);
                d.reset();
                d.setValues(a2);
                canvas.concat(d);
                canvas.save();
                Paint a3 = c.a(g, looper);
                h = c.h(looper);
                h.moveTo(119.8f, 1.65f);
                h.cubicTo(121.16f, -0.16f, 123.89f, -0.03f, 125.24f, 1.73f);
                h.cubicTo(127.13f, 3.37f, 130.24f, 6.19f, 127.75f, 8.68f);
                h.cubicTo(100.6f, 35.88f, 73.26f, 62.91f, 46.05f, 90.06f);
                h.cubicTo(44.57f, 92.14f, 41.39f, 92.28f, 39.84f, 90.19f);
                h.cubicTo(26.99f, 77.36f, 14.05f, 64.61f, 1.25f, 51.73f);
                h.cubicTo(-0.26f, 50.38f, 0.23f, 48.01f, 1.69f, 46.83f);
                h.cubicTo(3.36f, 44.96f, 6.08f, 41.82f, 8.64f, 44.2f);
                h.cubicTo(20.14f, 55.42f, 31.41f, 66.89f, 42.88f, 78.15f);
                h.cubicTo(68.55f, 52.68f, 94.14f, 27.13f, 119.8f, 1.65f);
                h.lineTo(119.8f, 1.65f);
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
