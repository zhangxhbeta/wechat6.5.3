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

public final class aez extends c {
    private final int height = 240;
    private final int width = 273;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 273;
            case 1:
                return 240;
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
                a.setColor(-12810566);
                c = c.a(c, 1.0f, 0.0f, 13.0f, 0.0f, 1.0f, 15.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(81.42f, 3.53f);
                h.cubicTo(95.01f, -1.21f, 111.01f, 0.68f, 122.61f, 9.4f);
                h.cubicTo(131.81f, 16.24f, 137.63f, 26.99f, 139.4f, 38.23f);
                h.cubicTo(142.14f, 55.42f, 137.68f, 73.52f, 127.81f, 87.8f);
                h.cubicTo(125.42f, 91.04f, 123.03f, 94.46f, 119.58f, 96.67f);
                h.cubicTo(115.73f, 98.97f, 114.46f, 104.5f, 116.82f, 108.3f);
                h.cubicTo(117.96f, 110.49f, 120.26f, 111.59f, 122.4f, 112.57f);
                h.cubicTo(113.67f, 127.91f, 111.16f, 146.58f, 115.4f, 163.69f);
                h.cubicTo(117.69f, 173.22f, 122.14f, 182.16f, 128.07f, 189.95f);
                h.cubicTo(86.27f, 189.94f, 44.47f, 189.83f, 2.68f, 189.86f);
                h.cubicTo(0.79f, 182.9f, 0.06f, 175.6f, 0.47f, 168.41f);
                h.cubicTo(1.99f, 158.77f, 9.44f, 151.6f, 16.38f, 145.37f);
                h.cubicTo(31.11f, 132.98f, 48.14f, 123.71f, 65.3f, 115.14f);
                h.cubicTo(68.3f, 113.53f, 71.69f, 112.5f, 74.27f, 110.21f);
                h.cubicTo(77.62f, 107.25f, 77.96f, 101.52f, 74.82f, 98.3f);
                h.cubicTo(65.32f, 90.48f, 59.09f, 79.29f, 55.61f, 67.62f);
                h.cubicTo(51.68f, 53.94f, 51.44f, 38.66f, 57.48f, 25.56f);
                h.cubicTo(62.04f, 15.38f, 70.85f, 7.16f, 81.42f, 3.53f);
                h.lineTo(81.42f, 3.53f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(179.49f, 85.57f);
                h.cubicTo(193.81f, 84.44f, 208.47f, 88.43f, 220.18f, 96.76f);
                h.cubicTo(232.95f, 105.7f, 242.15f, 119.57f, 245.32f, 134.84f);
                h.cubicTo(248.47f, 149.59f, 246.09f, 165.46f, 238.59f, 178.56f);
                h.cubicTo(231.36f, 191.39f, 219.45f, 201.5f, 205.59f, 206.49f);
                h.cubicTo(189.73f, 212.32f, 171.51f, 211.3f, 156.42f, 203.71f);
                h.cubicTo(143.23f, 197.18f, 132.54f, 185.82f, 126.8f, 172.27f);
                h.cubicTo(120.63f, 157.93f, 120.2f, 141.26f, 125.52f, 126.59f);
                h.cubicTo(133.46f, 103.93f, 155.49f, 87.09f, 179.49f, 85.57f);
                h.lineTo(179.49f, 85.57f);
                h.close();
                h.moveTo(179.21f, 110.04f);
                h.cubicTo(179.15f, 124.0f, 179.14f, 137.97f, 179.22f, 151.94f);
                h.cubicTo(179.06f, 154.46f, 181.46f, 156.49f, 183.9f, 156.24f);
                h.cubicTo(195.3f, 156.32f, 206.69f, 156.22f, 218.09f, 156.29f);
                h.cubicTo(220.06f, 156.25f, 222.47f, 156.47f, 223.81f, 154.68f);
                h.cubicTo(225.82f, 151.94f, 224.96f, 146.49f, 220.98f, 146.21f);
                h.cubicTo(210.42f, 146.01f, 199.86f, 146.2f, 189.3f, 146.13f);
                h.cubicTo(189.21f, 133.77f, 189.45f, 121.41f, 189.19f, 109.06f);
                h.cubicTo(188.35f, 103.85f, 178.85f, 104.55f, 179.21f, 110.04f);
                h.lineTo(179.21f, 110.04f);
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
