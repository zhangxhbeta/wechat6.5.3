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

public final class aat extends c {
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
                g2.setColor(-11286451);
                canvas.save();
                Paint a = c.a(g2, looper);
                Path h = c.h(looper);
                h.moveTo(106.78f, 0.0f);
                h.lineTo(114.26f, 0.0f);
                h.cubicTo(143.67f, 0.83f, 172.5f, 13.86f, 192.4f, 35.56f);
                h.cubicTo(210.27f, 54.61f, 220.71f, 80.13f, 222.0f, 106.17f);
                h.lineTo(222.0f, 115.49f);
                h.cubicTo(220.85f, 140.93f, 210.93f, 165.91f, 193.85f, 184.84f);
                h.cubicTo(173.91f, 207.48f, 144.4f, 221.16f, 114.26f, 222.0f);
                h.lineTo(107.88f, 222.0f);
                h.cubicTo(78.88f, 221.22f, 50.43f, 208.59f, 30.55f, 187.44f);
                h.cubicTo(12.11f, 168.27f, 1.27f, 142.3f, 0.0f, 115.78f);
                h.lineTo(0.0f, 107.09f);
                h.cubicTo(1.01f, 80.27f, 11.92f, 53.95f, 30.53f, 34.57f);
                h.cubicTo(50.17f, 13.67f, 78.16f, 1.14f, 106.78f, 0.0f);
                h.lineTo(106.78f, 0.0f);
                h.close();
                h.moveTo(166.75f, 67.7f);
                h.cubicTo(141.11f, 93.18f, 115.52f, 118.69f, 89.88f, 144.16f);
                h.cubicTo(78.65f, 133.04f, 67.47f, 121.87f, 56.26f, 110.74f);
                h.cubicTo(55.32f, 109.66f, 53.84f, 108.99f, 52.43f, 109.53f);
                h.cubicTo(49.78f, 111.27f, 45.1f, 115.1f, 48.7f, 118.23f);
                h.cubicTo(60.56f, 130.06f, 72.47f, 141.86f, 84.32f, 153.7f);
                h.cubicTo(85.66f, 154.99f, 86.88f, 156.46f, 88.47f, 157.46f);
                h.cubicTo(90.13f, 158.14f, 91.93f, 157.42f, 93.02f, 156.09f);
                h.cubicTo(120.24f, 128.93f, 147.59f, 101.89f, 174.75f, 74.68f);
                h.cubicTo(177.24f, 72.17f, 174.1f, 69.35f, 172.21f, 67.69f);
                h.cubicTo(170.84f, 65.92f, 168.1f, 65.88f, 166.75f, 67.7f);
                h.lineTo(166.75f, 67.7f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-1);
                float[] a2 = c.a(c, 1.0f, 0.0f, 47.0f, 0.0f, 1.0f, 66.0f);
                d.reset();
                d.setValues(a2);
                canvas.concat(d);
                canvas.save();
                Paint a3 = c.a(g, looper);
                h = c.h(looper);
                h.moveTo(119.75f, 1.7f);
                h.cubicTo(121.1f, -0.12f, 123.84f, -0.08f, 125.21f, 1.69f);
                h.cubicTo(127.1f, 3.35f, 130.24f, 6.17f, 127.75f, 8.68f);
                h.cubicTo(100.59f, 35.89f, 73.24f, 62.93f, 46.02f, 90.09f);
                h.cubicTo(44.93f, 91.42f, 43.13f, 92.14f, 41.47f, 91.46f);
                h.cubicTo(39.88f, 90.46f, 38.66f, 88.99f, 37.32f, 87.7f);
                h.cubicTo(25.47f, 75.86f, 13.56f, 64.06f, 1.7f, 52.23f);
                h.cubicTo(-1.9f, 49.1f, 2.78f, 45.27f, 5.43f, 43.53f);
                h.cubicTo(6.84f, 42.99f, 8.32f, 43.66f, 9.26f, 44.74f);
                h.cubicTo(20.47f, 55.87f, 31.65f, 67.04f, 42.88f, 78.16f);
                h.cubicTo(68.52f, 52.69f, 94.11f, 27.18f, 119.75f, 1.7f);
                h.lineTo(119.75f, 1.7f);
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
